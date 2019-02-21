package controller.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.board.BoardDao;
import dao.board.BoardDaoImpl;
import dto.board.Board;
import service.board.BoardService;
import service.board.BoardServiceImpl;

@WebServlet("/board/view")
public class BoardViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoardService boardService = new BoardServiceImpl();
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//한글 처리 인코딩 설정 (UTF-8)
		request.setCharacterEncoding("utf-8");
		
		//서비스 처리
		Board board = boardService.getParam(request, response);
				
		Board view = boardService.view(board);
		
		request.setAttribute("view", view);
		
		RequestDispatcher rd;
		rd= request.getRequestDispatcher("/view/board/view.jsp");
		rd.forward(request, response);
		
		
		
	
	}

}
