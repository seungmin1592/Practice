<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%!
    	Connection connection;
    	Statement stmt;
    	ResultSet resultSet;
    	
    	String name, id, pw, phone1, phone2, phone3, gender;
    %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	id = (String)session.getAttribute("id");

	String query = "select * from member where id = '" + id + "'";
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr2","1234");
	stmt = connection.createStatement();
	resultSet = stmt.executeQuery(query);
	
	while(resultSet.next()){
		name = resultSet.getString("name");
		id = resultSet.getString("id");
		pw = resultSet.getString("pw");
		phone1 = resultSet.getString("phone1");
		phone2 = resultSet.getString("phone2");
		phone3 = resultSet.getString("phone3");
		gender = resultSet.getString("gender");
		
	}

%>

	<form action="ModifyOk" method="post">
		이름 : <input type="text" name="name" size="10" value=<%=name %>><br>
		아이디 : <%=id %><br>
		비밀번호 : <input type="text" name="pw" size="10"><br>
		전화번호 : <select name="phone1">
					<option value="010">010</option>
					<option value="011">011</option>
					<option value="070">070</option>
					<option value="02">02</option>
				</select>
				<input type="text" name="phone2" size="10" value=<%=phone2 %>>
				<input type="text" name="phone3" size="10" value=<%=phone3 %>><br>
				
		<%
			if(gender.equals("남자")){
				%>
				성별 : <input type="radio" name="gender" value="남자" checked>남자  
					<input type="radio" name="gender" value="여자">여자<br>
				<%
			}else if(gender.equals("여자")){
				%>
				성별 : <input type="radio" name="gender" value="남자" >남자  
						<input type="radio" name="gender" value="여자" checked>여자<br>
				<%
			}
		%>
		
			  <input type="submit" value="정보수정">
			  <input type="reset" value="취소"> 
	
	</form>

</body>
</html>