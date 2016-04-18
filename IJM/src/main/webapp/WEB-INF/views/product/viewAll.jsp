<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>IJM</title>
</head>
<body id="content">

<h1>
	Lista de Productos
</h1>
<table>
<tr>
	<td>Nombre</td><td>Categoria</td><td>Edicion</td><td>Borrado</td>
</tr>
<c:forEach items="${products}" var="product">
    <tr>
        <td><c:out value="${product.name}"/></td>
        <td><c:out value="${product.category.name}"/></td>
        <td><form action="product/update/${product.code}"><input type="submit" class="button" value="Editar"/></form></td>
        <td><form action="product/delete/${product.code}" method="post"><input type="submit" class="button" value="Borrar"/></form></td>
    </tr>
</c:forEach>
<tr><td><form action="product/insert"><input type="submit" class="button" value="Agregar Nuevo Producto"/></form></td></tr>
</table>
</body>
</html>
