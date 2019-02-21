package com.itcast.service.impl;

import com.itcast.service.IAccountService;
// 账户的业务层实体类
public class AccountService implements IAccountService {


    public void saveAccount() {
        System.out.println("保存执行了");
    }

    public void update(int i) {
        System.out.println("更新"+i);
    }

    public int deleteAccount() {
        System.out.println("删除");
        return 0;
    }
}
