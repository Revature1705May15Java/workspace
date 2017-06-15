package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjaxGetJsonServlet
 */
//@WebServlet("/AjaxGetJsonServlet")
public class AjaxGetJsonServlet extends HttpServlet {

	/**
   * 
   */
  private static final long serialVersionUID = 267414056204917990L;

  /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  response.setContentType("application/json");
	  PrintWriter out = response.getWriter();
	  String json = "{\"name\":\"Guy\",\"age\":20}";
	  out.write(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  doGet(request, response);
	}

}
