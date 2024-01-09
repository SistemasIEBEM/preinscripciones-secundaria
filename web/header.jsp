<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<!-- Header -->
<%  
    Date anio = new Date();
    SimpleDateFormat ft = new SimpleDateFormat("yyyy");
    String c1 = ft.format(anio);
    String ciclo = c1 + " - " + (Integer.parseInt(c1)+1);
%>
<div id="site">
    <title>PREINSCRIPCIONES EN LINEA</title>
    <div id="header-wrapper">
        <header id="header" class="container">
            <div id="logo">
                <div id="logo-sipreeb"></div>
            </div>
            <nav id="nav">
                <div id="logo-iebem"></div>
            </nav>
        </header>
    </div>
</div>

