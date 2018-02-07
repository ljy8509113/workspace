<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.Enumeration" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<%
	Enumeration<String> attrEnum = application.getAttributeNames();
	while(attrEnum.hasMoreElements()){
		String name = attrEnum.nextElement();

		Object value = application.getAttribute(name);
	%>
		application 속성 :  <%=name %> = <%=value %>
	<%}%>

</body>
</html>