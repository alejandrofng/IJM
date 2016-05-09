/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    $("#btn-agregar-proveedor").click(function () {
        $('#modal-proveedores').modal('show');
        limpiarFormulario($('#form-proveedor'));

    });
    $(".editar-proveedor").click(function () {
        $('#modal-proveedores').modal('show');

    });

    $(".eliminar-proveedor").click(function () {
        bootbox.confirm("Esta seguro que desea eliminar este proveedor?", function (result) {
            if (result) {
//                ok

            } else {
//                no

            }
        });

    });
});