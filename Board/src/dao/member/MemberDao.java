package dao.member;

import dto.member.Member;

public interface MemberDao {

	// userid/pw 일치하는 회원 수 조회	
	int selectCntMemberByUserid(Member member);
	
	//userid로 유저정보 조회
	Member selectMemberByUserid(Member member);
	
	//회원가입
	public void insert(Member member);
	
}
