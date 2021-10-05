<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="edit" method="post">
		<table>
		 <tbody>
		 	<tr>
		 		<td>이름</td>
		 		<td><input type="text" name="name" value="${edit.name }"></td>
		 	</tr>
		 	<tr>
		 		<td>닉네임</td>
		 		<td><input type="text" name="nickname" value="${edit.nickname}"></td>
		 	</tr>
		 	<tr>
		 		<td>내용</td>
		 		<td><textarea name="content" value="${edit.content }"></textarea></td>
		 	</tr>
		 </tbody>
		
		</table>
		<input type="hidden" name="idx" value="${edit.idx }">
		<input type="submit">
	</form>
	  
</body>
</html>