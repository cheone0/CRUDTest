package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberDAO;

/**
 * Servlet implementation class LoginProcess
 */
@WebServlet("/loginProcess")
public class LoginProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String userID = request.getParameter("userID");
		String userPW = request.getParameter("userPW");
		
		System.out.println("입력받은 ID 값 : " + userID);
		System.out.println("입력받은 PW 값 : " + userPW);
		
		MemberDAO dao = new MemberDAO();
		boolean resultLogin = dao.login(userID,userPW);
		
		if(resultLogin) {
			HttpSession sess = request.getSession();
			sess.setAttribute("user_id", userID);
			RequestDispatcher rd = request.getRequestDispatcher("loginSuccess.jsp");
			rd.forward(request, response);
			
		}else {
			response.sendRedirect("loginFail.jsp");
		}
		
	}

}