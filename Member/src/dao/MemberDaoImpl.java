package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbutil.DBConn;
import dto.Member;

public class MemberDaoImpl implements MemberDao {

	private Connection conn = DBConn.getConnection(); 

	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public boolean join(Member mem) {

		//기존 회원 체크
		// 데이터베이스에 이미 존재하는 userid일 경우
		// false를 return하며 처리 중단
		String countSql = "";
		countSql+="SELECT COUNT(*) FROM member";
		countSql+=" WHERE userid=?";
		
		try {
			ps = conn.prepareStatement(countSql);
			
			//조회할 ID 지정
			ps.setString(1, mem.getUserid());
			
			//SELECT 수행
			rs = ps.executeQuery();
			
			//SELECT 결과 처리
			rs.next();
			
			int cnt = rs.getInt(1);

			//이미 존재하는 아이디로 회원가입 시도한 경우
			//	return false로 회원가입절차를 중단하고
			//	회원가입 실패를 알림
			if(cnt>0) {
//				System.out.println("DAO - 회원가입 수행 전 중복");
				return false;
			} 
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
//		System.out.println("DAO - 중복검사 성공");
		//------------------------------------------------
		
		//회원가입 쿼리
		String sql = "";
		sql+="INSERT INTO member ( userid, nick, email )";
		sql+=" VALUES ( ?, ?, ? )";
		
		try {
			ps = conn.prepareStatement(sql);
			
			//삽입할 내용 지정
			ps.setString(1, mem.getUserid());
			ps.setString(2, mem.getNick());
			ps.setString(3, mem.getEmail());

			// INSERT 쿼리 수행
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

//		System.out.println("DAO - 회원가입 수행 후");
		//------------------------------------------------
		
		//회원가입 체크
		// 회원가입 이후 userid가 존재하는지 확인
		String checkSql = "";
		checkSql+="SELECT COUNT(*) FROM member";
		checkSql+=" WHERE userid=?";
		
		try {
			ps = conn.prepareStatement(countSql);
			
			//조회할 ID 지정
			ps.setString(1, mem.getUserid());
			
			//SELECT 수행
			rs = ps.executeQuery();
			
			//SELECT 결과 처리
			rs.next();
			
			int cnt = rs.getInt(1);

			//회원가입 이후 count가 0이면 회원가입 실패
			if(cnt==0) {
//				System.out.println("DAO - 회원가입 수행 후 실패");
				return false;
			} 
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		
		// 모든 절차를 정상적으로 완료하면 회원가입 성공
//		System.out.println("DAO - 회원가입 성공");
		return true;
	}

}





