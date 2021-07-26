

import java.io.IOException;

import javax.print.attribute.standard.RequestingUserName;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/calc")
public class Calc extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		
		String op = request.getParameter("operator");
		
		System.out.println(op);
		
		int result = 0;
		
		if(op.equals("덧셈")) {
			result = x + y;
		} else { 
			result = x - y;
		}
		
		response.getWriter().printf("result is %d \n zzz",result);
	}
	


}
