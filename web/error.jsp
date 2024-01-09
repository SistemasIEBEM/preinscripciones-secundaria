<%-- 
    Document   : error
    Created on : 3/01/2017, 08:59:27 PM
    Author     : david
--%>

<%@page import="java.util.Collection"%>
<%@page import="Dao.Muestra"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String errores = request.getAttribute("error") != null ? (String) request.getAttribute("error") : "";
    String ct = request.getAttribute("ct") != null ? (String) request.getAttribute("ct") : "";
    String nombre_ct = request.getAttribute("nombre_ct") != null ? (String) request.getAttribute("nombre_ct") : "";

%>
<html><head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style=" background-color: #f1f1f1">
        <input type="hidden" id="ct" value="<%=ct%>"/>
        <input type="hidden" id="nombre_ct" value="<%=nombre_ct%>"/>
    </body>
</html>
<script src="jquery/jquery.js" type="text/javascript" ></script>
<script src="js/jquery-1.11.0.min.js" type="text/javascript" ></script>
<script type="text/javascript" >
    $(document).ready(function () {


    <%     if (errores != null) {
            int error = Integer.parseInt(errores);
            if (error == 6) { %>
        alert('El aspirante tiene un lugar reservado, espere 3 minutos a que sea liberado el lugar por el sistema y vuelva a intentar.');
        location.href = "index.jsp";
        //document.getElementById('curp').focus();
    <%
        }

        if (error == 8) { %>
        alert('La escuela que eligio ha llenado los lugares disponibles para el d\u00eda de hoy, por favor seleccione otra escuela.');
        location.href = "index.jsp";
        //document.getElementById('curp').focus();
    <%
        }

        if (error == 9) { %>
        alert('Error de conexi&oacute;n, por favor intente de nuevo realizar su pre inscripci&oacute;n.');
        location.href = "index.jsp";
        //document.getElementById('curp').focus();

    <%
        }

        if (error == 99) { %>
        alert('Error de conexi&oacute;n, por favor intente de nuevo realizar su pre inscripci&oacute;n.');
        location.href = "preinscribirDir.jsp";
        //document.getElementById('curp').focus();

    <%
        }
        if (error == 1) { %>
        alert('Uno o más campos están vacíos. Ingrese una CURP o clave de Centro de Trabajo válidas.');
        location.href = "index.jsp";
        //document.getElementById('curp').focus();
    <%
        }
        if (error == 22) { %>
        alert('Campo vacío. Ingrese una CURP válida.');
        location.href = "preinscribirDir.jsp";
        //document.getElementById('curp').focus();

    <%
        }
        if (error == 222) { %>
        alert('Campo vacío. Ingrese una CURP válida.');
        location.href = "consultaFolio.jsp";
        //document.getElementById('curp').focus();

    <%
        }
        if (error == 2) { %>
        alert('El día de hoy no le corresponde inscribirse a la letra inicial de su clave CURP. Revise la convocatoria para conocer que día le toca Pre-Inscribirse.');
        location.href = "index.jsp";
        //document.getElementById('curp').focus();

    <%
        }
        if (error == 23) { %>
        alert('El día de hoy no le corresponde inscribirse a la letra inicial de su clave CURP. Revise la convocatoria para conocer que día le toca Pre-Inscribirse.');
        location.href = "preinscribirDir.jsp";
        //document.getElementById('curp').focus();

    <%
        }
        if (error == 3) { %>
        alert('Debe especificar una clave de escuela valida.');
        location.href = "index.jsp";
        //document.getElementById('curp').focus();

    <%
        }
        if (error == 10) { %>
        alert('Esta CURP no esta registrada en renapo.');
        location.href = "index.jsp";
        //document.getElementById('curp').focus();

    <%
        }
        if (error == 110) { %>
        alert('Esta CURP no esta registrada en renapo.');
        location.href = "index.jsp";
        //document.getElementById('curp').focus();

    <%
        }
        if (error == 120) { %>
        alert('Esta CURP no esta registrada en renapo.');
        location.href = "preinscribirDir.jsp";
        //document.getElementById('curp').focus();

    <%
        }
        if (error == 1200) { %>
        alert('El curp del alumno no está registrado en el sistema.');
        location.href = "preinscribirDir.jsp";
        //document.getElementById('curp').focus();

    <%
        }
        if (error == 12) { %>
        alert('Formato de CURP incorrecta, ingrese una CURP válida.');
        location.href = "index.jsp";
        //document.getElementById('curp').focus();
    <%
        }
        if (error == 13) { %>
        alert('Formato de clave de Centro de Trabajo incorrecta, ingrese una clave válida.');
        location.href = "index.jsp";
        //document.getElementById('curp').focus();
    <%
        }
        if (error == 122) { %>
        alert('Formato de CURP incorrecta, ingrese una CURP válida.');
        location.href = "preinscribirDir.jsp";
        //document.getElementById('curp').focus();
    <%
        }
        if (error == 133) { %>
        alert('Formato de clave de Centro de Trabajo incorrecta, ingrese una clave válida.');
        location.href = "preinscribirDir.jsp";
        //document.getElementById('curp').focus()
    <%
        }
        if (error == 14) { %>
        alert('El aspirante no cuenta con la edad indicada para ingresar a educación secundaria.');
        location.href = "index.jsp";
        //document.getElementById('curp').focus();

    <%
        }
        if (error == 144) { %>
        alert('El aspirante no cuenta con la edad indicada para ingresar a educación secundaria.');
        location.href = "preinscribirDir.jsp";
        //document.getElementById('curp').focus();

    <%
        }
        if (error == 145) { %>
        alert('Ha ingresado un formato de mes inválido.');
        location.href = "datos_alumno_sincurp.jsp";
        //document.getElementById('curp').focus();

    <%
        }
        if (error == 146) { %>
        alert('Ha ingresado un formato de día inválido.');
        location.href = "datos_alumno_sincurp.jsp";
        //document.getElementById('curp').focus();

    <%
        }
        if (error == 88) { %>
        alert('Ya no tiene lugares disponibles.');
        location.href = "preinscribirDir.jsp";
        //document.getElementById('curp').focus();

    <%
        }
        if (error == 665) { %>
        alert('El alumno ya esta preinscrito');
        location.href = "preinscribirDir.jsp";



    <%
        }
        if (error == 777) { %>
        alert('Debe especificar una CURP valida');
        location.href = "pre_dir.jsp";
        //document.getElementById('curp').focus();

    <%
        }
        if (error == 111) { %>
        alert('El centro de trabajo o la contraseña son incorrectos');
        location.href = "loginsuper.jsp";

    <%
        }
        if (error == 112) { %>
        alert('El centro de trabajo o la contraseña son incorrectos');
        location.href = "logindir.jsp";

    <%
        }
        if (error == 17) { %>
        alert('Centro de trabajo no válido.');
        location.href = "logindir.jsp";

    <%
        }
        if (error == 117) {
    %>
        alert('Centro de trabajo no válido.');
        location.href = "logindir.jsp";

    <%
        }
        if (error == 1117) {
    %>
        var CT = document.getElementById("ct").value;
        var nombreCT = document.getElementById("nombre_ct").value;
        //alert('El alumno ya se encuentra preinscrito en la escuela ' + nombreCT + ' con clave' + CT + '.');
        alert('El alumno ya se encuentra preinscrito en la escuela ' + nombreCT + ' con clave ' + CT + '.');
        location.href = "preinscribirDir.jsp";

    <%
        }
        if (error == 333) { %>
        alert('El alumno con la CURP ingresada no está preinscrito');
        location.href = "index.jsp";

    <%
        }
        if (error == 115) { %>
        alert('El centro de trabajo o la contraseña son incorrectos');
        location.href = "loginadmin.jsp";

    <%  }
        if (error == 204) { %>
        alert('El alumno no está cursando actualmente el 6° grado de primaria en el estado de Morelos, o proviene de otra entidad');
        location.href = "index.jsp";
    <%
            }
        }
    %>
    });
</script>