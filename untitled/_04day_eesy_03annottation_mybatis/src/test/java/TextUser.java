import com.itcast.dao.IUserDao;
import com.itcast.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TextUser {
    public static void main(String[] args) throws IOException {
        // 读取核心配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 创建sqlSessionFactory工厂
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
        // 使用工厂生产sqlSession对象
        SqlSession sqlSession = factory.openSession();
        // 使用sqlSession获取dao的代理对象
        IUserDao mapper = sqlSession.getMapper(IUserDao.class);
        // 使用对象执行方法
        List<User> all = mapper.findAll();
        for (User user : all) {
            System.out.println(user);
        }
        // 释放资源
        sqlSession.close();
        in.close();
    }
}
