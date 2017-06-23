<head>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.3/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
<script src="../static/SpringSecAppModule/controllers/Login.js"></script>	
<title>Login</title> Login into your application:
</head>


<body ng-app="SpringSecApp" ng-controller="LoginController">
	<div class="container">
		<tr>
			<td >UserName:</td>
			<td><input type="text" placeholder="Enter your username">
			</td>
		</tr>

		<tr>
			<td>Password:</td>
			<td><input type="text" placeholder="Enter your password">
			</td>
		</tr>
	</div>
{{message}}
</body>