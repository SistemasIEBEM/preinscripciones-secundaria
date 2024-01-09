<%-- 
    Document   : getCT
    Created on : 20-dic-2016, 12:39:25
    Author     : David Costet
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
            String municipio = (String) request.getParameter("municipio");
        %>
        <div class="table-responsive"> 
        <table align="center" class="table table-hover table-bordered">
            <tr class="info">
                <th>MUNICIPIO</th>
                <th>CT</th>               
                <th>NOMBRE</th>               
                <th>TURNO</th>               
                <th>DIRECCION</th>               
            </tr>            
            <%
                Collection<BeanCT> listaCTS;
                CT muestra = new CT();
                listaCTS = muestra.mostrarCentrosTrabajo(municipio) ;
                for (BeanCT unCt : listaCTS) {
            %>    
            <tr>    
                <td><%=unCt.getMunicipio()%></td>
                <td><%=unCt.getCt()%></td>                
                <td><%=unCt.getNombre()%></td>                
                <td><%=unCt.getTurno()%></td>                
                <td><%=unCt.getDireccion()%></td>                
            </tr>
            <%
                }
            %>
        </table>   
        </div>
    </body>
</html>