/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Bean.BeanEscuela;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

/**
 *
 * @author Registro
 */
public class DaoEscuela {

    Connection conexion = null;
    PreparedStatement stm = null;
    ResultSet rs = null;

    public Collection<BeanEscuela> getEscuelas(String claveCt) throws SQLException {
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
        ArrayList<BeanEscuela> listaCentrosTrabajo = new ArrayList<BeanEscuela>();
        try {
            String Query = "select distinct case when c.total > c.ocupados then 'VACANTE' else 'COMPLETO' end as 'SELECCIONE', a.ct as CT, a.nombre as NOMBRE, a.direccion as DIRECCION, a.municipio as MUNICIPIO,a.turno as TURNO from ct a inner join ct_ori_dest b on a.ct=b.ct_destino inner join ct_lugares c on a.ct=c.ct where b.ct_origen=? and c.fecha=convert(date, getdate()) and c.modo=1";
            //String Query = "select distinct case when c.total > c.ocupados then 'VACANTE' else 'COMPLETO' end as 'SELECCIONE', a.ct as CT, a.nombre as NOMBRE, a.direccion as DIRECCION, a.municipio as MUNICIPIO,a.turno as TURNO from ct a inner join ct_ori_dest b on a.ct=b.ct_destino inner join ct_lugares c on a.ct=c.ct where b.ct_origen=? and c.modo=1";
            stm = conexion.prepareStatement(Query);
            stm.setString(1, claveCt);
            rs = stm.executeQuery();
            while (rs.next()) {
                BeanEscuela ct = new BeanEscuela();
                //ct.setVacante(rs.getString("VACANTE"));
                //ct.setCompleto(rs.getString("COMPLETO"));
                ct.setSeleccione(rs.getString("SELECCIONE"));
                ct.setCt(rs.getString("CT"));
                ct.setNombre(rs.getString("NOMBRE"));
                ct.setDireccion(rs.getString("DIRECCION"));
                ct.setMunicipio(rs.getString("MUNICIPIO"));
                ct.setTurno(rs.getString("TURNO"));
                listaCentrosTrabajo.add(ct);
            }
            rs.close();
            stm.close();
            conexion.close();
        } catch (SQLException e) {
            e.getMessage();
            conexion.close();
        }
        return listaCentrosTrabajo;
    }

}
