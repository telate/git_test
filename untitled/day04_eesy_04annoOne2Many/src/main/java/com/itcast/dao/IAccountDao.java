package com.itcast.dao;

import com.itcast.domain.Account;
import com.itcast.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface IAccountDao {


    /**
     * 查询所有
     * @return
     */
    @Select("select * from account")
    @Results(id="accountMap", value = {
            @Result(id = true,column="id",property="id"),
            @Result(column="uid", property="uid"),
            @Result(column="money",property="money"),
            @Result(property="user", column="uid",one = @One(select="com.com.itcast.dao.IUserDao.findById", fetchType = FetchType.EAGER))
    })
    List<Account> findAll();

    /**
     * 根据用户ID查询账户信息
     * @param userId
     */
    @ResultMap("accountMap")
    @Select("select * from account where uid=#{userId}")
    List<Account> findById(Integer userId);
}