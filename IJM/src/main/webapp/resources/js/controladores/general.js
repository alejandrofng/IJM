/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
	$('#bGuardar').click(function() {

	    location.reload();

	});

});



function limpiarFormulario(formulario) {
    formulario.find('input').each(function () {
        $(this).val('');

    });
    formulario.find('select').each(function () {
        $(this).val('');

    });
}
