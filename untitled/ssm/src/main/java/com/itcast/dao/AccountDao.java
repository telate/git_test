package com.itcast.dao;

import com.itcast.domian.Account1;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface AccountDao {
    /**
     * 查询所有账户
     * @return
     */
    @Select("select * from account1")
    public List<Account1> findAll();

    /**
     * 保存账户
     * @param account1
     */
    @Insert("insert into account1 (name,money) values(#{name},#{money})")
    public void saveAccount(Account1 account1);
}
