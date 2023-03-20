<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layouts/user/taglib.jsp" %>

<head>
<style>
.pagination {
	display: flex;
	justify-content: center
}
.pagination a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
	transition: background-color .3s;
	border: 1px solid #cbcbcb;
	border-radius: 1px
}

.pagination a.active {
	background-color: dodgerblue;
	color: white;
	border: 1px solid #cbcbcb;
	border-radius: 1px
}
.pagination a:hover:not(.active) {
	background-color: #ddd
}
</style>
<title>Tìm kiếm sản phẩm</title>
</head>
<body>
	<h1>CatID = ${ query }</h1>
		<div class="row">
			<span style="margin-left: 25px">Danh sách sản phẩm</span> <select
				class="pull-right">
				<option>A - Z</option>
				<option>Cao - Thấp</option>
			</select>
		</div>
		
		<c:if test="${ pagination.size() > 0 }">
			<div class="row-fluid">
				<ul class="thumbnails">
			<c:forEach var="item" items="${ pagination }" varStatus="itemS">
				<li class="span4">
					<div class="thumbnail">
						<a href="product_details.html" class="overlay"></a> <a
							class="zoomTool" href="product_details.html" title="add to cart"><span
							class="icon-search"></span> QUICK VIEW</a> <a
							href="<c:url value="/product-details/${ item.id_product }" />"><img src="<c:url value="/assets/user/img/${ item.img }" />"
							alt=""></a>
						<div class="caption cntr">
							<p>${ item.name }</p>
							<p>
								<strong> <fmt:formatNumber type="number" groupingUsed="true" value="${item.price}" />₫</strong>
							</p>
							<h4>
								<a class="shopBtn" href="#" title="add to cart"> Add to cart
								</a>
							</h4>
							<div class="actionList">
								<a class="pull-left" href="#">Add to Wish List </a> <a
									class="pull-left" href="#"> Add to Compare </a>
							</div>
							<br class="clr">
						</div>
					</div>
				</li>
				<c:if test="${ (itemS.index + 1) % 3 == 0 || (itemS.index + 1) == pagination.size() }">
						</ul>
					</div>
					<c:if test="${ itemS.index < pagination.size() }">
						<div class="row-fluid">
							<ul class="thumbnails">
					</c:if>
				</c:if>
			</c:forEach>
		</c:if>
		
	<div class="pagination">
		<a href="<c:url value="/search-results${ query }/p1" />">&laquo;</a>
		<c:forEach var="item" begin="1" end="${ paginationInfo.totalPages }" varStatus="itemS">
			<c:if test="${ itemS.index == paginationInfo.currentPage }">
				<a href="<c:url value="/search-results${ query }/p${ itemS.index }" />" class="active">${ itemS.index }</a>
			</c:if>
			<c:if test="${ itemS.index != paginationInfo.currentPage }">
				<a href="<c:url value="/search-results${ query }/p${ itemS.index }" />">${ itemS.index }</a>
			</c:if>
			<c:set var="lastpage" value="${ itemS.index }" />
		</c:forEach>
		<a href="<c:url value="/search-results${ query }/p${ lastpage }" />">&raquo;</a>
	</div>
</body>