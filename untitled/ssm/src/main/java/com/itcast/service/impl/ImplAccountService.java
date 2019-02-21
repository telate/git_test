package com.itcast.service.impl;

import com.itcast.dao.AccountDao;
import com.itcast.domian.Account1;
import com.itcast.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("implAccountService")
public class ImplAccountService implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Override
    public List<Account1> findAll() {
        System.out.println("业务层：查询所有账户信息");
        return accountDao.findAll();
    }

    @Override
    public void saveAccount(Account1 account1) {

        System.out.println("业务层：保存账户信息");
        accountDao.saveAccount(account1);

    }


}
