package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;
// 用户的持久层业务
public interface IUserDao {
    // 创建findAll方法
    public List<User> findAll();
}
