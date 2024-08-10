
package qlhv.Service;

import qlhv.DAO.TaiKhoanDAO;
import qlhv.DAO.TaiKhoanDAOImpl;
import qlhv.Model.TaiKhoan;


public class TaiKhoanServiceImpl implements TaiKhoanService{
    
    private TaiKhoanDAO taiKhoanDAO = null;

    public TaiKhoanServiceImpl() {
        taiKhoanDAO = new TaiKhoanDAOImpl();
    }

    @Override
    public TaiKhoan login(String tenDangNhap, String matKhau) {
        return taiKhoanDAO.login(tenDangNhap, matKhau);
    }
}
