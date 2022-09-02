package servlet;

import mapper.UserMapper;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/**
 * @author 陈境聪
 * @date 2022年09月02日 10:23
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        System.out.println(username+":" + password);

        UserMapper userMapper = new UserMapper();
        User user = userMapper.getUserToLogin(username, password);
        if (user != null) {
            req.getSession().setAttribute("user",user);
            resp.sendRedirect("/java_web/jsp/index.jsp");
        } else {
            req.setAttribute("msg", "用户名或密码错误");
            req.getRequestDispatcher("Login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
