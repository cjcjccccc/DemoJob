package filter;

import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;
import model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 陈境聪
 * @date 2022年09月02日 11:19
 */

@WebFilter("/vip/*")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        User user =(User)req.getSession().getAttribute("user");
//        未登录
        if (user == null) {
            resp.getWriter().println("尚未登录，请登录");
            resp.setHeader("refresh","3;url=/java_web/Login.jsp");
            return;
        }else {
            filterChain.doFilter(request,response);
        }
    }
}
