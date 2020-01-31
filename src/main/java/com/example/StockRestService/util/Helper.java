package com.example.StockRestService.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper {


    public static SimpleDateFormat mmddyyyy = new SimpleDateFormat("MM-dd-yyyy");
    public static SimpleDateFormat yyyymmdd = new SimpleDateFormat("yyyy-MM-dd");

    public static Date getDefaultDate() {
        try{
            return mmddyyyy.parse("01-01-1970");
        }
        catch(Exception e){
            return null;
        }
    }

    public static Date get_yyyy_mm_dd(String dateStr){

        try{
            return yyyymmdd.parse(dateStr);
        }
        catch(Exception e){
            return null;
        }
    }
}
