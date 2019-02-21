package com.itcast.service;

import com.itcast.domian.Account1;

import java.util.List;

public interface AccountService {

    /**
     * 查询所有账户
     * @return
     */
    public List<Account1> findAll();

    /**
     * 保存账户
     * @param account1
     */
    public void saveAccount(Account1 account1);

}
