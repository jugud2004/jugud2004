<%@page import="com.communication.stock.board.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	List<BoardVO> boardList = (List)request.getAttribute("boardList");

	int nowPage = (Integer)request.getAttribute("page");
	int maxPage = (Integer)request.getAttribute("maxPage");
	int startPage = (Integer)request.getAttribute("startPage");
	int endPage = (Integer)request.getAttribute("endPage");
	int listCount = (Integer)request.getAttribute("listCount");
	int dataCnt = boardList.size();
	BoardVO vo = null;
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/main.css"/>    
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>


</head>
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
	border : 1px solid black;
	width: 1200px;
	height: 40px;
	position:absolute;
	left:750px;  
    top:400px;      
    margin-left:-150px;   
    margin-top:-150px;
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
#board{  
	text-align : left;   
}
                  
</style>
<body>       
	<div id="container">
		<jsp:include page="menu.jsp"></jsp:include>   
		<div id="rightmain">
		<h1>공지 게시판</h1>
	
	<table id="test">    
		<tr>
			<th width="100">번호</th>     
			<th width="250">제목</th>
			<th width="150">작성자</th>
			<th width="150">등록일</th>
			<th width="100">조회수</th>
		</tr>
		<% for(int i = 0; i <dataCnt; i++){
			vo = boardList.get(i);
			pageContext.setAttribute("vo", vo);
		%>
		<tr>
			<td width="100">${ vo.seq }</td>
			<td id= "board" width="250"><a href="getBoard.do?seq=${ vo.seq }">${ vo.title }</a></td>
			<td width="150">${ vo.writer }</td>
			<td width="150">${ vo.postDate }</td>
			<td width="100">${ vo.viewCount }</td>
		</tr>
		<%} %>          
		 
	</table><br />
	<hr />
	
	<%
		if(nowPage > 1){
			int weight = nowPage/10<5?4:0;
			out.println("<a href=\"/board.do?page=" + (nowPage-1) + "\">[이전]</a>&nbsp;&nbsp;");
		}
		startPage = ( nowPage<5 )? 1:(nowPage/5<5)?nowPage: nowPage-4;
		
		for(int a=startPage;a<=endPage;a++){
			if(a==nowPage){
				out.print("["+ a +"]&nbsp;");
			}else{ 
				out.println("<a href=\"/BoardList.do?page=" + a + "\">["+ a + "]</a>&nbsp;");
			} 
		} 
		if(nowPage<maxPage){ 
			out.println("<a href=\"/BoardList.do?page=" + (nowPage+1)+"\">[다음]</a>");
		}
	%>
	

<div class="button">
<%if(session.getAttribute("position").equals(311101)){ %><a href="insertBoard.jsp?classify=" id="btn1">글쓰기</a><%}%><!-- 인사행정병만 볼수있음 -->
<a href="main.do" id="btn2">메인으로</a>
</div>
                   
		</div>
	</div>
</body>
</html>