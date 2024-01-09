<%-- 
    Document   : directores
    Created on : 5/01/2017, 01:21:26 PM
    Author     : Mike
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        String context = request.getContextPath();
        HttpSession sesion = request.getSession();
        String username = (String) sesion.getAttribute("usuario");
        if (sesion.getAttribute("usuario") == null) {
            response.sendRedirect("index_dir.jsp");
        }
    %>  
    <head>
        <link rel="shortcut icon" href="<%=context%>/images/iebem.ico">
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <meta name="description" content="" />
        <meta name="keywords" content="" />
        <%@include file="snippets/generalcssjs.jsp"%>
        <script src="<%=context%>/js/funciones/tabla_listado_escuelas.js"></script>
        <style type="text/css">
            body {
                overflow-x:hidden;
            }
        </style>
    </head>
    <body>
        <form class="form-signin" action="<%=request.getContextPath()%>/ServletArchivo" method="post" >
            <!-- Header -->
            <%@include file="header.jsp"%>
            <div id="border-top"></div>
            <!-- Index -->
            <div class="container">
                <br/>
                <center>
                    <h1>SISTEMA DE PRE-INSCRIPCIONES <%=ciclo %></h1>
                    <h2>"MÓDULO DE ACCESO PARA DIRECTORES"</h2>
                    <br/>
                    <h4>SELECCIONE ALGUNA DE LAS SIGUIENTES OPCIONES: </h4>
                </center>
                <br/>
                <br/>
                <div class="table-responsive">
                    <table  class="table">
                        <tr>
                            <td>
                                <a class="btn btn-lg btn-primary" onclick='window.location = "preinscribirDir.jsp"'>
                                    <i class="fas fa-save"></i> 
                                    PRE-INSCRIBIR</a>
                            </td>
                            <td>
                                <a class="btn btn-lg btn-success" onclick="location.href = 'reporte.jsp';">
                                    <i class="fas fa-book"></i> 
                                    REPORTE</a>                            
                            </td>
                            <td>
                                <button type="submit" class="btn btn-lg btn-warning">
                                    <i class="fas fa-download"></i> 
                                    DESCARGA DE LISTA ALUMNOS</button>
                                <input type="hidden" value="DescargarListaExcel" name="opc"/>
                                <input type="hidden" value="<%=username%>" name="ct"/>
                            </td>
                            <td>
                                <a class="btn btn-lg btn-danger" onclick="location.href = 'salir_dir.jsp';">
                                    <i class="fas fa-outdent"></i> 
                                    SALIR</a>
                            </td>
                        </tr>
                    </table>                     
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
