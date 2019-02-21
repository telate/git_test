package com.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//控制器类
@Controller
@RequestMapping(path="/user")
public class HelloController {

    @RequestMapping(path = "/hello") //请求映射
    public String sayHello(){
        System.out.println("Hello SpringMVC");
        return "success";
    }

    /**
     *
     * @return
     */
    @RequestMapping(path = "/textRequestMapping")
    public String textRequestMapping(){
        System.out.println("requestMapping执行了");
        return "success";
    }
}
