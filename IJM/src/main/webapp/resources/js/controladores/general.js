/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {

});



function limpiarFormulario(formulario) {
    formulario.find('input').each(function () {
        $(this).val('');
    });
    formulario.find('select').each(function () {
        $(this).val('');
    });
    formulario.find("#lbErrorForm").each(function () {
        $(this).val('');
    });
}
function errorFormulario(msg){
        $("#lbErrorForm").text(msg);
}
function reloadPage()
{
    var loc = window.location;
    window.location = loc.protocol + '//' + loc.host + loc.pathname + loc.search;
}