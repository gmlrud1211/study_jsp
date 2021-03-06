package dao.board;

import java.util.List;

import dbutil.Paging;
import dto.board.Board;

public interface BoardDao {

	
	//게시글 전체 조회
	public List selectAll();
	
	//게시글번호로 게시글 보기
	public Board selectBoardByBoardno(Board board);
	
	//추천수 hit+1
	public void updateHit(Board board);
	
	//총 게시글 수 반환
	public int selectCntBoard();

	//페이징처리된 게시글 목록 조회
	public List selectPagingList(Paging paging);
	
	//게시글 작성
	public void insert(Board board);
	
}
