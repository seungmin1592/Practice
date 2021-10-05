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
	<table>
	 <thead>
	  <tr>
	   <th>번호</th>
	   <th>이름</th>
	   <th>닉네임</th>
	   <th>내용</th>
	  </tr>
	 </thead>
	 
	 <tbody>
	 	<c:forEach items="${list}" var="list">
		 	<tr>
			 	<td>${list.idx}</td>
			 	<td>${list.name}</td>
			 	<td>${list.nickname}</td>
			 	<td>${list.content}</td>
			 	<td><a href="/board/edit?idx=${list.idx}">수정</a></td>
			 	<td><a href="/board/delete?idx=${list.idx}">삭제</a></td>
		 	</tr>
	 	</c:forEach>
	 </tbody>
	
	</table>
	  
</body>
</html>