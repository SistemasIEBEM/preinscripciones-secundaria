/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoImpl;

import Bean.BeanEscuela;
import Bean.BeanInscribir;
import Bean.BeanInscribirResultado;
import Dao.DaoAlumno;
import Dao.DaoEscuela;
import Dao.DaoPadres;
import java.sql.SQLException;
import java.util.Collection;

/**
 *
 * @author daniel.vazquez
 */
public class FachadaPadres {

    public Boolean getActualiza(String curp, String folio, String municipio, String direccion, String telefono, String tutor_curp, String tutor_nombre, String tutor_apPaterno, String tutor_apMaterno, String tutor_entidad, String tutor_fecha, String tutor_sexo, String correo) throws SQLException {
        DaoPadres PreinscribirPadre = new DaoPadres();
        return PreinscribirPadre.getDatosACtualizados(curp, folio, municipio, direccion, telefono, tutor_curp, tutor_nombre, tutor_apPaterno, tutor_apMaterno, tutor_entidad, tutor_fecha, tutor_sexo, correo);
    }

    public Collection<BeanEscuela> getEscuelas(String ct) throws SQLException {
        DaoEscuela MuestraCTS = new DaoEscuela();
        Collection<BeanEscuela> listaEscuelas = MuestraCTS.getEscuelas(ct);
        return listaEscuelas;
    }
    
    public int logcurp (String curp) throws SQLException{
     DaoPadres log = new DaoPadres();
     return log.logValida(curp);
    }

    public BeanInscribirResultado getDatosPreinscribir(BeanInscribir DNIdatos) throws SQLException {
        DaoPadres obtenDNIdatos = new DaoPadres();
        return obtenDNIdatos.getPreinscribirPadres(DNIdatos);
    }

    public BeanInscribirResultado getDatosFinal(String curp) throws SQLException {
        DaoPadres DatosFinal = new DaoPadres();
        return DatosFinal.getDatosPres(curp);
    }

    public String getFecha(String curp) throws SQLException {
        DaoPadres fechaAl = new DaoPadres();
        return fechaAl.consultafecha(curp);
    }

}
