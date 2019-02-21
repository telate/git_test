package com.itcast.text;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


// 模拟一个表现层，用于调用业务层
public class Text {
    public static void main(String[] args) {
        // 获取核心容器对象
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");

        // 根据id获取bean对象
        Object accountServices = ac.getBean("accountService");
         // 输出
        System.out.println(accountServices);


    }

}
