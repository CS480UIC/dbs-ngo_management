<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center"> Volunteer Table </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>volunteer_id</th>
		<th>first_name</th>
		<th>num_causes</th>
		<th>cause_name</th>
	</tr>
<c:forEach items="${VolunteerCauseList}" var="volunteercause">
	<tr>
		<td>${volunteercause.volunteer_id}</td>
		<td>${volunteercause.first_name}</td>
		<td>${volunteercause.num_causes}</td>
		<td>${volunteercause.cause_name}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>
