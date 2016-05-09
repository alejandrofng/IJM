<%-- 
    Document   : listProveedores
    Created on : 28/04/2016, 08:24:18 AM
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
    <th  >RIF</th>
    <th  colspan='2' >Acciones</th>
</thead>
<tbody>
    <%

//            Aqui va el arraylist correspondiente con los objetos de tipo Proveedor ArrayList<Proveedor>
        ArrayList<String> proveedores = new ArrayList<String>(Arrays.asList("Prov1", "Prov2", "Prov3"));

    %>

    <%    for (String proveedor : proveedores) {%>
    <tr id='tr-categoria-id'>

        <td class='td-nombre-proveedor'><%=proveedor%></td>
        <td class='td-rif-proveedor'><%=proveedor%></td>
        <td class='td-accion' width='50' ><img src='resources/img/Editar.png' class='btn editar-proveedor img-editar'></td>
        <td class='td-accion' width='50'><img src='resources/img/Eliminar.png' class='btn eliminar-proveedor img-eliminar' ></td>
    </tr>
    <%
        }

    %>


</tbody>

<tfoot>
    <tr>
        <td colspan="3" class="text-center"><button id='btn-agregar-proveedor' class='btn btn-default'><img src='resources/img/Add.png' >Agregar</button></td>
    </tr>
</tfoot>
</table>
