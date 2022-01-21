<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url value="/templates/admin/static" var="url"></c:url>
<div id="page-wrapper">
	<div id="page-inner">
		<div class="row">
			<div class="col-md-12">
				<h2>List User</h2>
				<h5>You can edit , add, delete User</h5>

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
										<th>User Name</th>
										<th>Password</th>
										<th>First Name</th>
										<th>Last Name</th>
										<th>Gender</th>
										<th>Phone</th>
										<th>Email</th>
										<th>Address</th>
										<th class="center">Role</th>
										<th class="center">Action</th>

									</tr>
								</thead>
								<tbody>
									<c:forEach items="${getUserByPagging}" var="list">
										<tr class="odd gradeX">
											<td>${list.id }</td>
											<td>${list.username }</td>
											<td>${list.password }</td>
											<td>${list.fname }</td>
											<td>${list.lname }</td>
											<td><c:choose>
													<c:when test="${list.gender == 0 }">
													Nam</c:when>
													<c:otherwise>Nữ</c:otherwise>
												</c:choose></td></td>
											<td>${list.phone }</td>
											<td>${list.email }</td>
											<td>${list.address }</td>

											<td class="center"><c:choose>
													<c:when test="${list.roleId == 1 }">
													Admin
													</c:when>
													<c:otherwise>Client</c:otherwise>
												</c:choose></td>
											<td><a
												href="<c:url value='/admin/user/delete?deleteId=${list.id }'/>"
												class="center">Delete</a></td>

										</tr>
									</c:forEach>

								</tbody>

							</table>
							<div aria-label="Page navigation example">
								<ul class="pagination">
									<li class="page-item ${tag <= 1 ? "disabled":"" }" "><a class="page-link"
										href="list?index=${tag-1 }">Previous</a></li>
									<c:forEach begin="1" end="${countPageUser}" var="p">
										<li class="page-item ${tag == p ? "active":"" }" ><a
											class="page-link" href="list?index=${p}">${p}</a></li>
									</c:forEach>
									<li class="page-item ${tag >= countPageUser ? "disabled":"" }" " ><a class="page-link"
										href="list?index=${tag+1 }">Next</a></li>
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
<!-- /. PAGE INNER  -->

<!-- /. PAGE WRAPPER  -->
<!-- /. WRAPPER  -->
<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->

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
