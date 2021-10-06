<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시물 수정하기</h1>
	<a href="javascript:history.back()">뒤로가기</a>
	<form method="post">
		<table>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value="${edit.name }"></td>
			</tr>
			<tr>
				<td>닉네임</td>
				<td><input type="text" name="nickname" value="${edit.nickname }"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><input type="text" name="content" value="${edit.content }"></td>
			</tr>
		</table>
		<input type="hidden" value="${edit.idx }" name="idx">
		<input type="submit">
	</form>
</body>
</html>