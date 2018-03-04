<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Approve Gennerate 3D</title>
<!-- Bootstrap -->
<link rel='stylesheet prefetch'
	href='${pageContext.request.contextPath}/resources/styles/css/bootstrap.min.css'>
<link rel='stylesheet prefetch'
	href='${pageContext.request.contextPath}/resources/styles/css/font-awesome.min.css'>

<link
	href="${pageContext.request.contextPath}/resources/vendors/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">

<link
	href="${pageContext.request.contextPath}/resources/styles/css/mystyle.css"
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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
	

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<div class="col-md-3 left_col">
				<div class="left_col scroll-view">
					<div class="navbar nav_title" style="border: 0;">
						<a href="index.html" class="site_title"><i class="fa fa-map"></i>
							<span>ifAR</span></a>
					</div>

					<div class="clearfix"></div>

					<!-- menu profile quick info -->
					<div class="profile clearfix">
						<div class="profile_pic">
							<img src="" alt="..." class="img-circle profile_img">
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
								<li><a><i class="fa fa-home"></i> Create 3D model </a></li>

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
									<li><a href="">Edit Profile</a></li>
									<spring:url value="/checkProcess" var="checkProcessUrl" />
									<li><a href="">Change Password</a></li>
									<li><a href="login.html"><i
											class="fa fa-sign-out pull-right"></i> Log Out</a></li>
								</ul></li>


						</ul>
					</nav>
				</div>
			</div>
			<!-- /top navigation -->

			<!-- page content -->

			<div id="blur_div2" class="modal2"></div>

			<div id="blur_div" class="modal fade bs-example-modal-lg in">
				<div id="pop-up" class="modal-dialog modal-lg">
					<div class="modal-content">

						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								onclick="closePopup()">
								<span aria-hidden="true">X</span>
							</button>
							<h4 class="modal-title" id="myModalLabel">Seller Request
								Details</h4>
						</div>
						<div class="modal-body">
							<div class="row">
								<div class="form-group col-md-8">
									<label>ID:</label> <span id="rq_id">
								</div>
							</div>
							<div class="row">
								<div class="form-group col-md-8">
									<label>Status:</label> <span id="rq_status">
								</div>
							</div>
							<div class="row">
								<div class="form-group col-md-8">
									<label>ImageSet:</label> <span id="rq_imageSet">
								</div>
							</div>
							<div class="row">
								<div class="form-group col-md-8">
									<label>Link:</label> <span id="rq_publicLink">
								</div>
							</div>
							<div class="row">
								<div class="form-group col-md-8">
									<label>Size:</label> <span id="rq_width"></span> x <span
										id="rq_length"></span> x <span id="rq_height"></span>
								</div>
							</div>
							<div class="row">
								<div class="form-group col-md-8">
									<label>Create Date:</label> <span id="rq_createdAt"></span>
								</div>
							</div>
							<div class="row">
								<div class="form-group col-md-8">
									<label>Update Date:</label> <span id="rq_updatedAt"></span>
								</div>
							</div>
							<div class="row">
								<div class="form-group col-md-8">
									<label>Reason to Reject:</label> <input type="text"
										name="rq_reason" id="rq_reason">
								</div>
							</div>
						</div>
						<div class="modal-footer">
							 <div class="progress" 	 id="progressBarHolder">
						    <div id="progress_bar" class="progress-bar progress-bar-striped active" 
						    	role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width:40%">
						      40%
						    </div>
						  </div>

							<spring:url value="/adminWeb/approve" var="profileUrl" />
							<form action="${profileUrl}" method="get" class="approveForm">

								<input type="hidden" name="userRequest" id="userRequest"
									value=""> <input type="hidden" name="_id" id="hiddenid"
									value=""> <input type="hidden" name="token"
									value="${token}">
								<button type="submit" class="btn btn-primary" id="btn_Approve">Approve</button>
							</form>
							

						
								

							<%-- <button type="button" class="btn btn-primary" id="btn_Download">Download</button>--%>
							<form id="uploadForm" class="uploadForm"
								action="/adminWeb/re-upload" method="POST"
								enctype="multipart/form-data">
								<div class="btn btn-primary" id="btn_upload">
									<span>Re-Upload</span>
								</div>
								<input id="input_upload" name="file" type="file" class="upload" multiple="multiple"
									style="display: none"" directory="" webkitdirectory="" mozdirectory=""/> <input id="frq_id" name="_id"
									type="hidden" />
								<input type="hidden" name="_id" id="reupload_id"
									value=""> 	
							
								<button type="button" class="btn btn-primary" id="btn_Reject">Reject</button>
								<button type="button" class="btn btn-default"
								data-dismiss="modal" onclick="closePopup()">Close</button>

							</form>
							
						</div>

					</div>
				</div>
			</div>

			<div class="right_col" role="main">
				<div class="">
					<div class="page-title">
						<div class="title_left">
							<h3>Approve Gennerate 3D</h3>
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
								<div class="row">
									<ul class="nav nav-tabs">
										<li class="active"><a data-toggle="tab" href="#approved">Approved</a></li>
										<li><a data-toggle="tab" href="#pending">Peding</a></li>
										<li><a data-toggle="tab" href="#reject">Reject</a></li>

									</ul>

									<div class="tab-content">
										<div id="approved" class="tab-pane fade in active">
											<div class="table-responsive">
												<table class="table table-striped jambo_table">
													<thead>
														<tr class="headings">
															<th class="column-title">No</th>
															<th class="column-title">User Name</th>
															<th class="column-title">Create at</th>
															<th class="column-title">Details</th>
															</th>
														</tr>
													</thead>

													<tbody>
														<c:forEach var="sellerRequest" items="${approvedList}"
															varStatus="count">
															<tr class="pointer">
																<td class=" ">${count.count}</td>
																<td class=" ">${sellerRequest.userAccount.username}</td>
																<td class=" ">${sellerRequest.createdAt}</td>
																<td class=" "><button type="button"
																		class="btn btn-primary"
																		onclick="showPopup('${sellerRequest.userAccount.username}','${sellerRequest.id}','${sellerRequest.status}','${sellerRequest.imageSet}','${sellerRequest.publicLink}','${sellerRequest.width}','${sellerRequest.length}','${sellerRequest.height}','${sellerRequest.createdAt}','${sellerRequest.updatedAt}')">Details</button>
																	
																	<c:if test="${sellerRequest.id eq requestid}">
																	<button type="button" class="btn btn-primary"><a style="text-decoration: none;color: white;" href="${link}">Download</a> </button>
																	</c:if>
																		</td>



															</tr>
														</c:forEach>

													</tbody>
												</table>
											</div>
										</div>
										<div id="pending" class="tab-pane fade">
											<div class="table-responsive">
												<table class="table table-striped jambo_table">
													<thead>
														<tr class="headings">
															<th class="column-title">No</th>
															<th class="column-title">User Name</th>
															<th class="column-title">Create at</th>
															<th class="column-title">Details</th>
															
															</th>
														</tr>
													</thead>

													<tbody>
														<c:forEach var="sellerRequest" items="${pedingList}"
															varStatus="count">
															<tr class="pointer">
																<td class=" ">${count.count}</td>
																<td class=" ">${sellerRequest.userAccount.username}</td>
																<td class=" ">${sellerRequest.createdAt}</td>
																<td class=" "><button type="button"
																		class="btn btn-primary"
																		onclick="showPopup('${sellerRequest.userAccount.username}','${sellerRequest.id}','${sellerRequest.status}','${sellerRequest.imageSet}','${sellerRequest.publicLink}','${sellerRequest.width}','${sellerRequest.length}','${sellerRequest.height}','${sellerRequest.createdAt}','${sellerRequest.updatedAt}')">Details</button>
																		
																		</td>



															</tr>
														</c:forEach>

													</tbody>
												</table>
											</div>
										</div>
										<div id="reject" class="tab-pane fade">
											<div class="table-responsive">
												<table class="table table-striped jambo_table">
													<thead>
														<tr class="headings">
															<th class="column-title">No</th>
															<th class="column-title">User Name</th>
															<th class="column-title">Create at</th>
															<th class="column-title">Details</th>
															</th>
														</tr>
													</thead>

													<tbody>
														<c:forEach var="sellerRequest" items="${rejectList}"
															varStatus="count">
															<tr class="pointer">
																<td class=" ">${count.count}</td>
																<td class=" ">${sellerRequest.userAccount.username}</td>
																<td class=" ">${sellerRequest.createdAt}</td>
																<td class=" "><button type="button"
																		class="btn btn-primary"
																		onclick="showPopup('${sellerRequest.userAccount.username}','${sellerRequest.id}','${sellerRequest.status}','${sellerRequest.imageSet}','${sellerRequest.publicLink}','${sellerRequest.width}','${sellerRequest.length}','${sellerRequest.height}','${sellerRequest.createdAt}','${sellerRequest.updatedAt}')">Details</button></td>



															</tr>
														</c:forEach>

													</tbody>
												</table>
											</div>
										</div>

									</div>
								</div>
							</div>
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

	
	<script>
	
	
	
	
	$(document).ready(function(){
	    $("#btn_Download").click(function(){
	    	var id= document.getElementById("rq_id").innerHTML;
	        $.get("/adminWeb/download?_id="+id, function(data, status){
	        	  console.log(data);
	        	  var element = document.createElement('a');
	        	  element.setAttribute('href', data);
	        	  element.setAttribute('download',"" );

	        	  element.style.display = 'none';
	        	  document.body.appendChild(element);

	        	  element.click();

	        	  document.body.removeChild(element);
	        });
	    });
	});
	
	
	$(document).ready(function(){
	    $("#btn_Reject").click(function(){
	    	var id= document.getElementById("rq_id").innerHTML;
	    	var rs= document.getElementById("rq_reason")[0].value;
	        $.get("/adminWeb/reject?_id="+id+"&reason="+rs, function(data, status){
	        	 
	        });
	    });
	});
	
	
	
	

	
	
	
	
	

	   function showPopup(username,id,status,imageSet,rq_publicLink,rq_width,rq_length,rq_height,rq_createdAt,rq_updatedAt){
		   document.getElementById("userRequest").value=username;
		   document.getElementById("hiddenid").value=id;
		 
		   document.getElementById("blur_div").style.display="block";
		   document.getElementById("blur_div2").style.display="block";
		   document.getElementById("pop-up").style.display="block";
		   document.getElementById("rq_id").innerHTML=""+id;
		   document.getElementById("rq_status").innerHTML=""+status;
		   document.getElementById("rq_imageSet").innerHTML=""+imageSet;
		   document.getElementById("rq_publicLink").innerHTML=""+rq_publicLink;
		   
		   document.getElementById("rq_width").innerHTML=""+rq_width;
		   document.getElementById("rq_length").innerHTML=""+rq_length;
		   document.getElementById("rq_height").innerHTML=""+rq_height;
		   document.getElementById("rq_createdAt").innerHTML=""+rq_createdAt;
		   document.getElementById("rq_updatedAt").innerHTML=""+rq_updatedAt;
	   }
	   
	   function closePopup(){
		   document.getElementById("blur_div").style.display="none";
		   document.getElementById("blur_div2").style.display="none";
		   document.getElementById("pop-up").style.display="none";
		   
	   }

	   <!-- Jquery -->
	   $(document).ready(function(){
	   $("#btn_upload").click(function () {
		    $("#input_upload").trigger('click');
		});
	   });
	   
	   $(document).ready(function(){
		   $('#input_upload').change(function() {
			   var id=document.getElementById("rq_id").innerHTML;
			   document.getElementById("frq_id").setAttribute("value", id);
			   $('#uploadForm').submit();
			   
			   
			   
			 });
		   });
		   
	

	
	

 
   

   

