<%@ page import="model.productVO"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
	request.setCharacterEncoding("utf-8");
	ArrayList<productVO> items = new ArrayList<>();
	items = (ArrayList<productVO>)request.getAttribute("list");
%>


<title>일학습병행제 평가</title>
</head>
<body>
<table border=1>
<th>제품코드</th><th>제품이름</th><th>제품원가</th>
<th>목표수량</th><th>재고수량</th><th>출고가</th><th>그룹이름</th>
<%
if(items != null){
	for(int i=0; i<items.size(); i++){
		String code = items.get(i).code.intern();
		String pname = items.get(i).pname;
		String cost = items.get(i).cost;
		String pnum = items.get(i).pnum;
		String jnum = items.get(i).jnum;
		String sale = items.get(i).sale;
		String gcode = items.get(i).gcode;

%>
	<tr>
	<td> <%=code %> </td>
	<td> <%=pname %> </td>
	<td> <%=cost %> </td>
	<td> <%=pnum %> </td>
	<td> <%=jnum %> </td>
	<td> <%=sale %> </td>
	<td> <%=gcode %> </td>
	</tr>
<%
	}
}
%>
</table>
<a href='productMain.jsp'>메인화면으로</a>
</body>
</html>