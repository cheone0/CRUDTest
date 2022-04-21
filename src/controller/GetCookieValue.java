package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/get")
public class GetCookieValue extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset = utf-8");
		Cookie[] allValues = request.getCookies();
		PrintWriter out = response.getWriter();
		
		for(int i=0; i<allValues.length; i++) {
			if(allValues[i].getName().equals("name")) {
				out.print("<h1>"+ allValues[i].getValue() +"</h1>");
			}
			
			if(allValues[i].getName().equals("address")) {
				out.print("<h1>"+ allValues[i].getValue() +"</h1>");
			}
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}