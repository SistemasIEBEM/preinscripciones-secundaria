<%-- 
    Document   : menuadmin
    Created on : 10-ene-2017, 10:08:28
    Author     : David Costet
--%>


<%@page import="java.util.Calendar"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.List"%>
<%@page import="Bean.BeanCT"%>
<%@page import="Bean.Beansupervisor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <% String context = request.getContextPath();
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
        <script src="<%=context%>/js/funciones/tabla_listado_escuelas.js"></script>
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
                if (e.keyCode === 8) {
                    return false;
                }
            };
        </script>
        <script>

            var f = new Date();
            var fecha1 = (f.getFullYear() + "/" + (f.getMonth() + 1) + "/" + f.getDate());


        </script>
        <%
            Calendar fecha = Calendar.getInstance();

            int año = fecha.get(Calendar.YEAR);
            int mes = fecha.get(Calendar.MONTH) + 1;
            int dia = fecha.get(Calendar.DAY_OF_MONTH);
            int hora = fecha.get(Calendar.HOUR_OF_DAY);
            int minuto = fecha.get(Calendar.MINUTE);
            int segundo = fecha.get(Calendar.SECOND);

            String fechacompleta = año + "-" + mes + "-" + dia;
        %>
    </head>
    <body onload="nobackbutton();">
        <form class="form-signin">
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
                    <div class="row justify-content-md-center" >
                        <div class="col">
                            <a class="btn btn-danger btn-block" href="<%=context%>/salir1.jsp">
                                <i class="fas fa-outdent"></i> 
                                SALIR
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <% if (nombre.getCt().equals("17ADG0034F")) {%>
            <div class="container">
                <div class="col">
                    <a class="btn btn-success btn-block" href="<%=context%>/lugares?valida=3&&fecha=<%=fechacompleta%>">
                        <i class="fas fa-cogs"></i> 
                        ESTADISTICAS
                    </a>
                    <br>
                </div>
            </div>
            <% } else {%>
            <div class="container">
                <div class="col">
                    <a class="btn btn-primary btn-block" href="<%=context%>/Buscardatos.jsp">
                        <i class="fas fa-search"></i> 
                        CONSULTAR DATOS DEL PLANTEL
                    </a>
                    <br>
                </div>
                <div class="col">
                    <a class="btn btn-info btn-block" href="<%=context%>/administrar_lugares.jsp">
                        <i class="fas fa-cog"></i> 
                        ADMINISTRAR LUGARES
                    </a>
                    <br>
                </div>
                <div class="col">
                    <a class="btn btn-default btn-block" href="<%=context%>/consultaorigen.jsp">
                        <i class="fa fa-barcode"></i> 
                        CONSULTAR ORIGEN-DESTINO
                    </a>
                    <br>
                </div>
                <div class="col">
                    <a class="btn btn-danger btn-block" href="<%=context%>/origen-destino.jsp">
                        <i class="fas fa-cog"></i> 
                        AGREGAR ORIGEN-DESTINO
                    </a>
                    <br>
                </div>
                <div class="col">
                    <a class="btn btn-success btn-block" href="<%=context%>/lugares?valida=3&&fecha=<%=fechacompleta%>">
                        <i class="fa fa-barcode"></i> 
                        ESTADISTICAS
                    </a>
                    <br>
                </div>
            </div>
            <%}%>
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
