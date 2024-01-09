/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Bean.BeanInscribir;
import Bean.BeanInscribirResultado;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.TimeZone;

/**
 *
 * @author Mike
 */
public class DaoPadres {

    Connection conexion = null;
    PreparedStatement stm = null;
    ResultSet rs = null;

    public BeanInscribirResultado getPreinscribirPadres(BeanInscribir DNIdatos) throws SQLException {
        ResourceBundle archivoConfiguracion = ResourceBundle.getBundle("Conexion/conexion");
        try {
            Class.forName(archivoConfiguracion.getString("manejador"));
            String url = archivoConfiguracion.getString("cadenaconexion");
            conexion = DriverManager.getConnection(url);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error1 en la Conexión con la BD");
            conexion = null;
        } catch (SQLException ex) {
            System.out.println("Error1 en la Conexión con la BD");
            conexion = null;
        } catch (Exception ex) {
            //out.println("Error1 en la Conexión con la BD");
            conexion = null;
        }
        BeanInscribirResultado resultadoPre = new BeanInscribirResultado();
        try {
            String Query1 = "Exec  dbo.preinscrbirPadres ?,?,?,?,?,?,?,?,?";
            stm = conexion.prepareStatement(Query1);
            stm.setString(1, DNIdatos.getCurp());
            stm.setString(2, DNIdatos.getPaterno());
            stm.setString(3, DNIdatos.getMaterno());
            stm.setString(4, DNIdatos.getNombre());
            stm.setDate(5, DNIdatos.getFecha_nac());
            stm.setString(6, DNIdatos.getSexo());
            stm.setString(7, DNIdatos.getEdo_nac());
            stm.setString(8, DNIdatos.getCt_destino());
            stm.setString(9, DNIdatos.getGrado());
            rs = stm.executeQuery();
            while (rs.next()) {
                resultadoPre.setError(rs.getString("error"));
                resultadoPre.setFolio(rs.getString("folio"));
                resultadoPre.setCurp(rs.getString("curp"));
                resultadoPre.setNombre(rs.getString("nombre"));
                resultadoPre.setPaterno(rs.getString("paterno"));
                resultadoPre.setMaterno(rs.getString("materno"));
                resultadoPre.setCt(rs.getString("ct"));
                resultadoPre.setNombre_ct(rs.getString("nombre_ct"));
                resultadoPre.setDireccion(rs.getString("direccion"));
                resultadoPre.setMunicipio(rs.getString("municipio"));
                resultadoPre.setTurno(rs.getString("turno"));
            }
            rs.close();
            stm.close();
            conexion.close();
        } catch (SQLException e) {
            e.getMessage();
            conexion.close();
        }
        return resultadoPre;
    }

    public BeanInscribirResultado getDatosPres(String curp) throws SQLException {
        ResourceBundle archivoConfiguracion = ResourceBundle.getBundle("Conexion/conexion");
        try {
            Class.forName(archivoConfiguracion.getString("manejador"));
            String url = archivoConfiguracion.getString("cadenaconexion");
            conexion = DriverManager.getConnection(url);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error1 en la Conexión con la BD");
            conexion = null;
        } catch (SQLException ex) {
            System.out.println("Error1 en la Conexión con la BD");
            conexion = null;
        } catch (Exception ex) {
            //out.println("Error1 en la Conexión con la BD");
            conexion = null;
        }
        BeanInscribirResultado pre = new BeanInscribirResultado();
        try {
            String Query = "Select a.folio as folio, a.curp as curp, a.nombre as nombre, a.paterno as paterno, a.materno as materno, a.ct as ct, b.nombre as nombre_ct, b.direccion as direccion, b.municipio as municipio, b.turno as turno from dbo.pres a inner join dbo.ct b on a.ct=b.ct Where curp = ?";
            stm = conexion.prepareStatement(Query);
            stm.setString(1, curp);
            rs = stm.executeQuery();
            while (rs.next()) {
                pre.setFolio(rs.getString("folio"));
                pre.setCurp(rs.getString("curp"));
                pre.setNombre(rs.getString("nombre"));
                pre.setPaterno(rs.getString("paterno"));
                pre.setMaterno(rs.getString("materno"));
                pre.setCt(rs.getString("ct"));
                pre.setNombre_ct(rs.getString("nombre_ct"));
                pre.setDireccion(rs.getString("direccion"));
                pre.setMunicipio(rs.getString("municipio"));
                pre.setTurno(rs.getString("turno"));
            }
            rs.close();
            stm.close();
            conexion.close();
        } catch (SQLException e) {
            e.getMessage();
            conexion.close();
        }
        return pre;
    }

