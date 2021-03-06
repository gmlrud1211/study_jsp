package dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
		private static final String DRIVER
		= "oracle.jdbc.driver.OracleDriver";
	
		// DB 연결 정보
		private static final String URL
			= "jdbc:oracle:thin:@localhost:1521:xe";
		private static final String USERNAME = "scott";
		private static final String PASSWORD = "tiger";
		
		private static Connection conn;	//DB연결객체
		
		//private 생성자
		private DBConn() { }

		//Connection 객체 반환 - Singleton Pattern
		public static Connection getConnection() {
			if(conn==null)
			{
				try {
					Class.forName(DRIVER);
					conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return conn;
		}
}
