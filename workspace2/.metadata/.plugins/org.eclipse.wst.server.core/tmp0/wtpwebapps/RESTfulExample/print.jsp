<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	
	
    $("button").click(function(){
    	
    	
        $.ajax({url: "http://localhost:8080/RESTfulExample/rest/table/marks, 
        	success: function(result){
        		console.log(result);
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
<title>Print Details</title>
</head>
<body>

<button>Get Marks</button>
</body>
</html>