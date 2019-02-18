package singleton;

//사용되는 시점에 인스턴스를 생성하도록 정의

public class Singleton_03 {
	private static Singleton_03 instance; //객체 변수
	
	private Singleton_03() {} //private 생성자 - 외부생성 막기
	
	public static Singleton_03 getInstance() {//객체 반환
		
		//장점1. getInstance() 처음 호출할 때까지
		//		객체생성을 미룸
		
		//장점2. 객체 생성시 추가작업 가능(예외처리)
		if( instance == null ) {
			try {
				instance = new Singleton_03();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return instance;
	}
	
}














