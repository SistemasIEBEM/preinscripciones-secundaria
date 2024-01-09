<%-- 
    Document   : getReporte
    Created on : 13/01/2017, 10:32:41 AM
    Author     : Registro
--%>

<%@page import="Bean.BeanReporte"%>
<%@page import="DaoImpl.Fachada"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <%
            String ct = (String) request.getParameter("ct");
        %>
        <div class="table-responsive">
            <table align="center" class="table table-hover table-bordered">
                <tr class="info">
                    <th>GRADO</th>
                    <th>LUGARES PARA</th>               
                    <th>CAPACIDAD</th>               
                    <th>OCUPADOS</th>               
                    <th>RESERVADOS</th>               
                    <th>DISPONIBLES</th>               
                </tr>            
                <%
                    Collection<BeanReporte> listaReporte;
                    Fachada report = new Fachada();
                    listaReporte = report.mostrarReporte(ct);
                    for (BeanReporte unrep : listaReporte) {
                %>    
                <tr>    
                    <td><%=unrep.getGrado()%></td>
                    <td><%=unrep.getLugaresPara()%></td>                
                    <td><%=unrep.getCapacidad()%></td>                
                    <td><%=unrep.getOcupados()%></td>                
                    <td><%=unrep.getReservados()%></td>
                    <td><%=unrep.getDisponibles()%></td>                
                </tr>
                <%
                    }
                %>
            </table>
        </div>
    </body>
</html>
