package com.example.StockRestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class StockRestServiceApplication {


	public static void main(String[] args) {
		SpringApplication.run(StockRestServiceApplication.class, args);
	}

}

