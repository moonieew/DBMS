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
					<div class="panel-heading">Welcome to you</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-6">
								<a
									href="${pageContext.request.contextPath }/account/changepassword">
									<button type="button" class="btn btn-primary">Change
										Password</button>
								</a> <a
									href="${pageContext.request.contextPath }/account/changeinfor">
									<button type="button" class="btn btn-primary">Change
										Information</button>
								</a>
								<h3>Information</h3>
								<h4 class="text-danger">${mess }</h4>
								<form role="form" action="#" method="post">
									<div class="form-group">
										<label>Username :	${sessionScope.user.username}</label>
					
									</div>
									<div class="form-group">
										<label>Name :	${sessionScope.user.fname} ${sessionScope.user.lname}</label>
										
									</div>
									<div class="form-group">
										<label>Phone :	${sessionScope.user.phone}</label>
										
									</div>
									<div class="form-group">
										<label>Email :	${sessionScope.user.email}</label>
										
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
			</div>
		</div>

	</div>
	<!-- /. PAGE INNER  -->
</div>
<!-- /. PAGE WRAPPER  -->

<!-- CUSTOM SCRIPTS -->
<script src="${url}/js/custom.js"></script>
