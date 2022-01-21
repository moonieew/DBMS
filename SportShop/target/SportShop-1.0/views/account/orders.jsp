<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url value="/templates/admin/static" var="url"></c:url>

<div id="page-wrapper">
	<div id="page-inner">
		<div class="row">
			<div class="col-md-12">
				<h2>Thông tin đơn hàng</h2>
			</div>
		</div>
		<!-- /. ROW  -->
		<hr />
		<div class="row">
			<div class="col-md-12">
				<!-- Form Elements -->
				<div class="panel panel-default">
					<div class="panel-heading">Thông tin cá nhân</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-6">
								<h4 class="text-danger">${mess }</h4>
								<form role="form" action="#" method="post">
									<div class="form-group">
										<label>Username : ${sessionScope.user.username}</label>

									</div>
									<div class="form-group">
										<label>Name : ${sessionScope.user.fname}
											${sessionScope.user.lname}</label>

									</div>
									<div class="form-group">
										<label>Phone : ${sessionScope.user.phone}</label>

									</div>
									<div class="form-group">
										<label>Email : ${sessionScope.user.email}</label>

									</div>
									<div class="form-group">
										<label>Address : ${sessionScope.user.address}</label>

									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
				<!-- End Form Elements -->

				<!-- Form Elements -->
				<c:forEach items="${listorderModel}" var="p">
					<div class="panel panel-default">
						<div class="panel-heading">Đơn hàng</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-md-6">
									<h4 class="text-danger">${mess }</h4>
									<form role="form" action="#" method="post">

										<div class="form-group">
											<label>ID đơn hàng: ${p.id }</label>
										</div>
										<c:choose>
											<c:when test="${p.status == 1 }">
												<div class="form-group">
													<label>Trạng thái: Chưa xác nhận</label>
												</div>
											</c:when>
											<c:when test="${p.status == 2 }">
												<div class="form-group">
													<label>Trạng thái: Đã xác nhận</label>
												</div>
											</c:when>
											<c:when test="${p.status == 3 }">
												<div class="form-group">
													<label>Trạng thái: Đang giao hàng</label>
												</div>
											</c:when>
											<c:when test="${p.status == 1 }">
												<div class="form-group">
													<label>Trạng thái: Đã giao thành công</label>
												</div>
											</c:when>
										</c:choose>

										<div class="form-group">
											<label>Ngày đặt hàng: ${p.createAt }</label>
										</div>
										<div class="form-group">
											<label>Ngày nhận: ${p.completedAt }</label>
										</div>
										<div class="form-group">
											<label>Tiền ship: ${p.shipping }đ</label>
										</div>
										<div class="form-group">
											<label>Tổng tiền hàng: ${p.total }đ</label>
										</div>
										<div class="form-group">
											<label>Tổng tiền: ${p.grandTotal }đ</label>
										</div>
									</form>
								</div>
							</div>

							<div class="table-responsive">
								<table class="table table-striped table-bordered table-hover"
									id="dataTables-example">
									<thead>
										<tr>
											<th>Image</th>
											<th>Name</th>
											<th>Price</th>
											<th>Quantity</th>
											<th>Total</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${p.listorderdetail}" var="pro">
											<tr class="odd gradeX">
												<td><img height="150" width="150"
													src="${pro.productmodel.image}" /></td>
												<td>${pro.productmodel.name }</td>
												<td>${pro.productmodel.price - pro.productmodel.salePrice }</td>
												<td>${pro.quantity }</td>
												<td>${pro.price }</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>


						</div>
					</div>
				</c:forEach>

				<!-- End Form Elements -->
			</div>
		</div>

	</div>
	<!-- /. PAGE INNER  -->
</div>
<!-- /. PAGE WRAPPER  -->

<!-- CUSTOM SCRIPTS -->
<script src="${url}/js/custom.js"></script>