<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="container">
	<div class="row">

		<%-- <!-- Fixed navbar start -->
			<%@include file="./shared/navbar_top.jsp"%>
		<!-- /.Fixed navbar  --> --%>

		<%-- <footer>
			<%@include file="./shared/footer.jsp"%>
		</footer> --%>



		<!-- to display the actual products -->
		<div class="col-md-9">

			<!-- Added breadcrumb component -->
			<%-- <div class="row">
				<div class="col-lg-12">
					<c:if test="${userClickAllProducts == true}">
						<script>
							window.categoryId = '';
						</script>
						<ol class="breadcrumb">
							<li><a href="<%=request.getContextPath()%>/demoList">Home</a></li>
							<li class="active">All Products</li>
						</ol>
					</c:if>

					<c:if test="${userClickCategoryProducts == true}">
						<script>
							window.categoryId = '${category.id}';
						</script>

						<ol class="breadcrumb">
							<li><a href="<%=request.getContextPath()%>/demoList">Home</a></li>
							<li class="active">Category</li>
							<li class="active">${category.name}</li>
						</ol>
					</c:if>
				</div>
			</div> --%>
			<div class="row">

				<div class="col-xs-12">
					<table id="productListTable"
						class="table table-striped table-borderd">

						<thead>
							<tr>
								<th></th>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Qty. Available</th>
								<th></th>

							</tr>
						</thead>
						<tfoot>
							<tr>
								<th></th>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Qty. Available</th>
								<th></th>

							</tr>
						</tfoot>
					</table>
				</div>
			</div>
			
		</div>
		<%-- <footer>
			<%@include file="./shared/footer.jsp"%>
		</footer> --%>
	</div>
</div>