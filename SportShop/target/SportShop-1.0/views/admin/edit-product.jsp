<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url value="/templates/admin/static" var="url"></c:url>
<div id="page-wrapper">
	<div id="page-inner">
		<div class="row">
			<div class="col-md-12">
				<h2>Edit Product</h2>
			</div>
		</div>
		<!-- /. ROW  -->
		<hr />
		<div class="row">
			<div class="col-md-12">
				<!-- Form Elements -->
				<div class="panel panel-default">
					<div class="panel-heading">Edit Product</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-6">
								<h3>Info Product:</h3>

								<form role="form" action="edit" method="post">
									<div class="form-group">
										<label>ID</label> <input class="form-control" required
											placeholder="" name="productid" value = ${productid } >
									</div>
									<div class="form-group">
										<label>Name</label> <input class="form-control"
											placeholder="Nhập tên sản phẩm" name="name" />
									</div>
									<div class="form-group">
										<label>Price</label> <input class="form-control"
											placeholder="Nhập giá sản phẩm" type="number" name="price" />
									</div>
									<div class="form-group">
										<label>Sale Price</label> <input class="form-control" required
											placeholder="Nhập giá khuyến mãi" type="number" name="saleprice" >
									</div>
									<div class="form-group">
										<label>Quantity</label> <input class="form-control"
											placeholder="Nhập số lượng sản phẩm vào kho" type="number" name="quantity" />
									</div>
									<div class="form-group">
										<label>Description </label> <br>
										<textarea rows="4" cols="50" name="description" id="editer"></textarea>

									</div>

									<div class="form-group">
										<label>Category</label>
										<div class="checkbox">
											<select name="category">
												<c:forEach items="${categories}" var="c">
													<option value="${c.id}">${c.name}</option>
												</c:forEach>
											</select>
										</div>

									</div>
									<div class="form-group">
										<label>Brand</label>
										<div class="checkbox">
											<select name="brand">
												<c:forEach items="${brands}" var="c">
													<option value="${c.id}">${c.name}</option>
												</c:forEach>
											</select>
										</div>

									</div>
									<div class="form-group">
										<label>Image</label> <input type="text" name="image" />
									</div>
									<button type="submit" class="btn btn-default">Edit</button>
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
<!-- /. WRAPPER  -->

<!-- CUSTOM SCRIPTS -->
<script src="${url}/js/custom.js"></script>
<script type="text/javascript" language="javascript">
	CKEDITOR.replace('editer', {
		width : '700px',
		height : '300px'
	});
</script>