<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="true"%>
<html>
<head>
	<title>Take Test</title>
	<link href="css/jquery-ui.min.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">
	<script src="js/jquery.js"></script>
	<script src="js/jquery-ui.min.js"></script>
	<script src="js/takeTest.js"></script>
	<style>
		.question-style {
			background: none repeat scroll 0 0 #00ff00;
			color: white;
		}
		
		.wrong-answer{
		{
			background: none repeat scroll 0 0 #ff0000;
			color: white;

		}
	</style>
	<c:if  test="${!empty testList}">
<c:forEach items="${testList}" var="t">
<style>
	
		#question_${t.questionsTaken.id} .ui-selecting { background: #FECA40;color:black; }
		#question_${t.questionsTaken.id} .ui-selected { background: #F39814; color: black; }
		#question_${t.questionsTaken.id} { list-style-type: none; margin: 0; padding: 0; width: auto; }
		#question_${t.questionsTaken.id} li { margin: 3px; padding: 0.4em; font-size: 1.4em; height: 18px; }
		
		
		 #selectable_${t.questionsTaken.id} .ui-selecting { background: #FECA40; }
		#selectable_${t.questionsTaken.id} .ui-selected { background: #F39814; color: white; }
		#selectable_${t.questionsTaken.id} { list-style-type: none; margin: 0; padding: 0; width: auto; }
		#selectable_${t.questionsTaken.id} li { margin: 3px; padding: 0.4em; font-size: 1.4em; height: 18px; }
		</style>
<script>
		testData["${t.questionsTaken.id}"] = { correctAnswer:${t.questionsTaken.answer}, answer:null };
		 $(function() {
			$( "#selectable_${t.questionsTaken.id}" ).selectable({
			stop: function() {
			
			$( ".ui-selected", this ).each(function() {
			var index = $( "#selectable_${t.questionsTaken.id} li" ).index( this );
			
			});
			}
			,selected: function( event, ui ) {
			testData[$(event.target).attr("questionid")].answer= parseInt($(ui.selected).attr('answer'),10);			
			}
			,unselected: function( event, ui ) {
			testData[$(event.target).attr("questionid")].answer = null;
			}
			});
			});
	</script>	
</c:forEach>
</c:if>
	
</head>
<body>

<h2>Take Test</h2>

<form:form method="post" action="saveTest.html">

<c:if  test="${!empty testList}">

<c:forEach items="${testList}" var="t">
<div>
	<ol id="question_${t.questionsTaken.id}" class="ui-selectable" questionID="${t.questionsTaken.id}">				
		<li style='ui-widget-content question-style' quest="${t.questionsTaken.id}">${t.questionsTaken.question}?</li> 
	</ol>
			<ol id="selectable_${t.questionsTaken.id}" class="ui-selectable" questionID="${t.questionsTaken.id}">
				<li class="ui-widget-content" quest="${t.questionsTaken.id}_1" answer="1">${t.questionsTaken.option1}</li>
				<li class="ui-widget-content" quest="${t.questionsTaken.id}_2" answer="2">${t.questionsTaken.option2}</li>
				<li class="ui-widget-content" quest="${t.questionsTaken.id}_3" answer="3">${t.questionsTaken.option3}</li>
				<li class="ui-widget-content" quest="${t.questionsTaken.id}_4" answer="4">${t.questionsTaken.option4}</li>
				<li class="ui-widget-content" quest="${t.questionsTaken.id}_5" answer="5">${t.questionsTaken.option5}</li>
				
			</ol>
</div>		
</c:forEach>
<input type="button" value="Check" onclick="checkAnswer();" /> &nbsp;&nbsp;
<input type="button" value="Submit" onclick="doSubmit();" />
</c:if>
	
</form:form>
<div id="dialog-message" title="" style="display:none;">
	
</div>


</body>
</html>
