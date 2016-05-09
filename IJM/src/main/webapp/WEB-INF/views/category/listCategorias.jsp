<%-- 
    Document   : listCategorias
    Created on : 28/04/2016, 08:23:42 AM
    Author     : juan

--%>

<%@page import="java.util.Arrays"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<table id='tabla-categorias' class='table table-hover table-condensed table-striped table-bordered'>
    <thead>

    <th  >Nombre</th>
    <th  colspan='2' >Acciones</th>
</thead>
<tbody>
    <%

//            Aqui va el arraylist correspondiente con los objetos de tipo Categoria ArrayList<Categoria>
        ArrayList<String> categorias = new ArrayList<String>(Arrays.asList("Cat1", "Cat2", "Cat3"));

    %>

    <%    for (String categoria : categorias) {%>
    <tr id='tr-categoria-id'>

        <td class='td-nombre-categoria'><%=categoria%></td>
        <td class='td-accion' width='50' ><img src='resources/img/Editar.png' class='btn editar-categoria img-editar'></td>
        <td class='td-accion' width='50'><img src='resources/img/Eliminar.png' class='btn eliminar-categoria img-eliminar' ></td>
    </tr>
    <%
        }

    %>


</tbody>

<tfoot>
    <tr>
        <td colspan="3" class="text-center"><button id='btn-agregar-categoria' class='btn btn-default'><img src='resources/img/Add.png' >Agregar</button></td>
    </tr>
</tfoot>
</table>
