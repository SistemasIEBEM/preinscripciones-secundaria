<%-- 
    Document   : datos_personales
    Created on : 8/01/2017, 09:09:14 PM
    Author     : Mike
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        String context = request.getContextPath();
        String folio = request.getAttribute("folio") != null ? (String) request.getAttribute("folio") : "";
        String curp = request.getAttribute("curp") != null ? (String) request.getAttribute("curp") : "";
        String nombre = request.getAttribute("nombre") != null ? (String) request.getAttribute("nombre") : "";
        String paterno = request.getAttribute("paterno") != null ? (String) request.getAttribute("paterno") : "";
        String materno = request.getAttribute("materno") != null ? (String) request.getAttribute("materno") : "";
        String ct = request.getAttribute("ct") != null ? (String) request.getAttribute("ct") : "";
        String Ct_nombre = request.getAttribute("Ct_nombre") != null ? (String) request.getAttribute("Ct_nombre") : "";
        String Ct_direccion = request.getAttribute("Ct_direccion") != null ? (String) request.getAttribute("Ct_direccion") : "";
        String Ct_turno = request.getAttribute("Ct_turno") != null ? (String) request.getAttribute("Ct_turno") : "";
    %>   
    <head>
        <link rel="shortcut icon" href="<%=context%>/images/iebem.ico">
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <meta name="description" content="" />
        <meta name="keywords" content="" />
        <%@include file="snippets/generalcssjs.jsp"%>
        <script src="<%=context%>/js/funciones/validar_campos.js"></script>
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
        <form class="form-signin" action="<%=context%>/ServletProcDatosPreinscribir" method="post" onsubmit="return validacion()">
            <div class="jumbotron">
                <div class="container">
                    <div class="row">                      
                        <div class="col-xs-12">
                            <center>
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
                                        <td style="font-weight:bold; width:200px">CURP del padre ó tutor:<font color="red">*</font></td>
                                        <td>
                                            <!--<div class="col-md-6">
                                                <input type="text" class="form-control" placeholder="Ingrese su CURP" aria-label="Ingrese su CURP" aria-describedby="basic-addon2" onkeyup="mayus(this);" name="curpT" id="curpT">
                                            </div>
                                            <div class="col-md-6">
                                                <button class="btn btn-outline-secondary btn-danger" type="button" onclick="consultar(document.getElementById('curpT').value)">Consultar</button>
                                            </div>-->
                                            <div class="input-group">
                                                <div class="input-group-prepend">
                                                    <button class="btn btn-outline-primary" type="button" onclick="consultar(document.getElementById('curpT').value)">Consultar</button>
                                                </div>
                                                <input type="text" class="form-control" placeholder="Ingrese su CURP" aria-label="Ingrese su CURP" aria-describedby="basic-addon2" onkeyup="mayus(this);" name="curpT" id="curpT" maxlength="18">
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>  
                                    <h1 style="font-size: 14px; font-weight:bold;">
                                        "Para consultar su CURP, acceda a la siguiente dirección: <a href="https://www.gob.mx/curp" target="_blank">https://www.gob.mx/curp</a>".
                                    </h1>
                                    </tr>
                                    <tr>
                                        <td style="font-weight:bold; width:200px">Nombre:<font color="red">*</font></td>
                                        <td>
                                            <input id="nombreT" name="nombreT" size="67" onkeyup="mayus(this);" class="form-control" readonly/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td style="font-weight:bold; width:200px">Apellido paterno:<font color="red">*</font></td>
                                        <td>
                                            <input id="apPaterno" name="apPaterno" size="67" onkeyup="mayus(this);" class="form-control" readonly/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td style="font-weight:bold; width:200px">Apellido materno:<font color="red">*</font></td>
                                        <td>
                                            <input id="apMaterno" name="apMaterno" size="67" onkeyup="mayus(this);" class="form-control" readonly/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td style="font-weight:bold; width:200px">Entidad de nacimiento:<font color="red">*</font></td>
                                        <td>
                                            <input id="entidad" name="entidad" size="67" onkeyup="mayus(this);" class="form-control" readonly/>
                                        </td>
                                    </tr>                                    
                                    <tr>
                                        <td style="font-weight:bold; width:200px">Fecha nacimiento:<font color="red">*</font></td>
                                        <td>
                                            <input id="fechanac" name="fechanac" size="67" onkeyup="mayus(this);" class="form-control" readonly/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td style="font-weight:bold; width:200px">Sexo:<font color="red">*</font></td>
                                        <td>
                                            <input id="sexo" name="sexo" size="67" onkeyup="mayus(this);"class="form-control" readonly/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td style="font-weight:bold; width:200px">Municipio:<font color="red">*</font></td>
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
                                        <td style="font-weight:bold; width:200px">Telefono:</td>
                                        <td>
                                            <input id="telefono" name="telefono" size="16" maxlength="10" onkeypress="ValidaSoloNumeros()" class="form-control" disabled/>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                            <input type="hidden" name="curp" id="curp" value="<%=curp%>  "/>
                            <input type="hidden" name="folio" id="folio" value="<%=folio%>  "/>
                            <input type="hidden" name="nombre" id="nombre" value="<%=nombre%>  "/>
                            <input type="hidden" name="ct" id="ct" value="<%=ct%>  "/>
                            <input type="hidden" name="ct_nombre" id="ct_nombre" value="<%=Ct_nombre%>  "/>
                            <input type="hidden" name="ct_direccion" id="ct_direccion" value="<%=Ct_direccion%>"/>
                            <input type="hidden" name="turno" id="turno" value="<%=Ct_turno%>  "/>
                            <input type="hidden" name="contexto" id="contexto" value="<%=context%>"
                            <hr>
                            <div class="col">
                                <button class="btn btn-primary" type="submit" id="botonPre">
                                    GUARDAR
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
        <!-- Footer -->
        <%@include file="footer.jsp" %>
        <script type="text/javascript">
            $(document).ready(function () {
                $('#skel-layers-visibleWrapper').remove();
            });
        </script>
        <script type="text/javascript">
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
                                            $('#apPaterno').val(consulta.parametros.apellidoPaterno);
                                            $('#apMaterno').val(consulta.parametros.apellidoMaterno);
                                            $('#fechanac').val(consulta.parametros.fechaNacimiento);
                                            $('#entidad').val(consulta.parametros.claveEntidadNacimiento);
                                            $('#sexo').val(consulta.parametros.sexo);
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
                    $('#apPaterno').val('');
                    $('#apMaterno').val('');
                    $('#fechanac').val('');
                    $('#entidad').val('');
                    $('#sexo').val('');
                    $('#municipio').val('');
                    $('#domicilio').val('');
                    $('#correo').val('');
                    $('#telefono').val('');
                    alert("Ingrese un registro válido en el campo CURP");
                }
            }
        </script>
    </body>
</html>

