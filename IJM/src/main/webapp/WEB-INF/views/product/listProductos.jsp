<%-- 
    Document   : listProductos
    Created on : 28/04/2016, 08:23:59 AM
    Author     : juan
--%>


<%@page import="java.util.Arrays"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<table id='tabla-productos' class='table table-hover table-condensed table-striped table-bordered'>
    <thead>

    <th  >Nombre</th>
    <th  >Descripcion</th>
    <th  >Categoria</th>
    <th  >Precio</th>
    <th  >Imagen</th>
    <th  colspan='2' >Acciones</th>
</thead>
<tbody>
    <%

//            Aqui va el arraylist correspondiente con los objetos de tipo Producto ArrayList<Producto>
        ArrayList<String> productos = new ArrayList<String>(Arrays.asList("Pro1", "pro2", "pro3"));

    %>

    <%    for (String producto : productos) {%>
    <tr id='tr-categoria-id'>

        <td class='td-nombre-producto'><%=producto%></td>
        <td class='td-descripcion-producto'><%=producto%></td>
        <td class='td-categoria-producto'><%=producto%></td>
        <td class='td-precio-producto'><%=producto%></td>
        <!--AQUI EL URL DE LA IMAGEN DEL PRODUCTO-->
        <td class='td-imagen-producto'><img height="80" src="resources/img/mprod.jpg"> </td>
        <td class='td-accion' width='50' ><img src='resources/img/Editar.png' class='btn editar-producto img-editar'></td>
        <td class='td-accion' width='50'><img src='resources/img/Eliminar.png' class='btn eliminar-producto img-eliminar' ></td>
    </tr>
    <%
        }

    %>


</tbody>

<tfoot>
    <tr>
        <td colspan="7" class="text-center"><button id='btn-agregar-producto' class='btn btn-default'><img src='resources/img/Add.png' >Agregar</button></td>
    </tr>
</tfoot>
</table>
