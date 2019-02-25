package controller.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbutil.Paging;
import dto.board.Board;
import service.board.BoardService;
import service.board.BoardServiceImpl;

@WebServlet("/board/paginglist")
public class BoardPagingListController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private BoardService boardService = new BoardServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//현재 페이지 번호 얻기
		int curPage = boardService.getCurPage(request);
		
		//총게시글 수 얻기
		int totalCount = boardService.getTotalCount();
		
		//페이지 객체 생성
		Paging paging = new Paging(totalCount, curPage);
		System.out.println(paging);
		
		//게시글 목록 MODEL로 추가
	//	List<Board> boardList = boardService.getList(); //걍 board/list 일때 전체조회할때 사용햇음
		List<Board> boardList = boardService.getPagingList(paging);
		request.setAttribute("boardList", boardList);
		
		//페이징 객체 model로 추가
		request.setAttribute("paging", paging);
		
		
		//view 지정
		RequestDispatcher rd;
		rd= request.getRequestDispatcher("/view/board/paginglist.jsp");
		rd.forward(request, response);
		
		
	}

	

}
