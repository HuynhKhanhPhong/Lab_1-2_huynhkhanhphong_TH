package com.example.lab10_11_hkp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class M002StoryFrg extends Fragment {
    private Context mContext;
    private String topicName;

    // onAttach, onCreateView, setTopicName... (Giữ nguyên)

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.m002_frg_story, container, false);
        initViews(rootView);
        return rootView;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    private void initViews(View v) {
        // ẨN nút Back vì không có màn hình M001
        v.findViewById(R.id.iv_back).setVisibility(View.GONE);

        ((TextView) v.findViewById(R.id.tv_name)).setText(topicName);

        RecyclerView rv = v.findViewById(R.id.rv_story);

        ArrayList<StoryEntity> listStory = readStory();

        StoryAdapter adapter = new StoryAdapter(listStory, mContext);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(mContext));
    }

    private ArrayList<StoryEntity> readStory() {
        ArrayList<StoryEntity> listStory = new ArrayList<>();
        BufferedReader reader = null;
        try {
            // Đọc file data cố định (10 câu chuyện tự nghĩ)
            String dataFileName = "TruyenCuoiKhongMacCuoi.txt";

            reader = new BufferedReader(
                    new InputStreamReader(mContext.getAssets().open("story/" + dataFileName), "UTF-8"));

            String mLine;
            String content;

            do {
                String title = reader.readLine();
                if (title == null) break;

                content = "";

                do {
                    mLine = reader.readLine();
                    if (mLine == null) break;
                    content += mLine + "\n";
                } while (!mLine.contains("', '0');"));

                content = content.replace("', '0');", "");

                StoryEntity storyEntity = new StoryEntity(topicName, title, content);
                listStory.add(storyEntity);

            } while (mLine != null);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Đóng reader (được đề cập trong file Lab)
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return listStory;
    }
}