<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layouts/user/taglib.jsp" %>

<header id="header">
	<!-- 
	Upper Header Section 
-->
	

	<!--
Lower Header Section 
-->
	<div class="row">
		<div class="span4">
			<h1>
				<a class="logo" href="<c:url value="/homepage" />"><span>Twitter Bootstrap
						ecommerce template</span> <img
					src="<c:url value = "/assets/user/img/logoShop.png" />"
					alt="bootstrap sexy shop" width="150px"> </a>
			</h1>
		</div>
		<div class="span4 alignR" style="float: right">
			<p>
				<br> <strong> Hỗ trợ (24/7) : 0800 1234 678 </strong><br>
				<br>
			</p>
			<c:if test="${ empty LoginSession }">
				<a href="<c:url value="/register"/>" class="btn btn-mini">[
				<c:if test="${ empty totalQuantity }">
					0
				</c:if>
				<c:if test="${ not empty totalQuantity }">
					${ totalQuantity }
				</c:if>
			 ] <span
				class="icon-shopping-cart"></span></a>
			</c:if>
			
			<c:if test="${ not empty LoginSession }">
				<a href="<c:url value="/cart"/>" class="btn btn-mini">[
				<c:if test="${ empty totalQuantity }">
					0
				</c:if>
				<c:if test="${ not empty totalQuantity }">
					${ totalQuantity }
				</c:if>
			 ] <span
				class="icon-shopping-cart"></span></a>
			</c:if>
		</div>
	</div>
</header>

<!--
Navigation Bar Section 
-->
<div class="navbar">
	<div class="navbar-inner">
		<div class="container">
			<a data-target=".nav-collapse" data-toggle="collapse"
				class="btn btn-navbar"> <span class="icon-bar"></span> <span
				class="icon-bar"></span> <span class="icon-bar"></span>
			</a>
			<div class="nav-collapse">
				<ul class="nav">
					<c:forEach var="item" items="${ menu }" varStatus="index">
						<c:if test="${ index.first }">
							<li class="active">
						</c:if>
						<c:if test="${ not index.first }">
							<li class="">
						</c:if>
						<a href="<c:url value="${ item.url }" />">${ item.name }</a>
						</li>
					</c:forEach>
				</ul>
				<form:form action="/LightningMobile/search-results" modelAttribute="productsearch" class="navbar-search pull-left">
					<form:input path="name" placeholder="Tìm kiếm" class="search-query span2" />
				</form:form>
				<!-- <form action="search-results/1" class="navbar-search pull-left">
					<input type="text" placeholder="Tìm kiếm" class="search-query span2">
				</form> -->
				<ul class="nav pull-right">
					<c:if test="${ not empty LoginSession }">
						<li class="dropdown"><a data-toggle="dropdown"
						class="dropdown-toggle" href="#"><span class="icon-lock"></span>
							${ LoginSession.display_name } <!-- <b class="caret"></b> --></a>
						<!-- <div class="dropdown-menu">
							<form class="form-horizontal loginFrm">
								<div class="control-group">
									<button type="submit" class="shopBtn btn-block">Đăng xuất</button>
								</div>
							</form>
						</div> -->
					</li>
					</c:if>
					<c:if test="${ empty LoginSession }">
						<li class="dropdown"><a data-toggle="dropdown"
						class="dropdown-toggle" href="<c:url value="/register" />"><span class="icon-lock"></span>
							Đăng nhập <!-- <b class="caret"></b> --></a>
						<!-- <div class="dropdown-menu">
							<form class="form-horizontal loginFrm">
								<div class="control-group">
									<input type="text" class="span2" id="inputEmail"
										placeholder="Email">
								</div>
								<div class="control-group">
									<input type="password" class="span2" id="inputPassword"
										placeholder="Password">
								</div>
								<div class="control-group">
									<label class="checkbox"> <input type="checkbox">
										Nhớ
									</label>
									<button type="submit" class="shopBtn btn-block">Đăng nhập</button>
								</div>
							</form>
						</div> -->
					</li>
					</c:if>
				</ul>
			</div>
		</div>
	</div>
</div>