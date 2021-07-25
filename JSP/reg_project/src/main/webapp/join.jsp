<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
	<form action="JoinOk" method="post">
		<div>
			이름 : 
			<input type="text" name="name">
		</div>
		<div>
			아이디 : 
			<input type="text" name="id">
		</div>
		<div>
			비밀번호 : 
			<input type="text" name="pw">
		</div>
		<div>
			전화번호 : 
			<select name="phone1">
				<option>010</option>
				<option>011</option>
				<option>02</option>
			</select> -
			<input type="text" name="phone2"> -
			<input type="text" name="phone3">
		</div>
		<div>
			성별 : 
			<input type="radio" name="gender" value="남자">남자
			<input type="radio" name="gender" value="여자">여자
		</div>
		<input type="submit" value="회원가입">
	
	</form>
</body>
</html>