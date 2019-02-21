package dao.board;

import java.util.List;

import dto.board.Board;

public interface BoardDao {

	
	//게시글 전체 조회
	public List selectAll();
	
	//게시글번호로 게시글 보기
	public Board selectBoardByBoardno(Board board);
	
	//추천수 hit+1
	public void updateHit(Board board);
	
}
