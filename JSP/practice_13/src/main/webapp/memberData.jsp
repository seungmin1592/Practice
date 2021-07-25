<%@page import="java.sql.SQLException"%>
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
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String uid = "hr2";
	String upw = "1234";
	
	String sql = "select * from memberforpre";

%>   
   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		try {
	
			Class.forName(driver);
			conn = DriverManager.getConnection(url, uid, upw);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				
				out.println(id+"/"+pw+"/"+name+"/"+phone+"<br>"); 
			}
			
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			try{
				if(rs !=null){
					rs.close();				
				}
				if(stmt != null){
					stmt.close();				
				}
				if(conn != null){
					conn.close();
				}
			} catch(SQLException e1){
				e1.printStackTrace();
			}
		}
	
	
	%>
</body>
</html>