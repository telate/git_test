package com.itheima.text;

import com.itheima.dao.ItemsDao;
import com.itheima.domain.Items;
import com.itheima.service.ItemsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ItemsTest {

    @Test
    public void findById(){
        // 获取Spring容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 从容器中拿到所需要的dao的代理对象
        ItemsDao itemsDao = ac.getBean(ItemsDao.class);
        // 调用方法
        Items items = itemsDao.findById(1);
        System.out.println(items.getName());

    }
    @Test
    public void findById2(){
        // 获取Spring容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 从容器中拿到所有需要的dao的代理对象
        ItemsService bean = ac.getBean(ItemsService.class);
        // 调用方法
        Items byId = bean.findById(1);
        System.out.println(byId.getName());

    }
}
