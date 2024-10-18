package org.jsp.I18N.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController 
{

	//why filtering in microservices: if i want to hide or ignore the data to show it in postman or front end from rest api--i will go for filtering
	//1)static filtering:here if i want to hide password field it will be applicable for all the rest apis like user api and users api both
	//it means if i hide field2(password) that field2 will get hide in both the rest apis
	
	//2)dynamic filtering:in dynamic filtering i can make different significant  changes in rest apis individually
	//for example if i want to hide password field from 1st rest api inside sinle bean i can hide
	//if i want to hide mobile number field from 1st rest api inside sinle bean i can hide
	
	//some of the importatnt annotations in filtering
	//1--@JsonIgnore--it will help us to ignore particular field
	//2--@JsonIgnoreProperties({"field1","field2"})//it will help us to ignore multiple fields.
	//@JsonFilter
	
	@GetMapping("/filtering")
	public MappingJacksonValue filtering() 
	{
	 
	SomeBean someBean	 =new SomeBean("Value1","Value2","Value3");
		MappingJacksonValue mappingjacksonvalue=new MappingJacksonValue(someBean);//4 //this class is helping us for dynamic fitering
//		return new SomeBean("Value1","Value2","Value3");//1st waystatic filtering
		
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3");
		FilterProvider filters=new SimpleFilterProvider().addFilter("Sachin", filter);
		mappingjacksonvalue.setFilters(filters);
		
		
		return mappingjacksonvalue;
	}
	
	@GetMapping("/filtering-list")   //3rd
	public   MappingJacksonValue   filteringList() 
	{
//		return   Arrays.asList( new SomeBean("Value1","Value2","Value3"),new SomeBean("Value4","Value5","Value6"));---static filtering
	
	List<SomeBean>	someBeans=  Arrays.asList( new SomeBean("Value1","Value2","Value3"),new SomeBean("Value4","Value5","Value6"));
    MappingJacksonValue mappingJacksonValue	=new MappingJacksonValue(someBeans);
    SimpleBeanPropertyFilter filter   = SimpleBeanPropertyFilter.filterOutAllExcept("field2","field3");
    
   FilterProvider filters    = new SimpleFilterProvider().addFilter("Sachin", filter);
	mappingJacksonValue.setFilters(filters);
	
	return mappingJacksonValue;
	}
}
