package com.in288minutes.microservices.currency_exchange_service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController 
{
	@Autowired//to bring the reference or object of that class
 private Environment environment;//9th Environment is an interface presented inside the org.springframework.core.env
	
	@Autowired
	Exchange_value_repository exValue_repository;//9th
	
  @GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from,@PathVariable String to) //1st
	{
	 ExchangeValue exchangeValue     = new ExchangeValue(1000L, from, to, BigDecimal.valueOf(65));	//3rd
	// exchangeValue.setPort(8000);//8th--hard coding
//	  ExchangeValue exchangeValue 	=exValue_repository.findByFromAndTo(from, to);//12
	 exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));//9th--here iam setting the port number Dynamically
	 return exchangeValue;//7th
	}
}
