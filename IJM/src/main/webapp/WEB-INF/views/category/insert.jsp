<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page session="false" %>
<html>
<head>
	<title>IJM</title>
</head>
<body id="content">

<h1>
	Ingrese nueva Categoria
</h1>
<h1>${message}</h1>
<form:errors path="category.*"/>
	<c:if test="${not empty category}">
	<form action="/IJM/category/update/${category.id}" method="POST">
	   <input type="text" name="name" value="${category.name}"/>
	</c:if>
	<c:if test="${empty category}">
	<form action="/IJM/category/insert" method="POST">
	   <input type="text" name="name"/>
	</c:if>
	<select name="parent.id">
    	<c:forEach items="${categories}" var="category">	    
	        <option value="${category.id}"><c:out value="${category.name}"/></option>
		</c:forEach>
  </select>
  <input type="submit" value="Submit">
</form>
</body>
</html>