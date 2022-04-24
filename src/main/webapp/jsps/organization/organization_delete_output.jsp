<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Organization</title>
    
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
  <h1>Delete Organization</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/OrganizationServletDelete'/>" method="post">
	<input type="hidden" name="method" value="delete"/>
		<input type="hidden" name="organization_id" value="${organization.organization_id }"/>
	organization_id    :<input type="text" name="organization_id" value="${organization.organization_id }" disabled/>
	<br/>
	
	organization_name：<input type="text" name="organization_name" value="${organization.organization_name }" disabled/>
	<br/>
	address	：<input type="text" name="address" value="${organization.address }" disabled/>
	<br/>
	email	：<input type="text" name="email" value="${organization.email }" disabled/>
	<br/>
	phone	：<input type="text" name="phone" value="${organization.phone }" disabled/>
	<br/>
	<input type="submit" value="Delete Organization"/>
</form>

</body>
</html>
