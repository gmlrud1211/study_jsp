package session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/session/create")
public class SessionCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//세션객체 얻기(생성)
		HttpSession session = request.getSession(true); //세션이 없으면 새로생성 있으면 이전거 불러옴
		
		//세션정보 추가
		session.setAttribute("test", "hahaha");
		
		//view지정, 포워딩
		request.getRequestDispatcher("/session/create.jsp").forward(request, response);

		
		
	
	}

}
