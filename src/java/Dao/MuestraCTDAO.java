/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Bean.BeanCT;
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
 * @author David Costet
 */
public class MuestraCTDAO {

    public Collection<BeanCT> getCTS(String municipio) throws SQLException {
        ResourceBundle archivoConfiguracion = ResourceBundle.getBundle("Conexion/conexion");
        Connection conexion = null;
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
        Statement stm = null;
        ResultSet rs = null;

        ArrayList<BeanCT> listaCentrosTrabajo = new ArrayList<BeanCT>();
        try {
            

            String Query = "exec listadoCTs ?";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setString(1, municipio);
            rs = pstm.executeQuery();
            while (rs.next()) {
                BeanCT ct = new BeanCT();
                ct.setMunicipio(rs.getString("MUNICIPIO"));
                ct.setCt(rs.getString("CT"));
                ct.setNombre(rs.getString("NOMBRE"));
                ct.setTurno(rs.getString("TURNO"));
                ct.setDireccion(rs.getString("DIRECCION"));
                listaCentrosTrabajo.add(ct);
            }
            pstm.close();
            rs.close();
            conexion.close();
        } catch (SQLException e) {
            e.getMessage();
            conexion.close();

        }
        return listaCentrosTrabajo;

    }
    
    
    
    
    
}
