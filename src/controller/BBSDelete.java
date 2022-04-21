package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardDAO;

/**
 * Servlet implementation class BBSInsert
 */
@WebServlet("/delete")
public class BBSDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String bNo = request.getParameter("delNum");
		System.out.println("bNo 값 확인 : " + bNo);
		
		BoardDAO dao = new BoardDAO();
		dao.delete(bNo);
		
		PrintWriter out = response.getWriter();
		String data = "<html><body><h1>게시글 삭제 완료</h1>"
				+ "<a href=index.jsp>인덱스로 돌아가기</a>"
				+ "</body></html>";
		out.print(data);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}