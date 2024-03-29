<%-- 
    Document   : Buscardatos
    Created on : 27/12/2016, 05:36:52 PM
    Author     : david
--%>

<%@page import="Bean.Beansupervisor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        String context = request.getContextPath();
        HttpSession sesion = request.getSession();
        Beansupervisor nombre = (Beansupervisor) sesion.getAttribute("usuario");
        if (sesion.getAttribute("usuario") == null) {
            response.sendRedirect("loginadmin.jsp");
        }


    %>
    <head>
        <link rel="shortcut icon" href="<%=context%>/images/iebem.ico">
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <meta name="description" content="" />
        <meta name="keywords" content="" />
        <%@include file="snippets/generalcssjs.jsp"%>
        <script src="<%=context%>/js/funciones/tabladatosescuela.js"></script>
        <script src="<%=context%>/js/funciones/validaCT.js"></script>
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
        <form class="form-signin" onchange="return validactcontra();" >
            <!-- Header -->
            <%@include file="header.jsp"%>
            <div id="border-top"></div>
            <!-- Index -->
            <div class="container">
                <div class="login form-container" id="InputText">
                    <center><h3><b>ADMINISTRADOR</b></h3></center>
                    <center><h4><b>USUARIO:</h4> <h5><%=nombre.getCt()%> </b></h5></center>
                    <center><b><h4>NOMBRE DEL USUARIO:</h4> <h5><%=nombre.getNombrect()%> </b></h5></center>
                    <br>
                    <div class="row" >
                        <div class="col-md-6 col-md-offset-3">
                            <a class="btn btn-danger btn-block" href="<%=context%>/salir1.jsp">
                                <i class="fas fa-outdent"></i> 
                                SALIR
                            </a>
                        </div>
                        <div class="col-md-6 col-md-offset-3">
                            <a class="btn btn-success btn-block" href="<%=context%>/menuadmin.jsp">
                                <i class="fas fa-reply"></i> 
                                REGRESAR
                            </a>
                        </div>
                    </div>
                </div>
                <div class="login form-container" id="InputText">
                    <center><h5><b>INTRODUZCA LA CLAVE DE CENTRO DE TRABAJO PARA MOSTRAR SUS DATOS.</b></h5></center>
                    <center>
                        <input type="text"  placeholder="EJEMPLO: 17DPR0001J" name="ct" id="ct" onchange="muestraCT()" style="text-transform:uppercase;">
                    </center>
                    <br>

                </div>
            </div>
            <div id="txtHint"></div>
            <!-- Footer -->
            <%@include file="footer.jsp" %>
            <script type="text/javascript">
                $(document).ready(function () {
                    $('#skel-layers-visibleWrapper').remove();
                });
            </script>
        </form>
    </body>
</html>
