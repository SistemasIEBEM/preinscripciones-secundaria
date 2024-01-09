/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Bean.BeanReporte;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

/**
 *
 * @author Mike
 */
public class DaoReporte {

    Connection conexion = null;
    PreparedStatement stm = null;
    ResultSet rs = null;

    public Collection<BeanReporte> getReporte(String ct) throws SQLException {
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
        ArrayList<BeanReporte> listaReporte = new ArrayList<BeanReporte>();
        try {
            String Query = "exec reporte_totales ?";
            stm = conexion.prepareStatement(Query);
            stm.setString(1, ct);
            rs = stm.executeQuery();
            while (rs.next()) {
                BeanReporte rep = new BeanReporte();
                rep.setGrado(rs.getString("GRADO"));
                rep.setLugaresPara(rs.getString("LUGARES_PARA"));
                rep.setCapacidad(rs.getString("CAPACIDAD"));
                rep.setOcupados(rs.getString("OCUPADOS"));
                rep.setReservados(rs.getString("RESERVADOS"));
                rep.setDisponibles(rs.getString("DISPONIBLES"));
                listaReporte.add(rep);
            }
            rs.close();
            stm.close();
            conexion.close();
        } catch (SQLException e) {
            e.getMessage();
            conexion.close();
        }
        return listaReporte;
    }

}
