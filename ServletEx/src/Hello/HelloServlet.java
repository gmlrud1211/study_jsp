package Hello;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("요청URI : "+req.getRequestURI());
		
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().println("hello servlet");
		resp.getWriter().println("<h1>hi servlet</h1>");
		
		
	}

	
}