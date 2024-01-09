<%-- 
    Document   : login_admin
    Created on : 10-ene-2017, 8:35:16
    Author     : David Costet
--%>

<form class="form-signin" action="<%=context%>/ServletLogin" method="post" name="formvalidasuper" id="formvalidasuper" onsubmit="return valida_admin();">
    <div class="form-group">
        <center><label for="exampleFormControlInput1">CLAVE DE CENTRO DE TRABAJO:</label></center>
        <input type="text" class="form-control" placeholder="EJEMPLO: 17ADG0001C" id="ct" name="ct" style="text-transform:uppercase;">
    </div>
    <div class="form-group">
        <center><label for="exampleFormControlInput1">CONTRASEÑA:</label></center>
        <input type="password" class="form-control" placeholder="EJEMPLO: 123456" id="contra" name="contra" style="text-transform:uppercase;">
    </div>
    <input type="hidden" name="valida" value="3">
    <hr>
    <div class="row">
        <div class="col">
            <button class="btn btn-primary btn-block">
                <i class="fas fa-user"></i> 
                INGRESAR
            </button>
        </div>
        <div class="col">
            <a class="btn btn-danger btn-block" href="<%=context%>/index.jsp">
                <i class="fas fa-reply"></i> 
                REGRESAR
            </a>
        </div>
        <div class="col">
            <!--<a class="btn btn-success btn-block" href="#success" data-toggle="modal">
                <i class="fas fa-columns"></i> 
                AYUDA
            </a>-->
            <button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#abrete">
                <i class="fas fa-bars"></i> 
                AYUDA
            </button>
        </div>        
    </div>
</form>