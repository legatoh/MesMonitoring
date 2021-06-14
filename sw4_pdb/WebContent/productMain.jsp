<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>일학습병행 출제</title>
<script src="../lib/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="ajax/jquery-3.4.1.js"></script>
<script type="text/javascript" src="ajax/ajaxCommunication.js"></script>
<script type="text/javascript">
	function selectPRS(str) {
		if (str == "pre") {
			prsForm.action = "preProductServlet";
			prsForm.submit();
		}
		if (str == "rank") {
			prsForm.action = "RankProductServlet";
			prsForm.submit();
		}
		if (str == "stock") {
			prsForm.action = "StockProductServlet";
			prsForm.submit();
		}
	}
</script>
</head>
<body>
<h1>생산관리 시스템</h1><br>
생산관리 메인메뉴<br>
<form name="prsForm" method="POST]">
	<input type='BUTTON' value='제품입력' 
		onclick="location.href='productInsert.jsp'">
	<input type='BUTTON' value='제품조회'
		onclick="location.href='productSelectUpdate.jsp'">
	<input type='BUTTON' value='우선생산제품'
		onclick="selectPRS('pre')">
	<input type='BUTTON' value='이익순위'
		onclick="selectPRS('rank')">
	<input type='BUTTON' value='그룹별재고수량'
		onclick="selectPRS('stock')">
</form>
</body>
</html>