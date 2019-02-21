package com.itcast.dao;

import com.itcast.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.junit.Test;

import java.util.List;


public interface IUserDao {


    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from user")
    @Results(id="userMap", value ={
            @Result(id=true,column = "id",property ="userId" ),
            @Result(column = "username",property ="userName" ),
            @Result(column = "birthday",property ="userBirthday" ),
            @Result(column = "sex",property ="userSex" ),
            @Result(column = "address",property ="userAddress" ),
            @Result(property="accounts", column="id",many=@Many(select="com.com.itcast.dao.IAccountDao.findById",fetchType= FetchType.LAZY  ) )
    })
    List<User> findAll();


    /**
     * 根据Id查询用户
     * @param id
     */
    @ResultMap("userMap")
    @Select("select * from user where id=#{id}")
    User findById(int id);


    /**
     * 根据用户名模糊查询
     * @param username
     * @return
     */
    @ResultMap(value={"userMap"})
    @Select("select * from user where username like '%${value}%'  ")
   List<User> findUserByName(String username);



}