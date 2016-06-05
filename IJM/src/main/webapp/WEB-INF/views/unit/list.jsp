<%-- 
    Document   : listunidads
    Created on : 28/04/2016, 08:23:42 AM
    Author     : juan

--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<table id='tabla-unidads' class='table table-hover table-condensed table-striped table-bordered'>
    <thead>

    <th>Nombre</th>
    <th  colspan='2' >Acciones</th>
</thead>
<tbody>

    <c:forEach items="${units}" var="unit">
    <tr id='tr-unidad-id' data-id="${unit.id}">

        <td class='td-nombre-unidad'>${unit.name}</td>
        <td class='td-accion' width='50' ><img src='resources/img/Editar.png' class='btn editar-unidad img-editar'></td>
        <td class='td-accion' width='50'><img src='resources/img/Eliminar.png' class='btn eliminar-unidad img-eliminar' ></td>
    </tr>
	</c:forEach>
</tbody>

<tfoot>
    <tr>
            </tr>
</tfoot>
</table>

