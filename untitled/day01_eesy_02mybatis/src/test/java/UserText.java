import com.itcast.dao.IUserDao;
import com.itcast.main.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class UserText {

    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao mapper;

    @Before //用于在测试方法执行之前执行
    // 创建初始化方法
    public void init()throws Exception{
        // 1 读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2 创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        // 3 使用工厂生产SqlSession对象
        sqlSession = factory.openSession();
        // 4 使用SqlSession创建Dao接口的代理对象
        mapper = sqlSession.getMapper(IUserDao.class);
    }

    @After //用于测试方法执行之后执行
    // 创建销毁方法
    public void destory()throws Exception{
        // 提交事务
        sqlSession.commit();
        // 释放资源
        sqlSession.close();
        in.close();
    }

    /**
     * 查询所有数据
     * @throws Exception
     */
    @Test
    public void findAll()throws Exception{

        //  使用代理对象执行方法
        List<User> all = mapper.findAll();
        for (User user : all) {
            System.out.println(user);
        }
        }


    /**
     *    测试保存操作
     *
     */
    @Test
    public void testSave() {
        User user=new User();
        user.setName("陈文斌");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("成都金牛区精城国际");

        //  使用代理对象执行方法
        mapper.saveUser(user);
    }

    /**
     * 更新用户
     */
    @Test
    public void textUpdate(){
        User user=new User();
        user.setId(48);
        user.setName("林芝");
        user.setBirthday(new Date());
        user.setSex("女");
        user.setAddress("广安");

        // 使用代理对象执行方法
        mapper.updateUser(user);
    }

    /**
     * 测试删除用户
     */
   @Test
    public void textDelete(){
        // 执行删除方法
        mapper.deleteUser(45);
    }


    /**
     * 测试查找userById方法
     */
    @Test
    public void  textFindOne(){
       // 执行查找方法
        User user=mapper.findById(48);
        System.out.println(user);
    }

    /**
     * 测试模糊查询方法
     */
    @Test
    public void textFindName(){
        //执行查找username方法
        List<User> byName = mapper.findByName("%王%");
        for (User user : byName) {
            System.out.println(user);
        }
    }

    /**
     * 测试查询所有id
     */
    @Test
    public void textFindTotal(){
        int total = mapper.findTotal();
        System.out.println(total);
    }
}
