package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import dao.MemberDaoImpl;
import dto.Member;

@WebServlet("/member/join")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MemberDao memberDao = new MemberDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// VIEW 지정
		req.getRequestDispatcher("/view/member/joinForm.jsp")
			.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 요청파라미터 한글 처리 인코딩 설정 (UTF-8)
		req.setCharacterEncoding("utf-8");
		
		// 요청파라미터 받기
		String userid = (String) req.getParameter("userid");
		String nick = (String) req.getParameter("nick");
		String email = (String) req.getParameter("email");
		
		// DTO에 요청파라미터 담기
		Member mem = new Member();
		mem.setUserid(userid);
		mem.setNick(nick);
		mem.setEmail(email);
		
		// DAO를 통한 회원가입(데이터베이스 삽입)
		boolean joinResult = memberDao.join(mem);
		
		// join결과 request에 담기
		//	VIEW에 전달할 MODEL값을 담기
		req.setAttribute("joinResult", joinResult);
		
		// VIEW 지정하기
		req.getRequestDispatcher("/view/member/result.jsp")
			.forward(req, resp);
		
	}
}
















