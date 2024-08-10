
package qlhv.Controller;

import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import qlhv.Model.LopHoc;
import qlhv.Service.LopHocService;


public class QuanLyLopHocController {
    
    private JTable jTableLopHoc;
    private JTextField jtfMaLopHoc;
    private JTextField jtfMaKhoaHoc;
    private JTextField jtfMaHocVien;
    private JDateChooser jdcNgayDangKy;
    private JCheckBox jcbTinhTrang;
    private JButton btnTimKiem;
    private JButton btnThem;
    private JButton btnXoa;
    private JButton btnNhapMoi;
    
    private LopHoc lopHoc = null;
    private TableRowSorter<TableModel> rowSorter = null;

    public QuanLyLopHocController(JTable jTableLopHoc, JTextField jtfMaLopHoc, JTextField jtfMaKhoaHoc, JTextField jtfMaHocVien, JDateChooser jdcNgayDangKy, JCheckBox jcbTinhTrang, JButton btnTimKiem, JButton btnThem, JButton btnXoa, JButton btnNhapMoi) {
        this.jTableLopHoc = jTableLopHoc;
        this.jtfMaLopHoc = jtfMaLopHoc;
        this.jtfMaKhoaHoc = jtfMaKhoaHoc;
        this.jtfMaHocVien = jtfMaHocVien;
        this.jdcNgayDangKy = jdcNgayDangKy;
        this.jcbTinhTrang = jcbTinhTrang;
        this.btnTimKiem = btnTimKiem;
        this.btnThem = btnThem;
        this.btnXoa = btnXoa;
        this.btnNhapMoi = btnNhapMoi;
    }


    DefaultTableModel model;
    List<LopHoc> list = new ArrayList<>();
    public void showDataLopHoc(){
        model = (DefaultTableModel) jTableLopHoc.getModel();
        list = LopHocService.findall();
        model.setRowCount(0);
        
        list.forEach((lopHoc) ->{
        
            model.addRow(new Object[] {model.getRowCount() + 1, lopHoc.getMa_lop_hoc(),
            lopHoc.getMa_khoa_hoc(), lopHoc.getMa_hoc_vien(), lopHoc.getNgay_dang_ky(),
            lopHoc.isTinh_trang()});
        });
            
    }
    
    public void setEvent(){

        btnNhapMoi.addMouseListener(new MouseAdapter(){
                
            @Override
            public void mouseClicked(MouseEvent e) {
                jtfMaLopHoc.setText("");
                jtfMaKhoaHoc.setText("");
                jtfMaHocVien.setText("");
                jcbTinhTrang.setSelected(false);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
            }
        });
    
        btnThem.addMouseListener(new MouseAdapter(){
                
            @Override
            public void mouseClicked(MouseEvent e) {
                int ma_lop_hoc = Integer.parseInt(jtfMaLopHoc.getText());
                int ma_khoa_hoc = Integer.parseInt(jtfMaKhoaHoc.getText());
                int ma_hoc_vien = Integer.parseInt(jtfMaHocVien.getText());
                Date ngay_dang_ky = jdcNgayDangKy.getDate();
                boolean tinh_trang = jcbTinhTrang.isSelected();
                
                if(showDialog()){
                LopHoc lopHoc = new LopHoc(ma_lop_hoc, ma_khoa_hoc, ma_hoc_vien, ngay_dang_ky, tinh_trang);
                LopHocService.InsertLopHoc(lopHoc);
                
                showDataLopHoc();
                }
            
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
            }
        });
        
        btnXoa.addMouseListener(new MouseAdapter(){
                
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedIndex = jTableLopHoc.getSelectedRow();
                if(selectedIndex >= 0){
                    LopHoc lopHoc = list.get(selectedIndex);
                    
                    int option = JOptionPane.showConfirmDialog(jtfMaLopHoc, "Bạn có chắc chắn muốn xóa không ??");
                    System.out.println("option : " + option);
                    
                    if(option == 0){
                        LopHocService.DeleteLopHoc(lopHoc.getMa_lop_hoc());
                        showDataLopHoc();
                    }
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
            }
        });
        
        btnTimKiem.addMouseListener(new MouseAdapter(){
                
            @Override
            public void mouseClicked(MouseEvent e) {
                String input = JOptionPane.showInputDialog("Nhập mã lớp học cần tìm:");
                if(input.length() > 0){
                    list = LopHocService.findByMaLopHoc(input);
                    
                    model.setRowCount(0);
        
                model.setRowCount(0);
        
            list.forEach((lopHoc) ->{
        
            model.addRow(new Object[] {model.getRowCount() + 1, lopHoc.getMa_lop_hoc(),
            lopHoc.getMa_khoa_hoc(), lopHoc.getMa_hoc_vien(), lopHoc.getNgay_dang_ky(),
            lopHoc.isTinh_trang()});
        });
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
            }
        });
    }
    
    private boolean showDialog() {
        int dialogResult = JOptionPane.showConfirmDialog(null,
                "Bạn muốn thêm dữ liệu hay không?", "Thông báo", JOptionPane.YES_NO_OPTION);
        return dialogResult == JOptionPane.YES_OPTION;
    }
}
