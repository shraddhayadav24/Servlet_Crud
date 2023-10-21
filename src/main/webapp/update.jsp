<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Update details</h1>
<form action="update" method="post">
Id:<input type="text" name="id" value="<%= request.getParameter("id")%>"><br><br>
Email:<input type="text" name="email"><br><br>
<input type="submit">

</form>
</body>
</html>