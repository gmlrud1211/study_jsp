package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.face.EmpDao;
import dao.impl.EmpDaoImpl;
import dto.Emp;

@WebServlet("/emp/detail")
public class EmpDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmpDao empDao = new EmpDaoImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empno = request.getParameter("empno");
		System.out.println(empno);
		
		// 전달 데이터 DTO
		Emp emp = new Emp();
		emp.setEmpno( Integer.parseInt(empno) );
		
		// DAO통한 SELECT
		Emp result = empDao.selectByEmpno(emp);
		
		System.out.println(result);
	
		request.setAttribute("res", result);
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher(
				"/views/emp/detail.jsp");
		rd.forward(request, response);
		
	}

}


















