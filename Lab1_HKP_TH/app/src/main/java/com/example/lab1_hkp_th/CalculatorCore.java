package com.example.lab1_hkp_th;

public class CalculatorCore {
    public static double cong(double soHang1, double soHang2) {
        return soHang1 + soHang2;
    }

    public static double tru(double soBiTru, double soTru) {
        return soBiTru - soTru;
    }

    public static double nhan(double thuaSo1, double thuaSo2) {
        return thuaSo1 * thuaSo2;
    }

    public static double chia(double soBiChia, double soChia) {
        if (soChia == 0) {
            // Ném ngoại lệ khi số chia là 0 để Activity có thể bắt và hiển thị lỗi.
            throw new ArithmeticException("Lỗi: Không thể chia cho 0.");
        }
        return soBiChia / soChia;
    }

    public static double phanDu(double soBiChia, double soChia) {
        if (soChia == 0) {
            // Ném ngoại lệ khi số chia là 0.
            throw new ArithmeticException("Lỗi: Không thể chia cho 0 để lấy phần dư.");
        }
        return soBiChia % soChia;
    }
}
