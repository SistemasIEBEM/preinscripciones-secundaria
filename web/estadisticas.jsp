<%-- 
    Document   : estadisticas
    Created on : 25-ene-2017, 8:41:20
    Author     : David Costet
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="Bean.BeanFecha"%>
<%@page import="java.util.Collection"%>
<%@page import="Bean.Beansupervisor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        String context = request.getContextPath();
        HttpSession sesion = request.getSession();
        String mensaje = null;
        Beansupervisor nombre = (Beansupervisor) sesion.getAttribute("usuario");
        if (sesion.getAttribute("usuario") == null) {
            response.sendRedirect("loginadmin.jsp");
        }

        ArrayList<BeanFecha> lista = (ArrayList<BeanFecha>) request.getAttribute("conteo");
        

        if (request.getAttribute("mIntegerensaje_alerta") != null) {
            mensaje = request.getAttribute("mensaje").toString();
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
            <%
                Calendar fecha = Calendar.getInstance();

                int año = fecha.get(Calendar.YEAR);
                int mes = fecha.get(Calendar.MONTH) + 1;
                int dia = fecha.get(Calendar.DAY_OF_MONTH);
                int hora = fecha.get(Calendar.HOUR_OF_DAY);
                int minuto = fecha.get(Calendar.MINUTE);
                int segundo = fecha.get(Calendar.SECOND);
                String fechacompleta = año + "-" + mes + "-" + dia;
                int hola = 0;
                int modo = 0;
                int total = 0;
                int a = 0;
                int d = 0;

            %>
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
                        <div class="col">
                            <a class="btn btn-success btn-block" href="<%=context%>/menuadmin.jsp">
                                <i class="fas fa-reply"></i> 
                                REGRESAR
                            </a>
                        </div>
                    </div>
                </div>
                <div  id="InputText">
                    <center><h3><b>Reporte de Preinscripciones Preescolar Fecha Actual: <%=año%> / <%=mes%> / <%=dia%>  Hora Actual: <%=hora%> : <%=minuto%> : <%=segundo%> </b></h3></center>

                    <br>
                    <div class="col">
                        <a class="btn btn-success btn-block" href="<%=context%>/lugares?valida=3&&fecha=<%=fechacompleta%>">
                            <i class="fa fa-cloud"></i> 
                            Actualizar
                        </a>
                        <br>
                    </div>
                </div>
            </div>
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
                            <th><b>HORA</b></th>
                            <th><b>PADRES</b></th>
                            <th><b>DIRECTOR</b></th>
                            <th><b>TOTAL</b></th>


                        </tr>
                    </thead>
                    <tbody>

                        <%
                            int suma = 0;
                            int suma3 = 0;
                            int suma4 = 0;
                            int suma6 = 0;
                            for (BeanFecha bean : lista) {

                                /*if (lista1.size() < lista2.size()) {

                                    lista1.add(0);
                                }

                                if (lista.size() < lista2.size()) {

                                    lista.add(0);

                                }*/

                        %>
                        <tr>
                            <td><%=bean.getHora() %></td>
                            <td><%=bean.getModo() %></td>
                            <td><%=bean.getTotal() %></td>
                            <%suma = bean.getModo() + bean.getTotal();%>
                            <td><%=suma%></td>
                        </tr>

                        <% suma3 = suma3 + bean.getModo();%>
                        <%suma4 = suma4 + bean.getTotal();%>
                        <%suma6 = suma6 + suma;%>                             

                        

                        <%
                            }
                        %>

                        <tr>
                            <td>total</td>                            
                            <td><%=suma3%></td>                                                          
                            <td><%=suma4%></td>                                                          
                            <td><%=suma6%></td>
                        </tr>
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

