<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">

  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Information</title>

    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/resources/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="${pageContext.request.contextPath}/resources/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="${pageContext.request.contextPath}/resources/vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="${pageContext.request.contextPath}/resources/vendors/iCheck/skins/flat/green.css" rel="stylesheet">
    <!-- bootstrap-progressbar -->
    <link href="${pageContext.request.contextPath}/resources/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
    <!-- PNotify -->
    <link href="${pageContext.request.contextPath}/resources/vendors/pnotify/dist/pnotify.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/vendors/pnotify/dist/pnotify.buttons.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/vendors/pnotify/dist/pnotify.nonblock.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="${pageContext.request.contextPath}/resources/build/css/custom.min.css" rel="stylesheet">
    <style>
      .custom_image_dropdown_row{
        padding: 1px;
      }

      .custom_image_dropdown_item img{
        width: 100px;
        height: 100px;
        border: 1px solid darkgray;
      }
      .custom_image_dropdown_item :hover{
        border: 1px solid cornflowerblue;
        box-shadow: 0 0 10px 1px cornflowerblue;
        outline-color: blue;
      }
    </style>
    <script>
      function change_dropdown_image(event){
        document.getElementById("dropdown_image").src = event.target.src;
        document.getElementById("image_id").value =event.target.alt;
      }
    </script>

  </head>

  <body class="nav-md">
    <div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
              <a href="index.html" class="site_title"><i class="fa fa-map"></i> <span>Share Location</span></a>
            </div>

            <div class="clearfix"></div>

            <!-- menu profile quick info -->
            <div class="profile clearfix">
              <div class="profile_pic">
                <img src="images/img.jpg" alt="..." class="img-circle profile_img">
              </div>
              <div class="profile_info">
                <span>Welcome,</span>
                <h2>John Doe</h2>
              </div>
            </div>
            <!-- /menu profile quick info -->

            <br />

            <!-- sidebar menu -->
            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
              <div class="menu_section">
                <h3>General</h3>
                <ul class="nav side-menu">
                  <li><a><i class="fa fa-home"></i>Manage Users</a>
                  </li>
                  
                </ul>
              </div>
            </div>
            <!-- /sidebar menu -->
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
                <li class="">
                  <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                    <img src="images/img.jpg" alt="">John Doe
                    <span class=" fa fa-angle-down"></span>
                  </a>
                  <ul class="dropdown-menu dropdown-usermenu pull-right">
                    <li><a href="javascript:;">Edit Profile</a></li>
                    <li><a href="login.html"><i class="fa fa-sign-out pull-right"></i> Log Out</a></li>
                  </ul>
                </li>
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
                <h3>Nha Pham(ducnha12@gmail.com)</h3>
              </div>

              <div class="title_right">
                
              </div>
            </div>

            <div class="clearfix"></div>

            <div class="">
              

              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  
                  <div class="x_content">

                    <div class="col-xs-3">
                      <!-- required for floating -->
                      <!-- Nav tabs -->
                      <ul class="nav nav-tabs tabs-left">
                        <spring:url value="/user/${userid}" var="informationTabUrl"/>
                      	<spring:url value="/user/${userid}/friend" var="friendTabUrl"/>
                      	<spring:url value="/user/${userid}/location" var="locationTabUrl"/>
                        <li class="active"><a href="${informationTabUrl}">Information</a>
                        </li>
                        <li><a href="${friendTabUrl}">Friend</a>
                        </li>
                        <li><a href="${locationTabUrl}">Location</a>
                        </li>
                      </ul>
                    </div>

                    <div class="col-xs-9">
                      <!-- Tab panes -->
                      <div class="tab-content">
                        <div class="tab-pane active" id="information">
                          <p class="lead">Information</p>
                          <spring:url value="/user/${userid}/save" var="saveEditUrl"/>
                          <form class="form-horizontal form-label-left" action="${saveEditUrl}" method="post">

                      

                      <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="email">Avatar <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <div class="dropdown">
                            <input type="hidden" name="image_id" id="image_id" value=""/>
                            <button class="btn dropdown-toggle" type="button" data-toggle="dropdown"><img id="dropdown_image" src="avatar\avatar1.jpg" width="100px" height="100px"/>
                            <span class="caret"></span></button>
                            <ul class="dropdown-menu" style="height: auto; max-height: 300px; overflow-x: hidden; padding: 10px">
                              <li>
                                <div class="custom_image_dropdown_row">
                                  <a href="#" class="custom_image_dropdown_item" ><img src="avatar\avatar1.jpg" onclick="change_dropdown_image(event)" alt="id1"/></a>
                                  <a href="#" class="custom_image_dropdown_item" ><img src="avatar\avatar2.jpg" onclick="change_dropdown_image(event)"/></a>
                                  <a href="#" class="custom_image_dropdown_item" ><img src="avatar\avatar3.jpg" onclick="change_dropdown_image(event)"/></a>
                                  <a href="#" class="custom_image_dropdown_item" ><img src="avatar\avatar4.jpg" onclick="change_dropdown_image(event)"/></a>
                                </div>
                              </li>
                              
                            </ul>
                          </div>
                        </div>
                      </div>

                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Name <span class="required">*</span>
                        </label>
                        <div class="col-md-3 col-sm-6 col-xs-12">
                          <input class="form-control col-md-7 col-xs-12" placeholder="First Name" type="text" name="firstname" value="${accountDetail.firstName}">
                        </div>
                        <div class="col-md-3 col-sm-6 col-xs-12">
                          <input class="form-control col-md-7 col-xs-12" placeholder="Last Name" type="text" name="lastname" value="${accountDetail.lastName}">
                        </div>
                      </div>
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Username <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input class="form-control col-md-7 col-xs-12" type="hidden" name="username" value="${accountDetail.username}">
                          <input class="form-control col-md-7 col-xs-12" type="text" name="username" value="${accountDetail.username}" disabled>
                        </div>
                      </div>
                      
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Email <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="text" class="form-control col-md-7 col-xs-12" name="email" value="${accountDetail.email}">
                        </div>
                      </div>
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Date of Birth <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <jsp:useBean id="dateValue" class="java.util.Date"/>
						  <jsp:setProperty name="dateValue" property="time" value="${accountDetail.dateOfBirth}" />
						  <fmt:formatDate value="${dateValue}" pattern="yyyy-MM-dd" var="profileDate"/>
                          <input type="date" class="form-control col-md-7 col-xs-12" value="${profileDate}" name="dateofbirth">
                        </div>
                      </div>

                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="email">Gender <span class="required">*</span>
                        </label>
                        
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="text" class="form-control col-md-7 col-xs-12" value="${accountDetail.gender}" name="gender">
                        </div>
                      </div>
                      
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Address
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="text" class="form-control col-md-7 col-xs-12" value="${accountDetail.address}" name="address">
                        </div>
                      </div>

                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="email">Phone
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="text" class="form-control col-md-7 col-xs-12" value="${accountDetail.phone}" name="phone">
                        </div>
                      </div>

                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="email">Is Admin <span class="required">*</span>
                        </label>
                        
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="checkbox" ${accountDetail.role ? 'checked' : ''} name="role" value="true">
                        </div>
                      </div>

                      
                      <div class="ln_solid"></div>
                      <div class="form-group">
                        <div class="col-md-6 col-md-offset-3">
                          <button type="button" class="btn btn-primary">Cancel</button>
                          <button id="send" type="submit" class="btn btn-success">Save</button>
                          <spring:url value="/user/${userid}/changePassword" var="changePasswordUrl"/>
                          <a href="${changePasswordUrl}">
                            <button id="send" type="button" class="btn btn-warning">Change password</button>
                          </a>
                          
                        </div>
                      </div>
                    </form>
                        </div>
                      </div>
                    </div>

                    <div class="clearfix"></div>

                  </div>
                </div>
              </div>

              

            </div>
            <div class="clearfix"></div>

            
          </div>
          <div class="clearfix"></div>
        </div>
        <!-- /page content -->

        <!-- footer content -->
        <footer>
          <div class="pull-right">
            Gentelella - Bootstrap Admin Template by <a href="https://colorlib.com">Colorlib</a>
          </div>
          <div class="clearfix"></div>
        </footer>
        <!-- /footer content -->
      </div>
    </div>

    <div id="custom_notifications" class="custom-notifications dsp_none">
      <ul class="list-unstyled notifications clearfix" data-tabbed_notifications="notif-group">
      </ul>
      <div class="clearfix"></div>
      <div id="notif-group" class="tabbed_notifications"></div>
    </div>

    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/resources/vendors/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="${pageContext.request.contextPath}/resources/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <script src="${pageContext.request.contextPath}/resources/vendors/fastclick/lib/fastclick.js"></script>
    <!-- NProgress -->
    <script src="${pageContext.request.contextPath}/resources/vendors/nprogress/nprogress.js"></script>
    <!-- bootstrap-progressbar -->
    <script src="${pageContext.request.contextPath}/resources/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
    <!-- iCheck -->
    <script src="${pageContext.request.contextPath}/resources/vendors/iCheck/icheck.min.js"></script>


    <!-- Custom Theme Scripts -->
    <script src="${pageContext.request.contextPath}/resources/build/js/custom.min.js"></script>
	
  </body>
</html>