package com.itcast.Utils;

/**
 * 用户记录日志的工具列类，他里面提供了公共的代码
 */
public class AccountUtils {

    /**
     * 用与打印日志：计划让其在切入点方法执行之前执行（切入点方法就是业务层方法）
     */
    public void printLog(){
        System.out.println("AccountUnits类中的printLog开始记录日志");
    }
}
