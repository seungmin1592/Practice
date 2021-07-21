package com.ex;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;

@WebServlet("/ModifyOk")
public class ModifyOk extends HttpServlet{
	private Connection connection;
	private Statement stmt;
	private ResultSet resultSet;
	private HttpSession httpSession;
	private String name, id, pw, phone1, phone2, phone3, gender;
	
	public ModifyOk() {
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		httpSession = request.getSession();
		
		name = request.getParameter("name");
		 id = (String)httpSession.getAttribute("id");
		pw = request.getParameter("pw");
		phone1 = request.getParameter("phone1");
		phone2 = request.getParameter("phone2");
		phone3 = request.getParameter("phone3");
		gender = request.getParameter("gender");
		
		
		if(pwConfirm()) {
			System.out.println("OK");
			
			String query = "UPDATE member SET NAME='" + name + "', PHONE1='" + phone1 + "', PHONE2='" + phone2 + "', PHONE3='" + phone3 + "', GENDER='" + gender + "' WHERE ID='" + id + "'";  
			
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr2","1234");
				stmt = connection.createStatement();
				int i = stmt.executeUpdate(query);
				if(i == 1) {
					System.out.println("update success");
					httpSession.setAttribute(name, "name");
					response.sendRedirect("modifyResult.jsp");
				} else {
					System.out.println("update fail");
					response.sendRedirect("modify.jsp");
				}
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if(stmt != null) {
						stmt.close();
					}
					if(connection != null) {
						connection.close();
					}
				} catch(Exception e) {
					e.printStackTrace();
				}
			} 
		} else {
			System.out.println("NG"); 
		}
	}
	
	private boolean pwConfirm() {
		boolean rs = false;
		
		String sessionPw = (String)httpSession.getAttribute("pw");
		if(sessionPw.equals(pw)) {
			rs = true;
		} else {
			rs = false;
		}
		
		return rs;
		
	}
}
