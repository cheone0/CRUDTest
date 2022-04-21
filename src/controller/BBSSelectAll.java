package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDTO;
import service.BoardDAO;

/**
 * Servlet implementation class BBSInsert
 */
@WebServlet("/bbsSelectAll")
public class BBSSelectAll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		BoardDAO dao = new BoardDAO();
		List<BoardDTO> list = dao.selectAll();
		
		PrintWriter out = response.getWriter();
		String data = "<html><body>";
		data += "<table border=1><tr>";
		data += "<td>번호</td><td>제목</td><td>작성자</td><td>작성일</td><td>삭제하기</td></tr>";
		
		for(int i=0; i < list.size(); i++) {
			
			BoardDTO dto = list.get(i);
			
			int bNo = dto.getbNo();
			String bTitle = dto.getbTitle();
			String bWriter = dto.getbWriter();
			Date bRegDate = dto.getbRegDate();
			
			data += "<tr>";
			data += "<td>" + bNo + "</td>";
			data += "<td>" + bTitle + "</td>";
			data += "<td>" + bWriter + "</td>";
			data += "<td>" + bRegDate + "</td>";
			data += "<td> <a href='delete?delNum="+bNo+ "'>삭제하기</a> </td>";
			data += "</tr>";
		}
		
		data += "</table>";
		data += "<a href=index.jsp>인덱스로 돌아가기</a></body></html>";
		
		out.print(data);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}