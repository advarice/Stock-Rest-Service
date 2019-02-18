package com.example.StockRestService.rowmapper;

import com.example.StockRestService.entity.StockEntity;
import com.example.StockRestService.entity.StockPerformanceEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StockPerformanceRowMapper implements RowMapper<StockPerformanceEntity> {
    @Override
    public StockPerformanceEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        StockPerformanceEntity obj = new StockPerformanceEntity();
        StockEntity stockEntity =new StockEntity();
        stockEntity.setStockSymbol(resultSet.getString("stock_symbol"));
        stockEntity.setName(resultSet.getString("name"));
        stockEntity.setIndustry(resultSet.getString("industry"));
        stockEntity.setSector(resultSet.getString("sector"));
        obj.setStockEntity(stockEntity);
        obj.setStockSymbol(resultSet.getString("stock_symbol"));
        obj.setDay7AvgClose(resultSet.getDouble("day7avgclose"));
        obj.setDay7AvgVolume(resultSet.getDouble("day7avgvolume"));
        obj.setDay30AvgClose(resultSet.getDouble("day30avgclose"));
        obj.setDay30AvgVolume(resultSet.getDouble("day30avgvolume"));
        obj.setDay60AvgClose(resultSet.getDouble("day60avgclose"));
        obj.setDay60AvgVolume(resultSet.getDouble("day60avgvolume"));
        obj.setDay90AvgClose(resultSet.getDouble("day90avgclose"));
        obj.setDay90AvgVolume(resultSet.getDouble("day90avgvolume"));
        obj.setCurrentClose(resultSet.getDouble("currentClose"));
        obj.setCurrentVolume(resultSet.getDouble("currentVolume"));
        return obj;
    }
}
