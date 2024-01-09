<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        HttpSession sesion = request.getSession();
        String nombre = (String) sesion.getAttribute("usuario");
        if (sesion.getAttribute("usuario") == null) {
            response.sendRedirect("logindir.jsp");
        }
        String context = request.getContextPath();
        String grado = null;
        String curp = request.getAttribute("curp") != null ? (String) request.getAttribute("curp") : null;
        String nombre1 = request.getAttribute("nombre") != null ? (String) request.getAttribute("nombre") : null;
        String paterno = request.getAttribute("paterno") != null ? (String) request.getAttribute("paterno") : null;
        String materno = request.getAttribute("materno") != null ? (String) request.getAttribute("materno") : null;
        String ct = request.getAttribute("ct") != null ? (String) request.getAttribute("ct") : null;
        String fecha_nac = "20" + curp.substring(4, 6) + "-" + curp.substring(6, 8) + "-" + curp.substring(8, 10);
        String sexo = curp.substring(10, 11);
        String edo_nac = curp.substring(11, 13);
        String bandera = request.getAttribute("bandera") != null ? (String) request.getAttribute("bandera") : null;
        
        if(bandera.equals("1")){
        grado = "1";
        }
        switch (Integer.parseInt(curp.substring(4, 6))) {
            case 11:
                grado = "1";
                break;
            case 10:
                grado = "1";
                break;
            case 9:
                grado = "1";
                break;
            case 8:
                grado = "1";
                break;
            case 7:
                grado = "1";
                break;
            case 6:
                grado = "1";
                break;    
        }
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
    <body>
        <!-- Header -->
        <%@include file="header.jsp"%>
        <div id="border-top"></div>
        <!-- Index -->
        <form class="form-signin" action="<%=context%>/ServletProcDatosPreinscribirDir" method="post" onsubmit="return validacion()">
            <div class="jumbotron">
                <div class="container">
                    <div class="row justify-content-md-center">
                        <div class="col-xs-12">
                            <%@include file="formdatos_alumnos_dir.jsp"%>    
                        </div> 
                        <input type="hidden" id="curp" name="curp" value="<%=curp%>" />
                        <input type="hidden" id="paterno" name="paterno" value="<%=paterno%>" />
                        <input type="hidden" id="materno" name="materno" value="<%=materno%>" />
                        <input type="hidden" id="nombre" name="nombre" value="<%=nombre1%>" />
                        <input type="hidden" id="sexo" name="sexo" value="<%=sexo%>" />
                        <input type="hidden" id="fecha_nac" name="fecha_nac" value="<%=fecha_nac%>" />
                        <input type="hidden" id="edo_nac" name="edo_nac" value="<%=edo_nac%>" />
                        <input type="hidden" id="grado" name="grado" value="<%=grado%>" />
                        <input type="hidden" id="ct" name="ct" value="<%=ct%>" />
                        <input type="hidden" name="contexto" id="contexto" value="<%=context%>"/>
                    </div>
                </div>
            </div>
        </form>  
        <!-- Footer -->
        <%@include file="footer.jsp" %>
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
                    $('#apPaterno').val('');
                    $('#apMaterno').val('');
                    $('#fechanac').val('');
                    $('#entidad').val('');
                    $('#sexoT').val('');
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
