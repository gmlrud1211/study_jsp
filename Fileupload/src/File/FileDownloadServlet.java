package File;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FileUploadDao;
import dao.FileUploadDaoImpl;
import dto.UploadFile;

@WebServlet("/file/download")
public class FileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	private FileUploadDao fileUploadDao = new FileUploadDaoImpl();
	
	
	// <a>태글 리용한 업로드 파일링크만 걸기
	// 와녑ㄱ한 파일 다운로드가 이루어지지 않는다.
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String html ="<a href='/cos/upload/라이언1.jpg'>라이언.jpg</a>";
		
		out.println(html);
	
	}*/
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//요청 파라미터 : fileno
		String param = req.getParameter("fileno");
		
		int fileno=0;
		
		if( param!=null && !"".equals(param) ) {
			fileno = Integer.parseInt(param);
		}
		
		System.out.println("[down] fileno="+fileno);
		
		//다운로드 대상 파일 정보 찾기
		UploadFile downFile = fileUploadDao.selectByFileno(fileno);
		System.out.println("[down] "+downFile);
		
		//다운로드 파일 객체
		String path = getServletContext().getRealPath("cos/upload");
	
		File file = new File(path, downFile.getStoredName());
		System.out.println("[down] file:"+file);
		System.out.println("[down] exists:"+file.exists());
		
		
		
		
	
	
	}

}
