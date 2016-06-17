<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="./include/header.jsp" %>

<script type="text/javascript">
	function newData() {
		location.href="/rest/new";
	}
</script>	
<style type="text/css">
	#btn {
		float: right;
	}
	
	a {
		color: #333;
	}
</style>
	
<div class="container">
<h1>게시판 목록</h1>
<input type="button" id="btn" name="btn" class="btn btn-success" value="글쓰기" onclick="newData()" />
<table class="table table-hover">
	<thead>
		<tr>
			<th>No.</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="vo">
			<tr>
				<td>${vo.board_no}</td>
				<td><a href="/rest/${vo.board_no}">${vo.title} ( ${vo.reply_cnt} )</a></td>
				<td>${vo.user_name}</td>
				<td>${vo.regdate}</td>
				<td>${vo.view_cnt}</td>
				<td>
					<form action="/rest/update" method="POST">
						<input type="hidden" id="board_no" name="board_no" value="${vo.board_no}">
						<input type="submit" class="btn btn-warning" value="수정" />
					</form>
				</td>
				<td>
					<form action="/rest/delete" method="POST">
						<input type="hidden" id="board_no" name="board_no" value="${vo.board_no}">
						<input type="submit" class="btn btn-danger" value="삭제" />
					</form>
				</td>

			</tr>
		</c:forEach>
	</tbody>
</table>
</div>
<%@include file="./include/footer.jsp" %>
