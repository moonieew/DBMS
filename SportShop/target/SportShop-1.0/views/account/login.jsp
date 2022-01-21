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
					<div class="panel-heading">Please fill in your account to login</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-6">
								<h3>UserName: phu password: 123</h3>
								<h3>AdminName: admin password: 123</h3>
								<h4 class="text-danger">${mess }</h4>
								<form role="form" action="login" method="post">
									<div class="form-group">
										<label>User Name:</label> <input class="form-control"
											placeholder="please enter username" name="username" />
									</div>
									<div class="form-group">
										<label>Password</label> <input class="form-control"
											placeholder="please enter password" type="password"
											name="password" />
									</div>

									<button type="submit" class="btn btn-default">Login</button>
									<button type="reset" class="btn btn-primary">Reset</button>
									<h3>Don't have an account ?</h3>
									<a href = "${pageContext.request.contextPath }/account/register">
									<button type="button" class="btn btn-primary">Register</button></a>
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
