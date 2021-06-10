<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>일학습병행제 평가</title>
<script src="../lib/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="ajax/jquery-3.4.1.js"></script>
<script type="text/javascript" src="ajax/ajaxCommunication.js"></script>
<script type="text/javascript">
	function selectSUD(str) {
		if (str == "sel") {
			sudForm.action = "selectServlet";
			sudForm.submit();
		}
		if (str == "upd") {
			sudForm.action = "updateServlet";
			sudForm.submit();
		}
		if (str == "del") {
			sudForm.action = "deleteServlet";
			sudForm.submit();
		}
	}
</script>
<%
	String code = (String)request.getAttribute("code"); 
	String pname = (String)request.getAttribute("pname");
	String cost = (String)request.getAttribute("cost");
	String pnum = (String)request.getAttribute("pnum");
	String jnum = (String)request.getAttribute("jnum");
	String sale = (String)request.getAttribute("sale");
	String gcode = (String)request.getAttribute("gcode");
%>  
</head>
<body>
	<h1>생산관리 조회 & 수정 화면</h1>
	<br> 생산관리 조회화면
	<br>
	<form name="sudForm" method="POST">
		<ul>
			<li>제품코드 <input type="text" name="code" value=<%=code %>></li>
			<li>제품이름 <input type="text" name="pname" value=<%=pname %>></li>
			<li>제품원가 <input type="text" name="cost" value=<%=cost %>></li>
			<li>목표수량 <input type="text" name="pnum" value=<%=pnum %>></li>
			<li>재고수량 <input type="text" name="jnum" value=<%=jnum %>></li>
			<li>출고가&nbsp;&nbsp;&nbsp;
						<input type="text" name="sale" value=<%=sale %>></li>
			<li>그룹이름 <select name="gcode">
					<option value="A" <c:if test="${gcode=='A'}"> selected </c:if>>컴퓨터</option>
					<option value="B" <c:if test="${gcode=='B'}"> selected </c:if>>냉장고</option>
					<option value="C" <c:if test="${gcode=='C'}"> selected </c:if>>냉장소모품</option>
			</select>
			</li>
		</ul>
		<input type='BUTTON' value='조회' name='sel' onclick="selectSUD('sel')">
		<input type='BUTTON' value='수정' name='upd' onclick="selectSUD('upd')">
		<input type='BUTTON' value='삭제' name='del' onclick="selectSUD('del')">
		<input type='BUTTON' value='메인화면'
			onclick="location.href='productManagerSystem.jsp'">
	</form>


</body>
</html>