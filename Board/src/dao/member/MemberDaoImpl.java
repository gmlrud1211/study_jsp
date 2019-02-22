package dao.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import dbutil.DBConn;
import dto.board.Board;
import dto.member.Member;

public class MemberDaoImpl implements MemberDao{

	private Connection conn = DBConn.getConnection();
	
	private PreparedStatement ps;
	private ResultSet rs;
	
	
	@Override
	public int selectCntMemberByUserid(Member member) {
		
		
		return 0;
	}

	@Override
	public Member selectMemberByUserid(Member member) {
		
		String sql="";
		sql +="select * from member";
		sql +=" where userid= ?";
		
		Member result = new Member();
		
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.getUserid());
			
			rs = ps.executeQuery();
			
			if(rs.next())
			{
				member.setUserid(rs.getString("userid"));
				member.setUserpw(rs.getString("userpw"));
				member.setUsernick(rs.getString("usernick"));
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
	public void insert(Member member) {
		
		String sql="";
		sql +="insert into member(userid, userpw, usernick)";
		sql +=" values (?,?,?)";

		try {

			ps = conn.prepareStatement(sql);

			ps.setString(1, member.getUserid());
			ps.setString(2, member.getUserpw());
			ps.setString(3, member.getUsernick());
			
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

}
