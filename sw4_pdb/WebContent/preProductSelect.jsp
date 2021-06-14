<%@page import="model.productVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	ArrayList<productVO> items = new ArrayList<>();
	items = (ArrayList<productVO>) request.getAttribute("list");
%>
</head>
<body>
<table>
<th>
<td>제품코드</td><td>제품이름</td><td>제품원가</td>
<td>목표수량</td><td>재고수량</td><td>출고가</td><td>그룹이름</td>
</th>

<%
for(productVO item : items){
	%><tr>
	<td> <%= item.code %> </td>
	<td> <%= item.pname %> </td>
	<td> <%= item.cost %> </td>
	<td> <%= item.pnum %> </td>
	<td> <%= item.jnum %> </td>
	<td> <%= item.sale %> </td>
	<td> <%= item.gcode %> </td>
	</tr><%
}
%>

</table>
<a href='productMain.jsp'>메인화면으로</a>
</body>
</html>