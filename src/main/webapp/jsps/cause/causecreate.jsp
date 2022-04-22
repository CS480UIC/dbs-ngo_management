<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>cause Create</title>
    
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
  <h1>cause Create</h1>
<form action="<c:url value='/CauseServletCreate'/>" method="post">
	cause_id    :<input type="text" name="cause_id" value="${form.cause_id }"/>
	<span style="color: red; font-weight: 900">${errors.cause_id }</span>
	<br/>
	cause_name：<input type="text" name="cause_name" value="${form.cause_name }"/>
	<span style="color: red; font-weight: 900">${errors.cause_name }</span>
	<br/>
	cause_supported：<input type="text" name="cause_supported" value="${form.cause_supported }"/>
	<span style="color: red; font-weight: 900">${errors.cause_supported }</span>
	<br/>
	cause_funds_raised：<input type="text" name="cause_funds_raised" value="${form.cause_funds_raised }"/>
	<span style="color: red; font-weight: 900">${errors.cause_funds_raised }</span>
	<br/>	
	<input type="submit" value="Create cause"/>
</form>
  </body>
</html>
