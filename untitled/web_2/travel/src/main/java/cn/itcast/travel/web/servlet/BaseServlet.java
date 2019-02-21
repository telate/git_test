package cn.itcast.travel.web.servlet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // 完成方法分发
       // 1 获取请求路径
        String uri = request.getRequestURI();// "/travel/user/add"
       // 获取方法名称
        String methodName = uri.substring(uri.lastIndexOf("/") + 1);
        try {
            // 2 获取方法对象method
            Method method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this,request,response);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    // 直接将传入的对象序列化为json，并且写回客户端
    public void writeValue(Object obj,HttpServletResponse response) throws IOException {
        // 序列化json并返回
        ObjectMapper mapper= new ObjectMapper();
       response.setContentType("application/json;charset=utf-8");
       mapper.writeValue(response.getOutputStream(),obj);
    }

    // 将传入的对象序列化为json，返回
     public String writeValueAsString(Object obj) throws JsonProcessingException {
        ObjectMapper mapper=new ObjectMapper();
        return mapper.writeValueAsString(obj);

     }

























}
