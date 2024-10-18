package org.jsp.I18N.controller;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//rest api
@RestController
public class Helloworld_Controller 
{
	private MessageSource messageSource;  //to get the message from the exact location.
	
	
	public Helloworld_Controller(MessageSource messageSource) 
	{
		this. messageSource=messageSource;
	}
	

	
     @GetMapping("/sachin")
	public String helloworldInternationalized() 
	{
    	 //lacale will help us to send the response based upon the regional requests if requests is in the format of english it will help us to send the response in english format.
    	 
    Locale locale	   = LocaleContextHolder.getLocale();//it will help us to identify and formate languages and country and various specific data like dates,times
    	return messageSource.getMessage("good.morning.message", null,"Default Message", locale);
    	 
    	                                                 //in 2nd position if u r having any variable to replace message u can or else leave it as null
//		return "Ice Cream v2";
	}
}
