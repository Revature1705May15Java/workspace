package com.ex.HelloConsumer;

import com.ex.helloservice.HelloWorld;
import com.ex.helloservice.HelloWorldImplService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        HelloWorld hello = new HelloWorldImplService().getHelloWorldImplPort();
        
        hello.sayHi("We are super excited.");
    }
}
