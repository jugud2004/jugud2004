<%@page import="com.communication.stock.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<% BoardVO vo = (BoardVO)request.getAttribute("board");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정</title>
<link rel="stylesheet" href="./css/main.css" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
	
</script>
</head>
<style>
table, th, td {
	    border: 1px solid black;
	    text-align: center;
	    }
	table{
 		width: 500px;     
	height: 350px;
	font-family: arial, sans-serif;
  	border-collapse: collapse;
  	position:absolute;
    left:1000px;  
    top:400px;    
    margin-left:-150px;         
    margin-top:-150px;   
    text-align :center;
	}
	h1{
		 border: 2px solid #4d94ff;
	background-color: #4d94ff;
	color: white;
	text-align: center;
	width: 1200px;
	height: 60px;
	position: absolute;
	left: 670px;
	top: 250px;
	margin-left: -150px;
	margin-top: -150px;
	}
	button{
 	width: 110px;
	height: 40px;
	background-color: black;
	color: white;    
}  
th{
	background-color: #4d94ff;
	color: white;
}
 #btn1{
	position: absolute;
	left: 1400px;
	top: 800px;
	margin-left: -150px;
	margin-top: -150px;

}


</style>
<body>
	<div id="container">
		<jsp:include page="menu.do"></jsp:include>   
		<div id="rightmain">
		
	<h1>글 수정</h1>
	<form action="updateBoard_proc.do" method="post">
		<table>
			<!-- <tr>
				<td>
					<select name="classify">
						<option value="0">공지사항</option>
						<option value="1">자료</option>
						<option value="2">Q&A</option>
					</select>
				</td>
			</tr> -->
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" value="<%=vo.getTitle()%>" required="required"/></td>
				<td><input type="hidden" name="seq" value="<%=vo.getSeq()%>"/></td>
				<td><input type="hidden" name="viewCount" value="<%=vo.getViewCount()%>"/></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><%=vo.getWriter() %></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content" id="" cols="40" rows="10" required="required" style="resize: none;"><%=vo.getContent() %></textarea></td>
				
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="등록"/></td>
				
			</tr>
		</table>
	</form>
	
	<hr />
	
	<button id="btn1"  onclick="location.href='board.do?classify=<%=session.getAttribute("classify")%>' ">돌아가기</button>
	

		</div>

	</div>
	
</body>
</html>