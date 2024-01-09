/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Bean.BeanCT;
import Bean.BeanCTO;
import Bean.BeanPres;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.ResourceBundle;

/**
 *
 * @author David Costet
 */
public class DaoArchivo {

    Connection conexion = null;
    PreparedStatement stm = null;
    ResultSet rs = null;

    public Collection<BeanPres> getlistaalumnos(String claveCt) throws SQLException {
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
        ArrayList<BeanPres> listaalumnos = new ArrayList<BeanPres>();
        try {
            String Query = "Exec archivo ?";
            stm = conexion.prepareStatement(Query);
            stm.setString(1, claveCt);
            rs = stm.executeQuery();
            while (rs.next()) {
                BeanPres ct = new BeanPres();
                ct.setFolio(rs.getString("folio"));
                ct.setCurp(rs.getString("curp"));
                ct.setPaterno(rs.getString("paterno"));
                ct.setMaterno(rs.getString("materno"));
                ct.setNombre(rs.getString("nombre"));
                ct.setFecha(rs.getDate("fechaNac"));
                ct.setSexo(rs.getString("sexo"));
                ct.setEdonac(rs.getString("edonac"));
                ct.setCt(rs.getString("ct"));
                ct.setGrado(rs.getInt("grado"));
                ct.setModo(rs.getInt("modo"));
                ct.setDom_direccion(rs.getString("dom_direccion"));
                ct.setTelefono(rs.getString("telefono"));
                ct.setTutor_nombre(rs.getString("tutor_nombre"));
                ct.setTutor_apPaterno(rs.getString("tutor_apPaterno"));
                ct.setTutor_apMaterno(rs.getString("tutor_apMaterno"));
                ct.setCorreo(rs.getString("correo"));
                listaalumnos.add(ct);

            }
            rs.close();
            stm.close();
            conexion.close();
        } catch (SQLException e) {
            e.getMessage();
            conexion.close();
        }
        return listaalumnos;
    }

}
