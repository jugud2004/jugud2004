<%@page import="com.communication.stock.messages.MessagesVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	trimDirectiveWhitespaces="true" pageEncoding="UTF-8"%>
<%
	List<MessagesVO> msList = (List) request.getAttribute("messages");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/main.css" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		var Accordion = function(el, multiple) {
			this.el = el || {};
			this.multiple = multiple || false;

			var dropdownlink = this.el.find('.dropdownlink');
			dropdownlink.on('click', {
				el : this.el,
				multiple : this.multiple
			}, this.dropdown);
		};   

		Accordion.prototype.dropdown = function(e) {
			var $el = e.data.el, $this = $(this),
			$next = $this.next();

			$next.slideToggle();
			$this.parent().toggleClass('open');

			if (!e.data.multiple) {
				$el.find('.submenuItems').not($next).slideUp().parent()
						.removeClass('open');
			}
		}

		var accordion = new Accordion($('.accordion-menu'), false);
	})
</script>

<script src="https://kit.fontawesome.com/a076d05399.js"></script>

</head>
<body>


	<!-- <div id="container"> -->
		<div id="leftNav">
			<div id="image">
				<a href="main.do"><img src="/images/logo.jpg"></a>
			</div>
			<div id="soMenu">
				<nav id="simpleMenu">
					<ul>
						<li style="border-bottom: 1px solid #ccc;">
							
						<li><a class="menuLink" href="login.jsp">로그아웃</a></li>
					</ul>
				</nav> 
			</div>
	
			<!-- 메인메뉴  -->
			<div id="mainMenu">
				<ul class="accordion-menu">
					<!--게시판  -->
					<li>
						<div class="dropdownlink">
							<i class="fas fa-chalkboard" aria-hidden="true"></i>게시판 <i
								class="fa fa-chevron-down" aria-hidden="true"></i>
						</div>
						<ul class="submenuItems">
							<li><a href="board.do?classify=0">공지사항</a></li>
							<li><a href="board.do?classify=2">Q & A</a></li>
							<li><a href="board.do?classify=1">정보게시판</a></li>
						</ul>  
					</li>
					<!-- 재고관리 -->
					<li>
						<div class="dropdownlink">
							<i class="fas fa-warehouse" aria-hidden="true"></i>자재관리<i
								class="fa fa-chevron-down" aria-hidden="true"></i>
						</div>
						<ul class="submenuItems">
							<li><a href="itemsInfoTest.do">재고관리</a></li>
							<li><a href="itemsUpdateList.do">재고수정</a></li>
							<li><a href="itemDeleteList.do">재고삭제</a></li>

						</ul>
					</li>

					<!-- 입출고관리 -->
					<li>
						<div class="dropdownlink">
							<i class="fas fa-box" aria-hidden="true" ></i> 입출고관리 <i
								class="fa fa-chevron-down" aria-hidden="true"></i>
						</div>
						<ul class="submenuItems">
							<li><a href="itemsInsert.do">입고</a></li>
							<li><a href="itemReleaseList.do">출고</a></li>
						</ul>     
					</li>
  
					<!-- 청구 -->
					<li>
						<div class="dropdownlink">
							<i class="fas fa-dolly-flatbed" aria-hidden="true"></i>인사 <i
								class="fa fa-chevron-down" aria-hidden="true"></i>
						</div>
						<ul class="submenuItems"> <!-- 인사행정병만 볼수 있음 -->
							<li><%if(session.getAttribute("position").equals(311101)){ %><a href="usersControl.do">인사 관리</a><%} %></li>
						</ul>
					</li>
					
					<!-- 청구 -->
					<li>
						<div class="dropdownlink">
							<i class="#" aria-hidden="true"></i>알림 <strong style="color: <%if(msList.size()==0){%>black;<%}else{%>red;<%}%>"><%=msList.size()%></strong> <i
								class="fa fa-chevron-down" aria-hidden="true"></i>
						</div>
						<ul class="submenuItems">
							<li><a href="messageList.do">알림 목록</a></li>
						</ul>
					</li>
				</ul>
				
		
				
			</div>

		</div>
	
<!-- 	</div> -->


</body>
</html>