<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Read Resource_usage Output</title>
    
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
  <h1>Read Resource_usage Output</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	usage_id    :<input type="text" name="usage_id" value="${resource_usage.usage_id }" disabled/>
	<br/>
	
	resource_id：<input type="text" name="resource_id" value="${resource_usage.resource_id }" disabled/>
	<br/>
	organization_id	：<input type="text" name="organization_id" value="${resource_usage.organization_id }" disabled/>
	<br/>
	usage_count	：<input type="text" name="usage_count" value="${resource_usage.usage_count }" disabled/>
	<br/>
</form>

<button onclick="window.location.href='<c:url value='/jsps/main.jsp'/>'">Continue</button>
</body>
</html>
