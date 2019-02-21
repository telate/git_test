package com.itcast.service.impl;

import com.itcast.dao.impl.IServiceDao;
import com.itcast.domain.Account;
import com.itcast.service.ServiceAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 账户的业务层实现类
 */
public class ServiceAccountImpl implements ServiceAccount {


    private IServiceDao serviceDao;

    public void setServiceDao(IServiceDao serviceDao) {
        this.serviceDao = serviceDao;
    }

    public  List<Account> findAllAccount() {
        return serviceDao.findAllAccount();
    }

    public Account findAccountById(Integer accountId) {
        return serviceDao.findAccountById(accountId);
    }

    public void saveAccount(Account account) {
          serviceDao.saveAccount(account);
    }


    public void deleteAccount(Integer accountId) {
          serviceDao.deleteAccount(accountId);
    }

    public void updateAccount(Account account) {
          serviceDao.updateAccount(account);
    }


}
