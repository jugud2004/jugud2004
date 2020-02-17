<%-- <%@page import="com.communication.stock.selectItems.SelectItemsVO"%>
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
<title>재고 관리</title>
<style>
	table, th, td {
	    border: 1px solid black;
	    text-align: center;
	}
	table {
	    border-collapse: collapse;
	    display: inline-block;
	}
	#test{
		background-color: aqua;
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
		<select name="sortType">
			<option value="asc">오름차순</option>
			<option value="desc">내림차순</option>
		</select>
		<input type="submit" value="정렬"/>
	</form>
	<table>
		<th>번호</th>
		<th>제품ID</th>
		<th>품명</th>
		<th>품목코드</th>
		<th>제품타입</th>
		<th>취급등급</th>
		<th>보안등급</th>

		<%for(int i = 0; i<vo.size(); i++){ %>
		<tr>
			<td><%=i+1 %></td>
			<td><%=vo.get(i).getItemID() %></td>
		    <td><%=vo.get(i).getItemName() %></td>
		    <td><%=vo.get(i).getItemSortation() %></td>
		    <td><%=vo.get(i).getItemType() %></td>
		    <td><%=vo.get(i).getHandlingGrade() %></td>
		    <td><%=vo.get(i).getSecurityLevel() %></td>
		</tr>
		<%} %>
   	</table><br />
	<form action="itemsSearchInfoTest.do" method="post">
		<select name="searchType">
			<option value="itemID">제품ID</option>
			<option value="itemName">품명</option>
			<option value="itemSortation">품목코드</option>
			<option value="itemType">제품타입</option>
			<option value="handlingGrade">취급등급</option>
			<option value="securityLevel">보안등급</option>
		</select>
		<input type="search" name="searchContent"/>
		<input type="submit" value="검색"/>
		
	</form><br />
   	<h2>품목별 합계</h2>
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
   	</table><br />
   	
	<div class="graphAll">
		<div class="graph">
			<label for="bar"><%=vo_quentity.get(0).getItemSortation() %></label><strong class="bar" style="width: <%=vo_quentity.get(0).getItemQuentity() +50%>px;"><%=vo_quentity.get(0).getItemQuentity() %>개</strong>
		</div>
		
		
		<div class="graph">
		    <label for="bar"><%=vo_quentity.get(1).getItemSortation() %></label><strong class="bar" style="width: <%=vo_quentity.get(1).getItemQuentity() +50%>px;"><%=vo_quentity.get(1).getItemQuentity() %>개</strong>
		</div>
		
		<div class="graph">
		    <label for="bar"><%=vo_quentity.get(2).getItemSortation() %></label><strong class="bar" style="width: <%=vo_quentity.get(2).getItemQuentity() +50%>px;"><%=vo_quentity.get(2).getItemQuentity() %>개</strong>
		</div>
	</div><br />
	
   	<a href="main.do">돌아가기</a>
   	<a href="itemDeleteList.do">재고 삭제</a>
   	<a href="itemReleaseList.do">출고</a>
   	<a href="itemsInsert.do">재고 입력</a>
</body>
</html> --%>