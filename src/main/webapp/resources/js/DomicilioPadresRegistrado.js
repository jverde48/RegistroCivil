/**
 * Created with IntelliJ IDEA.
 * User: Ale
 * Date: 17/04/14
 * Time: 12:39 PM
 * To change this template use File | Settings | File Templates.
 */



function asignaCalleMadreRegistrado(elemento, nombreFormulario) {
    document.getElementById(nombreFormulario+':tabView:calleRegistrado').value = elemento.value;
}


function asignaColoniaMadreRegistrado(elemento, nombreFormulario) {
    document.getElementById(nombreFormulario+':tabView:coloniaRegistrado').value = elemento.value;
}

function asignaNumeroExteriorMadreRegistradoo(elemento, nombreFormulario) {
    document.getElementById(nombreFormulario+':tabView:noExteriorRegistrado').value = elemento.value;
}

function asignaNumeroInteriorMadreRegistrado(elemento, nombreFormulario) {
    document.getElementById(nombreFormulario+':tabView:noInteriorRegistrado').value = elemento.value;
}

function asignaCodigoPostalMadreRegistrado(elemento, nombreFormulario) {
    document.getElementById(nombreFormulario+':tabView:codigoPostalRegistrado').value = elemento.value;
}
