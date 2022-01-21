<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<div class="container">
	<div class="row">
		<div class="col">
			<div id="carouselExampleIndicators" class="carousel slide"
				data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-target="#carouselExampleIndicators" data-slide-to="0"
						class="active"></li>
					<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
					<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
				</ol>
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img class="d-block w-100"
							src="https://images.unsplash.com/photo-1613070120286-98b11cdb9ae2?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=870&q=80"
							alt="First slide">
					</div>
					<div class="carousel-item">
						<img class="d-block w-100"
							src="https://images.unsplash.com/photo-1489987707025-afc232f7ea0f?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=870&q=80"
							alt="Second slide">
					</div>
					<div class="carousel-item">
						<img class="d-block w-100"
							src="https://images.unsplash.com/photo-1538406641397-91f410ec4ec2?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=870&q=80"
							alt="Third slide">
					</div>
				</div>
				<a class="carousel-control-prev" href="#carouselExampleIndicators"
					role="button" data-slide="prev"> <span
					class="carousel-control-prev-icon" aria-hidden="true"></span> <span
					class="sr-only">Previous</span>
				</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
					role="button" data-slide="next"> <span
					class="carousel-control-next-icon" aria-hidden="true"></span> <span
					class="sr-only">Next</span>
				</a>
			</div>
		</div>
		<div class="col-12 col-md-3">
			<div class="card">
				<div class="card-header bg-success text-white text-uppercase">
					<i class="fa fa-heart"></i> Top product
				</div>
				<img class="img-fluid border-0" src="${topProduct.image}"
					alt="Card image cap">
				<div class="card-body">
					<h4 class="card-title text-center">
						<a href="productdetail?pid=${topProduct.id}&cid=${topProduct.categoryId}" title="View Product">${topProduct.name}</a>
					</h4>
					<div class="row">
						<div class="col">
							<p class="btn btn-danger btn-block">${topProduct.price}</p>
						</div>
						<div class="col">
							<a href="productdetail?pid=${topProduct.id}&cid=${topProduct.categoryId}"
								class="btn btn-success btn-block">View</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


<div class="container mt-3">
	<div class="row">
		<div class="col-sm">
			<div class="card">
				<div class="card-header bg-primary text-white text-uppercase">
					<i class="fa fa-star"></i> Best products
				</div>
				<div class="card-body">
					<div class="row">
						<c:forEach items="${list4product }" var="p">
							<div class="col-sm">
								<div class="card">
									<img class="card-img-top" src="${p.image }" alt="${p.name}">
									<div class="card-body">
										<h4 class="card-title">
											<a href="productdetail?pid=${p.id}&cid=${p.categoryId}"
												title="View Product">${p.name}</a>
										</h4>
										<p class="card-text">${p.description}</p>
										<div class="row">
											<div class="col">
												<p class="btn btn-danger btn-block">${p.price - p.salePrice}</p>
											</div>
											<c:choose>
												<c:when test="${sessionScope.user == null }">
													<a href="${pageContext.request.contextPath}/account/login"
													class="btn btn-success btn-block"> Thêm vào giỏ </a>
												</c:when>
												<c:otherwise>
													<a href="<c:url value="/cart-add?pid=${p.id}&quantity=1"></c:url>"
														class="btn btn-success btn-block"> Thêm vào giỏ </a>
												</c:otherwise>
											</c:choose>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>



