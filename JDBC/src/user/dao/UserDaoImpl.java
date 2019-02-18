package user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import user.dto.User;

public class UserDaoImpl implements UserDao {

	// DB 연결 정보
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USERNAME = "scott";
	private static final String PASSWORD = "tiger";

	// DB 연결 객체
	private static Connection conn = null; //연결객체
	
	// JDBC 객체
	private PreparedStatement ps;
	private ResultSet rs;
	
	public UserDaoImpl() {
		try {
			// 드라이버 로드
			Class.forName(DRIVER);
			
			// 연결객체 생성
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			// 오토커밋 설정 (기본값:true)
			conn.setAutoCommit(false);			

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<User> selectAll() {
		
		String sql = "SELECT * FROM userTest"
				+ " ORDER BY idx";
		
		List<User> userList = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				User u = new User();
				
				u.setIdx( rs.getInt("idx") );
				u.setUserId( rs.getString("userId") );
				u.setName( rs.getString("name") );
				
				userList.add(u);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return userList;
	}

	@Override
	public User selectByIdx(int idx) {
		
		String sql = "SELECT * FROM userTest"
				+ " WHERE idx=?"
				+ " ORDER BY idx";
		
		User user = new User();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idx);
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				user.setIdx( rs.getInt("idx") );
				user.setUserId( rs.getString("userId") );
				user.setName( rs.getString("name") );
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return user;
	}

	@Override
	public void insertUser(User insertUser) {
		
		String sql = "INSERT INTO userTest (idx, userid, name)"
				+ " VALUES ( userTest_SQ.nextval, ?, ? )";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, insertUser.getUserId());
			ps.setString(2, insertUser.getName());
			
			ps.executeUpdate();
			
			conn.commit(); // 명시적으로 커밋하기
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			try {
				conn.rollback(); //예외 발생 시 롤백
			} catch (SQLException e1) {
				e1.printStackTrace();
			} 
			
		} finally {
			try {
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deleteByIdx(int idx) {
		
		String sql = "DELETE userTest"
				+ " WHERE idx=?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idx);
			
			ps.executeUpdate();
			
			conn.commit(); // 커밋
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			try {
				conn.rollback(); // 롤백
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		} finally {
			try {
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}