/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.sql.Date;

/**
 *
 * @author David Costet
 */
public class BeanPres {

    private String folio;
    private String curp;
    private String paterno;
    private String materno;
    private String nombre;
    private Date fecha;
    private String sexo;
    private String edonac;
    private String ct;
    private int grado;
    private int modo;
    private String dom_direccion;
    private String telefono;
    private String tutor_nombre;
    public String tutor_apPaterno;
    public String tutor_apMaterno;
    private String correo;

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEdonac() {
        return edonac;
    }

    public void setEdonac(String edonac) {
        this.edonac = edonac;
    }

    public String getCt() {
        return ct;
    }

    public void setCt(String ct) {
        this.ct = ct;
    }

    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }

    public int getModo() {
        return modo;
    }

    public void setModo(int modo) {
        this.modo = modo;
    }

    public String getDom_direccion() {
        return dom_direccion;
    }

    public void setDom_direccion(String dom_direccion) {
        this.dom_direccion = dom_direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTutor_nombre() {
        return tutor_nombre;
    }

    public void setTutor_nombre(String tutor_nombre) {
        this.tutor_nombre = tutor_nombre;
    }

    public String getTutor_apPaterno() {
        return tutor_apPaterno;
    }

    public void setTutor_apPaterno(String tutor_apPaterno) {
        this.tutor_apPaterno = tutor_apPaterno;
    }

    public String getTutor_apMaterno() {
        return tutor_apMaterno;
    }

    public void setTutor_apMaterno(String tutor_apMaterno) {
        this.tutor_apMaterno = tutor_apMaterno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

}
