<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	function deleteBoard(isbn, title){
		if (confirm(title+" 도서를 삭제하시겠습니까??") == true){    //확인
			//location.href = 'BoardServlet?cmd=CMD_REMOVE&no='+no;
			document.frmSubmit.action="BookServlet"; 
			document.frmSubmit.method="post"; 
			
			var input1 = document.createElement("input");
			input1.setAttribute("type", "hidden");
			input1.setAttribute("name", "cmd");
			input1.setAttribute("value", "CMD_REMOVE");
			
			var input2 = document.createElement("input");
			input2.setAttribute("type", "hidden");
			input2.setAttribute("name", "isbn");
			input2.setAttribute("value", isbn);
			
			document.frmSubmit.appendChild(input1);
			document.frmSubmit.appendChild(input2);
			
			document.frmSubmit.submit();

		}else{   //취소
			
		}
	}
</script>
<title>Insert title here</title>
</head>
<body>
	<form name="frmSubmit" onsubmit="return false;">
	<table>
		<tbody>
				<tr>
					<th>ISBN</th>
					<td>${requestScope.detail.isbn}</td>
				</tr>
				<tr>
					<th>제목</th>
					<td>${requestScope.detail.title}</td>
				</tr>
				<tr>
					<th>저자</th>
					<td>${requestScope.detail.author}</td>
				</tr>
				<tr>
					<th>출판사</th>
					<td>${requestScope.detail.publicsher}</td>
				</tr>
				<tr>
					<th>가격</th>
					<td>${requestScope.detail.price}</td>
				</tr>
				<tr>
					<th>정보</th>
					<td>${requestScope.detail.description}</td>
				</tr>
		</tbody>
	</table>
	 <a href=<c:url value='/BookServlet?cmd=CMD_UPDATE_FORM&isbn=${requestScope.detail.isbn}'/>>수정</a><br>
	<button onclick="deleteBoard(${requestScope.detail.isbn}, '${requestScope.detail.title}');" >삭제</button>
	</form>
</body>
</html>