<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	td{
		border : 1px solid black;
		width : 20px;
		height : 20px;
	}
</style>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
	
</script>

<script type="text/javascript">
	function tableRow(){
		var tableSelect = document.getElementById("calendar"); // 테이블 달력을 만들 테이블
		var startVal = 3;// 해당 요일의 값
		var lastDay = 30;// 해당 월의 마지막날
		var rowCount = 5;//함수를 통해서 반환되는 결과 값을 저장한다. 최악의 경우 6, 최상의 경우 4, 대부분 5
		for(let i= 0; i < rowCount; i++){
			let selRow = tableSelect.insertRow();
			for(let j = 0; j < 7; j++){
				selRow.insertCell();
			}
		}
		backcolor(startVal, lastDay);
	}
	
	function backcolor(startVal, lastDay){
		console.log(startVal, lastDay);
		var cnt = $('#calendar tr>td');
		for(let i = 14; i < cnt.length; i++){
			if( i % 7 == 0) $(cnt[i]).css("background", "red");
			if( i % 7 == 6) $(cnt[i]).css("background", "blue");
			if(i >= 14+startVal && i<= lastDay+16){
				$(cnt[i]).text(i-16);
			}
		}
		//수요일이라면 = > 3 
		//start num = 1부터 28또는, 30또는 31일
		
	}
</script>
</head>
<body onload="tableRow()">
<table id="calendar">
	<tr>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<td>일</td>
		<td>월</td>
		<td>화</td>
		<td>수</td>
		<td>목</td>
		<td>금</td>
		<td>토</td>
	</tr>
</table>
</body>
</html>