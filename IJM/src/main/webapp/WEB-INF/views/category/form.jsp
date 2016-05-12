<%-- 
    Document   : formCategorias
    Created on : 28/04/2016, 08:30:09 AM
    Author     : juan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id='div-datos-categoria' class='well'  >
    <form id="form-categoria" action="/IJM/category/insert" method="POST">
        <div class='row form-group'>
            <div class='col-md-4'><label for='tbNombreCategoria' class='control-label'>Nombre</label></div>
            <div class='col-md-8'>
                <input id='tbNombreCategoria' class='form-control' required='true' type="text" name="name"/>
                <p id='info-tbNombreCategoria' class='help-block'></p>
                <select id='sCategoriaPadre' name="parent.id">
                	<option value="" ><c:out value="Seleccione una categoria Padre"/></option>
			    	<c:forEach items="${categories}" var="category">	    
				        <option value="${category.id}"><c:out value="${category.name}"/></option>
					</c:forEach>
			 	</select>
			 	<label id="lbErrorForm"></label>
            </div>
        </div>
	</form>
</div>