package com.in28minutes.microservices.spring_cloud_config_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication//It is used to mark the main class of a Spring Boot application and serves as the entry point for bootstrapping the application. It brings together three important annotations:
public class SpringCloudConfigServerApplication {

	public static void main(String[] args) 
	{
		
		//in spring cloud config server i can do all the application configuration inside this place  that might be limits service and currencyExchangeService and currency calculationservice
		SpringApplication.run(SpringCloudConfigServerApplication.class, args);
	}

}
