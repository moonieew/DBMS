<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url value="/templates/admin/static" var="url"></c:url>

<div id="page-wrapper">
	<div id="page-inner">
		<div class="row">
			<div class="col-md-12">
				<h2>Login</h2>
			</div>
		</div>
		<!-- /. ROW  -->
		<hr />
		<div class="row">
			<div class="col-md-12">
				<!-- Form Elements -->
				<div class="panel panel-default">
					<div class="panel-heading">Change password</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-6">
								<h3>Password</h3>
								<h4 class="text-danger">${mess }</h4>

								<form role="form" action="changepassword" method="post">

									<div class="form-group">
										<label>Old Password</label> <input class="form-control"
											placeholder="please enter password" type="password"
											name="oldpassword" />
									</div>
									<div class="form-group">
										<label>New Password</label> <input class="form-control"
											placeholder="please enter password" type="password"
											name="newpassword" />
									</div>
									<div class="form-group">
										<label>Confirm New Password</label> <input
											class="form-control" placeholder="please enter password"
											type="password" name="confirmnewpassword" />
									</div>

									<button type="submit" class="btn btn-default">Submit</button>
									<button type="reset" class="btn btn-primary">Reset</button>
								</form>


							</div>
						</div>
					</div>
				</div>
				<!-- End Form Elements -->
			</div>
		</div>

	</div>
	<!-- /. PAGE INNER  -->
</div>
<!-- /. PAGE WRAPPER  -->

<!-- CUSTOM SCRIPTS -->
<script src="${url}/js/custom.js"></script>
