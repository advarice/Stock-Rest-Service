package com.example.StockRestService.rowmapper;

import com.example.StockRestService.entity.StockEntity;
import com.example.StockRestService.entity.StockStartEndPriceEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StockStartEndPriceEntityRowMapper implements RowMapper<StockStartEndPriceEntity> {
    @Override
    public StockStartEndPriceEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        StockStartEndPriceEntity obj = new StockStartEndPriceEntity();
        obj.setStockSymbol(resultSet.getString("stock_symbol"));
        obj.setStartDate(resultSet.getDate("start"));
        obj.setEndDate(resultSet.getDate("end"));
        obj.setStartPrice(resultSet.getDouble("start_price"));
        obj.setEndPrice(resultSet.getDouble("start_price"));
        return obj;
    }
}
