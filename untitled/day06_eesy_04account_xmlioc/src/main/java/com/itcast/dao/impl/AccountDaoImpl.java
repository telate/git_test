package com.itcast.dao.impl;

import com.itcast.dao.AccountDao;
import com.itcast.domain.Account3;
import com.itcast.service.ServiceAccount;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {


    @Autowired
    // 连接数据库
    private QueryRunner runner;


    /**
     * 查询所有
     * @return
     */
    public List<Account3> findAllAccount3() {
        try {
            return runner.query("select * from account3",new BeanListHandler<Account3>(Account3.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查询一个
     * @param account3Id
     * @return
     */
    public Account3 findById(Integer account3Id) {
        try {
            return runner.query("select * from account3 where id=?",new BeanHandler<Account3>(Account3.class),account3Id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 保存
     * @param account3
     */
    public void saveAccount3(Account3 account3) {
        try {
            runner.update("insert into account3(name,money) values(?,?)",account3.getName(),account3.getMoney());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 删除
     * @param account3Id
     */
    public void deleteAccount3(Integer account3Id) {
        try {
            runner.update("delete from account3 where id=?",account3Id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新
     * @param account3
     */
    public void updateAccount3(Account3 account3) {
        try {
            runner.update("update account3 set name=? , money=? where id=?",account3.getName(),account3.getMoney(),account3.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
