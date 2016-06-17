<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="./include/header.jsp" %>
	<style type="text/css">
		#btn_box {
			text-align: center;
		}

		.frm {
			display: inline;
			margin-right: 5px;
		}

		textarea {
			border: none;
		}
		
		ul {
			list-style: none;
		}

	</style>

<div class="container">
<h1>게시글 상세</h1>
	<table class="table table-hover">
		<tbody>
				<tr>
					<th>No.</th>
					<td id="no">${vo.board_no}</td>
				</tr>
				<tr>	
					<th>제목</th>
					<td>${vo.title}</td>
				</tr>
				<tr>	
					<th>내용</th>
					<td>
						<c:out value="${vo.content}" escapeXml="false" />
					</td>
				</tr>
				<tr>	
					<th>작성자</th>
					<td>${vo.user_name}</td>
				</tr>
				<tr>	
					<th>조회수</th>
					<td>${vo.view_cnt}</td>
				</tr>
		</tbody>
	</table>
	<div id="btn_box">	
		<form class="frm" id="update" action="/rest/update" method="POST">
			<input type="hidden" id="board_no" name="board_no" value="${vo.board_no}">
			<input type="submit" class="btn btn-warning" value="수정" />
		</form>
		
		<form class="frm" id="delete" action="/rest/${board_no}" method="POST">
			<input type="hidden" id="_method" name="_method" value="DELETE">
			<input type="submit" class="btn btn-danger" value="삭제" />
		</form>
		
		<form class="frm" id="aaa">
			<input type="button" class="btn btn-success" value="목록" onclick="javascript:location.href='/rest'" />
		</form>
	</div>	

<h3>댓글</h3>
<div id="reply_list"></div>
<div id="reply_page" style="text-align: center;"></div>
<form action="/reply" method="post">
	<input type="text" id="content" name="content" size="50" />
	작성자 : <input type="text" id="user_name" name="user_name" size="10" />
	<input type="hidden" id="board_no" name="board_no" value="${board_no}" />
	<input type="button"  onclick="insertReply()" class="btn btn-primary" value="등록" />
</form>

<script>
var bno = '${vo.board_no}';
var currentPage = 1;

function insertReply() {
	var reply_content = $("#content").val();
	var reply_user = $("#user_name").val();
	
	$.ajax({
		type : 'post',
		url : '/reply/' + bno,
		headers : {
			"Content-Type" : "application/json",
		},
		data : 
			JSON.stringify({content:reply_content, user_name:reply_user}),
			//'{"content":"'+reply_content+'", "user_name":"'+reply_user+'"}',
		dataType : 'text',
		success : function(result){
			if(result == "SUCCESS"){
				getReplyList();
			}
		}
	});
}
	function setReplyList( data ) {
		var result = "<ul>";
//		var cnt = list.length;
//		for( var i = 0; i < cnt; i++ ) {
//			if( bno == list[i].board_no ) {
//				result += "<li> 작성자 : " + list[i].user_name + " 내용 : " + list[i].content + " 작성일 : " + list[i].regdate + "</li>";
//				result += "<li><form style='display: inline;' action='/reply/delete' method='POST'><input type='hidden' id='reply_no' name='reply_no' value='"+ list[i].reply_no + "'><input type='submit' value='삭제' /></form><li>";
//			}
//		}
		$(data).each( function(){
			result += "<li>" + this.user_name + " " + this.content + " " + this.regdate + "<input type='button' class='btn btn-danger' value='삭제' onclick='deleteReply(" + this.reply_no + ")' /></li>";	
		});
		result += "</ul>";
		document.getElementById( "reply_list" ).innerHTML = result;
	}
	
//	function deleteBtn( reply_no ) {
//		location.href = "/reply/delete";
//	}

	function deleteReply( rno ) {
		$.ajax({
			type : 'delete',
			url : '/reply/' + rno,
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "DELETE",
			},
			data : '',
			dataType : 'text',
			success : function( result ) {
				if(result == "SUCCESS"){
					getReplyList( 1 );
				}
			}	
		});
	}

	function getReplyList( page ) {
		if( page == null ) {
			page = currentPage;
		} 
			
		$.ajax({
			type : 'get',
			url : '/reply/' + bno + '/' + page,
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "GET",
			},
			data : '',	
			dataType : 'json',
			success : function( result ){
				setReplyList( result.l );
				setPagePrint( result.p );
			}
		});
		currentPage = page;
	}
	
	function setPagePrint( pm ) {
		var str = "<ul class='pagination'>";
		
		if( pm.prev ) {
			str += "<li><a onclick='getReplyList(" + ( pm.startPage - 1 ) + ")' style='cursor: hand'> &lt; </a></li>";
		}
		
		for( var i = pm.startPage; i <= pm.endPage; i++ ) {
			if( i == pm.criteria.page ) {
				str += "<li class='active'><a href='#'>" + i + "</a><li>";
			} else {
				str += "<li><a style='cursor: hand' onclick='getReplyList(" + i + ")'>" + i + "</a><li>";
			}
		}
		
		if( pm.next ) {
			str += "<li><a onclick='getReplyList(" + ( pm.endPage + 1 ) + ")' style='cursor: hand'> &gt; </a></li>";
		}
		
		str += "</ul>";
		document.getElementById( "reply_page" ).innerHTML = str;
	}
	getReplyList( currentPage );
</script>

</div>
<%@include file="./include/footer.jsp" %>
