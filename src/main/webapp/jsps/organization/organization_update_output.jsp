<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Organization</title>
    
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
  <h1>Update Organization</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	organization_id    :<input type="text" name="organization_id1" value="${organization.organization_id }" disabled/>
	<br/>
	
	organization_name：<input type="text" name="organization_name1" value="${organization.organization_name }" disabled />
	<br/>
	address	：<input type="text" name="address1" value="${organization.address }" disabled/>
	<br/>
	email	：<input type="text" name="email1" value="${organization.email }" disabled/>
	<br/>
	phone	：<input type="text" name="phone1" value="${organization.phone }" disabled/>
	<br/>
</form>
<h1>Update the values below</h1>
<form action="<c:url value='/OrganizationServletUpdate'/>" method="post">
		<input type="hidden" name="method" value="update"/>
				<input type="hidden" name="organization_id" value="${organization.organization_id }"/>
	organization_name：<input type="text" name="organization_name" value="${form.organization_name }"/>
	<span style="color: red; font-weight: 900">${errors.organization_name }</span>
	<br/>
	address	：<input type="text" name="address" value="${form.address }"/>
	<span style="color: red; font-weight: 900">${errors.address }</span>
	<br/>
	email：<input type="text" name="email" value="${form.email }"/>
	<span style="color: red; font-weight: 900">${errors.email }</span>
	<br/>
	phone	：<input type="text" name="phone" value="${form.phone }"/>
	<span style="color: red; font-weight: 900">${errors.phone }</span>
	<br/>
	<input type="submit" value="Update Organization"/>
</form>

</body>
</html>
