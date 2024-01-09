function muestraCT() {
    var str = $('#ct').val();
    //  alert(str);
    var xmlhttp;
    if (str === "00")
    {
        document.getElementById("txtHint").innerHTML = "no hay datos";
        return;
    }
    if (window.XMLHttpRequest)
    {// code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp = new XMLHttpRequest();
    } else
    {// code for IE6, IE5
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange = function ()
    {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
        {
            document.getElementById("txtHint").innerHTML = xmlhttp.responseText;
        }
    }
    //xmlhttp.open("GET","../getDiasPermiso.php?fecha_ini="+str+'&fecha_fin='+fecha_fin,true);
    xmlhttp.open("GET", "getdatos.jsp?ct=" + str, true);
    xmlhttp.send();
}


