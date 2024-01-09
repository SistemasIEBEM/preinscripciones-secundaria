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
        <div class="jumbotron" id="slider">
            <div class="container">
                <center>
                    <p style="font-weight:bold" class="blackboard">
                        EN ESTE M&Oacute;DULO USTED PUEDE PRE INSCRIBIR ALUMNOS, INCLUSO SI NO LE CORRESPONDE A LA LETRA INICIAL DE SU CURP EL DIA DE HOY.
                    </p>
                    <p class="blackboard">
                        Para comenzar capture la CURP del alumno y de clic en el bot&oacute;n 
                        <font style="font-weight:bold">"CONTINUAR"</font>
                    </p>
                    <p class="blackboard">
                        En caso de no contar con la CURP del alumno de clic en el bot&oacute;n 
                        <font style="font-weight:bold">"PRE-INSCRIBIR SIN CURP"</font>
                    </p>
                    <p class="blackboard">
                        ** Si al ingresar la CURP el sistema no responde, favor de utilizar otro navegador ( Recomendamos - <a href="https://www.mozilla.org/es-MX/firefox/download/thanks/" target="_blank" style="color: #c12e2a">MOZILLA FIREFOX</a>), ya que actualmente Google Chrome presenta algunos errores de incompatibilidad. Gracias.
                    </p>
                </center>
                <div class="row justify-content-md-center">                      
                    <div class="col-md-6 col-md-offset-3">
                        <div class="container" id="login-form">
                            <div class="container">
                                <div class="login login-container">
                                    <%@include file="peticionDir.jsp"%>                                                                           
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Modal -->
        <%@include file="ayuda3.jsp"%>     
        <!-- Footer -->
        <%@include file="footer.jsp" %>
        <script type="text/javascript">
            $(document).ready(function () {
                $('#skel-layers-visibleWrapper').remove();
            });
        </script>
    </body>
</html>