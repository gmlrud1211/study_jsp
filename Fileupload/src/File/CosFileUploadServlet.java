package File;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import dao.FileUploadDao;
import dao.FileUploadDaoImpl;
import dto.UploadFile;

@WebServlet("/cos/file/upload")
public class CosFileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/cos/file/fileUpload.jsp").forward(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//요청파라미터에 한글 인코딩 설정 : utf-8
		req.setCharacterEncoding("UTF-8");
		
		//응답 객체 MIME타입 (content-type )설정
		resp.setContentType("text/html; charset=utf-8"); 
		
		//응답객체 출력 스트림
		PrintWriter out = resp.getWriter();
		
		
		//-------MultipartRequest 생성자의 매개변수 준비----------
		//1. 요청객체 - 따로 만들 필요 없음
		//2. 파일 저장위치 - 서버의 배포폴더를 이용
		ServletContext context = getServletContext();
		String saveDirectory = context.getRealPath("cos//upload");
//		3. 업로드 제한 사이즈  
		int maxPostSize = 10*1024*1024;
//		4. 인코딩
		String encoding = "UTF-8";
//		5. 중복 파일 이름 정책  - DefaultFileRenamePolicy
		//중복 파일이 있으면 파일 이름 뒤에 1부터 증가하는 숫자 삽입
		FileRenamePolicy policy = new DefaultFileRenamePolicy();
		
		MultipartRequest mul = new MultipartRequest(req, saveDirectory,maxPostSize, encoding, policy);
	
		
		
		
		
		
		// ---------- 업로드 정보 관리 ----------
		out.println("--- 전달 파라미터 ---<br>");
		out.println( mul.getParameter("title") );

		out.println("<br><br>--- 업로드파일 ---<br>");
		File up = mul.getFile("uploadFile");
		out.println( up.toString() );
		
		out.println("<br><br>--- 저장된 파일이름 ---<br>");
		out.println( mul.getFilesystemName("uploadFile") );

		out.println("<br><br>--- 원본 파일이름 ---<br>");
		out.println( mul.getOriginalFileName("uploadFile") );

		out.println("<br><br>--- 파일 형식 ---<br>");
		out.println( mul.getContentType("uploadFile") );
		// -------------------------------------
		
		
		
		//---------- DB에 파일기록 ----------
		UploadFile uploadFile = new UploadFile();
		
		// 저장된 파일이름
		uploadFile.setStoredName(
				mul.getFilesystemName("uploadFile") );
		
		// 원본 파일 이름
		uploadFile.setOriginName(
				mul.getOriginalFileName("uploadFile") );
		
		FileUploadDao dao = new FileUploadDaoImpl();
		dao.insert( uploadFile );
		//-----------------------------------
	
		
		
	}
}
