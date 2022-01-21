<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url value="/templates/admin/static" var="url"></c:url>

<div id="page-wrapper">
	<div id="page-inner">
		<div class="row">
			<div class="col-md-12">
				<h2>Edit User</h2>
				<h5>You can edit info user in here</h5>
			</div>
		</div>
		<!-- /. ROW  -->
		<hr />
		<div class="row">
			<div class="col-md-12">
				<!-- Form Elements -->
				<div class="panel panel-default">
					<div class="panel-heading">Add Category</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-6">
								<h3>User:</h3>

								<form role="form" action="add" method="post">
									<div class="form-group">
										<label>Category Name</label> <input class="form-control"
											placeholder="please enter categoryname" name="categoryname"   />
									</div>

									<button type="submit" class="btn btn-default">Add</button>
									<button type="reset" class="btn btn-primary">Reset</button>
								</form>


							</div>
						</div>
					</div>
				</div>
				<!-- End Form Elements -->
			</div>
		</div>
		<!-- /. ROW  -->
		<div class="row">
			<div class="col-md-12"></div>
		</div>
		<!-- /. ROW  -->
	</div>
	<!-- /. PAGE INNER  -->
</div>
<!-- /. PAGE WRAPPER  -->

<!-- CUSTOM SCRIPTS -->
<script src="${url}/js/custom.js"></script>
