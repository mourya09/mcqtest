var testData = {};

$(document).ready(function() {

});
function setErrorMessage(str)
{
	$( "#dialog-message" ).children().remove().end();
	$( "#dialog-message" ).html('<p>'+str+'</p>');
	$('#dialog-message').attr('title',str);
	try{
	$( "#dialog-message" ).dialog( "close" );
	}catch(exp)
	{
	}
		$( "#dialog-message" ).dialog({
	modal: true,
	buttons: {
	Ok: function() {
			$( "#dialog-message" ).dialog( "close" );}
	}
	});
	
}
function checkAnswer()
{
	if(testData != null && isAllAnswered())
	{
		for(key in testData)
		{
			if(testData[key].answer != testData[key].correctAnswer)
			{
				$('[quest="'+key+"_"+testData[key].correctAnswer+'"]').css("background","none repeat scroll 0 0 #ff0000").css("color","white").trigger('refresh');
			}
		}
		
	}
}

function isAllAnswered()
{
	if(testData != null)
	{
		for(key in testData)
		{
			if(typeof testData[key].answer == 'undefined' || testData[key].answer == null ||  isNaN(testData[key].answer))
			{
				return false;
			}
		}
		
	}
	
	return true;
}

function doSubmit()
{
	if(testData == null)
	{
		setErrorMessage("Please select the questions");
	}else
	{
		if(!isAllAnswered())
			{
				setErrorMessage("Please answer all the questions!!!")
				return;
			}else
			{
				var count =0;
				//dataToSend = "{";
				dataToSend = "";
				for(var key in testData)
				{
					dataToSend = dataToSend + '&testDTO['+count+'].id=' + key +'&testDTO['+count+'].markedAnswer=' + testData[key].answer;
					count = count + 1;
				}
				//dataToSend = dataToSend + "}";
				$.ajax({url : 'saveTest.html' ,
							cache : false,
							data : dataToSend,
							type : 'POST',
							success : function(returnData) {
							
								if(returnData.errorMessage != null)
								{
									//$('#blocker').hide();	
									alert(returnData.errorMessage);
									return;
								}
								FetchData();
								//$('#save').trigger('close');
								
							},error : function(xhr, textStatus, thrownError){
							//$('#blocker').hide();	
							alert(textStatus + ": " + thrownError);
	
					}});
				
			}
		
		
	}
}