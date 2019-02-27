<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="dto.member.Member" %> 

	<meta charset="UTF-8">
	<title>글쓰기 form</title>
	
	<jsp:include page="../layout/header.jsp"/>
		
	<script type="text/javascript" 
		src="/resources/smarteditor2/js/service/HuskyEZCreator.js" 
		charset="utf-8">
	</script>

	<script type="text/javascript">
		$(document).ready(function() {
			$("#btnWrite").click(function() {
				//스마트에디터 내용을 <textarea>에 적용하기
				submitContents($("#btnWrite"));
				$("form").submit();
			});
			
			$("#btnCancel").click(function() {
				history.go(-1);
			}) ;
		});
	</script>
	
	<style>
	h4{ text-align : center; }
	
	#content { width :100% }
	
	</style>
	
	<div class="container">
		<h4>게시글 작성</h4>
		<hr>
		
		<div>
		
		<form action="/board/write" method="post">
			<table class="table table-bordered">
				<tr><td class="info">아이디</td> <td> ${writer}</td></tr>
				<tr><td class="info">닉네임</td> <td> ${nick}</td></tr>
				<tr><td class="info">제목</td> 
					<td> <input type="text" name="title" style="width:100%"/></td>
				</tr>
				<tr><td class="info" colspan="2">본문</td></tr>
				<tr>
					<td colspan="2">
						<textarea id="content" name="content"></textarea>
					</td>
				</tr>
	
			</table>
			

			<div class="text-center">	
				<button type="button" id="btnWrite" class="btn btn-primary">등록</button>
				<button type="button" id="btnCancel" class="btn btn-danger">취소</button>
			</div>
			
		</form>
		
		</div>
			
	</div>
	
	<script type="text/javascript">
	//스마트 에디터 스킨 적용
		var oEditors = [];
		
		nhn.husky.EZCreator.createInIFrame({
		
		    oAppRef: oEditors,
		    elPlaceHolder: "content", //<textarea>의 id 입력
		    sSkinURI: "/resources/smarteditor2/SmartEditor2Skin.html",
		    fCreator: "createSEditor2",
		    htParams: {
		    	bUseToolbar : true, //툴바 사용여부
		    	bUseVerticlaResizer : false, //입력창 크기 조절바
		    	bUseModeChanger: false //모드 탭
		    }
		
		});
	

		//form의 submit동작에 맞춰 스마트에디터에 작성한 내용을
		//textarea의 내용으로전송함 -> form태그의 값으로 적용
		
		function submitContents(elClickedObj) {
		    oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);
		    try {
		        elClickedObj.form.submit();
		    } catch(e) {  }
		    }
		
	</script>
	
	
	<jsp:include page="../layout/footer.jsp"/>		
	
	
	