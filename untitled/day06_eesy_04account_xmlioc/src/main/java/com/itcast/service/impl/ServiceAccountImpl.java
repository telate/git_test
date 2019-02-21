package com.itcast.service.impl;


import com.itcast.dao.impl.AccountDaoImpl;
import com.itcast.domain.Account3;
import com.itcast.service.ServiceAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service("ServiceAccount")
public class ServiceAccountImpl implements ServiceAccount {


    @Autowired
    // 获取dao数据
    private AccountDaoImpl accountDao;



    public List<Account3> findAllAccount3() {
        return accountDao.findAllAccount3();
    }

    public Account3 findById(Integer account3Id) {
        return accountDao.findById(account3Id);
    }

    public void saveAccount3(Account3 account3) {
            accountDao.saveAccount3(account3);
    }

    public void deleteAccount3(Integer account3Id) {
          accountDao.deleteAccount3(account3Id);
    }

    public void updateAccount3(Account3 account3) {
           accountDao.updateAccount3(account3);
    }
}
