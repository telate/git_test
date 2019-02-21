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
     * 保存用户
     * @param user
     */
    void saveUser(User user);

    /**
     * 更新用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 删除用户
     * @param userId
     */
    void deleteUser(Integer userId);


    /**
     * 根据Id查询用户
     * @param userId
     * @return
     */
    User findById(Integer userId);

    /**
     * 根据用户名查找用户
     * @param userName
     * @return
     */
    List<User> findByName(String userName);


   /**
     * 查询所有id总和
     * @return
     */
    int findTotal();



}
