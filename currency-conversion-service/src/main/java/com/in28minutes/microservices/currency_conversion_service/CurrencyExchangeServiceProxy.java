package com.in28minutes.microservices.currency_conversion_service;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "currency-exchange-service",url = "localhost:8000") //this is used to talk to external microservisec
 
//@FeignClient(name = "currency-exchange-service")
@FeignClient(name = "netflix-zuul-api-gateway-server")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy 
{
	
	 //URI -uniform resource identifier
	 
		  @GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}") //12th
			public CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from,@PathVariable("to") String to); //13
			

			
	

}
