package com.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 控制器
 */
@Controller("/user")
public class HelloController {
    /**
     * 接收请求
     * @return
     */
   @RequestMapping(path="/hello")
    public String sayHello(){
        System.out.println("HelloController执行了。。。");
        return "success";
    }
}
