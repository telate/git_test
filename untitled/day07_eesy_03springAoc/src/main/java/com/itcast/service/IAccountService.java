package com.itcast.service;
// 账户的业务层接口
public interface IAccountService {

    /**
     * 模拟保存
     */
    void saveAccount();

    /**
     * 模拟更新
     * @param i
     */
    void update(int i);

    /**
     * 模拟删除
     * @return
     */
    int deleteAccount();

}
