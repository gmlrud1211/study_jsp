package dao;

import java.util.List;

import dto.Emp;

public interface EmpDao {
	
	//Emp 테이블 전체 조회
	public List<Emp> getList();
	
	//Emp 테이블 전체 사원수 조회
	public int getCount();
	
	//Emp 테이블의 SALESMAN 조회
	public List<Emp> getSalesman();
	
	//Emp 테이블의 특정 사원 조회
	public Emp getEmp(int empno);
	
}















