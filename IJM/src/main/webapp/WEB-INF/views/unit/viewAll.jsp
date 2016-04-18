<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>IJM</title>
</head>
<body id="content">

<h1>
	Lista de Unidades
</h1>
<table>
<tr>
	<td>Nombre</td><td>Edicion</td><td>Borrado</td>
</tr>
<c:forEach items="${units}" var="unit">
    <tr>
        <td><c:out value="${unit.name}"/></td>
        <td><form action="unit/update/${unit.id}"><input type="submit" class="button" value="Editar"/></form></td>
        <td><form action="unit/delete/${unit.id}" method="post"><input type="submit" class="button" value="Borrar"/></form></td>
    </tr>
</c:forEach>
<tr><td col="3"><form action="unit/insert"><input type="submit" class="button" value="Agregar Nueva Unidad"/></form></td></tr>
</table>
</body>
</html>
