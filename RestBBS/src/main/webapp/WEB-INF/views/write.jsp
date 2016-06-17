<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="./include/header.jsp" %>

<div class="container">
<h1>글쓰기</h1>
<form action="/rest" method="post">
<table class="table table-hover">
	<tbody>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" /></td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<textarea name="content" cols="50" rows="5"></textarea>
			</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input type="text" name="user_name" /></td>
		</tr>
	</tbody>
</table>
<div style="text-align:center;">
	<input type="reset" class="btn btn-warning" value="재입력" />
	<input type="submit" class="btn btn-primary" value="등록" />
	<input type="button" class="btn btn-danger" value="취소" onclick="javascript:location.href='/rest'" />
</div>	
</form>
</div>

<%@include file="./include/footer.jsp" %>