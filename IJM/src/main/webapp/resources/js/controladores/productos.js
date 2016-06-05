/* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var id_producto;
var hasImage = false;
var imagen="";
var image = {"id":null,"checksum":null,"file":null, "extension":null,"size":null,"file_name":null};
function reloadPage()
{
	id_producto=null;
	imagen="";
	image = {"id":null,"checksum":null,"file":null, "extension":null,"size":null,"file_name":null};
	hasImage = false;
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
	
	$("#tbPrecio_Regular_Producto").val(data['price_regular']);
	$("#tbPrecio_Descuento_Producto").val(data['price_discount']);
	if(data['images'][0]!=null)
		{
			$("#fileDiv").hide();
			hasImage = true;
			//image['id'] = data['images'][0]['id'];
		}
	else $("#fileDiv").show();
	if(data['unit']!='undefined')
		$("#sUnidad").val(data['unit']['id']);
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
	    url:'product/'+Producto['code'],
		}).done(function(data, textStatus, jqXHR) { 	
	   		 window.location.href = "productos";	
		}).fail(function(jqXHR, textStatus, errorThrown) {
	    	if(jqXHR.status==409)
	    		errorFormulario("Ya existe un Producto con ese nombre!");
	    	});
}
function borrarProducto(code)
{
	
	$.ajax({
	    method:'DELETE',
	    url:'product/'+code,
	    success: function (rest) {
	    	window.location.href = "productos";
	    },
	    error: function(rest){
	    	console.log(rest);
	    }
	});
	
}
function borrarImagen(code)
{
	$.ajax({
	    method:'DELETE',
	    url:'image/product/'+code,
	    success: function (rest) {
	    	window.location.href = "productos";
	    },
	    error: function(rest){
	    	console.log(rest);
	    }
	});
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
			            	imagen = e.target.result;
			            };
			           
			            reader.readAsDataURL(files[0]);

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
    
    $(".eliminar-imagen").click(function () {
    	if(!$(this).is(':disabled'))
		{
	    	var parentTag = $( this ).closest("tr");
	        bootbox.confirm("¿Esta seguro que desea eliminar esta imagen?", function (result) {
	            if (result) {
	            	
	                id_producto = parentTag.data('code');
	        		borrarImagen(id_producto);
	
	            } else {
	//                no
	
	            }
	        });
		}
    	else alert("No existe una imagen para el producto seleccionado!");
    });
    $("#btn-agregar-producto").click(function () {
        $('#modal-productos').modal('show');
        limpiarFormulario($('#form-producto'));

    });
    $(".editar-producto").click(function () {
        $('#modal-productos').modal('show');
        var parentTag = $( this ).closest("tr");
        id_producto = parentTag.data('code');
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
    	else if($("#sUnidad").val()=="" || $("#sUnidad").val()==null)
		{
    		errorFormulario("Seleccione una Unidad para el Producto!");
    		return;
		}
    	else if(imagen=="" && !hasImage)
		{
    		errorFormulario("Seleccione una imagen valida para el Producto!");
    		return;
		}
    	else
    	{
	    	var categoria = {"id":$("#sCategoria").val(),"name":$("#sCategoria option:selected").text()};
	    	var unidad = {"id":$("#sUnidad").val(),"name":$("#sUnidad option:selected").text()};
	    	if(image["id"]==null && !hasImage)
	    	{
		    	image['file'] = imagen;
		    	image['extension'] = control.files[0].type;
		    	image['size'] = control.files[0].size;
		    	image['file_name'] = control.files[0].name;
	    	}
	    	var imagenes = [image];
	    	
	    	var producto = {"description":$("#tbDescripcionProducto").val(),
	    			"price_regular":$("#tbPrecio_Regular_Producto").val(),
	    			"price_discount":$("#tbPrecio_Descuento_Producto").val(),"category":categoria,
	    			"unit":unidad,"code":$("#tbCodigoProducto").val().toUpperCase(),
	    			"name":$("#tbNombreProducto").val(),"images":imagenes};
			
	    	if(esEdicionDeProducto())
    		{	  
	    		actualizarProducto(producto);
    		}
	    	else
	    		guardarProducto(producto);
    	}
    });
    $(".eliminar-producto").click(function () {
    	var parentTag = $( this ).closest("tr");
        bootbox.confirm("¿Esta seguro que desea eliminar este producto?", function (result) {
            if (result) {
            	
                id_producto = parentTag.data('code');
        		borrarProducto(id_producto);

            } else {
//                no

            }
        });

    });
});