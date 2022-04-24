<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete volunteer_support_cause</title>
    
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
  <h1>Delete volunteer_support_cause</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/Volunteer_support_causeServletDelete'/>" method="post">
	<input type="hidden" name="method" value="delete"/>
		<input type="hidden" name="volunteer_id" value="${volunteer_support_cause.volunteer_id }"/>
		<input type="hidden" name="support_cause_id" value="${volunteer_support_cause.support_cause_id }"/>
	volunteer_id    :<input type="text" name="volunteer_id" value="${volunteer_support_cause.volunteer_id }" disabled/>
	<br/>
	
	support_cause_id：<input type="text" name="support_cause_id" value="${volunteer_support_cause.support_cause_id }" disabled/>
	<br/>
	<input type="submit" value="Delete volunteer_support_cause"/>
</form>

</body>
</html>
