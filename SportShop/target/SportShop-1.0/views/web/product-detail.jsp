<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<div class="container">
	<div class="row">
		<!-- Image -->
		<div class="col-12 col-lg-6">
			<div class="card bg-light mb-3">
				<div class="card-body">
					<a href="" data-toggle="modal" data-target="#productModal"> <img
						class="img-fluid" src="${ProductByID.image}" />
						<p class="text-center">Zoom</p>
					</a>
				</div>
			</div>
		</div>

		<!-- Add to cart -->
		<div class="col-12 col-lg-6 add_to_cart_block">
			<div class="card bg-light mb-3">
				<div class="card-body">
					<h2>${ProductByID.name}</h2>
					<c:forEach items="${listCategory}" var="ca">
						<c:if test="${ProductByID.categoryId == ca.id}">
							<h2>${ca.name}</h2>
						</c:if>
					</c:forEach>
					<p class="price">${ProductByID.price}</p>
					<form method="get" action="cart-add?pId=${ProductByID.id}">
						<div class="form-group">
							<label>Số lượng :</label>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<button type="button"
										class="quantity-left-minus btn btn-danger btn-number"
										data-type="minus" data-field="">
										<i class="fa fa-minus"></i>
									</button>
								</div> 
								<input type="hidden"  name="pid" value="${ProductByID.id }">
								<input type="text" class="form-control" id="quantity"
									name="quantity" min="1" max="100" value="1"> 
								
								<div class="input-group-append">
									<button type="button"
										class="quantity-right-plus btn btn-success btn-number"
										data-type="plus" data-field="">
										<i class="fa fa-plus"></i>
									</button>
								</div> 
							</div>
						</div>
						<c:choose>
							<c:when test="${sessionScope.user == null }">
								<a class="btn btn-success btn-block"> Thêm vào giỏ </a>
							</c:when>
							<c:otherwise>
								<input type="submit" value="Thêm vào giỏ hàng" class="btn btn-success btn-lg btn-block text-uppercase">
								<%-- <a href="<c:url value="cart-add?pid=${ProductByID.id}&quantity=${quantity}"></c:url>"
									class="btn btn-success btn-lg btn-block text-uppercase"> <i
									class="fa fa-shopping-cart"></i> Thêm vào giỏ hàng
								</a> --%>
							</c:otherwise>
						</c:choose>
					</form>
					<div class="product_rassurance">
						<ul class="list-inline">
							<li class="list-inline-item"><i class="fa fa-truck fa-2x"></i><br />Fast
								delivery</li>
							<li class="list-inline-item"><i
								class="fa fa-credit-card fa-2x"></i><br />Secure payment</li>
							<li class="list-inline-item"><i class="fa fa-phone fa-2x"></i><br />+33
								1 22 54 65 60</li>
						</ul>
					</div>
					<div class="reviews_product p-3 mb-2 ">
						3 reviews <i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
							class="fa fa-star"></i> <i class="fa fa-star"></i> <i
							class="fa fa-star"></i> (4/5) <a class="pull-right"
							href="#reviews">View all reviews</a>
					</div>
					<div class="datasheet p-3 mb-2 bg-info text-white">
						<a href="" class="text-white"><i class="fa fa-file-text"></i>
							Download DataSheet</a>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="row">
		<!-- Description -->
		<div class="col-12">
			<div class="card border-light mb-3">
				<div class="card-header bg-primary text-white text-uppercase">
					<i class="fa fa-align-justify"></i> Description
				</div>
				<div class="card-body">
					<p class="card-text">${ProductByID.description}</p>
				</div>
			</div>
		</div>

		<!-- Reviews -->
		<div class="col-12" id="reviews">
			<div class="card border-light mb-3">
				<div class="card-header bg-primary text-white text-uppercase">
					<i class="fa fa-comment"></i> Reviews
				</div>
				<div class="card-body">
					<div class="review">
						<span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
						<meta itemprop="datePublished" content="01-01-2016">
						January 01, 2018 <span class="fa fa-star"></span> <span
							class="fa fa-star"></span> <span class="fa fa-star"></span> <span
							class="fa fa-star"></span> <span class="fa fa-star"></span> by
						Paul Smith
						<p class="blockquote">
						<p class="mb-0">Lorem ipsum dolor sit amet, consectetur
							adipiscing elit. Integer posuere erat a ante.</p>

						<hr>
					</div>
					<div class="review">
						<span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
						<meta itemprop="datePublished" content="01-01-2016">
						January 01, 2018 <span class="fa fa-star" aria-hidden="true"></span>
						<span class="fa fa-star" aria-hidden="true"></span> <span
							class="fa fa-star" aria-hidden="true"></span> <span
							class="fa fa-star" aria-hidden="true"></span> <span
							class="fa fa-star" aria-hidden="true"></span> by Paul Smith
						<p class="blockquote">
						<p class="mb-0">Lorem ipsum dolor sit amet, consectetur
							adipiscing elit. Integer posuere erat a ante.</p>

						<hr>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script src="//code.jquery.com/jquery-3.2.1.slim.min.js"
	type="text/javascript"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	type="text/javascript"></script>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	type="text/javascript"></script>
<script type="text/javascript">
	//Plus & Minus for Quantity product
	$(document).ready(function() {
		var quantity = 1;

		$('.quantity-right-plus').click(function(e) {
			e.preventDefault();
			var quantity = parseInt($('#quantity').val());
			$('#quantity').val(quantity + 1);
		});

		$('.quantity-left-minus').click(function(e) {
			e.preventDefault();
			var quantity = parseInt($('#quantity').val());
			if (quantity > 1) {
				$('#quantity').val(quantity - 1);
			}
		});

	});
</script>
