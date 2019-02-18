package ojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OjdbcEx_01 {
	public static void main(String[] args) {
		
		// 1. JDBC 드라이버 로드 ( ojdbc6.jar )
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// OJDBC 사용에 필요한 변수들
		Connection conn = null;	//DB연결 객체
		Statement st = null;	//SQL문 수행 객체
		ResultSet rs = null;	//조회결과 반환 객체
		
		try {
			// 2. DB 연결 (Connection)
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe"
					, "scott"
					, "tiger");
			
			// 3. SQL 쿼리 수행 (Statement, PreparedStatement)
			//3-1. SQL 수행 객체 생성
			st = conn.createStatement();
			
			//3-2. SQL 수행 및 결과 반환
			String sql = "SELECT * FROM emp ORDER BY empno";
			rs = st.executeQuery(sql);
			
			// 4. 결과 처리 (ResultSet)
			while( rs.next() ) {
				System.out.print(rs.getString(1));
				System.out.print(", "+rs.getString(2));				
				System.out.print(", "+rs.getString("job"));
				System.out.print(", "+rs.getString("mgr"));
				System.out.print(", "+rs.getString("hiredate"));
				System.out.print(", "+rs.getString("sal"));
				System.out.print(", "+rs.getString("comm"));
				System.out.println(", "+rs.getString("deptno"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 5. 연결 종료 ( close() )
				if(rs!=null)	rs.close();
				if(st!=null)	st.close();
				if(conn!=null)	conn.close();
			} catch (SQLException e) { }
		}
		
	}
}
















