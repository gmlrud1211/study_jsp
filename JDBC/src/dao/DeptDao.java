package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dbutil.DBConn;

public class DeptDao {

	private Connection conn = DBConn.getConnection();
	
	private PreparedStatement ps;
	private ResultSet rs;
	
	public List selectAll() {
		String sql = "SELECT * FROM dept ORDER BY deptno";
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}











