/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var id_Unidad;
function reloadPage()
{
	id_Unidad=null;
    var loc = window.location;
    window.location = loc.protocol + '//' + loc.host + loc.pathname + loc.search;
}
function esNombreVacio()
{
	
	if($("#tbNombreUnidad").val()!="")
		{
			return false
		}
	return true;
	
}
function esEdicionDeUnidad()
{
	if(id_Unidad==null)
	{
		return false;
	}
return true;
}
function cargarUnidadEnFormulario(data)
{
	$("#tbNombreUnidad").val(data['name']);
}
function obtenerUnidad(id)
{
	$.ajax({
	    method:'GET',
	    contentType: "application/json; charset=utf-8",
	    url:'unit/'+id,
		}).done(function(data, textStatus, jqXHR) { 	
			cargarUnidadEnFormulario(data);
		}).fail(function(jqXHR, textStatus, errorThrown) {
	    	});
}
function guardarUnidad(Unidad)
{
	$.ajax({
	    method:'POST',
	    data:JSON.stringify(Unidad),
	    contentType: "application/json; charset=utf-8",
	    url:'unit',
		}).done(function(data, textStatus, jqXHR) { 	
	   		 window.location.href = "unidades";	
		}).fail(function(jqXHR, textStatus, errorThrown) {
	    	if(jqXHR.status==409)
	    		errorFormulario("Ya existe una Unidad con ese nombre!");
	    	});
}
function actualizarUnidad(Unidad)
{
	$.ajax({
	    method:'PUT',
	    data:JSON.stringify(Unidad),
	    contentType: "application/json; charset=utf-8",
	    url:'unit/'+Unidad['id'],
		}).done(function(data, textStatus, jqXHR) { 	
	   		 window.location.href = "unidades";	
		}).fail(function(jqXHR, textStatus, errorThrown) {
	    	if(jqXHR.status==409)
	    		errorFormulario("Ya existe una Unidad con ese nombre!");
	    	});
}
function borrarUnidad(id)
{
	$.ajax({
	    method:'DELETE',
	    url:'unit/'+id,
	    success: function (rest) {
	    	console.log(rest);
	    	console.log("delete");
	    	window.location.href = "unidades";
	    },
	    error: function(rest){
	    	console.log(rest);
	    }
	});
}
$(document).ready(function () {


	$("#btn-agregar-unidad").click(function () {
    	limpiarFormulario($('#form-unidad'));
        $('#modal-unidades').modal('show');
    });
    
    $("#btn-guardar-unidad").click(function () {

    	if(esNombreVacio())
    	{
    		errorFormulario("Debe indicar un nombre para la Unidad!")
    		return;
    	}
    	else
    	{
	    	var Unidad = {"id":id_Unidad,"name":$("#tbNombreUnidad").val()}	
	    	if(esEdicionDeUnidad())
    		{	  
	    		actualizarUnidad(Unidad);
    		}
	    	else
	    		guardarUnidad(Unidad);
    	}
    });
    
    $(".editar-unidad").click(function () {
        $('#modal-unidades').modal('show');
        var parentTag = $( this ).closest("tr");
        id_Unidad = parentTag.data('id');
        obtenerUnidad(id_Unidad);
    });

    $(".eliminar-unidad").click(function () {
    	var id = $( this ).closest("tr").data("id");
    	
        bootbox.confirm("Esta seguro que desea eliminar esta Unidad?", function (result) {
            if (result) {
            	borrarUnidad(id);

            } else {

            }
        });

    });

    $("#btn-cerrar-formulario").click( function () {
    	if(esEdicionDeUnidad())
		{
	    	id_Unidad=null;
		}
    });
    $("#bCancelar").click( function () {
    	if(esEdicionDeUnidad())
		{
	    	id_Unidad=null;
		}
    });
});


