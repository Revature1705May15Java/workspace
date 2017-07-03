
package com.ex.helloservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface = "com.ex.helloservice.HelloWorld")
public class HelloWorldImpl implements HelloWorld {
	
	@WebMethod 
    public String sayHi(String text) {
		System.out.println(text);
        return "Hello " + text;
        
        
    }
}

