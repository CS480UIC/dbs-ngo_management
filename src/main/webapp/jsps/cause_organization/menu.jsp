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
    <h1>CRUD operations for cause_organization </h1>
    <br>
	<a href="<c:url value='/jsps/cause_organization/cause_organizationcreate.jsp'/>" target="_parent">Create cause_organization</a> |&nbsp; 
	<a href="<c:url value='/jsps/cause_organization/cause_organizationread.jsp'/>" target="_parent">Read cause_organization</a> |&nbsp;
	<a href="<c:url value='/jsps/cause_organization/cause_organizationupdate.jsp'/>" target="_parent">Update cause_organization</a> |&nbsp;	 
	<a href="<c:url value='/jsps/cause_organization/cause_organizationdelete.jsp'/>" target="_parent">Delete cause_organization</a>	
	    
  </body>
</html>
