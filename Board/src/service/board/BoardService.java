package service.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbutil.Paging;
import dto.board.Board;

public interface BoardService {

	//게시글 목록(전체) 조회
	public List getList();
	
	//게시글 조회(+ 조회마다 게시글 조회수 1 up)
	public Board view(Board board);
	
	//요청파라미터 데이터를 객체화해서 반환
	public Board getParam(HttpServletRequest req, HttpServletResponse resp);

	//요청 파라미터에서 curPage반환
	public int getCurPage(HttpServletRequest req);
	
	//총 게시글 수 얻기
	public int getTotalCount();
	
	//페이징 리스트 얻기
	public List getPagingList(Paging paging);

	//게시글 작성
	public Board write(Board board);
	
}
