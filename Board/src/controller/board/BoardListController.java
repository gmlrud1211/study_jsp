package controller.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.board.BoardDao;
import dao.board.BoardDaoImpl;
import dbutil.Paging;
import dto.board.Board;
import service.board.BoardService;
import service.board.BoardServiceImpl;

@WebServlet("/board/list")
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoardService boardService = new BoardServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Board 테이블 전체 조회
		List<Board> boardList = boardService.getList();
		
		//view에 전달
		request.setAttribute("boardList", boardList);
		
		//view 지정
		RequestDispatcher rd;
		rd= request.getRequestDispatcher("/view/board/list.jsp");
		rd.forward(request, response);
	
		
	
	}
	

}
