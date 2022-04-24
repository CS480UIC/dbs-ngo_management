<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Resource_store</title>
    
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
  <h1>Delete Resource_store</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/Resource_storeServletDelete'/>" method="post">
	<input type="hidden" name="method" value="delete"/>
		<input type="hidden" name="resource_id" value="${resource_store.resource_id }"/>
	resource_id    :<input type="text" name="resource_id" value="${resource_store.resource_id }" disabled/>
	<br/>
	name：<input type="text" name="name" value="${resource_store.name }" disabled/>
	<br/>
	type_name	：<input type="text" name="type_name" value="${resource_store.type_name }" disabled/>
	<br/>
	resource_count	：<input type="text" name="resource_count" value="${resource_store.resource_count }" disabled/>
	<br/>
	<input type="submit" value="Delete Resource_store"/>
</form>

</body>
</html>
