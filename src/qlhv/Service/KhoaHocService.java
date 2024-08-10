
package qlhv.Service;

import java.util.List;
import qlhv.Model.KhoaHoc;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class KhoaHocService {
    
    public static List<KhoaHoc> findall(){
        List<KhoaHoc> list = new ArrayList<>();
    
        Connection connection = null;
        Statement statement = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlhocvien","root","");
        
            String sql = "SELECT * FROM khoa_hoc";
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()){
                KhoaHoc khoaHoc = new KhoaHoc();
                khoaHoc.setMa_khoa_hoc(resultSet.getInt("ma_khoa_hoc"));
                khoaHoc.setTen_khoa_hoc(resultSet.getString("ten_khoa_hoc"));
                khoaHoc.setNgay_bat_dau(resultSet.getDate("ngay_bat_dau"));
                khoaHoc.setNgay_ket_thuc(resultSet.getDate("ngay_ket_thuc"));
                khoaHoc.setTinh_trang(resultSet.getBoolean("tinh_trang"));
                khoaHoc.setMo_ta(resultSet.getString("mo_ta"));
                list.add(khoaHoc);
            }
        }catch (SQLException ex){
            Logger.getLogger(KhoaHocService.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement != null){
                try{
                    statement.close();
                }catch (SQLException ex){
                    Logger.getLogger(KhoaHocService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if(connection != null){
                try{
                    connection.close();
                }catch (SQLException ex){
                    Logger.getLogger(KhoaHocService.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
        }
            return list;
        }
    
    public static void InsertKhoaHoc(KhoaHoc khoaHoc){
            Connection connection = null;
            PreparedStatement statement = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlhocvien","root","");
        
            String sql = "INSERT INTO khoa_hoc(ma_khoa_hoc, ten_khoa_hoc, ngay_bat_dau, ngay_ket_thuc, tinh_trang, mo_ta) VALUES (?,?,?,?,?,?)";
            statement = connection.prepareCall(sql);
            
            statement.setInt(1, khoaHoc.getMa_khoa_hoc());
            statement.setString(2, khoaHoc.getTen_khoa_hoc());
            statement.setDate(3, new Date (khoaHoc.getNgay_bat_dau().getTime()));
            statement.setDate(4, new Date (khoaHoc.getNgay_ket_thuc().getTime()));
            statement.setBoolean(5, khoaHoc.isTinh_trang());
            statement.setString(6, khoaHoc.getMo_ta());
            
            statement.execute();
        }catch (SQLException ex){
            Logger.getLogger(KhoaHocService.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement != null){
                try{
                    statement.close();
                }catch (SQLException ex){
                    Logger.getLogger(KhoaHocService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if(connection != null){
                try{
                    connection.close();
                }catch (SQLException ex){
                    Logger.getLogger(KhoaHocService.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
        }
        }
        
    public static void UpdateKhoaHoc(KhoaHoc khoaHoc){
            Connection connection = null;
            PreparedStatement statement = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlhocvien","root","");
        
            String sql = "UPDATE khoa_hoc SET ten_khoa_hoc=?, ngay_bat_dau=?, ngay_ket_thuc=?, tinh_trang=?, mo_ta=? WHERE ma_khoa_hoc=?";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, khoaHoc.getTen_khoa_hoc());
            statement.setDate(2, new Date (khoaHoc.getNgay_bat_dau().getTime()));
            statement.setDate(3, new Date (khoaHoc.getNgay_ket_thuc().getTime()));
            statement.setBoolean(4, khoaHoc.isTinh_trang());
            statement.setString(5, khoaHoc.getMo_ta());
            statement.setInt(6, khoaHoc.getMa_khoa_hoc());
            
            statement.execute();
        }catch (SQLException ex){
            Logger.getLogger(KhoaHocService.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement != null){
                try{
                    statement.close();
                }catch (SQLException ex){
                    Logger.getLogger(KhoaHocService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if(connection != null){
                try{
                    connection.close();
                }catch (SQLException ex){
                    Logger.getLogger(KhoaHocService.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
        }
        }
        
    public static void DeleteKhoaHoc(int ma_khoa_hoc){
            Connection connection = null;
            PreparedStatement statement = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlhocvien","root","");
        
            String sql = "DELETE FROM khoa_hoc WHERE ma_khoa_hoc=?";
            statement = connection.prepareCall(sql);
            
            statement.setInt(1, ma_khoa_hoc);
            
            statement.execute();
        }catch (SQLException ex){
            Logger.getLogger(KhoaHocService.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement != null){
                try{
                    statement.close();
                }catch (SQLException ex){
                    Logger.getLogger(KhoaHocService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if(connection != null){
                try{
                    connection.close();
                }catch (SQLException ex){
                    Logger.getLogger(KhoaHocService.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
        }
        }
    
    public static List<KhoaHoc> findByMaKhoaHoc(String mkh){
        List<KhoaHoc> list = new ArrayList<>();
    
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlhocvien","root","");
        
            String sql = "SELECT * FROM khoa_hoc WHERE ma_khoa_hoc LIKE ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%"+mkh+"%");
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()){
                KhoaHoc khoaHoc = new KhoaHoc();
                khoaHoc.setMa_khoa_hoc(resultSet.getInt("ma_khoa_hoc"));
                khoaHoc.setTen_khoa_hoc(resultSet.getString("ten_khoa_hoc"));
                khoaHoc.setNgay_bat_dau(resultSet.getDate("ngay_bat_dau"));
                khoaHoc.setNgay_ket_thuc(resultSet.getDate("ngay_ket_thuc"));
                khoaHoc.setTinh_trang(resultSet.getBoolean("tinh_trang"));
                khoaHoc.setMo_ta(resultSet.getString("mo_ta"));
                list.add(khoaHoc);
            }
        }catch (SQLException ex){
            Logger.getLogger(KhoaHocService.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement != null){
                try{
                    statement.close();
                }catch (SQLException ex){
                    Logger.getLogger(KhoaHocService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if(connection != null){
                try{
                    connection.close();
                }catch (SQLException ex){
                    Logger.getLogger(KhoaHocService.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
        }
            return list;
        }
}

