package com.in28minutes.microservices.netflix_zuul_api_gateway_server;

 

 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import jakarta.servlet.http.HttpServletRequest;

 

 

 

@Component
public class Zuul_Logging_filter extends ZuulFilter//1st
//
{
	 
  
     private Logger logger=LoggerFactory.getLogger(this.getClass());
     
	     
	
	@Override
	public boolean shouldFilter() {
		 
		return true;//2nd
	}

	@Override
	public Object run() throws ZuulException {
		 
		// 4th i need to log here the details of the request
	 HttpServletRequest request	=(HttpServletRequest) RequestContext.getCurrentContext().getRequest();
	  
		 logger.info("request -> {} request uri -> {}",request,request.getRequestURI());//7th
 
		
		return null;
	}

	@Override
	public String filterType() {
	 
		return "pre";//3rd
	}

	@Override
	public int filterOrder() {
	 
		return 1;//1st
	}

}
