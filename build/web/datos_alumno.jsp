<%@page import="DaoImpl.FachadaPadres"%>
<%@page import="Bean.BeanEscuela"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%  String context = request.getContextPath();
        String curp = request.getAttribute("curp") != null ? (String) request.getAttribute("curp") : null;
        String nombre = request.getAttribute("nombre") != null ? (String) request.getAttribute("nombre") : null;
        String paterno = request.getAttribute("paterno") != null ? (String) request.getAttribute("paterno") : null;
        String materno = request.getAttribute("materno") != null ? (String) request.getAttribute("materno") : null;
        String fecha_nac = request.getAttribute("fecha_nac") != null ? (String) request.getAttribute("fecha_nac") : null;
        String sexo = request.getAttribute("sexo") != null ? (String) request.getAttribute("sexo") : null;
        String edo_nac = request.getAttribute("edo_nac") != null ? (String) request.getAttribute("edo_nac") : null;
        String grado = request.getAttribute("grado") != null ? (String) request.getAttribute("grado") : null;
        String ct = request.getAttribute("ct") != null ? (String) request.getAttribute("ct") : null;
        String Ct_nombre = request.getAttribute("Ct_nombre") != null ? (String) request.getAttribute("Ct_nombre") : null;
        String Ct_direccion = request.getAttribute("Ct_direccion") != null ? (String) request.getAttribute("Ct_direccion") : null;
        String Ct_turno = request.getAttribute("Ct_turno") != null ? (String) request.getAttribute("Ct_turno") : null;
    %>
    <head>
        <link rel="shortcut icon" href="<%=context%>/images/iebem.ico">
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <meta name="description" content="" />
        <meta name="keywords" content="" />
        <%@include file="snippets/generalcssjs.jsp"%>
        <style type="text/css">
            body {
                overflow-x:hidden;
            }
        </style>
    </head>
    <body>
        <!-- Header -->
        <%@include file="header.jsp"%>
        <div id="border-top"></div>
        <!-- Index -->
        <form class="form-signin" action="<%=context%>/ServletDatosPersonales" onsubmit="return valida()" method="post">
            <div class="jumbotron">
                <div class="container">
                    <div class="row">     
                        <div class="container centered">
                            <table class="table table-hover">
                                <tbody>
                                    <tr>
                                        <td style="font-weight:bold;">CURP: <%=curp%></td>
                                        <td style="font-weight:bold;">CLAVE DE LA ESCUELA: <%=ct%></td>
                                    </tr>
                                    <tr>
                                        <td style="font-weight:bold;">NOMBRE(S): <%=nombre%></td>
                                        <td style="font-weight:bold;">NOMBRE: <%=Ct_nombre%></td>
                                    </tr>
                                    <tr>
                                        <td style="font-weight:bold;">PRIMER APELLIDO: <%=paterno%></td>
                                        <td style="font-weight:bold;">DIRECCIÓN: <%=Ct_direccion%></td>
                                    </tr>
                                    <tr>
                                        <td style="font-weight:bold;">SEGUNDO APELLIDO: <%=materno%></td>
                                        <td style="font-weight:bold;">TURNO: <%=Ct_turno%></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="col-lg-12">
                            <h3>
                                <center>
                                    OPCIONES PARA ELEGIR ESCUELA DESTINO
                                </center>
                            </h3>
                            <div class="table-responsive">
                                <table id="tablaPrincipal" class="table table-bordered table-striped table-condensed">
                                    <thead>
                                        <tr class="info">
                                            <th>CT</th>               
                                            <th>NOMBRE</th>    
                                            <th>DIRECCION</th>
                                            <th>MUNICIPIO</th>
                                            <th>TURNO</th>               
                                            <th>Seleccione</th> 
                                        </tr>
                                    </thead>
                                    <tbody id="cuerpotablaPrincipal"></tbody>
                                </table>
                            </div>
                        </div>
                        <div class="col-lg-12 text-center">
                            <div class="alert alert-success alert-dismissible fade show" role="alert">
                                <h4>Si los datos son correctos haga clic en el botón "PRE-INSCRIBIR", si no son correctos haga clic en el botón "REGRESAR".</h4>                            
                            </div>
                            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                                <h4>Una vez presionado el botón "PRE-INSCRIBIR" el alumno queda pre inscrito en el sistema.</h4>                            
                            </div>
                        </div>
                        <!--<div class="col-lg-12">-->
                        <div class="col">
                            <button id="botonPre" class="btn btn-primary" name="botonPre" type="submit">
                                <i class="fas fa-save"></i> 
                                PRE-INSCRIBIR
                            </button>
                        </div>
                        <div class="col">
                            <button class="btn btn-danger" type="reset" id="botonPre" onclick="location.href = 'index.jsp';">
                                <i class="fas fa-reply"></i> 
                                REGRESAR
                            </button>
                        </div>
                        <!--</div>-->
                        <input type="hidden" value="<%=context%>" name="contexto" id="contexto"/>
                        <input type="hidden" id="curp" name="curp" value="<%=curp%>" />
                        <input type="hidden" id="paterno" name="paterno" value="<%=paterno%>" />
                        <input type="hidden" id="materno" name="materno" value="<%=materno%>" />
                        <input type="hidden" id="nombre" name="nombre" value="<%=nombre%>" />
                        <input type="hidden" id="fechaNac" name="fechaNac" value="<%=fecha_nac%>" />
                        <input type="hidden" id="sexo" name="sexo" value="<%=sexo%>" />
                        <input type="hidden" id="edonac" name="edonac" value="<%=edo_nac%>" />
                        <input type="hidden" id="ct" name="ct" value="<%=ct%>" />
                        <input type="hidden" id="grado" name="grado" value="<%=grado%>" />
                        <input type="hidden" id="modo" name="modo" value="1" />
                    </div>
                </div>
            </div>
        </form>
        <!-- Footer -->
        <%@include file="footer.jsp" %>
        <script type="text/javascript">
            $(document).ready(function () {
                $('#skel-layers-visibleWrapper').remove();
                var ct = $('#ct').val();
                var context = $('#contexto').val();
                $.getJSON(context + '/dato?accion=4', {ct: ct}, function (data) {
                    //console.log(data);
                    $('#cuerpotablaPrincipal').remove();
                    var cuerpoT = '<tbody id="cuerpotablaPrincipal">';
                    for (DatosCCT in data.parametros) {
                        if (data.parametros[DatosCCT].Seleccione === 'VACANTE') {
                            cuerpoT += "<tr>"
                                    + "<td>" + data.parametros[DatosCCT].ct + "</td>"
                                    + "<td>" + data.parametros[DatosCCT].nombre + "</td>"
                                    + "<td>" + data.parametros[DatosCCT].direccion + "</td>"
                                    + "<td>" + data.parametros[DatosCCT].municipio + "</td>"
                                    + "<td>" + data.parametros[DatosCCT].turno + "</td>"
                                    + "<td style='text-align: center;'><input type='radio' name='ct_registro' id='ct_registro' value='" + data.parametros[DatosCCT].ct + "'/></td>"
                                    + "</tr>";
                        } else {
                            cuerpoT += "<tr>"
                                    + "<td style='background-color: red; color: white;'>" + data.parametros[DatosCCT].ct + "</td>"
                                    + "<td style='background-color: red; color: white;'>" + data.parametros[DatosCCT].nombre + "</td>"
                                    + "<td style='background-color: red; color: white;'>" + data.parametros[DatosCCT].direccion + "</td>"
                                    + "<td style='background-color: red; color: white;'>" + data.parametros[DatosCCT].municipio + "</td>"
                                    + "<td style='background-color: red; color: white;'>" + data.parametros[DatosCCT].turno + "</td>"
                                    + "<td style='background-color: red; color: white; text-align: center;'><input type='radio' name='ct_registro' id='ct_registro' value='" + data.parametros[DatosCCT].ct + "'/></td>"
                                    + "</tr>";
                        }
                    }
                    $('#tablaPrincipal').append(cuerpoT + '</tbody>');
                    $('#tablaPrincipal').DataTable({
                        "language": {
                            "url": "js/datatable/lenguaje/Spanish.json"
                        },
                        "ordering": false,
                        "dom": '<"toolbar">frtip',
                        "scrollY": 640,
                        scrollCollapse: true,
                        "order": [[2, 'asc']],
                        "bFilter": false,
                        "bPaginate": false,
                        "bInfo": false
                    });
                });
            });</script>
        <script type="text/javascript">
            function valida() {
                opciones = document.getElementsByName("ct_registro");
                var seleccionado = false;
                for (var i = 0; i < opciones.length; i++) {
                    if (opciones[i].checked) {
                        seleccionado = true;
                        break;
                    }
                }
                if (!seleccionado) {
                    alert("Debe seleccionar  una clave de escuela valida");
                    document.getElementById('ct_registro').focus();
                    return false;
                }
            }
        </script>
    </body>
</html>
