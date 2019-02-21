package com.itcast.service;

import com.itcast.daomain.Account2;

import java.util.List;

public interface ServiceAccount {

    /**
     * 查询所有
     * @return
     */
    List<Account2> findAllAccount2();

    /**
     * 根据id查询账户
     * @param account2
     * @return
     */
    Account2 findByIdAccount2(Integer account2);

    /**
     * 保存账户
     * @param account2
     */
    void saveAccount2(Account2 account2);

    /**
     * 删除账户
     * @param account2
     */
    void deleteAccount2(Integer account2);

    /**
     * 更新账户
     * @param account2
     */
    void updateAccount2(Account2 account2);




}
