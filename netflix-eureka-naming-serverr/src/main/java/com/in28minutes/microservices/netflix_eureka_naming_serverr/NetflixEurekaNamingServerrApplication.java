package com.in28minutes.microservices.netflix_eureka_naming_serverr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //1st
public class NetflixEurekaNamingServerrApplication 
{

	public static void main(String[] args) {
		SpringApplication.run(NetflixEurekaNamingServerrApplication.class, args);
	}

}
