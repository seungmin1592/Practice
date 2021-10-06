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
	<h1>게시판 리스트</h1>
	<a href="javascript:history.back()">뒤로가기</a>
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
					<td><a href="<c:url value="/board/edit?idx=${list.idx}"/>">수정</a></td>
					<td><a href="<c:url value="/board/delete?idx=${list.idx}"/>">삭제</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>