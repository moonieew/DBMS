<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url value="/templates/admin/static" var="url"></c:url>
<div id="page-wrapper">
	<div id="page-inner">
		<div class="row">
			<div class="col-md-12">
				<h2>All Product</h2>
				<h5>You can management product in here</h5>

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
										<th>ID</th>
										<th>Image</th>
										<th>Name</th>
										<th>Price</th>
										<th>SalePrice</th>
										<th>Quantity</th>
										<th>Description</th>
										<th>Action</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${getProductByPagging}" var="pro">
										<tr class="odd gradeX">
											<td>${pro.id }</td>
											<td><img height="150" width="150" src="${pro.image}" /></td>
											<td>${pro.name }</td>
											<td>${pro.price }</td>
											<td>${pro.salePrice }</td>
											<td>${pro.quantity }</td>
											<td>${pro.description }</td>
											<td><a
												href="<c:url value='/admin/product/edit?editId=${pro.id }'/>"
												class="center">Edit</a> | <a
												href="<c:url value='/admin/product/delete?deleteId=${pro.id }'/>"
												class="center">Delete</a></td>

										</tr>
									</c:forEach>


								</tbody>
							</table>
							<div aria-label="Page navigation example">
								<ul class="pagination">
									<li class="page-item ${tag <= 1 ? "disabled":"" }" "><a
										class="page-link" href="list?index=${tag-1 }">Previous</a></li>
									<c:forEach begin="1" end="${countPageProduct}" var="p">
										<li class="page-item ${tag == p ? "active":"" }" ><a
											class="page-link" href="list?index=${p}">${p}</a></li>
									</c:forEach>
									<li class="page-item ${tag >= countPageProduct ? "disabled":"" }" " ><a
										class="page-link" href="list?index=${tag+1 }">Next</a></li>
								</ul>
							</div>
						</div>

					</div>
				</div>
				<!--End Advanced Tables -->
			</div>
		</div>

	</div>

</div>

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
