function valida_CT() {
    ct = document.getElementById('ct').value.toUpperCase();

    var varct = /^17([FIS|FTV|FZT]{3})[0-9]{4}[A-Z]{1}/;
    //var varct = /^17[DJN|DCC]{3}[0-9]{4}[A-Z]{1}/;
    if (ct.match(varct))
    {
        contra = document.getElementById('contra').value;
        if (contra.length == 0) {
            alert('Debe especificar una contraseña');
            document.getElementById('contra').focus();
            return false;
        } else {
            return true;
        }
    } else {
        alert("Debe especificar una clave de supervisor valida");
        document.getElementById('ct').focus();
        return false;
    }
}


function valida_admin() {
    ct = document.getElementById('ct').value.toUpperCase();

    var varct = /^17([ADG|ADG]{3})[0-9]{4}[A-Z]{1}/;
    //var varct = /^17[DJN|DCC]{3}[0-9]{4}[A-Z]{1}/;
    if (ct.match(varct))
    {
        contra = document.getElementById('contra').value;
        if (contra.length == 0) {
            alert('Debe especificar una contraseña');
            document.getElementById('contra').focus();
            return false;
        } else {
            return true;
        }
    } else {
        alert("Debe especificar una clave de administrador valida");
        document.getElementById('ct').focus();
        return false;
    }
}


function validactingreso() {
    ct = document.getElementById('ct').value.toUpperCase();
     grado = document.getElementById('grado').value.toUpperCase();
    var varct = /^17([DES|DTV|DZS|DSN|DST]{3})[0-9]{4}[A-Z]{1}/;
    //var varct = /^17[DJN|DCC]{3}[0-9]{4}[A-Z]{1}/;
    if (ct.length===0 || grado==='0') {
        alert("Debe especificar una clave de centro de trabajo y/o un grado");
        document.getElementById('ct').focus();
        return false;
    }
    else if (ct.match(varct))
    {

        return true;

    } else {
        alert("Debe especificar una clave de escuela valida");
        document.getElementById('ct').focus();
        return false;
    }
}

function validactcontra() {
    ct = document.getElementById('ct').value.toUpperCase();
    
    var varct = /^17([DES|SPR|PML|KPR||DZC|DPR|DTV|DPB|DIX|DZS|DSN|PDM|PPR|DML|DST]{3})[0-9]{4}[A-Z]{1}/;
    //var varct = /^17[DJN|DCC]{3}[0-9]{4}[A-Z]{1}/;
    
    if (ct.match(varct))
    {
    
        return true;

    } else {
        alert("Debe especificar una clave de escuela valida");
        document.getElementById('ct').focus();
        return false;
    }
}