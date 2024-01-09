/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 *
 * @author daniel.vazquez
 */
public class LestrasDelDiaDAO {

    Connection conexion = null;
    Statement stm = null;
    ResultSet rs = null;

    public String getLetrasDelDia() {
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
            System.out.println("Error1 en la Conexión con la BD");
            conexion = null;
        }
        String letras = "";
        try {
            String Query = "Exec letrasDelDia";
            stm = conexion.createStatement();
            rs = stm.executeQuery(Query);
            while (rs.next()) {
                letras = rs.getString("valido");
            }

        } catch (SQLException e) {
            e.getMessage();
        }
        return letras;
    }
}
