/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Bean.BeanCorreo;
import Conexion.conexionDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import java.util.TimeZone;

/**
 *
 * @author David
 */
public class DaoAlumno {

    private Connection conexion;
    ResultSet rs;
    PreparedStatement preparedStatement;
    PreparedStatement stm = null;

    public DaoAlumno(Connection conexion) throws ClassNotFoundException {
        this.miConexion = (Connection) conexionDB.GetConnection();
        this.conexion = conexion;
    }

    Connection miConexion;

    public DaoAlumno() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<BeanCorreo> consulta(String muni) {
        List<BeanCorreo> listas = new ArrayList();
        try {
            Statement statement = miConexion.createStatement();
            rs = statement.executeQuery("select distinct localidad from ct where municipio='" + muni + "' and contrasena IS NOT NULL");
            while (rs.next()) {
                BeanCorreo bean = new BeanCorreo();
                bean.setCorreo(rs.getString("localidad"));
                listas.add(bean);
            }
            rs.close();
            statement.close();
            conexion.close();
        } catch (SQLException e) {
        }
        return listas;
    }

    public List<BeanCorreo> consultacorde(String muni) {
        List<BeanCorreo> listas = new ArrayList();
        try {
            Statement statement = miConexion.createStatement();
            rs = statement.executeQuery("select lat,lng from coordenadas_muni where municipio='" + muni + "'");
            while (rs.next()) {
                BeanCorreo bean = new BeanCorreo();
                bean.setLat(rs.getString("lat"));
                bean.setLng(rs.getString("lng"));
                listas.add(bean);
            }
            rs.close();
            statement.close();
            conexion.close();
        } catch (SQLException e) {
        }
        return listas;
    }

    public List<BeanCorreo> consultadatos(String muni, String loca) {
        List<BeanCorreo> listas = new ArrayList();
        try {
            Statement statement = miConexion.createStatement();
            rs = statement.executeQuery("select * from ct  where municipio='" + muni + "' and localidad='" + loca + "' and contrasena IS NOT NULL");
            while (rs.next()) {
                BeanCorreo bean = new BeanCorreo();
                bean.setCt(rs.getString("ct"));
                bean.setNombre(rs.getString("nombre"));
                bean.setMunicipio(rs.getString("municipio"));
                bean.setDireccion(rs.getString("direccion"));
                bean.setTurno(rs.getString("turno"));
                bean.setLati(rs.getString("lat"));
                bean.setLon(rs.getString("long"));

                listas.add(bean);
            }
            rs.close();
            statement.close();
            conexion.close();
        } catch (SQLException e) {
        }
        return listas;
    }

   

}
