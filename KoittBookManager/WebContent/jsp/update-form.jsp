<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<h1>도서 정보 수정</h1>
	<a href="BookServlet?cmd=CMD_LIST">글 목록</a><br>
	<!--<a href=<c:url value='/BoardServlet?cmd=CMD_LIST' />> -->
	<form action="BookServlet" method="post">
	<!-- <form action=<c:url value='/BoardServlet' /> method="post">' -->
		<input type="hidden" name="cmd" value="CMD_UPDATE">
		<input type="hidden" name="isbn" value="${requestScope.detail.isbn}">
		<label>번호 : ${requestScope.detail.isbn}</label><br><br>
		<label>제목 : <input type="text" name="title" value="${requestScope.detail.title}"></label><br><br>
		<label>저자 : ${requestScope.detail.author}</label><br><br>
		<label>출판사 : <input type="text" name="publicsher" value="${requestScope.detail.publicsher}"></label><br><br>
		<label>가격 : <input type="text" name="price" value="${requestScope.detail.price}"></label><br><br>
		<label>내용 : <textarea rows="3" cols="50" name="description">${requestScope.detail.description}</textarea></label><br><br>
		<input type="submit" value="수정" />
	</form>
</body>
</html>