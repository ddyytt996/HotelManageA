package Service;
import dao.AdminUserDao;
import domain.manageUser.AdminUser;

import java.sql.SQLException;

public class AdminUserService {
    private static AdminUserDao degreeDao
            = AdminUserDao.getInstance();
    private static AdminUserService degreeService
            =new AdminUserService();
    private AdminUserService(){}

    public static AdminUserService getInstance(){
        return degreeService;
    }
    public AdminUser login(String account) throws SQLException {
        return AdminUserDao.getInstance().login(account);
    }
}
