<%-- 
    Document   : consultaFolio
    Created on : 13/01/2017, 09:27:14 AM
    Author     : Registro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <% String context = request.getContextPath();%>
    <head>
        <link rel="shortcut icon" href="<%=context%>/images/iebem.ico">
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <meta name="description" content="" />
        <meta name="keywords" content="" />
        <%@include file="snippets/generalcssjs.jsp"%>
        <style type="text/css">
            body {
                overflow-x:hidden;
            }
        </style>
    </head>
    <body>
        <!-- Header -->
        <%@include file="header.jsp"%>
        <div id="border-top"></div>
        <!-- Index -->
        <div class="jumbotron" id="slider">
            <div class="container">
                <div class="row justify-content-md-center">                      
                    <div class="col-md-6 col-md-offset-3">
                        <div class="container" id="login-form">
                            <div class="container">
                                <div class="login login-container">
                                    <%@include file="peticion_consulta.jsp"%>                                                                           
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Modal -->
        <%@include file="ayuda4.jsp"%>   
        <!-- Footer -->
        <%@include file="footer.jsp" %>
        <script type="text/javascript">
            $(document).ready(function () {
                $('#skel-layers-visibleWrapper').remove();
            });
        </script>
    </body>
</html>

