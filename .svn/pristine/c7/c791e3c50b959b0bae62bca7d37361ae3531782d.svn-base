<%-- 
    Document   : getorigen
    Created on : 08-feb-2017, 12:28:03
    Author     : David Costet
--%>

<%@page import="Bean.Beanorigen"%>
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
                    <th class="encabezado">CT ORIGEN</th>
                    <th class="encabezado">CT DESTINO</th>               

                </tr>            
                <%
                    Collection<Beanorigen> origen ;
                    CT muestra = new CT();
                     origen = muestra.mostrarDatos1(ct);
                    for (Beanorigen cts : origen) {
                %>    
                <tr>    
                    <td class="cuerpo"><%=cts.getCt_origen()%></td>
                    <td class="cuerpo"><%=cts.getCt_destino()%></td>                

                </tr>
                <%
                    }
                %>
            </table>   
        </div>
    </body>
</html>