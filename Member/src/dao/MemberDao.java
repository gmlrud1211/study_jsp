package dao;

import dto.Member;

public interface MemberDao {

	// 회원가입
	//	return : boolean - 회원가입 결과 
	public boolean join(Member mem);
	
}
