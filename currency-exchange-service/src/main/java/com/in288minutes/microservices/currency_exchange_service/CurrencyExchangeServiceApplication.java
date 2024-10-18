package com.in288minutes.microservices.currency_exchange_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CurrencyExchangeServiceApplication {

	public static void main(String[] args) 
	{
		//some of the standards port number for currency exchange Service are 8000,8001,8002
		SpringApplication.run(CurrencyExchangeServiceApplication.class, args);
	}

}
