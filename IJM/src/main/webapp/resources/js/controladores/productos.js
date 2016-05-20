/* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var id_producto;
var imagen="";
function reloadPage()
{
	id_producto=null;
	imagen="";
    var loc = window.location;
    window.location = loc.protocol + '//' + loc.host + loc.pathname + loc.search;
}
function esNombreVacio()
{
	
	if($("#tbNombreProducto").val()!="")
		{
			return false
		}
	return true;
	
}
function esEdicionDeProducto()
{
	if(id_producto==null)
	{
		return false;
	}
return true;
}
function cargarProductoEnFormulario(data)
{
	$("#tbNombreProducto").val(data['name']);
	$("#tbCodigoProducto").val(data['code']);
	$("#tbDescripcionProducto").val(data['description']);
	$("#sCategoria").val(data['category']['id']);
}
function obtenerProducto(id)
{
	$.ajax({
	    method:'GET',
	    contentType: "application/json; charset=utf-8",
	    url:'product/'+id,
		}).done(function(data, textStatus, jqXHR) { 	
			cargarProductoEnFormulario(data);
		}).fail(function(jqXHR, textStatus, errorThrown) {
	    	});
}
function guardarProducto(Producto)
{
	$.ajax({
	    method:'POST',
	    data:JSON.stringify(Producto),
	    contentType: "application/json; charset=utf-8",
	    url:'product',
		}).done(function(data, textStatus, jqXHR) { 	
	   		 window.location.href = "productos";	
		}).fail(function(jqXHR, textStatus, errorThrown) {
	    	if(jqXHR.status==409)
	    		errorFormulario("Ya existe un Producto con ese nombre!");
	    	});
}
function actualizarProducto(Producto)
{
	$.ajax({
	    method:'PUT',
	    data:JSON.stringify(Producto),
	    contentType: "application/json; charset=utf-8",
	    url:'product/'+Producto['id'],
		}).done(function(data, textStatus, jqXHR) { 	
	   		 window.location.href = "productos";	
		}).fail(function(jqXHR, textStatus, errorThrown) {
	    	if(jqXHR.status==409)
	    		errorFormulario("Ya existe un Producto con ese nombre!");
	    	});
}
function borrarProducto(id)
{
	{
		$.ajax({
		    method:'DELETE',
		    url:'product/'+id,
		    success: function (rest) {
		    	console.log(rest);
		    	console.log("delete");
		    	window.location.href = "productos";
		    },
		    error: function(rest){
		    	console.log(rest);
		    }
		});
	}
}
$(document).ready(function () {

    var control = document.getElementById("fileImagen");
    control.addEventListener("change", function(event) {

        // When the control has changed, there are new files

        var i = 0;
        var	files = control.files;
        validate(files[0],
    		function (flag){
        		if(flag)
        			{
			            var reader = new FileReader();
			            reader.onload = function(e) {
			            	imagen = Base64.encode(e.target.result);
			            };
			           
			            reader.readAsText(files[0]);
        			}
        		else 
        			{
        				errorFormulario("Tipo de Archivo no aceptado!")
        				var $el = $('#fileImagen');
        				$el.wrap('<form>').closest('form').get(0).reset();
        				$el.unwrap();
        			}
        		});  
        

    }, false);
	    

    $("#btn-agregar-producto").click(function () {
        $('#modal-productos').modal('show');
        limpiarFormulario($('#form-producto'));

    });
    $(".editar-producto").click(function () {
        $('#modal-productos').modal('show');
        var parentTag = $( this ).closest("tr");
        id_producto = parentTag.data('id');
        obtenerProducto(id_producto);	
    });
    
    $("#btn-guardar-producto").click(function () {

    	if(esNombreVacio())
    	{
    		errorFormulario("Debe indicar un nombre para el Producto!");
    		return;
    	}
    	else if($("#sCategoria").val()=="" || $("#sCategoria").val()==null)
		{
    		errorFormulario("Seleccione una categoria para el Producto!");
    		return;
		}
    	else if(imagen=="")
		{
    		errorFormulario("Seleccione una imagen valida para el Producto!");
    		return;
		}
    	else
    	{
	    	var categoria = {"id":$("#sCategoria").val()}	;
	    	var image = {"file":imagen, "extension":control.files[0].type};
	    	var producto = {"id":id_producto,"description":$("#tbDescripcionProducto").val(),
	    			"price":$("#tbPrecioProducto").val(),"category":categoria,
	    			"unit":null,"code":$("#tbCodigoProducto").val(),
	    			"name":$("#tbNombreProducto").val(),"image":image};
				
	    	if(esEdicionDeProducto())
    		{	  
	    		actualizarProducto(producto);
    		}
	    	else
	    		guardarProducto(producto);
    	}
    });
    $(".eliminar-producto").click(function () {
        bootbox.confirm("Esta seguro que desea eliminar este producto?", function (result) {
            if (result) {
//                ok

            } else {
//                no

            }
        });

    });
});