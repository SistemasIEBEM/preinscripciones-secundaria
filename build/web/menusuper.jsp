<%-- 
    Document   : menusuper
    Created on : 4/01/2017, 12:28:13 PM
    Author     : david
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
        Collection<BeanCT> lista = (Collection<BeanCT>) request.getAttribute("ctzona");
        if (sesion.getAttribute("usuario") == null) {
            response.sendRedirect("loginsuper.jsp");
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
    </head>
    <body onload="nobackbutton();">
        <form class="form-signin">
            <!-- Header -->
            <%@include file="header.jsp"%>
            <div id="border-top"></div>
            <!-- Index -->
            <div class="container">
                <div class="login form-container" id="InputText">
                    <center><h3><b>CONSULTA DE LUGARES POR ZONA ESCOLAR</b></h3></center>
                    <center><h4><b>USUARIO:</h4> <h5><%=nombre.getCt()%> </b></h5></center>
                    <center><b><h4>NOMBRE DEL USUARIO:</h4> <h5><%=nombre.getNombrect()%> </b></h5></center>
                    <center><h4><b>ZONA ESCOLAR:</h4> <h5> <%=nombre.getZona()%> </b></h5></center>
                    <br>
                    <div class="row justify-content-md-center">
                        <div class="col">
                            <a class="btn btn-danger btn-block" href="<%=context%>/salir.jsp">
                                <i class="fas fa-outdent"></i> 
                                SALIR
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="table-responsive">
                <table  class="table table-bordered table-condensed table-striped" id="tablas">
                    <thead>
                        <tr class="active">
                            <th><b>CT</b></th>
                            <th><b>Nombre del CT</b></th>                                    
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (BeanCT bean : lista) {
                        %>
                        <tr>
                            <td><a href="<%=request.getContextPath()%>/ctlugares?ct=<%=bean.getCt()%>" ><%=bean.getCt()%></a></td>
                            <td><%=bean.getNombre()%></td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>                       
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




