<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layouts/user/taglib.jsp" %>
<head>
<title>Đăng ký</title>
</head>
<body>
	<h1>${ login }</h1>
	<div class="row">
		<div id="sidebar" class="span3">
			<div class="well well-small">
				<ul class="nav nav-list">
					<c:forEach var="item" items="${ categories }">
						<li><a href="<c:url value = "/products/${ item.id } " />"><span
								class="icon-chevron-right"></span>${ item.name }</a></li>
					</c:forEach>
					<li><a href="<c:url value="/all-product/page1" />"><span
							class="icon-circle-blank"></span>Xem tất cả</a></li>
					<li style="border: 0">&nbsp;</li>
					<li><c:if test="${ empty totalPrice }">
							<a class="totalInCart" href="cart.html"><strong>Tổng
									tiền <span class="badge badge-warning pull-right"
									style="line-height: 18px;"><fmt:formatNumber
											type="number" groupingUsed="true" value="0" /> ₫</span>
							</strong></a>
						</c:if> <c:if test="${ not empty totalPrice }">
							<a class="totalInCart" href="cart.html"><strong>Tổng
									tiền <span class="badge badge-warning pull-right"
									style="line-height: 18px;"><fmt:formatNumber
											type="number" groupingUsed="true" value="${ totalPrice }" />
										₫</span>
							</strong></a>
						</c:if></li>
				</ul>
			</div>

			<div class="well well-small alert alert-warning cntr">
				<h2>Giảm giá 50%</h2>
				<p>
					có giá trị với các đơn hàng online <br> <br> <a
						class="defaultBtn" href="#"> Xem ngay </a>
				</p>
			</div>
			<div class="well well-small">
				<a href="#"><img
					src="<c:url value = "/assets/user/img/paypal.jpg"/>"
					alt="payment method paypal"></a>
			</div>

			<a class="shopBtn btn-block" href="#"> Sản phẩm sắp tới <br>
				<small>Xem ngay</small></a> <br> <br>
			<ul class="nav nav-list promowrapper">
				<li>
					<div class="thumbnail">
						<a class="zoomTool" href="product_details.html"
							title="add to cart"><span class="icon-search"></span> XEM
							NHANH </a> <img
							src="<c:url value = "/assets/user/img/asusrogphone6.png"/>"
							alt="bootstrap ecommerce templates">
						<div class="caption">
							<h4>
								<a class="defaultBtn" href="product_details.html">XEM</a> <span
									class="pull-right"><fmt:formatNumber type="number"
										groupingUsed="true" value="22000000" />₫</span>
							</h4>
						</div>
					</div>
				</li>
				<li style="border: 0">&nbsp;</li>
				<li>
					<div class="thumbnail">
						<a class="zoomTool" href="product_details.html"
							title="add to cart"><span class="icon-search"></span> XEM
							NHANH </a> <img
							src="<c:url value = "/assets/user/img/iphone14pm128.png"/>"
							alt="shopping cart template">
						<div class="caption">
							<h4>
								<a class="defaultBtn" href="product_details.html">XEM</a> <span
									class="pull-right"><fmt:formatNumber type="number"
										groupingUsed="true" value="18000000" />₫</span>
							</h4>
						</div>
					</div>
				</li>
				<li style="border: 0">&nbsp;</li>
				<li>
					<div class="thumbnail">
						<a class="zoomTool" href="product_details.html"
							title="add to cart"><span class="icon-search"></span> XEM
							NHANH </a> <img
							src="<c:url value = "/assets/user/img/redmagic7pro.png"/>"
							alt="bootstrap template">
						<div class="caption">
							<h4>
								<a class="defaultBtn" href="product_details.html">XEM</a> <span
									class="pull-right"><fmt:formatNumber type="number"
										groupingUsed="true" value="14000000" />₫</span>
							</h4>
						</div>
					</div>
				</li>
			</ul>

		</div>
		<div class="span9">
			<ul class="breadcrumb">
				<li><a href="index.html">Home</a> <span class="divider">/</span></li>
				<li class="active">Login</li>
			</ul>
			<h3>Login</h3>
			<hr class="soft" />

			<div class="row">
				<div class="span4">
					<div class="well">
						<h5>Tạo tài khoản</h5>
						<br />
						<form:form action="register" method="POST" modelAttribute="user">
							<div class="control-group">
								<label class="control-label" for="inputEmail">E-mail
									</label>
								<div class="controls">
									<form:input path="username" class="span3" type="email" placeholder="Email" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputEmail">Mật khẩu
									</label>
								<div class="controls">
									<form:input path="password" class="span3" type="password" placeholder="Mật khẩu" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputEmail">Tên
									</label>
								<div class="controls">
									<form:input path="display_name" class="span3" type="text" placeholder="Tên" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputEmail">Địa chỉ
									</label>
								<div class="controls">
									<form:input path="address" class="span3" type="text" placeholder="Địa chỉ" />
								</div>
							</div>
							<div class="controls">
								<button type="submit" class="btn block">Đăng ký</button>
							</div>
						</form:form>
					</div>
				</div>
				<div class="span1">&nbsp;</div>
				<div class="span4">
					<div class="well">
						<h5>Đã có tài khoản ?</h5>
						<form:form action="login" method="POST" modelAttribute="user">
							<div class="control-group">
								<label class="control-label" for="inputEmail">Email</label>
								<div class="controls">
									<form:input path="username" class="span3" type="text" placeholder="Email" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputPassword">Mật khẩu</label>
								<div class="controls">
									<form:input path="password" class="span3" type="password" placeholder="Mật khẩu" />
								</div>
							</div>
							<div class="control-group">
								<div class="controls">
									<button type="submit" class="defaultBtn">Đăng ký</button>
									<a href="#">Quên mật khẩu?</a>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>

		</div>
	</div>
</body>