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
		<label for="code">Codigo</label>
	   	<input id="code" type="text" name="code" value="${product.code}"/>
	  	<label for="name">Nombre</label>
	   	<input id="name" type="text" name="name" value="${product.name}"/>
	   	<label for="description">Descripcion</label>
	   	<input id="description" type="text" name="description" value="${product.description}"/>
	</c:if>
	<c:if test="${empty product}">
	<form action="/IJM/product/insert" method="POST">
		<label for="code">Codigo</label>
	   	<input id="code" type="text" name="code"/>
	   	<label for="name">Nombre</label>
	  	<input id="name" type="text" name="name"/>
	  		   	<label for="description">Descripcion</label>
	   	<input id="description" type="text" name="description"/>
	</c:if>
	<select name="category.id">
    	<c:forEach items="${categories}" var="category">	    
	        <option value="${category.id}"><c:out value="${category.name}"/></option>
		</c:forEach>
  </select>
  	<select name="unit.id">
    	<c:forEach items="${units}" var="unit">	    
	        <option value="${unit.id}"><c:out value="${unit.name}"/></option>
		</c:forEach>
  </select>
  <input type="submit" value="Submit">
</form>
</body>
</html>