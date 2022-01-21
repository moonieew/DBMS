<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/templates/admin/static" var="url"></c:url>
<nav class="navbar-default navbar-side" role="navigation">
	<div class="sidebar-collapse">
		<ul class="nav" id="main-menu">
			<li><a
				href="#"><i
					class="fa fa-desktop fa-3x"></i>Management</a>
				<ul class="nav nav-second-level">
					<li><a
						href="${pageContext.request.contextPath }/home">Home Page</a></li>
					<li><a
						href="${pageContext.request.contextPath }/product?cid=0">Product Page</a></li>
				</ul></li>
		</ul>
	</div>
</nav>