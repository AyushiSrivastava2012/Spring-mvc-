<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>

<link rel="stylesheet"
	href="<c:url value="/resources/SpringSecAppModule/externalCss/bootstrap.min.css" ></c:url>">
<script type="text/javascript"
	src="<c:url value="/resources/SpringSecAppModule/libs/angular.min.js" ></c:url>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/SpringSecAppModule/libs/jquery.min.js" ></c:url>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/SpringSecAppModule/libs/bootstrap.min.js" ></c:url>"></script>

<script type="text/javascript"
	src="<c:url value="/resources/SpringSecAppModule/utils/server.js" ></c:url>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/SpringSecAppModule/utils/appConstants.js" ></c:url>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/SpringSecAppModule/controllers/Login.js" ></c:url>"></script>
<title>Login</title>
</head>


<body ng-app="SpringSecApp" ng-controller="LoginController"
	class="container">
	Login into your application:
	<table>
		<tr>
			<td>UserName:</td>
			<td><input type="text" ng-model="username"
				placeholder="Enter your username"></td>
		</tr>

		<tr>
			<td>Password:</td>
			<td><input type="text" ng-model="password"
				placeholder="Enter your password"></td>
		</tr>


	</table>
	<input type="submit" ng-click="submitDetails()">

</body>