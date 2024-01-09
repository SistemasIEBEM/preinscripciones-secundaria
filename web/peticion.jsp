<!-- Formulario -->
<form class="form-signin" action="<%=context%>/ServletProcesaDatos" method="post" id="formvalida" name="formvalida">
    <h5>
        <center>
            <b>PREINSCRIPCIÓN PARA PADRES</b>
        </center>
    </h5>
    <hr>
    <div class="form-group">
        <center><label for="exampleFormControlInput1">INGRESE LA CURP:</label></center>
        <input type="text" class="form-control" placeholder="EJEMPLO: ABCD123456HMSERFA9" name="curp" id="curp" style="text-transform:uppercase;">
    </div>
    <div class="form-group">
        <center><label for="exampleFormControlInput1">CLAVE DE LA PRIMARIA DONDE CURSA ACTUALMENTE EL 6to GRADO:</label></center>
        <input type="text" class="form-control" placeholder="EJEMPLO: 17DPR0006R" name="ct" id="ct" style="text-transform:uppercase;">
    </div>
    <hr>
    <div class="row">
        <!--<div class="col-lg-12">-->
        <div class="col">
            <button type="submit" class="btn btn-primary btn-block">
                <i class="fas fa-play"></i> 
                CONTINUAR
            </button>
        </div>
        <div class="col">
            <!--<a class="btn btn-success btn-block" href="#abrete" data-toggle="modal" data-bs-target="#abrete">
                <i class="fas fa-bars"></i> 
                AYUDA
            </a>-->
            <button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#abrete">
                <i class="fas fa-bars"></i> 
                AYUDA
            </button>
        </div>
        <!--</div> --> 
    </div>
</form>


