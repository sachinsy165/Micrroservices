package org.jsp.I18N.versioning;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class VersioningpersonController 
{
	@GetMapping("/v1/person")//uri or url versioning
	public PersonV1 getfirstVersionOfPerson( ) 
	{
		 return new PersonV1("Bob  Charlie");
	}
	
	@GetMapping("/v2/person")//uri or url versioning
	public PersonV2 getSecondVersionOfPerson( ) 
	{
		 return new PersonV2(new Name("sachin", "Java"));
	}

	@GetMapping(path = "/person",params = "version=1")//request parameter versioning
	public PersonV1 getfirstVersionOfPersonRequestParameter( ) 
	{
		 return new PersonV1("Bob  Charlie");
	}
	
	@GetMapping(path = "/person",params = "version=2")//request parameter versioning
	public PersonV2 getSecondVersionOfPersonRequestParameter( ) 
	{
		 return new PersonV2(new Name("sachin", "Java"));
	}
	
	@GetMapping(path = "/person/header",headers = "X-API-VERSION=1")//    request Header  versioning
	public PersonV1 getfirstVersionOfPersonRequestHeader( ) 
	{
		 return new PersonV1("Bob  Charlie");
	}
	
	@GetMapping(path = "/person/header",headers = "X-API-VERSION=2")//    request Header  versioning
	public PersonV2 getsecondVersionOfPersonRequestHeader( ) 
	{
		 return new PersonV2(new Name("sachin", "Java"));
	}
	
	 
	@GetMapping(path = "/person/accept",produces = "application/vnd.company.app-v1+json")//     //accept header versioning
	public PersonV1 getfirstVersionOfPersonAcceptHeader( ) 
	{
		 return new PersonV1("Bob  Charlie");
	}
	
	@GetMapping(path = "/person/accept",produces = "application/vnd.company.app-v2+json")//     //accept header versioning
	public PersonV2 getsecondVersionOfPersonAcceptHeader( ) 
	{
		 return new PersonV2(new Name("sachin", "Java"));
	}
}
