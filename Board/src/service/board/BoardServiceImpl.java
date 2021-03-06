package service.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.board.BoardDao;
import dao.board.BoardDaoImpl;
import dbutil.Paging;
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


	@Override
	public int getCurPage(HttpServletRequest req) {
	
		//요청 파라미터 curPage 받기
		String param = req.getParameter("curPage");

		//null이나 ""이 아니면 int리턴
		if(param!=null && !"".equals(param)) {
			int curPage = Integer.parseInt(param);
			return curPage;
		}
		
		//null이나 ""이면 0으로 반환
		return 0;
	}


	@Override
	public int getTotalCount() {
		return boardDao.selectCntBoard();
	}


	@Override
	public List getPagingList(Paging paging) {
			
		return boardDao.selectPagingList(paging);
	}


	@Override
	public Board write(Board board) {
		boardDao.insert(board);
		
		return board;
	}



	
}
