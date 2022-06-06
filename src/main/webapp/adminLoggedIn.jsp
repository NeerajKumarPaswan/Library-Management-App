<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Admin logged in</h1> 
    <form action="librarian" method="post">
     Id : <input type ="text" name ="libId"> <br> <br>
     Name : <input type ="text" name ="libName"> <br> <br>
     Phone : <input type ="number" name ="libPhone"> <br> <br>
    Email : <input type ="email" name ="libEmail"> <br> <br>
    Password: <input type ="password" name ="libPassword"> <br> <br>
    
    
 <input type="submit" value="CREATE Librarian"> <br> <br>

    
    
    
    
    
    
    </form>
</body>
</html>