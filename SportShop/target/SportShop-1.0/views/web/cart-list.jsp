<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>


<div class="container mb-4">
	<div class="row">
		<div class="col-12">
			<div class="table-responsive">
				<table class="table table-striped">
					<thead>
						<tr>
							<th scope="col" class="text-left">Ảnh</th>
							<th scope="col" class="text-center">Tên sản phẩm</th>
							<th scope="col" class="text-center">Số lượng</th>
							<th scope="col" class="text-center">Giá gốc</th>
							<th scope="col" class="text-center">Giá khuyến mãi</th>
							<th scope="col" class="text-right">Giá tiền</th>
							<!-- <th> </th> -->
						</tr>
					</thead>
					<tbody>




						<c:forEach items="${sessionScope.cart.listcartdetail}" var="p">
							<tr>
								<c:url value="${p.productmodel.image}" var="imgUrl"></c:url>

								<td><img class="img-responsive" width="60px" height="60px"
									src="${imgUrl}" /></td>
								<td class="text-center">${p.productmodel.name }</td>
								<td class="text-center">${p.quantity }</td>
								<td class="text-center">${p.productmodel.price }</td>
								<td class="text-center text-danger">${p.productmodel.price - p.productmodel.salePrice }</td>
								<td class="text-right">${p.price } <a
									href="${pageContext.request.contextPath}/cart-remove?pid=${p.productid}"
									class="btn btn-sm btn-danger"><i class="fa fa-trash"></i> </a>
								</td>
							</tr>
						</c:forEach>

						<%-- <<tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td>Sub-Total</td>
                            <td class="text-right"><h4>Subtotal:</h4> <c:set var="total" value="${0}" /> 
                            <c:forEach items="${sessionScope.cart}" var="map">
								<c:set var="total" value="${total + map.value.quantity * map.value.product.price}" />
							</c:forEach>
											<div class="total-result-in">
												<span>$ ${total }</span>

											</div>
</td>
                        </tr> --%>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td>Shipping</td>
							<td class="text-right">${sessionScope.cart.shipping }</td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td><strong>Total</strong></td>
							<td class="text-right"><strong>${sessionScope.cart.grandTotal }</strong></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="col mb-2">
			<div class="row">
				<div class="col-sm-12  col-md-6">
					<%-- <button class="btn btn-block btn-lg btn-success btn-dark text-uppercase" href="${pageContext.request.contextPath}/home">Tiếp tục mua sắm</button> --%>
					<a class="btn btn-block btn-lg btn-success btn-dark text-uppercase"
						href="${pageContext.request.contextPath}/product?cid=0&index=1"
						role="button">Tiếp tục mua sắm</a>
				</div>
				<c:choose>
					<c:when test="${sessionScope.user == null }">
						<div class="col-sm-12 col-md-6 text-right">
							<button class="btn btn-lg btn-block btn-success text-uppercase">Thanh toán</button>
						</div>
					</c:when>
					<c:otherwise>
						<div class="col-sm-12 col-md-6 text-right">
							<a href="${pageContext.request.contextPath}/order-add" 
							class="btn btn-lg btn-block btn-success text-uppercase">Thanh toán</a>
						</div>
					</c:otherwise>
				</c:choose>
				

			</div>
		</div>
	</div>
</div>

