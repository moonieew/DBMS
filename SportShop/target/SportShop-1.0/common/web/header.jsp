<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<a class="navbar-brand" href="home">Ecommerce</a> <span class="sr-only">(current)</span>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="home">Home
					<span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> Categories </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<c:forEach items="${listCategory}" var="o">
						<a class="dropdown-item ${tagCategory == o.id ? "active":""  }" href="product?cid=${o.id}&index=1">${o.name}</a>
					</c:forEach>
				</div></li>
			<li class="nav-item"><a class="nav-link"
				href="product?cid=0&index=1">Sản phẩm</a></li>
			<c:choose>
				<c:when test="${sessionScope.user == null }">
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/account/login">Đăng nhập</a></li>
				</c:when>
				<c:otherwise>

					<%-- <li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> My Account </a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item"
								href="${pageContext.request.contextPath}/account/information">My Account</a>
							<a class="dropdown-item" href="${pageContext.request.contextPath}/#">Đơn hàng</a>
						</div></li> --%>
					
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/account/orders">Đơn Hàng</a></li>
						
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/account/information">My Account</a></li>
						
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/logout">Đăng xuất</a></li>
					<li class="nav-item"><a class="nav-link"
						href="#">Hello ${sessionScope.user.fname} ${sessionScope.user.lname}</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
		<form action="search" class="form-inline my-2 my-lg-0">
			<div class="input-group input-group-sm">
				<input type="text" name="search" value="${searchValue}"
					class="form-control" placeholder="Tìm kiếm...">
				<div class="input-group-append">
					<button type="submit" class="btn btn-secondary btn-number">
						<i class="fa fa-search"></i>
					</button>
				</div>
			</div>
			<c:choose>
				<c:when test="${sessionScope.cart == null }">
					<a class="btn btn-success btn-sm ml-3" href="${pageContext.request.contextPath}/account/login">
						<i class="fa fa-shopping-cart"></i> Giỏ hàng <span
						class="badge badge-light">0</span>
					</a>
				</c:when>
				<c:otherwise>
					<a class="btn btn-success btn-sm ml-3" href="cart"> <i
						class="fa fa-shopping-cart"></i> Giỏ hàng <span
						class="badge badge-light">${sessionScope.cart.quantity }</span>
					</a>
				</c:otherwise>
			</c:choose>
		</form>
	</div>
</nav>

<section class="jumbotron text-center">
	<div class="container">
		<h1 class="jumbotron-heading">Sports shop E-commerce</h1>
		<p class="lead text-muted mb-0">Chúng tôi mang đến những sản phẩm đẹp cho bạn</p>
	</div>
</section>