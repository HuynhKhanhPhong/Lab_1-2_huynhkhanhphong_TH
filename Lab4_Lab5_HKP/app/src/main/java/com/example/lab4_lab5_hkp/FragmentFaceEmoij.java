package com.example.lab4_lab5_hkp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import java.util.Random;

public class FragmentFaceEmoij extends Fragment implements View.OnClickListener {

    // ... (Giữ nguyên các mảng ids, mContext, mRootView đã khai báo trước)
    private static final int[] ids = {R.id.iv_face1, R.id.iv_face2, R.id.iv_face3, R.id.iv_face4,
            R.id.iv_face5, R.id.iv_face6, R.id.iv_face7, R.id.iv_face8, R.id.iv_face9};
    private static final int ID_RANDOM_BUTTON = R.id.btn_random;
    private Context mContext;
    private View mRootView;
    private Random random = new Random();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.m001_frg_face_emoij, container, false);
        initViews(mRootView);
        return mRootView;
    }

    @Override
    public void onAttach(Context context) {
        mContext = context;
        super.onAttach(context);
    }

    private void initViews(View v) {

        for (int id : ids) {
            v.findViewById(id).setOnClickListener(this);
        }


        View randomButton = v.findViewById(ID_RANDOM_BUTTON);
        if (randomButton != null) {
            randomButton.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == ID_RANDOM_BUTTON) {

            showRandomEmoji();
        } else {

            ImageView ivFace = (ImageView) v;
            showToast(ivFace.getDrawable());
        }
    }

    // Logic Bài tập 3: Hiển thị icon ngẫu nhiên
    private void showRandomEmoji() {
        if (mRootView == null || mContext == null) return;

        int randomIndex = random.nextInt(ids.length);

        ImageView randomImageView = mRootView.findViewById(ids[randomIndex]);

        if (randomImageView != null) {
            showToast(randomImageView.getDrawable());
        }
    }

    private void showToast(Drawable drawable) {
        // ... (Giữ nguyên logic Custom Toast với ImageView)
        Toast toast = new Toast(mContext);
        ImageView ivEmoij = new ImageView(mContext);
        ivEmoij.setImageDrawable(drawable);
        toast.setView(ivEmoij);
        toast.show();
    }
}