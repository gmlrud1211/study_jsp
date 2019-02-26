package dao;

import dto.UploadFile;

public interface FileUploadDao {

	//업로드 파일 기록 삽입
	public void insert(UploadFile file);

}
