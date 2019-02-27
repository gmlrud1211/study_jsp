package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
			
			ps.executeUpdate();
			
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

	@Override
	public List getList() {
		String sql =""; 
		sql +="select * from upload";
		sql +=" order by fileno";
		
		List list = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
		
			while(rs.next()) {
				UploadFile u = new UploadFile();
				
				u.setFileno(rs.getInt("fileno"));
				u.setOriginName(rs.getString("originName"));
				u.setStoredName(rs.getString("storedName"));
				u.setUploadDate(rs.getDate("uploadDate"));
				
				list.add(u);
			}
			
			
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
	
	
		
		
		
		return list;
	}

	@Override
	public UploadFile selectByFileno(int fileno) {
		String sql =""; 
		sql +="select * from upload";
		sql +=" where fileno=?";
		sql +=" order by fileno";
		
		UploadFile u = new UploadFile();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1,fileno);
			
			rs = ps.executeQuery();
		
			while(rs.next()) {
				
				u.setFileno(rs.getInt("fileno"));
				u.setOriginName(rs.getString("originName"));
				u.setStoredName(rs.getString("storedName"));
				u.setUploadDate(rs.getDate("uploadDate"));
				
			}
			
			
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
   
		return u;
	}

}
