package dto;

import java.util.Date;

public class UploadFile {
	private int fileno;
	private String originName;
	private String storedName;
	private Date uploadDate;
	
	public int getFileno() {
		return fileno;
	}
	public void setFileno(int fileno) {
		this.fileno = fileno;
	}
	public String getOriginName() {
		return originName;
	}
	public void setOriginName(String orginName) {
		this.originName = orginName;
	}
	public String getStoredName() {
		return storedName;
	}
	public void setStoredName(String storedName) {
		this.storedName = storedName;
	}
	public Date getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
	@Override
	public String toString() {
		return "uploadFile [fileno=" + fileno + ", originName=" + originName + ", storedName=" + storedName
				+ ", uploadDate=" + uploadDate + "]";
	}
	
	
	
	
	
}
