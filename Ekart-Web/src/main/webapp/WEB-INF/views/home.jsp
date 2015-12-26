

<br />
<br />
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<spring:url var="register" value="/register"></spring:url>
<spring:url var="login" value="/login"></spring:url>
<div class="row">

	<div class="col-md-3">
		<p class="lead">E Kart</p>
		<div class="list-group">
			<a href="#" class="list-group-item">Category 1</a> <a href="#"
				class="list-group-item">Category 2</a> <a href="#"
				class="list-group-item">Category 3</a>
		</div>
	</div>

	<div class="col-md-9">

		<div class="row carousel-holder">

			<div class="col-md-12">
				<div id="carousel-example-generic" class="carousel slide"
					data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#carousel-example-generic" data-slide-to="0"
							class="active"></li>
						<li data-target="#carousel-example-generic" data-slide-to="1"></li>
						<li data-target="#carousel-example-generic" data-slide-to="2"></li>
					</ol>
					<div class="carousel-inner">
						<div class="item active">
							<img class="slide-image" src="images/slide1.jpg" alt="">
						</div>
						<div class="item">
							<img class="slide-image" src="images/slide2.jpg" alt="">
						</div>
						<div class="item">
							<img class="slide-image" src="images/slide1.jpg" alt="">
						</div>
					</div>
					<a class="left carousel-control" href="#carousel-example-generic"
						data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left"></span>
					</a> <a class="right carousel-control" href="#carousel-example-generic"
						data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right"></span>
					</a>
				</div>
			</div>

		</div>

		<div class="row"></div>

	</div>

</div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-login">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-6">
								<a href="#" class="active" id="login-form-link">Login</a>
							</div>
							<div class="col-xs-6">
								<a href="#" id="register-form-link">Register</a>
							</div>
						</div>
						<hr>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<form:form id="login-form" action="${login}" method="post"
									role="form" style="display: block;" modelAttribute="loginForm">
									<div class="form-group">
										<form:input name="username" id="username" tabindex="1"
											cssClass="form-control" path="username"></form:input>
									</div>
									<div class="form-group">
										<form:input type="password" name="password" id="password"
											tabindex="2" cssClass="form-control" path="password"></form:input>
									</div>
									<div class="form-group text-center">
										<input type="checkbox" tabindex="3" class="" name="remember"
											id="remember"> <label for="remember">
											Remember Me</label>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" name="login-submit" id="login-submit"
													tabindex="4" class="form-control btn btn-login"
													value="Log In">
											</div>
										</div>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-lg-12">
												<div class="text-center">
													<a href="<spring:url value='/forgot' />" tabindex="5"
														class="forgot-password">Forgot Password?</a>
												</div>
											</div>
										</div>
									</div>
								</form:form>
								<form:form id="register-form" action="${register}" method="post"
									modelAttribute="registerForm" role="form"
									style="display: none;">
									<div class="alert alert-success" style="display: none;">Registration
										successfull!</div>
									<div class="form-group">
										<input type="text" name="name" id="name" tabindex="1"
											class="form-control" placeholder="Full Name" value="">
									</div>
									<div class="form-group">
										<input type="text" name="username" id="username" tabindex="1"
											class="form-control" placeholder="Username" value="">
									</div>
									<div class="form-group">
										<input type="email" name="email" id="email" tabindex="1"
											class="form-control" placeholder="Email Address" value="">
									</div>
									<div class="form-group">
										<input type="password" name="password" id="password"
											tabindex="2" class="form-control" placeholder="Password">
									</div>
									<div class="form-group">
										<input type="password" name="confirm-password"
											id="confirm-password" tabindex="2" class="form-control"
											placeholder="Confirm Password">
									</div>
									<div class="form-group">

										<div class="btn-group" id="chkRoles" data-toggle="buttons">
											<label class="btn btn-primary active"> <input
												type="checkbox" autocomplete="off" checked> User
											</label> <label class="btn btn-primary"> <input
												type="checkbox" autocomplete="off"> Merchant
											</label>
										</div>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="button" name="register-submit"
													id="register-submit" tabindex="4"
													class="form-control btn btn-register" value="Register Now">
											</div>
										</div>
									</div>
								</form:form>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->



	<jsp:include page="../views/common/common.jsp"></jsp:include>
	 <script src="js/homepage.js"></script>