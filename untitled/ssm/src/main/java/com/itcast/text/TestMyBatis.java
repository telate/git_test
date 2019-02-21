package com.itcast.text;

import com.itcast.dao.AccountDao;
import com.itcast.domian.Account1;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMyBatis {
    /**
     * 查询所有
     * @throws Exception
     */
    @Test
    public void run() throws Exception {
     // 加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
     // 创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
      // 创建SqlSession对象
        SqlSession session = factory.openSession();
      // 获取代理对象
        AccountDao mapper = session.getMapper(AccountDao.class);
      // 查询所有数据
        List<Account1> all = mapper.findAll();
        for (Account1 account1 : all) {
            System.out.println(account1);
        }
        // 关闭资源
        session.close();
        in.close();
    }

    /**
     * 保存用户
     * @throws Exception
     */
    @Test
    public void run1() throws Exception {
        // 加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 创建SqlSession对象
        SqlSession session = factory.openSession();
        // 获取代理对象
        AccountDao mapper = session.getMapper(AccountDao.class);
        // 查询所有数据


        Account1 a=new Account1();
        a.setName("马儿");
        a.setMoney(100000.0);

        mapper.saveAccount(a);

        // 提交事务
        session.commit();


        // 关闭资源
        session.close();
        in.close();
    }
}
