<%-- 
    Document   : folioConsulta
    Created on : 13/01/2017, 09:21:31 AM
    Author     : Registro
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Bean.BeanPreinscribirPadres"%>
<%@page import="DaoImpl.Fachada"%>
<!DOCTYPE html>
<html>
    <%
        String context = request.getContextPath();
        String curp = request.getAttribute("curp") != null ? (String) request.getAttribute("curp") : "";
        Fachada facha = new Fachada();
        BeanPreinscribirPadres datosFolio = facha.getFolio(curp);
        String folio = datosFolio.getFolio();
        String nombre = datosFolio.getNombre();
        String paterno = datosFolio.getPaterno();
        String materno = datosFolio.getMaterno();
        String ct = datosFolio.getCt();
        String Ct_nombre = datosFolio.getNombre_ct();
        String Ct_direccion = datosFolio.getDireccion();
        String Ct_turno = datosFolio.getTurno();
        String cadena = folio + " / " + curp + " / " + nombre + " / " + ct;
        String fecha = request.getAttribute("fecha") != null ? (String) request.getAttribute("fecha") : "";
        nombre = nombre + " " + paterno + " " + materno;
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="<%=context%>/images/iebem.ico">
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
        <div id="border-top" class="d-print-none"></div>
        <div class="d-none d-print-block">
            <div class="row">
                <div class="col-md-6 text-center">
                    <img src="images/logo_nuevo.png" style="height: 135px; width: 1100px;"/>
                </div>
            </div>
        </div>
        <!-- Index -->
        <div class="jumbotron">
            <!--<div class="container">-->
            <div class="row justify-content-md-center">                      
                <div class="col-xs-12">
                    <center>
                        <h1 style="font-size: 22px; font-weight:bold;">
                            COMPROBANTE DE PRE-INSCRIPCI&Oacute;N AL CICLO ESCOLAR <%=ciclo%>
                        </h1>
                        <%if (datosFolio.getFolio() == null) {%>
                        <h1 style="font-size: 24px; font-weight:bold;">
                            <strong>¡ERROR!</strong>
                        </h1>
                        <br />
                        <h3>El alumno no se encuentra aún pre-inscrito en ningún plantel educativo.</h3>
                        <br/>
                        <div class="col-lg-12">
                            <div class="col-md-6 col-md-offset-3">
                                <img src="images/regresar.png" onclick="location.href = 'index.jsp';"/>
                            </div>
                        </div>
                        <br/>
                        <br/>
                        <%} else {%>
                        <h1 style="font-size: 24px; font-weight:bold;">
                            FOLIO:<%=folio%>
                        </h1>
                        <br />
                        <h1 style="font-size: 20px; font-weight:bold;">
                            FECHA Y HORA DE REGISTRO:<%=fecha%> 
                        </h1>
                        <div class="text-justify">
                            <h3>El presente documento es el comprobante de pre-inscripci&oacute;n del alumno <%=nombre%> con clave CURP <%=curp.trim()%>. El alumno se encuentra pre-inscrito en la escuela "<%=Ct_nombre%>" con clave <%=ct.trim()%> turno <%=Ct_turno%> con domicilio, <%=Ct_direccion.trim()%>.</h3>
                            <h3>El alumno deber&aacute; presentarse a la escuela con este comprobante el d&iacute;a que realice su inscripci&oacute;n.</h3>
                        </div>
                        <div class="d-print-none">
                            <img src="https://chart.googleapis.com/chart?chs=150x150&cht=qr&chl=<%=cadena%>&choe=UTF-8" title="Link to Google.com" />        
                        </div>
                        <div class="d-none d-print-block">
                            <br/>
                            <br/>
                            <br/>
                            <div class="row">
                                <div class="col">
                                    <img src="images/escudo_secretaria.png" style="height: 80px; width: 300px;"/>
                                </div>
                                <div class="col">
                                    <img src="https://chart.googleapis.com/chart?chs=150x150&cht=qr&chl=<%=cadena%>&choe=UTF-8" title="Link to Google.com" style="height: 80px; width: 100px;"/>
                                    <h3 style="font-size: 20px;">
                                        <b>"La realizaci&oacute;n de este tr&aacute;mite es gratuito"</b>
                                    </h3>
                                </div>
                                <div class="col">
                                    <img src="images/logoSIPREEB.png" style="height: 80px; width: 300px;"/>
                                </div>
                                <div class="col-lg-12">
                                    <img src="images/pleca_docto.png" style="height: 110px; width: 1060px;"/>
                                </div>
                            </div>
                        </div>
                        <br/>
                        <!--<div class="col-lg-12">-->
                        <div class="d-print-none">
                            <div class="row">
                                <div class="col">
                                    <img src="images/imprimir.png" onclick="window.print();" />
                                </div>     
                                <div class="col">
                                    <img src="images/regresar.png" onclick="location.href = 'index.jsp';"/>
                                </div> 
                            </div>
                        </div>
                        <!--</div>-->
                        <br/>
                        <br/>
                        <%}%>
                        <div class="d-print-none">
                            <h3>
                                <b>"La realizaci&oacute;n de este tr&aacute;mite es gratuito"</b>
                            </h3>
                        </div>
                    </center>
                </div>
            </div>
            <!--</div>-->
        </div>  
        <!-- Footer -->
        <footer id="footer-wrapper" class="d-print-none">
            <div id="border-bottom"></div>
            <div class="row">
                <!--<div class="col-lg-12">-->
                <div class="col">
                    <p style="text-align:center;">
                        <img src="<%=context%>/images/escudo_secretaria.png" class="img-responsive" id="logosec">
                    </p>
                </div>
                <!--<div class="col-lg-3 col-md-4 col-md-offset-1">
                <p style="text-align:center;">
                        <img src="<%=context%>/images/logoVision.png" class="img-responsive" id="logovision">
                <p>
                </div>-->
                <div class="col">
                    <h4>Teléfonos:</h4>
                    <p><a title="Contactanos!"><i class="fa fa-phone"></i> (777) 317 34 52, 317 03 11,  (777)102 01 12 ó (777) 101 36 17</a></p>
                </div>
                <div class="col">
                    <h4>Redes Sociales:</h4>
                    <a href="https://www.facebook.com/IEBEMDirecci%C3%B3n-de-Planeaci%C3%B3n-Educativa-143152726037204"  target="_blank" title="Facebook" class="noline">
                        <span class="fa-stack fa-lg">
                            <i class="fas fa-link"></i>
                        </span>
                        <b>Dirección de Planeación Educativa</b>
                    </a>
                </div>
            </div>
            <hr>
            <!--<div class="col-lg-12">-->
            <p class="text-center">
                Instituto de la Educaci&oacute;n B&aacute;sica del Estado de Morelos
                <br/>
                Subdirecci&oacute;n de Inform&aacute;tica
                <br/>
                Calle Nueva China, sin n&uacute;mero. Col. Lomas de Cort&eacute;s, Cuernavaca, Morelos. C.P. 62240.
                <br/>
                Copyright © 2022
            </p>
            <!--</div>-->
            <!--</div>-->
            <script>
                (function (i, s, o, g, r, a, m) {
                    i['GoogleAnalyticsObject'] = r;
                    i[r] = i[r] || function () {
                        (i[r].q = i[r].q || []).push(arguments)
                    }, i[r].l = 1 * new Date();
                    a = s.createElement(o),
                            m = s.getElementsByTagName(o)[0];
                    a.async = 1;
                    a.src = g;
                    m.parentNode.insertBefore(a, m)
                })(window, document, 'script', '//www.google-analytics.com/analytics.js', 'ga');

                ga('create', 'UA-47756308-1', 'auto');
                ga('send', 'pageview');

            </script> 
        </footer>
        <script type="text/javascript">
            $(document).ready(function () {
                $('#skel-layers-visibleWrapper').remove();
            });
        </script>
    </body>
</html>
