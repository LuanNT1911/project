<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Change Password</title>

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
<!-- bootstrap-daterangepicker -->
<link
	href="${pageContext.request.contextPath}/resources/vendors/bootstrap-daterangepicker/daterangepicker.css"
	rel="stylesheet">

<!-- Custom Theme Style -->
<link
	href="${pageContext.request.contextPath}/resources/styles/css/custom.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/styles/css/loading-bar.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/styles/js/loading-bar.js"></script>
<script>
	function validateMyForm() {
		var valid = true;
		var password = document.getElementById("fieldPassword").value;
		var passwordError = document.getElementById("fieldPasswordError");

		var confirmPassword = document.getElementById("fieldConfirmPassword").value;
		var confirmPasswordError = document
				.getElementById("fieldConfirmPasswordError");

		passwordError.style.display = "none";
		confirmPasswordError.style.display = "none";

		if (password.trim().length < 8) {
			passwordError.style.display = "block";
			valid = false;
		} else if (password.trim() != confirmPassword.trim()) {
			confirmPasswordError.style.display = "block";
			valid = false;
		}
		return valid;
	}
</script>
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<div class="col-md-3 left_col">
				<div class="left_col scroll-view">
					<div class="navbar nav_title" style="border: 0;">
						<a href="index.html" class="site_title"><i class="fa fa-map"></i>
							<span>Share Location</span></a>
					</div>

					<div class="clearfix"></div>

					<!-- menu profile quick info -->
					<div class="profile clearfix">
						<div class="profile_pic">
							<img src="images/img.jpg" alt="..."
								class="img-circle profile_img">
						</div>
						<div class="profile_info">
							<span>Welcome,</span>
							<h2>John Doe</h2>
						</div>
					</div>
					<!-- /menu profile quick info -->

					<br />

					<!-- sidebar menu -->
					<div id="sidebar-menu"
						class="main_menu_side hidden-print main_menu">
						<div class="menu_section">
							<h3>General</h3>
							<ul class="nav side-menu">
								<li><a><i class="fa fa-home"></i> Manage User </a></li>

							</ul>
						</div>


					</div>
					<!-- /sidebar menu -->

					<!-- /menu footer buttons -->

					<!-- /menu footer buttons -->
				</div>
			</div>

			<!-- top navigation -->
			<div class="top_nav">
				<div class="nav_menu">
					<nav>
						<div class="nav toggle">
							<a id="menu_toggle"><i class="fa fa-bars"></i></a>
						</div>

						<ul class="nav navbar-nav navbar-right">
							<li class=""><a href="javascript:;"
								class="user-profile dropdown-toggle" data-toggle="dropdown"
								aria-expanded="false"> <img src="images/img.jpg" alt="">John
									Doe <span class=" fa fa-angle-down"></span>
							</a>
								<ul class="dropdown-menu dropdown-usermenu pull-right">
									<spring:url value="/viewProfile" var="profileUrl" />
									<li><a href="${profileUrl}">Edit Profile</a></li>
									<spring:url value="/checkProcess" var="checkProcessUrl" />
									<li><a href="${checkProcessUrl}">Change Password</a></li>
									<li><a href="login.html"><i
											class="fa fa-sign-out pull-right"></i> Log Out</a></li>
								</ul></li>


						</ul>
					</nav>
				</div>
			</div>
			<!-- /top navigation -->

			<!-- page content -->
			<div class="right_col" role="main">
				<div class="">
					<div class="page-title">
						<div class="title_left">
							<h3>Change Password</h3>
						</div>

						<div class="title_right"></div>
					</div>

					<div class="clearfix"></div>

					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel">
								<div class="x_title">

									<div class="clearfix"></div>
								</div>
								<div class="x_content">

									<spring:url value="/checkProcess" var="checkProcessUrl" />
									<form class="form-horizontal form-label-left"
										onsubmit="return validateMyForm()" action="${checkProcessUrl}"
										method="get">
										<input name="photosceneId" value="${photosceneId}" />${photosceneId}
										<input name="token" value="${token}" />${token}
										<div class="ln_solid"></div>
										<div class="form-group">
											<div class="col-md-6 col-md-offset-3">
												<button type="submit" class="btn btn-primary">Cancel</button>
												<button id="send" type="submit" class="btn btn-success">Save</button>
											</div>
										</div>
									</form>
									<div id="myItem1" class="ldBar" data-value="50"></div>


									<script>
										var bar1 = new ldBar("#myItem1");
										var bar2 = document
												.getElementById('myItem1').ldBar;

										bar1.set(60);
									</script>

								</div>
								<input id="" type="button" onclick="clickon()">change
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- /page content -->

			<!-- footer content -->
			<footer>
				<div class="pull-right">
					Gentelella - Bootstrap Admin Template by <a
						href="https://colorlib.com">Colorlib</a>
				</div>
				<div class="clearfix"></div>
			</footer>
			<!-- /footer content -->
		</div>
	</div>

	<!-- jQuery -->
	<script
		src="${pageContext.request.contextPath}/resources/vendors/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script
		src="${pageContext.request.contextPath}/resources/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- FastClick -->
	<script
		src="${pageContext.request.contextPath}/resources/vendors/fastclick/lib/fastclick.js"></script>
	<!-- NProgress -->
	<script
		src="${pageContext.request.contextPath}/resources/vendors/nprogress/nprogress.js"></script>
	<!-- morris.js -->
	<script
		src="${pageContext.request.contextPath}/resources/vendors/raphael/raphael.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/vendors/morris.js/morris.min.js"></script>
	<!-- bootstrap-progressbar -->
	<script
		src="${pageContext.request.contextPath}/resources/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
	<!-- bootstrap-daterangepicker -->
	<script
		src="${pageContext.request.contextPath}/resources/vendors/moment/min/moment.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/vendors/bootstrap-daterangepicker/daterangepicker.js"></script>

	<!-- Custom Theme Scripts -->
	<script
		src="${pageContext.request.contextPath}/resources/styles/js/custom.min.js"></script>
	<script>
		//$(function() {
		//var bar1 = new ldBar(
		//	"#myItem1");
		//var bar2 = document
		//	.getElementById('myItem1').ldBar;
		//var clickon = function() {

		//bar1.set(${oldProcess});

		//bar1.set(70);

		//};

		//<c:if test="${not empty Process}">
		//document.getElementById("myItem1").style.visibility = "visible";
		//	clickon.call(this);
		//</c:if>
	</script>
</body>
</html>