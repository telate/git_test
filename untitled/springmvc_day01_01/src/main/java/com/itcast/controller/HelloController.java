package com.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//控制器类
@Controller
@RequestMapping("controller")
public class HelloController {

    @RequestMapping("hello")
  public String SayHello(){
      System.out.println("HelloController执行了");
      return null;
  }



}
