package singleton;

public class SingletonEx {
	public static void main(String[] args) {
		Singleton_01 s01 = Singleton_01.getInstance();
		Singleton_01 s02 = Singleton_01.getInstance();
		Singleton_01 s03 = Singleton_01.getInstance();
		Singleton_01 s04 = Singleton_01.getInstance();
		
		System.out.println(s01);
		System.out.println(s02);
		System.out.println(s03);
		System.out.println(s04);
		
		s01.data = "Apple";
		
		System.out.println("---------");
		Singleton_02 s05 = Singleton_02.getInstance();
		Singleton_02 s06 = Singleton_02.getInstance();
		
		System.out.println(s05);
		System.out.println(s06);
		
	}
}



















