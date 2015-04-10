$(document).ready(function(){
	
	$(".viewDialog").click(function(e) {
        e.preventDefault();  // ADDITIONAL CODE. FIX FOR IE
// generateMsgParts(selectedValue,variables);
        
        var selectedName = $(this).attr("value");
        var selectedHobby = $(this).attr("hobby");
		console.log(selectedName)
		console.log(selectedHobby)
		
		
		var studentName = selectedName;
		var studentHobby = selectedHobby;
        
        $.ajax({
            url : "/UniversityRegistration/showDialog",
            type : "GET",
            traditional : true,
            contentType : "application/json",
            dataType : "json",
            data : {
				studentName : studentName,
				studentHobby : studentHobby
			},
		}).error(function(jqXHR, textStatus, errorThrown) {
			console.log(errorThrown);
		}).success(function(data, textStatus, jqXHR) {
			
			alert("Name: " + data.studentName + " , " + data.studentHobby);
			
			$('#responsecode').text("Name: " + data.studentName + " , " + data.studentHobby);
			
			$('#innerResponsecode').text("Inner Name: " + data.studentName + " , Music: " + data.studentHobby);
			
			 $( "#myDialog" ).dialog({
		            autoOpen: false,
		            resizable:true,
		            width: 250,
		            minHeight: 0,
		            height: 250,
		            modal: true,
		            position: 'center',
		            buttons: {
		                "OK": function() {
		                    
		                	 $( "#innerDialog" ).dialog({
		     		            autoOpen: false,
		     		            resizable:true,
		     		            width: 250,
		     		            minHeight: 0,
		     		            height: 250,
		     		            modal: true,
		     		            position: 'center',
		     		            buttons: {
		     		                "OK": function() {
		     		                    $(this).dialog("close");
		     		                }
		     		            }

		     		        });
		     		        $("#innerDialog").parent().css({position:"fixed"});
		     		        $("#innerDialog").dialog('open');
		                	
		                }
		            }

		        });
		        $("#myDialog").parent().css({position:"fixed"});
		        $("#myDialog").dialog('open');
			
		})	
	
       
	  });
	
	return false;
	
});