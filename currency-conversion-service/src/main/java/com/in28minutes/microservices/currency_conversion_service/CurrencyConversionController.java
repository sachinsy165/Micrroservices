package com.in28minutes.microservices.currency_conversion_service;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController  //1st
public class CurrencyConversionController 
{
	@Autowired
 private	CurrencyExchangeServiceProxy  proxy ;
	
	
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")//2nd
	public CurrencyConversionBean convertCurrency(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quantity) 
	{
		
	//	connecting currency conversion service to currency exchange service
		Map<String,String> urivariables=new HashMap<>();//3rd
		urivariables.put("from", from);//4th
		urivariables.put("to", to);//5th
ResponseEntity<CurrencyConversionBean>	responseEntity	=new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class,urivariables);//2nd

		//feign---will help us to call oher microservices very simply with less lines of code.
		//feign---problem1
		CurrencyConversionBean response	  =responseEntity.getBody();//6th
return new CurrencyConversionBean(response.getId(),from,to,response.getConversionMultiple(),quantity,quantity.multiply(response.getConversionMultiple()),response.getPort());//1st
	}
	
	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")//14th
	public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quantity) //15th
	{
		
	 

   CurrencyConversionBean response		 = proxy.retrieveExchangeValue(from, to);
//		CurrencyConversionBean response	  =responseEntity.getBody();//20
   return new CurrencyConversionBean(response.getId(),from,to,response.getConversionMultiple(),quantity,quantity.multiply(response.getConversionMultiple()),response.getPort());//21
	}
	
	

}
