<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page session="false" %>
<html>
<head>
	<title>IJM</title>
</head>
<body id="content">

<h1>
	Ingrese nuevo Producto
</h1>
<h1>${message}</h1>
<form:errors path="product.*"/>
	<c:if test="${not empty product}">
	<form action="/IJM/product/update/${product.code}" method="POST">
	   <input type="text" name="name" value="${product.name}"/>
	</c:if>
	<c:if test="${empty product}">
	<form action="/IJM/product/insert" method="POST">
	   <input type="text" name="name"/>
	</c:if>
	<select name="product.category.id">
    	<c:forEach items="${categories}" var="category">	    
	        <option value="${category.id}"><c:out value="${category.name}"/></option>
		</c:forEach>
  </select>
  	<select name="product.unit.id">
    	<c:forEach items="${units}" var="unit">	    
	        <option value="${unit.id}"><c:out value="${unit.name}"/></option>
		</c:forEach>
  </select>
  <input type="submit" value="Submit">
</form>
</body>
</html>