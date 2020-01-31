package com.example.StockRestService.dao;

import java.util.List;
import java.util.Map;

public interface IGenericDao {

    List<Map<String, Object>> getListMap(String sql);

    List<Map<String, Object>> getListMap(String sql, Object... vars);
}
