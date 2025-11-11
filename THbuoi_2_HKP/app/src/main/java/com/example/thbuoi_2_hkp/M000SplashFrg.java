package com.example.thbuoi_2_hkp;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class M000SplashFrg extends Fragment {

    // Sử dụng Handler/Runnable để tránh rò rỉ bộ nhớ tốt hơn
    private final Handler handler = new Handler(Looper.getMainLooper());
    private final Runnable gotoNextScreen = this::gotoM001Screen;
    private static final int SPLASH_DELAY = 2000; // 2 giây

    // Yêu cầu: m000_frg_splash.xml (Layout FrameLayout với bg greenMid và ImageView)

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.m000_frg_splash, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Bắt đầu đếm ngược sau khi View đã được tạo
        handler.postDelayed(gotoNextScreen, SPLASH_DELAY);
    }

    @Override
    public void onDestroyView() {
        // Đảm bảo hủy bỏ tác vụ đang chờ xử lý khi Fragment bị hủy
        handler.removeCallbacks(gotoNextScreen);
        super.onDestroyView();
    }

    private void gotoM001Screen() {
        // Kiểm tra Activity có tồn tại không trước khi ép kiểu
        if (getActivity() instanceof TruyenCuoiActivity) {
            ((TruyenCuoiActivity) getActivity()).gotoM001Screen();
        }
    }
}