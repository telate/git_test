package com.itcast.controller;

import com.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 返回String
     * @param model
     * @return
     */
    @RequestMapping("/testString")
    public String testString(Model model){
        System.out.println("testString方法执行了。。。");

        // 模拟从数据库里获取数据
        User user=new User();
        user.setUsername("古力娜扎");
        user.setPassword("1234");
        user.setAge(18);
        // model 对象
        model.addAttribute("user",user);
        return "success";
    }


    /**
     * 是void
     * @param
     * @return
     */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception{
        System.out.println("testVoid方法执行了。。。");
        // 编写请求转发的程序
        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
        return;
    }

    /**
     * 返回ModelAndView
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        // 创建ModelAndView对象
        ModelAndView mv=new ModelAndView();
        System.out.println("testModelAndView方法执行了。。。");

        // 模拟从数据库里获取数据
        User user=new User();
        user.setUsername("迪丽热巴");
        user.setPassword("2345");
        user.setAge(20);
        // 把user对象储存到mv对象中，也会把user对象存到request对象中
        mv.addObject("user",user);
        // 跳转到哪个页面
        mv.setViewName("success");

        return mv;
    }

    /**
     * 模拟异步请求响应
     */
    @RequestMapping("/testAjax")
    public void testAjax(@RequestBody User user){
        System.out.println("testAjax方法执行了。。。");
        System.out.println(user);
        return ;
    }

}

























