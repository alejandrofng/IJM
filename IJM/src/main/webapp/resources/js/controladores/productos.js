/* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    $("#btn-agregar-producto").click(function () {
        $('#modal-productos').modal('show');
        limpiarFormulario($('#form-producto'));

    });
    $(".editar-producto").click(function () {
        $('#modal-productos').modal('show');

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