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
		
	}

	@Override
	public Board view(Board board) {
		
		
		return null;
	}
		
	@Override
	public Board getParam(HttpServletRequest req, HttpServletResponse resp) {
	
		
		return null;
	}


	
}
