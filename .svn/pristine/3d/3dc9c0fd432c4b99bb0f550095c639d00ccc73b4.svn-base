<%-- 
    Document   : getdatos
    Created on : 27/12/2016, 06:07:43 PM
    Author     : david
--%>

<%@page import="DaoImpl.CT"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Dao.MuestraCTDAO"%>
<%@page import="Bean.BeanCT"%>
<%@page import="java.util.Collection"%>
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
                    <th class="encabezado">MUNICIPIO</th>
                    <th class="encabezado">CT</th>               
                    <th class="encabezado">NOMBRE</th>               
                    <th class="encabezado">TURNO</th>               
                    <th class="encabezado">DIRECCION</th>
                    <th class="encabezado">CONTRASEÑA</th> 
                </tr>            
                <%
                    BeanCT listaCTS = new BeanCT();
                    CT muestra = new CT();
                    listaCTS = muestra.mostrarDatos(ct);

                %>    
                <tr>    
                    <td class="cuerpo"><%=listaCTS.getMunicipio()%></td>
                    <td class="cuerpo"><%=listaCTS.getCt()%></td>                
                    <td class="cuerpo"><%=listaCTS.getNombre()%></td>                
                    <td class="cuerpo"><%=listaCTS.getTurno()%></td>                
                    <td class="cuerpo"><%=listaCTS.getDireccion()%></td>
                    <td class="cuerpo"><%=listaCTS.getContrasena()%></td>                
                </tr>
                <%

                %>
            </table>   
        </div>
    </body>
</html>