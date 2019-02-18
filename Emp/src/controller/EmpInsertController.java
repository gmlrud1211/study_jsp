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

@WebServlet("/emp/insert")
public class EmpInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmpDao empDao = new EmpDaoImpl();
	
	protected void doGet(
			HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("확인");
		
		// View 지정하기
		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher(
				"/views/emp/insertForm.jsp");
		rd.forward(request, response);
				
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("POST 확인");
		
		//요청 파라미터 꺼내기
		String param = req.getParameter("empno");
		System.out.println( param );
		
		//DTO에 파라미터 담기
		Emp emp = new Emp();
		emp.setEmpno( Integer.parseInt(param) );
		
		//DAO를 통해 insert
		empDao.insert(emp);
		
		
		//VIEW 대신 컨트롤러 요청하기
		resp.sendRedirect("/emp/detail?empno="+emp.getEmpno());
	}

}


















