<%-- 
    Document   : loginadmin
    Created on : 10-ene-2017, 8:33:17
    Author     : David Costet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <% String context = request.getContextPath();%>
    <head>
        <title>PREINSCRICIONES 2019</title>
        <link rel="shortcut icon" href="<%=context%>/images/iebem.ico">
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <meta name="description" content="" />
        <meta name="keywords" content="" />
        <%@include file="snippets/generalcssjs.jsp"%>
        <script src="<%=context%>/js/funciones/validaCT.js"></script>
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
                <center>
                    <div class="blackboard">
                        <p>
                            <span class="fas fa-book" aria-hidden="true"></span>
                            MÓDULO DE ACCESO PARA ADMINISTRADOR
                        </p>
                    </div>
                </center>
                <div class="row justify-content-md-center">                      
                    <div class="col-md-6 col-md-offset-3">
                        <div class="container" id="login-form">
                            <div class="container">
                                <div class="login form-container-dir">
                                    <%@include file="login_admin.jsp"%>                                                                           
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Modal -->
        <%@include file="ayuda2.jsp"%>  
        <!-- Footer -->
        <%@include file="footer.jsp" %>
        <script type="text/javascript">
            $(document).ready(function () {
                $('#skel-layers-visibleWrapper').remove();
            });
        </script>
    </body>
</html>
