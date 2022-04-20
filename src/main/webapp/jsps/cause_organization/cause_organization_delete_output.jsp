<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Cause_organization</title>
    
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
  <h1>Delete Cause_organization</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/Cause_organizationServletDelete'/>" method="post">
	<input type="hidden" name="method" value="delete"/>
		<input type="hidden" name="cause_id" value="${cause_organization.cause_id }"/>
		<input type="hidden" name="organization_id" value="${cause_organization.organization_id }"/>
	cause_id    :<input type="text" name="cause_id" value="${cause_organization.cause_id }" disabled/>
	<br/>
	
	organization_id：<input type="text" name="organization_id" value="${cause_organization.organization_id }" disabled/>
	<br/>
	<input type="submit" value="Delete Cause_organization"/>
</form>

</body>
</html>
