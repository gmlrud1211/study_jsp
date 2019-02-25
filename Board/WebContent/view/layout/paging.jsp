<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!--  페이지네이션 요소 --> 
<div class="text-center">
<ul class="pagination">
		<li>
			<!-- 첫페이지가 아니라면 처음 버튼 보이기 -->
			<c:if test="${paging.curPage ne 1}">
			<a href="/board/paginglist?curPage=1">&larr;처음</a>
			</c:if>	
		</li>
		<!-- 이전 페이지 그룹 -->
		<li>
			<a href="/board/paginglist?curPage=${paging.startPage-paging.pageCount }">&lt;&lt;</a>
		</li>
		
		<!-- 이전 페이지 -->
		<li>
			<a href="/board/paginglist?curPage=${paging.curPage-1 }">&lt;</a>
		</li>

		<!-- 다음 페이지 -->
		<li>
			<a href="/board/paginglist?curPage=${paging.curPage+1 }">&gt;</a>
		</li>
		
		<!-- 다음 페이지 그룹 -->
		<li>
			<a href="/board/paginglist?curPage=${paging.startPage+paging.pageCount }">&gt;&gt;</a>
		</li>
		


</ul>

</div>