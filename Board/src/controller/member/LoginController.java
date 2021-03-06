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

	private MemberService memberService = new MemberServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/view/member/login.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//한글 인코딩
		request.setCharacterEncoding("utf-8");
		
		//요청 파라미터 처리
		Member member = memberService.getParam(request, response);
		
		boolean login = memberService.login(member); //로그인 인증

		//정보 저장
		request.getSession().setAttribute("login", login);
		request.getSession().setAttribute("writer", member.getUserid());
		request.getSession().setAttribute("nick", member.getUsernick());
		
		
		response.sendRedirect("/main");	
			
	
	}

}
