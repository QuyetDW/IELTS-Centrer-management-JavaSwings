
package qlhv.Controller;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import qlhv.Model.HocVien;
import qlhv.Service.HocVienService;
import qlhv.Service.HocVienServiceImpl;


public class HocVienController {
    
    private JButton btnSubmit;
    private JTextField jtfMaHocVien;
    private JTextField jtfHoTen;
    private JDateChooser jdcNgaySinh;
    private JTextField jtfSDT;
    private JRadioButton jrdNam;
    private JRadioButton jrdNu;
    private JTextArea jtaDiaChi;
    private JCheckBox jcbTinhTrang;
    private JLabel jlbMsg;

    private HocVien hocVien = null;

    private HocVienService hocVienService = null;
    
    public HocVienController(JButton btnSubmit, JTextField jtfMaHocVien, JTextField jtfHoTen,
            JDateChooser jdcNgaySinh, JTextField jtfSDT, JRadioButton jrdNam, JRadioButton jrdNu,
            JTextArea jtaDiaChi, JCheckBox jcbTinhTrang, JLabel jlbMsg) {
        this.btnSubmit = btnSubmit;
        this.jtfMaHocVien = jtfMaHocVien;
        this.jtfHoTen = jtfHoTen;
        this.jdcNgaySinh = jdcNgaySinh;
        this.jtfSDT = jtfSDT;
        this.jrdNam = jrdNam;
        this.jrdNu = jrdNu;
        this.jtaDiaChi = jtaDiaChi;
        this.jcbTinhTrang = jcbTinhTrang;
        this.jlbMsg = jlbMsg;

        this.hocVienService = new HocVienServiceImpl();
    }

    public void setView(HocVien hocVien) {
        this.hocVien = hocVien;
        // set data
        jtfMaHocVien.setText("#" + hocVien.getMa_hoc_vien());
        jtfHoTen.setText(hocVien.getHo_ten());
        jdcNgaySinh.setDate(hocVien.getNgay_sinh());
        if (hocVien.isGioi_tinh()) {
            jrdNam.setSelected(true);
        } else {
            jrdNu.setSelected(true);
        }
        jtfSDT.setText(hocVien.getSo_dien_thoai());
        jtaDiaChi.setText(hocVien.getDia_chi());
        jcbTinhTrang.setSelected(hocVien.isTinh_trang());
        
    }

    public void setEvent() {
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try{
                    if (!checkNotNull()) {
                        jlbMsg.setText("Vui lòng nhập dữ liệu bắt buộc!");
                    } else {
                        hocVien.setHo_ten(jtfHoTen.getText());
                        hocVien.setNgay_sinh(jdcNgaySinh.getDate());
                        hocVien.setSo_dien_thoai(jtfSDT.getText());
                        hocVien.setDia_chi(jtaDiaChi.getText());
                        hocVien.setGioi_tinh(jrdNam.isSelected());
                        hocVien.setTinh_trang(jcbTinhTrang.isSelected());
                        int lastId = hocVienService.createOrUpdate(hocVien);
                        if (showDialog()) {
                            if (lastId > 0) {
                                hocVien.setMa_hoc_vien(lastId);
                                jtfMaHocVien.setText("#" + lastId);
                                jlbMsg.setText("Xử lý cập nhật dữ liệu thành công!");
                            } else {
                                jlbMsg.setText("Có lỗi xảy ra, vui lòng thử lại!");
                            }
                        }
                    }
                    } catch (Exception ex) {
                    jlbMsg.setText(ex.toString());
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnSubmit.setBackground(new Color(0, 200, 83));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnSubmit.setBackground(new Color(100, 221, 23));
            }
        });
    }

    private boolean checkNotNull() {
        return jtfHoTen.getText() != null && !jtfHoTen.getText().equalsIgnoreCase("");
    }

    private boolean showDialog() {
        int dialogResult = JOptionPane.showConfirmDialog(null,
                "Bạn muốn cập nhật dữ liệu hay không?", "Thông báo", JOptionPane.YES_NO_OPTION);
        return dialogResult == JOptionPane.YES_OPTION;
    }
    
}
