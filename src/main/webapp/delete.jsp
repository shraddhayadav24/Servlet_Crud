<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to Destroy Employees Career</h1>
<form action="delete" method="post">
Id: <input type="text" name="id" value="<%= request.getParameter("id") %>"><br><br>
<input type="submit">
</form>

</body>
</html>