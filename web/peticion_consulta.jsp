<!-- Formulario -->
<form class="form-signin" action="<%=context%>/ServletConsultaFolio" method="post" id="formvalida" name="formvalida">
    <div class="form-group" id="inputText">
        <center><label for="exampleFormControlInput1">CURP:</label></center>
        <input type="text" class="form-control" placeholder="EJEMPLO: ABCD123456HMSERFA9" name="curp" id="curp" style="text-transform:uppercase;">
    </div>
    <hr>
    <div class="row">
        <!--<div class="col-lg-12">-->
            <div class="col">
                <button type="submit" class="btn btn-primary btn-block">
                    <i class="fas fa-search"></i> 
                    CONTINUAR
                </button>
            </div>
            <div class="col">
                <a class="btn btn-success btn-block" href="#success" data-toggle="modal">
                  <i class="fas fa-bars"></i>
                    AYUDA
                </a>
            </div>
            <div class="col">
                <a class="btn btn-danger btn-block" href="<%=context%>/index.jsp">
                    <i class="fas fa-reply"></i>
                    REGRESAR
                </a>
            </div>
        <!--</div>-->
    </div>
</form>
