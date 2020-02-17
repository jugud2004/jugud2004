<%@page import="com.communication.stock.messages.MessagesVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%
	List<MessagesVO> msgList = (List)request.getAttribute("messagesList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	width: 650px;     
	height: 350px;
	font-family: arial, sans-serif;
  	border-collapse: collapse;
  	position:absolute;
    left:950px;  
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

button{
 	width: 110px;
	height: 40px;
	background-color: black;
	color: white;    
}  
#btn1{
	position:absolute;
	left:1500px;  
	top:800px;  
	margin-left:-150px;  
	margin-top:-150px; 
	}
#tkrwp{
	width: 110px;
	height: 40px;
	background-color: black;
	color: white;   
	position:absolute;
	left:1350px;  
	top:800px;  
	margin-left:-150px;  
	margin-top:-150px;
}
</style>
</head>
<body>
<div id="container">
		<jsp:include page="menu.do"></jsp:include>   
		<div id="rightmain">
		<h1>알림 정보</h1>
		<form action="deleteMessage.do" method="post">
			<table id="test">    
				<tr>
					<th></th>
					<th>알림내용</th>     
					<th>알림 번호</th>
				</tr>
				<% for(int i = 0; i < msgList.size(); i++){ %>
				<tr>
					<td><input type="checkbox" name="msCount" value="<%=msgList.get(i).getMsCount() %>"/></td>
					<td><%= msgList.get(i).getContents1()%></td>
					<td><%= msgList.get(i).getMsCount()%></td>
				</tr>
				<%} %>
			</table>
			<input id="tkrwp" type="submit" value="삭제하기"/>
		</form><br />
	
	
	<button id="btn1" type="button" onclick="location.href='main.do' ">메인으로 돌아가기</button>    

		</div>

	</div>
</body>
</html>