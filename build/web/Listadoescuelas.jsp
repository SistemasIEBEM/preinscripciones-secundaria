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

            #hola {
                font-family: inherit;
                font-size: inherit;
                line-height: inherit;
                position: absolute;
                top: 70%;
                left: 0px;
                z-index: -1;
                background-color: #f1f1f1;
                border-style: none;
            }
            /* Always set the map height explicitly to define the size of the div
             * element that contains the map. */
            #map-canvas {
                height: 500px;
                width: 100%;
            }
            /* Optional: Makes the sample page fill the window. */
            html, body {
                height: 100%;
                margin: 0;
                padding: 0;
            }

            body {
                overflow-x:hidden;
            }
        </style>
        <script
            src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB5C10-g-khNEvVaXL29kTOdXLQvmqIAFU&callback=initMap">
        </script>        
        <script>

            var map;
            function initialize() {
                var mapOptions = {
                    zoom: 5,
                    center: new google.maps.LatLng(22.8621500, -102.6106100)
                };
                map = new google.maps.Map(document.getElementById('map-canvas'),
                        mapOptions);
            }

            google.maps.event.addDomListener(window, 'load', initialize);

            function cambiarTipo(id, context) {
                console.log(id);
                document.getElementById("divlocalidad").innerHTML = " ";
                $("#carga").show();
                $.get(context + '/dato?accion=2', {id: id}, function (data) {
                    $("#carga").hide();
                    $("#divlocalidad").append("<select name='loca' id='loca' class='form-control'><option value='' disabled selected>Seleccione una opción</option>" + data + "</select>");
                });
            }

            function consultar(context) {
                var muni = $('#muni').val();
                var loca = $('#loca').val();
                console.log(muni, loca);
                console.log(context);
                $.getJSON(context + '/dato?accion=3', {muni: muni, loca: loca}, function (dataa)
                {
                    console.log(dataa);

                    console.log(dataa[0]);

                    dataa[0].forEach(function (cor) {
                        map = new google.maps.Map(document.getElementById('map-canvas'), {
                            center: new google.maps.LatLng(cor.lat, cor.lng), //cambiar esta linea para centrar el mapa
                            zoom: 8
                        });
                    });
                    infoWindow = new google.maps.InfoWindow;

                    // cambiarMuni($("#municipio").val());
                    dataa[1].forEach(function (element) {

                        var name = element.ct;
                        console.log(name);
                        var nombre = "NOMBRE CT: " + element.nombre;
                        var address = "DIRECCIÓN: " + element.direccion;
                        var mu = "MUNICIPIO: " + element.municipio;
                        var turno = "TURNO: " + element.turno;

                        //var type = markerElem.getAttribute('type');
                        var point = new google.maps.LatLng(
                                parseFloat(element.lati),
                                parseFloat(element.lon)
                                );

                        var infowincontent = document.createElement('div');
                        var strong = document.createElement('strong');
                        // var direccion = document.createElement('strong');

                        strong.textContent = name
                        // direccion.textContent = address

                        infowincontent.appendChild(strong);
                        infowincontent.appendChild(document.createElement('br'));

                        var text1 = document.createElement('text');
                        text1.textContent = nombre
                        infowincontent.appendChild(text1);

                        infowincontent.appendChild(document.createElement('br'));
                        var text3 = document.createElement('text');
                        text3.textContent = turno
                        infowincontent.appendChild(text3);


                        infowincontent.appendChild(document.createElement('br'));
                        var text = document.createElement('text');
                        text.textContent = address
                        infowincontent.appendChild(text);

                        infowincontent.appendChild(document.createElement('br'));
                        var text4 = document.createElement('text');
                        text4.textContent = mu
                        infowincontent.appendChild(text4);


                        var marker = new google.maps.Marker({
                            map: map,
                            position: point,
                        });
                        marker.addListener('click', function () {
                            infoWindow.setContent(infowincontent);
                            infoWindow.open(map, marker);
                        });


                    });

                    document.getElementById("tabla").innerHTML = " ";
                    var ct = '';
                    var trs = '';

                    dataa[1].forEach(function (dato) {

                        trs = trs + '<tr onclick="mostrarPunto(' + dato.lati + ',' + dato.lon + ',\u0027' + dato.ct + '\u0027,\u0027' + dato.nombre + '\u0027,\u0027' + dato.turno + '\u0027,\u0027' + dato.direccion + '\u0027,\u0027' + dato.municipio + '\u0027)">' +
                                "<td><button type='button' onclick='focusNoScrollMethod()'  class='btn btn-danger glyphicon glyphicon-map-marker'> VerMapa</button></td>" +
                                "<td><strong>" + dato.ct + "</strong></td>" +
                                "<td><strong>" + dato.nombre + "</strong></td>" +
                                "<td><strong>" + dato.turno + "</strong></td>" +
                                "<td><strong>" + dato.direccion + "</strong></td>" +
                                "</tr>";
                    });
                    $("#tabla").append("<h4> Centros de trabajo </h4>" +
                            "<table id='example' class='table table-condensed table-hover'>" +
                            "<thead>" +
                            "<tr>" +
                            "<th>ACCIÓN</th>" +
                            "<th>CT</th>" +
                            "<th>NOMBRE</th>" +
                            "<th>TURNO</th>" +
                            "<th>DIRECCION</th>" +
                            "</tr>" +
                            "</thead>" +
                            "<tbody>" +
                            trs +
                            "</tbody>" +
                            "</table>");
                    $('#example').DataTable({
                        "language": {
                            "url": "js/lenguaje/Spanish.json"
                        },
                        "lengthMenu": [[10, -1], [10, "Todos"]],
                        responsive: true,
                        "dom": '<"toolbar">frtip',
                        "order": [[1, "asc"]],
                        "scrollY": 480,
                        scrollCollapse: true
                    });

                });

            }

            function mostrarPunto(lat, long, ct, nombre, turno, direc, muni) {
                console.log(map);
                var popup = new google.maps.InfoWindow({
                    content: 'Wohoooo, salió el InfoWindow, pero ¿por qué sale exactamente en el punto del marcador?',
                    //position: new google.maps.LatLng(parseFloat(lat),parseFloat(long))
                });
                var marker = new google.maps.Marker({
                    map: map,
                    position: new google.maps.LatLng(parseFloat(lat), parseFloat(long)),
                    // label: icon.label
                });
                // marker.addListener('click', function() {
                infoWindow.setContent("<strong>" + ct + "</strong><br>NOMBRE CT: " + nombre + "<br>TURNO: " + turno + "<br>DIRECCIÓN: " + direc + "<br>MUNICIPIO: " + muni);
                infoWindow.open(map, marker);
                // });
                // popup.open(map);

            }
            function scrollToTop() {
                /*var scrollStep = -window.scrollY / (scrollDuration / 15),
                 scrollInterval = setInterval(function () {
                 if (window.scrollY != 0) {
                 window.scrollBy(0, scrollStep);
                 } else
                 clearInterval(scrollInterval);
                 }, 15);*/
                document.getElementById('#map-canvas').focus();
            }
            focusNoScrollMethod = function getFocusWithoutScrolling() {

                document.getElementById("hola").focus({preventScroll: true});
            }



        </script>
    </head>
    <body>
        <form class="form-signin">
            <!-- Header -->
            <%@include file="header.jsp"%>
            <div id="border-top"></div>
            <!-- Index -->
            <br>
            <br>
            <div class="row justify-content-md-center">
                <div class="col-md-6 col-md-offset-3">
                    <a class="btn btn-danger btn-block" href="<%=context%>/index.jsp">
                        <i class="fas fa-reply"></i> 
                        REGRESAR MENU PRINCIPAL
                    </a>
                </div>
            </div>
            <br>
            <div class="container">
                <div align="center">
                    <h3>Consulta de Centros de Trabajo por Municipio</h3>
                </div>
                <form id="formulario1">
                    <div class="form-group">
                        <label for="exampleInputEmail1">Municipio</label>
                        <select class="form-control" id="muni"  name="muni" onchange="cambiarTipo(this.value, '<%=context%>')">
                            <option value="0" disabled="" selected="">Selecciona una opción</option>
                            <option value="AMACUZAC">AMACUZAC</option>
                            <option value="ATLATLAHUCAN">ATLATLAHUCAN</option>
                            <option value="AXOCHIAPAN">AXOCHIAPAN</option>
                            <option value="AYALA">AYALA</option>
                            <option value="COATLAN DEL RIO">COATLAN DEL RIO</option>
                            <option value="CUAUTLA">CUAUTLA</option>
                            <option value="CUERNAVACA">CUERNAVACA</option>
                            <option value="EMILIANO ZAPATA">EMILIANO ZAPATA</option>
                            <option value="HUITZILAC">HUITZILAC</option>
                            <option value="JANTETELCO">JANTETELCO</option>
                            <option value="JIUTEPEC">JIUTEPEC</option>
                            <option value="JOJUTLA">JOJUTLA</option>
                            <option value="JONACATEPEC">JONACATEPEC</option>
                            <option value="MAZATEPEC">MAZATEPEC</option>
                            <option value="MIACATLAN">MIACATLAN</option>
                            <option value="OCUITUCO">OCUITUCO</option>
                            <option value="PUENTE DE IXTLA">PUENTE DE IXTLA</option>
                            <option value="TEMIXCO">TEMIXCO</option>
                            <option value="TEMOAC">TEMOAC</option>
                            <option value="TEPALCINGO">TEPALCINGO</option>
                            <option value="TEPOZTLAN">TEPOZTLAN</option>
                            <option value="TETECALA">TETECALA</option>
                            <option value="TETELA DEL VOLCAN">TETELA DEL VOLCAN</option>
                            <option value="TLALNEPANTLA">TLALNEPANTLA</option>
                            <option value="TLALTIZAPAN">TLALTIZAPAN</option>
                            <option value="TLAQUILTENANGO">TLAQUILTENANGO</option>
                            <option value="TLAYACAPAN">TLAYACAPAN</option>
                            <option value="TOTOLAPAN">TOTOLAPAN</option>
                            <option value="XOCHITEPEC">XOCHITEPEC</option>
                            <option value="YAUTEPEC">YAUTEPEC</option>
                            <option value="YECAPIXTLA">YECAPIXTLA</option>
                            <option value="ZACATEPEC">ZACATEPEC</option>
                            <option value="ZACUALPAN">ZACUALPAN</option>

                        </select>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputEmail1">Localidad</label>
                        <img id="carga" src="<%=context%>/images/cargar.gif" class="img-responsive" style="display: none">
                        <div id="divlocalidad">
                            <select class="form-control" id="loca" name="loca">
                                <option value="0" disabled="" selected="">Selecciona una opción</option>
                            </select>
                        </div>

                    </div>
                    <div class="form-group">
                        <button type="button" class="btn btn-primary" onclick="consultar('<%=context%>')">
                            <i class="fas fa-search"></i> 
                            Consultar
                        </button>
                    </div>
                </form>		
            </div>
            <div class="container">
                <div id="tabla"></div>
                <div id="map-canvas"></div>
                <input type="tex" id="hola" readonly/>
            </div>
            <!-- Footer -->
            <%@include file="footer.jsp" %>
            <script type="text/javascript">
                $(document).ready(function () {
                    $('#skel-layers-visibleWrapper').remove();
                    $('#skel-layers-hiddenWrapper').hide();
                });
            </script>
        </form>
    </body>
</html>




