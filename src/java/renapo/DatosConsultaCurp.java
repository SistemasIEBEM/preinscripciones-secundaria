/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renapo;

/**
 *
 * @author 20iebem13
 */
public class DatosConsultaCurp {

    private String direccionIp;
    private int tipoTransaccion;
    private String usuario;
    private String password;
    private String cveCurp;
    private String cveEntidadEmisora;
    
    public DatosConsultaCurp(){
        super();
    }

    public DatosConsultaCurp(String direccionIp, int tipoTransaccion, String usuario, String password, String cveCurp, String cveEntidadEmisora) {
        this.direccionIp = direccionIp;
        this.tipoTransaccion = tipoTransaccion;
        this.usuario = usuario;
        this.password = password;
        this.cveCurp = cveCurp;
        this.cveEntidadEmisora = cveEntidadEmisora;
    }

    public String getDireccionIp() {
        return direccionIp;
    }

    public void setDireccionIp(String direccionIp) {
        this.direccionIp = direccionIp;
    }

    public int getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(int tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCveCurp() {
        return cveCurp;
    }

    public void setCveCurp(String cveCurp) {
        this.cveCurp = cveCurp;
    }

    public String getCveEntidadEmisora() {
        return cveEntidadEmisora;
    }

    public void setCveEntidadEmisora(String cveEntidadEmisora) {
        this.cveEntidadEmisora = cveEntidadEmisora;
    }

    
}
