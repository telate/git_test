package cn.itcast.travel.service.impl;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;

// 创建线路service
public interface RouteService {
// 根据类别进行分类
    public PageBean<Route> PageQuery(int cid, int currentPage, int pageSize);
}
