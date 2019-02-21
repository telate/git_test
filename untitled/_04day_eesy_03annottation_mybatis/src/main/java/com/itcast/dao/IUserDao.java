package com.itcast.dao;

import com.itcast.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.junit.Test;

import java.util.List;

/**
 * 在mybatis中针对，crud
 */
public interface IUserDao {


    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from user")
    List<User> findAll();


    /**
     * 保存用户
     * @param user
     */
    @Insert("insert into user(username,birthday,sex,address)values(#{username},#{birthday},#{sex},#{address})")
    void saveUser(User user);


    /**
     * 更新用户
     * @param user
     */
    @Update("update  user set username=#{username},birthday=#{birthday},sex=#{sex},address=#{address} where id=#{id} ")
    void updateUser(User user);

    /**
     * 删除用户
     * @param id
     */
    @Delete("delete from user where id=#{id} ")
    void deleteUser(int id);

    /**
     * 根据Id查询用户
     * @param id
     */
    @Select("select * from user where id=#{id}")
    User findById(int id);

    /**
     * 根据用户名模糊查询
     * @param username
     * @return
     */
    @Select("select * from user where username like '%${value}%'  ")
   List<User> findUserByName(String username);


    /**
     * 查询总用户数量
     * @return
     */
    @Select("select count(*) from user")
    int findCount();

}