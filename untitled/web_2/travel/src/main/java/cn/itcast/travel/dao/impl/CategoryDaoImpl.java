package cn.itcast.travel.dao.impl;

import cn.itcast.travel.domain.Category;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CategoryDaoImpl implements CategoryDao{
    @Override
    public List<Category> findAll() {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        // 查询SQL
        String sql="select * from tab_category";
        // 直接返回
        return template.query(sql, new BeanPropertyRowMapper<Category>(Category.class));
    }
}
