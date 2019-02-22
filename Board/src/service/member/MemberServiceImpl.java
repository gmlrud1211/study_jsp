package service.member;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.member.MemberDao;
import dao.member.MemberDaoImpl;
import dto.member.Member;

public class MemberServiceImpl implements MemberService{

	private MemberDao memberDao = new MemberDaoImpl();
	
	


	@Override
	public boolean login(Member member) {
		
		memberDao.selectCntMemberByUserid(member);
		
		return true;
	}

	@Override
	public Member getMemberByUserid(Member member) {
		
		memberDao.selectMemberByUserid(member);
		
		return member;
	}

	@Override
	public void join(Member member) {
		memberDao.insert(member);
	}
	
	@Override
	public Member getParam(HttpServletRequest req, HttpServletResponse resp) {
	
		String userid = (String)req.getParameter("userid");
		
		Member member = new Member();
		member.setUserid(userid);
		
		return member;
	}
	

}
