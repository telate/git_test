import com.itcast.dao.IAccountDao;
import com.itcast.main.Account;
import com.itcast.main.AccountUser;
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

public class AccountText {

    private InputStream in;
    private SqlSession sqlSession;
    private IAccountDao mapper;

    @Before
    public void  init()throws Exception{
        // 1 读取配置文件
         in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2 创建SqlSessionFactory工厂
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
        // 3 使用工厂生产sqlSession对象
         sqlSession = factory.openSession();
        // 4 使用sqlSession创建dao接口的代理对象
         mapper = sqlSession.getMapper(IAccountDao.class);
    }

    @After
    public void destory()throws Exception{
        //回滚事务
        sqlSession.commit();
        //  释放资源
        sqlSession.close();
        in.close();
    }



        //查询所有
            @Test
        public void findAll(){
                List<Account> all = mapper.findAll();
                for (Account account : all) {
                    System.out.println("-------------------");
                    System.out.println(account);
                    System.out.println(account.getUser());
                }

            }


        @Test
        public void textFindAllAccountUser(){
            List<AccountUser> allAccountUser = mapper.findAllAccountUser();
            for (AccountUser accountUser : allAccountUser) {
                System.out.println(accountUser);
            }

        }































/*     // 测试查询所有
    @Test
    public void textFindAll() throws IOException {
        // 5 使用方法获取值
        List<Account> all = mapper.findAll();
        for (Account account : all) {
            System.out.println(account);
        }
    }

    // 测试查询所有外加用户名和地址
    @Test
    public void textFindAllAccount() throws IOException {
        // 5 使用方法获取值
        List<AccountUser> allAccount = mapper.findAllAccount();
        for (Account account : allAccount) {
            System.out.println(account);
        }
    }*/


}
