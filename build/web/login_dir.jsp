<form class="form-signin" action="<%=context%>/ServletLogin" method="post">
    <div class="form-group">
        <center><label for="exampleFormControlInput1">CLAVE DE CENTRO DE TRABAJO:</label></center>
        <input type="text" class="form-control" placeholder="EJEMPLO: 17DPR0006R" name="ct" style="text-transform:uppercase;">
    </div>
    <div class="form-group">
        <center><label for="exampleFormControlInput1">CONTRASEÑA:</label></center>
        <input type="password" class="form-control" placeholder="EJEMPLO: 123456 (CONTRASEÑA DE LA 911)" name="pass" style="text-transform:uppercase;">
    </div>
    <input type="hidden" name="valida" value="1">
    <hr>
    <div class="row">
        <div class="col">
            <button class="btn btn-primary btn-block">
                <i class="fas fa-user"></i> 
                INGRESAR
            </button>
        </div>
        <div class="col">
            <!--<a class="btn btn-danger btn-block" href="http://escolar.iebem.edu.mx/secundaria/index.jsp">-->
            <a class="btn btn-danger btn-block" href="<%=context%>/index.jsp">
                <i class="fas fa-reply"></i> 
                REGRESAR
            </a>
        </div>
        <div class="col">
            <!--<a class="btn btn-success btn-block" href="#success" data-toggle="modal">
                <i class="fas fa-bars"></i> 
                AYUDA
            </a>-->
            <button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#abrete">
                <i class="fas fa-bars"></i> 
                AYUDA
            </button>
        </div>        
    </div>
</form>