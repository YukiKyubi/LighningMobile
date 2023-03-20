<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ include file="/WEB-INF/views/layouts/user/taglib.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title><decorator:title default="Master-layout"/></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<!-- Bootstrap styles -->
<link href="<c:url value = "/assets/user/css/bootstrap.css"/>" rel="stylesheet" />
<!-- Customize styles -->
<link href="<c:url value = "/assets/user/style.css" />" rel="stylesheet" />
<!-- font awesome styles -->
<link href="<c:url value = "/assets/user/font-awesome/css/font-awesome.css" />" rel="stylesheet">
<!--[if IE 7]>
			<link href="css/font-awesome-ie7.min.css" rel="stylesheet">
		<![endif]-->

<!--[if lt IE 9]>
			<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->

<!-- Favicons -->
<link rel="shortcut icon" href="<c:url value = "/assets/user/ico/favicon.ico" />">
<decorator:head/>
<style type="text/css">
	html {
		scroll-behavior: smooth
	}
</style>
</head>
<body style="background: url(<c:url value = "/assets/user/img/white_leather.png" />) repeat 0 0">

	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="topNav">
			<div class="container">
				<div class="alignR">
					<div class="pull-left socialNw">
						<a href="#"><span class="icon-twitter"></span></a> <a href="#"><span
							class="icon-facebook"></span></a> <a href="#"><span
							class="icon-youtube"></span></a> <a href="#"><span
							class="icon-tumblr"></span></a>
					</div>
					<a class="" href="index.html"> <span class="icon-home"></span>
						Trang chủ
					<c:if test="${ not empty LoginSession }">
						</a> <a href="#"><span class="icon-user"></span>${ LoginSession.display_name }</a>
						<a href="<c:url value="/logout" />"><span class="icon-edit"></span> Đăng xuất </a>
						<a href="contact.html"><span class="icon-envelope"></span>
						Liên hệ</a> <a class="clickToCart" href="<c:url value="/cart"/>">
					</c:if>
					<c:if test="${ empty LoginSession }">
						</a> <a href="<c:url value = "/register" />"><span class="icon-user"></span>Đăng nhập/Đăng ký</a>
						<a href="contact.html"><span class="icon-envelope"></span>
						Liên hệ</a> <a class="clickToCart" href="<c:url value="/register"/>">
					</c:if>
					<c:if test="${ empty totalQuantity }">
						<span class="icon-shopping-cart"></span> 0 Item(s)
					</c:if>
					<c:if test="${ not empty totalQuantity }">
						<span class="icon-shopping-cart"></span> ${ totalQuantity } Item(s)
					</c:if>
					<c:if test="${ empty totalPrice }">
						- <span class="badge badge-warning"> <fmt:formatNumber
								type="number" groupingUsed="true" value="0" /> ₫
					</span></a>
					</c:if>
					<c:if test="${ not empty totalPrice }">
						- <span class="badge badge-warning"> <fmt:formatNumber
								type="number" groupingUsed="true" value="${ totalPrice }" /> ₫
					</span></a>
					</c:if>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div id="gototop"></div>
		
		<%@ include file="/WEB-INF/views/layouts/user/header.jsp" %>
		
		<decorator:body />
		
		<%@ include file="/WEB-INF/views/layouts/user/footer.jsp" %>
	</div>
	<!-- /container -->

	<div class="copyright">
		<div class="container">
			<p class="pull-right" style="margin-right: 40px">
				<a href="#"><img src="<c:url value="/assets/user/img/maestro.png" />" alt="payment"></a>
				<a href="#"><img src="<c:url value="/assets/user/img/mc.png" />" alt="payment"></a> <a
					href="#"><img src="<c:url value="/assets/user/img/pp.png" />" alt="payment"></a> <a
					href="#"><img src="<c:url value="/assets/user/img/visa.png" />" alt="payment"></a> <a
					href="#"><img src="<c:url value="/assets/user/img/disc.png" />" alt="payment"></a>
			</p>
			<span>Bản quyền &copy; 2023<br> bootstrap ecommerce
				shopping template
			</span>
		</div>
	</div>
	<button id="goToTop" class="gotop"><i class="icon-double-angle-up"></i></button>
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="<c:url value = "/assets/user/js/jquery.js" />"></script>
	<script src="<c:url value = "/assets/user/js/bootstrap.min.js" />"></script>
	<script src="<c:url value = "/assets/user/js/jquery.easing-1.3.min.js" />"></script>
	<script src="<c:url value = "/assets/user/js/jquery.scrollTo-1.4.3.1-min.js" />"></script>
	<script src="<c:url value = "/assets/user/js/shop.js" />"></script>
	<decorator:getProperty property="page.script"></decorator:getProperty>
	<script>
		var topBtn = document.getElementById('goToTop')
		topBtn.onclick = function goToTop() {
			document.body.scrollTop = 0;
			document.documentElement.scrollTop = 0;
		}
	</script>
</body>
</html>