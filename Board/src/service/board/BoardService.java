package service.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.board.Board;

public interface BoardService {

	//게시글 목록(전체) 조회
	public List getList();
	
	//게시글 조회(+ 조회마다 게시글 조회수 1 up)
	public Board view(Board board);
	
	//요청파라미터 데이터를 객체화해서 반환
	public Board getParam(HttpServletRequest req, HttpServletResponse resp);
	
}
