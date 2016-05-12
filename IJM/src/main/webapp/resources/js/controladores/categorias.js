/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function reloadPage()
{
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
function cargarCategoriaEnFormulario(data)
{
	$("#tbNombreCategoria").val(data['name']);
	$("#sCategoriaPadre").val(data['id_parent']);
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
	    	if(jqXHR.status==409)
	    		errorFormulario("Ya existe una categoria con ese nombre!");
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
	    	var categoria = {"id":'null',"name":$("#tbNombreCategoria").val()}
	    	
	    	if ($("#sCategoriaPadre").val()!="" && $("#sCategoriaPadre").val()!=null)
			{
	    		console.log($("#sCategoriaPadre").val());
				categoria['id_parent']=$("#sCategoriaPadre").val();
			}
	    	guardarCategoria(categoria);
	    	
    	}
    });
    
    $(".editar-categoria").click(function () {
        $('#modal-categorias').modal('show');
        var parentTag = $( this ).closest("tr");
        obtenerCategoria(parentTag.data('id'));

        
        
    });

    $(".eliminar-categoria").click(function () {
    	var id = $( this ).closest("tr").data("id");
    	
        bootbox.confirm("Esta seguro que desea eliminar esta categoria?", function (result) {
            if (result) {
//                ok
            	borrarCategoria(id);

            } else {
//                no

            }
        });

    });


});


