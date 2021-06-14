<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>일학습병행제 평가</title>
</head>
<body>
<h1>생산관리 등록화면</h1><br>
생산관리 등록화면<br>
<form action="insertServlet" method="POST">
<ul>
<li>제품코드 <input type="text" name="code"></li>
<li>제품이름 <input type="text" name="pname"></li>
<li>제품원가 <input type="text" name="cost"></li>
<li>목표수량 <input type="text" name="pnum"></li>
<li>재고수량 <input type="text" name="jnum"></li>
<li>출고가&nbsp;&nbsp;&nbsp; <input type="text" name="sale"></li>
<li>그룹이름 
	<select name="gcode">
		<option value="A">컴퓨터</option>
		<option value="B">냉장고</option>
		<option value="C">냉장소모품</option>
	</select>
</li>
</ul>
	<input type='submit' value='등록' >
	<input type='BUTTON' value='메인화면'
		onclick="location.href='productMain.jsp'">
</form>
</body>
</html>