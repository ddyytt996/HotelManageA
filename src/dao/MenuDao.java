package dao;

import domain.manageUser.Menu;
import util.JdbcHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;

public class MenuDao {
    private static MenuDao degreeDao=
            new MenuDao();
    private MenuDao(){}
    public static MenuDao getInstance(){
        return degreeDao;
    }
    private static Collection<Menu> degrees;

    public Collection<Menu> findByUserId(int userId) throws SQLException {
        Connection connection = JdbcHelper.getConn();
        PreparedStatement preparedStatement = connection.prepareStatement("Select menu.id,menu.description,menu.route\n" +
                "from menu,adminuser,role,ur,rm\n" +
                "where adminuser.id = ur.user_id and ur.role_id = role.id and rm.role_id = role.id and rm.menu_id = menu.id\n" +
                "and adminuser.id =?  ");
        preparedStatement.setInt(1,userId);
        ResultSet resultSet = preparedStatement.executeQuery();
        Collection menus = new HashSet<Menu>();
        while (resultSet.next()){
            Menu menu = new Menu(resultSet.getInt("id"),resultSet.getString("description")
                    ,resultSet.getString("route"));
            menus.add(menu);
        }
        JdbcHelper.close(resultSet,preparedStatement,connection);
        return menus;
    }
}
