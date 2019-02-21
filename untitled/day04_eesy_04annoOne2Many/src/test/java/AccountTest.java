import com.itcast.dao.IAccountDao;
import com.itcast.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AccountTest {

    private InputStream in;
    private SqlSession sqlSession;
    private IAccountDao mapper;

    /**
     *  测试在测试方法执行前执行
     * @throws IOException
     */
    @Before
    public void init() throws IOException {
        // 读取核心配置文件
         in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 创建sqlSessionFactory工厂
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
        // 使用工厂生产sqlSession对象
         sqlSession = factory.openSession();
        // 使用sqlSession获取dao的代理对象
         mapper = sqlSession.getMapper(IAccountDao.class);
    }

    /**
     * 测试在测试方法执行后执行
     * @throws IOException
     */
    @After
    public void destroy() throws IOException {
        // 事务回滚
        sqlSession.commit();
        in.close();
    }

    @Test
    public void testFindAll(){
        List<Account> all = mapper.findAll();
        for (Account account : all) {
            System.out.println("----------每个用户的信息--------");
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }


@Test
    public void textFindById(){
        List<Account> byId = mapper.findById(45);
        System.out.println(byId);
    }


}
