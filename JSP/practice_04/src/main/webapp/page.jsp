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
	<!-- page 지시자 -->
	<!-- Arrays를 import -->
	<%
		int[] arr = {10,20,30};
		out.println(Arrays.toString(arr));
	%>
</body>
</html>