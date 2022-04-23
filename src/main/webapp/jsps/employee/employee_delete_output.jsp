<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Employee</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <h1>Delete Employee</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/EmployeeServletDelete'/>" method="post">
	<input type="hidden" name="method" value="delete"/>
		<input type="hidden" name="employee_id" value="${employee.employee_id }"/>
	employee_id    :<input type="text" name="employee_id" value="${employee.employee_id }" disabled/>
	<br/>
	first_name：<input type="text" name="first_name" value="${employee.first_name }" disabled/>
	<br/>
	last_name	：<input type="text" name="last_name" value="${employee.last_name }" disabled/>
	<br/>
	ssn	：<input type="text" name="ssn" value="${employee.ssn }" disabled/>
	<br/>
	organization_id	：<input type="text" name="organization_id" value="${employee.organization_id }" disabled/>
	<br/>
	salary    :<input type="text" name="salary" value="${employee.salary }" disabled/>
	<br/>
	birth_date：<input type="text" name="birth_date" value="${employee.birth_date }" disabled/>
	<br/>
	address	：<input type="text" name="address" value="${employee.address }" disabled/>
	<br/>
	email	：<input type="text" name="email" value="${employee.email }" disabled/>
	<br/>
	phone	：<input type="text" name="phone" value="${employee.phone }" disabled/>
	<br/>

	<input type="submit" value="Delete Employee"/>
</form>

</body>
</html>