</script> 
<!-- Custom Theme Scripts --> <script
		src="${pageContext.request.contextPath}/resources/js/app.js"></script>
   
	<!-- Bootstrap --> <script
		src="${pageContext.request.contextPath}/resources/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- FastClick --> <script
		src="${pageContext.request.contextPath}/resources/vendors/fastclick/lib/fastclick.js"></script>
	<!-- NProgress --> <script
		src="${pageContext.request.contextPath}/resources/vendors/nprogress/nprogress.js"></script>
	<!-- morris.js --> <script
		src="${pageContext.request.contextPath}/resources/vendors/raphael/raphael.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/vendors/morris.js/morris.min.js"></script>
	<!-- bootstrap-progressbar --> <script
		src="${pageContext.request.contextPath}/resources/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
	<!-- bootstrap-daterangepicker --> <script
		src="${pageContext.request.contextPath}/resources/vendors/moment/min/moment.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/vendors/bootstrap-daterangepicker/daterangepicker.js"></script>

	


	<script
		src="${pageContext.request.contextPath}/resources/vendors/pnotify/dist/pnotify.nonblock.js"></script>

	<script
		src="${pageContext.request.contextPath}/resources/vendors/pnotify/dist/pnotify.nonblock.js"></script>


	<script
		src="${pageContext.request.contextPath}/resources/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/vendors/fastclick/lib/fastclick.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/vendors/iCheck/icheck.min.js"></script>
	
</html>