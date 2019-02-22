package service.member;

import javax.servlet.http.HttpServlet;

import dto.member.Member;

public interface MemberService {

	public Member getParam(HttpServlet Req, HttpServlet resp);
	
	//id/pw 일치하는 행 count로 처리
	boolean login(Member member);
	
	public Member getMemberByUserid(Member member);
	
	public void join(Member member);
	
}
