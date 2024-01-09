<%-- 
    Document   : confirmarorigen
    Created on : 07-feb-2017, 16:57:55
    Author     : David Costet
--%>

<%@page import="Bean.Beansupervisor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        String context = request.getContextPath();
        HttpSession sesion = request.getSession();
        Beansupervisor nombre = (Beansupervisor) sesion.getAttribute("usuario");
        if (sesion.getAttribute("usuario") == null) {
            response.sendRedirect("loginadmin.jsp");
        }


    %>
    <head>
        <link rel="shortcut icon" href="<%=context%>/images/iebem.ico">
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <meta name="description" content="" />
        <meta name="keywords" content="" />
        <%@include file="snippets/generalcssjs.jsp"%>
        <script src="<%=context%>/js/funciones/tabladatosescuela.js"></script>
        <script src="<%=context%>/js/funciones/valida.js"></script>
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
        <script type="text/javascript">
            $(document).ready(function () {

                var MaxInputs = 10; //Número Maximo de Campos
                var contenedor = $("#contenedor12"); //ID del contenedor
                var contenedor1 = $("#numero");
                var AddButton = $("#agregarCampo"); //ID del Botón Agregar

                //var x = número de campos existentes en el contenedor
                var x = $("#contenedor12 div").length + 1;
                var FieldCount = x - 1; //para el seguimiento de los campos
                $(AddButton).click(function (e) {
                    if (x <= MaxInputs) //max input box allowed
                    {
                        FieldCount++;
                        //agregar campo
                        $(contenedor).append('<div class="added" ><input type="text" name="ct' + FieldCount + '" id="ct' + FieldCount + '" placeholder="ct ' + FieldCount + '" style="text-transform:uppercase;" /><a href="#" class="eliminar">X</a></div>');
                        x++; //text box increment
                    }
                    $('#prueba').val(0);
                    $('#prueba').val(FieldCount);
                    return false;
                }
                );

                $("body").on("click", ".eliminar", function (e) { //click en eliminar campo
                    if (x > 1) {
                        $(this).parent('div').remove(); //eliminar el campo
                        x--;
                    }
                    return false;
                });
            });
        </script>
    </head>
    <body onload="nobackbutton();">
        <form action="<%=context%>/lugares" method="post"  onsubmit="return validaorigen();" >
            <!-- Header -->
            <%@include file="header.jsp"%>
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
                                <i class="fas fa-reply"></i> 
                                SALIR
                            </a>
                            <br>
                            <a class="btn btn-success btn-block" href="<%=context%>/origen-destino.jsp">
                                <i class="fas fa-outdent"></i> 
                                REGRESAR
                            </a>
                        </div>
                    </div>
                </div>
                <div class="login form-container" id="InputText">
                    <center><h5><b>..::LOS REGISTROS ORIGEN DESTINO FUERON DADOS DE ALTA::..</b></h5></center>
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