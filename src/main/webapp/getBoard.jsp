<%@page import="org.springframework.web.multipart.MultipartFile"%>
<%@page import="com.communication.stock.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	trimDirectiveWhitespaces="true" pageEncoding="UTF-8"%>
<%
	BoardVO board = (BoardVO) request.getAttribute("board");
	MultipartFile uploadFile;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 상세보기</title>
<link rel="stylesheet" href="./css/main.css" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
	
</script>
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
	left: 1200px;
	top: 800px;
	margin-left: -150px;
	margin-top: -150px;

}
 #btn2{
	position: absolute;
	left: 1300px;
	top: 800px;
	margin-left: -150px;
	margin-top: -150px;

}
 #btn3{
	position: absolute;
	left: 1400px;
	top: 800px;
	margin-left: -150px;
	margin-top: -150px;

}
 #btn4{
	position: absolute;
	left: 1500px;
	top: 800px;
	margin-left: -150px;
	margin-top: -150px;

}

</style>
</head>
<body>
	<div id="container">
		<jsp:include page="menu.do"></jsp:include>
		<div id="rightmain">
			<h1>상세보기</h1>
			<table>
				<tr>
					<th>제목</th>
					<td align="left">${ board.title }</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td align="left">${ board.writer }</td>
				</tr>
				<tr>
					<th>내용</th>
					<td align="left"><%=board.getContent()%></td>
				</tr>
				<tr>
					<th>등록일</th>
					<td align="left"><%=board.getPostDate()%></td>
				</tr>
				<tr>
					<th>조회수</th>
					<td align="left"><%=board.getViewCount()%></td>
				</tr>
				<%
					if (board.getFilename() != null) {
				%>
				<tr>
					<th>자료</th>
					<td><a href="#">첨부파일</a></td>
				</tr>
				<%
					} else {
					}
				%>
			</table>
			
			<button id="btn1"  onclick="location.href='board.do?classify=<%=session.getAttribute("classify")%>' ">돌아가기</button>
			
			<button id="btn2"  onclick="location.href='insertBoard.jsp' ">글쓰기</button>
			<button id="btn3"  onclick="location.href='updateBoard.do?seq=<%=board.getSeq()%>' ">글수정</button>
			<button id="btn4"  onclick="location.href='deleteBoard.do?seq=<%=board.getSeq()%>' ">글삭제</button>
			
			
	


		</div>

	</div>
</body>
</html>