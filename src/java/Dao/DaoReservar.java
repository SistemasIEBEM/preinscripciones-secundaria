/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Bean.BeanCTO;
import Bean.BeanReservar;
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
public class DaoReservar {

    Connection conexion = null;
    PreparedStatement stm = null;
    ResultSet rs = null;

    public int getReservar(String curp) throws SQLException {
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
        int msj = 100;
        try {
            String Query = "SELECT COUNT(*) AS msj FROM pres WHERE curp=?";
            stm = conexion.prepareStatement(Query);
            stm.setString(1, curp);
            rs = stm.executeQuery();
            while (rs.next()) {
                msj = rs.getInt("msj");
            }
            rs.close();
            stm.close();
            conexion.close();
        } catch (SQLException e) {
            e.getMessage();
            conexion.close();
        }
        return msj;

    }

    public int getReservarDir(BeanReservar reservar2) throws SQLException {

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
        int msj = 100;
        try {
            String Query = "Exec validaDir  ?,?,?";
            stm = conexion.prepareStatement(Query);
            stm.setString(1, reservar2.getCurp());
            stm.setString(2, reservar2.getCt());
            stm.setString(3, reservar2.getGrado());
            rs = stm.executeQuery();
            while (rs.next()) {
                msj = rs.getInt("msj");
            }
            rs.close();
            stm.close();
            conexion.close();
        } catch (SQLException e) {
            e.getMessage();
            conexion.close();
        }
        return msj;

    }

    public int getReservarDirSinCurp(BeanReservar reservar2) throws SQLException {
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
        //CtDTO ct = new CtDTO();
        int msj = 100;
        try {
            String Query = "Exec validaDirSinCurp  ?,?,?,?,?";
            stm = conexion.prepareStatement(Query);
            stm.setString(1, reservar2.getCt());
            stm.setString(2, reservar2.getPaterno());
            stm.setString(3, reservar2.getMaterno());
            stm.setString(4, reservar2.getNombre());
            stm.setString(5, reservar2.getGrado());
            rs = stm.executeQuery();
            while (rs.next()) {
                msj = rs.getInt("msj");
            }
            rs.close();
            stm.close();
            conexion.close();
        } catch (SQLException e) {
            e.getMessage();
            conexion.close();
        }
        return msj;

    }

}
