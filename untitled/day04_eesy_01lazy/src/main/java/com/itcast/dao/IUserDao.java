package com.itcast.dao;

import com.itcast.main.User;

import java.util.List;
// 用户的持久层接口
public interface IUserDao  {

    /**
     *
     * 查询所有用户
     * @return
     */
    public List<User> findAll();

    /**
     * 根据Id查询用户
     * @param userId
     * @return
     */
    User findById(Integer userId);



}
