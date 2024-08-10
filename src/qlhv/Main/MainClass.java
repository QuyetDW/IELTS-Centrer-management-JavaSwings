
package qlhv.Main;

//import qlhv.View.MainJFrame;
import qlhv.View.DangNhapJDialog;


public class MainClass {

    public static void main(String args[]) {
        //new MainJFrame().setVisible(true);
        DangNhapJDialog dangnhap = new DangNhapJDialog(null, true);
        dangnhap.setTitle("Đăng nhập hệ thống");
        dangnhap.setResizable(false);
        dangnhap.setLocationRelativeTo(null);
        dangnhap.setVisible(true);
    }
}
