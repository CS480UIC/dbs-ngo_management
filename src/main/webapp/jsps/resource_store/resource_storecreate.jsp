<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Entity1 resource_store</title>
    
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
  <h1>Entity1 resource_store</h1>
<form action="<c:url value='/Entity1ServletCreate'/>" method="post">
	resource_name : <input type="text" name="resource_name" value="${form.username }"/>
	<span style="color: red; font-weight: 900">${errors.username }</span>
	<br/>
	type_name ： <input type="text" name="type_name" value="${form.password }"/>
	<span style="color: red; font-weight: 900">${errors.password }</span>
	<br/>
	resource_count	：<input type="text" name="resource_count" value="${form.email }"/>
	<span style="color: red; font-weight: 900">${errors.email }</span>
	<br/>
	<input type="submit" value="Create resource_store"/>
</form>
  </body>
</html>
