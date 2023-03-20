<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ include file="/WEB-INF/views/layouts/user/taglib.jsp" %>

<!DOCTYPE html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title><decorator:title default="MasterLayout" /></title>
  <!-- base:css -->
  <link rel="stylesheet" href="<c:url value="/assets/admin/vendors/typicons/typicons.css" />">
  <link rel="stylesheet" href="<c:url value="/assets/admin/vendors/css/vendor.bundle.base.css" />">
  <!-- endinject -->
  <!-- plugin css for this page -->
  <!-- End plugin css for this page -->
  <!-- inject:css -->
  <link rel="stylesheet" href="<c:url value="/assets/admin/css/vertical-layout-light/style.css" />">
  <!-- endinject -->
  <link rel="shortcut icon" href="<c:url value="/assets/admin/images/favicon.png" />" />
  <decorator:head/>
</head>
<body>
  
  <div class="container-scroller">
    <!-- partial:partials/_navbar.html -->
    
    <%@ include file="/WEB-INF/views/layouts/admin/header.jsp" %>
	
	<decorator:body />
	
	
    <!-- page-body-wrapper ends -->
  </div>
  <!-- container-scroller -->

  <!-- base:js -->
  <script src="<c:url value="/assets/admin/vendors/js/vendor.bundle.base.js" />"></script>
  <!-- endinject -->
  <!-- Plugin js for this page-->
  <script src="<c:url value="/assets/admin/vendors/chart.js/Chart.min.js" />"></script>
  <!-- End plugin js for this page-->
  <!-- inject:js -->
  <script src="<c:url value="/assets/admin/js/off-canvas.js" />"></script>
  <script src="<c:url value="/assets/admin/js/hoverable-collapse.js" />"></script>
  <script src="<c:url value="/assets/admin/js/template.js" />"></script>
  <script src="<c:url value="/assets/admin/js/settings.js" />"></script>
  <script src="<c:url value="/assets/admin/js/todolist.js" />"></script>
  <!-- endinject -->
  <!-- Custom js for this page-->
  <script src="<c:url value="/assets/admin/js/dashboard.js" />"></script>
  <!-- End custom js for this page-->
</body>

</html>

