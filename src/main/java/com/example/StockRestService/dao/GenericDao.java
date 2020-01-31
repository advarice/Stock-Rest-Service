package com.example.StockRestService.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class GenericDao implements IGenericDao{

    private JdbcTemplate jdbcTemplate;

    public GenericDao(@Qualifier("fdeDataSource") DriverManagerDataSource datasource){
        jdbcTemplate=new JdbcTemplate(datasource);
    }

    @Override
    public List<Map<String, Object>> getListMap(String sql) {
        return jdbcTemplate.queryForList(sql);
    }

    @Override
    public List<Map<String, Object>> getListMap(String sql, Object... vars) {

        return jdbcTemplate.queryForList(sql,vars);
    }


}
