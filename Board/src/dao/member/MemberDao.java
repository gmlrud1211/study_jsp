package dao.member;

import dto.member.Member;

public interface MemberDao {

	//id/pw 일치하는지 안하는지 조회할 0/1 count 반환
	int selectCntMemberByUserid(Member member);
	
	Member selectMemberByUserid(Member member);
	
	public void insert(Member member);
	
}
