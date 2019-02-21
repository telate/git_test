package cn.itcast.travel.dao.impl;

import cn.itcast.travel.domain.Route;

import java.util.List;

public interface RouteDao {
    // 根据uid查询总记录数
    public int  findTotalCount(int cid);


    // 根据uid,start,pageSize查询当前数据集合
    public List<Route> findByPage(int cid, int start, int pageSize);
}
