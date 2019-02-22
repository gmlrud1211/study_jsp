package service.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.board.BoardDao;
import dao.board.BoardDaoImpl;
import dto.board.Board;

public class BoardServiceImpl implements BoardService{

	private BoardDao boardDao = new BoardDaoImpl();
	
	@Override
	public List getList() {

		//board전제 조회결과 반환
		return boardDao.selectAll();
		
	}


	@Override
	public Board view(Board board) {
		
		//조회수 증가
		boardDao.updateHit(board);
		//게시글 반환
		boardDao.selectBoardByBoardno(board);
		
		return board;
	}
		
	@Override
	public Board getParam(HttpServletRequest req, HttpServletResponse resp) {
	
		//요청파라미터 정보 저장할 DTO
		Board board = new Board();
		
		//요청 파라미터 받음
		String boardno = (String)req.getParameter("boardno");

		//DTO에 저장
		board.setBoardno(Integer.parseInt(boardno));
	
		//요청 파라미터 객체로 변환된 DTO에 변환
		return board;
	}



	
}
