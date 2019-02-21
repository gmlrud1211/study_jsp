package dao.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbutil.DBConn;
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
		sql+=" order by boardno";
			
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
		
	}


	

	
}
