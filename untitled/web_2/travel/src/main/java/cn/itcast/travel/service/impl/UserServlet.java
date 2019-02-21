package cn.itcast.travel.service.impl;

import cn.itcast.travel.domain.User;

public interface UserServlet {
    //注册用户
    boolean regist(User user);

    boolean active(String code);

    User login(User user);
}
