package session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/session/view")
public class SessionViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//세션 객체 얻어오기
		HttpSession session = request.getSession(true);
	
		//세션 id 확인하기
		System.out.println("sessionID : "+session.getId());
		
		//세션 생성 시간
		System.out.println("createTime : "+session.getCreationTime());
	
		//세션 유지 시간 (반응없을때 시간 )
		System.out.println("MaxInactiveInterval : "+session.getMaxInactiveInterval());
	
		//세션 유지 시간 설정 - 5초
		session.setMaxInactiveInterval(5);
		//session.setMaxInactiveInterval(0); 반영구적
		//세션 유지 시간 (반응없을때 시간 )
		System.out.println("MaxInactiveInterval : "+session.getMaxInactiveInterval());
	
		//세션 만들어진지 확인
		System.out.println("isNew : "+session.isNew());
	
		//세션 컨텍스트 정보 확인
		System.out.println("Attribute [test] : "+session.getAttribute("test")); 
		//테스트라는 세션정보없음(create에 만들어둿음)-> create에 들렸다가 view로 와야 값 지정됨(세션유지된상태)
		
		//view 포워딩
		request.getRequestDispatcher("/session/view.jsp").forward(request, response);;
		
	
	}

}
