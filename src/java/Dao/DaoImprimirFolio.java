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
 * @author Mike
 */
public class DaoImprimirFolio {

    Connection conexion = null;
    PreparedStatement stm = null;
    ResultSet rs = null;

    public BeanPreinscribirPadres getDatosFolio(String curp) throws SQLException {
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

}
