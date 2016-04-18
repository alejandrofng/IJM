<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>IJM</title>
</head>
<body id="content">

<h1>
	Lista de Categorias
</h1>
<table>
<tr>
	<td>Nombre</td><td>Pertenece a</td><td>Edicion</td><td>Borrado</td>
</tr>
<c:forEach items="${categories}" var="category">
    <tr>
        <td><c:out value="${category.name}"/></td>
        <td><c:out value="${category.parent.name}"/></td>
        <td><form action="category/update/${category.id}"><input type="submit" class="button" value="Editar"/></form></td>
        <td><form action="category/delete/${category.id}" method="post"><input type="submit" class="button" value="Borrar"/></form></td>
    </tr>
</c:forEach>
</table>
</body>
</html>
