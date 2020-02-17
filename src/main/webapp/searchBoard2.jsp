<%-- <%@page import="com.communication.stock.board.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	List<BoardVO> boardList = (List)request.getAttribute("boardList");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA 검색 리스트</title>
<style>
	table, th, td {
	    border: 1px solid black;
	    text-align: center;
	}
	table {
	    border-collapse: collapse;
	    display: inline-block;
	}
</style>
</head>
<body>
<h1>QnA 게시판</h1>
	
	<table id="test">
		<tr>
			<th width="100">번호</th>
			<th width="250">제목</th>
			<th width="150">작성자</th>
			<th width="150">등록일</th>
			<th width="100">조회수</th>
		</tr>
		
		<c:forEach items="${ boardList }" var="vo">
		<tr>
			<td width="100">${ vo.seq }</td>
			<td width="250"><a href="getBoard.do?seq=${ vo.seq }">${ vo.title }</a></td>
			<td width="150">${ vo.writer }</td>
			<td width="150">${ vo.postDate }</td>
			<td width="100">${ vo.viewCount }</td>
		</tr>
		</c:forEach>

	</table><br />
	<form action="searchBoard.do?classify=2" method="post">
		<select name="searchType">
			<option value="title">제목</option>
			<option value="content">내용</option>
		</select>
		<input type="search" name="seachContent"/>
		<input type="submit" value="검색"/>
		
	</form><br />
<%if(session.getAttribute("position").equals(311101)){ %><a href="insertBoard.jsp?classify=">글쓰기</a><%} %><!-- 인사행정병만 볼수있음 -->
<a href="main.do">메인으로</a>
</body>
</html> --%>