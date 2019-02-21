package com.itcast.dao;

import com.itcast.domain.Account3;

import java.util.List;

public interface AccountDao {
    /**
     * 查询所有
     * @return
     */
    List<Account3> findAllAccount3();

    /**
     * 查询一个
     * @param account3Id
     * @return
     */
    Account3 findById(Integer account3Id);

    /**
     * 保存
     * @param account3
     */
    void saveAccount3(Account3 account3);

    /**
     * 删除
     * @param account3Id
     */
    void deleteAccount3(Integer account3Id);

    /**
     * 更新
     * @param account3
     */
    void updateAccount3(Account3 account3);


}
