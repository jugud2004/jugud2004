<%@page import="com.communication.stock.usersInfo.UsersInfoVO"%>
<%@page import="com.communication.stock.users.UsersVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<% List<UsersInfoVO> userList = (List)request.getAttribute("userList");int i=1; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인사 관리</title>
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

button{
 	width: 110px;
	height: 40px;
	background-color: black;
	color: white;    
}  
#btn1{
	position:absolute;
	left:1400px;  
	top:800px;  
	margin-left:-150px;  
	margin-top:-150px; 
	}
#btn2{
	position:absolute;
	left:1550px;  
	top:800px;  
	margin-left:-150px;  
	margin-top:-150px; 
	}
select{
	position:absolute;
	left:750px;  
	top:370px;  
	margin-left:-150px;  
	margin-top:-150px;
}
#search1{
	position:absolute;
	left:850px;  
	top:370px;  
	margin-left:-150px;  
	margin-top:-150px;
}
#search2{
	position:absolute;
	left:1050px;  
	top:370px;  
	margin-left:-150px;  
	margin-top:-150px;
}
</style>
</head>
<body>
	<div id="container">
		<jsp:include page="menu.do"></jsp:include>   
		<div id="rightmain">
		<h1>인사 관리</h1>
		<table>
			<tr>
				<th>번호</th>
				<th>아이디</th>
				<th>이름</th>
				<th>계급</th>
				<th>보직 코드</th>
				<th>소속 코드</th>
				<th>사령부</th>
				<th>군단</th>
				<th>사단</th>
				<th>연대</th>
				<th>대대</th>
				<th>중대</th>
				<th>소대</th>
				<th>삭제</th>
			</tr>	
			<c:forEach items="${ userList }" var="vo">
			<tr>
				<td><%=i %></td>
				<td>${ vo.id }</td>
			    <td>${ vo.name }</td>
			    <td>${ vo.rankName }</td>
			    <td>${ vo.positionName }</td>
			    <td>${ vo.mtCode }</td>
			    <td>${ vo.command }</td>
			    <td>${ vo.corps }</td>
			    <td>${ vo.division }</td>
			    <td>${ vo.regiment }</td>
			    <td>${ vo.battalion }</td>
			    <td>${ vo.company }</td>
			    <td>${ vo.platoon }</td>
			    <td><a href="deleteUser.do?id=${ vo.id }">삭제</a></td>
			</tr>
			<%i=i+1; %>
			</c:forEach>
    	</table><br />
	<form action="usersSearchList.do" method="post">
		<select name="searchType">
			<option value="id">군번( ID )</option>
			<option value="name">이름</option>
			<option value="rankName">계급</option>
			<option value="positionName">보직 코드</option>
			<option value="mtCode">소속 코드</option>
			<option value="command">사령부</option>
			<option value="corps">군단</option>
			<option value=division>사단</option>
			<option value="regiment">연대</option>
			<option value="battalion">대대</option>
			<option value="company">중대</option>
			<option value="platoon">소대</option>
		</select>
		<input id="search1" type="search" name="searchContent"/>
		<input id="search2" type="submit" value="검색"/>
		
	</form><br />          
	
	
	<button id="btn1" type="button" onclick="location.href='main.do' ">메인으로 돌아가기</button>
	<button id="btn2" type="button" onclick="location.href='updateUsers.do' ">인사수정</button>                                                                                                                                                                                                                                                                                                                                                                                                                                      
    	
		</div>

	</div>
</body>
</html>