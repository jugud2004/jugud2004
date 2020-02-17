<%@page import="com.communication.stock.selectItems.SelectItemsVO"%>
<%@page import="java.util.List"%>
<%@page import="com.communication.stock.items.ItemsVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
	List<ItemsVO> list = (List)request.getAttribute("itemInfo");
	List<SelectItemsVO> list_quentity = (List)request.getAttribute("itemQuentity");
	int quentity = 0;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>재고 관리</title>
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
	table, th, td {
	    border: 1px solid black;
	    text-align: center;
	}
#ta{
	width: 700px;     
	height: 400px;
	font-family: arial, sans-serif;
  	border-collapse: collapse;
  	position:absolute;
	left:670px;  
    top:430px;    
    margin-left:-150px;         
    margin-top:-150px;   
    text-align :center;
	}
	#test{
		background-color: aqua;
	}
#ta2{
	width: 400px;     
	height: 350px;
	font-family: arial, sans-serif;
  	border-collapse: collapse;
  	position:absolute;
	left:1400px;    
    top:480px;    
    margin-left:-150px;         
    margin-top:-150px;   
    text-align :center;
}
h2{
	position:absolute;
	left:1520px;    
    top:430px;      
    margin-left:-150px;         
    margin-top:-150px;   
}
#sortItems{
	position:absolute;
	left:670px;    
    top:380px;      
    margin-left:-150px;         
    margin-top:-150px; 
}
#sortItems2{
	position:absolute;
	left:750px;    
    top:380px;      
    margin-left:-150px;         
    margin-top:-150px; 
}
#sortItems3{
	position:absolute;
	left:840px;    
    top:380px;      
    margin-left:-150px;         
    margin-top:-150px; 
}
#sortItems4{
	position:absolute;
	left:900px;    
    top:380px;      
    margin-left:-150px;         
    margin-top:-150px;
}
#sortItems5{
	position:absolute;
	left:1000px;    
    top:380px;      
    margin-left:-150px;         
    margin-top:-150px;
}
#sortItems6{
	position:absolute;
	left:1200px;    
    top:380px;      
    margin-left:-150px;         
    margin-top:-150px;
}
form{
	
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
	left:1200px;  
	top:850px;  
	margin-left:-150px;  
	margin-top:-150px;  
}     
#btn2{  
	position:absolute;    
	left:1300px;
	top:850px;  
	margin-left:-150px;
	margin-top:-150px;  
}     
#btn3{
	position:absolute;    
	left:1400px;
	top:850px;  
	margin-left:-150px;
	margin-top:-150px;
}
#btn4{
	position:absolute;    
	left:1500px;
	top:850px;  
	margin-left:-150px;
	margin-top:-150px;
}
#btn5{
	position:absolute;    
	left:1600px;  
	top:850px;  
	margin-left:-150px;
	margin-top:-150px;
}
</style>

</head>   
<body>
	<div id="container">    
		<jsp:include page="menu.do"></jsp:include>   
		<div id="rightmain">
		<h1>재고 관리</h1>
	<form action="itemsInfoTest_proc.do" method="post">
		<select name="sortItems" id="sortItems">
			<option value="itemID">제품ID</option>
			<option value="itemName">품명</option>
			<option value="itemSortation">품목코드</option>
			<option value="itemType">제품타입</option>
			<option value="handlingGrade">취급등급</option>
			<option value="securityLevel">보안등급</option>
		</select>
		<select name="sortType" id="sortItems2">
			<option value="asc">오름차순</option>
			<option value="desc">내림차순</option>
		</select>
		<input id="sortItems3" type="submit" value="정렬"/>
	</form>
	<table id="ta">
		<tr>
			<th>번호</th>
			<th>제품ID</th>
			<th>품명</th>
			<th>품목코드</th>
			<th>제품타입</th>
			<th>취급등급</th>
			<th>보안등급</th>
		</tr>
		<%for(int i = 0; i<list.size(); i++){ %>
		<tr>
			<td><%=i+1 %></td>
			<td><%=list.get(i).getItemID() %></td>
		    <td><%=list.get(i).getItemName() %></td>
		    <td><%=list.get(i).getItemSortation() %></td>
		    <td><%=list.get(i).getItemType() %></td>
		    <td><%=list.get(i).getHandlingGrade() %></td>
		    <td><%=list.get(i).getSecurityLevel() %></td>
		</tr>
		<%} %>
   	</table><br />
	<form action="itemsSearchInfoTest.do" method="post">
		<select name="searchType" id="sortItems4">
			<option value="itemID">제품ID</option>
			<option value="itemName">품명</option>
			<option value="itemSortation">품목코드</option>
			<option value="itemType">제품타입</option>
			<option value="handlingGrade">취급등급</option>
			<option value="securityLevel">보안등급</option>
		</select>
		<input type="search" name="searchContent" id="sortItems5"/>
		<input id="sortItems6" type="submit" value="검색"/>
		
	</form><br />
   	<h2>품목별 합계</h2>
   	<table id="ta2">
   		<tr>
			<th>품목코드</th>
			<th>품목수량</th>
		</tr>
		<%for(int i = 0; i<list_quentity.size(); i++){%>
		<tr>
			<td><%=list_quentity.get(i).getItemSortation() %></td>
		    <td><%=list_quentity.get(i).getItemQuentity() %></td>
		</tr>
		<%quentity = quentity + list_quentity.get(i).getItemQuentity();} %>
		<tr>
			<td id="test">합계</td>
			<td id="test"><%=quentity %></td>
		</tr>
   	</table><br />
   	
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
	
	<button id="btn1" type="button" onclick="location.href='main.do' ">돌아가기</button>
	<button id="btn2" type="button" onclick="location.href='itemDeleteList.do' ">재고삭제</button>
	<button id="btn3" type="button" onclick="location.href='itemReleaseList.do' ">출고</button>
	<button id="btn4" type="button" onclick="location.href='itemsInsert.do' ">재고입력</button>
	<button id="btn5" type="button" onclick="location.href='itemsUpdateList.do' ">재고수정</button>	
	
  
		</div>     

	</div>
</body>
</html>