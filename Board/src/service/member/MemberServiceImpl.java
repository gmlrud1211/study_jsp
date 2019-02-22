package service.member;

import javax.servlet.http.HttpServlet;

import dao.member.MemberDao;
import dao.member.MemberDaoImpl;
import dto.member.Member;

public class MemberServiceImpl implements MemberService{

	private MemberDao memberDao = new MemberDaoImpl();
	
	
	@Override
	public Member getParam(HttpServlet req, HttpServlet resp) {
	/*	
		String userid = (String)req.getParameter("userid");
		
		Member member = new Member();
		member.setUserid(userid);
		
		return member;
	*/
		return null;
	}

	@Override
	public boolean login(Member member) {
		
		
		
		return false;
	}

	@Override
	public Member getMemberByUserid(Member member) {
		
		return null;
	}

	@Override
	public void join(Member member) {
		memberDao.insert(member);
	}
	
	

}
