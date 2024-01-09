<%-- 
    Document   : confirmacionctgrado
    Created on : 11-ene-2017, 16:19:28
    Author     : David Costet
--%>


<%@page import="Bean.Beanlugaresctgrado"%>
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
        Collection<Beanlugaresctgrado> lista = (Collection<Beanlugaresctgrado>) request.getAttribute("lugaresctgrado");

        int suma = 0;
        int contador = 0;
        String mensaje = null;

        if (request.getAttribute("mensaje_alerta") != null) {
            mensaje = request.getAttribute("mensaje_alerta").toString();
        }

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

            };
        </script>
    </head>
    <body onload="nobackbutton();">
        <form class="form-signin" action="<%=context%>/lugares" method="post" >
            <!-- Header -->
            <%@include file="header.jsp"%>
            <div id="border-top"></div>

            <!-- Index -->
            <div class="container">
                <div class="login form-container" id="InputText">
                    <center><h3><b>CONSULTA DE LUGARES POR ZONA ESCOLAR</b></h3></center>
                    <center><h4><b>USUARIO:</b></h4> <h5><b><%=nombre.getCt()%> </b></h5></center>
                    <center><b><h4>NOMBRE DEL USUARIO:</h4></b> <h5><b><%=nombre.getNombrect()%> </b></h5></center>

                    <br>
                    <div class="row justify-content-md-center" >
                        <div class="col">
                            <a class="btn btn-success btn-block" href="<%=context%>/administrar_lugares.jsp">
                                <i class="fas fa-reply"></i> 
                                REGRESAR
                            </a>
                            <br>
                            <a class="btn btn-danger btn-block" href="<%=context%>/salir1.jsp">
                                <i class="fas fa-outdent"></i> 
                                SALIR
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <center><h4><b>LUGARES TOTALES</b></h4></center>
                        <%  if (mensaje != null) {%>
            <div class="alert alert-danger alert-dismissable">
                <button type="button" class="close" data-dismiss="alert">
                    &times;</button>
                    <%=mensaje%>
            </div>
            <% }%>
            <div class="table-responsive">
                <table  class="table table-bordered table-condensed table-striped" id="tablas">
                    <thead>
                        <tr class="active">
                            <th><b>FECHA</b></th>
                            <th><b>CT</b></th>
                            <th><b>MODO</b></th>
                            <th><b>GRADO</b></th>
                            <th><b>TOTAL</b></th>
                            <th><b>OCUPADOS</b></th>

                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (Beanlugaresctgrado bean : lista) {
                                contador = contador + 1;
                        %>
                        <tr>
                            <td><%=bean.getFecha()%></td>
                            <td><%=bean.getCt()%></td>

                            <%if (bean.getModo() == 1) {
                            %>
                            <td>PADRES</td>
                            <%} else { %>
                            <td>DIRECTOR</td>
                            <%}%>

                            <td><%=bean.getGrado()%></td>
                            <td><input type="text"   name="total<%=contador%>" class="col-md-6" id="total" value="<%=bean.getTotal()%>" /></td>
                            <td><%=bean.getOcupados()%></td>
                    <input type="hidden" name="fecha<%=contador%>" value="<%=bean.getFecha()%>" />
                    <input type="hidden" name="ct<%=contador%>" value="<%=bean.getCt()%>" />
                    <input type="hidden" name="grado<%=contador%>" value="<%=bean.getGrado()%>" />
                    <input type="hidden" name="modo<%=contador%>" value="<%=bean.getModo()%>">
                    </tr>
                    <%
                            suma = suma + bean.getTotal();
                        }

                    %>

                    </tbody>
                </table>                       
            </div>
            <center><h4><b>TOTAL DE LUGARES PARA EL CT SON:<%=suma%></b></h4></center>
            <input type="hidden" name="suma" value="<%=suma%>">
            <input type="hidden" name="contador" value="<%=contador%>">
            <input type="hidden" name="valida" value="2">
            <br>
            <div class="row justify-content-md-center">
                <div class="col-8">
                    <button class="btn btn-success btn-block">
                        <i class="fas fa-cloud"></i> 
                        MODIFICAR
                    </button>
                </div>
            </div>
            <br>
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
