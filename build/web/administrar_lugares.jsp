<%-- 
    Document   : administrar_lugares
    Created on : 10-ene-2017, 14:28:12
    Author     : David Costet
--%>


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
        <form class="form-signin" action="<%=context%>/lugares" method="post" onsubmit="return validactingreso();">
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
                            <a class="btn btn-success btn-block" href="<%=context%>/menuadmin.jsp">
                                <i class="fa fa-reply"></i> 
                                REGRESAR
                            </a>
                        </div>
                        <div class="col">
                            <a class="btn btn-danger btn-block" href="<%=context%>/salir1.jsp">
                                <i class="fa fa-outdent"></i> 
                                SALIR
                            </a>
                        </div>
                    </div>
                </div>
            </div>

            <div class="container">
                <div class="col">
                    <div class="form-group" id="inputText">
                        <center><h5><b>PARA MODIFICAR LOS LUGARES INTRODUCE EL CT Y EL GRADO:</b></h5></center>
                        <center><h5><b>CT:</b></h5></center>
                        <input type="text" class="form-control" placeholder="EJEMPLO: 17DPR0009Y" name="ct" id="ct" style="text-transform:uppercase;">
                        <br>
                        <center><h5><b>GRADO:</b></h5></center>
                        <center><select id="grado" name="grado" class="form-control">
                                <option value="1">1</option>
                            </select>
                        </center>

                    </div>
                </div>
                <input type="hidden" name="valida" value="1">
                <input type="hidden" name="mensaje" value="">
                <br>
                <div class="col">
                    <button type="submit" class="btn btn-primary btn-block">
                        <i class="fas fa-search"></i> 
                        CONSULTAR
                    </button>
                </div>
            </div>
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

