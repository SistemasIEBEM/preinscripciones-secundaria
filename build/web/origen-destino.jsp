<%-- 
    Document   : origen-destino
    Created on : 03-feb-2017, 15:36:56
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
                    <div class="row" >
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
                <div class="login form-container" id="InputText">
                    <center><h5><b>INTRODUZCA LA CLAVE DE CENTRO DE TRABAJO <font color="red">ORIGEN</font></b></h5></center>
                    <center>
                        <input type="text"  placeholder="EJEMPLO: 17DJN0001J" name="ct" id="ct"  style="text-transform:uppercase;">
                    </center>
                    <br>

                    <center><h5><b>INTRODUZCA LA CLAVE DE LOS CENTROS DE TRABAJO <font color="red">DESTINO</font></b></h5></center>
                    <center>
                        <a id="agregarCampo" class="btn btn-primary" href="#">Agregar Campo</a>                        
                        <div id="contenedor12">
                            <div class="added">
                                <input type="text" name="ct1" id="ct1" placeholder="ct 1" style="text-transform:uppercase;" /><a href="#" class="eliminar">X</a>
                            </div>
                        </div>
                        <input type="hidden" id="prueba" name="numero" value="0"/>

                    </center>
                </div>
                <input type="hidden" name="valida" value="4">
                <div class="col">
                    <button type="submit" class="btn btn-danger btn-block">
                        <i class="fas fa-reply"></i> 
                        INSERTAR
                    </button>
                    <br>
                </div>

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
