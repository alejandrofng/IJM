<%-- 
    Document   : viewGestionarProveedores
    Created on : 26/04/2016, 09:11:04 PM
    Author     : juan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script type="text/JavaScript" src="resources/js/lib/jquery-1.9.1.js"></script>
        <script type="text/JavaScript" src="resources/js/lib/bootstrap.js"></script>
        <script type="text/JavaScript" src="resources/js/lib/bootbox.js"></script>
        <script type="text/JavaScript" src="resources/js/controladores/general.js?v=1"></script>
        <script type="text/JavaScript" src="resources/js/controladores/proveedores.js?v=1.1"></script>
        <link href="resources/css/lib/bootstrap.min.css" rel="stylesheet">
        <link href="resources/css/estilos/general.css?v=1" rel="stylesheet">
    </head>
    <body>
        <%@include file="../menu.jsp" %>
        <div class='container'>
            <div class='row'>
                <div class='panel panel-default'>

                    <div class='panel-heading'>
                        Proveedores
                    </div>
                    <div class='panel-body'>
                        <div class="div-tab-categorias table-responsive">
                            <!--AQUI LA TABLA DE PROVEEDORES-->
                            <%@include file="listProveedores.jsp" %>
                        </div>

                    </div>

                </div>

            </div>

        </div>
        <!--modal-->
        <!--MODAL CON FORMULARIO DE PROVEEDORES-->
        <div class="modal fade" id="modal-proveedores" tabindex="-1" role="dialog" aria-labelledby="modalProveedoresLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="modalProveedoresLabel">Categoria</h4>
                    </div>
                    <div class="modal-body">
                        <%@include file="formProveedores.jsp" %>
                    </div>
                    <div class="modal-footer">
                        <button type="button" id='bProcesarCategoria' class="btn btn-primary">Guardar</button>
                        <button type="button" id='bCancelar' class="btn btn-default" data-dismiss="modal">Cancelar</button>

                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
