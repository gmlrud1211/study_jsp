package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.board.Board;
import dto.member.Member;
import service.board.BoardService;
import service.board.BoardServiceImpl;
import service.member.MemberService;
import service.member.MemberServiceImpl;

@WebServlet("/member/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	private MemberService memberservice = new MemberServiceImpl();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/view/member/login.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//한글 인코딩
		request.setCharacterEncoding("utf-8");
		
		//세션객체 얻기(생성)
		HttpSession session = request.getSession(true); //세션이 없으면 새로생성 있으면 이전거 불러옴
				
		
		//요청 파라미터 처리
		String id = request.getParameter("userid");
		String pw = request.getParameter("userpw");
		
		boolean login = true;//로그인 인증값
		
		//멤버 서비스 처리
		Member member = memberservice.getParam(request, response);
		
		Member view = memberservice.getMemberByUserid(member);
		
		request.setAttribute("view", view);
		
		//로그인 인증 처리
		
		if(login) {
			//로그인 성공했을 때 
			request.getSession().setAttribute("login", login);
			request.getSession().setAttribute("userid", id);
		
			response.sendRedirect("/main");	
			
		}else {
			response.sendRedirect("/main");	
		
		}
		
		
		
		
		
		
		
		
	
	}

}
