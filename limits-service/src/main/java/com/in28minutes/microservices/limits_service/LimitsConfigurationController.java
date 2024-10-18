package com.in28minutes.microservices.limits_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.microservices.limits_service.bean.LimitConfiguration;

@RestController
public class LimitsConfigurationController //1st
{
	@Autowired
	Configuration configuration;//6
	
	
	@GetMapping("/limits")
public LimitConfiguration retrieveLimitsFromConfigurations() 
{
//	return new LimitConfiguration(1000, 1); //3rd---we are here hard coding the value
	return new LimitConfiguration(configuration.getMaximum(), configuration.getMinimum());
}
}
