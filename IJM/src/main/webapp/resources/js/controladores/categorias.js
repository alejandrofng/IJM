/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var id_categoria;
function reloadPage()
{
	id_categoria=null;
    var loc = window.location;
    window.location = loc.protocol + '//' + loc.host + loc.pathname + loc.search;
}
function esNombreVacio()
{
	
	if($("#tbNombreCategoria").val()!="")
		{
			return false
		}
	return true;
	
}
function esEdicionDeCategoria()
{
	if(id_categoria==null)
	{
		return false;
	}
return true;
}
function cargarCategoriaEnFormulario(data)
{
	$("#tbNombreCategoria").val(data['name']);
	$("#sCategoriaPadre").val(data['id_parent']);
	$("#sCategoriaPadre option[value='"+data['id']+"']").hide();
}
function obtenerCategoria(id)
{
	$.ajax({
	    method:'GET',
	    contentType: "application/json; charset=utf-8",
	    url:'category/'+id,
		}).done(function(data, textStatus, jqXHR) { 	
			cargarCategoriaEnFormulario(data);
		}).fail(function(jqXHR, textStatus, errorThrown) {
	    	});
}
function guardarCategoria(categoria)
{
	$.ajax({
	    method:'POST',
	    data:JSON.stringify(categoria),
	    contentType: "application/json; charset=utf-8",
	    url:'category',
		}).done(function(data, textStatus, jqXHR) { 	
	   		 window.location.href = "categorias";	
		}).fail(function(jqXHR, textStatus, errorThrown) {
	    	if(jqXHR.status==409)
	    		errorFormulario("Ya existe una categoria con ese nombre!");
	    	});
}
function actualizarCategoria(categoria)
{
	$.ajax({
	    method:'PUT',
	    data:JSON.stringify(categoria),
	    contentType: "application/json; charset=utf-8",
	    url:'category/'+categoria['id'],
		}).done(function(data, textStatus, jqXHR) { 	
	   		 window.location.href = "categorias";	
		}).fail(function(jqXHR, textStatus, errorThrown) {
	    	if(jqXHR.status==409)
	    		errorFormulario("Ya existe una categoria con ese nombre!");
	    	});
}
function borrarCategoria(id)
{
	$.ajax({
	    method:'DELETE',
	    url:'category/'+id,
	    success: function (rest) {
	    	console.log(rest);
	    	console.log("delete");
	    	window.location.href = "categorias";
	    },
	    error: function(rest){
	    	console.log(rest);
	    }
	});
}
$(document).ready(function () {


	$("#btn-agregar-categoria").click(function () {
    	limpiarFormulario($('#form-categoria'));
        $('#modal-categorias').modal('show');
    });
    
    $("#btn-guardar-categoria").click(function () {

    	if(esNombreVacio())
    	{
    		errorFormulario("Debe indicar un nombre para la categoria!")
    		return;
    	}
    	else
    	{
	    	var categoria = {"id":id_categoria,"name":$("#tbNombreCategoria").val()}	
	    	if ($("#sCategoriaPadre").val()!="" && $("#sCategoriaPadre").val()!=null)
			{
				categoria['id_parent']=$("#sCategoriaPadre").val();
			}
	    	if(esEdicionDeCategoria())
    		{	  
	    		actualizarCategoria(categoria);
    		}
	    	else
	    		guardarCategoria(categoria);
    	}
    });
    
    $(".editar-categoria").click(function () {
        $('#modal-categorias').modal('show');
        var parentTag = $( this ).closest("tr");
        id_categoria = parentTag.data('id');
        obtenerCategoria(id_categoria);
    });

    $(".eliminar-categoria").click(function () {
    	var id = $( this ).closest("tr").data("id");
    	
        bootbox.confirm("Esta seguro que desea eliminar esta categoria?", function (result) {
            if (result) {
            	borrarCategoria(id);

            } else {

            }
        });

    });

    $("#btn-cerrar-formulario").click( function () {
    	if(esEdicionDeCategoria())
		{
	    	$("#sCategoriaPadre option[value='"+id_categoria+"']").show();
	    	id_categoria=null;
		}
    });
    $("#bCancelar").click( function () {
    	if(esEdicionDeCategoria())
		{
	    	$("#sCategoriaPadre option[value='"+id_categoria+"']").show();
	    	id_categoria=null;
		}
    });
});


