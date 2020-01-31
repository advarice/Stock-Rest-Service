package com.example.StockRestService.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;


import java.util.*;

@Repository
public class MacroDaoImpl implements IMacroDao{

    @Autowired
    @Qualifier("getGDPInfo")
    private String getGDPData;

    private JdbcTemplate jdbcTemplate;

    List<String> displayCountryList;

    public MacroDaoImpl(DriverManagerDataSource datasource){

        displayCountryList= Arrays.asList("Australia","Belgium","Canada","Switzerland", "China", "Costa Rica","Cuba", "Germany" ,
                "Denmark" ,"Dominican Republic" ,"Egypt, Arab Rep.","Finland","France","United Kingdom",
                "Greece","Hong Kong SAR, China", "Haiti","Indonesia","India" ,"Ireland", "Iraq","Iran, Islamic Rep.",
                "Iceland", "Israel","Japan", "Mexico", "Malaysia", "New Zealand", "Pakistan","Philippines","Poland",
                "Korea, Dem. People's Rep.","Portugal","Russian Federation", "Saudi Arabia","Singapore","Serbia",
                "Sweden", "Thailand","Turkey", "Ukraine", "United States","Vietnam","South Africa");

        displayCountryList= Arrays.asList("Canada", "China", "Germany" ,
                 "France","United Kingdom"
                ,"Indonesia","India" ,
                 "Japan", "Mexico",
                "Korea, Dem. People's Rep.","Russian Federation", "Singapore",
                  "United States");
        jdbcTemplate=new JdbcTemplate(datasource);
    }



    @Override
    public List<Map<Object,Object>> getCountryGDP() {
        List<Map<Object,Object>>   GDPSeriesList = new ArrayList<>();
        List<Map<String, Object>> gdpData = jdbcTemplate.queryForList(getGDPData);

        for(Map<String, Object> countryGDP: gdpData){

            List<Object> gdpSeries = new ArrayList();
            Map<Object,Object> countryGDPSeries = new HashMap<>();
            if(!displayCountryList.contains(countryGDP.get("country_nm").toString())){
                continue;
            }
            for(int i =1960; i<=2019;i++){
                if(countryGDP.get(String.valueOf(i))==null){

                    gdpSeries.add(null);
                }
                else{
                    try{
                        Double yearGDP = (Double)countryGDP.get(String.valueOf(i));
                        gdpSeries.add(yearGDP);
                    }
                    catch(Exception e){
                        gdpSeries.add(null);
                    }

                }

            }
            countryGDPSeries.put("name",countryGDP.get("country_nm").toString());
            countryGDPSeries.put("data",gdpSeries);
            GDPSeriesList.add(countryGDPSeries);
        }

        return GDPSeriesList;
    }
}
