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
            <div class='col-md-4'><label for='cbUnidadProducto' class='control-label'>Unidad</label></div>
            <div class='col-md-8'>
                <select id='sUnidad' name="unit.id">
                	<option value="" ><c:out value="Seleccione una Unidad"/></option>
			    	<c:forEach items="${units}" var="unit">	    
				        <option value="${unit.id}"><c:out value="${unit.name}"/></option>
					</c:forEach>
			 	</select>
                <p id='cb-tbUnidadProducto' class='help-block'></p>
            </div>
        </div>
        <div class='row form-group'>
            <div class='col-md-4'><label for='tbPrecio_Regular_Producto' class='control-label'>Precio Regular</label></div>
            <div class='col-md-8'>
                <input id='tbPrecio_Regular_Producto' class='form-control' required='true'/>
                <p id='info-tbPrecio_Regular_Producto' class='help-block'></p>
            </div>
         <div class='row form-group'>
            <div class='col-md-4'><label for='tbPrecio_Descuento_Producto' class='control-label'>Precio con Descuento</label></div>
            <div class='col-md-8'>
                <input id='tbPrecio_Descuento_Producto' class='form-control' required='true'/>
                <p id='info-recio_Descuento_Producto' class='help-block'></p>
            </div>
        </div>
        <div id="fileDiv" class='row form-group'>
            <div class='col-md-4'><label for='fileImagen' class='control-label filestyle'>Imagen</label></div>
            <div class='col-md-8'>
                <input id='fileImagen' accept="image/*" class='filestyle form-control' name='imagen' type='file' required='true'  data-buttonText='Seleccionar Imagen' accept='image/*'/>
                <p id='info-tbfileImagen' class='help-block'></p>
            </div>
        </div>
		<label id="lbErrorForm"></label>
		
    </form >

</div>