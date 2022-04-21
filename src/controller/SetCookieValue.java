package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/set")
public class SetCookieValue extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8");
		Cookie c = new Cookie("name", "tester");
		c.setMaxAge(60*60*24);
		response.addCookie(c);
		
		Cookie addr = new Cookie("address", "대구");
		addr.setMaxAge(60);
		response.addCookie(addr);
		
		PrintWriter out = response.getWriter();
		out.print("쿠키 저장 완료");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}