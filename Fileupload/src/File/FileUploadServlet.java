package File;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.FileUploadDao;
import dao.FileUploadDaoImpl;
import dto.UploadFile;

@WebServlet("/file/upload")
public class FileUploadServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//파일 업로드 form 띄우기
		request.getRequestDispatcher("/views/file/fileUpload.jsp").forward(request, response);
	
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//요청파라미터에 한글 인코딩 설정 : utf-8
		req.setCharacterEncoding("UTF-8");
		
		//응답 객체 MIME타입 (content-type )설정
		resp.setContentType("text/html; charset=utf-8"); 
		
		//응답객체 출력 스트림
		PrintWriter out = resp.getWriter();
		
		// -------------파일업로드 처리 시작
		// 1. 파일업로드 형태가 맞는지 확인
		//  multipart/form-data 인코딩으로 전송했는지 확인
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		
		// 1-1.multipart/form-data가 아닐경우
		if(!isMultipart) {
			out.println("<h1>enctype이 multipart/form-data가 아님</h1>");
			return;
		}
		
		// 1-2.multipart/form-data인코딩으로 전송했을 경우
		//  파일이 전송되었고, 파일을 받아서 처리한다.
		
		
		
		// 2. 업로드된 파일을 처리하는 FileItemFactory 객체 생성
		//  DiskFileItemFactory : 디스크 기반으로 파일아이템을 처리하는 API
		//  업로드 파일을 디스크에 임시저장하고 후처리한다
		DiskFileItemFactory factory = null;
		factory = new DiskFileItemFactory();
		
		// 3. 업로드 아이템의 용량이 적당히 작으면 메모리에서 처리
		int maxMem = 1*1024*1024; //1MB
		factory.setSizeThreshold(maxMem);
		
		
		// 4. 용량이 적당히 크면 임시파일을 만들어서 처리(디스크 처리)
		
		//서블릿 정보를 담고있는 서블릿컨텍스트 객체 얻기
		ServletContext context = getServletContext();
		//서블릿 컨텍스트로부터 실제 배포위치를 알아낸 경로
		File respository = new File(context.getRealPath("tmp"));
//		System.out.println(respository);
//		System.out.println("exists : "+respository.exists());
		
		factory.setRepository(respository);
	
		//5. 업로드 허용기준을 넘지 않으면 파일업로드 처리
		int maxFile = 10*1024*1024; //10MB
		
		//업로드 객체 생성
		ServletFileUpload upload = null;
		upload = new ServletFileUpload(factory);

		//업로드 용량 제한 설정 : 10MB
		upload.setFileSizeMax(maxFile);
		
		//----------업로드 처리 준비 완료------------
		//6. upload 데이터 파싱(추출) - 임시파일업로드 수행
		
		List<FileItem> items =null;
		
		try {
			items = upload.parseRequest(req); //req정보로 꺼내옴
		} catch (FileUploadException e) {
			e.printStackTrace();
		} 
		
		// 7. 파싱 데이터 처리

		Iterator<FileItem> iter = items.iterator();
		
		while(iter.hasNext()) {
			FileItem item = iter.next(); //요청 정보 하나씩 꺼내기
			
			//**전송된 데이터를 3가지 형태로 구분하여 처리**
			// 1. 빈 파일 (empty)
			// 2. form-data(일반적인 요청파라미터, 폼 필드)
			// 3. 정상적인 파일
			
			// 빈 파일 처리하지 않고 넘어감
			if(item.getSize()<=0 ) continue;
			
			// 빈파일 아닐경우			
			if(item.isFormField()) { //폼 필드일 경우
				// 요청파라미터 {변수=값}
				
				// 키 얻기 : getFieldName()
				// 값 얻기 : getString()
				String key = item.getFieldName();
				String value = item.getString();
				
				if("title".equals(key)) {
					String data = value;
				} else if ("name".equals(key)) {
						String data = value;
				}
				out.println("<h3>폼 필드키 : "+key+"</h3>");
				out.println("<h3>폼 필드값 : "+value+"</h3>");
				
			} else { //정상파일일 경우
				//웹서버 로컬디스크에 저장
				//DB에 저장하기도함
				
				
				//UUID생성
				UUID uuid = UUID.randomUUID();
				String u = uuid.toString();
				String res = u.split("-")[4]; //12자리 uuid
				
				String storedName = item.getName()+res;
				
				
				
				//업로드 경로 및 파일이름 지정하기
				File up = new File(
						context.getRealPath("upload"),
						storedName);
				
				
				//DB에 파일 업로드 기독하기
				// 파일 고유번호 - pk - DB Sequence
				// 원본 이름  - item.getString()
				// 업로드된 이름 - UUID
				// 업로드 시간  - DB sysdate

				//파일 기록 DTO 생성
				UploadFile file = new UploadFile();
				file.setOriginName(item.getName());
				file.setStoredName(storedName);
				System.out.println(file);
				
				
				//파일기록 DB삽입
				FileUploadDao dao = new FileUploadDaoImpl();
				dao.insert(file);
				
				
				try {
					//실제 업로드 파일 저장
					item.write(up);
					
					//임시 파일 삭제
					item.delete();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}
		
		}
		
		
		
		
		
	}
	

}
