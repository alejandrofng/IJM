/* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var id_producto;
function reloadPage()
{
	id_producto=null;
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

	    $("#uploader").pluploadQueue({
	        // General settings
	        runtimes : 'html5,flash,silverlight,html4',
	        url : '/examples/upload',
	        chunk_size : '1mb',
	        unique_names : true,
	        max_files:1,
	        // Resize images on client-side if we can
	        resize : {width : 320, height : 240, quality : 90},
	         
	        filters : {
	            max_file_size : '10mb',
	 
	            // Specify what files to browse for
	            mime_types: [
	                {title : "Image files", extensions : "jpg,gif,png"},
	                {title : "Zip files", extensions : "zip"}
	            ]
	        },
	 
	        // Flash settings
	        flash_swf_url : '/plupload/js/Moxie.swf',
	     
	        // Silverlight settings
	        silverlight_xap_url : '/plupload/js/Moxie.xap',
	         
	        // PreInit events, bound before any internal events
	        preinit : {
	            Init: function(up, info) {
	                //log('[Init]', 'Info:', info, 'Features:', up.features);
	            },
	 
	            UploadFile: function(up, file) {
	                //log('[UploadFile]', file);
	 
	                // You can override settings before the file is uploaded
	                // up.setOption('url', 'upload.php?id=' + file.id);
	                // up.setOption('multipart_params', {param1 : 'value1', param2 : 'value2'});
	            }
	        },
	 
	        // Post init events, bound after the internal events
	        init : {

	            FilesAdded: function(up, files) {
	                // Called when files are added to queue
	                var maxfiles = 1;
                    if(up.files.length > maxfiles )
                     {
                        up.splice(maxfiles);
                        alert('no more than '+maxfiles + ' file(s)');
                     }
                    if (up.files.length === maxfiles) {
                        $('#uploader_browse').hide("slow"); // provided there is only one #uploader_browse on page
                    }
	            },
	            
	            FilesRemoved: function(up, files) {
	                // Called when files are removed from queue
	                
	                if (up.files.length < up.settings.max_files) {
	                    $(up.settings.browse_button).show("slow");
	                  }
	            },

	        }
	    });
	 
	 
   
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
    		errorFormulario("Debe indicar un nombre para el Producto!")
    		return;
    	}
    	else if($("#sCategoria").val()=="" || $("#sCategoria").val()==null)
		{
    		errorFormulario("Seleccione una categoria para el Producto!")
    		return;
		}
    	else
    	{
			var image = document.getElementById('myFile').files[0];
			var  fr = new FileReader();
			fr.onload = receivedText;
	      //fr.readAsText(file);
			fr.readAsDataURL(file);
	    	var categoria = {"id":$("#sCategoria").val()}	;
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