package service.board;

import java.sql.Date;

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
		String title = (String)req.getParameter("title");
		String writer = (String)req.getParameter("writer");
		String content = (String)req.getParameter("content");
		String hit = (String)req.getParameter("hit");
		String writtendate =(String) req.getParameter("writtendate");
		
		Board board = new Board();
		
		board.setBoardno(Integer.parseInt(boardno));
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		/*board.setHit(Integer.parseInt(hit));
		System.out.println(hit);
		board.setWrittendate(Date.);
		*/
		
		return board;
	}


	
}
