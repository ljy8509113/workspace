<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<h1>도서 등록</h1>
	<a href="BookServlet?cmd=CMD_LIST">글 목록</a>
	<form action="BookServlet" method="post">
		<input type="hidden" name="cmd" value="CMD_INSERT">
		<label>책 제목 : <input type="text" name="title"/></label><br>
		<label>작가 : <input type="text" name="author"/></label><br>
		<label>출판사 : <input type="text" name="publicsher"/></label><br>
		<label>가격 : <input type="text" name="price"/></label><br>
		<label>정보 : <textarea rows="3" cols="50" name="description"></textarea></label><br>
		<input type="submit" value="도서 등록" />
	</form>
</body>
</html>
<!-- title, author, publicsher, price, description  -->
