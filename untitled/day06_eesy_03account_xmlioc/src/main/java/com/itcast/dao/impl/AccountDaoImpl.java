package com.itcast.dao.impl;

import com.itcast.dao.AccountDao;
import com.itcast.daomain.Account2;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * 账户的持久层实体类
 */
public class AccountDaoImpl implements AccountDao {
    // 连接数据库
    private QueryRunner runner;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    /**
     * 查询所有
     * @return
     */
    public List<Account2> findAllAccount2() {
        try {
            return runner.query("select * from account2",new BeanListHandler<Account2>(Account2.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查询一个
     * @param account2
     * @return
     */
    public Account2 findByIdAccount2(Integer account2) {
        try {
            return runner.query("select * from account2 where id=?",new BeanHandler<Account2>(Account2.class),account2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    /**
     * 保存
     * @param account2
     */
    public void saveAccount2(Account2 account2) {

        try {
            runner.update("insert into account2(name, money) values(?,?)",account2.getName(),account2.getMoney());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 删除
     * @param account2
     */
    public void deleteAccount2(Integer account2) {
        try {
            runner.update("delete from account2 where id =?",account2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新
     * @param account2
     */
    public void updateAccount2(Account2 account2) {
        try {
            runner.update("update  account2 set name=? , money=? where id=?",account2.getName(),account2.getMoney(),account2.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
