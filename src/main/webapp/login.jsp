<%@ page language="java" contentType="text/html; charset=UTF-8"
	trimDirectiveWhitespaces="true" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	top: 380px;
	margin-left: -150px;
	margin-top: -150px;
	width: 400px;
	height: 250px;
}

form, tr, th {
	background-color: white;
}

input {
	background-color: white;
}

#log {
	background-color: #1a75ff;
	color: white;
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
	left: 1100px;
	top: 560px;
	margin-left: -150px;
	margin-top: -150px;
}
</style>
<body>
	<div>
		<form action="login.do" method="post">
			<table>
				<tr>
					<th>아이디</th>
					<th><input type="text" name="id" /></th>
				</tr>
				<tr>
					<th>비밀번호</th>
					<th><input type="password" name="password" /></th>
				</tr>
				<tr>
					<th><input id="log" type="submit" value="로그인" /></th>
				</tr>
			</table>
		</form>
	</div>
	<button id="btn1" type="button" onclick="location.href='joinForm.do' ">회원가입</button>
	

</body>
</html>