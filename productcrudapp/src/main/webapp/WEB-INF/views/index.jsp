<html>
<head>
<%@include file="./base.jsp" %><!-- //include base wali page -->
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
</head>
<body>

	<div class="container mt-3">
		<div class="row">
			<div class="col-md-12">
			<h1 class="text-center mb-3">Welcome to Product App</h1>
			<table class="table">
			  <thead class="thead-dark">
			    <tr>
			      <th scope="col">ID</th>
			      <th scope="col">Product Name</th>
			      <th scope="col">Product Description</th>
			      <th scope="col">Price</th>
			      <th scope="col">Action</th>
			    </tr>
			  </thead>
			  <tbody>
			  <c:forEach items="${products }" var="p">
			    <tr>
			      <th scope="row">TECHONLY${p.id}</th>
			      <td>${p.name }</td>
			      <td>${p.discription }</td>
			      <td class="font-weight-bold ">&#x20B9; ${p.price }</td>
			      <td>
			      <a href="delete/${p.id }"><i class="fa-solid fa-trash text-danger " style="font-size:30px"></i>
			      </a>
			      </td>
			    </tr>
			   </c:forEach>
			  </tbody>
			</table>
			<div class="container text-center">
			<a href="addProduct"  class="btn btn-outline-success">ADD Product</a>
			</div>
			</div>
		
		</div>
	
	</div>

</body>
</html>
