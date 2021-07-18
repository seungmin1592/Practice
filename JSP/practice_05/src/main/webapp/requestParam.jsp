<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String name, id, pw, major, protocol;
	String[] hobby;
%>

<%
	// post 형식에선 인코딩 설정을 해줘야한다.
	request.setCharacterEncoding("UTF-8");

	name = request.getParameter("name");
	id = request.getParameter("id");
	pw = request.getParameter("pw");
	major = request.getParameter("major");
	protocol = request.getParameter("protocol");
	
	// 배열의 데이터 값을 넘기기 위해서 getParameterValues를 사용한다.
	hobby = request.getParameterValues("hobby");
%>

이름 : <%= name %><br>
아이디 : <%= id %><br>
비밀번호 : <%= pw %><br>
취미 : <%= Arrays.toString(hobby) %><br>
전공 : <%= major %><br>
프로토콜 : <%= protocol %><br>

</body>
</html>