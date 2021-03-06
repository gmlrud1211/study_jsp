package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.board.Board;
import dto.member.Member;
import service.board.BoardService;
import service.board.BoardServiceImpl;
import service.member.MemberService;
import service.member.MemberServiceImpl;

@WebServlet("/board/write")
public class BoardWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//로그인 안됬으면 /main으로 리다이렉트
		if(request.getSession().getAttribute("login")==null) {
			response.sendRedirect("/main");
			
			return;
		}
		
		request.getRequestDispatcher("/view/board/write.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[param] "+req.getParameter("title"));
		System.out.println("[param] "+req.getParameter("content"));
		
		
	}
	
	
}
