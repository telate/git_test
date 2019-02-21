package com.itcast.dao;

import com.itcast.main.Account;
import com.itcast.main.AccountUser;

import java.util.List;

public interface IAccountDao {

    /**
     * 查询所有，同时获取到所有用户下的所有账户信息
     * @return
     */
    List<Account> findAll();

    /**
     * 查询所有外加用户名和地址
     * @return
     */
    List<AccountUser> findAllAccountUser();























/*    *//**
     *
     * 查询所有账户
     * @return
     *//*
    public List<Account> findAll();

    *//**
     * 查找账户的所有信息
     * @return
     *//*
    List<AccountUser> findAllAccount();*/

}
