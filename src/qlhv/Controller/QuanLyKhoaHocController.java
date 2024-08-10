
package qlhv.Controller;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
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
import qlhv.Model.KhoaHoc;
import qlhv.Service.KhoaHocService;

public class QuanLyKhoaHocController {
    
    private JTable jTableKhoaHoc;
    private JTextField jtfMaKhoaHoc;
    private JTextField jtfTenKhoaHoc;
    private JDateChooser jdcNgayBatDau;
    private JDateChooser jdcNgayKetThuc;
    private JTextField jtfMoTa;
    private JCheckBox jcbTinhTrang;
    private JButton btnThem;
    private JButton btnXoa;
    private JButton btnNhapMoi;
    private JButton btnTimKiem;
    
    
    private KhoaHoc khoaHoc = null;
    private TableRowSorter<TableModel> rowSorter = null;

    public QuanLyKhoaHocController(JTable jTableKhoaHoc, JTextField jtfMaKhoaHoc, JTextField jtfTenKhoaHoc,
            JDateChooser jdcNgayBatDau, JDateChooser jdcNgayKetThuc, JTextField jtfMoTa, JCheckBox jcbTinhTrang,
            JButton btnThem, JButton btnXoa, JButton btnNhapMoi, JButton btnTimKiem) {
        this.jTableKhoaHoc = jTableKhoaHoc;
        this.jtfMaKhoaHoc = jtfMaKhoaHoc;
        this.jtfTenKhoaHoc = jtfTenKhoaHoc;
        this.jdcNgayBatDau = jdcNgayBatDau;
        this.jdcNgayKetThuc = jdcNgayKetThuc;
        this.jtfMoTa = jtfMoTa;
        this.jcbTinhTrang = jcbTinhTrang;
        this.btnThem = btnThem;
        this.btnXoa = btnXoa;
        this.btnNhapMoi = btnNhapMoi;
        this.btnTimKiem = btnTimKiem;
    }

    DefaultTableModel model;
    List<KhoaHoc> list = new ArrayList<>();
    public void showDataKhoaHoc(){
        model = (DefaultTableModel) jTableKhoaHoc.getModel();
        list = KhoaHocService.findall();
        model.setRowCount(0);
        
        list.forEach((khoaHoc) ->{
        
            model.addRow(new Object[] {model.getRowCount() + 1, khoaHoc.getMa_khoa_hoc(),
            khoaHoc.getTen_khoa_hoc(), khoaHoc.getNgay_bat_dau(), khoaHoc.getNgay_ket_thuc(),
            khoaHoc.isTinh_trang(), khoaHoc.getMo_ta()});
        });
            
    }
    
    public void setEvent(){

        btnNhapMoi.addMouseListener(new MouseAdapter(){
                
            @Override
            public void mouseClicked(MouseEvent e) {
                jtfMaKhoaHoc.setText("");
                jtfTenKhoaHoc.setText("");
                jtfMoTa.setText("");
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
                int ma_khoa_hoc = Integer.parseInt(jtfMaKhoaHoc.getText());
                String ten_khoa_hoc = jtfTenKhoaHoc.getText();
                Date ngay_bat_dau = jdcNgayBatDau.getDate();
                Date ngay_ket_thuc = jdcNgayKetThuc.getDate();
                boolean tinh_trang = jcbTinhTrang.isSelected();
                String mo_ta = jtfMoTa.getText();
                
                if(showDialog()){
                KhoaHoc khoaHoc = new KhoaHoc(ma_khoa_hoc, ten_khoa_hoc, mo_ta, ngay_bat_dau, ngay_ket_thuc, tinh_trang);
                KhoaHocService.InsertKhoaHoc(khoaHoc);
                
                showDataKhoaHoc();
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
                int selectedIndex = jTableKhoaHoc.getSelectedRow();
                if(selectedIndex >= 0){
                    KhoaHoc khoaHoc = list.get(selectedIndex);
                    
                    int option = JOptionPane.showConfirmDialog(jtfTenKhoaHoc, "Bạn có chắc chắn muốn xóa không ??");
                    System.out.println("option : " + option);
                    
                    if(option == 0){
                        KhoaHocService.DeleteKhoaHoc(khoaHoc.getMa_khoa_hoc());
                        showDataKhoaHoc();
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
                String input = JOptionPane.showInputDialog("Nhập mã khóa học cần tìm:");
                if(input.length() > 0){
                    list = KhoaHocService.findByMaKhoaHoc(input);
                    
                    model.setRowCount(0);
        
                list.forEach((khoaHoc) ->{
        
                model.addRow(new Object[] {model.getRowCount() + 1, khoaHoc.getMa_khoa_hoc(),
                khoaHoc.getTen_khoa_hoc(), khoaHoc.getNgay_bat_dau(), khoaHoc.getNgay_ket_thuc(),
                khoaHoc.isTinh_trang(), khoaHoc.getMo_ta()});
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
