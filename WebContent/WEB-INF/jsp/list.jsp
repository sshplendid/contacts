<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.multi.contacts.biz.domain.*" %>
<%
	List<Contact> list = (List<Contact>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CURD 연락처 샘플</title>
</head>
<body>
	<div style="border:solid 1px black;">
		<form id="contactForm" method="POST" action="add.do">
			<span>번호: </span><input type="text" name="no" placeholder="0" readonly /><br />
			<span>이름: </span><input type="text" name="name" placeholder="홍길동" /><br />
			<span>전화번호: </span><input type="text" name="tel" placeholder="000-000-0000" /><br />
			<span>주소: </span><input type="text" name="address" placeholder="서울시 강남구 역삼동" /><br />
			<br />
			<input id="add" type="button" value="추가" />
			<input id="update" type="button" value="수정" />
		</form>
	</div>
	<hr />
	<div id="list">
	<% for (Contact c : list) {%>
	<%=c.getNo() %> : <%=c.getName() %>, <%=c.getTel() %>, <%=c.getAddress() %> <br />
	<% } %>
	</div>
	
	<script>
		var f = document.forms.contactForm;
		var no = document.getElementsByName('no')[0];
		var addBtn = document.getElementById('add');
		var updateBtn = document.getElementById('update');
		
		addBtn.onclick = function() {
			no.value='0';
			f.submit();
		}
		updateBtn.onclick = function() {
			f.action = 'update.do';
			f.submit();
		}
		
	</script>
</body>
</html>