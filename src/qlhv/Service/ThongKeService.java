
package qlhv.Service;

import java.util.List;
import qlhv.Bean.KhoaHocBean;
import qlhv.Bean.LopHocBean;


public interface ThongKeService {
    public List<LopHocBean> getListByLopHoc();
    
    public List<KhoaHocBean> getListByKhoaHoc();
}
