package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.face.EmpDao;
import dao.impl.EmpDaoImpl;
import dto.Emp;

@WebServlet("/emp/view")
public class EmpViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmpDao empDao = new EmpDaoImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/emp/view - doGet() 동작");
		
		//비지니스로직처리
		//	EMP테이블 전체 조회 결과 보여주기

		//1. DAO를 통해 EMP 테이블 조회하기
		List<Emp> list = empDao.selectEmp();

		//2. 조회 결과를 VIEW에 전달하기
		request.setAttribute("list", list);
		
		//JSP를 이용한 응답 처리
		//	View에 해당하는 JSP를 지정
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/views/emp/view.jsp");
		
		rd.forward(request, response);
		
	}
}

















