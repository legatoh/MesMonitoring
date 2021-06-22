<%@page import="model.StockVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
request.setCharacterEncoding("utf-8");
ArrayList<StockVO> items= new ArrayList<>();
items= (ArrayList<StockVO>)request.getAttribute("StockList");

%>
<title>일학습병행제 평가</title>
</head>
<body>
	<table border=1>
		<th>그룹 이름</th>
		<th>재고 수량</th>
		<%
			if (items != null) {
				for (int i = 0; i < items.size(); i++) {
					String gname = items.get(i).gname;
					String jnum = items.get(i).jnum;
		%>
		<tr>
			<td><%=gname%></td>
			<td><%=jnum%></td>

		</tr>
		<%
			}
			}
		%>
	</table>
	<a href='productMain.jsp'>메인화면으로</a>
</body>
</html>