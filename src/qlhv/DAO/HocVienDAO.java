
package qlhv.DAO;

import qlhv.Model.HocVien;
import java.util.List;


public interface HocVienDAO{
    public List<HocVien> getList();
    
    public int createOrUpdate(HocVien hocVien);
}
