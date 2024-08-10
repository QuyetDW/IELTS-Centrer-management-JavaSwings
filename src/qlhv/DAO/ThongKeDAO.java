
package qlhv.DAO;

import qlhv.Bean.LopHocBean;
import java.util.List;
import qlhv.Bean.KhoaHocBean;

public interface ThongKeDAO {
    
    public List<LopHocBean> getListByLopHoc();
    
    public List<KhoaHocBean> getListByKhoaHoc();
}
