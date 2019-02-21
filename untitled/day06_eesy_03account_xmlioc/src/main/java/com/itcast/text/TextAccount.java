package com.itcast.text;

import com.itcast.daomain.Account2;
import com.itcast.service.ServiceAccount;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TextAccount {
    /**
     * 查询所有
     */
    @Test
    public void textFindAllAccount(){
        //读取核心容器对象
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        // 得到业务层对象
        ServiceAccount bean = ac.getBean(ServiceAccount.class);
        // 执行对象
        System.out.println(bean);
        List<Account2> allAccount2 = bean.findAllAccount2();
        for (Account2 account2 : allAccount2) {
            System.out.println(account2);
        }

    }

    /**
     * 查询一个
     *
     */
    @Test
    public void textFindById(){
        // 读取核心容器对象
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        // 得到业务层对象
        ServiceAccount bean = ac.getBean(ServiceAccount.class);
        //执行方法
        Account2 byIdAccount2 = bean.findByIdAccount2(1);
        System.out.println(byIdAccount2);
    }

    /**
     * 保存
     *
     */
    @Test
    public void textSaveAccount(){
        Account2 account2=new Account2();
        account2.setId(4);
        account2.setName("古力娜扎");
        account2.setMoney(1000000.0);

        // 读取核心容器对象
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        // 获取业务层对象
        ServiceAccount bean = ac.getBean(ServiceAccount.class);
        // 执行对象
        bean.saveAccount2(account2);
    }

    /**
     * 删除
     */
    @Test
    public void textDeleteAccount(){
        // 读取核心容器对象
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        // 获取业务层对象
        ServiceAccount bean = ac.getBean(ServiceAccount.class);
        //执行对象
        bean.deleteAccount2(4);

    }

    /**
     * 更新
     */
    @Test
    public void textUpdateAccount(){
    // 读取核心容器对象
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        // 获取业务层对象
        ServiceAccount bean = ac.getBean(ServiceAccount.class);
        Account2 byIdAccount2 = bean.findByIdAccount2(1);
        byIdAccount2.setMoney(20000.0);
        bean.updateAccount2(byIdAccount2);
    }

}
