package service.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.member.Member;

public interface MemberService {

	//요청 파라미터 처리
	public Member getParam(HttpServletRequest Req, HttpServletResponse resp);
	
	//로그인
	boolean login(Member member);
	
	//유저정보 가져옴
	public Member getMemberByUserid(Member member);
	
	//회원가입
	public void join(Member member);
	
}
