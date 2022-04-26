<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>top</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	body {
		background: #4682B4; 
	}
	a {
		text-transform:none;
		text-decoration:none;
	} 
	a:hover {
		text-decoration:underline;
	}
</style>
  </head>
  
  <body>
<h1 style="text-align: center;">NGO Database Management System</h1>
<div style="font-size: 10pt;">
	<c:choose>
		<c:when test="${empty sessionScope.session_user }">
			<a href="<c:url value='/jsps/user/login.jsp'/>" target="_parent">Login</a> |&nbsp; 
			<a href="<c:url value='/jsps/user/regist.jsp'/>" target="_parent">Register</a> |&nbsp; 
			<a href="<c:url value='/jsps/initialize/init.jsp'/>" target="body">Initialize Database</a> |&nbsp;&nbsp;
			<a href="<c:url value='/jsps/initialize/delete.jsp'/>" target="body">Delete all Tables</a> |&nbsp;&nbsp;
		</c:when>
		<c:otherwise>
			Hello：${sessionScope.session_user.username };
			<a href="<c:url value='/jsps/user/queries.jsp'/>" target="body">Query Result</a> |&nbsp;&nbsp;
			<a href="<c:url value='/UserServletLogout'/>" target="_parent">Logout</a> |&nbsp; 
			<a href="<c:url value='/jsps/cause/menu.jsp'/>" target="body">CRUD cause</a> |&nbsp;&nbsp;
			<a href="<c:url value='/jsps/organization/menu.jsp'/>" target="body">CRUD organization</a> |&nbsp;&nbsp;
			<a href="<c:url value='/jsps/volunteer/menu.jsp'/>" target="body">CRUD volunteer</a> |&nbsp;&nbsp;
			<a href="<c:url value='/jsps/donor/menu.jsp'/>" target="body">CRUD donor</a> |&nbsp;&nbsp;
			<a href="<c:url value='/jsps/employee/menu.jsp'/>" target="body">CRUD employee</a> |&nbsp;&nbsp;
			<a href="<c:url value='/jsps/donation/menu.jsp'/>" target="body">CRUD donation</a> |&nbsp;&nbsp;  
			<a href="<c:url value='/jsps/resource_store/menu.jsp'/>" target="body">CRUD resource_store</a> |&nbsp;&nbsp;
			<a href="<c:url value='/jsps/resource_usage/menu.jsp'/>" target="body">CRUD resource_usage</a> |&nbsp;&nbsp;
			<a href="<c:url value='/jsps/volunteer_support_cause/menu.jsp'/>" target="body">CRUD volunteer_support_cause</a> |&nbsp;&nbsp;
			<a href="<c:url value='/jsps/cause_organization/menu.jsp'/>" target="body">CRUD cause_organization</a> |&nbsp;&nbsp;
			<a href="<c:url value='/jsps/donation_donation_type/menu.jsp'/>" target="body">CRUD donation_donation_type</a> |&nbsp;&nbsp;		
		</c:otherwise>
	</c:choose>

</div>
  </body>
</html>

