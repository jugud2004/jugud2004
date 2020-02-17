<%@page import="com.communication.stock.security.SecurityVO"%>
<%@page import="com.communication.stock.handlingGrade.HandlingGradeVO"%>
<%@page import="com.communication.stock.itemType.ItemTypeVO"%>
<%@page import="com.communication.stock.itemSortation.ItemSortationVO"%>
<%@page import="com.communication.stock.selectItems.SelectItemsVO"%>
<%@page import="java.util.List"%>
<%@page import="com.communication.stock.items.ItemsVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% 
	List<ItemsVO> vo = (List)request.getAttribute("itemInfo");
	List<SelectItemsVO> vo_quentity = (List)request.getAttribute("itemQuentity");
	List<ItemSortationVO> sortList = (List)request.getAttribute("sort");
	List<ItemTypeVO> typeList = (List)request.getAttribute("itemType");
	List<HandlingGradeVO> hgList = (List)request.getAttribute("handlingGrade");
	List<SecurityVO> securityList = (List)request.getAttribute("security");
	int quentity = 0;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>재고 수정</title>
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
		<h1>재고 수정</h1>
	
	<table>
		<th>번호</th>
		<th>제품ID</th>
		<th>품명</th>
		<th>품목코드</th>
		<th>제품타입</th>
		<th>취급등급</th>
		<th>보안등급</th>
		<th>수정</th>
		<%
			for (int j = 0; j < vo.size(); j++) {
		%>
		<form action="itemsUpdateList_proc.do">
		
		<tr>
			<td><%=j + 1%></td>
			<td><input type="hidden" value="<%=vo.get(j).getItemID()%>"
				name="itemID" /><%=vo.get(j).getItemID()%></td>

			<td><input type="text" name="itemName"
				value="<%=vo.get(j).getItemName()%>" required="required" /></td>



			<td><select name="itemSortation">
					<%
						for (int i = 0; i < sortList.size(); i++) {
					%>
					<option value="<%=sortList.get(i).getItemSortation()%>"><%=sortList.get(i).getItemSortation()%>
						-
						<%=sortList.get(i).getItemSortationName()%></option>
					<%
						}
					%>
			</select></td>



			<td><select name="itemType">
					<%
						for (int i = 0; i < typeList.size(); i++) {
					%>
					<option value="<%=typeList.get(i).getItemType()%>"><%=typeList.get(i).getItemType()%>
						-
						<%=typeList.get(i).getItemTypeName()%></option>
					<%
						}
					%>
			</select></td>



			<td><select name="handlingGrade">
					<%
						for (int i = 0; i < hgList.size(); i++) {
					%>
					<option value="<%=hgList.get(i).getHandlingGrade()%>"><%=hgList.get(i).getHandlingGrade()%>
						-
						<%=hgList.get(i).getHandlingGradeName()%></option>
					<%
						}
					%>
			</select></td>


			<td><select name="securityLevel">
					<%
						for (int i = 0; i < securityList.size(); i++) {
					%>
					<option value="<%=securityList.get(i).getSecurityLevel()%>"><%=securityList.get(i).getSecurityLevel()%>
						-
						<%=securityList.get(i).getSecurityName()%></option>
					<%
						}
					%>
			</select></td>

			<td><input type="submit" value="수정" /></td>

		</tr>
		</form>
		<%
			}
		%>
	</table>
	<br />
	<%-- <h2>품목별 합계</h2>
   	<table>
		<th>품목코드</th>
		<th>품목수량</th>
		<%for(int i = 0; i<vo_quentity.size(); i++){%>
		<tr>
			<td><%=vo_quentity.get(i).getItemSortation() %></td>
		    <td><%=vo_quentity.get(i).getItemQuentity() %></td>
		</tr>
		<%quentity = quentity + vo_quentity.get(i).getItemQuentity();} %>
		<tr>
			<td id="test">합계</td>
			<td id="test"><%=quentity %></td>
		</tr>
   	</table><br /> --%>

	<%-- 	<div class="graphAll">
		<div class="graph">
			<label for="bar"><%=vo_quentity.get(0).getItemSortation() %></label><strong class="bar" style="width: <%=vo_quentity.get(0).getItemQuentity() +50%>px;"><%=vo_quentity.get(0).getItemQuentity() %>개</strong>
		</div>
		
		
		<div class="graph">
		    <label for="bar"><%=vo_quentity.get(1).getItemSortation() %></label><strong class="bar" style="width: <%=vo_quentity.get(1).getItemQuentity() +50%>px;"><%=vo_quentity.get(1).getItemQuentity() %>개</strong>
		</div>
		
		<div class="graph">
		    <label for="bar"><%=vo_quentity.get(2).getItemSortation() %></label><strong class="bar" style="width: <%=vo_quentity.get(2).getItemQuentity() +50%>px;"><%=vo_quentity.get(2).getItemQuentity() %>개</strong>
		</div>
	</div><br /> --%>

	<button id="btn1" type="button" onclick="location.href='itemsInfoTest.do' ">재고관리로 돌아가기</button>
	
		</div>

	</div>
</body>
</html>