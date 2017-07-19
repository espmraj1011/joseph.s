<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<title>Product</title>
</head>
<body>
	<div>
		<h4>
			Product from Categories
		</h4>
		<div class="row">
			<div>
				<div class="col-sm-12">
					<label for="categories">Categories</label> 
						<select id="categories" onchange="loadPro()">
						</select>
				</div>
				<br>
				<br>
				<div>
					<label for="product">Products</label> 
						<select id="product">
						</select>
				</div>
			</div>
		</div>
	</div>
<script>
$( document ).ready(function() {
	loadDetails();
});


var categories = [];
var product = [];


function loadDetails(){
$.ajax({url: "http://localhost:8080/RESTfulExample/rest/admin/overload", 
	success: function(result){
		console.log(result);
		
		
		categories = result.categories;
		product = result.product;
		
		console.log("categories", categories, "product", product);
			for(i=0; i < categories.length; i++) {
			$('#categories').append(new Option(categories[i].categoryName, categories[i].categoryId+""));
			}
			loadPro();
	}
});
}
function loadPro(){
	var selectedCategoryId = $('#categories').val();
	$('#product').empty();
	console.log("selectedCategoryId", selectedCategoryId, "product", product);
		for(i=0; i < product.length; i++) {
			if(product[i].categoryId+"" == selectedCategoryId){
				console.log("categoryID matched");		
			}
			if(product[i].categoryId == selectedCategoryId){
				$('#product').append(new Option(product[i].productName, product[i].productId+""));	
			}
			
		}
}

		</script>
</body>
</html>