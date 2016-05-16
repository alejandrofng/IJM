<%-- 
    Document   : listProductos
    Created on : 28/04/2016, 08:23:59 AM
    Author     : juan
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<table id='tabla-productos' class='table table-hover table-condensed table-striped table-bordered'>
    <thead>

    <th  >Codig</th>
    <th  >Nombre</th>
    <th  >Categoria</th>
    <th  >Precio</th>
    <th  >Imagen</th>
    <th  colspan='2' >Acciones</th>
</thead>
<tbody>

    <c:forEach items="${products}" var="product">
    <tr id='tr-producto-id' data-id="${product.id}">

        <td class='td-nombre-producto'>${product.code}</td>
        <td class='td-descripcion-producto'>${product.name}</td>
        <td class='td-categoria-producto'>${product.category.name}</td>
        <td class='td-precio-producto'>aun no agregado</td>
        <!--AQUI EL URL DE LA IMAGEN DEL PRODUCTO-->
        <td class='td-imagen-producto'><img height="80" src="resources/img/mprod.jpg"> </td>
        <td class='td-accion' width='50' ><img src='resources/img/Editar.png' class='btn editar-producto img-editar'></td>
        <td class='td-accion' width='50'><img src='resources/img/Eliminar.png' class='btn eliminar-producto img-eliminar' ></td>
    </tr>
	</c:forEach>

</tbody>

<tfoot>
    <tr>
        
    </tr>
</tfoot>
</table>
