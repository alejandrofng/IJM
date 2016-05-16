<%-- 
    Document   : listCategorias
    Created on : 28/04/2016, 08:23:42 AM
    Author     : juan

--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<table id='tabla-categorias' class='table table-hover table-condensed table-striped table-bordered'>
    <thead>

    <th>Nombre</th>
    <th>Pertenece a</th>
    <th  colspan='2' >Acciones</th>
</thead>
<tbody>

    <c:forEach items="${categories}" var="category">
    <tr id='tr-categoria-id' data-id="${category.id}">

        <td class='td-nombre-categoria'>${category.name}</td>
        <td><c:out value="${category.parent.name}"/></td>
        <td class='td-accion' width='50' ><img src='resources/img/Editar.png' class='btn editar-categoria img-editar'></td>
        <td class='td-accion' width='50'><img src='resources/img/Eliminar.png' class='btn eliminar-categoria img-eliminar' ></td>
    </tr>
	</c:forEach>
</tbody>

<tfoot>
    <tr>
            </tr>
</tfoot>
</table>

