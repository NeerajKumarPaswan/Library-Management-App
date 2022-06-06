<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Book to be returned</h1>
<form action="returnBook" method ="post">
Book Id: <input type="text" name ="bookId"> </input> <br> <br>
Student Id: <input type="text" name ="studentId"> </input> <br> <br>
<input type="submit" value ="Return Book">




</form>
</body>
</html>