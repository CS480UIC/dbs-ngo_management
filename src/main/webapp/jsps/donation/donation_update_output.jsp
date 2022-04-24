<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Donation</title>
    
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
  <h1>Update Donation</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	transaction_id    :<input type="text" name="transaction_id" value="${donation.transaction_id }" disabled/>
	<br/>
	donor_id：<input type="text" name="donor_id" value="${donation.donor_id }" disabled/>
	<br/>
	resource_id	：<input type="text" name="resource_id" value="${donation.resource_id }" disabled/>
	<br/>
	organization_id	：<input type="text" name="organization_id" value="${donation.organization_id }" disabled/>
	<br/>
	time	：<input type="text" name="time" value="${donation.time }" disabled/>
	<br/>
	amount	：<input type="text" name="amount" value="${donation.amount }" disabled/>
	<br/>
</form>
<h1>Update the values below</h1>
<form action="<c:url value='/DonationServletUpdate'/>" method="post">
		<input type="hidden" name="method" value="update"/>
				<input type="hidden" name="transaction_id" value="${donation.transaction_id }"/>
	donor_id ：<input type="text" name="donor_id" value="${form.donor_id }"/>
	<span style="color: red; font-weight: 900">${errors.donor_id }</span>
	<br/>
	resource_id	：<input type="text" name="resource_id" value="${form.resource_id }"/>
	<span style="color: red; font-weight: 900">${errors.resource_id }</span>
	<br/>
	organization_id	：<input type="text" name="organization_id" value="${form.organization_id }"/>
	<span style="color: red; font-weight: 900">${errors.organization_id }</span>
	<br/>
	time	：<input type="text" name="time" value="${form.time }"/>
	<span style="color: red; font-weight: 900">${errors.time }</span>
	<br/>	
	amount	：<input type="text" name="amount" value="${form.amount }"/>
	<span style="color: red; font-weight: 900">${errors.amount }</span>
	<br/>
	<input type="submit" value="Update donation"/>
</form>

</body>
</html>
