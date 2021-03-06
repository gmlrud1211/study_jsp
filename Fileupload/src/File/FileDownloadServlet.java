package File;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
		
		
		//----------------------------------
		//아래만 controller가 구현하는게 좋고 위부분은 service에서 처리하는게 좋다.
		
		
		
		
		
		//파일이 존재하고 디렉토리가 아닐때만 동작
		if(file.exists() && file.isFile()) {
			//응답 정보 설정
			//response 메시지의 header영역을 수정
			
			//응답 본문 길이
			resp.setHeader("Content-Leight", String.valueOf(file.length())); //string type을 long으로 바꿔줌
			
			//응답 파일 저장위치 지정 및 다운로드 이름 설정
			//직렬화 시키기 위한 작업 (한글인코딩 보존을 위해서)
			//가져온파일을 utf-8형식으로 잘라서 가져와서 8859_1방식으로 재조립한다
			resp.setHeader("Content-Disposition", "attachment;fileName="+new String(downFile.getOriginName().getBytes("utf-8"),"8859_1")+";");
			
			//text/html;charset="utf-8"로 하던 설정을 변경
			//다운받는 내용을 html이 아닌 바이너리파일로 설정
			// => 브라우저는 응답받는 내용에 따라 동작을 달리함
			
			// -> html : 화면에 보이도록 동작
			// -> 바이너리 파일 : 파일 다운로드 동작
			// -> pdf : pdf 확장프로그램을 이용해 보이도록 동작
			resp.setContentType("application/octet-stream");
			
			//파일을 읽어 응답출력스트림으로 전송
			//파일 입력 스트림(서버 로컬 저장소(HDD))
			InputStream is = new FileInputStream(file);

			//응답 출력스트림(브라우저쪽)
			OutputStream os = resp.getOutputStream();
			
			byte buf[] = new byte[4096];
			int len =-1;
			
			while ((len=is.read(buf))!=-1)
			{
				os.write(buf,0,len);
			}
		
			os.flush();
			
			os.close();
			is.close();
			
			//----------------------------
			return;
			
		}
		resp.setContentType("text/html;charset=utf-8"); 
		resp.getWriter().println("파일이 존재하지 않습니다.");		

	}

}
