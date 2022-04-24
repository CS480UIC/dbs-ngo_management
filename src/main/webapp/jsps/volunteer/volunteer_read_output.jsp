<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Read Volunteer Output</title>
    
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
  <h1>Read Volunteer Output</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	volunteer_id    :<input type="text" name="volunteer_id" value="${volunteer.volunteer_id }" disabled/>
	<br/>
	first_name：<input type="text" name="first_name" value="${volunteer.first_name }" disabled/>
	<br/>
	last_name	：<input type="text" name="last_name" value="${volunteer.last_name }" disabled/>
	<br/>
	birth_date：<input type="text" name="birth_date" value="${volunteer.birth_date }" disabled/>
	<br/>
	address	：<input type="text" name="address" value="${volunteer.address }" disabled/>
	<br/>
	email	：<input type="text" name="email" value="${volunteer.email }" disabled/>
	<br/>
	phone	：<input type="text" name="phone" value="${volunteer.phone }" disabled/>
	<br/>
</form>

<button onclick="window.location.href='<c:url value='/jsps/main.jsp'/>'">Continue</button>
</body>
</html>
