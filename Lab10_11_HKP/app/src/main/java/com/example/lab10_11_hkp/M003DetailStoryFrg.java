package com.example.lab10_11_hkp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;
import androidx.activity.OnBackPressedCallback;

public class M003DetailStoryFrg extends Fragment {
    private Context mContext;
    private ArrayList<StoryEntity> listStory;
    private String topicName;
    private StoryEntity currentStory;

    // onAttach, onCreateView... (Giữ nguyên)

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.m003_frg_detail_story, container, false);
        initViews(rootView);
        return rootView;
    }

    private void initViews(View v) {
        v.findViewById(R.id.iv_back).setVisibility(View.VISIBLE);
        v.findViewById(R.id.iv_back).setOnClickListener(v1 -> backToM002Screen());

        ((TextView) v.findViewById(R.id.tv_name)).setText(topicName);

        ViewPager vp = v.findViewById(R.id.vp_story);
        DetailStoryAdapter adapter = new DetailStoryAdapter(listStory, mContext);
        vp.setAdapter(adapter);

        vp.setCurrentItem(listStory.indexOf(currentStory), true);
    }
    private void setupOnBackPressed() {
        if (getActivity() != null) {
            getActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) {
                @Override
                public void handleOnBackPressed() {
                    backToM002Screen();
                }
            });
        }
    }

    public void setData(String topicName, ArrayList<StoryEntity> listStory, StoryEntity currentStory) {
        this.currentStory = currentStory;
        this.topicName = topicName;
        this.listStory = listStory;
    }

    private void backToM002Screen() {
        // Quay lại màn hình danh sách truyện (M002)
        if (getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).gotoM002Screen(topicName);
        }
    }
}