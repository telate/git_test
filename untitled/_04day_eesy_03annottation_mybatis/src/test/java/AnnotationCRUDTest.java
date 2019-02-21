import com.itcast.dao.IUserDao;
import com.itcast.domain.User;
import com.sun.xml.internal.ws.developer.UsesJAXBContext;
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

public class AnnotationCRUDTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao mapper;

    /**
     * 在测试文件执行之前执行
     * @throws Exception
     */
    @Before
    public void init() throws Exception {
        // 读取配置核心配置文件
         in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 创建sqlSessionFactory工厂
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
        // 使用工厂生产sqlSession对象
         sqlSession = factory.openSession();
        // 使用sqlSession获取dao的代理对象
         mapper = sqlSession.getMapper(IUserDao.class);

    }

    /**
     * 在测试文件执行之后执行
     * @throws Exception
     */
    @After
    public void destroy()throws Exception{
        // 事务回滚
        sqlSession.commit();
        // 释放资源
        sqlSession.close();
        in.close();
    }

    /**
     *  测试查询所有用户
     */
    @Test
    public void textFindAll(){
        List<User> all = mapper.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }

    /**
     * 测试保存用户
     */
    @Test
    public void textSaveUser(){
        User user =new User();
        user.setUsername("林芝");
        user.setBirthday(new Date());
        user.setSex("女");
        user.setAddress("广安");
        mapper.saveUser(user);
    }

    /**
     * 测试更新用户
     */
    @Test
    public void textUpdateUser(){
        User user =new User();
        user.setId(48);
        user.setUsername("马云");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("济南");
        mapper.updateUser(user);
    }

    /**
     * 测试删除用户
     */
    @Test
    public void textDeleteUser(){
        mapper.deleteUser(49);
    }

    /**
     * 测试根据Id查询用户
     */
    @Test
    public void textFindById(){
        User byId = mapper.findById(48);
        System.out.println(byId);
    }


    /**
     * 根据用户名模糊查询
     */
    @Test
    public void textFindByName(){
    List<User> userByName = mapper.findUserByName("马");
    for (User user : userByName) {
        System.out.println(user);
    }
}

    /**
     * 测试 查询总用户数量
     */
    @Test
    public void textFindCount(){
        Integer count = mapper.findCount();
        System.out.println(count);
    }

}
