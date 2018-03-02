<<<<<<< Updated upstream
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
=======
>>>>>>> Stashed changes
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>DataTables | Gentelella</title>

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
<!-- iCheck -->
<link
	href="${pageContext.request.contextPath}/resources/vendors/iCheck/skins/flat/green.css"
	rel="stylesheet">
<!-- Datatables -->
<link
	href="${pageContext.request.contextPath}/resources/vendors/datatables.net-bs/css/dataTables.bootstrap.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css"
	rel="stylesheet">

<!-- Custom Theme Style -->
<link
	href="${pageContext.request.contextPath}/resources/styles/css/custom.min.css"
	rel="stylesheet">
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<div class="col-md-3 left_col">
				<div class="left_col scroll-view">
					<div class="navbar nav_title" style="border: 0;">
						<a href="index.html" class="site_title"><i class="fa fa-map"></i>
							<span>IFAR</span></a>
					</div>

					<div class="clearfix"></div>

					<!-- menu profile quick info -->
					<div class="profile clearfix">
						<div class="profile_pic">
<<<<<<< Updated upstream
							<img src="" alt="..." class="img-circle profile_img">
=======
							<img src="" alt="..."
								class="img-circle profile_img">
>>>>>>> Stashed changes
						</div>
						<div class="profile_info">
							<span>Welcome,</span>
							<h2>${sessionScope.USERACCOUNT.fullname}</h2>
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
<<<<<<< Updated upstream
								<li><a><i class="fa fa-home"></i> Manage Product </a></li>
								<li><a><i class="fa fa-home"></i> Create 3D Model </a></li>
=======
								<li><a><i class="fa fa-home"></i> Manage User </a></li>

>>>>>>> Stashed changes
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
								aria-expanded="false"> <img src="images/img.jpg" alt="">${sessionScope.USERACCOUNT.fullname}
<<<<<<< Updated upstream
									<span class=" fa fa-angle-down"></span>
=======
								<span class=" fa fa-angle-down"></span>
>>>>>>> Stashed changes
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
							<h3>
								Users <small>Some examples to get you started</small>
							</h3>
						</div>

						<div class="title_right">
							<div
								class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
								<div class="input-group">
									<input type="text" class="form-control"
										placeholder="Search for..."> <span
										class="input-group-btn">
										<button class="btn btn-default" type="button">Go!</button>
									</span>
								</div>
							</div>
						</div>
					</div>

					<div class="clearfix"></div>

					<div class="row">


						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel">
								<div class="x_title">
<<<<<<< Updated upstream
									<h2>Plus Table Design</h2>

=======
									<h2>
										Plus Table Design</small>
									</h2>
									
>>>>>>> Stashed changes
									<div class="clearfix"></div>
								</div>
								<div class="x_content">
									<p class="text-muted font-13 m-b-30">
										DataTables has most features enabled by default, so all you
										need to do to use it with your own tables is to call the
										construction function:
										<code>$().DataTable();</code>
									</p>
<<<<<<< Updated upstream
									<table id="datatable"
										class="table table-striped table-bordered">
										<thead>
											<tr>
												<th>Name</th>
												<th>Price</th>
												<th>Quantity</th>
												<th>Origin</th>
												<th>Weight</th>
												<th>Describle</th>
												<th>Image</th>
												<th>Status</th>
												<th>Create At</th>
												<th>Update At</th>
												<th>Model Id</th>
												<th>Product Id</th>
												<th>Reject Reason</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${PRODUCTLIST}" var="product">
												<tr>
													<td>${product.name}</td>
													<td>${product.price}</td>
													<td>${product.quantity}</td>
													<td>${product.origin}</td>
													<td>${product.weight}</td>
													<td>${product.describe}</td>
													<td>${product.image}</td>
													<td>${product.status}</td>
													<td>${product.createAt}</td>
													<td>${product.updateAt}</td>
													<td>${product.modelId}</td>
													<td>${product.productId}</td>
													<td>${product.rejectReason}</td>
												</tr>
											</c:forEach>
