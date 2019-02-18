package singleton;

public class Singleton_04 {
	
	// 내부 클래스
	private static class Singleton {
		private static final Singleton_04 instance
			= new Singleton_04();
	}
	
	//객체 반환
	public static Singleton_04 getInstance() {
		return Singleton.instance;
	}
	
	//private 생성자
	private Singleton_04() { }
	
}














