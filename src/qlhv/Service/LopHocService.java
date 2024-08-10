
package qlhv.Service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import qlhv.Model.LopHoc;


public class LopHocService {
    
    public static List<LopHoc> findall(){
        List<LopHoc> list = new ArrayList<>();
    
        Connection connection = null;
        Statement statement = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlhocvien","root","");
        
            String sql = "SELECT * FROM lop_hoc";
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()){
                LopHoc lopHoc = new LopHoc();
                lopHoc.setMa_lop_hoc(resultSet.getInt("ma_lop_hoc"));
                lopHoc.setMa_khoa_hoc(resultSet.getInt("ma_khoa_hoc"));
                lopHoc.setMa_hoc_vien(resultSet.getInt("ma_hoc_vien"));
                lopHoc.setNgay_dang_ky(resultSet.getDate("ngay_dang_ky"));
                lopHoc.setTinh_trang(resultSet.getBoolean("tinh_trang"));
                list.add(lopHoc);
            }
        }catch (SQLException ex){
            Logger.getLogger(LopHocService.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement != null){
                try{
                    statement.close();
                }catch (SQLException ex){
                    Logger.getLogger(LopHocService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if(connection != null){
                try{
                    connection.close();
                }catch (SQLException ex){
                    Logger.getLogger(LopHocService.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
        }
            return list;
        }
    
    public static void InsertLopHoc(LopHoc lopHoc){
            Connection connection = null;
            PreparedStatement statement = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlhocvien","root","");
        
            String sql = "INSERT INTO lop_hoc(ma_lop_hoc, ma_khoa_hoc, ma_hoc_vien, ngay_dang_ky, tinh_trang) VALUES (?,?,?,?,?)";
            statement = connection.prepareCall(sql);
            
            statement.setInt(1, lopHoc.getMa_lop_hoc());
            statement.setInt(2, lopHoc.getMa_khoa_hoc());
            statement.setInt(3,lopHoc.getMa_hoc_vien());
            statement.setDate(4, new Date (lopHoc.getNgay_dang_ky().getTime()));
            statement.setBoolean(5, lopHoc.isTinh_trang());
            
            statement.execute();
        }catch (SQLException ex){
            Logger.getLogger(LopHocService.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement != null){
                try{
                    statement.close();
                }catch (SQLException ex){
                    Logger.getLogger(LopHocService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if(connection != null){
                try{
                    connection.close();
                }catch (SQLException ex){
                    Logger.getLogger(LopHocService.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
        }
        }
        
    public static void UpdateLopHoc(LopHoc lopHoc){
            Connection connection = null;
            PreparedStatement statement = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlhocvien","root","");
        
            String sql = "UPDATE lop_hoc SET ma_khoa_hoc=?, ma_hoc_vien=?, ngay_dang_ky=?, tinh_trang=? WHERE ma_lop_hoc=?";
            statement = connection.prepareCall(sql);
            
            statement.setInt(1, lopHoc.getMa_khoa_hoc());
            statement.setInt(2, lopHoc.getMa_hoc_vien());
            statement.setDate(3, new Date (lopHoc.getNgay_dang_ky().getTime()));
            statement.setBoolean(4, lopHoc.isTinh_trang());
            statement.setInt(5, lopHoc.getMa_lop_hoc());
            
            statement.execute();
        }catch (SQLException ex){
            Logger.getLogger(LopHocService.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement != null){
                try{
                    statement.close();
                }catch (SQLException ex){
                    Logger.getLogger(LopHocService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if(connection != null){
                try{
                    connection.close();
                }catch (SQLException ex){
                    Logger.getLogger(LopHocService.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
        }
        }
        
    public static void DeleteLopHoc(int ma_lop_hoc){
            Connection connection = null;
            PreparedStatement statement = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlhocvien","root","");
        
            String sql = "DELETE FROM lop_hoc WHERE ma_lop_hoc=?";
            statement = connection.prepareCall(sql);
            
            statement.setInt(1, ma_lop_hoc);
            
            statement.execute();
        }catch (SQLException ex){
            Logger.getLogger(LopHocService.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement != null){
                try{
                    statement.close();
                }catch (SQLException ex){
                    Logger.getLogger(LopHocService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if(connection != null){
                try{
                    connection.close();
                }catch (SQLException ex){
                    Logger.getLogger(LopHocService.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
        }
        }
    
    public static List<LopHoc> findByMaLopHoc(String mlh){
        List<LopHoc> list = new ArrayList<>();
    
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlhocvien","root","");
        
            String sql = "SELECT * FROM lop_hoc WHERE ma_lop_hoc LIKE ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%"+mlh+"%");
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()){
                LopHoc lopHoc = new LopHoc();
                lopHoc.setMa_lop_hoc(resultSet.getInt("ma_lop_hoc"));
                lopHoc.setMa_khoa_hoc(resultSet.getInt("ma_khoa_hoc"));
                lopHoc.setMa_hoc_vien(resultSet.getInt("ma_hoc_vien"));
                lopHoc.setNgay_dang_ky(resultSet.getDate("ngay_dang_ky"));
                lopHoc.setTinh_trang(resultSet.getBoolean("tinh_trang"));
                list.add(lopHoc);
            }
        }catch (SQLException ex){
            Logger.getLogger(LopHocService.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement != null){
                try{
                    statement.close();
                }catch (SQLException ex){
                    Logger.getLogger(LopHocService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if(connection != null){
                try{
                    connection.close();
                }catch (SQLException ex){
                    Logger.getLogger(LopHocService.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
        }
            return list;
        }
}
