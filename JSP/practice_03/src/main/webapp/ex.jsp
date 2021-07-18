<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- jsp 선언문 -->
	<%!
		int i = 10;
		String str = "ABCEDF";
	%>
	
	<!-- jsp 스크립트릿문 -->
	<%
		out.println("i = " + i + "<br>");
		out.println("str = " + str);
	%>
	
	<!-- jsp 표현식 -->
	i = <%= i%><br>
	str = <%= str%><br>
</body>
</html>