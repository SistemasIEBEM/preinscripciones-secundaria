/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoImpl;

import Bean.BeanPreinscribirPadres;
import Dao.DaoDirectores;
import java.sql.SQLException;

public class FachadaDirectores {

    public Boolean getPreinscribirDir(String curp, String ct, String paterno, String materno, String nombre, String fecha_nac, String sexo, String edo_nac, String grado, String municipio, String direccion, String telefono, String tutor_curp, String tutor_nombre, String tutor_apPaterno, String tutor_apMaterno, String tutor_entidad, String tutor_fecha, String tutor_sexo, String correo) throws SQLException {
        DaoDirectores PreinscribirDir = new DaoDirectores();
        return PreinscribirDir.getPreinscribirDirectores(curp, ct, paterno, materno, nombre, fecha_nac, sexo, edo_nac, grado, municipio, direccion, telefono, tutor_curp, tutor_nombre, tutor_apPaterno, tutor_apMaterno, tutor_entidad, tutor_fecha, tutor_sexo, correo);
    }

    public Boolean getPreinscribirDirSinCurp(String curp, String ct, String paterno, String materno, String nombre, String fecha_nac, String sexo, String edo_nac, String grado, String municipio, String direccion, String telefono, String tutor_curp, String tutor_nombre, String tutor_apPaterno, String tutor_apMaterno, String tutor_entidad, String tutor_fecha, String tutor_sexo, String correo) throws SQLException {
        DaoDirectores PreinscribirDir = new DaoDirectores();
        return PreinscribirDir.getPreinscribirDirectoresSinCurp(curp, ct, paterno, materno, nombre, fecha_nac, sexo, edo_nac, grado, municipio, direccion, telefono, tutor_curp, tutor_nombre, tutor_apPaterno, tutor_apMaterno, tutor_entidad, tutor_fecha, tutor_sexo, correo);
    }

    public BeanPreinscribirPadres getDatosDir(String curp) throws SQLException {
        DaoDirectores PreinscribirDir = new DaoDirectores();
        return PreinscribirDir.getDatosPres(curp);
    }

    public BeanPreinscribirPadres getDatosDirSinCurp(String paterno, String materno, String nombre, String grado) throws SQLException {
        DaoDirectores PreinscribirDir = new DaoDirectores();
        return PreinscribirDir.getDatosPresSinCurp(paterno, materno, nombre, grado);
    }

}
