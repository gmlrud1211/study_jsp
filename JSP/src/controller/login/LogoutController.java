package controller.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login/logout")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//세션 객체 얻어오기
		HttpSession session = request.getSession(true);
			
		//세션 정보 삭제하기
		session.invalidate(); //로그아웃기능때 사용
				
		// /session/view로 리다이렉트
		response.sendRedirect("/login/login");
				
	
	
	}


}
