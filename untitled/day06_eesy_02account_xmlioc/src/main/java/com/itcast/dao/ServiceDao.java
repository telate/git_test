package com.itcast.dao;

import com.itcast.domain.Account;

import java.util.List;

/**
 *
 */
public interface ServiceDao {
    /**
     * 查询所有
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 查询一个
     * @param accountId
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 保存
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 删除账户
     * @param accountId
     */
    void deleteAccount(Integer accountId);


    /**
     * 更新账户
     * @param account
     */
    void updateAccount(Account account);



}
