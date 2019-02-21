package com.itcast.text;

import com.itcast.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TextService {
    public static void main(String[] args) {

        // 获取核心容器对象
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        // 根据Id获取对象
      // 第一种方式 IAccountService account=(IAccountService)ac.getBean("accountServiceImpl");
        IAccountService account=(IAccountService)ac.getBean("accountService");
        System.out.println(account);
        account.saveAccount();
    }
}
