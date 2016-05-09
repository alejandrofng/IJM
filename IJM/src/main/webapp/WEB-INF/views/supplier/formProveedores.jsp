<%-- 
    Document   : formProveedores
    Created on : 28/04/2016, 08:30:28 AM
    Author     : juan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id='div-datos-proveedor' class='well' >
    <form id="form-proveedor">
        <div class='row form-group'>
            <div class='col-md-4'><label for='tbNombreProveedor' class='control-label'>Nombre</label></div>
            <div class='col-md-8'>
                <input id='tbNombreProveedor' class='form-control' required='true'/>
                <p id='info-tbNombreProveedor' class='help-block'></p>
            </div>
        </div>

        <div class='row form-group'>
            <div class='col-md-4'><label for='tbRifProveedor' class='control-label'>RIF</label></div>
            <div class='col-md-8'>
                <input id='tbRifProveedor' class='form-control' required='true'/>
                <p id='info-tbRifProveedor' class='help-block'></p>
            </div>
        </div>

    </form >

</div>