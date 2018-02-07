<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.Map" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<b>request.getParameter()</b>
	name = <%= request.getParameter("name") %><br/>
	address = <%= request.getParameter("address") %><br/>
	<p/>
	<b>request.getParameterValue()</b><br>
	<%
		String[] values = request.getParameterValues("pet");
		if(values != null){
			for(int i=0; i<values.length; i++){
				%>
					<%= values[i] %>
				<%
			}
		}
	%>
	<p>
	<b>request.getParameterNames() 메서드 사용</b>
	<%
		Enumeration paramEnum = request.getParameterNames();
		while(paramEnum.hasMoreElements()){
			String name = (String)paramEnum.nextElement();
			%>
				<%= name %>
			<%
			}
	%>
	<p>
	<b>request.getParameterMap() 메서드 사용</b>
	<%
		Map<String, String[]> parameterMap = request.getParameterMap();
		String[] nameParam = (String[]) parameterMap.get("name");
		if(nameParam != null){
			%>
				name = <%=nameParam[0] %>
			<%
		}
	%>
</body>
</html>