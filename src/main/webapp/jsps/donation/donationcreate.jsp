<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>donation Create</title>
    
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
  <h1>donation Create</h1>
<form action="<c:url value='/Entity1ServletCreate'/>" method="post">
	donor_id ：<input type="text" name="donor_id" value="${form.password }"/>
	<span style="color: red; font-weight: 900">${errors.password }</span>
	<br/>
	resource_id	：<input type="text" name="resource_id" value="${form.email }"/>
	<span style="color: red; font-weight: 900">${errors.email }</span>
	<br/>
	organization_id	：<input type="text" name="organization_id" value="${form.email }"/>
	<span style="color: red; font-weight: 900">${errors.email }</span>
	<br/>
	amount	：<input type="text" name="amount" value="${form.email }"/>
	<span style="color: red; font-weight: 900">${errors.email }</span>
	<br/>
	<input type="submit" value="Create donation"/>
</form>
  </body>
</html>
