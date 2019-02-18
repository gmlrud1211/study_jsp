package ex;

import java.util.List;

import dao.EmpDao;
import dao.EmpDaoImpl;
import dto.Emp;

public class EmpEx {
	public static void main(String[] args) {
		
		EmpDao empDao = new EmpDaoImpl();
		
		List<Emp> list = empDao.getList();
		for( Emp e : list )
			System.out.println(e);

		System.out.println("-----------------------");
		System.out.println( empDao.getEmp(1001) );
		System.out.println( empDao.getEmp(7782) );
		
		System.out.println("-----------------------");
		int cnt = empDao.getCount();
		System.out.println("emp테이블 전체 인원 수 : " + cnt);
		
		System.out.println("-----------------------");
		List<Emp> salesManlist = empDao.getSalesman();
		for( Emp e : salesManlist )
			System.out.println(e);
	}
}
















