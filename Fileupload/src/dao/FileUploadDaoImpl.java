package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbutil.DBConn;
import dto.UploadFile;

public class FileUploadDaoImpl implements FileUploadDao{

private Connection conn = DBConn.getConnection();
	
	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public void insert(UploadFile file) {
		String sql ="";
		sql +="insert into upload(fileno, originName, storedName, uploadDate)";
		sql +=" values (seq_upload.nextval, ?, ?, sysdate)";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, file.getOriginName());
			ps.setString(2, file.getStoredName());
			ps.executeQuery();
			
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
	
	
		
	}

}
