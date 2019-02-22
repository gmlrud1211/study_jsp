package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.member.MemberDao;
import dao.member.MemberDaoImpl;
import dto.member.Member;
import service.board.BoardService;
import service.board.BoardServiceImpl;
import service.member.MemberService;
import service.member.MemberServiceImpl;


@WebServlet("/member/join")
public class MemberJoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	private MemberService memberService = new MemberServiceImpl();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/view/member/join.jsp").forward(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		//한글 인코딩
		req.setCharacterEncoding("utf-8");
	
		//요청 파라미터
		Member member = memberService.getParam(req, resp);
		
		//회원가입
		memberService.join(member);
			
		
		resp.sendRedirect("/main");
		
		
	}
	
}
