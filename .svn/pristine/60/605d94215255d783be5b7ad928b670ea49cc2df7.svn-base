function muestraReporte() {
    var str = $('#ct').val();
    var xmlhttp;
    if (str === "00")
    {
        document.getElementById("txtHint").innerHTML = "";
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

    xmlhttp.open("GET", "getReporte.jsp?ct=" + str, true);
    xmlhttp.send();
}