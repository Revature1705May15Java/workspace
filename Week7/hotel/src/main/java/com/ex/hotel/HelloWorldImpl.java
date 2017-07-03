
package com.ex.hotel;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface = "com.ex.hotel.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

	
	/*
	 * WSDL = XML representation of SEI
	 * 
	 * (non-Javadoc)
	 * @see com.ex.hotel.HelloWorld#sayHi(java.lang.String)
	 */
	@WebMethod // ensures that theyll be generated into the WSDL
    public String sayHi(String text) {
		   System.out.println(text);
		return "Hello " + text;
     
    }
}

