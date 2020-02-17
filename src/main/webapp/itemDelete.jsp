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
<title>재고 삭제</title>
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
/* 	 .graph { 
        position: relative; 
        width: 200px; 
        padding: 2px; 
		font-size:11px;
		font-family:tahoma;
		margin-bottom:3px;
    }
    .graph .bar { 
        display: block;
        position: relative;
        background: #B1D632; 
        text-align: center; 
        color: #333; 
        height: 2em; 
        line-height: 2em;            
    }
    .graph .bar span { position: absolute; left: 1em; }
    .graphAll{
    	border: 1px solid #B1D632;
    	display: inline-block;
    } */
</style>

</head>
<body>
	<div id="container">
		<jsp:include page="menu.do"></jsp:include>   
		<div id="rightmain">
		<h1>재고 삭제</h1>
	<form action="deleteItem.do" method="post">
		<table>
		<tr>
			<th>삭제여부</th>
			<th>번호</th>
			<th>제품ID</th>
			<th>품명</th>
			<th>품목코드</th>
			<th>제품타입</th>
			<th>취급등급</th>
			<th>보안등급</th>
			</tr>
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
			</tr>
			<%} %>  
	   	</table>
	   	<input id="tkrwp" type="submit" value="삭제하기"/>
   	</form>
   	
	
   	
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