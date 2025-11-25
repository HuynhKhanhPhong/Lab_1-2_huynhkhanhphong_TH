package com.example.lab10_11_hkp;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

public class M000SplashFrg extends Fragment {

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.m000_frg_splash, container, false);
        initViews();
        return rootView;
    }

    private void initViews() {
        // Sau 2 giây, chuyển thẳng sang màn hình M002StoryFrg
        new Handler().postDelayed(this::gotoM001Screen, 2000);
    }

    private void gotoM001Screen() {
        if (getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).gotoM001Screen();
        }
    }
}