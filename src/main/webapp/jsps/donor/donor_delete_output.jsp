<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Donor</title>
    
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
  <h1>Delete Donor</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/DonorServletDelete'/>" method="post">
	<input type="hidden" name="method" value="delete"/>
		<input type="hidden" name=donor_id value="${donor.donor_id }"/>
	donor_id    :<input type="text" name="donor_id" value="${donor.donor_id }" disabled/>
	<br/>
	first_name：<input type="text" name="first_name" value="${donor.first_name }" disabled/>
	<br/>
	last_name	：<input type="text" name="last_name" value="${donor.last_name }" disabled/>
	<br/>
	birth_date：<input type="text" name="birth_date" value="${donor.birth_date }" disabled/>
	<br/>
	address	：<input type="text" name="address" value="${donor.address }" disabled/>
	<br/>
	email	：<input type="text" name="email" value="${donor.email }" disabled/>
	<br/>
	phone	：<input type="text" name="phone" value="${donor.phone }" disabled/>
	<br/>
	num_of_donations	：<input type="text" name="num_of_donations" value="${donor.num_of_donations }" disabled/>
	<br/>
	last_donation	：<input type="text" name="last_donation" value="${donor.last_donation }" disabled/>
	<br/>
	<input type="submit" value="Delete Donor"/>
</form>

</body>
</html>
