package com.itcast.dao.impl;

import com.itcast.dao.ServiceDao;
import com.itcast.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

// 账户的持久层实现类
public class IServiceDao implements ServiceDao {

    private QueryRunner runner;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    public List<Account> findAllAccount() {
        try {
            return runner.query("select * from account1",new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



    public Account findAccountById(Integer accountId) {
        try {
            return runner.query("select * from account1 where id=?",new BeanHandler<Account>(Account.class),accountId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void saveAccount(Account account) {
        try {
            runner.update("insert into  account1 (name,money) values(?,?)",account.getName(),account.getMoney());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteAccount(Integer accountId) {
        try {
            runner.update("delete  from account1 where id =?",accountId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAccount(Account account) {
        try {
            runner.update("update  account1 set name=? ,money=? where id=? ",account.getName(),account.getMoney(),account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
