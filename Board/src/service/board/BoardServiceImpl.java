package service.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.board.BoardDao;
import dao.board.BoardDaoImpl;
import dto.board.Board;

public class BoardServiceImpl implements BoardService{

	private BoardDao boardDao = new BoardDaoImpl();
	
	@Override
	public void getList() {
		boardDao.selectAll();
		
	}

	@Override
	public Board view(Board board) {
		
		boardDao.selectBoardByBoardno(board);
		
		return board;
	}
		
	@Override
	public Board getParam(HttpServletRequest req, HttpServletResponse resp) {
	
		String boardno = (String)req.getParameter("boardno");

		Board board = new Board();
		
		board.setBoardno(Integer.parseInt(boardno));
	
		return board;
	}


	
}
