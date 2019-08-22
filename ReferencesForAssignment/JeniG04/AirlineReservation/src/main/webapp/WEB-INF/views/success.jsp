<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success</title>
</head>
<body>
<!-- <h4>success</h4> -->
<c:forEach items="${flightlist}" var="eachFlight">
   <tr>      
    <td>${eachFlight.source}</td>
       <td>${eachFlight.destination}</td>
       <td>${eachFlight.airline}</td>
       <td>${eachFlight.flight_number}</td>
       <td>${eachFlight.price}</td>
       <td>${eachFlight.travel_time}</td>  
       <td>${eachFlight.available_seat}</td> 
       <input type="submit" value="BOOK">
   </tr>
   <br/><br/>
</c:forEach>
<%-- <p>${flightList}</p> --%>
</body>
</html>


