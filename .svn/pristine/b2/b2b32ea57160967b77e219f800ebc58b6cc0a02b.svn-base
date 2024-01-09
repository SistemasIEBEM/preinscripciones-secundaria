function valida() {

    ct = document.getElementById('ct').value.toUpperCase();
   // ct1 = document.getElementById('ct1').value.toUpperCase();
    //ct2 = document.getElementById('ct2').value.toUpperCase();
    //ct3 = document.getElementById('campo_3').value.toUpperCase();

    var varct = /^17([DJN|DCC|DNM|EJN]{3})[0-9]{4}[A-Z]{1}/;
   // var varct2 = /^17([DPR|DIX|DZC|DPB]{3})[0-9]{4}[A-Z]{1}/;
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

