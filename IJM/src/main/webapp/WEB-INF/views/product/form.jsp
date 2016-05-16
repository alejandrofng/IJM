<%-- 
    Document   : formProductos
    Created on : 28/04/2016, 08:30:18 AM
    Author     : juan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id='div-datos-producto' class='well' >
    <form id="form-producto">
        <div class='row form-group'>
        	<div class='col-md-4'><label for='tbCodigoProducto' class='control-label'>Codigo</label></div>
            <div class='col-md-8'>
                <input id='tbCodigoProducto' class='form-control' required='true'/>
                <p id='info-tbNombreProducto' class='help-block'></p>
            </div>
            <div class='col-md-4'><label for='tbNombreProducto' class='control-label'>Nombre</label></div>
            <div class='col-md-8'>
                <input id='tbNombreProducto' class='form-control' required='true'/>
                <p id='info-tbNombreProducto' class='help-block'></p>
            </div>
        </div>
        <div class='row form-group'>
            <div class='col-md-4'><label for='tbDescripcionProducto' class='control-label'>Descripcion</label></div>
            <div class='col-md-8'>
                <input id='tbDescripcionProducto' class='form-control' required='true'/>
                <p id='info-tbDescripcionProducto' class='help-block'></p>
            </div>
        </div>

        <div class='row form-group'>
            <div class='col-md-4'><label for='cbCategoriaProducto' class='control-label'>Categoria</label></div>
            <div class='col-md-8'>
                <select id='sCategoria' name="category.id">
                	<option value="" ><c:out value="Seleccione una Categoria"/></option>
			    	<c:forEach items="${categories}" var="category">	    
				        <option value="${category.id}"><c:out value="${category.name}"/></option>
					</c:forEach>
			 	</select>
                <p id='cb-tbCategoriaProducto' class='help-block'></p>
            </div>
        </div>
        <div class='row form-group'>
            <div class='col-md-4'><label for='tbPrecioProducto' class='control-label'>Precio</label></div>
            <div class='col-md-8'>
                <input id='tbPrecioProducto' class='form-control' required='true'/>
                <p id='info-tbPrecioProducto' class='help-block'></p>
            </div>
        </div>

        <div class='row form-group'>
            <div class='col-md-4'><label for='fileImagen' class='control-label filestyle'>Imagen</label></div>
            <div class='col-md-8'>
                <input id='fileImagen' class='filestyle form-control' name='imagen' type='file' required='true'  data-buttonText='Seleccionar Imagen' accept='image/*'/>
                <p id='info-tbPrecioProducto' class='help-block'></p>
            </div>
        </div>
		<label id="lbErrorForm"></label>


    </form >

</div>