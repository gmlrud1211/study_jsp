package user.ex;

import java.util.List;

import user.dao.UserDao;
import user.dao.UserDaoImpl;
import user.dto.User;

public class UserEx {
	public static void main(String[] args) {

		// DAO 생성
		UserDao userDao = null; // 동작되도록 바꾸세요!!
		userDao = new UserDaoImpl();
		
		// 전체 출력
		List<User> list = userDao.selectAll();
		System.out.println("= = = = = 전체 출력 = = = = =");
		for(User u : list) {
			System.out.println(u);
		}
		System.out.println("= = = = = = = = = = = = = = =");
		
		
		
		// 유저 삽입
		
		// 유저 삽입되도록 구현하세요!!
		//	userId : A123
		//	name : Alice
		
		User insertUser = new User();
		insertUser.setUserId("A123");
		insertUser.setName("Alice");
		
		userDao.insertUser(insertUser);
		
		System.out.println("= = = = = Alice 삽입 확인 = = = = =");
		List<User> list1 = userDao.selectAll();
		for(User u : list1) {
			System.out.println(u);
		}
		System.out.println("= = = = = = = = = = = = = = =");

		
		
		
		// 유저 조회
		User selectUser = userDao.selectByIdx(20);
		System.out.println("= = = = = 20번 확인 = = = = =");
		System.out.println(selectUser);
		System.out.println("= = = = = = = = = = = = = = =");
		
		// 유저 삭제
		userDao.deleteByIdx(20);
				
		// 유저 조회
		User resultUser = userDao.selectByIdx(20);
		System.out.println("= = = = = 20번 확인 = = = = =");
		System.out.println(resultUser);
		System.out.println("= = = = = = = = = = = = = = =");
			
	}	
}











