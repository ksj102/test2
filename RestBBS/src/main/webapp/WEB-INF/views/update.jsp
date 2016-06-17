<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="./include/header.jsp" %>

<div class="container">
<h1>게시글 수정</h1>
<form action="/rest/update2" method="POST">
	<table class="table table-hover">
		<tbody>
				<tr>
					<th>No.</th>
					<td>${vo.board_no}</td>
					<td>
						<input type="hidden" id="board_no" name="board_no" value="${vo.board_no}" />
					</td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" id="title" name="title" value="${vo.title}" /></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea cols="50" rows="5" id="content" name="content">${vo.content}</textarea></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><input type="text" id="user_name" name="user_name" value="${vo.user_name}" /></td>
				</tr>
		</tbody>
	</table>
	<div style="text-align:center;">	
		<input type="submit" class="btn btn-primary" value="등록" />
	</div>	
</form>
</div>
<%@include file="./include/footer.jsp" %>