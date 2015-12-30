<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title" /></title>
</head>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%-- <tilesx:useAttribute name="current" /> --%>
<body>
	<script type="text/javascript">
		var contextRoot = "<spring:url  value='/'></spring:url>";
	</script>
	<!-- Navigation -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"> <img alt="Brand"
					src="images/brand.png">
				</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">

					<sec:authorize access="hasRole('ROLE_ADMIN')">
						<li><a href="#">Products</a></li>
						<li><a href="#">Users</a></li>
						<li><a href="#">Offers</a></li>
					</sec:authorize>

					<sec:authorize access="hasRole('ROLE_MERCHANT')">
						<li><a href="#">My Products</a></li>
						<li><a href="#">Sales</a></li>
					</sec:authorize>

					<li><a href="#">About</a></li>
					<li><a href="#">Contact</a></li>


				</ul>
				<sec:authorize access="! isAuthenticated()">
					<button type="button" id="btnRegister"
						class="btn btn-default navbar-btn navbar-right"
						data-toggle="modal" data-target="#myModal">Register</button>
				</sec:authorize>
				<sec:authorize access="! isAuthenticated()">
					<button type="button" id="btnSignin"
						class="btn btn-default navbar-btn navbar-right"
						data-toggle="modal" data-target="#myModal">Sign in</button>
				</sec:authorize>

				<sec:authorize access="isAuthenticated()">
					<a href="<spring:url value="/logout"></spring:url>"
						class="btn btn-default navbar-btn navbar-right">Logout</a>
				</sec:authorize>
			</div>

			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>
	<div class="container">

		<hr>
		<tiles:insertAttribute name="body" />

	</div>

	<div class="container">

		<hr>
		<div align="center">
			<tiles:insertAttribute name="footer" />

		</div>
	</div>


</body>
</html>