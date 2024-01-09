function validardatos(e) {
    if (e.nombre.value === "") {
        alert('LE FALTO CAPTURAR EL NOMBRE DEL ALUMNO');
        //form1.nombre.focus();
        return false;
    } else if (e.paterno.value === "") {
        alert('LE FALTO CAPTURAR EL APELLIDO PATERNO');
        //form1.paterno.focus();
        return false;
    } else if (e.sexo.value === "00") {
        alert('LE FALTO CAPTURAR EL  SEXO');
        //form1.sexo.focus();
        return false;
    } else if (e.anio.value === "") {
        alert('LE FALTO CAPTURAR EL  AÑO DE NACIMIENTO');
        //form1.anio.focus();
        return false;
    } else if (e.mes.value === "") {
        alert('LE FALTO CAPTURAR EL  MES DE NACIMIENTO');
        //form1.mes.focus();
        return false;
    } else if (e.dia.value === "") {
        alert('LE FALTO CAPTURAR EL DIA DE NACIMIENTO');
        //form1.dia.focus();
        return false;
    } else if (e.edonac.value === "00") {
        alert('LE FALTO CAPTURAR EL ESTADO DE NACIMIENTO');
        //form1.edonac.focus();
        return false;
    } else if (e.domicilio.value === "") {
        alert("¡CAMPO OBLIGATORIO! - ingrese su domicilio");
        //form1.domicilio.focus();
        return false;
    } else if (e.municipio.value === "00") {
        alert("¡CAMPO OBLIGATORIO! - Seleccione una municipio");
        //form1.municipio.focus();
        return false;
    } else if (e.grado.value === "00") {
        alert('LE FALTO CAPTURAR EL GRADO A CURSAR');
        //form1.grado.focus();
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

function validaciondir() {
    return validardatos(this) && checkSubmit();
}
