package user.dao;

import java.util.List;

import user.dto.User;

public interface UserDao {

	//UserTest 테이블 전체 조회
	//	idx 정렬
	public List<User> selectAll();
	
	// idx를 이용한 UserTest 조회
	//	1명이 조회되도록 한다
	public User selectByIdx(int idx);
	
	// User 삽입
	public void insertUser(User insertUser);
	
	// idx를 이용한 UserTest 삭제
	public void deleteByIdx(int idx);
	
}
