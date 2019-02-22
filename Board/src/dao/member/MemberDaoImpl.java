package dao.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dbutil.DBConn;
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
		return null;
	}

	@Override
	public void insert(Member member) {
		
		String sql="";
		sql +="insert into member(userid, userpw, usernick)";
		sql +=" values=(?,?,?)";
		
		
		
	}

}
