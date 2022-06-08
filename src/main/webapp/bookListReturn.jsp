<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="returnBook" method="post">
 Student Id <input type="number" name ="studentId" value=""> </input> <br> <br>
 Book Id <input type="number " name="bookId" value="<%=request.getParameter("id")%>">
 <input type="submit" value ="Submit"> </input> <br> <br>

</body>
</html>