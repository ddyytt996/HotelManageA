package Service;

import dao.MenuDao;
import domain.manageUser.Menu;

import java.sql.SQLException;
import java.util.Collection;

public class MenuService {
    private static MenuDao degreeDao
            = MenuDao.getInstance();
    private static MenuService menuService
            =new MenuService();
    private MenuService(){}

    public static MenuService getInstance(){
        return menuService;
    }
    public Collection<Menu> findByUserId(int userId) throws SQLException {
        return MenuDao.getInstance().findByUserId(userId);
    }
}
