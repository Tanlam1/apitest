<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="x-ua-compatible" content="ie=edge">

<title>Admin</title>

<!-- Font Awesome Icons -->
<link rel="stylesheet" href="/plugins/fontawesome-free/css/all.min.css">
<!-- overlayScrollbars -->
<link rel="stylesheet"
	href="/plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="/dist/css/adminlte.min.css">
<!-- Google Font: Source Sans Pro -->
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700"
	rel="stylesheet">
<link rel="stylesheet"
	href="/assets/fonts/fontawesome-free-6.1.1-web/css/all.min.css">
</head>
<body
	class="hold-transition sidebar-mini layout-fixed layout-navbar-fixed layout-footer-fixed">
	<div class="wrapper">
		<!-- Navbar -->
		<nav
			class="main-header navbar navbar-expand navbar-white navbar-light">
			<!-- Left navbar links -->
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" data-widget="pushmenu"
					href="#" role="button"><i class="fas fa-bars"></i></a></li>
				<li class="nav-item d-none d-sm-inline-block"><a
					href="/admin/sortaccount" class="nav-link">Sort</a></li>
				<li class="nav-item d-none d-sm-inline-block"><a
					href="/admin/pageaccount" class="nav-link">Page</a></li>
			</ul>

			<!-- SEARCH FORM -->
			<form class="form-inline ml-3">
				<div class="input-group input-group-sm">
					<input class="form-control form-control-navbar" type="search"
						placeholder="Search" aria-label="Search">
					<div class="input-group-append">
						<button class="btn btn-navbar" type="submit">
							<i class="fas fa-search"></i>
						</button>
					</div>
				</div>
			</form>

		</nav>
		<!-- /.navbar -->

		<!-- Main Sidebar Container -->
		<aside class="main-sidebar sidebar-dark-primary elevation-4">
			<!-- Brand Logo -->
			<a href="index3.html" class="brand-link"> <img
				src="/assets/img/AdminLTELogo.png" alt="AdminLTE Logo"
				class="brand-image img-circle elevation-3" style="opacity: .8">
				<span class="brand-text font-weight-light">Admin</span>
			</a>

			<!-- Sidebar -->
			<div class="sidebar">
				<!-- Sidebar user panel (optional) -->
				<div class="user-panel mt-3 pb-3 mb-3 d-flex">
					<div class="image">
						<img src="/assets/img/user2-160x160.jpg"
							class="img-circle elevation-2" alt="User Image">
					</div>
					<div class="info">
						<a href="#" class="d-block">Lam Nhut Tan</a>
					</div>
				</div>

				<!-- Sidebar Menu -->
				<nav class="mt-2">
					<ul class="nav nav-pills nav-sidebar flex-column"
						data-widget="treeview" role="menu" data-accordion="false">
						<!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
						<li class="nav-item"><a href="/admin/product"
							class="nav-link"> <i class="nav-icon fas fa-th"></i>
								<p>Bảng sản phẩm</p>
						</a></li>
						<li class="nav-item"><a href="/admin/order" class="nav-link">
								<i class="nav-icon fas fa-th"></i>
								<p>Bảng hóa đơn</p>
						</a></li>
						<li class="nav-item"><a href="/admin/orderdetail"
							class="nav-link"> <i class="nav-icon fas fa-th"></i>
								<p>Bảng chi tiết hóa đơn</p>
						</a></li>
						<li class="nav-item"><a href="/admin/account"
							class="nav-link"> <i class="nav-icon fas fa-th"></i>
								<p>Bảng tài khoản</p>
						</a></li>
						<li class="nav-item"><a href="/admin/category"
							class="nav-link"> <i class="nav-icon fas fa-th"></i>
								<p>Danh mục</p>
						</a></li>
					</ul>
					</li>
					</ul>
				</nav>
				<!-- /.sidebar-menu -->
			</div>
			<!-- /.sidebar -->
		</aside>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<div class="container col-12">
				<div class="col-6">
					<form:form action="/admin/account" modelAttribute="item">
						<form>
							<div class="row">
								<div class="col">
									<label for="exampleInputUsername">Username</label>
									<form:input type="text" class="form-control" path="username"/>
								</div>
								<div class="col">
									<label for="exampleInputPassword">Password</label>
									<form:input type="text" class="form-control" path="password"/>
								</div>
							</div>
						</form>
						<div class="form-group">
							<label for="exampleInputFullname">Fullname</label>
							<form:input type="text" class="form-control"
								id="exampleInputFullname" path="fullname"/>
						</div>
						<div class="form-group">
							<label for="exampleInputEmail">Email</label>
							<form:input type="email" class="form-control"
								id="exampleInputEmail" path="email"/>
						</div>
						<div class="form-group">
							<label for="exampleInputPhoto">Photo</label>
							<div class="custom-file">
								<form:input type="file" class="custom-file-input"
									id="inputGroupPhoto" path="photo" />
								<label class="custom-file-label" for="inputGroupPhoto">Choose
									file</label>
							</div>
						</div>
						<%-- <div class="form-group">
							<div class="form-check">
								<form:input class="form-check-input" type="checkbox"
									id="gridCheck" path="role" />
								<label class="form-check-label" for="gridCheck"> Admin </label>
							</div>
						</div> --%>
						<button type="submit" class="btn btn-primary" formaction="/admin/account/create">Thêm</button>
						<button type="submit" class="btn btn-danger" ><a href="/admin/account/delete/${item.username}">Xóa</a></button>
						<button type="submit" class="btn btn-success" formaction="/admin/account/update">Sửa</button>
					</form:form>
				</div>
				<hr>
				<table class="table col-8 m-auto">
					<thead>
						<tr>
							<th scope="col">Usernam</th>
							<th scope="col">Password</th>
							<th scope="col">Fullname</th>
							<th scope="col">Email</th>
							<th scope="col">Photo</th>
							<th scope="col">Role</th>
							<th scope="col">Activated</th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${items}">
							<tr>
								<td>${item.username}</td>
								<td>${item.password}</td>
								<td>${item.fullname}</td>
								<td>${item.email}</td>
								<td>${item.photo}</td>
								<td>${item.admin}</td>
								<td>${item.activated}</td>
								<td><a href="/admin/account/edit/${item.username}"><i
										class="fa-solid fa-pen-to-square"></i></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

	</div>
	<!-- ./wrapper -->

	<!-- REQUIRED SCRIPTS -->
	<!-- jQuery -->
	<script src="/plugins/jquery/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- overlayScrollbars -->
	<script
		src="/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
	<!-- AdminLTE App -->
	<script src="/dist/js/adminlte.js"></script>

	<!-- OPTIONAL SCRIPTS -->
	<script src="/dist/js/demo.js"></script>

	<!-- PAGE /plugins -->
	<!-- jQuery Mapael -->
	<script src="/plugins/jquery-mousewheel/jquery.mousewheel.js"></script>
	<script src="/plugins/raphael/raphael.min.js"></script>
	<script src="/plugins/jquery-mapael/jquery.mapael.min.js"></script>
	<script src="/plugins/jquery-mapael/maps/usa_states.min.js"></script>
	<!-- ChartJS -->
	<script src="/plugins/chart.js/Chart.min.js"></script>

	<!-- PAGE SCRIPTS -->
</body>
</html>
