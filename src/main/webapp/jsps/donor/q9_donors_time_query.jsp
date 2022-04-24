<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center"> Donors Table </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>first_name</th>
		<th>last_name</th>
	</tr>
<c:forEach items="${DonorTimeList}" var="donor">
	<tr>
		<td>${donor.first_name}</td>
		<td>${donor.last_name}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>
