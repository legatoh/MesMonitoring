<%@page import="model.RankVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
	request.setCharacterEncoding("utf-8");
	ArrayList<RankVO> items = new ArrayList<>();
	items = (ArrayList<RankVO>) request.getAttribute("RankList");
%>
<title>일학습병행제 평가</title>
</head>
<body>
	<table border=1>
		<th>제품 이름</th>
		<th>총 이익 금액</th>
		<%
			if (items != null) {
				for (int i = 0; i < items.size(); i++) {
					String pname = items.get(i).pname;
					String scost = items.get(i).scost;
		%>
		<tr>
			<td><%=pname%></td>
			<td><%=scost%></td>

		</tr>
		<%
			}
			}
		%>
	</table>
	<a href='productMain.jsp'>메인화면으로</a>
</body>
</html>