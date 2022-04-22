<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Read Cause Output</title>
    
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
  <h1>Read Cause Output</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	cause_id    :<input type="text" name="cause_id" value="${cause.cause_id }" disabled/>
	<br/>
	cause_name：<input type="text" name="cause_name" value="${cause.cause_name }" disabled/>
	<br/>
	cause_supported	：<input type="text" name="cause_supported" value="${cause.cause_supported }" disabled/>
	<br/>
	cause_funds_raised	：<input type="text" name="cause_funds_raised" value="${cause.cause_funds_raised }" disabled/>
	<br/>
</form>

<button onclick="window.location.href='<c:url value='/jsps/main.jsp'/>'">Continue</button>
</body>
</html>
