<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false" import="com.cenarius.form.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>MCQ Master - Login</title>
	<style type="text/css">
		body {
			font-family: sans-serif;
		}
		.data, .data td {
			border-collapse: collapse;
			width: 100%;
			border: 1px solid #aaa;
			margin: 2px;
			padding: 2px;
		}
		.data th {
			font-weight: bold;
			background-color: #5C82FF;
			color: white;
		}
	</style>
</head>
<body>
<h2>Please Login</h2>

<form:form method="post" action="login.html" commandName="user">

	<table>
	<tr>
		<td><form:label path="userName"><spring:message code="userr.userName"/></form:label></td>
		<td><form:input path="userName" /></td> 
	</tr>
	<tr>
		<td><form:label path="userPassword"><spring:message code="userr.userPassword"/></form:label></td>
		<td> <form:password path="userPassword" /></td>
	</tr>	
	<tr>
		<td colspan="2">
			<input type="submit" value="<spring:message code="userr.submit"/>"/>
		</td>
	</tr>
</table>	
</form:form>
</body>
</html>