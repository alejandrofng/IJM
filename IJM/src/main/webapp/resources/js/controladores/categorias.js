/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    $("#btn-agregar-categoria").click(function () {
        $('#modal-categorias').modal('show');
        limpiarFormulario($('#form-categoria'));

    });
    $(".editar-categoria").click(function () {
        $('#modal-categorias').modal('show');

    });

    $(".eliminar-categoria").click(function () {
        bootbox.confirm("Esta seguro que desea eliminar esta categoria?", function (result) {
            if (result) {
//                ok

            } else {
//                no

            }
        });

    });


});

