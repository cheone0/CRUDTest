<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공</title>
</head>
<body>
	
	<%= session.getAttribute("user_id") %>
	
	님 환영합니다.

	로그인 성공 <br>
	<a href="index.jsp">홈으로 돌아가기</a>

</body>
</html>