<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Connection conn = null;
    	Statement stmt = null;
    	ResultSet rs = null;
    	
    	String name, id, pw, phone1,phone2,phone3,gender;
    	
    %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		id = (String) session.getAttribute("id");
	
		String sql = "select * from member where id = " + id;
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
	
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr2", "1234");
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		
		while(rs.next()){
			name = rs.getString("name");
			pw = rs.getString("pw");
			phone1 = rs.getString("phone1");
			phone2 = rs.getString("phone2");
			phone3 = rs.getString("phone3");
			gender = rs.getString("gender");
		}
		
	%>
	
	<form action="modifyedit" method="post">
		<div>
			아이디 : <%=id %>
		</div>
		<div>
			비밀번호 : <input type="text" name="pw">
		</div>
		<div>
			전화번호 : <input type="text" name="phone1" value="<%=phone1 %>"> - 
			<input type="text" name="phone2" value="<%= phone2 %>"> - 
			<input type="text" name="phone3" value="<%= phone3 %>">
		</div>
		<div>
			성별 : 
			<%
				if(gender.equals("남자")){
					%>
					<input type="radio" name="gender" value="남자" checked>
					<input type="radio" name="gender" value="여자">
					<%
				} else {
					%>
					<input type="radio" name="gender" value="남자">
					<input type="radio" name="gender" value="여자" checked>
					<%
				}
			%>
		</div>
		
		<input type="submit">
		
	
	</form>
</body>
</html>