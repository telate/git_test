package com.itcast.dao;

import com.itcast.daomain.User;

import java.util.List;

/**
 * 创建持久层接口
 */
public interface userDaoImpl {
    // 查询所有
    List<User> findAll();
}
