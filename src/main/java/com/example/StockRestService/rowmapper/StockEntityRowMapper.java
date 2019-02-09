package com.example.StockRestService.rowmapper;

import com.example.StockRestService.entity.StockEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StockEntityRowMapper implements RowMapper<StockEntity> {
    @Override
    public StockEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        StockEntity obj = new StockEntity();
        obj.setStockSymbol(resultSet.getString("stock_symbol"));
        obj.setName(resultSet.getString("name"));
        obj.setIndustry(resultSet.getString("industry"));
        obj.setSector(resultSet.getString("sector"));
        return obj;
    }
}
