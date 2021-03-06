<%-- 
    Document   : viewGestionarCategorias
    Created on : 26/04/2016, 09:09:35 PM
    Author     : juan
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script type="text/JavaScript" src="resources/js/lib/jquery-2.1.1.min.js"></script>
        <script type="text/JavaScript" src="resources/js/lib/bootstrap.js"></script>
        <script type="text/JavaScript" src="resources/js/lib/bootbox.js"></script>
        <script type="text/JavaScript" src="resources/js/controladores/general.js?v=1"></script>
        <script type="text/JavaScript" src="resources/js/controladores/categorias.js?v=1"></script>
        <link href="resources/css/lib/bootstrap.min.css" rel="stylesheet">
        <link href="resources/css/estilos/general.css?v=1" rel="stylesheet">
    </head>
    <body>
        <%@include file="../menu.jsp" %>
        <div class='container'>
            <div class='row'>
                <div class='panel panel-default'>

                    <div class='panel-heading'>
                        Categorias
                    </div>
                    <div class='panel-body'>
                        <!--AQUI LA TABLA DE CATEGORIAS-->
                        <div class="div-tab-categorias table-responsive">
                            <%@include file="list.jsp" %>
                        </div>
						<div>
							<div colspan="3" class="text-center"><button id='btn-agregar-categoria' class='btn btn-default'><img src='resources/img/Add.png' >Agregar</button></div>		
						</div>
                    </div>

                </div>

            </div>

        </div>
        <!--modal-->
        <!--AQUI EL MODAL CON EL FORMULARIO DE CATEGORIAS-->
        <div class="modal fade" id="modal-categorias" tabindex="-1" role="dialog" aria-labelledby="modalCategoriasLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button id="btn-cerrar-formulario" type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="modalCategoriasLabel">Categoria</h4>
                    </div>
                    <div class="modal-body">
                    
                        <%@include file="form.jsp" %>
                    </div>
                    <div class="modal-footer">
                        <button type="button" id='btn-guardar-categoria' class="btn btn-primary">Guardar</button>
                        <button type="button" id='bCancelar' class="btn btn-default" data-dismiss="modal">Cancelar</button>
						
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>