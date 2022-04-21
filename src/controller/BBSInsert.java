package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardDAO;

/**
 * Servlet implementation class BBSInsert
 */
@WebServlet("/insert")
public class BBSInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		String bWriter = request.getParameter("bWriter");
		
		System.out.println("제목 : " + bTitle);
		System.out.println("내용 : " + bContent);
		System.out.println("작성자 : " + bWriter);
		
		BoardDAO dao = new BoardDAO();
		dao.insert(bTitle, bContent, bWriter);
		
		//진화하기 전 원시인 단계
//		PrintWriter out = response.getWriter();
//		String data = "<html><body><h1>게시글 삭제 완료</h1>"
//				+ "<a href=index.jsp>인덱스로 돌아가기</a>"
//				+ "</body></html>";
//		out.print(data);
		
		//진화 단계(redirect 방법)		
		//response.sendRedirect("insertResult.jsp");
//		request.setAttribute("name", "민니");
//		response.sendRedirect("insertResultToServlet");
		
		//진화 단계(location 방법)
//		PrintWriter out = response.getWriter();
//		String data = "<script> location.href = 'insertResult.jsp' </script>";
//		out.print(data);
		
		//진화 단계(dispatch 방법)
//		RequestDispatcher rd = request.getRequestDispatcher("insertResultToServlet?name=lee");
//		rd.forward(request, response);
		request.setAttribute("name", "민니");
		RequestDispatcher rd = request.getRequestDispatcher("insertResultToServlet");
		rd.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}