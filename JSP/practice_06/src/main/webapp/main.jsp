<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>main.jsp페이지입니다.</h1>
	
	<!-- forward 페이지를 입력한 페이지로 넘긴다. url은 해당 페이지 url로 적용되나 내용은 포워딩한 페이지소스로 노출 -->
	<jsp:forward page="sub.jsp"/>
	
</body>
</html>