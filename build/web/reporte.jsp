<%-- 
    Document   : reporte
    Created on : 13/01/2017, 10:33:17 AM
    Author     : Registro
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        String context = request.getContextPath();
        HttpSession sesion = request.getSession();
        String nombre = (String) sesion.getAttribute("usuario");
        if (sesion.getAttribute("usuario") == null) {
            response.sendRedirect("indexdir.jsp");
        }
    %> 
    <head>
        <link rel="shortcut icon" href="<%=context%>/images/iebem.ico">
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <meta name="description" content="" />
        <meta name="keywords" content="" />
        <%@include file="snippets/generalcssjs.jsp"%>
        <script src="<%=context%>/js/funciones/tabla_reporte.js"></script>
        <style type="text/css">
            body {
                overflow-x:hidden;
            }
        </style>
    </head>
    <body onload="muestraReporte();">
        <form class="form-signin">
            <!-- Header -->
            <%@include file="header.jsp"%>
            <div id="border-top"></div>
            <!-- Index -->
            <div class="container">
                <br/>
                <br/>
                <div id="txtHint"></div>
                <input type="hidden" value="<%=nombre%>" name="ct" id="ct"/>
                <div class="row" >
                    <div class="col">
                        <a class="btn btn-danger btn-block" href="<%=context%>/menudir.jsp">
                            <i class="fas fa-reply"></i> 
                            REGRESAR
                        </a>
                    </div>
                </div>
            </div>
            <br/>
            <!-- Footer -->
            <%@include file="footer.jsp"%>
            <script type="text/javascript">
                $(document).ready(function () {
                    $('#skel-layers-visibleWrapper').remove();
                });
            </script>
        </form>
    </body>
</html>