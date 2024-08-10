
package qlhv.Service;

//import qlhv.Bean.KhoaHocBean;
import qlhv.Bean.LopHocBean;
import qlhv.DAO.ThongKeDAO;
import qlhv.DAO.ThongKeDAOImpl;
import java.util.List;
import qlhv.Bean.KhoaHocBean;


public class ThongKeServiceImpl implements ThongKeService{

    private ThongKeDAO thongKeDAO = null;

    public ThongKeServiceImpl(){
        thongKeDAO = new ThongKeDAOImpl();
    }

    @Override
    public List<LopHocBean> getListByLopHoc() {
        return thongKeDAO.getListByLopHoc();
    }

    @Override
    public List<KhoaHocBean> getListByKhoaHoc() {
        return thongKeDAO.getListByKhoaHoc();
    }
}
