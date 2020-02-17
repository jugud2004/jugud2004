<%@page import="com.communication.stock.board.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	List<BoardVO> boardList = (List)request.getAttribute("boardList");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보 게시판</title>
<link rel="stylesheet" href="./css/main.css" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
	
</script>
<style>
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
table{
	width: 1000px;     
	height: 350px;
	font-family: arial, sans-serif;
  	border-collapse: collapse;
  	position:absolute;
    left:750px;  
    top:400px;    
    margin-left:-150px;         
    margin-top:-150px;   
    text-align :center;
}
th,td{        
	border : 1px solid black;
}
th{
	background-color: #4d94ff;
	color: white;
	
}
form{

}       
input{
	position:absolute;
	left:850px;  
    top:370px;    
    margin-left:-150px;         
    margin-top:-150px;
	
}  
select{
	position:absolute;
	left:750px;  
    top:360px;    
    margin-left:-150px;         
    margin-top:-150px;
    width: 70px;
    height: 40px;
} 
button{
 	width: 110px;
	height: 40px;
	background-color: black;
	color: white;    
}  
#btn1{
	position:absolute;
	left:1500px;  
	top:850px;  
	margin-left:-150px;  
	margin-top:-150px;  
}     
#btn2{  
	position:absolute;    
	left:1650px;
	top:850px;  
	margin-left:-150px;
	margin-top:-150px;  
}     
.btn3{
	position:absolute;    
	left:1100px;
	top:346px;  
	margin-left:-150px;
	margin-top:-150px;
}
#board{  
	text-align : left;   
}
        
#select1{
	position:absolute;    
	left:800px;
	top:350px;  
	margin-left:-150px;
	margin-top:-150px;
	width: 70px;
	height: 30px;
} 
#rjator{
	position:absolute;
	left:340px;  
	top:150px;  
	margin-left:-150px;  
	margin-top:-150px; 
}
#divPaging {
        clear:both; 
        margin-top : 45%; 
        margin-left : 40%;
        width:220px; 
        height:200px;
}

    #divPaging > div {
        float:left;
        width: 30px;
        margin:0 auto;
        text-align:center;
}
</style>
</head>
<body>
<div id="container">
		<jsp:include page="menu.do"></jsp:include>   
		<div id="rightmain">
		<h1>정보 게시판</h1>
	
	<table id="test">
		<tr>
			<th width="100">번호</th>
			<th width="250">제목</th>
			<th width="150">작성자</th>
			<th width="150">등록일</th>
			<th width="100">조회수</th>
		</tr>
		
		<c:forEach items="${ boardList }" var="vo">
		<tr>
			<td width="100">${ vo.seq }</td>
			<td width="250"><a href="getBoard.do?seq=${ vo.seq }">${ vo.title }</a></td>
			<td width="150">${ vo.writer }</td>
			<td width="150">${ vo.postDate }</td>
			<td width="100">${ vo.viewCount }</td>
		</tr>
		</c:forEach>

	</table><br />
	<form action="searchBoard.do?classify=1" method="post">
		<select name="searchType">
					<option value="title">제목</option>
					<option value="content">내용</option>
		</select>
		<input type="search" name="seachContent"/>
		<div id="rjator">
		<input type="submit" value="검색"/>
		</div>
	</form><br />
<!-- <%if(session.getAttribute("position").equals(311101)){ %><a href="insertBoard.do?classify=1">글쓰기</a><%} %> 인사행정병만 볼수있음 -->
	
<button id="btn1" type="button" onclick="location.href='main.do' ">메인으로</button>
<button id="btn2" type="button" onclick="location.href='insertBoard.jsp?classify=' ">글쓰기</button>

		</div>

	</div>
</body>
</html>