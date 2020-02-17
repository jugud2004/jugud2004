<%@page import="com.communication.stock.militaryInfo.MilitaryInfoVO"%>
<%@page import="com.communication.stock.rank.RankVO"%>
<%@page import="com.communication.stock.positions.PositionsVO"%>
<%@page import="com.communication.stock.usersInfo.UsersInfoVO"%>
<%@page import="com.communication.stock.users.UsersVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
	List<UsersInfoVO> userList = (List)request.getAttribute("userList");int i=1; 
	List<PositionsVO> positionsList = (List)request.getAttribute("positions");
	List<RankVO> rankList = (List)request.getAttribute("rank");
	List<MilitaryInfoVO> mtCodeList = (List)request.getAttribute("mtCode");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인사정보 수정</title>
<link rel="stylesheet" href="./css/main.css" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
	
</script>
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
	left:1500px;  
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
		<h1>인사정보 수정</h1>
		<table>
			<tr>
				<th>번호</th>
				<th>아이디</th>
				<th>이름</th>
				<th>계급</th>
				<th>보직 코드</th>
				<th>소속 코드</th>
				<th>수정</th>
			</tr>	
			<c:forEach items="${ userList }" var="vo">
			<form action="updateUsers_proc.do" method="post">
				<tr>
					<td><%=i %></td>
					<td><input type="hidden" value="${ vo.id }" name="id"/>${ vo.id }</td>
				    <td><input type="text" value="${ vo.name }" name="name"/></td>
				    <td>
				    	<select name="rank" id="rank">
				    	<%for(int j=0; j<rankList.size();j++){ %>
				    		<option value="<%=rankList.get(j).getRankCode()%>"><%=rankList.get(j).getRankCode()%> - <%=rankList.get(j).getRankName()%></option>
				    	<%} %>
				    	</select>
				    </td>
				    <td>
				    	<select name="positionCode" id="positionCode">
				    		<%for(int j = 0; j<positionsList.size(); j++){ %>
				    		<option value="<%=positionsList.get(j).getPositionCode()%>"><%=positionsList.get(j).getPositionCode()%> - <%=positionsList.get(j).getPositionName()%></option>
				    		<%} %>
				    	</select>
				    </td>
				    <td>
				    	<select name="mtCode" id="mtCode">
				    		<%for(int j=0; j<mtCodeList.size(); j++) {%>
				    		<option value="<%=mtCodeList.get(j).getMtCode()%>"><%=mtCodeList.get(j).getMtCode()%></option>
				    		<%} %>
				    	</select>
				    </td>
				    <td>
				    	<input type="submit" value="수정"/>
				    </td>
				</tr>
			</form>
			<%i=i+1; %>
			</c:forEach>
    	</table><br />
		
	</form><br />             
	<button id="btn1" type="button" onclick="location.href='usersControl.do' ">돌아가기</button>                                                                                                                                                                                                                                                                                                                                                                                                                                   
 
		</div>

	</div>
</body>
</html>