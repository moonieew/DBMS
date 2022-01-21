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
					<div class="panel-heading">Add User</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-6">
								<h3>User:</h3>

								<form role="form" action="add" method="post">
									<div class="form-group">
										<label>User Name:</label> <input class="form-control"
											placeholder="please enter username" name="username"   />
									</div>
									<div class="form-group">
										<label>Password</label> <input class="form-control"
											placeholder="please enter password" type="password"
											name="password"   />
									</div>
									<div class="form-group">
										<label>First Name</label> <input class="form-control"
											placeholder="please enter fname" type="text" name="fname"
											  />
									</div>
									<div class="form-group">
										<label>Last Name</label> <input class="form-control"
											placeholder="please enter lname" type="text" name="lname"
											  />
									</div>
									<div class="form-group">
										<label>Gender</label> <br>
										<select name="gender" id="gender">
											<option value="0">Nam</option>
											<option value="1">Nữ</option>
										</select>
									</div>
									<div class="form-group">
										<label>Phone</label> <input class="form-control"
											placeholder="please enter phone" type="text" name="phone"
											  />
									</div>
									<div class="form-group">
										<label>Email</label> <input class="form-control"
											placeholder="Please enter email" type="text" name="email"   />
									</div>
									<div class="form-group">
										<label>Address</label> <input class="form-control"
											placeholder="please enter address" type="text"
											name="address"   />
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
