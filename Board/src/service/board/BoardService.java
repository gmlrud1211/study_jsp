package service.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.board.Board;

public interface BoardService {

	
	public void getList();
	
	public Board view(Board board);

	public Board getParam(HttpServletRequest req, HttpServletResponse resp);
	
}
