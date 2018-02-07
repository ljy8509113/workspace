<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<h1>도서 목록</h1><br/>
	<a href="BookServlet?cmd=CMD_INSERT_FORM">도서 등록</a>
	<table>
		<thead>
			<tr>
				<th>ISBN</th>
				<th>제목</th>
				<th>저자</th>
				<th>출판사</th>
				<th>가격</th>
				<th>정보</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items='${requestScope.list}' var='book'>
				<tr>
					<td>${book.isbn}</td>
					<td><a href="BookServlet?cmd=CMD_DETAIL&isbn=${book.isbn}">${book.title}</a></td>
					<td>${book.author}</td>
					<td>${book.publicsher}</td>
					<td>${book.price}</td>
					<td>${book.description}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>