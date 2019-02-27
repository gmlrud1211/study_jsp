package File;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FileUploadDao;
import dao.FileUploadDaoImpl;
import dto.UploadFile;

@WebServlet("/file/list")
public class FileListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private FileUploadDao fileUploadDao = new FileUploadDaoImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<UploadFile> list = fileUploadDao.getList();
		
		request.setAttribute("list",list);
		
		request.getRequestDispatcher("/views/file/list.jsp").forward(request, response);
		
		
		
		
	}

}
