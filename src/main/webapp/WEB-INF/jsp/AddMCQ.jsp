<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="true"%>
<html>
<head>
	<title>MCQ Addition</title>
	<link href="css/jquery-ui.min.css" rel="stylesheet">
	<script src="js/jquery.js"></script>
	<script src="js/jquery-ui.min.js"></script>
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

<h2>MCQ Manager</h2>

<form:form method="post" action="addMCQ.html" commandName="mcq">
<br>



		<!-- <form:input path="topic" /> -->
<br>
	<table>
			<tr>
				<td><form:label path="topic">
						<spring:message code="label.topic" />
					</form:label></td>
				<td><form:select path="topic">
						<form:option value=""></form:option>
						<form:option value="Constitution"></form:option>
						<form:option value="Substitution"></form:option>
						<form:option value="Prosecution"></form:option>
					</form:select></td>
			</tr>
			<tr>
				<td><form:label path="question">
						<spring:message code="label.question" />
					</form:label></td>
				<td><form:input path="question" /></td>
			</tr>
			<tr>
				<td><form:label path="option1">
						<spring:message code="label.option1" />
					</form:label></td>
				<td><form:input path="option1" /></td>
			</tr>
			<tr>
				<td><form:label path="option2">
						<spring:message code="label.option2" />
					</form:label></td>
				<td><form:input path="option2" /></td>
			</tr>
			<tr>
				<td><form:label path="option3">
						<spring:message code="label.option3" />
					</form:label></td>
				<td><form:input path="option3" /></td>
			</tr>
			<tr>
				<td><form:label path="option4">
						<spring:message code="label.option4" />
					</form:label></td>
				<td><form:input path="option4" /></td>
			</tr>
			<tr>
				<td><form:label path="option5">
						<spring:message code="label.option5" />
					</form:label></td>
				<td><form:input path="option5" /></td>
			</tr>
			<tr>
				<td><form:label path="answer">
						<spring:message code="label.answer" />
					</form:label></td>
				<td><form:select path="answer">
						<form:option value=""></form:option>
						<form:option value="1"></form:option>
						<form:option value="2"></form:option>
						<form:option value="3"></form:option>
						<form:option value="4"></form:option>
						<form:option value="5"></form:option>
					</form:select></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"
					value="<spring:message code="label.createQuestion"/>" /></td>
			</tr>
		</table>	
</form:form>
<h3>Take tests </h3>
<form:form  method="post" action="takeTest.html" commandName="testDTO">
    <br>
		<table>
			<tr>
			<td>Topic :</td>
			<td>
			<form:select path="topic">
						<form:option value=""></form:option>
						<form:option value="Constitution"></form:option>
						<form:option value="Substitution"></form:option>
						<form:option value="Prosecution"></form:option>
					</form:select>
			</td>
			</tr>

			<tr>
			<td>TestLimit :</td>
			<td><form:select path="testLimit">
						<form:option value=""></form:option>
						<form:option value="1"></form:option>
						<form:option value="2"></form:option>
						<form:option value="3"></form:option>
						<form:option value="4"></form:option>
						<form:option value="5"></form:option>
					</form:select></td>
			</tr>
			<tr>
			<td>Topic :</td>
			<td>
			<td colspan="2"><input type="submit"
					value="Start Test" /></td>
			</td>
			</tr>
		</table>
	</form:form>
	
<h3>MCQs</h3>
<script> var bondd = ${jsonList}; </script>
<c:if  test="${!empty mcqList}">
<table class="data">
<tr>
	<th>Question</th>
	<th>Option1</th>
	<th>Option2</th>
	<th>Option3</th>
	<th>Option4</th>
	<th>Option5</th>	
	<th>&nbsp;</th>
</tr>
<c:forEach items="${mcqList}" var="mcq">
	
	<tr>
		<td>${mcq.question}</td>
		<td><c:if test="${mcq.answer == 1 }"><mark></c:if>${mcq.option1}<c:if test="${mcq.answer == 1 }"></mark></c:if></td>
		<td><c:if test="${mcq.answer == 2 }"><mark></c:if>${mcq.option2}<c:if test="${mcq.answer == 2 }"></mark></c:if></td>
		<td><c:if test="${mcq.answer == 3 }"><mark></c:if>${mcq.option3}<c:if test="${mcq.answer == 3 }"></mark></c:if></td>
		<td><c:if test="${mcq.answer == 4 }"><mark></c:if>${mcq.option4}<c:if test="${mcq.answer == 4 }"></mark></c:if></td>
		<td><c:if test="${mcq.answer == 5 }"><mark></c:if>${mcq.option5}<c:if test="${mcq.answer == 5 }"></mark></c:if></td>
		<td><a href="deletemcq/${mcq.id}">delete</a></td>
	</tr>
</c:forEach>
</table>
</c:if>


</body>
</html>
