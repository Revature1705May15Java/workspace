package com.serv.filters;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/*
 * a filter is a class that implements the 
 * javax.servlet.Filter interface
 * the interface defines the following methods
 * that we will define
 */
public class LogFilter implements Filter{

	/*
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 * Called by the web container to indicate that
	 * a filter is being placed into service
	 */
	@Override
	public void init(FilterConfig config) throws ServletException {
		//Get init param
		String testParam = config.getInitParameter("test-param");
		
		//Print out the init parameter
		System.out.println("Test Param: " + testParam);
	}
	
	/*
	 * (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 * called by the container each time a request/response
	 * pair is passed through the chain due to 
	 * a client request for a resource at the 
	 * end of the chain
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		//Get the IP address of client machine
		String ipAddress = request.getRemoteAddr();
		
		//Log the IP address and current timestamp
		System.out.println("IP " + ipAddress + ", Time " + new java.util.Date().toString());
		
		//Pass request back down the filter chain
		chain.doFilter(request, response);
		
		
	}

	
	/*
	 * @see javax.servlet.Filter#destroy()
	 * Called by the web container to indicate that
	 * a filter is being taken out of service
	 */
	@Override
	public void destroy() {
		//called before filter instance is removed
		
	}


	

}
