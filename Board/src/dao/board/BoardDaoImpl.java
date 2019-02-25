package dao.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbutil.DBConn;
import dbutil.Paging;
import dto.board.Board;

public class BoardDaoImpl implements BoardDao {

	private Connection conn = DBConn.getConnection();
	
	private PreparedStatement ps;
	private ResultSet rs;
	
	
	@Override
	public List selectAll() {

		//sql작성
		String sql = "";
		sql+="select * from board";
		sql+=" order by boardno desc";
			
		//쿼리 결과저장할 list
		List<Board> boardList = new ArrayList<>();
		
		
		try {
			//sql 수행
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			//결과처리
			while(rs.next())
			{
				Board board = new Board();
				//ResultSet의 결과 행이 DTO에 하나씩 저장됨
				board.setBoardno(rs.getInt("boardno"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setHit(rs.getInt("hit"));
				board.setWrittendate(rs.getDate("writtendate"));
			
				boardList.add(board);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//--- 자원 해제 ---
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
				//-----------------
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return boardList;
	}

	@Override
	public Board selectBoardByBoardno(Board board) {
		
		//조회쿼리
		String sql ="";
		sql +="select * from board";
		sql +=" where boardno=?";
	
		Board result = new Board(); 
		
		try {

			ps = conn.prepareStatement(sql);
			ps.setInt(1, board.getBoardno());
		
			rs = ps.executeQuery();
						
			while(rs.next())
			{
				board.setBoardno(rs.getInt("boardno"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setHit(rs.getInt("hit"));
				board.setWrittendate(rs.getDate("writtendate"));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//--- 자원 해제 ---
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
				//-----------------
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		
		return result;
	}


	@Override
	public void updateHit(Board board) {
		
		String sql = "";
		sql+="update board";
		sql+=" set hit=hit+1";
		sql+=" where boardno= ?";

		try {

			ps = conn.prepareStatement(sql);
			ps.setInt(1, board.getBoardno());
			
			ps.executeUpdate();
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//--- 자원 해제 ---
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
				//-----------------
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public int selectCntBoard() {

		//sql작성
		String sql = "";
		sql+="select count(*) from board";
			
		//쿼리 결과저장할 변수
		int cnt = 0;
		
		try {
			//sql 수행
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			//결과처리
			rs.next();
			cnt = rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//--- 자원 해제 ---
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
				//-----------------
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//전체 게시글 수 반환
		return cnt;
	}

	@Override
	public List selectPagingList(Paging paging) {
		
		//sql작성
		String sql = "";
		sql+="select * from (";
		sql+=" select rownum rnum, B.* from(";
		sql+=" select * from board ";
		sql+=" order by boardno desc";
		sql+=" ) B";
		sql+=" order by rnum";
		sql+=" ) R";
		sql+=" where rnum between ? and ?";

		
		//쿼리 결과저장할 list
		List<Board> boardList = new ArrayList<>();
				
				
		try {
			//sql 수행
			ps = conn.prepareStatement(sql);
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			rs = ps.executeQuery();
					
			//결과처리
			while(rs.next())
			{
				Board board = new Board();
				
				board.setBoardno(rs.getInt("boardno"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setHit(rs.getInt("hit"));
				board.setWrittendate(rs.getDate("writtendate"));
					
				boardList.add(board);
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//--- 자원 해제 ---
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
				//-----------------
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
			return boardList;
		
	}

	@Override
	public void insert(Board board) {
		String sql = "";
		sql+="insert into board(boardno,title,writer,content,hit)";
		sql+=" values(?, ?, ?, ?, 0)";

		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, board.getBoardno());
			ps.setString(1, board.getTitle());
			ps.setString(2, board.getWriter());
			ps.setString(3, board.getContent());
			
			ps.executeUpdate();
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//--- 자원 해제 ---
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
				//-----------------
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	}
	
}/*

*/