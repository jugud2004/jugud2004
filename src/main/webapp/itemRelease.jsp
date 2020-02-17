<%@page import="com.communication.stock.selectItems.SelectItemsVO"%>
<%@page import="java.util.List"%>
<%@page import="com.communication.stock.items.ItemsVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
	List<ItemsVO> vo = (List)request.getAttribute("itemInfo");
	List<SelectItemsVO> vo_quentity = (List)request.getAttribute("itemQuentity");
	int quentity = 0;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>재고 출고</title>
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
p{
	position:absolute;
	left:760px;  
	top:350px;  
	margin-left:-150px;  
	margin-top:-150px;
}
#btn2{
	position:absolute;
	left:1020px;  
	top:350px;  
	margin-left:-150px;  
	margin-top:-150px;
}

</style>

</head>
<body>
	<div id="container">
		<jsp:include page="menu.do"></jsp:include>   
		<div id="rightmain">
		<h1>재고 출고</h1>
	<!-- <form action="itemsInfoTest_proc.do" method="post">
		<select name="sortItems" id="sortItems">
			<option value="itemID">제품ID</option>
			<option value="itemName">품명</option>
			<option value="itemSortation">품목코드</option>
			<option value="itemType">제품타입</option>
			<option value="handlingGrade">취급등급</option>
			<option value="securityLevel">보안등급</option>
		</select>
		<select name="sortType">
			<option value="asc">오름차순</option>
			<option value="desc">내림차순</option>
		</select>
		<input type="submit" value="정렬"/>
	</form> -->
	<form action="itemRelease_proc.do" method="post">
		<p>ID 입력 : <input type="text" name="ownerShip" required="required" placeholder="대상 ID"/></p>
		<table>
			<th>출고체크</th>
			<th>번호</th>
			<th>제품ID</th>
			<th>품명</th>
			<th>품목코드</th>
			<th>제품타입</th>
			<th>취급등급</th>
			<th>보안등급</th>
			<!-- <th>출고</th> -->
			<%for(int i = 0; i<vo.size(); i++){ %>
			<tr>
				<td><input type="checkbox" name="itemID" value="<%=vo.get(i).getItemID() %>"/></td>
				<td><%=i+1 %></td>
				<td><%=vo.get(i).getItemID() %></td>
			    <td><%=vo.get(i).getItemName() %></td>
			    <td><%=vo.get(i).getItemSortation() %></td>
			    <td><%=vo.get(i).getItemType() %></td>
			    <td><%=vo.get(i).getHandlingGrade() %></td>
			    <td><%=vo.get(i).getSecurityLevel() %></td>
			    <%-- <td>
			    	<form action="itemRelease_proc.do" method="post">
			    		ID 입력 : <input type="text" name="ownerShip" required="required" placeholder="대상 ID"/>
			    		<input type="hidden" name="itemID" value="<%=vo.get(i).getItemID() %>"/>
			    		<input type="submit" value="출고"/>
			    	</form>
			    </td> --%>
			</tr>
			<%} %>
			
	   	</table>
	   	<input id="btn2" type="submit" value="출고"/>
   	</form>
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