package cn.itcast.travel.dao.impl;

import cn.itcast.travel.domain.User;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public User findByUsername(String username) {
        User user = null;
        try {
            // 定义sql
            String sql = "select * from tab_user where username=?";
            // 执行sql
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username);
        } catch (Exception e) {
        }
        return user;
    }

    @Override
    public void save(User user) {
        // 定义sql
        String sql = "insert into tab_user(username,password,name,birthday,sex,telephone,email,status,code) values(?,?,?,?,?,?,?,?,?)";
        // 执行sql
        template.update(sql,user.getUsername(),
                user.getPassword(),
                user.getName(),
                user.getBirthday(),
                user.getSex(),
                user.getTelephone(),
                user.getEmail(),
                user.getStatus(),
                user.getCode());
    }


    // 根据激活码查询用户对象
    @Override
    public User findByCode(String code) {
        User user=null;
        try {
            //定义sql
            String  sql="select * from tab_user where code=?";
            // 执行sql
             user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), code);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return user;
    }


    // 修改指定用户激活码
    @Override
    public void updateStatus(User user) {
        // 修改sql
        String sql="update tab_user set status='Y' where uid=?";
        // 执行sql
        template.update(sql, user.getUid());

    }
   // 查询用户名和密码
    @Override
    public User findByUsernameAndPassword(String username, String password) {
        User user=null;
        try {
            //定义sql
            String  sql="select * from tab_user where username=? and password=?";
            // 执行sql
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username,password);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return user;
    }
}

















