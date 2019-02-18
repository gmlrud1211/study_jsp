package ojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Emp;

public class OjdbcEx_04 {

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
	private static PreparedStatement ps; //SQL수행객체 
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
		String sql = "";
		sql += "SELECT * FROM emp";
		sql += " WHERE job = ? OR job = ?";
		sql += " ORDER BY empno";
		//----------------
		
		try {
			//--- DB 연결 ---
			conn = DriverManager.getConnection(
					URL, USERNAME, PASSWORD);
			//---------------
			
			//--- SQL 수행 ---
			//PreparedStatement 객체 생성
			ps = conn.prepareStatement(sql);
			
			//SQL의 ? 에 알맞은 데이터 넣기
			ps.setString(1, "SALESMAN");
			ps.setString(2, "CLERK");			
			
			//SQL수행
			rs = ps.executeQuery();			
			//----------------
			
			List<Emp> list = new ArrayList<>();
			
			//--- 결과 처리 ---
			while( rs.next() ) {
				Emp emp = new Emp();
				
				emp.setEmpno( rs.getInt("empno") );
				emp.setEname( rs.getString("ename") );
				emp.setJob( rs.getString("job") );
				emp.setMgr( rs.getInt("mgr") );
				emp.setHiredate( rs.getDate("hiredate") );
				emp.setSal( rs.getInt("sal") );
				emp.setComm( rs.getInt("comm") );
				emp.setDeptno( rs.getInt("deptno") );
				
				list.add(emp);
			}
			//-----------------
			
			//전체출력
			for(Emp e : list)	System.out.println(e);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//--- 자원 해제 ---
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
				if(conn!=null)	conn.close();
				//-----------------
			} catch (SQLException e) { }
		}
	} 
	
}










