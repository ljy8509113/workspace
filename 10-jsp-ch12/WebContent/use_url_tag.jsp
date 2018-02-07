<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<c:url value="http://search.daum.net/search" var="searchUrl">
		<c:param name="w" value="blog" />
		<c:param name="q" value="공원"></c:param>
	</c:url>
	
	<ul>
		<li>${searchUrl}</li>
		<li><c:url value="/use_if_tag.jsp"></c:url></li>
		<li><c:url value="./use_if_tag.jsp"></c:url></li>
	</ul>
</body>
</html>