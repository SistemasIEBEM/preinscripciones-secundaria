<!-- Formulario -->
<form class="form-signin" action="<%=context%>/ServletProcesaDatosDir" method="post" id="formvalida" name="formvalida">
    <div class="form-group" id="inputText">
        <center><label for="exampleFormControlInput1">CURP:</label></center>
        <input type="text" class="form-control" placeholder="EJEMPLO: ABCD123456HMSERFA9" name="curp" id="curp" style="text-transform:uppercase;">
    </div>
    <input type="hidden" name="ct" id="ct" value="<%=nombre%>"/>
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
                <button type="reset" class="btn btn-warning btn-block" onclick="location.href = '<%=context%>/datos_alumno_sincurp.jsp'">
                    <i class="fas fa-user"></i> 
                    PRE-INSCRIBIR SIN CURP
                </button>
            </div>
            <div class="col">
                <a class="btn btn-danger btn-block" href="<%=context%>/menudir.jsp">
                    <i class="fas fa-reply"></i> 
                    REGRESAR
                </a>
            </div> 
        <!--</div>-->
    </div>
</form>
