<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title boo</title>
</head>
<body>


<table>
<thead>
<tr>
<td>Id</td>
<td>Name</td>
<td>Specialization</td>
<td>Phone Number</td>
<td>Address</td>
</tr>
</thead>
<tbody>
<tr>
<td>${command.doctorId}</td>
<td>${command.doctorName}</td>
<td>${command.specialisation}</td>
<td>${command.phoneNumber}</td>
<td>${command.address.addrLine1}, ${command.address.city}, ${command.address.pincode}</td>
</tr>
</tbody>
</table>
</body>
</html>