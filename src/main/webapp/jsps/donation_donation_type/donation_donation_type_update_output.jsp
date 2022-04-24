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
  <h1>Update donation_donation_type</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	transaction_id    :<input type="text" name="transaction_id" value="${donation_donation_type.transaction_id }" disabled/>
	<br/>
	
	donation_type：<input type="text" name="donation_type" value="${donation_donation_type.donation_type }" disabled/>
	<br/>
</form>
<h1>Update the values below</h1>
<form action="<c:url value='/Donation_donation_typeServletUpdate'/>" method="post">
		<input type="hidden" name="method" value="update"/>
				<input type="hidden" name="transaction_id" value="${donation_donation_type.transaction_id }"/>
	transaction_id : <input type="text" name="transaction_id" value="${form.transaction_id }"/>
	<span style="color: red; font-weight: 900">${errors.transaction_id }</span>
	<br/>
	donation_type : <input type="text" name="donation_type" value="${form.donation_type }"/>
	<span style="color: red; font-weight: 900">${errors.donation_type }</span>
	<br/>
	<input type="submit" value="Update donation_donation_type"/>
</form>

</body>
</html>
