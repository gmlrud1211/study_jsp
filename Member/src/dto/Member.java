package dto;

public class Member {
	private String userid;
	private String nick;
	private String email;
	
	@Override
	public String toString() {
		return "Member [userid=" + userid + ", nick=" + nick + ", email=" + email + "]";
	}

	public String getUserid() {
		return userid;
	}
	
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
