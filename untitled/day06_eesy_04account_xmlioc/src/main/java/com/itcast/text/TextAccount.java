package com.itcast.text;


import com.itcast.domain.Account3;
import com.itcast.service.ServiceAccount;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 测试
 */
public class TextAccount {
    /**
     * 查询所有
     */
    @Test
    public void testFindAll(){
       //读取核心容器对象
       ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        // 获取业务层实体类对象
        ServiceAccount bean = ac.getBean(ServiceAccount.class);
        List<Account3> allAccount3 = bean.findAllAccount3();
        for (Account3 account3 : allAccount3) {
            System.out.println(account3);
        }
    }


    /**
     * 查询一个
     *
     */
    @Test
    public void testFindById(){
        // 读取核心容器对象
        ApplicationContext ca=new ClassPathXmlApplicationContext("bean.xml");
        // 获取业务层对象
        ServiceAccount bean = ca.getBean(ServiceAccount.class);
        Account3 byId = bean.findById(1);
        System.out.println(byId);

    }

    /**
     * 保存
     */
    @Test
    public void testSave(){
        Account3 account3=new Account3();
        account3.setId(4);
        account3.setName("古乐天");
        account3.setMoney(10000000.0);

    // 读取核心容器对象
    ApplicationContext ca=new ClassPathXmlApplicationContext("bean.xml");
    // 获取业务层对象
    ServiceAccount bean = ca.getBean(ServiceAccount.class);
        bean.saveAccount3(account3);

    }

    /**
     * 删除
     */
    @Test
    public void testDelete(){
        // 读取核心容器对象
        ApplicationContext ca=new ClassPathXmlApplicationContext("bean.xml");
        // 获取业务层对象
        ServiceAccount bean = ca.getBean(ServiceAccount.class);
        bean.deleteAccount3(4);
    }




    /**
     * 更新
     */
    @Test
    public void testUpdate(){
        // 读取核心容器对象
        ApplicationContext ca=new ClassPathXmlApplicationContext("bean.xml");
        // 获取业务层对象
        ServiceAccount bean = ca.getBean(ServiceAccount.class);
        Account3 byId = bean.findById(1);
        byId.setMoney(80000.0);
        bean.updateAccount3(byId);

    }

}
