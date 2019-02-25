package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.board.Board;
import service.board.BoardService;
import service.board.BoardServiceImpl;

@WebServlet("/board/write")
public class BoardWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoardService boardService = new BoardServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/view/board/write.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//한글 인코딩
		req.setCharacterEncoding("utf-8");
	
		//요청 파라미터
		Board board = boardService.getParam(req, resp);
		
		//서비스처리
		Board write = boardService.write(board);
		
		req.setAttribute("write", write);
		
		//req.getRequestDispatcher("/view/board/paginglist.jsp").forward(req, resp);
	

		resp.sendRedirect("/board/paginglist");	
	}
	
	
}
