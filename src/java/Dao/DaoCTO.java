/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Bean.BeanCTO;
import Bean.BeanCurp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 *
 * @author Mike
 */
public class DaoCTO {

    Connection conexion = null;
    PreparedStatement stm = null;
    ResultSet rs = null;

    public BeanCTO getCt(String claveCt) throws SQLException {
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
        BeanCTO ct = new BeanCTO();
        try {
            String Query = "Exec validaCT ?";
            stm = conexion.prepareStatement(Query);
            stm.setString(1, claveCt);
            rs = stm.executeQuery();
            while (rs.next()) {
                ct.setCt(rs.getString("ct"));
                ct.setDireccion(rs.getString("direccion"));
                ct.setMunicicpio(rs.getString("municipio"));
                ct.setNombre(rs.getString("nombre"));
                ct.setTurno(rs.getString("turno"));
            }
            rs.close();
            stm.close();
            conexion.close();
        } catch (SQLException e) {
            e.getMessage();
            conexion.close();
        }
        return ct;
    }

    public String getBandera(String curp) throws SQLException {
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
        String curp_alumno = "";
        try {
            String Query = "Select especial from curp_ct where curp=?";
            stm = conexion.prepareStatement(Query);
            stm.setString(1, curp);
            rs = stm.executeQuery();
            while (rs.next()) {
                curp_alumno = rs.getString("especial");
            }
            rs.close();
            stm.close();
            conexion.close();
        } catch (SQLException e) {
            e.getMessage();
            conexion.close();
        }
        return curp_alumno;
    }

    public String getBandera2(String curp) throws SQLException {
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
        String curp_alumno2 = "";
        try {
            String Query = "Select count(*) as cuenta from curp_ct where curp=?";
            stm = conexion.prepareStatement(Query);
            stm.setString(1, curp);
            rs = stm.executeQuery();
            rs.next();
            curp_alumno2 = rs.getString(1);
            rs.close();
            stm.close();
            conexion.close();
        } catch (SQLException e) {
            e.getMessage();
            conexion.close();
        }
        return curp_alumno2;
    }

    public BeanCTO getCt2(String curp) throws SQLException {
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
        BeanCTO ct = new BeanCTO();
        try {
            String Query = "Exec validaCurpCt ?";
            stm = conexion.prepareStatement(Query);
            stm.setString(1, curp);
            rs = stm.executeQuery();
            while (rs.next()) {
                ct.setCt(rs.getString("ct"));
                ct.setDireccion(rs.getString("direccion"));
                ct.setMunicicpio(rs.getString("municipio"));
                ct.setNombre(rs.getString("nombre"));
                ct.setTurno(rs.getString("turno"));
            }
            rs.close();
            stm.close();
            conexion.close();
        } catch (SQLException e) {
            e.getMessage();
            conexion.close();
        }
        return ct;
    }

    public BeanCTO getCt3(String curp) throws SQLException {
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
        BeanCTO ct2 = new BeanCTO();
        int cont1 = 0;
        try {
            String Query = "Exec validaCurpCtDest ?";
            stm = conexion.prepareStatement(Query);
            stm.setString(1, curp);
            rs = stm.executeQuery();

            while (rs.next()) {
                ct2.setCt(rs.getString("ct"));
                ct2.setNombre(rs.getString("nombre"));
                ct2.setDireccion(rs.getString("direccion"));
                //ct.setMunicicpio(rs.getString("municipio"));
                ct2.setTurno(rs.getString("turno"));
            }
            rs.close();
            stm.close();
            conexion.close();
        } catch (SQLException e) {
            e.getMessage();
            conexion.close();
        }
        return ct2;
    }

    public BeanCTO getUsuario(String claveCt, String contrasena) throws SQLException {
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
        BeanCTO ct2 = new BeanCTO();
        try {
            String Query = "exec valida_usuario ?,?";
            stm = conexion.prepareStatement(Query);
            stm.setString(1, claveCt);
            stm.setString(2, contrasena);
            rs = stm.executeQuery();
            while (rs.next()) {
                ct2.setCt(rs.getString("ct"));
                ct2.setContrasena(rs.getString("contrasena"));
            }
            rs.close();
            stm.close();
            conexion.close();
        } catch (SQLException e) {
            e.getMessage();
            conexion.close();
        }
        return ct2;
    }

}
