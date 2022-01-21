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
								<a
									href="${pageContext.request.contextPath }/account/information">
									<button type="button" class="btn btn-primary">Information</button>
								</a> <a
									href="${pageContext.request.contextPath }/account/changepassword">
									<button type="button" class="btn btn-primary">Change
										Password</button>
								</a>
								<h3>Information</h3>
								<h4 class="text-danger">${mess }</h4>

								<form role="form" action="changeinfor" method="post">

									<div class="form-group">
										<label>First Name</label> <input class="form-control"
											placeholder="please enter first name" type="text"
											name="fname" />
									</div>
									<div class="form-group">
										<label>Last Name</label> <input class="form-control"
											placeholder="please enter last name" type="text"
											name="lname" />
									</div>
									<div class="form-group">
										<label>Phone</label> <input
											class="form-control" placeholder="please enter phone"
											type="text" name="phone" />
									</div>
									<div class="form-group">
										<label>Email</label> <input
											class="form-control" placeholder="please enter email"
											type="text" name="email" />
									</div>
									<div class="form-group">
										<label>Address</label> <input
											class="form-control" placeholder="please enter address"
											type="text" name="address" />
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
