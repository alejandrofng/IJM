<%-- 
    Document   : formunidads
    Created on : 28/04/2016, 08:30:09 AM
    Author     : juan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id='div-datos-unidad' class='well'  >
    <form id="form-unidad" action="/IJM/unit/insert" method="POST">
        <div class='row form-group'>
            <div class='col-md-4'><label for='tbNombreUnidad' class='control-label'>Nombre</label></div>
            <div class='col-md-8'>
                <input id='tbNombreUnidad' class='form-control' required='true' type="text" name="name"/>
                <p id='info-tbNombreUnidad' class='help-block'></p>
			 	<label id="lbErrorForm"></label>
            </div>
        </div>
	</form>
</div>