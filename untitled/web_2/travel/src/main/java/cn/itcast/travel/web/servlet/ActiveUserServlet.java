package cn.itcast.travel.web.servlet;

import cn.itcast.travel.service.impl.UserServletImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/activeUserServlet")
public class ActiveUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     // 获取激活码
        String code = request.getParameter("code");
        if(code != null){
            // 调用servlet完成激活
            UserServletImpl service = new UserServletImpl();
            boolean flag=service.active(code);
            // 判断标记
            String msg=null;
            if(flag){
                // 激活码正确
                msg="激活成功，请<a href='login.html'>登录</a>";
            }else{
                // 激活码不正确
               msg="激活失败，请联系管理员！";
            }
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(msg);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
