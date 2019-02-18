package dao.face;

import java.util.List;

import dto.Emp;

public interface EmpDao {
	
	// Emp테이블 전체 조회
	public List selectEmp();
	
	// Emp테이블 삽입
	public void insert(Emp emp);
	
	// Emp 한명 조회
	public Emp selectByEmpno(Emp emp);
	
}


















