/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Bean.BeanPreinscribirPadres;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 *
 * @author Registro
 */
public class DaoDirectores {

    Connection conexion = null;
    PreparedStatement stm = null;
    ResultSet rs = null;

       public Boolean getPreinscribirDirectores(String curp, String ct, String paterno, String materno, String nombre, String fecha_nac, String sexo, String edo_nac, String grado, String municipio, String direccion, String telefono, String tutor_curp, String tutor_nombre, String tutor_apPaterno, String tutor_apMaterno, String tutor_entidad, String tutor_fecha, String tutor_sexo, String correo) throws SQLException {
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
            String Query1 = "Exec preinscrbirDir  ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
            stm = conexion.prepareStatement(Query1);
            stm.setString(1, curp);
            stm.setString(2, ct);
            stm.setString(3, paterno);
            stm.setString(4, materno);
            stm.setString(5, nombre);
            stm.setString(6, fecha_nac);
            stm.setString(7, sexo);
            stm.setString(8, edo_nac);
            stm.setString(9, grado);
            stm.setString(10, municipio);
            stm.setString(11, direccion);
            stm.setString(12, telefono);
            stm.setString(13, tutor_curp);
            stm.setString(14, tutor_nombre);
            stm.setString(15, tutor_apPaterno);
            stm.setString(16, tutor_apMaterno);
            stm.setString(17, tutor_entidad);
            stm.setString(18, tutor_fecha);
            stm.setString(19, tutor_sexo);
            stm.setString(20, correo);
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

    public Boolean getPreinscribirDirectoresSinCurp(String curp, String ct, String paterno, String materno, String nombre, String fecha_nac, String sexo, String edo_nac, String grado, String municipio, String direccion, String telefono, String tutor_curp, String tutor_nombre, String tutor_apPaterno, String tutor_apMaterno, String tutor_entidad, String tutor_fecha, String tutor_sexo, String correo) throws SQLException {
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
            String Query1 = "Exec preinscrbirSinCURP  ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
            stm = conexion.prepareStatement(Query1);
            stm.setString(1, curp);
            stm.setString(2, ct);
            stm.setString(3, paterno);
            stm.setString(4, materno);
            stm.setString(5, nombre);
            stm.setString(6, fecha_nac);
            stm.setString(7, sexo);
            stm.setString(8, edo_nac);
            stm.setString(9, grado);
            stm.setString(10, municipio);
            stm.setString(11, direccion);
            stm.setString(12, telefono);
            stm.setString(13, tutor_curp);
            stm.setString(14, tutor_nombre);
            stm.setString(15, tutor_apPaterno);
            stm.setString(16, tutor_apMaterno);
            stm.setString(17, tutor_entidad);
            stm.setString(18, tutor_fecha);
            stm.setString(19, tutor_sexo);
            stm.setString(20, correo);
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

    public BeanPreinscribirPadres getDatosPres(String curp) throws SQLException {
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
        BeanPreinscribirPadres pre = new BeanPreinscribirPadres();
        try {
            String Query = "Select a.folio as folio, a.curp as curp, a.nombre as nombre, a.paterno as paterno, a.materno as materno, a.ct as ct, b.nombre as nombre_ct, b.direccion as direccion, b.municipio as ct_dir, b.turno as turno  from dbo.pres a inner join dbo.ct b on a.ct=b.ct Where curp = ?";
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
                pre.setCt_dir(rs.getString("ct_dir"));
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

    public BeanPreinscribirPadres getDatosPresSinCurp(String paterno, String materno, String nombre, String grado) throws SQLException {
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
        BeanPreinscribirPadres pre = new BeanPreinscribirPadres();
        try {
            String Query = "Select a.folio, a.curp, a.nombre, a.paterno, a.materno, a.ct, b.nombre as nombre_ct, b.direccion as direccion, b.municipio as ct_dir, b.turno as turno from dbo.pres a inner join dbo.ct b on a.ct=b.ct  Where paterno = ? and materno = ? and a.nombre = ? and grado = ?";
            stm = conexion.prepareStatement(Query);
            stm.setString(1, paterno);
            stm.setString(2, materno);
            stm.setString(3, nombre);
            stm.setString(4, grado);
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
                pre.setCt_dir(rs.getString("ct_dir"));
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

    public Boolean getDatosACtualizados(String curp, String folio, String municipio, String direccion, String telefono) throws SQLException {
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
            String Query1 = "Exec  dbo.actualiza_datos ?,?,?,?,?";
            stm = conexion.prepareStatement(Query1);
            stm.setString(1, curp);
            stm.setString(2, folio);
            stm.setString(3, municipio);
            stm.setString(4, direccion);
            stm.setString(5, telefono);
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

}
