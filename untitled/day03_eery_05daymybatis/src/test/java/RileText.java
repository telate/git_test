import com.itcast.dao.IRoleDao;
import com.itcast.main.Role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class RileText {
       private InputStream in;
       private SqlSession sqlSession;
       private IRoleDao mapper;

    /**
     *
     * @throws Exception
     */
     @Before
     //默认在测试类测试之前测试
     public void init()throws Exception{
         // 读取配置文件
          in = Resources.getResourceAsStream("SqlMapConfig.xml");
         // 创建sqlSessionFactory工厂
         SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
         SqlSessionFactory factory = builder.build(in);
         // 使用工厂生产sqlSession对象
          sqlSession = factory.openSession();
         // 使用sqlSession创建dao的代理对象
          mapper = sqlSession.getMapper(IRoleDao.class);
     }

    /**
     *
     * @throws Exception
     */
   @After
     public void destory()throws Exception{
         // 事务回滚
         sqlSession.commit();
         // 释放资源
         sqlSession.close();
         in.close();
     }

    /**
     * 测试查询所有
     */
    @Test
    public void textFindAll() {
        //  使用代理对象执行方法
        List<Role> all = mapper.findAll();
        for (Role role : all) {
            System.out.println("---------每一个用户信息---------");
            System.out.println(role);
            System.out.println(role.getUsers());

        }
    }
}
