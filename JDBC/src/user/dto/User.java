package user.dto;

public class User {
	private int idx;
	private String userId;
	private String name;
	
	@Override
	public String toString() {
		return "User [idx=" + idx + ", userId=" + userId + ", name=" + name + "]";
	}

	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}