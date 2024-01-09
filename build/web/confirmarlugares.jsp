<%-- 
    Document   : confirmarlugares
    Created on : 5/01/2017, 09:37:20 PM
    Author     : david
--%>


<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="Bean.Beanlugaresactual"%>
<%@page import="Bean.Beanlugares"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.List"%>
<%@page import="Bean.BeanCT"%>
<%@page import="Bean.Beansupervisor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <% String context = request.getContextPath();%>
    <%
        HttpSession sesion = request.getSession();
        Beansupervisor nombre = (Beansupervisor) sesion.getAttribute("usuario");
        Collection<Beanlugares> lista = (Collection<Beanlugares>) request.getAttribute("total");
        Collection<Beanlugaresactual> totalactual = (Collection<Beanlugaresactual>) request.getAttribute("totalactual");

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
                    <center><h4><b>USUARIO:</b></h4> <h5><b><%=nombre.getCt()%> </b></h5></center>
                    <center><b><h4>NOMBRE DEL USUARIO:</h4></b> <h5><b><%=nombre.getNombrect()%> </b></h5></center>
                    <center><h4><b>ZONA ESCOLAR:</b></h4> <h5> <b><%=nombre.getZona()%> </b></h5></center>
                    <br>
                    <div class="row justify-content-md-center" >
                        <div class="col">
                            <a class="btn btn-success btn-block" href="<%=context%>/ServletLogin?ct=<%=nombre.getCt()%>&contra=<%=nombre.getClave()%>&valida=2">
                                <i class="fas fa-reply"></i> 
                                REGRESAR
                            </a>
                            <br>
                            <a class="btn btn-danger btn-block" href="<%=context%>/salir.jsp">
                                <i class="glyphicon glyphicon-new-window"></i> 
                                SALIR
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <center><h4><b>LUGARES TOTALES</b></h4></center>
            <div class="table-responsive">
                <table  class="table table-bordered table-condensed table-striped" id="tablas">
                    <thead>
                        <tr class="active">
                            <th><b>CT</b></th>
                            <th><b>GRADO</b></th>
                            <th><b>TOTAL</b></th>
                            <th><b>PADRES</b></th>
                            <th><b>DIRECTOR</b></th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (Beanlugares bean : lista) {
                        %>
                        <tr>
                            <td><%=bean.getCt()%></td>
                            <td><%=bean.getGrado()%></td>
                            <td><%=bean.getTotal()%></td>
                            <td><%=bean.getPadres()%></td>
                            <td><%=bean.getDirectores()%></td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>                       
            </div>
            <center><h4><b>LUGARES PREINSCRITOS EN TIEMPO REAL</b></h4></center>
            <div class="table-responsive">
                <table  class="table table-bordered table-condensed table-striped" id="tablas">
                    <thead>
                        <tr class="active">
                            <th><b>TIPO</b></th>
                            <th><b>GRADO</b></th>
                            <th><b>PREINSCRITOS</b></th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (Beanlugaresactual bean1 : totalactual) {
                        %>
                        <tr>
                            <%if (bean1.getModo() == 1) {

                            %>
                            <td>PADRES</td>
                            <%} else {%>
                            <td>DIRECTOR</td>
                            <%}%>
                            <td><%=bean1.getGrado()%></td>
                            <td><%=bean1.getPreinscritos()%></td>
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
