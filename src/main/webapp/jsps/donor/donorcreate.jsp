<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>donor Create</title>
    
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
  <h1>donor Create</h1>
<form action="<c:url value='/DonorServletCreate'/>" method="post">
	donor_id    :<input type="text" name="donor_id" value="${form.donor_id }"/>
	<span style="color: red; font-weight: 900">${errors.donor_id }</span>
	<br/>
	first_name    :<input type="text" name="first_name" value="${form.first_name }"/>
	<span style="color: red; font-weight: 900">${errors.first_name }</span>
	<br/>
	last_name ：<input type="text" name="last_name" value="${form.last_name }"/>
	<span style="color: red; font-weight: 900">${errors.last_name }</span>
	<br/>
	birth_date	：<input type="text" name="birth_date" value="${form.birth_date }"/>
	<span style="color: red; font-weight: 900">${errors.birth_date }</span>
	<br/>
	address	：<input type="text" name="address" value="${form.address }"/>
	<span style="color: red; font-weight: 900">${errors.address }</span>
	<br/>
	email ： <input type="text" name="email" value="${form.email }"/>
	<span style="color: red; font-weight: 900">${errors.email }</span>
	<br/>
	phone ： <input type="text" name="phone" value="${form.phone }"/>
	<span style="color: red; font-weight: 900">${errors.phone }</span>
	<br/>
	num_of_donations ： <input type="text" name="num_of_donations" value="${form.num_of_donations }"/>
	<span style="color: red; font-weight: 900">${errors.num_of_donations }</span>
	<br/>
	last_donation ： <input type="text" name="last_donation" value="${form.last_donation }"/>
	<span style="color: red; font-weight: 900">${errors.last_donation }</span>
	<br/>
	<input type="submit" value="Create donor"/>
</form>
  </body>
</html>
