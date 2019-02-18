package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Emp;

public class EmpDaoImpl implements EmpDao {

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
	
	
	
	public EmpDaoImpl() {
		//--- 드라이버 로드 ---
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//---------------------
		
		//--- DB 연결 ---
		try {
			conn = DriverManager.getConnection(
					URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//---------------
	}
	
	
	@Override
	public List<Emp> getList() {
		//--- SQL 작성 ---
		String sql = "";
		sql += "SELECT * FROM emp";
		sql += " ORDER BY empno";
		//----------------
		
		//--- 쿼리 결과 저장할 List ---
		List<Emp> empList = new ArrayList<>();
		//-----------------------------
		
		try {
			//--- SQL 수행 ---
			//PreparedStatement 객체 생성
			ps = conn.prepareStatement(sql);

			//SQL수행
			rs = ps.executeQuery();			
			//----------------
			
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
				
				empList.add(emp);
			}
			//-----------------
			
			for(Emp e : empList)
				System.out.println(e);
			
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
		
		return empList;
	}

	@Override
	public int getCount() {
		//--- SQL 작성 ---
				String sql = "";
				sql += "select count(*) from emp";
				//----------------
				
				//--- 쿼리 결과 저장할 DTO ---
				Emp emp = new Emp();
				//-----------------------------
				int rowCnt =0;
				
				try {
					//--- SQL 수행 ---
					//PreparedStatement 객체 생성
					ps = conn.prepareStatement(sql);

							
					//SQL수행
					rs = ps.executeQuery();			
					//----------------
					
					//--- 결과 처리 ---
					if(rs.next()) rowCnt = rs.getInt(1);
				     	
					//-----------------
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
				
				return rowCnt;
			}

	@Override
	public List<Emp> getSalesman() {
			//--- SQL 작성 ---
				String sql = "";
				sql += "SELECT * FROM emp";
				sql += " where job = ?";
				sql += " ORDER BY empno";
				//----------------
				
				//--- 쿼리 결과 저장할 List ---
				List<Emp> empList = new ArrayList<>();
				//-----------------------------
				
				try {
					//--- SQL 수행 ---
					//PreparedStatement 객체 생성
					ps = conn.prepareStatement(sql);

					ps.setString(1, "SALESMAN");
					
					//SQL수행
					rs = ps.executeQuery();		

					//----------------
					
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
						
						empList.add(emp);
					}
					//-----------------
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
				
				return empList;
			}

	@Override
	public Emp getEmp(int empno) {
		//--- SQL 작성 ---
		String sql = "";
		sql += "SELECT * FROM emp";
		sql += " WHERE empno = ?";
		//----------------
		
		//--- 쿼리 결과 저장할 DTO ---
		Emp emp = new Emp();
		//-----------------------------
		
		try {
			//--- SQL 수행 ---
			//PreparedStatement 객체 생성
			ps = conn.prepareStatement(sql);

			ps.setInt(1, empno);
			
			//SQL수행
			rs = ps.executeQuery();			
			//----------------
			
			//--- 결과 처리 ---
			while( rs.next() ) {
				emp.setEmpno( rs.getInt("empno") );
				emp.setEname( rs.getString("ename") );
				emp.setJob( rs.getString("job") );
				emp.setMgr( rs.getInt("mgr") );
				emp.setHiredate( rs.getDate("hiredate") );
				emp.setSal( rs.getInt("sal") );
				emp.setComm( rs.getInt("comm") );
				emp.setDeptno( rs.getInt("deptno") );
			}
			//-----------------
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
		
		return emp;
	}

}













