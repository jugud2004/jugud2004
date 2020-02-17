<%@page import="com.communication.stock.board.BoardVO"%>
<%@page import="com.communication.stock.messages.MessagesVO"%>
<%@page import="java.util.List"%>
<%@page import="com.communication.stock.users.UsersVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%
	List<MessagesVO> msList = (List) request.getAttribute("messages");
	List<BoardVO> bdList = (List)request.getAttribute("bdList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/main.css" />
<style>
#calendar {
	border-collapse: collapse;
	height: 300px;
	position: absolute;
	left: 670px;
	top: 380px;
	margin-left: -150px;
	margin-top: -150px;
	border: 1px solid #BDBDBD;
	text-align: center;
	width: 550px;
}



.list3 {
	list-style-type: circle;
	width: 600px;
	height: 300px;
	position: absolute;
	left: 1250px;
	top: 380px;
	margin-left: -150px;
	margin-top: -150px;
	border: 2px solid black;
	text-align: center;
}

h1 {
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
	font-size: 40px;
}
</style>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
	
</script>

<script type="text/javascript">
	var today = new Date(); // 현재 시스템(클라인언 시스템임)에 설정된 날짜
	var date = new Date();

	function beforem() //이전 달을 today에 값을 저장
	{
		today = new Date(today.getFullYear(), today.getMonth() - 1, today
				.getDate());
		build(); //만들기
	}

	function nextm() //다음 달을 today에 저장
	{
		today = new Date(today.getFullYear(), today.getMonth() + 1, today
				.getDate());
		build();
	}
	function build() {
		var nMonth = new Date(today.getFullYear(), today.getMonth(), 1); //현재 나타내고자하는 달의 시작일(1일)
		var lastDate = new Date(today.getFullYear(), today.getMonth() + 1, 0); //현재 나타내고자하는 달의 마지막 일(각각의 월에 따라 다름으로 다음달의 -1일을 스크립트에서 0으로 세팅하면 된다.)
		var tbcal = document.getElementById("calendar"); // 테이블 달력을 만들 테이블
		var yearmonth = document.getElementById("yearmonth"); //  년도와 월 출력할곳
		yearmonth.innerHTML = today.getFullYear() + "년 "
				+ (today.getMonth() + 1) + "월"; //년도와 월 출력 => 달력 테이블의 첫번째 줄<tr>의 두번째 칸에 을 출력함

		if (today.getMonth() + 1 == 12) //  눌렀을 때 월이 넘어가는 곳 현재 12월달을 화면상에 표현하고 있다면 ...
		{
			before.innerHTML = (today.getMonth()) + "월"; //이전달 부분을 11월로 만들어주고
			next.innerHTML = "1월"; //다음 달부분을 (테이블 첫번째 줄의 세번째 칸)을 1월로 만들어주고
		} else if (today.getMonth() + 1 == 1) //  1월 일 때
		{
			before.innerHTML = "12월"; //이전달 부분을 12월로 만들고...
			next.innerHTML = (today.getMonth() + 2) + "월"; //다음달 부분을 2월로 만들고..
		} else //  1월도 아니고... 12월도 아니라면....
		{
			before.innerHTML = (today.getMonth()) + "월";
			next.innerHTML = (today.getMonth() + 2) + "월";
		}
		// 남은 테이블 줄 삭제 => 세번째 줄부터 마지막 줄까지를 삭제
		while (tbcal.rows.length > 2) {
			tbcal.deleteRow(tbcal.rows.length - 1);
		}
		var row = null;
		row = tbcal.insertRow(); //테이블의 줄을 삽입한다.
		var cnt = 0;

		// 1일 시작칸 찾기
		//nMonth.getDay() => 요일을 나타내는 함수임(일요일은 0이고 토요일은 6임) 수요일이면 3의 값을 가진다... 
		// 수요일이라면 3회 반복
		for (i = 0; i < nMonth.getDay(); i++) { // 일요일이면 한 번도 실행되지 않는다.
			cell = row.insertCell(); //칸을 삽입화요일이라면 두 칸이 삽입된다....빈칸만 삽입되는 역할을 한다. 
			cnt = cnt + 1; //화요일이라면 2가 되어 반복문을 탈출한다.
		}//달력의 시작일이 어느 칸에서부터 시작해야 하는지를 판단하는 부분

		// 달력 출력
		for (i = 1; i <= lastDate.getDate(); i++) // 1일부터 마지막 일까지
		{
			cell = row.insertCell();
			cell.innerHTML = i;
			cnt = cnt + 1;
			if (cnt % 7 == 1) {//일요일 계산
				cell.innerHTML = "<font color=#FF9090>" + i//일요일에 색
			}
			if (cnt % 7 == 0) { // 1주일이 7일 이므로 토요일 계산
				cell.innerHTML = "<font color=#7ED5E4>" + i//토요일에 색
				row = calendar.insertRow();// 줄 추가
			}
			if (today.getFullYear() == date.getFullYear()
					&& today.getMonth() == date.getMonth()
					&& i == date.getDate()) {
				cell.bgColor = "#BCF1B1"; //오늘날짜배경색
			}
		}

	}
</script>


</head>

<body onload="build();">

	<div id="container">
		<jsp:include page="menu.do"></jsp:include>
		<div id="rightmain">

			<h1>(주) 산적</h1>
			<table class="list3">
				<tr>
					<th>제목</th>
					<th>작성자</th>
					<th>등록일</th>
				</tr>
				<c:forEach items="${ bdList }" var="vo">
				<tr>
					<td><a href="getBoard.do?seq=${ vo.seq }">${ vo.title }</a></td>
					<td>${ vo.writer }</td>
					<td>${ vo.postDate }</td>
				</tr>
				</c:forEach>
			</table>
			<!-- <ul >
				<li>공지사항</li>
			</ul> -->
			
			<table align="center" id="calendar">
				<tr>
					<td><font size=1%; color="#B3B6B3"><label
							onclick="beforem()" id="before"></label></font></td>
					<td colspan="5" align="center" id="yearmonth"></td>
					<td><font size=1%; color="#B3B6B3"><label
							onclick="nextm()" id="next"></label></font></td>
				</tr>
				<tr>
					<td align="center"><font color="#FF9090">일</font></td>
					<td align="center">월</td>
					<td align="center">화</td>
					<td align="center">수</td>
					<td align="center">목</td>
					<td align="center">금</td>
					<td align="center"><font color=#7ED5E4>토</font></td>
				</tr>
			</table>

		</div>

	</div>
</body>
</html>



