package controller;

import Service.AdminUserService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import dao.MenuDao;
import domain.manageUser.AdminUser;
import util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user_json = JSONUtil.getJSON(req);
        AdminUser userFromReq = JSON.parseObject(user_json,AdminUser.class);
        AdminUser user = null;
        Collection menus = null;
        try {
            user = AdminUserService.getInstance().login(userFromReq.getAccount());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(user==null||(!user.getPassword().equals(userFromReq.getPassword()))){
            JSONObject message = new JSONObject();
            message.put("message","账户或密码错误");
            resp.getWriter().println(message);
            return;
        }
        try {
            menus = MenuDao.getInstance().findByUserId(user.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String menus_json = JSON.toJSONString(menus);
        resp.getWriter().println(menus_json);
    }
}
