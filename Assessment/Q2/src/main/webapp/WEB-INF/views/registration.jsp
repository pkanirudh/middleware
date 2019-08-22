<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<form:form action="validate" method="POST">
<label>Username</label>
<form:input type="text" path=""/>

<label>Password</label>
<form:input type="password" path=""/>

<label>Email</label>
<form:input type="text" path=""/>

<label>Contact</label>
<form:input type="text" path=""/>

<label>City</label>
<form:input type="text" path=""/>

<label>Zip Code</label>
<form:input type="text" path=""/>

<input type="submit" value="Register">


</form:form>
</div>
</body>
</html>