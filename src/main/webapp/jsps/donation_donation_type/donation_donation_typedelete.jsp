<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete donation_donation_type</title>
    
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
  <h1>Delete donation_donation_type</h1>
<form action="<c:url value='/Donation_donation_typeServletDelete'/>" method="post">
	<input type="hidden" name="method" value="search"/>
	Delete transaction_id   :<input type="text" name="transaction_id" value="${form.transaction_id }"/>
	<span style="color: red; font-weight: 900">${errors.transaction_id }</span>
	<br/>
	Delete donation_type   :<input type="text" name="donation_type" value="${form.donation_type }"/>
	<span style="color: red; font-weight: 900">${errors.donation_type }</span>
	<br/>
	<input type="submit" value="Delete donation_donation_type"/>
</form>
  </body>
</html>
