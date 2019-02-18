package form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/form.do")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()");
				
		RequestDispatcher rd = request.getRequestDispatcher("/form/inputForm.jsp");
		rd.forward(request,response);
	
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		
		//요청파라미터 한글 인코딩 UTF-8로 설정
		request.setCharacterEncoding("UTF-8");
		
		//응답 데이터 형식 설정
		response.setContentType("text/html;charset=utf-8");
		
		System.out.println("doPost()");

		response.setContentType("text/html;charset=utf-8");
	
		String id = request.getParameter("uId");
		String pw = request.getParameter("uPw");
		
		System.out.println("id:"+id+", pw:"+pw);
		
		//클라이언트 응답
		//response.getWriter().println("id:"+id+", pw:"+pw);

		PrintWriter out = response.getWriter();
		out.append("<hr>");
		out.append("<h1>전달받은 데이터</h1>");
		out.append("<hr>")
			.append("<h3>아이디: "+id+"</h3>")
			.append("<h3>비번: "+pw+"</h3><br>")
			.append("로그인성공");

	}
	

}