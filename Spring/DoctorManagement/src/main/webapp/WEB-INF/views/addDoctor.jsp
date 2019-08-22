<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@ taglib uri = "http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Doctor</title>
</head>
<body>
<form:form action="addDoctor" method="post">
	<label>Doctor Id: </label>
	<form:input path="doctorId">
	</form:input><form:errors path ="doctorId"/>
	<label>Doctor Name</label>
	<form:input path="doctorName"></form:input>
	<label>Specialization</label>
	<form:select path="specialisation" items="${depts}"/>
	<label>Phone Number</label>
	<form:input path="phoneNumber"></form:input>
	<label>Address Line 1:</label>
	<form:input path="address.addrLine1"></form:input>
	<label>City:</label>
	<form:input path="address.city"></form:input>
	<label>Pincode: </label>
	<form:input path="address.pincode"></form:input>
	<input type= submit>
</form:form>
</body>
</html>