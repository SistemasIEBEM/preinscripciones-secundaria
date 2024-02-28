<table class="table table-condensed table-responsive">
    <tr>
        <td style="font-weight:bold;">CURP del aspirante:</td>
        <td><%=curp%></td>        
    <tr>
        <td style="font-weight:bold;">Nombre(s) completo del aspirante:</td>
        <td>
            <%=nombre1%> <%=paterno%> <%=materno%>
        </td>
    </tr>
</table>
<div>
    <div class='form-group'>
        <label style="font-weight:bold; width:200px">CURP del padre ó tutor:<font color="red">*</font></label>
        <div class="input-group">
            <div class="input-group-prepend">
                <button class="btn btn-outline-primary" type="button" onclick="consultar(document.getElementById('curpT').value)">Consultar</button>
            </div>
            <input type="text" class="form-control" placeholder="Ingrese su CURP" aria-label="Ingrese su CURP" aria-describedby="basic-addon2" onkeyup="mayus(this);" name="curpT" id="curpT" maxlength="18">
        </div>
    </div>
    <div class='form-group'>
        <h1 style="font-size: 14px; font-weight:bold;">
            "Para consultar su CURP, acceda a la siguiente dirección: <a href="https://www.gob.mx/curp" target="_blank">https://www.gob.mx/curp</a>".
        </h1>
    </div>
    <div class='form-group'>
        <label style="font-weight:bold;">Nombre:<font color="red">*</font></label>
        <input id="nombreT" name="nombreT" size="67" onkeyup="mayus(this);" class="form-control" readonly/>
    </div>
    <div class='form-group'>
        <label style="font-weight:bold;">Apellido paterno:<font color="red">*</font></label>
        <input id="apPaterno" name="apPaterno" size="67" onkeyup="mayus(this);" class="form-control" readonly/>
    </div>
    <div class='form-group'>
        <label style="font-weight:bold;">Apellido materno:<font color="red">*</font></label>
        <input id="apMaterno" name="apMaterno" size="67" onkeyup="mayus(this);" class="form-control" readonly/>
    </div>
    <div class='form-group'>
        <label style="font-weight:bold;">Entidad de nacimiento:<font color="red">*</font></label>
        <input id="entidad" name="entidad" size="67" onkeyup="mayus(this);" class="form-control" readonly/>
    </div>                                    
    <div class='form-group'>
        <label style="font-weight:bold;">Fecha nacimiento:<font color="red">*</font></label>
        <input id="fechanac" name="fechanac" size="67" onkeyup="mayus(this);" class="form-control" readonly/>
    </div>
    <div class='form-group'>
        <label style="font-weight:bold;">Sexo:<font color="red">*</font></label>
        <input id="sexoT" name="sexoT" size="67" onkeyup="mayus(this);"class="form-control" readonly/>
    </div>
    <div class='form-group'>
        <label style="font-weight:bold;">Municipio actual:<font color="red">*</font></label>
        <select id="municipio" name="municipio" class="form-control" disabled>
            <option value="00">Seleccione un municipio</option>
            <option value="Amacuzac">Amacuzac</option>
            <option value="Atlatlahucan">Atlatlahucan</option>
            <option value="Axochiapan">Axochiapan</option>
            <option value="Ayala">Ayala</option>
            <option value="Coatlan del Rio">Coatl&aacute;n del R&iacute;o</option>
            <option value="Cuautla">Cuautla</option>
            <option value="Cuernavaca">Cuernavaca</option>
            <option value="Emiliano Zapata">Emiliano Zapata</option>
            <option value="Huitzilac">Huitzilac</option>
            <option value="Jantetelco">Jantetelco</option>
            <option value="Jiutepec">Jiutepec</option>
            <option value="Jojutla">Jojutla</option>
            <option value="Jonacatepec de Leandro Valle">Jonacatepec de Leandro Valle</option>
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
            <option value="Tlaltizapan de Zapata">Tlaltizap&aacute;n de Zapata</option>
            <option value="Tlaquiltenango">Tlaquiltenango</option>
            <option value="Tlayacapan">Tlayacapan</option>
            <option value="Totolapan">Totolapan</option>
            <option value="Xochitepec">Xochitepec</option>
            <option value="Yautepec">Yautepec</option>
            <option value="Yecapixtla">Yecapixtla</option>
            <option value="Zacatepec">Zacatepec de Hidalgo</option>
            <option value="Zacualpan de Amilpas">Zacualpan de Amilpas</option>
        </select>
    </div>
    <div class='form-group'>
        <label style="font-weight:bold;">Domicilio particular:<font color="red">*</font></label>
        <input id="domicilio" name="domicilio" onKeyUp="this.value = this.value.toUpperCase()" class="form-control" disabled/>
    </div>
    <div class='form-group'>
        <label style="font-weight:bold;">Correo de contacto:</label>
        <input id="correo" name="correo" size="67" class="form-control" disabled/>
    </div>
    <div class='form-group'>
        <label style="font-weight:bold;">Teléfono:</label>
        <input id="telefono" name="telefono" size="16" maxlength="10" onkeypress="ValidaSoloNumeros()" class="form-control" disabled/>
    </div>

    <button id="botonPre" class="btn btn-primary" name="botonPre" type="submit">
        <i class="fas fa-save"></i> 
        PRE-INSCRIBIR
    </button>

</div>