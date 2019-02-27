package dao;

import java.util.List;

import dto.UploadFile;

public interface FileUploadDao {

	//업로드 파일 기록 삽입
	public void insert(UploadFile file);

	//업로드 파일 리스트
	public List getList();
	
	//다운 받을 파일선택 
	public UploadFile selectByFileno(int fileno);
	
	
}
