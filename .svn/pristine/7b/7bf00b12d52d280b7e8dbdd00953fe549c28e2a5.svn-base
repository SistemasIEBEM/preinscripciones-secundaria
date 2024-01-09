function valida(e) {
    if (e.domicilio.value === "") {
        alert("¡CAMPO OBLIGATORIO! - ingrese su domicilio");
        //form1.domicilio.focus();
        return false;
    } else if (e.municipio.value === "00") {
        alert("¡CAMPO OBLIGATORIO! - Seleccione un municipio");
        //form1.municipio.focus();
        return false;
    } else if (e.tutor.value === "") {
        alert("¡CAMPO OBLIGATORIO! - ingrese el nombre completo del padre o tutor");
        //form1.tutor.focus();
        return false;

    } else {
        return true;
    }
}

var statSend = false;
function checkSubmit() {
    if (!statSend) {
        statSend = true;
        return true;
    } else {
        alert("Registrando, espere un momento ...");
        return false;
    }
}

function validacion() {
    return valida(this) && checkSubmit();
}