=======
									<table id="datatable-responsive"
										class="table table-striped table-bordered dt-responsive nowrap"
										cellspacing="0" width="100%">
										<thead>
											<tr>
												<th>First name</th>
												<th>Last name</th>
												<th>Position</th>
												<th>Office</th>
												<th>Age</th>
												<th>Start date</th>
												<th>Salary</th>
												<th>Extn.</th>
												<th>E-mail</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>Tiger</td>
												<td>Nixon</td>
												<td>System Architect</td>
												<td>Edinburgh</td>
												<td>61</td>
												<td>2011/04/25</td>
												<td>$320,800</td>
												<td>5421</td>
												<td><a href="/cdn-cgi/l/email-protection"
													class="__cf_email__"
													data-cfemail="13673d7d7a6b7c7d53777267726772717f76603d7d7667">[email&#160;protected]</a></td>
											</tr>
											<tr>
												<td>Garrett</td>
												<td>Winters</td>
												<td>Accountant</td>
												<td>Tokyo</td>
												<td>63</td>
												<td>2011/07/25</td>
												<td>$170,750</td>
												<td>8422</td>
												<td><a href="/cdn-cgi/l/email-protection"
													class="__cf_email__"
													data-cfemail="03642d746a6d7766717043676277627762616f66702d6d6677">[email&#160;protected]</a></td>
											</tr>
											<tr>
												<td>Ashton</td>
												<td>Cox</td>
												<td>Junior Technical Author</td>
												<td>San Francisco</td>
												<td>66</td>
												<td>2009/01/12</td>
												<td>$86,000</td>
												<td>1562</td>
												<td><a href="/cdn-cgi/l/email-protection"
													class="__cf_email__"
													data-cfemail="30511e535f4870545144514451525c55431e5e5544">[email&#160;protected]</a></td>
											</tr>
											<tr>
												<td>Cedric</td>
												<td>Kelly</td>
												<td>Senior Javascript Developer</td>
												<td>Edinburgh</td>
												<td>22</td>
												<td>2012/03/29</td>
												<td>$433,060</td>
												<td>6224</td>
												<td><a href="/cdn-cgi/l/email-protection"
													class="__cf_email__"
													data-cfemail="7b1855101e1717023b1f1a0f1a0f1a19171e0855151e0f">[email&#160;protected]</a></td>
											</tr>
											<tr>
												<td>Airi</td>
												<td>Satou</td>
												<td>Accountant</td>
												<td>Tokyo</td>
												<td>33</td>
												<td>2008/11/28</td>
												<td>$162,700</td>
												<td>5407</td>
												<td><a href="/cdn-cgi/l/email-protection"
													class="__cf_email__"
													data-cfemail="14753a6775607b6154707560756075767871673a7a7160">[email&#160;protected]</a></td>
											</tr>
											<tr>
												<td>Brielle</td>
												<td>Williamson</td>
												<td>Integration Specialist</td>
												<td>New York</td>
												<td>61</td>
												<td>2012/12/02</td>
												<td>$372,000</td>
												<td>4804</td>
												<td><a href="/cdn-cgi/l/email-protection"
													class="__cf_email__"
													data-cfemail="05672b726c69696c6468766a6b45616471647164676960762b6b6071">[email&#160;protected]</a></td>
											</tr>
											<tr>
												<td>Herrod</td>
												<td>Chandler</td>
												<td>Sales Assistant</td>
												<td>San Francisco</td>
												<td>59</td>
												<td>2012/08/06</td>
												<td>$137,500</td>
												<td>9608</td>
												<td><a href="/cdn-cgi/l/email-protection"
													class="__cf_email__"
													data-cfemail="ed85c38e858c838981889fad898c998c998c8f81889ec3838899">[email&#160;protected]</a></td>
											</tr>
											<tr>
												<td>Rhona</td>
												<td>Davidson</td>
												<td>Integration Specialist</td>
												<td>Tokyo</td>
												<td>55</td>
												<td>2010/10/14</td>
												<td>$327,900</td>
												<td>6200</td>
												<td><a href="/cdn-cgi/l/email-protection"
													class="__cf_email__"
													data-cfemail="8bf9a5efeafde2eff8e4e5cbefeaffeaffeae9e7eef8a5e5eeff">[email&#160;protected]</a></td>
											</tr>
											<tr>
												<td>Colleen</td>
												<td>Hurst</td>
												<td>Javascript Developer</td>
												<td>San Francisco</td>
												<td>39</td>
												<td>2009/09/15</td>
												<td>$205,500</td>
												<td>2360</td>
												<td><a href="/cdn-cgi/l/email-protection"
													class="__cf_email__"
													data-cfemail="c8abe6a0bdbabbbc88aca9bca9bca9aaa4adbbe6a6adbc">[email&#160;protected]</a></td>
											</tr>
											<tr>
												<td>Sonya</td>
												<td>Frost</td>
												<td>Software Engineer</td>
												<td>Edinburgh</td>
												<td>23</td>
												<td>2008/12/13</td>
												<td>$103,600</td>
												<td>1667</td>
												<td><a href="/cdn-cgi/l/email-protection"
													class="__cf_email__"
													data-cfemail="03702d65716c707743676277627762616f66702d6d6677">[email&#160;protected]</a></td>
											</tr>
											<tr>
												<td>Jena</td>
												<td>Gaines</td>
												<td>Office Manager</td>
												<td>London</td>
												<td>30</td>
												<td>2008/12/19</td>
												<td>$90,560</td>
												<td>3814</td>
												<td><a href="/cdn-cgi/l/email-protection"
													class="__cf_email__"
													data-cfemail="6a00440d0b03040f192a0e0b1e0b1e0b08060f1944040f1e">[email&#160;protected]</a></td>
											</tr>
											<tr>
												<td>Quinn</td>
												<td>Flynn</td>
												<td>Support Lead</td>
												<td>Edinburgh</td>
												<td>22</td>
												<td>2013/03/03</td>
												<td>$342,000</td>
												<td>9497</td>
												<td><a href="/cdn-cgi/l/email-protection"
													class="__cf_email__"
													data-cfemail="73025d151f0a1d1d33171207120712111f16005d1d1607">[email&#160;protected]</a></td>
											</tr>
											<tr>
												<td>Charde</td>
												<td>Marshall</td>
												<td>Regional Director</td>
												<td>San Francisco</td>
												<td>36</td>
												<td>2008/10/16</td>
												<td>$470,600</td>
												<td>6741</td>
												<td><a href="/cdn-cgi/l/email-protection"
													class="__cf_email__"
													data-cfemail="d5b6fbb8b4a7a6bdb4b9b995b1b4a1b4a1b4b7b9b0a6fbbbb0a1">[email&#160;protected]</a></td>
											</tr>
											<tr>
												<td>Haley</td>
												<td>Kennedy</td>
												<td>Senior Marketing Designer</td>
												<td>London</td>
												<td>43</td>
												<td>2012/12/18</td>
												<td>$313,500</td>
												<td>3597</td>
												<td><a href="/cdn-cgi/l/email-protection"
													class="__cf_email__"
													data-cfemail="197137727c77777c7d60597d786d786d787b757c6a37777c6d">[email&#160;protected]</a></td>
											</tr>
											<tr>
												<td>Tatyana</td>
												<td>Fitzpatrick</td>
												<td>Regional Director</td>
												<td>London</td>
												<td>19</td>
												<td>2010/03/17</td>
												<td>$385,750</td>
												<td>1965</td>
												<td><a href="/cdn-cgi/l/email-protection"
													class="__cf_email__"
													data-cfemail="295d074f405d5359485d5b404a42694d485d485d484b454c5a07474c5d">[email&#160;protected]</a></td>
											</tr>
											<tr>
												<td>Michael</td>
												<td>Silva</td>
												<td>Marketing Designer</td>
												<td>London</td>
												<td>66</td>
												<td>2012/11/27</td>
												<td>$198,500</td>
												<td>1581</td>
												<td><a href="/cdn-cgi/l/email-protection"
													class="__cf_email__"
													data-cfemail="deb3f0adb7b2a8bf9ebabfaabfaabfbcb2bbadf0b0bbaa">[email&#160;protected]</a></td>
											</tr>
											<tr>
												<td>Paul</td>
												<td>Byrd</td>
												<td>Chief Financial Officer (CFO)</td>
												<td>New York</td>
												<td>64</td>
												<td>2010/06/09</td>
												<td>$725,000</td>
												<td>3059</td>
												<td><a href="/cdn-cgi/l/email-protection"
													class="__cf_email__"
													data-cfemail="f181df93888395b1959085908590939d9482df9f9485">[email&#160;protected]</a></td>
											</tr>
											<tr>
												<td>Gloria</td>
												<td>Little</td>
												<td>Systems Administrator</td>
												<td>New York</td>
												<td>59</td>
												<td>2009/04/10</td>
												<td>$237,500</td>
												<td>1721</td>
												<td><a href="/cdn-cgi/l/email-protection"
													class="__cf_email__"
													data-cfemail="395e1755504d4d555c795d584d584d585b555c4a17575c4d">[email&#160;protected]</a></td>
											</tr>
											<tr>
												<td>Bradley</td>
												<td>Greer</td>
												<td>Software Engineer</td>
												<td>London</td>
												<td>41</td>
												<td>2012/10/13</td>
												<td>$132,000</td>
												<td>2558</td>
												<td><a href="/cdn-cgi/l/email-protection"
													class="__cf_email__"
													data-cfemail="0f6d21687d6a6a7d4f6b6e7b6e7b6e6d636a7c21616a7b">[email&#160;protected]</a></td>
											</tr>
											<tr>
												<td>Dai</td>
												<td>Rios</td>
												<td>Personnel Lead</td>
												<td>Edinburgh</td>
												<td>35</td>
												<td>2012/09/26</td>
												<td>$217,500</td>
												<td>2290</td>
												<td><a href="/cdn-cgi/l/email-protection"
													class="__cf_email__"
													data-cfemail="24400a564d4b5764404550455045464841570a4a4150">[email&#160;protected]</a></td>
											</tr>
											<tr>
												<td>Jenette</td>
												<td>Caldwell</td>
												<td>Development Lead</td>
												<td>New York</td>
												<td>30</td>
												<td>2011/09/03</td>
												<td>$345,000</td>
												<td>1937</td>
												<td><a href="/cdn-cgi/l/email-protection"
													class="__cf_email__"
													data-cfemail="305a1e53515c5447555c5c70545144514451525c55431e5e5544">[email&#160;protected]</a></td>
											</tr>
											<tr>
												<td>Yuri</td>
												<td>Berry</td>
												<td>Chief Marketing Officer (CMO)</td>
												<td>New York</td>
												<td>40</td>
												<td>2009/06/25</td>
												<td>$675,000</td>
												<td>6154</td>
												<td><a href="/cdn-cgi/l/email-protection"
													class="__cf_email__"
													data-cfemail="5f26713d3a2d2d261f3b3e2b3e2b3e3d333a2c71313a2b">[email&#160;protected]</a></td>
											</tr>
											<tr>
												<td>Caesar</td>
												<td>Vance</td>
												<td>Pre-Sales Support</td>
												<td>New York</td>
												<td>21</td>
												<td>2011/12/12</td>
												<td>$106,450</td>
												<td>8330</td>
												<td><a href="/cdn-cgi/l/email-protection"
													class="__cf_email__"
													data-cfemail="87e4a9f1e6e9e4e2c7e3e6f3e6f3e6e5ebe2f4a9e9e2f3">[email&#160;protected]</a></td>
											</tr>
											<tr>
												<td>Doris</td>
												<td>Wilder</td>
												<td>Sales Assistant</td>
												<td>Sidney</td>
												<td>23</td>
												<td>2010/09/20</td>
												<td>$85,600</td>
												<td>3023</td>
												<td><a href="/cdn-cgi/l/email-protection"
													class="__cf_email__"
													data-cfemail="dfbbf1a8b6b3bbbaad9fbbbeabbeabbebdb3baacf1b1baab">[email&#160;protected]</a></td>
											</tr>
											<tr>
												<td>Angelica</td>
												<td>Ramos</td>
												<td>Chief Executive Officer (CEO)</td>
												<td>London</td>
												<td>47</td>
												<td>2009/10/09</td>
												<td>$1,200,000</td>
												<td>5797</td>
												<td><a href="/cdn-cgi/l/email-protection"
													class="__cf_email__"
													data-cfemail="0d6c237f6c60627e4d696c796c796c6f61687e23636879">[email&#160;protected]</a></td>
											</tr>
											<tr>
												<td>Gavin</td>
												<td>Joyce</td>
												<td>Developer</td>
												<td>Edinburgh</td>
												<td>42</td>
												<td>2010/12/22</td>
												<td>$92,575</td>
												<td>8822</td>
												<td><a href="/cdn-cgi/l/email-protection"
													class="__cf_email__"
													data-cfemail="d0b7febabfa9b3b590b4b1a4b1a4b1b2bcb5a3febeb5a4">[email&#160;protected]</a></td>
											</tr>
											<tr>
												<td>Jennifer</td>
												<td>Chang</td>
												<td>Regional Director</td>
												<td>Singapore</td>
												<td>28</td>
												<td>2010/11/14</td>
												<td>$357,650</td>
												<td>9239</td>
												<td><a href="/cdn-cgi/l/email-protection"
													class="__cf_email__"
													data-cfemail="23490d404b424d4463474257425742414f46500d4d4657">[email&#160;protected]</a></td>
											</tr>
											<tr>
												<td>Brenden</td>
												<td>Wagner</td>
												<td>Software Engineer</td>
												<td>San Francisco</td>
												<td>28</td>
												<td>2011/06/07</td>
												<td>$206,850</td>
												<td>1314</td>
												<td><a href="/cdn-cgi/l/email-protection"
													class="__cf_email__"
													data-cfemail="9efcb0e9fff9f0fbecdefaffeaffeafffcf2fbedb0f0fbea">[email&#160;protected]</a></td>
											</tr>
											<tr>
												<td>Fiona</td>
												<td>Green</td>
												<td>Chief Operating Officer (COO)</td>
												<td>San Francisco</td>
												<td>48</td>
												<td>2010/03/11</td>
												<td>$850,000</td>
												<td>2947</td>
												<td><a href="/cdn-cgi/l/email-protection"
													class="__cf_email__"
													data-cfemail="0d6b236a7f6868634d696c796c796c6f61687e23636879">[email&#160;protected]</a></td>
											</tr>
											<tr>
												<td>Shou</td>
												<td>Itou</td>
												<td>Regional Marketing</td>
												<td>Tokyo</td>
												<td>20</td>
												<td>2011/08/14</td>
												<td>$163,000</td>
												<td>8899</td>
												<td><a href="/cdn-cgi/l/email-protection"
													class="__cf_email__"
													data-cfemail="8cffa2e5f8e3f9cce8edf8edf8edeee0e9ffa2e2e9f8">[email&#160;protected]</a></td>
											</tr>
											<tr>
												<td>Michelle</td>
												<td>House</td>
												<td>Integration Specialist</td>
												<td>Sidney</td>
												<td>37</td>
												<td>2011/06/02</td>
												<td>$95,400</td>
												<td>2769</td>
												<td><a href="/cdn-cgi/l/email-protection"
													class="__cf_email__"
													data-cfemail="c7aae9afa8b2b4a287a3a6b3a6b3a6a5aba2b4e9a9a2b3">[email&#160;protected]</a></td>
											</tr>
											<tr>
												<td>Suki</td>
												<td>Burks</td>
												<td>Developer</td>
												<td>London</td>
												<td>53</td>
												<td>2009/10/22</td>
												<td>$114,500</td>
												<td>6832</td>
												<td><a href="/cdn-cgi/l/email-protection"
													class="__cf_email__"
													data-cfemail="20530e4255524b5360444154415441424c45530e4e4554">[email&#160;protected]</a></td>
											</tr>
											<tr>
												<td>Prescott</td>
												<td>Bartlett</td>
												<td>Technical Author</td>
												<td>London</td>
												<td>27</td>
												<td>2011/05/07</td>
												<td>$145,000</td>
												<td>3606</td>
												<td><a href="/cdn-cgi/l/email-protection"
													class="__cf_email__"
													data-cfemail="90e0bef2f1e2e4fcf5e4e4d0f4f1e4f1e4f1f2fcf5e3befef5e4">[email&#160;protected]</a></td>
											</tr>
											<tr>
												<td>Gavin</td>
												<td>Cortez</td>
												<td>Team Leader</td>
												<td>San Francisco</td>
												<td>22</td>
												<td>2008/10/26</td>
												<td>$235,500</td>
												<td>2860</td>
												<td><a href="/cdn-cgi/l/email-protection"
													class="__cf_email__"
													data-cfemail="f790d994988583928db7939683968396959b9284d9999283">[email&#160;protected]</a></td>
											</tr>
											<tr>
												<td>Martena</td>
												<td>Mccray</td>
												<td>Post-Sales support</td>
												<td>Edinburgh</td>
												<td>46</td>
												<td>2011/03/09</td>
												<td>$324,050</td>
												<td>8240</td>
												<td><a href="/cdn-cgi/l/email-protection"
													class="__cf_email__"
													data-cfemail="9cf1b2f1ffffeefde5dcf8fde8fde8fdfef0f9efb2f2f9e8">[email&#160;protected]</a></td>
											</tr>
											<tr>
												<td>Unity</td>
												<td>Butler</td>
												<td>Marketing Designer</td>
												<td>San Francisco</td>
												<td>47</td>
												<td>2009/12/09</td>
												<td>$85,675</td>
												<td>5384</td>
												<td><a href="/cdn-cgi/l/email-protection"
													class="__cf_email__"
													data-cfemail="a4d18ac6d1d0c8c1d6e4c0c5d0c5d0c5c6c8c1d78acac1d0">[email&#160;protected]</a></td>
											</tr>
											<tr>
												<td>Howard</td>
												<td>Hatfield</td>
												<td>Office Manager</td>
												<td>San Francisco</td>
												<td>51</td>
												<td>2008/12/16</td>
												<td>$164,500</td>
												<td>7031</td>
												<td><a href="/cdn-cgi/l/email-protection"
													class="__cf_email__"
													data-cfemail="fc94d2949d889a95999098bc989d889d889d9e90998fd2929988">[email&#160;protected]</a></td>
											</tr>
											<tr>
												<td>Hope</td>
												<td>Fuentes</td>
												<td>Secretary</td>
												<td>San Francisco</td>
												<td>41</td>
												<td>2010/02/12</td>
												<td>$109,850</td>
												<td>6318</td>
												<td><a href="/cdn-cgi/l/email-protection"
													class="__cf_email__"
													data-cfemail="89e1a7effcece7fdecfac9ede8fde8fde8ebe5ecfaa7e7ecfd">[email&#160;protected]</a></td>
											</tr>
											<tr>
												<td>Vivian</td>
												<td>Harrell</td>
												<td>Financial Controller</td>
												<td>San Francisco</td>
												<td>62</td>
												<td>2009/02/14</td>
												<td>$452,500</td>
												<td>9422</td>
												<td><a href="/cdn-cgi/l/email-protection"
													class="__cf_email__"
													data-cfemail="30461e58514242555c5c70545144514451525c55431e5e5544">[email&#160;protected]</a></td>
											</tr>
											<tr>
												<td>Timothy</td>
												<td>Mooney</td>
												<td>Office Manager</td>
												<td>London</td>
												<td>37</td>
												<td>2008/12/11</td>
												<td>$136,200</td>
												<td>7580</td>
												<td><a href="/cdn-cgi/l/email-protection"
													class="__cf_email__"
													data-cfemail="c4b0eaa9ababaaa1bd84a0a5b0a5b0a5a6a8a1b7eaaaa1b0">[email&#160;protected]</a></td>
											</tr>
											<tr>
												<td>Jackson</td>
												<td>Bradshaw</td>
												<td>Director</td>
												<td>New York</td>
												<td>65</td>
												<td>2008/09/26</td>
												<td>$645,750</td>
												<td>1042</td>
												<td><a href="/cdn-cgi/l/email-protection"
													class="__cf_email__"
													data-cfemail="8de7a3efffece9fee5ecfacde9ecf9ecf9ecefe1e8fea3e3e8f9">[email&#160;protected]</a></td>
											</tr>
											<tr>
												<td>Olivia</td>
												<td>Liang</td>
												<td>Support Engineer</td>
												<td>Singapore</td>
												<td>64</td>
												<td>2011/02/03</td>
												<td>$234,500</td>
												<td>2120</td>
												<td><a href="/cdn-cgi/l/email-protection"
													class="__cf_email__"
													data-cfemail="9af5b4f6f3fbf4fddafefbeefbeefbf8f6ffe9b4f4ffee">[email&#160;protected]</a></td>
											</tr>
											<tr>
												<td>Bruno</td>
												<td>Nash</td>
												<td>Software Engineer</td>
												<td>London</td>
												<td>38</td>
												<td>2011/05/03</td>
												<td>$163,500</td>
												<td>6222</td>
												<td><a href="/cdn-cgi/l/email-protection"
													class="__cf_email__"
													data-cfemail="385a1656594b50785c594c594c595a545d4b16565d4c">[email&#160;protected]</a></td>
											</tr>
											<tr>
												<td>Sakura</td>
												<td>Yamamoto</td>
												<td>Support Engineer</td>
												<td>Tokyo</td>
												<td>37</td>
												<td>2009/08/19</td>
												<td>$139,575</td>
												<td>9383</td>
												<td><a href="/cdn-cgi/l/email-protection"
													class="__cf_email__"
													data-cfemail="62114c1b030f030f0d160d22060316031603000e07114c0c0716">[email&#160;protected]</a></td>
											</tr>
											<tr>
												<td>Thor</td>
												<td>Walton</td>
												<td>Developer</td>
												<td>New York</td>
												<td>61</td>
												<td>2013/08/11</td>
												<td>$98,540</td>
												<td>8327</td>
												<td><a href="/cdn-cgi/l/email-protection"
													class="__cf_email__"
													data-cfemail="b3c79dc4d2dfc7dcddf3d7d2c7d2c7d2d1dfd6c09dddd6c7">[email&#160;protected]</a></td>
											</tr>
											<tr>
												<td>Finn</td>
												<td>Camacho</td>
												<td>Support Engineer</td>
												<td>San Francisco</td>
												<td>47</td>
												<td>2009/07/07</td>
												<td>$87,500</td>
												<td>2927</td>
												<td><a href="/cdn-cgi/l/email-protection"
													class="__cf_email__"
													data-cfemail="61074f02000c0002090e21050015001500030d04124f0f0415">[email&#160;protected]</a></td>
											</tr>
											<tr>
												<td>Serge</td>
												<td>Baldwin</td>
												<td>Data Coordinator</td>
												<td>Singapore</td>
												<td>64</td>
												<td>2012/04/09</td>
												<td>$138,575</td>
												<td>8352</td>
												<td><a href="/cdn-cgi/l/email-protection"
													class="__cf_email__"
													data-cfemail="40336e22212c2437292e00242134213421222c25336e2e2534">[email&#160;protected]</a></td>
											</tr>
											<tr>
												<td>Zenaida</td>
												<td>Frank</td>
												<td>Software Engineer</td>
												<td>New York</td>
												<td>63</td>
												<td>2010/01/04</td>
												<td>$125,250</td>
												<td>7439</td>
												<td><a href="/cdn-cgi/l/email-protection"
													class="__cf_email__"
													data-cfemail="a5df8bc3d7c4cbcee5c1c4d1c4d1c4c7c9c0d68bcbc0d1">[email&#160;protected]</a></td>
											</tr>
											<tr>
												<td>Zorita</td>
												<td>Serrano</td>
												<td>Software Engineer</td>
												<td>San Francisco</td>
												<td>56</td>
												<td>2012/06/01</td>
												<td>$115,000</td>
												<td>4389</td>
												<td><a href="/cdn-cgi/l/email-protection"
													class="__cf_email__"
													data-cfemail="9ae0b4e9ffe8e8fbf4f5dafefbeefbeefbf8f6ffe9b4f4ffee">[email&#160;protected]</a></td>
											</tr>
											<tr>
												<td>Jennifer</td>
												<td>Acosta</td>
												<td>Junior Javascript Developer</td>
												<td>Edinburgh</td>
												<td>43</td>
												<td>2013/02/01</td>
												<td>$75,650</td>
												<td>3431</td>
												<td><a href="/cdn-cgi/l/email-protection"
													class="__cf_email__"
													data-cfemail="503a7e31333f23243110343124312431323c35237e3e3524">[email&#160;protected]</a></td>
											</tr>
											<tr>
												<td>Cara</td>
												<td>Stevens</td>
												<td>Sales Assistant</td>
												<td>New York</td>
												<td>46</td>
												<td>2011/12/06</td>
												<td>$145,600</td>
												<td>3990</td>
												<td><a href="/cdn-cgi/l/email-protection"
													class="__cf_email__"
													data-cfemail="c9aae7babdacbfaca7ba89ada8bda8bda8aba5acbae7a7acbd">[email&#160;protected]</a></td>
											</tr>
											<tr>
												<td>Hermione</td>
												<td>Butler</td>
												<td>Regional Director</td>
												<td>London</td>
												<td>47</td>
												<td>2011/03/21</td>
												<td>$356,250</td>
												<td>1016</td>
												<td><a href="/cdn-cgi/l/email-protection"
													class="__cf_email__"
													data-cfemail="caa2e4a8bfbea6afb88aaeabbeabbeaba8a6afb9e4a4afbe">[email&#160;protected]</a></td>
											</tr>
											<tr>
												<td>Lael</td>
												<td>Greer</td>
												<td>Systems Administrator</td>
												<td>London</td>
												<td>21</td>
												<td>2009/02/27</td>
												<td>$103,500</td>
												<td>6733</td>
												<td><a href="/cdn-cgi/l/email-protection"
													class="__cf_email__"
													data-cfemail="afc381c8ddcacaddefcbcedbcedbcecdc3cadc81c1cadb">[email&#160;protected]</a></td>
											</tr>
											<tr>
												<td>Jonas</td>
												<td>Alexander</td>
												<td>Developer</td>
												<td>San Francisco</td>
												<td>30</td>
												<td>2010/07/14</td>
												<td>$86,500</td>
												<td>8196</td>
												<td><a href="/cdn-cgi/l/email-protection"
													class="__cf_email__"
													data-cfemail="503a7e313c3528313e34352210343124312431323c35237e3e3524">[email&#160;protected]</a></td>
											</tr>
											<tr>
												<td>Shad</td>
												<td>Decker</td>
												<td>Regional Director</td>
												<td>Edinburgh</td>
												<td>51</td>
												<td>2008/11/13</td>
												<td>$183,000</td>
												<td>6373</td>
												<td><a href="/cdn-cgi/l/email-protection"
													class="__cf_email__"
													data-cfemail="aad984cecfc9c1cfd8eacecbdecbdecbc8c6cfd984c4cfde">[email&#160;protected]</a></td>
											</tr>
											<tr>
												<td>Michael</td>
												<td>Bruce</td>
												<td>Javascript Developer</td>
												<td>Singapore</td>
												<td>29</td>
												<td>2011/06/27</td>
												<td>$183,000</td>
												<td>5384</td>
												<td><a href="/cdn-cgi/l/email-protection"
													class="__cf_email__"
													data-cfemail="bcd192decec9dfd9fcd8ddc8ddc8ddded0d9cf92d2d9c8">[email&#160;protected]</a></td>
											</tr>
											<tr>
												<td>Donna</td>
												<td>Snider</td>
												<td>Customer Support</td>
												<td>New York</td>
												<td>27</td>
												<td>2011/01/25</td>
												<td>$112,000</td>
												<td>4226</td>
												<td><a href="/cdn-cgi/l/email-protection"
													class="__cf_email__"
													data-cfemail="21450f524f4845445361454055405540434d44520f4f4455">[email&#160;protected]</a></td>
											</tr>
>>>>>>> Stashed changes
										</tbody>
									</table>
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
	<!-- iCheck -->
	<script
		src="${pageContext.request.contextPath}/resources/vendors/iCheck/icheck.min.js"></script>
	<!-- Datatables -->
	<script
		src="${pageContext.request.contextPath}/resources/vendors/datatables.net/js/jquery.dataTables.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/vendors/jszip/dist/jszip.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/vendors/pdfmake/build/pdfmake.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/vendors/pdfmake/build/vfs_fonts.js"></script>

	<!-- Custom Theme Scripts -->
	<script
		src="${pageContext.request.contextPath}/resources/styles/js/custom.min.js"></script>

</body>
</html>
