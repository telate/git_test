package com.text;

import com.itcast.domain.Account;
import com.itcast.service.ServiceAccount;
import com.itcast.service.impl.ServiceAccountImpl;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TextAccount {

   @Test
   public void testFindAll(){
        // 读取核心容器对象
        ApplicationContext ac=new ClassPathXmlApplicationContext("ApplicationConfig.xml");
        // 根据ID获取对象
        Object as = ac.getBean("ServiceAccount", ServiceAccountImpl.class);
        System.out.println(as);
        List<Account> allAccount = ((ServiceAccount) as).findAllAccount();
        for (Account account : allAccount) {
            System.out.println(account);
        }
    }

   @Test
   public void testFindById(){
       // 读取核心容器对象
       ApplicationContext ac=new ClassPathXmlApplicationContext("ApplicationConfig.xml");
       // 根据ID获取对象
       Object as = ac.getBean("ServiceAccount", ServiceAccountImpl.class);
       System.out.println(as);
       Account accountById = ((ServiceAccountImpl) as).findAccountById(1);
       System.out.println(accountById);


   }

   @Test
   public void testSave(){
// 读取核心容器对象
       ApplicationContext ac=new ClassPathXmlApplicationContext("ApplicationConfig.xml");
       // 根据Id获取对象
       ServiceAccount bean = ac.getBean(ServiceAccount.class);
       Account account =new Account();
       account.setName("马化腾");
       account.setMoney(2123.0);
       bean.saveAccount(account);

   }

   @Test
   public void testDelete(){
       // 读取核心容器对象
       ApplicationContext ac=new ClassPathXmlApplicationContext("ApplicationConfig.xml");
       //得到业务层对象
       ServiceAccount bean = ac.getBean(ServiceAccount.class);
       // 执行方法
       bean.deleteAccount(5);


   }

   @Test
   public void testUpdate(){

       //读取核心容器对象
       ApplicationContext ac=new ClassPathXmlApplicationContext("ApplicationConfig.xml");
       // 得到业务层对象
       ServiceAccount bean = ac.getBean(ServiceAccount.class);
       // 执行方法
       Account accountById = bean.findAccountById(1);
       accountById.setMoney(20000.0);
       bean.updateAccount(accountById);


   }
}
