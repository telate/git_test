package cn.itcast.travel.web.servlet;

import cn.itcast.travel.dao.impl.UserDao;
import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.impl.UserServletImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        UserServletImpl servlet = new UserServletImpl();
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


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
