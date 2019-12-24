package dao;

import domain.manageUser.AdminUser;
import util.JdbcHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;

public class AdminUserDao {
    private static AdminUserDao degreeDao=
            new AdminUserDao();
    private AdminUserDao(){}
    public static AdminUserDao getInstance(){
        return degreeDao;
    }

    public AdminUser login(String account) throws SQLException {
        AdminUser user = null;
        Connection connection = JdbcHelper.getConn();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from adminuser where " +
                "account = ?");
        preparedStatement.setString(1,account);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            user = new AdminUser(resultSet.getInt("id"),resultSet.getInt("status"),
                    resultSet.getString("account"),resultSet.getString("name"),resultSet
            .getString("password"));
        }
        JdbcHelper.close(resultSet,preparedStatement,connection);
        return user;
    }
}
