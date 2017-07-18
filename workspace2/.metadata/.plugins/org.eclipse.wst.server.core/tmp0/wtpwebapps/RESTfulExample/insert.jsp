<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	
	
    $("button").click(function(){
    	var total;
    	var a = parseInt($("#tamil").val());
    	var b = parseInt($("#english").val());
    	var c = parseInt($("#mathematics").val());
    	var d = parseInt($("#physics").val());
    	var e = parseInt($("#chemistry").val());
    	var f = parseInt($("#biology").val());
		total=a+b+c+d+e+f;
    	$.ajax({url: "http://localhost:8080/RESTfulExample/rest/insert/marks/"+$("#name").val()+"/"+$("#dateofbirth").val()+"/"+$("#tamil").val()+"/"+$("#english").val()+"/"+$("#mathematics").val()+"/"+$("#physics").val()+"/"+$("#chemistry").val()+"/"+$("#biology").val(), 
        	success: function(result){
        		console.log(result);
        		
        	},
        	error : function (a,b,c){
        		console.log(a,b,c);
        	}
        });
        
        
        
    });
    
    
    
});
 </script>       
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert marks</title>
</head>
<body>
Enter the name:
<br>
	<input type="text" id="name" value="">
	<br>
	Enter Date of birth:
<br>
	<input type="text" id="dateofbirth" value="">
	<br>
	Enter Tamil marks:
<br>
	<input type="text" id="tamil" value="">
	<br>
	Enter English marks:
<br>
	<input type="text" id="english" value="">
	<br>
	Enter Mathematics marks:
<br>
	<input type="text" id="mathematics" value="">
	<br>
	Enter Physics marks:
<br>
	<input type="text" id="physics" value="">
	<br>
	Enter Chemistry marks:
<br>
	<input type="text" id="chemistry" value="">
	<br>
	Enter Biology marks:
<br>
	<input type="text" id="biology" value="">
	<br>
	
	<button>Get Details</button>
</body>
</html>