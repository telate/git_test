package com.itcast.service.impl;

import com.itcast.service.IAccountService;
import org.springframework.stereotype.Component;

/**
 * 第一种方式
 * @Component
 */

 // 第二种方式
@Component(value="accountService")
public class AccountServiceImpl  implements IAccountService {
    public void saveAccount() {
        System.out.println("account执行了");
    }
}
