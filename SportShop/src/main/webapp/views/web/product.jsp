<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<div class="container">
	<div class="row">
		<div class="col-12 col-sm-3">
			<div class="card bg-light mb-3">
				<div class="card-header bg-primary text-white text-uppercase">
					<i class="fa fa-list"></i> Categories
				</div>
				<ul class="list-group category_block">
					<c:forEach items="${listCategory}" var="p">
						<li class="list-group-item text-white ${tagCategory == p.id ? "active":"" }"><a
							href="product?cid=${p.id}&index=1">${p.name}</a></li>
					</c:forEach>
				</ul>
			</div>
			<div class="card bg-light mb-3">
				<div class="card-header bg-success text-white text-uppercase">Best
					Product</div>
				<div class="card-body">
					<img class="img-fluid" src="${topProduct.image }" />
					<h5 class="card-title">${topProduct.name }</h5>
					<p class="card-text">${topProduct.description }</p>
					<p class="bloc_left_price">${topProduct.price - topProduct.salePrice}</p>
				</div>
			</div>
		</div>
		<div class="col">
			<div class="row">
				<c:forEach items="${listProduct}" var="p">
					<div class="col-12 col-md-6 col-lg-4">
						<div class="card">
							<img class="card-img-top" src="${p.image}" alt="Card image cap">
							<div class="card-body">
								<h4 class="card-title">
									<a href="productdetail?pid=${p.id}&cid=${p.categoryId}"
										title="View Product">${p.name}</a>
								</h4>
								<p class="card-text">${p.description}</p>
								<div class="row">
									<div class="col">
										<p class="btn btn-danger btn-block">${p.price-p.salePrice}</p>
									</div>
									<c:choose>
										<c:when test="${sessionScope.user == null }">
											<a href="${pageContext.request.contextPath}/account/login"
												class="btn btn-success btn-block"> Thêm vào giỏ </a>
										</c:when>
										<c:otherwise>

											<a
												href="<c:url value="/cart-add?pid=${p.id}&quantity=1"></c:url>"
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
	<c:choose>
		<c:when test="${tagCategory != null }">
			<div class="row">
				<div class="col-6"></div>
				<div class="col-6">
					<nav aria-label="...">
						<ul class="pagination">
							<li class="page-item ${tagIndex <= 1  ? "disabled":"" }" "><a
								class="page-link"
								href="product?cid=${tagCategory}&index=${tagIndex-1}"
								tabindex="-1">Previous</a></li>
							<c:forEach begin="1" end="${pageOfProduct}" var="o">
								<li class="page-item ${tagIndex==o ? "active":"" }"><a
									class="page-link" href="product?cid=${tagCategory}&index=${o}">${o}</a></li>
							</c:forEach>
							<li class="page-item ${tagIndex >= pageOfProduct ? "disabled":"" }""><a
								class="page-link"
								href="product?cid=${tagCategory}&index=${tagIndex+1}">Next</a></li>
						</ul>
					</nav>
				</div>
			</div>
		</c:when>
		<c:otherwise>
			<div class="row">
				<div class="col-6"></div>
				<div class="col-6">
					<nav aria-label="...">
						<ul class="pagination">
							<li class="page-item ${tagIndex <= 1  ? "disabled":"" }" "><a
								class="page-link"
								href="search?search=${searchValue}&index=${tagIndex-1}">Previous</a></li>
							<c:forEach begin="1" end="${pageOfProduct}" var="o">
								<li class="page-item ${tagIndex ==o ? "active":"" }"><a
									class="page-link"
									href="search?search=${searchValue}&index=${o}">${o}</a></li>
							</c:forEach>
							<li class="page-item ${tagIndex >= pageOfProduct ? "disabled":"" }""><a
								class="page-link"
								href="search?search=${searchValue}&index=${tagIndex+1}">Next</a></li>
						</ul>
					</nav>
				</div>
			</div>
		</c:otherwise>
	</c:choose>

</div>




