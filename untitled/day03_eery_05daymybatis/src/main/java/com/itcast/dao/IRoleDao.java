package com.itcast.dao;

import com.itcast.main.Role;

import java.util.List;

public interface IRoleDao {

    /**
     *  查询所有角色
     * @return
     */

    List<Role> findAll();
}
