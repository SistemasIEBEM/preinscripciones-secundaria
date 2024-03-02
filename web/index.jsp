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
                <center>
                    <a href="<%=context%>/Listadoescuelas.jsp" class="blackboard">
                        <p>PARA VER EL LISTADO DE ESCUELAS DISPONIBLES Y SU CLAVE DE CCT HAGA CLIC <span class="fas fa-clipboard" aria-hidden="true"></span></p>
                    </a>
                    <a href="http://escolar.iebem.edu.mx/Preinscripciones2024.Preesco/consultaFolio.jsp" class="blackboard">
                        <!--<a href="#" class="blackboard">-->
                        <p>REIMPRESIÓN DE COMPROBANTES DE PREINSCRIPCIÓN DE PREESCOLAR <span class="fas fa-clipboard" aria-hidden="true"></span></p>
                    </a>
                    <a href="http://escolar.iebem.edu.mx/Preinscripciones2024.Prim/consultaFolio.jsp" class="blackboard">
                        <!--<a href="#" class="blackboard">-->
                        <p>REIMPRESIÓN DE COMPROBANTES DE PREINSCRIPCIÓN DE PRIMARIA <span class="fas fa-clipboard" aria-hidden="true"></span></p>
                    </a>
                    <a href="<%=context%>/consultaFolio.jsp" class="blackboard">
                        <p>REIMPRESIÓN DE COMPROBANTES DE PREINSCRIPCIÓN DE SECUNDARIA <span class="fas fa-clipboard" aria-hidden="true"></span></p>
                    </a>
                </center>
                <!--<div class="row">-->
                <div class="row justify-content-md-center">      
                    <!--<div class="col-lg-12">-->
                    <div class="col-md-6">
                        <div class="login login-container">
                            <%@include file="peticion.jsp"%>                                                                           
                        </div>
                    </div>
                    <!--<div class="col-md-6">-->
                    <div class="col-md-6 col-md-offset-3">
                        <div class="login login-container">
                            <h5>
                                <center>
                                    <b>ACCESO PARA DIRECTORES</b>
                                </center>
                            </h5>
                            <hr>
                            <center>
                                <div class="btn-group" role="group">
                                    <button type="button" class="btn btn-danger dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                                        SELECCIONE NIVEL EDUCATIVO DANDO CLIC
                                    </button>
                                    <ul class="dropdown-menu btn-block" aria-labelledby="btnGroupDrop1">
                                        <!--<li><a href="#">Preescolar</a></li>-->
                                        <li><a class="dropdown-item" href="http://escolar.iebem.edu.mx/Preinscripciones2024.Preesco/logindir.jsp">Preescolar</a></li>
                                        <!--<li><a href="#">Primaria</a></li>-->
                                        <li><a class="dropdown-item" href="http://escolar.iebem.edu.mx/Preinscripciones2024.Prim/logindir.jsp">Primaria</a></li>
                                        <li><a class="dropdown-item" href="<%=context%>/logindir.jsp">Secundaria</a></li>
                                    </ul>
                                </div>
                            </center>
                            <hr>
                            <h5>
                                <center>
                                    <b>ACCESO PARA SUPERVISORES</b>
                                </center>
                            </h5>
                            <hr>
                            <!--<button type="reset" class="btn btn-warning btn-block" onclick="#">-->
                            <button type="reset" class="btn btn-warning btn-block" onclick="location.href = '<%=context%>/loginsuper.jsp'">
                                <i class="fas fa-user"></i> 
                                INGRESAR
                            </button>
                        </div>
                    </div>
                    <!--</div>-->
                </div>
            </div>
        </div>
        <!-- Modal -->
        <%@include file="ayuda.jsp"%>     
        <!-- Footer -->
        <%@include file="footer.jsp" %>
        <script type="text/javascript">
            $(document).ready(function () {
                $('#skel-layers-visibleWrapper').remove();
            });
        </script>
    </body>
</html>
