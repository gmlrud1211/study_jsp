package singleton;

//단점
//	1. 인스턴스화하면서 추가 작업을 할 수 없음(예외처리불가)
//	2. 인스턴스를 사용하지 않아도 생성해 놓는다

public class Singleton_01 {
	
	public String data = "Apple"; //데이터
	
	//객체 생성
	private static Singleton_01 instance
		= new Singleton_01();
	
	// private 생성자 - 외부에서 객체를 생성할 수 없게됨
	private Singleton_01() { }
	
	// 객체 반환
	public static Singleton_01 getInstance() {
		return instance;
	}
}














