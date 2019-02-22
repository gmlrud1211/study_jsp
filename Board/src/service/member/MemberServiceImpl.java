package service.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.member.MemberDao;
import dao.member.MemberDaoImpl;
import dto.member.Member;

public class MemberServiceImpl implements MemberService{

	private MemberDao memberDao = new MemberDaoImpl();

	@Override
	public Member getParam(HttpServletRequest req, HttpServletResponse resp) {
	
		Member member = new Member();
		
		String userid = (String)req.getParameter("userid");
		String userpw = (String)req.getParameter("userpw");
		String usernick = (String)req.getParameter("usernick");
		
		member.setUserid(userid);
		member.setUserpw(userpw);
		member.setUsernick(usernick);
				
		return member;
	}	
	
	@Override
	public boolean login(Member member) {
		
		//memberDao.selectCntMemberByUserid(member);

		if(memberDao.selectCntMemberByUserid(member)==1) {
			//로그인 성공 (1)
			return true;
		}else {
			//실패
			return false;
		}
		
	}

	@Override
	public Member getMemberByUserid(Member member) {
		
		return memberDao.selectMemberByUserid(member);
	}

	@Override
	public void join(Member member) {
		memberDao.insert(member);
	}
	
	
}
