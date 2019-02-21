package com.itcast.service.impl;

import com.itcast.service.ServiceAccount;

import java.util.Date;

public class ServiceAccountImpl implements ServiceAccount {

    private Integer id;
    private String name;
    private Date birthday;

    public ServiceAccountImpl(Integer id, String name, Date birthday) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }


    public void saveAccount() {
        System.out.println("ServiceAccount执行了"+id+","+name+","+birthday);
    }
}
