package com.ex.expedia;

import com.ex.hotel.HelloWorld;
import com.ex.hotel.HelloWorldImplService;

public class SOAPConsumer {

	public static void main(String[] args) {
		HelloWorld sei = new HelloWorldImplService().getHelloWorldImplPort(); //service locator
		sei.sayHi("");
	
	}
	
}
