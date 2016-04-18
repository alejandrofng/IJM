<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page session="false" %>
<html>
<head>
	<title>IJM</title>
</head>
<body id="content">

<h1>
	Ingrese nueva Unidad
</h1>
<h1>${message}</h1>
<form:errors path="category.*"/>
	<c:if test="${not empty unit}">
	<form action="/IJM/unit/update/${unit.id}" method="POST">
	   <input type="text" name="name" value="${unit.name}"/>
	</c:if>
	<c:if test="${empty unit}">
	<form action="/IJM/unit/insert" method="POST">
	   <input type="text" name="name"/>
	</c:if>
	<select name="parent.id">
    	<c:forEach items="${units}" var="category">	    
	        <option value="${unit.id}"><c:out value="${unit.name}"/></option>
		</c:forEach>
  </select>
  <input type="submit" value="Submit">
</form>
</body>
</html>