    public Boolean getDatosACtualizados(String curp, String folio, String municipio, String direccion, String telefono, String tutor_curp, String tutor_nombre, String tutor_apPaterno, String tutor_apMaterno, String tutor_entidad, String tutor_fecha, String tutor_sexo, String correo) throws SQLException {
        ResourceBundle archivoConfiguracion = ResourceBundle.getBundle("Conexion/conexion");
        try {
            Class.forName(archivoConfiguracion.getString("manejador"));
            String url = archivoConfiguracion.getString("cadenaconexion");
            conexion = DriverManager.getConnection(url);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error1 en la Conexión con la BD");
            conexion = null;
        } catch (SQLException ex) {
            System.out.println("Error1 en la Conexión con la BD");
            conexion = null;
        } catch (Exception ex) {
            //out.println("Error1 en la Conexión con la BD");
            conexion = null;
        }
        try {
            String Query1 = "Exec  dbo.actualiza_datos ?,?,?,?,?,?,?,?,?,?,?,?,?";
            stm = conexion.prepareStatement(Query1);
            stm.setString(1, curp);
            stm.setString(2, folio);
            stm.setString(3, municipio);
            stm.setString(4, direccion);
            stm.setString(5, telefono);
            stm.setString(6, tutor_curp);
            stm.setString(7, tutor_nombre);
            stm.setString(8, tutor_apPaterno);
            stm.setString(9, tutor_apMaterno);
            stm.setString(10, tutor_entidad);
            stm.setString(11, tutor_fecha);
            stm.setString(12, tutor_sexo);
            stm.setString(13, correo);
            rs = stm.executeQuery();
            rs.close();
            stm.close();
            conexion.close();
        } catch (SQLException e) {
            e.getMessage();
            conexion.close();
        }
        return true;
    }


    public String consultafecha(String curpAl) throws SQLException {
        String fecha = null;
        ResourceBundle archivoConfiguracion = ResourceBundle.getBundle("Conexion/conexion");
        try {
            Class.forName(archivoConfiguracion.getString("manejador"));
            String url = archivoConfiguracion.getString("cadenaconexion");
            conexion = DriverManager.getConnection(url);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error1 en la Conexión con la BD");
            conexion = null;
        } catch (SQLException ex) {
            System.out.println("Error1 en la Conexión con la BD");
            conexion = null;
        } catch (Exception ex) {
            //out.println("Error1 en la Conexión con la BD");
            conexion = null;
        }
        try {
            String query = "select fechaCaptura from pres  where curp='" + curpAl + "'";
            stm = conexion.prepareStatement(query);
            rs = stm.executeQuery();
            rs.next();
            fecha = rs.getString("fechaCaptura");
            rs.close();
            conexion.close();
        } catch (SQLException e) {
            e.getMessage();
            conexion.close();
        }
        return fecha;
    }
    
     public int logValida(String curp) throws SQLException {
        Calendar fecha = Calendar.getInstance(TimeZone.getTimeZone("America/Mexico_City"));
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH) + 1;
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int minuto = fecha.get(Calendar.MINUTE);
        int segundo = fecha.get(Calendar.SECOND);
        String fechacompleta = año + "-" + mes + "-" + dia+" "+hora+":"+minuto+":"+segundo;
         System.out.println("fecha completa : "+ fechacompleta);
        ResourceBundle archivoConfiguracion = ResourceBundle.getBundle("Conexion/conexion");
        try {
            Class.forName(archivoConfiguracion.getString("manejador"));
            String url = archivoConfiguracion.getString("cadenaconexion");
            conexion = DriverManager.getConnection(url);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error1 en la Conexión con la BD");
        } catch (SQLException ex) {
            System.out.println("Error1 en la Conexión con la BD");
        } catch (Exception ex) {
            //out.println("Error1 en la Conexión con la BD");
        }
        int result=0;
        try {
            String Query = "Exec SP_LogINCurp ?,?";

            stm = conexion.prepareStatement(Query);
            stm.setString(1, curp);
            stm.setString(2,fechacompleta);
            rs = stm.executeQuery();          
            rs.close();
            stm.close();
            conexion.close();
        } catch (SQLException e) {
            e.getMessage();
            conexion.close();
        }
        return result;
    }

}
