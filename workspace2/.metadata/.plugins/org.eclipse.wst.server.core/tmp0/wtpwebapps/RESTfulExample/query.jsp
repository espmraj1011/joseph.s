<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	
	
    $("button").click(function(){
    	
    	
        $.ajax({url: "http://localhost:8080/RESTfulExample/rest/data/marks/"+$("#name").val(), 
        	success: function(result){
        		console.log(result);
            	$("#div1").html("Name : "+result.name);
            	$("#div2").html("DateOfBirth : "+result.dateofbirth);
            	$("#div3").html("Tamil : "+result.tamil);
            	$("#div4").html("English : "+result.english);
            	$("#div5").html("Mathematics : "+result.mathematics);
            	$("#div6").html("Physics : "+result.physics);
            	$("#div7").html("Chemistry : "+result.chemistry);
            	$("#div8").html("Boilogy : "+result.biology);
            	var x,y,z,cut_off=0,total=0;
            	total=result.tamil+result.english+result.mathematics+result.physics+result.chemistry+result.biology;
            	x=result.physics/4;
            	y=result.chemistry/4;
            	z=result.biology/2;
            	cut_off=x+y+z;
            	$("#div9").html("Total : "+total);
            	$("#div0").html("CutOff : "+cut_off);
        	},
        	error : function (a,b,c){
        		console.log(a,b,c);
        	}
        });
        
        
        
    });
    
    
    
});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mark sheet</title>
</head>
<body>
Enter the name:
<br>
	<input type="text" id="name" value="">
	<br>
<div id="div1"></div>
<div id="div2"></div>
<div id="div3"></div>
<div id="div4"></div>
<div id="div5"></div>
<div id="div6"></div>
<div id="div7"></div>
<div id="div8"></div>
<div id="div9"></div>
<div id="div0"></div>

<button>Get Details</button>

</body>
</html>