<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url value="/templates/admin/static" var="url"></c:url>

<div id="page-wrapper">
	<div id="page-inner">
		<div class="row">
			<div class="col-md-12">
				<h2>Order Management</h2>


			</div>
		</div>
		<!-- /. ROW  -->
		<hr />

		<div class="row">
			<div class="col-md-12">
				<!-- Advanced Tables -->
				<div class="panel panel-default">
					<div class="panel-heading">Advanced Tables</div>
					<div class="panel-body">
						<div class="table-responsive">
							<table class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<thead>
									<tr>
										<th>index</th>
										<th>ID</th>
										<th>Buyer</th>
										<th>Email</th>
										<th>Date</th>
										<th>Product</th>
										<th>Quantity</th>
										<th>Price</th>
										<th>Sum</th>
										<th>Action</th>


									</tr>
								</thead>
								<tbody>
									<c:set var="index" value="${0}" />
									<c:forEach items="${listCartItem }" var="list">
										<tr class="odd gradeX">
											<c:set var="index" value="${index + 1}" />
											<td>${index }</td>
											<td>${list.id }</td>
											<td>${list.cart.buyer.username }</td>
											<td>${list.cart.buyer.email }</td>
											<td>${list.cart.buyDate }</td>
											<td>${list.product.name }</td>
											<td>${list.quantity }</td>
											<td>$ ${list.product.price }</td>
											<td>$ ${ list.quantity * list.product.price }</td>


											<td><a
												href="<c:url value='/admin/order/delete?id=${list.id }'/>"
												class="center">Delete</a></td>

										</tr>
									</c:forEach>

								</tbody>
							</table>
						</div>

					</div>
				</div>
				<!--End Advanced Tables -->
			</div>
		</div>

	</div>

</div>
<!-- /. PAGE INNER  -->
<!-- DATA TABLE SCRIPTS -->
<script src="${url}/js/dataTables/jquery.dataTables.js"></script>
<script src="${url}/js/dataTables/dataTables.bootstrap.js"></script>
<script>
	$(document).ready(function() {
		$('#dataTables-example').dataTable();
	});
</script>
<!-- CUSTOM SCRIPTS -->
<script src="${url}/js/custom.js"></script>

</body>
</html>