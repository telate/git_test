package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.impl.UserServletImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
    //声明userServlet对象功能
   private UserServletImpl servlet = new UserServletImpl();

     //  注册功能
    public void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 验证码校验
        String check = request.getParameter("check");
        // 从session中获取验证码值
        HttpSession session = request.getSession();
        String checkcode_server = (String)session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER"); // 为了保证验证码只是用一次
        // 判断验证码  不能相同
        if( checkcode_server==null || !checkcode_server.equalsIgnoreCase(check)){
            // 验证码错误
            ResultInfo info=new ResultInfo();
            // 注册失败
            info.setFlag(false);
            info.setErrorMsg("验证码错误！");
            // 将info对象序列化为json
            ObjectMapper mapper=new ObjectMapper();
            String json = mapper.writeValueAsString(info);
            // 将json数据写会客户端
            // 设置content-type
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(json);
            return;
        }
        // 1 获取数据
        Map<String, String[]> map = request.getParameterMap();

        // 2 封装对象
        User user=new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        // 3 调用service完成注册
        cn.itcast.travel.service.impl.UserServlet servlet=new UserServletImpl();
        boolean flag=servlet.regist(user);
        ResultInfo info=new ResultInfo();
        // 4 响应结果
        if(flag){
            // 注册成功
            info.setFlag(true);
        }else{
            // 注册失败
            info.setFlag(false);
            // 提示显示信息
            info.setErrorMsg("注册失败！");
        }
        // 将info对象序列化为json
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(info);
        // 将json数据写会客户端
        // 设置content-type
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
    }


    // 登录功能
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取用户账号和密码的值
        Map<String, String[]> map = request.getParameterMap();
        // 封装user对象
        User user=new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        // 调用service查询
        User u = servlet.login(user);


        // 调用ResultInfo方法
        ResultInfo info=new ResultInfo();
        // 判断用户对象是否为null
        if(u == null){
            // 用户名或密码错误
            info.setFlag(false);
            info.setErrorMsg("用户名或密码错误");
        }

        // 判断用户是否激活
        if(u != null && !"Y".equals(u.getStatus()) ){
            // 用户没有激活
            info.setFlag(false);
            info.setErrorMsg("你尚未激活，请激活账户");
        }


        if(u != null && "Y".equals(u.getStatus())){
            // 登录成功
            info.setFlag(true);
        }
        // 响应数据
        ObjectMapper mapper=new ObjectMapper();
        // 更改字节码格式
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),info);
    }

   // 查询单个对象
    public void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 从session中获取登录名
        Object user = request.getSession().getAttribute("user");
        // 将session写回到客户端
        ObjectMapper mapper = new ObjectMapper();
        // 设置字节码编码
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),user);
          writeValue(user,response);
    }


    // 退出功能
    public void exit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 销毁session
        request.getSession().invalidate();
        // 跳转到登录页面
        response.sendRedirect(request.getContextPath()+"/login.html");
    }

    // 激活功能
    public void active(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取激活码
        String code = request.getParameter("code");
        if(code != null){
            // 调用servlet完成激活
            boolean flag=servlet.active(code);
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
    }
