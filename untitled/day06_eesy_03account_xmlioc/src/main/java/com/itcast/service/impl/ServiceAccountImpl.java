package com.itcast.service.impl;

import com.itcast.dao.impl.AccountDaoImpl;
import com.itcast.daomain.Account2;
import com.itcast.service.ServiceAccount;

import java.util.List;
     // 账户的业务操作层实体类
public class ServiceAccountImpl implements ServiceAccount {

     private AccountDaoImpl accountDao;

    public void setAccountDao(AccountDaoImpl accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account2> findAllAccount2() {
        return accountDao.findAllAccount2();
    }

    public Account2 findByIdAccount2(Integer account2) {
        return accountDao.findByIdAccount2(account2);
    }

    public void saveAccount2(Account2 account2) {
        accountDao.saveAccount2(account2);
    }

    public void deleteAccount2(Integer account2) {
        accountDao.deleteAccount2(account2);
    }

    public void updateAccount2(Account2 account2) {
        accountDao.updateAccount2(account2);

    }
}
