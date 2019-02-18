package singleton;

//인스턴스화하면서 추가 작업을 할 수 있도록 적용

public class Singleton_02 {
	private static Singleton_02 instance; //객체 변수

	//static 초기화 블록 - 클래스변수 초기화
	static {
		try {
			instance = new Singleton_02(); //객체 생성
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Singleton_02() {} //private 생성자 - 외부생성 막기
	
	public static Singleton_02 getInstance() {//객체 반환
		return instance;
	}
	
}














