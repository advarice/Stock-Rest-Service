package com.example.StockRestService.rowmapper;

import com.example.StockRestService.entity.StockEntity;
import com.example.StockRestService.entity.earning.Earning;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@Slf4j
public class EarningRowMapper implements RowMapper<Earning> {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Earning mapRow(ResultSet resultSet, int i) throws SQLException {
        Earning obj = new Earning();

        try {
            objectMapper.readValue(resultSet.getString("data"),Earning.class);
        } catch (IOException e) {
            log.error("Error coverting earning data to java object");
            return null;
        }

/*        obj.setStockSymbol(resultSet.getString("stock_symbol"));
        obj.setName(resultSet.getString("name"));
        obj.setIndustry(resultSet.getString("industry"));
        obj.setSector(resultSet.getString("sector"));*/
        return obj;
    }
}
