<%-- 
    Document   : datosalumnos_sincurp
    Created on : 12/01/2017, 11:38:57 AM
    Author     : Registro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        String context = request.getContextPath();
        HttpSession sesion = request.getSession();
        String nombre = (String) sesion.getAttribute("usuario");
        if (sesion.getAttribute("usuario") == null) {
            response.sendRedirect("menudir.jsp");
        }
    %>   
    <head>
        <link rel="shortcut icon" href="<%=context%>/images/iebem.ico">
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <meta name="description" content="" />
        <meta name="keywords" content="" />
        <%@include file="snippets/generalcssjs.jsp"%>
        <script src="<%=context%>/js/funciones/validar_campos_dir.js"></script>
        <script src="<%=context%>/js/funciones/botonAtras.js"></script>
        <style type="text/css">
            body {
                overflow-x:hidden;
            }
        </style>
        <script>
            document.onkeydown = function (e) {
                if (e.keyCode === 116) {
                    return false;
                }
            };
        </script>
    </head>
    <body onload="nobackbutton();">
        <!-- Header -->
        <%@include file="header.jsp"%>
        <div id="border-top"></div>
        <!-- Index -->
        <form class="form-signin" action="<%=context%>/ServletPreinscribirSinCurp" method="post" onsubmit="return validaciondir()">
            <div class="jumbotron">
                <div class="container">
                    <div class="row">                      
                        <div class="col-xs-12">
                            <center>
                                <h1 style="font-size: 16px; font-weight:bold;">PREINSCRIPCION DE ASPIRANTES QUE NO CUENTAN CON CURP</h1>
                                <h1 style="font-size: 12px; font-style: italic; font-weight:bold;">
                                    "La informaci&oacute;n que usted nos proporciona, ser&aacute; tratada bajo estricto
                                    apego a lo establecido en la Ley de Informaci&oacute;n P&uacute;blica, Estad&iacute;stica 
                                    y Protecci&oacute;n de Datos Personales del Estado de Morelos".
                                </h1>
                                <h1 style="font-size: 12px; font-style: italic; font-weight:bold;">
                                    "Los campos con asteríscos(*) son obligatorios de llenar".
                                </h1>
                            </center>                            
                            <div class="table-responsive">
                                <table class="table table-condensed">
                                    <legend>
                                        <strong>
                                            <center>Datos Personales</center>
                                        </strong>
                                    </legend>
                                    <tr>
                                        <td style="font-weight:bold; width:200px">Nombre(s) del aspirante:<font color="red">*</font></td>
                                        <td>
                                            <input name="nombre" id="nombre" type="text" size="60" maxlength="40" onKeyUp="this.value = this.value.toUpperCase()" class="form-control"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td style="font-weight:bold;">Primer apellido del aspirante:<font color="red">*</font></td>
                                        <td>
                                            <input name="paterno" id="paterno" type="text" size="60" maxlength="40" onKeyUp="this.value = this.value.toUpperCase()" class="form-control"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td style="font-weight:bold;">Segundo apellido del aspirante:</td>
                                        <td>
                                            <input name="materno" id="materno" type="text" size="60" maxlength="40" onKeyUp="this.value = this.value.toUpperCase()" class="form-control"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td style="font-weight:bold;">Sexo del aspirante:<font color="red">*</font></td>
                                        <td>
                                            <select id="sexo" name="sexo" class="form-control">
                                                <option value="00">Seleccione un sexo</option>
                                                <option value="M">MUJER</option>
                                                <option value="H">HOMBRE</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td style="font-weight:bold;">Fecha de nacimiento del aspirante:<font color="red">*</font></td>
                                        <td> 
                                            <input type="text" class="form-control" id="fecha" name="fecha"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td style="font-weight:bold;">Estado de nacimiento del aspirante:<font color="red">*</font></td><td><select id="edonac" name="edonac" class="form-control">
                                                <option value='00'>Seleccione una entidad de nacimiento</option>
                                                <option value='BC'>BAJA CALIFORNIA</option>
                                                <option value='BS'>BAJA CALIFORNIA SUR</option>
                                                <option value='CC'>CAMPECHE</option>
                                                <option value='CS'>CHIAPAS</option>
                                                <option value='CH'>CHIHUAHUA</option>
                                                <option value='CL'>COAHUILA</option>
                                                <option value='CM'>COLIMA</option>
                                                <option value='DF'>DISTRITO FEDERAL</option>
                                                <option value='DG'>DURANGO</option>
                                                <option value='GT'>GUANAJUATO</option>
                                                <option value='GR'>GUERRERO</option>
                                                <option value='HG'>HIDALGO</option>
                                                <option value='JC'>JALISCO</option>
                                                <option value='MC'>ESTADO DE M&Eacute;XICO</option>
                                                <option value='MN'>MICHOAC&Aacute;N</option>
                                                <option value='MS'>MORELOS</option>
                                                <option value='NT'>NAYARIT</option>
                                                <option value='NL'>NUEVO LE&Oacute;N</option>
                                                <option value='OC'>OAXACA</option>
                                                <option value='PL'>PUEBLA</option>
                                                <option value='QT'>QUER&Eacute;TARO</option>
                                                <option value='QR'>QUINTANA ROO</option>
                                                <option value='SP'>SAN LUIS POTOS&Iacute;</option>
                                                <option value='SL'>SINALOA</option>
                                                <option value='SR'>SONORA</option>
                                                <option value='TC'>TABASCO</option>
                                                <option value='TS'>TAMAULIPAS</option>
                                                <option value='TL'>TLAXCALA</option>
                                                <option value='VZ'>VERACRUZ</option>
                                                <option value='YN'>YUCAT&Aacute;N</option>
                                                <option value='ZS'>ZACATECAS</option>
                                                <option value='NE'>NACIDO EN EL EXTRANJERO</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>  
                                    <h1 style="font-size: 14px; font-weight:bold;">
                                        "Para consultar su CURP, acceda a la siguiente dirección: <a href="https://www.gob.mx/curp" target="_blank">https://www.gob.mx/curp</a>".
                                    </h1>
                                    </tr>
                                    <tr>
                                        <!--<div class="form-group col-lg-12">-->
                                        <td style="font-weight:bold;">Para generar el segmento raíz, de clic en el botón 'Generar'.<font color="red">*</font></td>
                                        <td>
                                            <div class="input-group">
                                                <div class="input-group-append">
                                                    <button class="btn btn-outline-primary" onclick="generarSegmento();" type="button">Generar</button>
                                                </div>
                                                <input type="text" class="form-control"  aria-describedby="basic-addon2" name="curp" id="curp" readonly>
                                            </div> 
                                        </td>
                                    </tr>
                                    <tr>
                                        <td style="font-weight:bold; width:200px">CURP del padre ó tutor:<font color="red">*</font></td>
                                        <td>
                                            <div class="input-group">
                                                <div class="input-group-prepend">
                                                    <button class="btn btn-outline-primary" type="button" onclick="consultar(document.getElementById('curpT').value)">Consultar</button>
                                                </div>
                                                <input type="text" class="form-control" placeholder="Ingrese su CURP" aria-label="Ingrese su CURP" aria-describedby="basic-addon2" onkeyup="mayus(this);" name="curpT" id="curpT" maxlength="18">
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td style="font-weight:bold; width:200px">Nombre del padre ó tutor:<font color="red">*</font></td>
                                        <td>
                                            <input id="nombreT" name="nombreT" size="67" onkeyup="mayus(this);" class="form-control" readonly/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td style="font-weight:bold; width:200px">Apellido paterno del padre ó tutor:<font color="red">*</font></td>
                                        <td>
                                            <input id="apPaternoT" name="apPaternoT" size="67" onkeyup="mayus(this);" class="form-control" readonly/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td style="font-weight:bold; width:200px">Apellido materno del padre ó tutor:<font color="red">*</font></td>
                                        <td>
                                            <input id="apMaternoT" name="apMaternoT" size="67" onkeyup="mayus(this);" class="form-control" readonly/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td style="font-weight:bold; width:200px">Entidad de nacimiento del padre ó tutor:<font color="red">*</font></td>
                                        <td>
                                            <input id="entidadT" name="entidadT" size="67" onkeyup="mayus(this);" class="form-control" readonly/>
                                        </td>
                                    </tr>                                    
                                    <tr>
                                        <td style="font-weight:bold; width:200px">Fecha nacimiento del padre ó tutor:<font color="red">*</font></td>
                                        <td>
                                            <input id="fechanacT" name="fechanacT" size="67" onkeyup="mayus(this);" class="form-control" readonly/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td style="font-weight:bold; width:200px">Sexo del padre ó tutor:<font color="red">*</font></td>
                                        <td>
                                            <input id="sexoT" name="sexoT" size="67" onkeyup="mayus(this);"class="form-control" readonly/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td style="font-weight:bold; width:200px">Municipio actual:<font color="red">*</font></td>
                                        <td>
                                            <select id="municipio" name="municipio" class="form-control" disabled>
                                                <option value="00">Seleccione un municipio</option>
                                                <option value="Amacuzac">Amacuzac</option>
                                                <option value="Atlatlahucan">Atlatlahucan</option>
                                                <option value="Axochiapan">Axochiapan</option>
                                                <option value="Ayala">Ayala</option>
                                                <option value="Coatlan del Rio">Coatl&aacute;n del R&iacute;o</option>
                                                <option value="Cuautla">Cuautla</option>
                                                <option value="Cuernavaca">Cuernavaca</option>
                                                <option value="Emiliano Zapata">Emiliano Zapata</option>
                                                <option value="Huitzilac">Huitzilac</option>
                                                <option value="Jantetelco">Jantetelco</option>
                                                <option value="Jiutepec">Jiutepec</option>
                                                <option value="Jojutla">Jojutla</option>
                                                <option value="Jonacatepec de Leandro Valle">Jonacatepec de Leandro Valle</option>
                                                <option value="Mazatepec">Mazatepec</option>
                                                <option value="Miacatlan">Miacatl&aacute;n</option>
                                                <option value="Ocuituco">Ocuituco</option>
                                                <option value="Puente de Ixtla">Puente de Ixtla</option>
                                                <option value="Temixco">Temixco</option>
                                                <option value="Temoac">Temoac</option>
                                                <option value="Tepalcingo">Tepalcingo</option>
                                                <option value="Tepoztlan">Tepoztl&aacute;n</option>
                                                <option value="Tetecala">Tetecala</option>
                                                <option value="Tetela del Volcan">Tetela del Volc&aacute;n</option>
                                                <option value="Tlalnepantla">Tlalnepantla</option>
                                                <option value="Tlaltizapan de Zapata">Tlaltizap&aacute;n de Zapata</option>
                                                <option value="Tlaquiltenango">Tlaquiltenango</option>
                                                <option value="Tlayacapan">Tlayacapan</option>
                                                <option value="Totolapan">Totolapan</option>
                                                <option value="Xochitepec">Xochitepec</option>
                                                <option value="Yautepec">Yautepec</option>
                                                <option value="Yecapixtla">Yecapixtla</option>
                                                <option value="Zacatepec">Zacatepec de Hidalgo</option>
                                                <option value="Zacualpan de Amilpas">Zacualpan de Amilpas</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td style="font-weight:bold; width:200px">Domicilio particular:<font color="red">*</font></td>
                                        <td>
                                            <input id="domicilio" name="domicilio" size="67" onKeyUp="this.value = this.value.toUpperCase()" class="form-control" disabled/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td style="font-weight:bold; width:200px">Correo de contacto:</td>
                                        <td>
                                            <input id="correo" name="correo" size="67" class="form-control" disabled/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td style="font-weight:bold; width:200px">Teléfono:</td>
                                        <td>
                                            <input id="telefono" name="telefono" size="16" maxlength="10" onkeypress="ValidaSoloNumeros()" class="form-control" disabled/>
                                        </td>
                                    </tr>
                                </table>
                                <input type="hidden" name="contexto" id="contexto" value="<%=context%>"/>
                                <input type="hidden" id="ct" name="ct" value="<%=nombre%>" />
                            </div>
                            <hr>
                            <!--<div class="col-lg-12">-->
                            <div class="row">
                                <div class="col">
                                    <button class="btn btn-primary" type="submit" id="botonPre">
                                        <i class="fas fa-save"></i> 
                                        GUARDAR
                                    </button>
                                </div>
                                <div class="col">
                                    <button class="btn btn-danger" type="reset" id="botonPre" onclick="location.href = 'preinscribirDir.jsp';">
                                        <i class="fas fa-reply"></i> 
                                        REGRESAR
                                    </button>
                                </div>
                            </div>
                            <!--</div>-->
                        </div>
                    </div>
                </div>
            </div>
            <input type="hidden" id="ct" name="ct" value="<%=nombre%>"/>
        </form>
        <!-- Footer -->
        <%@include file="footer.jsp" %>
        <script type="text/javascript">
            $(document).ready(function () {
                $('#skel-layers-visibleWrapper').remove();
            });
        </script>
        <script type="text/javascript">
            $('#fecha').datepicker({
                uiLibrary: 'bootstrap4',
                modal: true,
                footer: true,
                iconsLibrary: 'fontawesome',
                locale: 'es-es',
                format: 'yyyy-mm-dd'
            });

            function validarCampo(nombre) {
                var valor = $("#" + nombre).val();
                console.log(valor);
                if (valor == null || valor.length == 0 || /^\s+$/.test(valor) || valor == '') {
                    $("#" + nombre).attr('class', 'form-control is-invalid');
                    return 0;
                } else {
                    $("#" + nombre).attr('class', 'form-control is-valid');
                    return 1;
                }
            }

            function validarSelect(nombre) {
                var valor = $("#" + nombre + " option:selected").val();
                if (valor == '0' || valor == '' || valor == null) {
                    $("#" + nombre).attr('class', 'form-control is-invalid');
                    return 0;
                } else {
                    $("#" + nombre).attr('class', 'form-control is-valid');
                    return 1;
                }
            }

            function ValidaSoloNumeros() {
                if ((event.keyCode < 48) || (event.keyCode > 57))
                    event.returnValue = false;
            }
            function mayus(e) {
                e.value = e.value.toUpperCase();
            }

            function consultar(curp) {
                //alert(curp);
                if ($("#curpT").val().length === 18) {
                    var context = $('#contexto').val();
                    $.ajax({
                        type: 'get',
                        cache: false,
                        url: context + '/ServletProcRenapo',
                        data: {curp: curp},
                        success:
                                function (data)
                                {
                                    var consulta = JSON.parse(data);
                                    //console.log(consulta);
                                    if (consulta.parametros != undefined) {
                                        if (consulta.parametros.curp != null) {
                                            $('#nombreT').val(consulta.parametros.nombre);
                                            $('#apPaternoT').val(consulta.parametros.apellidoPaterno);
                                            $('#apMaternoT').val(consulta.parametros.apellidoMaterno);
                                            $('#fechanacT').val(consulta.parametros.fechaNacimiento);
                                            $('#entidadT').val(consulta.parametros.claveEntidadNacimiento);
                                            $('#sexoT').val(consulta.parametros.sexo);
                                            $("#municipio").prop("disabled", false);
                                            $("#domicilio").prop("disabled", false);
                                            $("#correo").prop("disabled", false);
                                            $("#telefono").prop("disabled", false);
                                        } else {
                                            alert("CURP incorrecta, ingreselo nuevamente!");
                                        }
                                    } else {
                                        alert("Error en el registro");
                                    }
                                }
                    });
                } else {
                    $('#nombreT').val('');
                    $('#apPaternoT').val('');
                    $('#apMaternoT').val('');
                    $('#fechanacT').val('');
                    $('#entidadT').val('');
                    $('#sexoT').val('');
                    $('#municipio').val('');
                    $('#domicilio').val('');
                    $('#correo').val('');
                    $('#telefono').val('');
                    alert("Ingrese un registro válido en el campo CURP");
                }
            }

            function generarSegmento() {

                var lista_sexoVal = validarSelect('sexo');
                var lista_edoVal = validarSelect('edonac');
                var apPaternoSegmentoVal = validarCampo('paterno');
                //var apMaternoSegmentoVal =  validarCampo('apMaternoSegmento');
                var nombreSegmentoVal = validarCampo('nombre');
                var fechaNacmSegmentoVal = validarCampo('fecha');


                if (lista_sexoVal !== 0 && lista_edoVal !== 0 && apPaternoSegmentoVal !== 0 && nombreSegmentoVal !== 0 && fechaNacmSegmentoVal !== 0)
                {

                    var paterno1st = document.getElementById('paterno').value.toUpperCase();
                    paterno1st = paterno1st.replace("LAS ", "");
                    paterno1st = paterno1st.replace("DEL ", "");
                    var paterno = paterno1st.replace("LA ", "");
                    paterno = paterno.replace("DE ", "");
                    paterno = paterno.replace("Y ", "");
                    while (paterno[0] === " ") {
                        paterno = paterno.substr(1, paterno.length - 1);
                    }
                    console.log(paterno);
                    var materno1st = document.getElementById('materno').value.toUpperCase();
                    var materno1st = materno1st.replace("LAS ", "");
                    materno1st = materno1st.replace("DEL ", "");
                    materno1st = materno1st.replace("DE ", "");
                    var materno = materno1st.replace("LA ", "");
                    materno = materno.replace("Y ", "");
                    var maternosize = materno.length;
                    if (maternosize !== 0) {
                        if (materno[0] !== "Ñ") {
                            var s3 = materno[0];
                        } else {
                            s3 = "X";
                        }
                    } else {
                        s3 = "X";
                    }
                    while (materno[0] === " ") {
                        materno = materno.substr(1, materno.length - 1);
                    }
                    var nombre = document.getElementById('nombre').value.toUpperCase();
                    var nombreAl = nombre;
                    var op_paterno = paterno.length;
                    var vocales = /^[aeiou]/i;
                    var consonantes = /^[bcdfghjklmnñpqrstvwxyz]/i;
                    var s1 = '';
                    var s2 = '';
                    var s8 = '';
                    var i = 0;
                    var x = true;
                    var z = true;
                    while (i < op_paterno) {
                        if ((vocales.test(paterno[i]) === true) & (x !== false) || (consonantes.test(paterno[i]) === true) & (x !== false)) {
                            s1 = s1 + paterno[i];
                            switch (s1) {
                                case 'Ñ':
                                    s1 = 'X';
                                    break;
                                default:
                                    s1;
                                    break;
                            }
                            console.log(s1);
                            paterno = paterno.replace(paterno[i], "");
                            x = false;
                        }
                        if ((vocales.test(paterno[i]) === true) & (z !== false)) {
                            s2 = s2 + paterno[i];
                            switch (s2) {
                                case 'Ñ':
                                    s2 = 'X';
                                    break;
                                default:
                                    s2;
                                    break;
                            }
                            paterno = paterno.replace(paterno[i], "");
                            z = false;
                        }
                        i++;
                    }
                    var ix = 0;
                    var y = true;
                    var nparteno = paterno.length;
                    while (ix < nparteno) {
                        if ((consonantes.test(paterno[ix]) === true) & (y !== false)) {
                            s8 = s8 + paterno[ix];
                            switch (s8) {
                                case 'Ñ':
                                    s8 = 'X';
                                    break;
                                default:
                                    s8;
                                    break;
                            }
                            y = false;
                        }
                        ix++;
                    }
                    var j = 1;
                    var s9 = '';
                    var xm = true;
                    var ym = true;
                    if (maternosize !== 0) {
                        while (j < maternosize) {
                            if ((consonantes.test(materno[j]) === true) && (xm !== false)) {
                                s9 = s9.replace(materno[j], "");
                                switch (s9) {
                                    case 'Ñ':
                                        s9 = 'X';
                                        break;
                                    default:
                                        s9;
                                        break;
                                }
                                xm = false;
                            }
                            if ((consonantes.test(materno[j]) === true) && (ym !== false)) {
                                s9 = s9 + materno[j];
                                switch (s9) {
                                    case 'Ñ':
                                        s9 = 'X';
                                        break;
                                    default:
                                        s9;
                                        break;
                                }
                                ym = false;
                            }
                            j++;
                        }
                    } else {
                        s9 = "X";
                    }
                    var nombresize = nombre.length;
                    var im = 1;
                    var s10 = '';
                    var wz = true;
                    if (nombreAl === "JOSE MARIA" || nombreAl === "MARIA JOSE") {
                        var corteNombreAl = nombreAl.split(' ');
                        s10 = corteNombreAl[1].substring(0, 1);
                    } else {
                        var corteNombre2 = nombreAl.split(' ');
                        var nombre2 = corteNombre2[0];
                        var nombre3 = corteNombre2[1];
                        if (corteNombre2[0] === "MARIA" || corteNombre2[0] === "MA." || corteNombre2[0] === "MA" || corteNombre2[0] === "JOSE" || corteNombre2[0] === "J" || corteNombre2[0] === "J.") {
                            if (corteNombre2[1] === undefined) {
                                while (im < nombresize) {
                                    if ((consonantes.test(nombre2[im]) === true) && (wz !== false)) {
                                        s10 = s10 + nombre2[im];
                                        switch (s10) {
                                            case 'Ñ':
                                                s10 = 'X';
                                                break;
                                            default:
                                                s10;
                                                break;
                                        }
                                        nombre = nombre2.replace(nombre2[im], "");
                                        wz = false;
                                    }
                                    im++;
                                }
                            } else {
                                while (im < nombresize) {
                                    if ((consonantes.test(nombre3[im]) === true) && (wz !== false)) {
                                        s10 = s10 + nombre3[im];
                                        switch (s10) {
                                            case 'Ñ':
                                                s10 = 'X';
                                                break;
                                            default:
                                                s10;
                                                break;
                                        }
                                        nombre = nombre3.replace(nombre3[im], "");
                                        wz = false;
                                    }
                                    im++;
                                }
                            }
                        } else if (corteNombre2[1] === "MARIA" || corteNombre2[1] === "MA." || corteNombre2[1] === "MA" || corteNombre2[1] === "JOSE" || corteNombre2[1] === "J" || corteNombre2[1] === "J.") {
                            while (im < nombresize) {
                                if ((consonantes.test(nombre2[im]) === true) && (wz !== false)) {
                                    s10 = s10 + nombre2[im];
                                    switch (s10) {
                                        case 'Ñ':
                                            s10 = 'X';
                                            break;
                                        default:
                                            s10;
                                            break;
                                    }
                                    nombre = nombre2.replace(nombre2[im], "");
                                    wz = false;
                                }
                                im++;
                            }
                        } else {
                            while (im < nombresize) {
                                if ((consonantes.test(nombreAl[im]) === true) && (wz !== false)) {
                                    s10 = s10 + nombreAl[im];
                                    switch (s10) {
                                        case 'Ñ':
                                            s10 = 'X';
                                            break;
                                        default:
                                            s10;
                                            break;
                                    }
                                    nombre = nombreAl.replace(nombre[im], "");
                                    wz = false;
                                }
                                im++;
                            }
                        }
                    }
                    var sexo = $('select[name=sexo]').val();
                    //console.log(sexo);

                    var edo = $('select[name=edonac]').val();
                    //console.log(edo);
                    var s4 = '';
                    if (nombreAl === "JOSE MARIA" || nombreAl === "MARIA JOSE") {
                        var corteNombreAl = nombreAl.split(' ');
                        s4 = corteNombreAl[1].substring(0, 1);
                    } else {
                        var corteNombre = nombreAl.split(' ');
                        if (corteNombre[1] === "MARIA" || corteNombre[1] === "MA." || corteNombre[1] === "MA" || corteNombre[1] === "JOSE" || corteNombre[1] === "J" || corteNombre[1] === "J.") {
                            s4 = corteNombre[0].substring(0, 1);
                        } else if (corteNombre[0] === "MARIA" || corteNombre[0] === "MA." || corteNombre[0] === "MA" || corteNombre[0] === "JOSE" || corteNombre[0] === "J" || corteNombre[0] === "J.") {
                            if (corteNombre[1] === undefined) {
                                s4 = corteNombre[0].substring(0, 1);
                                switch (s4) {
                                    case 'Ñ':
                                        s4 = 'X';
                                        break;
                                    default:
                                        s4;
                                        break;
                                }
                            } else {
                                s4 = corteNombre[1].substring(0, 1);
                                switch (s4) {
                                    case 'Ñ':
                                        s4 = 'X';
                                        break;
                                    default:
                                        s4;
                                        break;
                                }
                            }
                        } else {
                            s4 = nombreAl[0];
                            switch (s4) {
                                case 'Ñ':
                                    s4 = 'X';
                                    break;
                                default:
                                    s4;
                                    break;
                            }
                        }
                    }
                    var caracteresCompletos = s1 + s2 + s3 + s4;
                    if (caracteresCompletos === "BACA" || caracteresCompletos === "BXCA" || caracteresCompletos === "LOCO" || caracteresCompletos === "LXCO" || caracteresCompletos === "BAKA"
                            || caracteresCompletos === "BXKA" || caracteresCompletos === "LOKA" || caracteresCompletos === "LXKA" || caracteresCompletos === "BUEI" || caracteresCompletos === "BXEI"
                            || caracteresCompletos === "LOKO" || caracteresCompletos === "LXKO" || caracteresCompletos === "BUEY" || caracteresCompletos === "BXEY" || caracteresCompletos === "MAME"
                            || caracteresCompletos === "MXME" || caracteresCompletos === "CACA" || caracteresCompletos === "CXCA" || caracteresCompletos === "MAMO" || caracteresCompletos === "MXMO"
                            || caracteresCompletos === "CACO" || caracteresCompletos === "CXCO" || caracteresCompletos === "MEAR" || caracteresCompletos === "MXAR" || caracteresCompletos === "CAGA"
                            || caracteresCompletos === "CXGA" || caracteresCompletos === "MEAS" || caracteresCompletos === "MXAS" || caracteresCompletos === "CAGO" || caracteresCompletos === "CXGO"
                            || caracteresCompletos === "MEON" || caracteresCompletos === "MXON" || caracteresCompletos === "CAKA" || caracteresCompletos === "CXKA" || caracteresCompletos === "MIAR"
                            || caracteresCompletos === "MXAR" || caracteresCompletos === "CAKO" || caracteresCompletos === "CXKO" || caracteresCompletos === "MION" || caracteresCompletos === "MXON"
                            || caracteresCompletos === "COGE" || caracteresCompletos === "CXGE" || caracteresCompletos === "MOCO" || caracteresCompletos === "MXCO" || caracteresCompletos === "COGI"
                            || caracteresCompletos === "CXGI" || caracteresCompletos === "MOKO" || caracteresCompletos === "MXKO" || caracteresCompletos === "COJA" || caracteresCompletos === "CXJA"
                            || caracteresCompletos === "MULA" || caracteresCompletos === "MXLA" || caracteresCompletos === "COJE" || caracteresCompletos === "CXJE" || caracteresCompletos === "MULO"
                            || caracteresCompletos === "MXLO" || caracteresCompletos === "COJI" || caracteresCompletos === "CXJI" || caracteresCompletos === "NACA" || caracteresCompletos === "NXCA"
                            || caracteresCompletos === "COJO" || caracteresCompletos === "CXJO" || caracteresCompletos === "NACO" || caracteresCompletos === "NXCO" || caracteresCompletos === "COLA"
                            || caracteresCompletos === "CXLA" || caracteresCompletos === "PEDA" || caracteresCompletos === "PXDA" || caracteresCompletos === "CULO" || caracteresCompletos === "CXLO"
                            || caracteresCompletos === "PEDO" || caracteresCompletos === "PXDO" || caracteresCompletos === "FALO" || caracteresCompletos === "FXLO" || caracteresCompletos === "PENE"
                            || caracteresCompletos === "PXNE" || caracteresCompletos === "FETO" || caracteresCompletos === "FXTO" || caracteresCompletos === "PIPI" || caracteresCompletos === "PXPI"
                            || caracteresCompletos === "GETA" || caracteresCompletos === "GXTA" || caracteresCompletos === "PITO" || caracteresCompletos === "PXTO" || caracteresCompletos === "GUEI"
                            || caracteresCompletos === "GXEI" || caracteresCompletos === "POPO" || caracteresCompletos === "PXPO" || caracteresCompletos === "GUEY" || caracteresCompletos === "GXEY"
                            || caracteresCompletos === "PUTA" || caracteresCompletos === "PXTA" || caracteresCompletos === "JETA" || caracteresCompletos === "JXTA" || caracteresCompletos === "PUTO"
                            || caracteresCompletos === "PXTO" || caracteresCompletos === "JOTO" || caracteresCompletos === "JXTO" || caracteresCompletos === "QULO" || caracteresCompletos === "QXLO"
                            || caracteresCompletos === "KACA" || caracteresCompletos === "KXCA" || caracteresCompletos === "RATA" || caracteresCompletos === "RXTA" || caracteresCompletos === "KACO"
                            || caracteresCompletos === "KXCO" || caracteresCompletos === "ROBA" || caracteresCompletos === "RXBA" || caracteresCompletos === "KAGA" || caracteresCompletos === "KXGA"
                            || caracteresCompletos === "ROBE" || caracteresCompletos === "RXBE" || caracteresCompletos === "KAGO" || caracteresCompletos === "KXGO" || caracteresCompletos === "ROBO"
                            || caracteresCompletos === "RXBO" || caracteresCompletos === "KAKA" || caracteresCompletos === "KXKA" || caracteresCompletos === "KXKA" || caracteresCompletos === "RUIN"
                            || caracteresCompletos === "RXIN" || caracteresCompletos === "KAKO" || caracteresCompletos === "KXKO" || caracteresCompletos === "SENO" || caracteresCompletos === "SXNO"
                            || caracteresCompletos === "KOGE" || caracteresCompletos === "KXGE" || caracteresCompletos === "TETA" || caracteresCompletos === "TXTA" || caracteresCompletos === "KOGI"
                            || caracteresCompletos === "KXGI" || caracteresCompletos === "VACA" || caracteresCompletos === "VXCA" || caracteresCompletos === "KOJA" || caracteresCompletos === "KXJA"
                            || caracteresCompletos === "VAGA" || caracteresCompletos === "VXGA" || caracteresCompletos === "KOJE" || caracteresCompletos === "KXJE" || caracteresCompletos === "VAGO"
                            || caracteresCompletos === "VXGO" || caracteresCompletos === "KOJI" || caracteresCompletos === "KXJI" || caracteresCompletos === "VAKA" || caracteresCompletos === "VXKA"
                            || caracteresCompletos === "KOJO" || caracteresCompletos === "KXJO" || caracteresCompletos === "VUEI" || caracteresCompletos === "VXEI" || caracteresCompletos === "KOLA"
                            || caracteresCompletos === "KXLA" || caracteresCompletos === "VUEY" || caracteresCompletos === "VXEY" || caracteresCompletos === "KULO" || caracteresCompletos === "KXLO"
                            || caracteresCompletos === "WUEI" || caracteresCompletos === "WXEI" || caracteresCompletos === "LILO" || caracteresCompletos === "LXLO" || caracteresCompletos === "WUEY"
                            || caracteresCompletos === "WXEY" || caracteresCompletos === "LOCA" || caracteresCompletos === "LXCA")
                    {
                        s2 = "X";
                    }
                    var fecha = $('input:text[name=fecha]').val();
                    var fechaSplit = fecha.split("-");
                    var s5 = fechaSplit[0];
                    var separa = s5.substring(2, 4);
                    var s6 = fechaSplit[1];
                    var s7 = fechaSplit[2];
                    console.log(s1 + " " + s2 + " " + s3 + " " + s4 + " " + separa + " " + s6 + " " + s7 + " " + sexo + " " + edo + " " + s8 + " " + s9 + " " + s10);
                    document.getElementById('curp').value = s1 + s2 + s3 + s4 + separa + s6 + s7 + sexo + edo + s8 + s9 + s10;
                } else {
                    alert("Complete todos los campos para generar el segmento raíz del alumno.");
                }

            }
        </script>
    </body>
</html>
