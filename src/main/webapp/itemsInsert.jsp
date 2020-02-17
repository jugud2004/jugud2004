<%@page import="com.communication.stock.security.SecurityVO"%>
<%@page import="com.communication.stock.handlingGrade.HandlingGradeVO"%>
<%@page import="com.communication.stock.itemType.ItemTypeVO"%>
<%@page import="java.util.List"%>
<%@page import="com.communication.stock.itemSortation.ItemSortationVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
List<ItemSortationVO> sortList = (List)request.getAttribute("sort");
List<ItemTypeVO> typeList = (List)request.getAttribute("itemType");
List<HandlingGradeVO> hgList = (List)request.getAttribute("handlingGrade");
List<SecurityVO> securityList = (List)request.getAttribute("security");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>재고 입력</title>
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
		<h1>재고 입력</h1>
	<form action="itemsInsert_proc.do" method="post">
		<table>
			<!-- <tr>
				<td>제품ID</td>
				<td><input type="text" name="itemID"/></td>
			</tr> -->
			<tr>
				<th>제품명</th>
				<td><input type="text" name="itemName" required="required"/></td>
			</tr>
			<tr>
				<th>품목코드</th>
				<td>
					<select name="itemSortation">
						<%for(int i = 0 ; i < sortList.size(); i++){ %>
						<option value="<%=sortList.get(i).getItemSortation()%>"><%=sortList.get(i).getItemSortation()%> - <%=sortList.get(i).getItemSortationName()%></option>
						<%} %>
					</select>
				</td>
			</tr>
			<tr>
				<th>제품타입</th>
				<td>
					<select name="itemType">
						<%for(int i = 0 ; i < typeList.size(); i++){ %>
						<option value="<%=typeList.get(i).getItemType()%>"><%=typeList.get(i).getItemType()%> - <%=typeList.get(i).getItemTypeName() %></option>
						<%} %>
					</select>
				</td>
			</tr>
			<tr>
				<th>취급등급</th>
				<td>
					<select name="handlingGrade">
						<%for(int i = 0 ; i < hgList.size(); i++){ %>
						<option value="<%=hgList.get(i).getHandlingGrade()%>"><%=hgList.get(i).getHandlingGrade()%> - <%=hgList.get(i).getHandlingGradeName() %></option>
						<%} %>
					</select>
				</td>
			</tr>
			<tr>
				<th>보안등급</th>
				<td>
					<select name="securityLevel">
						<%for(int i = 0 ; i < securityList.size(); i++){ %>
						<option value="<%=securityList.get(i).getSecurityLevel()%>"><%=securityList.get(i).getSecurityLevel()%> - <%=securityList.get(i).getSecurityName() %></option>
						<%} %>
					</select>
				</td>
			</tr>
			<tr>
				<th>등록하기</th>
				<td><input type="submit" value="등록"/></td>
				
			</tr>
		</table>
		<button id="btn1" type="button" onclick="location.href='itemsInfoTest.do' ">돌아가기</button>
		  
	</form>

		</div>

	</div>
</body>
</html>