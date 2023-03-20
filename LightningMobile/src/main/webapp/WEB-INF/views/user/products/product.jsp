<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layouts/user/taglib.jsp"%>

<head>
<meta charset="UTF-8">
<title>Chi tiết sản phẩm</title>
<style>
.hide-x-scrollbar {
	overflow-x: hidden
}
</style>
</head>
<body>
	<div class="row hide-x-scrollbar">
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
				<li><a href="index.html">Trang chủ</a> <span class="divider">/</span></li>
				<li><a href="products.html">Sản phẩm</a> <span class="divider">/</span></li>
				<li class="active">Chi tiết sản phẩm</li>
			</ul>
			<div class="well well-small">
				<div class="row-fluid">
					<div class="span5">
						<div id="myCarousel" class="carousel slide cntr">
							<div class="carousel-inner">
								<div class="item active">
									<a href="#"> <img
										src="<c:url value="/assets/user/img/${ product.img }" />"
										alt="" style="width: 100%"></a>
								</div>
							</div>
							<a class="left carousel-control" href="#myCarousel"
								data-slide="prev">‹</a> <a class="right carousel-control"
								href="#myCarousel" data-slide="next">›</a>
						</div>
					</div>
					<div class="span7">
						<h3>${ product.name }</h3>
						<hr class="soft" />

						<form class="form-horizontal qtyFrm" method="get" action="<c:url value="/addtoCart/${ product.id_product }" />">
							<div class="control-group">
								<label class="control-label"><span><fmt:formatNumber
											type="number" groupingUsed="true" value="${ product.price }" />₫</span></label>
								<div class="controls">
									<input type="number" min="0" value="0" class="span6">
								</div>
							</div>

							<div class="control-group">
								<label class="control-label"><span>Color</span></label>
								<div class="controls">
									<select class="span11">
										<option>Red</option>
										<option>Purple</option>
										<option>Pink</option>
										<option>Red</option>
									</select>
								</div>
							</div>

							<h4>100 items in stock</h4>
							<p>Nowadays the lingerie industry is one of the most
								successful business spheres. Nowadays the lingerie industry is
								one of ...
							<p>
								<button type="submit" class="shopBtn">
									<span class=" icon-shopping-cart"></span> Add to cart
								</button>
						</form>
					</div>
				</div>
				<hr class="softn clr" />


				<ul id="productDetail" class="nav nav-tabs">
					<li class="active"><a href="#home" data-toggle="tab">Chi
							tiết sản phẩm</a></li>
					<li class=""><a href="#profile" data-toggle="tab">Sản phẩm
							liên quan </a></li>
				</ul>
				<div id="myTabContent" class="tab-content tabWrapper">
					${ product.details }
					<div class="tab-pane fade" id="profile">
						<c:set var="max" value="${ listProductByCatId.size() }" />
						<c:if test="${ listProductByCatId.size() > 6 }">
							<c:set var="max" value="6" />
						</c:if>
						<c:forEach var="item" items="${ listProductByCatId }" begin="1" end="${ max }" varStatus="itemS">
							<div class="row-fluid">
								<div class="span2">
									<img src="<c:url value="/assets/user/img/${ item.img }" />"
										alt="">
								</div>
								<div class="span6">
									<h5>${ item.name }</h5>
									<p>${ item.title }</p>
								</div>
								<div class="span4 alignR">
									<form class="form-horizontal qtyFrm">
										<h3>
											<fmt:formatNumber type="number" groupingUsed="true"
												value="${ item.price }" />
											₫
										</h3>
										<div class="btn-group">
											<a href="product_details.html" class="defaultBtn"><span
												class=" icon-shopping-cart"></span> Add to cart</a> <a
												href="product_details.html" class="shopBtn">VIEW</a>
										</div>
									</form>
								</div>
							</div>
							<hr class="soft">
						</c:forEach>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
