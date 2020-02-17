<%@page import="com.communication.stock.rank.RankVO"%>
<%@page import="com.communication.stock.positions.PositionsVO"%>
<%@page import="com.communication.stock.militaryInfo.MilitaryInfoVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	List<MilitaryInfoVO> list = (List)request.getAttribute("mtInfo");
	List<PositionsVO> position_list = (List)request.getAttribute("positions");
	List<RankVO> rank_list = (List)request.getAttribute("rank");
	int check = 0;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<style>

* {
	background-color: #d1d1e0;
}

table {
	background-color: white;
	border: 1px solid black;
	position: absolute;
	left: 950px;
	top: 300px;
	margin-left: -150px;
	margin-top: -150px;
	width: 400px;
	height: 500px;
	border : 1px solid black;
	
	
}

form, tr, th {
	background-color: black;
	color:black;
}

input {
	background-color: white;
}

#log {
	background-color: #1a75ff;
	color: black;
	border-radius: 25px;
	width: 100px;
	height: 40px;
}
#btn1{
	background-color: #1a75ff;
	color: white;
	border-radius: 25px;
	width: 100px;
	height: 40px;
	position: absolute;
	left: 1250px;
	top: 850px;
	margin-left: -150px;
	margin-top: -150px;
}
td{
background-color: white;

}
</style>
<body>
<form action="joinForm_proc.do" method="post">
	<table>
		<tr>
			<td>ID(군번)</td>
			<td><input type="text" name="id"/></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name"/></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="password"/></td>
		</tr>
		<tr>
			<td>계급</td>
			<td>
				<select name="rank" id="rank">
					<%for(int i = 0 ; i < rank_list.size(); i++) {%>
						<option value="<%=rank_list.get(i).getRankCode()%>"><%=rank_list.get(i).getRankCode() %> - <%=rank_list.get(i).getRankName() %></option>
					<% }%>
				</select>
			</td>
		</tr>
		<tr>
			<td>보직</td>
			<td>
				<select name="positions" id="positions">
					<%for(int i = 0 ; i < position_list.size(); i++) {%>
						<option value="<%=position_list.get(i).getPositionCode()%>"><%=position_list.get(i).getPositionCode() %> - <%=position_list.get(i).getPositionName() %></option>
					<% }%>
				</select>
			</td>
		</tr>
		<tr>
			<td>군단</td>
			<td>
				<select name="command" id="command">
					<%for(int i = 0 ; i < list.size(); i++) {
					if(list.get(i).getCommand()==check){}else if(list.get(i).getCommand()==0){%>
					<option value="<%=list.get(i).getCommand()%>">없음</option>
					<%}else{%>
						<option value="<%=list.get(i).getCommand()%>"><%=list.get(i).getCommand() %>군단</option>
					<%} check=list.get(i).getCommand();}%>
				</select>
			</td>
		</tr>
		<tr>
			<td>사단</td>
			<td>
				<select name="corps" id="corps">
					<%for(int i = 0 ; i < list.size(); i++) {
					if(list.get(i).getCorps()==check){}else if(list.get(i).getCorps()==0){%>
					<option value="<%=list.get(i).getCorps()%>">없음</option>
					<%}else{%>
						<option value="<%=list.get(i).getCorps()%>"><%=list.get(i).getCorps() %>사단</option>
					<%} check=list.get(i).getCorps();}%>
				</select>
			</td>
		</tr>
		<tr>
			<td>여단</td>
			<td>
				<select name="division" id="division">
					<%for(int i = 0 ; i < list.size(); i++) {
					if(list.get(i).getDivision()==check){}else if(list.get(i).getDivision()==0){%>
					<option value="<%=list.get(i).getDivision()%>">없음</option>
					<%}else{%>
						<option value="<%=list.get(i).getDivision()%>"><%=list.get(i).getDivision() %>여단</option>
					<%} check=list.get(i).getDivision();}%>
				</select>
			</td>
		</tr>
		<tr>
			<td>연대</td>
			<td>
				<select name="regiment" id="regiment">
					<%for(int i = 0 ; i < list.size(); i++) {
					if(list.get(i).getRegiment()==check){}else if(list.get(i).getRegiment()==0){%>
					<option value="<%=list.get(i).getRegiment()%>">없음</option>
					<%}else{%>
						<option value="<%=list.get(i).getRegiment()%>"><%=list.get(i).getRegiment() %>연대</option>
					<%} check=list.get(i).getRegiment();}%>
				</select>
			</td>
		</tr>
		<tr>
			<td>대대</td>
			<td>
				<select name="battalion" id="battalion">
					<%for(int i = 0 ; i < list.size(); i++) {
					if(list.get(i).getBattalion()==check){}else if(list.get(i).getBattalion()==0){%>
					<option value="<%=list.get(i).getBattalion()%>">없음</option>
					<%}else{%>
						<option value="<%=list.get(i).getBattalion()%>"><%=list.get(i).getBattalion() %>대대</option>
					<%} check=list.get(i).getBattalion();}%>
				</select>
			</td>
		</tr>
		<tr>
			<td>중대</td>
			<td>
				<select name="company" id="company">
					<%for(int i = 0 ; i < list.size(); i++) {
					if(list.get(i).getCompany()==check){}else if(list.get(i).getCompany()==0){%>
					<option value="<%=list.get(i).getCompany()%>">없음</option>
					<%}else{%>
						<option value="<%=list.get(i).getCompany()%>"><%=list.get(i).getCompany() %>중대</option>
					<%} check=list.get(i).getCompany();}%>
				</select>
			</td>
		</tr>
		<tr>
			<td>소대</td>
			<td>
				<select name="platoon" id="platoon">
					<%for(int i = 0 ; i < list.size(); i++) {
						if(list.get(i).getPlatoon()==check){}else if(list.get(i).getPlatoon()==0){%>
						<option value="<%=list.get(i).getPlatoon()%>">없음</option>
						<%}else {%>
						<option value="<%=list.get(i).getPlatoon()%>"><%=list.get(i).getPlatoon() %>소대</option>
					<%} check = list.get(i).getPlatoon();}%>
				</select>
			</td>
		</tr>
		
		
		
		
		
		
		<tr>
			<td><input type="submit" value="회원가입"/></td>
		</tr>
	</table>
	<button id="btn1" type="button" onclick="location.href='login.do' ">돌아가기</button>
</form>
</body>
</html>