<%@page import="com.communication.stock.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
    <%BoardVO vo = (BoardVO)request.getAttribute("vo"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
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
		<h1>글 쓰기</h1>
	<form action="insertBoard_proc.do" method="post" enctype="multipart/form-data">
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
				<td><input type="text" name="title" required="required"/></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="hidden" name="writer" value="<%=session.getAttribute("userId")%>"/><%= session.getAttribute("userId")%></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content" id="" cols="40" rows="10" required="required" style="resize: none;"></textarea></td>
				
			</tr>
			<tr>
				<th>파일 첨부</td> <td><input type="file" name="uploadFile" /></th>
			</tr>
			<tr>
				
				<td colspan="2"><input type="submit" value="등록"/></td>
				
			</tr>  
			<!-- <tr>
				<td>
					<input type="file" />
				</td>
			</tr> -->
		</table>
	</form>
	
	<hr />
	
<button id="btn1"  onclick="location.href='board.do?classify=<%=session.getAttribute("classify")%>' ">게시판 보러가기</button>

		</div>

	</div>
</body>
</html>