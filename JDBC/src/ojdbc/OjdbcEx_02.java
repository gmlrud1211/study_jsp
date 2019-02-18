package ojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OjdbcEx_02 {

	// OJDBC 드라이버
	private static final String DRIVER
		= "oracle.jdbc.driver.OracleDriver";
	
	// DB 연결 정보
	private static final String URL
		= "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USERNAME = "scott";
	private static final String PASSWORD = "tiger";
	
	// OJDBC 이용 객체
	private static Connection conn;	//DB연결객체
	private static Statement st;	//SQL수행객체
	private static ResultSet rs;	//조회결과객체
	
	public static void main(String[] args) {
		//--- 드라이버 로드 ---
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//---------------------
		
		//--- SQL 작성 ---
		String sql1 = "";
		sql1 += "CREATE TABLE userTest (";
		sql1 += " idx NUMBER CONSTRAINT PK_USER_TEST PRIMARY KEY,";
		sql1 += " name VARCHAR2(50) NOT NULL,";
		sql1 += " phone VARCHAR2(30) NOT NULL )";
				
		String sql2 = "";
		sql2 += "CREATE SEQUENCE seq_usertest";
		sql2 += " INCREMENT BY 5";
		sql2 += " START WITH 10";
		//----------------
		
		try {
			//--- DB 연결 ---
			conn = DriverManager.getConnection(
					URL, USERNAME, PASSWORD);
			//---------------
			
			//--- SQL 수행 ---
			st = conn.createStatement(); //SQL수행객체
			
			st.execute(sql1);//CREATE TABLE
			st.execute(sql2);//CREATE SEQUENCE
			//----------------
			
			//--- 결과 처리 ---
			//테이블 생성 확인
			rs = st.executeQuery(
					"SELECT COUNT(*) FROM tabs"
					+ " WHERE table_name=upper('usertest')" );
			rs.next();
			if( rs.getInt(1) > 0 ) {
				System.out.println("테이블 생성 완료");
			} else {
				System.out.println("실패! 테이블 생성 안됨");
			}
			
			//시퀀스 생성 확인
			rs = st.executeQuery(
				"SELECT COUNT(*) FROM user_sequences"
				+ " WHERE sequence_name=upper('seq_usertest')" );
			rs.next();
			if( rs.getInt(1) > 0 ) {
				System.out.println("시퀀스 생성 완료");
			}
			//-----------------
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//--- 자원 해제 ---
				if(rs!=null)	rs.close();
				if(st!=null)	st.close();
				if(conn!=null)	conn.close();
				//-----------------
			} catch (SQLException e) { }
		}
	}
	
}










