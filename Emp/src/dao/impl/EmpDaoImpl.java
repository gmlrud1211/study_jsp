package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.face.EmpDao;
import dbutil.DBConn;
import dto.Emp;

public class EmpDaoImpl implements EmpDao {

	private Connection conn = DBConn.getConnection();
	
	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public List selectEmp() {
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
	public void insert(Emp emp) {
		String sql = "";
		sql += "INSERT INTO emp ( empno )";
		sql += " VALUES ( ? )";

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, emp.getEmpno());
			
			ps.executeUpdate();
			
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
		
	}

	@Override
	public Emp selectByEmpno(Emp emp) {
		String sql = "";
		sql += "SELECT * FROM emp";
		sql += " WHERE empno = ?";
		
		//조회 결과 객체
		Emp result = new Emp();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, emp.getEmpno());
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				result.setEmpno(rs.getInt("empno"));
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
		
		return result;
	}

}















