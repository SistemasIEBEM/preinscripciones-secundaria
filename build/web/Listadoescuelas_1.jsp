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
        <script src="<%=context%>/js/funciones/listado_escuela.js"></script>
        <style type="text/css">
            body {
                overflow-x:hidden;
            }
        </style>
    </head>
    <body>
        <form class="form-signin">
            <!-- Header -->
            <%@include file="header.jsp"%>
            <div id="border-top"></div>
            <!-- Index -->
            <div class="container">
                <div class="login form-container" id="InputText">
                    <center><h5><b>DE CLIC EN LA LISTA PARA VISUALIZAR SU MUNICIPIO.</b></h5></center>
                    <center><select id="municipio" name="municipio" onchange="muestraCT()" class="form-control">
                            <option value="00">Seleccione una opción</option>
                            <option value="Amacuzac">Amacuzac</option>
                            <option value="Atlatlahucan">Atlatlahucan</option>
                            <option value="Axochiapan">Axochiapan</option>
                            <option value="AYALA">Ayala</option>
                            <option value="Coatlan del Rio">Coatl&aacute;n del R&iacute;o</option>
                            <option value="Cuautla">Cuautla</option>
                            <option value="CUERNAVACA">Cuernavaca</option>
                            <option value="Emiliano Zapata">Emiliano Zapata</option>
                            <option value="Huitzilac">Huitzilac</option>
                            <option value="Jantetelco">Jantetelco</option>
                            <option value="JIUTEPEC">Jiutepec</option>
                            <option value="Jojutla">Jojutla</option>
                            <option value="Jonacatepec">Jonacatepec</option>
                            <option value="Mazatepec">Mazatepec</option>
                            <option value="Miacatlan">Miacatl&aacute;n</option>
                            <option value="Ocuituco">Ocuituco</option>
                            <option value="Puente de Ixtla">Puente de Ixtla</option>
                            <option value="Temixco">Temixco</option>
                            <option value="Temoac">Temoac</option>
                            <option value="Tepalcingo">Tepalcingo</option>
                            <option value="Tepoztlan">Tepoztl&aacute;n</option>
                            <option value="Tetecala">Tetecala</option>
                            <option value="Tetela del Volcan">Tetela del Volc&aacute;n</option>
                            <option value="Tlalnepantla">Tlalnepantla</option>
                            <option value="Tlaltizapan">Tlaltizap&aacute;n</option>
                            <option value="TLAQUILTENANGO">Tlaquiltenango</option>
                            <option value="Tlayacapan">Tlayacapan</option>
                            <option value="Totolapan">Totolapan</option>
                            <option value="Xochitepec">Xochitepec</option>
                            <option value="Yautepec">Yautepec</option>
                            <option value="Yecapixtla">Yecapixtla</option>
                            <option value="ZACATEPEC">Zacatepec de Hidalgo</option>
                            <option value="Zacualpan">Zacualpan</option>
                        </select>
                    </center>
                    <br>
                    <div class="row" >
                        <div class="col-md-6 col-md-offset-3">
                            <a class="btn btn-danger btn-block" href="<%=context%>/index.jsp">
                                <i class="glyphicon glyphicon-repeat"></i> 
                                REGRESAR
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <div id="txtHint"></div>
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