<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>일학습병행 출제</title>
</head>
<body>
<h1>생산관리 시스템</h1><br>
생산관리 메인메뉴<br>
<form>
	<input type='BUTTON' value='제품입력' 
		onclick="location.href='productInsert.jsp'">
	<input type='BUTTON' value='제품조회'
		onclick="location.href='productSelectUpdate.jsp'">
	<input type='BUTTON' value='우선생산제품'
		onclick="location.href='productSelect.jsp'">
	<input type='BUTTON' value='이익순위'
		onclick="location.href='productSelect.jsp'">
	<input type='BUTTON' value='그룹별재고수량'
		onclick="location.href='productSelect.jsp'">
</form>
</body>
</html>