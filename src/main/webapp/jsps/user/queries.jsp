<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="">
    
    <title>body</title>
    
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
    <h1>Welcome to the Demo</h1>
    <br>
    <a href="<c:url value='/findAll'/>" target="body">Please list all the user in the table</a>&nbsp;&nbsp;
    <br>
    
    <h3>Simple Queries</h3>
    <a href="<c:url value='/findEmployees'/>" target="body">Please list all employees with salary between 50000 and 100000</a>&nbsp;&nbsp;
    <br>
    <a href="<c:url value='/findDonations'/>" target="body">Please list all donations with amounts between 1000 and 10000</a>&nbsp;&nbsp;
    <br>
    <a href="<c:url value='/findVolunteers'/>" target="body">Please list all volunteers with whose are born before Jan 1st 1980</a>&nbsp;&nbsp;
    <br>
    
    <h3>Aggregate Queries</h3>
    <a href="<c:url value='/findExpense'/>" target="body">Please list total expense of NGO in Chicago</a>&nbsp;&nbsp;
    <br>
    <a href="<c:url value='/findTotalDonation'/>" target="body">Please list number of donations before 2022-02-03 05:00:00</a>&nbsp;&nbsp;
    <br>
    <a href="<c:url value='/findNumberDonations'/>" target="body">Please list total number of donations by each user</a>&nbsp;&nbsp;
    <br>
    
    <h3>Complex Queries</h3>
    <a href="<c:url value='/findEmployeeOrg'/>" target="body">Please list All employees and organizations they belong</a>&nbsp;&nbsp;
    <br>
    <a href="<c:url value='/findDonateTime'/>" target="body">Please list names of donors who made donation before 2022-02-03 05:00:00</a>&nbsp;&nbsp;
    <br>
    <a href="<c:url value='/findVolunteerCause'/>" target="body">Please list all volunteers and causes supported by them</a>&nbsp;&nbsp;
    

  </body>
</html>
