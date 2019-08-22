<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Find flights</title>
</head>
<body>
<form:form action="findMyFlight" method="POST">
<label>Source</label>
<form:input path="source"/>
<br/><br/>
<label>Destination</label>
<form:input path="destination"/>
<br/><br/>
<input type="submit" value="ADD">
</form:form>
</body>
</html>