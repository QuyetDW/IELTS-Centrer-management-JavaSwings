
package qlhv.Service;

import java.util.List;
import qlhv.DAO.HocVienDAO;
import qlhv.DAO.HocVienDAOImpl;
import qlhv.Model.HocVien;


public class HocVienServiceImpl implements HocVienService{

    private HocVienDAO hocVienDAO = null;
    
    public HocVienServiceImpl(){
        hocVienDAO = new HocVienDAOImpl();
    }
    
    @Override
    public List<HocVien> getList() {
        return hocVienDAO.getList();
    }
    
    @Override
    public int createOrUpdate(HocVien hocVien) {
        return hocVienDAO.createOrUpdate(hocVien);
    }

}
