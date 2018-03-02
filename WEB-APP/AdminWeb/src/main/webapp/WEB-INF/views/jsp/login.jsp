<!DOCTYPE html>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>IFAR! | Login Page</title>

<!-- Bootstrap -->
<link
	href="${pageContext.request.contextPath}/resources/vendors/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Font Awesome -->
<link
	href="${pageContext.request.contextPath}/resources/vendors/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<!-- NProgress -->
<link
	href="${pageContext.request.contextPath}/resources/vendors/nprogress/nprogress.css"
	rel="stylesheet">
<!-- Animate.css -->
<link
	href="${pageContext.request.contextPath}/resources/vendors/animate.css/animate.min.css"
	rel="stylesheet">

<!-- Custom Theme Style -->
<link
	href="${pageContext.request.contextPath}/resources/styles/css/custom.min.css"
	rel="stylesheet">
</head>

<body class="login">
	<div>
		<a class="hiddenanchor" id="signup"></a> <a class="hiddenanchor"
			id="signin"></a>

		<div class="login_wrapper">
			<div class="animate form login_form">
				<section class="login_content">
					
						<h1>Login</h1>
						<spring:url value="/checkLogin" var="checkLoginUrl"/>
						<form action="${checkLoginUrl}" method="post">

							<div>
								<input type="text" class="form-control" placeholder="Username"
									required="required" name="txtUsername" />
							</div>
							<div>
								<input type="password" class="form-control"
									placeholder="Password" required="required" name="txtPassword"/>
							</div>
							<div>
								<input type="submit" class="btn btn-default submit" >Log in</input>
						</form>
						<a class="reset_pass" href="#">Lost your password?</a>
			</div>

			<div class="clearfix"></div>

			<div class="separator">
				<p class="change_link">
					New to site? <a href="#signup" class="to_register"> Create
						Account </a>
				</p>

				<div class="clearfix"></div>
				<br />

				<div>
					<h1>
						<i class="fa fa-paw"></i> IFAR!
					</h1>
					<p>©2018 All Rights Reserved. IFAR</p>
				</div>
			</div>
			</form>
			</section>
		</div>

		<div id="register" class="animate form registration_form">
			<section class="login_content">
				<form>
					<h1>Create Account</h1>
					<div>
						<input type="text" class="form-control" placeholder="Username"
							required="" />
					</div>
					<div>
						<input type="email" class="form-control" placeholder="Email"
							required="" />
					</div>
					<div>
						<input type="password" class="form-control" placeholder="Password"
							required="" />
					</div>
					<div>
						<a class="btn btn-default submit" href="index.html">Submit</a>
					</div>

					<div class="clearfix"></div>

					<div class="separator">
						<p class="change_link">
							Already a member ? <a href="#signin" class="to_register"> Log
								in </a>
						</p>

						<div class="clearfix"></div>
						<br />

						<div>
							<h1>
								<i class="fa fa-paw"></i> IFAR!
							</h1>
							<p>©2018 All Rights Reserved. IFAR!</p>
						</div>
					</div>
				</form>
			</section>
		</div>
	</div>
	</div>
</body>
</html>
