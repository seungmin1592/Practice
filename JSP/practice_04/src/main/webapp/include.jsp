<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- include 지시자 -->
	<!-- include를 이용해서 다른 페이지의 내용을 가져올 수 있다 -->
	<h1>include.jsp입니다.</h1>
	<%@ include file="include01.jsp" %>
	<h1>include.jsp입니다.</h1>
</body>
</html>