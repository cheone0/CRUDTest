<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대문페이지입니다.</title>
</head>
<body>

<%= session.getAttribute("user_id") %>님 환영합니다.<br>

	<a href="bbsSelectAll">게시판 보러가기</a><br>
	<a href="bbsInsert.jsp">게시판 등록하기</a><br>
	<a href="set">쿠키 설정하기</a><br>
	<a href="get">쿠키값 확인하기</a><br>
	<a href="sess">세션 설정하기</a><br>
	<a href="login.jsp">로그인하러가기</a><br>
	<a href="logOut">로그아웃</a><br>
</body>
</html>