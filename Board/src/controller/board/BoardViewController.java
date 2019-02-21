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

@WebServlet("/board/view")
public class BoardViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoardDao boardDao = new BoardDaoImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String boardno = request.getParameter("boardno");
		
		Board board = new Board();
		board.setBoardno(Integer.parseInt(boardno));
		
		Board result = boardDao.selectBoardByBoardno(board);
		System.out.println(result);
		
		request.setAttribute("result", result);
		
		RequestDispatcher rd;
		rd= request.getRequestDispatcher("/view/board/view.jsp");
		rd.forward(request, response);
		
		
		
	
	}

}
