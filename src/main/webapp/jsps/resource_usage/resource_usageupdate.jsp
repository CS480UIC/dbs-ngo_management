<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Update Resource_usage</title>
    
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
  <h1>Update Resource_usage</h1>
<form action="<c:url value='/Resource_usageServletUpdate'/>" method="post">
	<input type="hidden" name="method" value="search"/>
	Update usage_id   :<input type="text" name="usage_id" value="${form.usage_id }"/>
	<span style="color: red; font-weight: 900">${errors.usage_id }</span>
	<br/>
	<input type="submit" value="Update Resource_usage"/>
</form>
  </body>
</html>
