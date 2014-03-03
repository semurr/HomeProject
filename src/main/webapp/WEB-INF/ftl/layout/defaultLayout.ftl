<#macro defaultLayout>

<html lang="en">
	
	<head>
		<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">		
	</head>
	
	<body>
		<#include "navigationBar.ftl" />
		<div class="container">
			<#nested/>
		</div>
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
		<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
	</body>
	
	<footer>
	</footer>
	
</html>

</#macro>