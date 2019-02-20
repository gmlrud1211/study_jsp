package controller.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		//view지정, 포워딩
		request.getRequestDispatcher("/view/login/loginForm.jsp").forward(request, response);

	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//세션객체 얻기(생성)
		HttpSession session = req.getSession(true); //세션이 없으면 새로생성 있으면 이전거 불러옴
		
		
		String users = "abc";
		String passwds = "123";
		
		String id = req.getParameter("userId");
		String pw = req.getParameter("userPw");
		
		
			if(users.equals(id) && passwds.equals(pw)) {
				session.setAttribute("login", true);
				session.setAttribute("userId", id);
				//session.setAttribute("userPw", pw); 비밀번호는 남기면 안됨
				req.getRequestDispatcher("/view/login/loginSuccess.jsp").forward(req, resp);							
				session.setMaxInactiveInterval(0);
				
				return;
			}
			
		req.getRequestDispatcher("/view/login/loginFail.jsp").forward(req, resp);
		

	}
	
}
