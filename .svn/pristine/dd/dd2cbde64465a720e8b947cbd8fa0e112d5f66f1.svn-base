/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Bean.BeanCT;
import Bean.BeanFecha;
import Bean.Beanlugares;
import Bean.Beanlugaresactual;
import Bean.Beanlugaresctgrado;
import Bean.Beanorigen;
import Bean.Beansupervisor;
import java.sql.Connection;
import java.sql.Date;
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
 * @author david
 */
public class Muestra {

    public BeanCT getCT(String ct) throws SQLException {
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

        BeanCT cct = new BeanCT();
        try {

            String Query = "exec listado ?";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setString(1, ct);
            rs = pstm.executeQuery();
            while (rs.next()) {
                cct.setMunicipio(rs.getString(1));
                cct.setCt(rs.getString(2));
                cct.setNombre(rs.getString(3));
                cct.setTurno(rs.getString(4));
                cct.setDireccion(rs.getString(5));
                cct.setContrasena(rs.getString(6));
            }
            pstm.close();
            rs.close();
            conexion.close();
        } catch (SQLException e) {
            e.getMessage();
            conexion.close();
        }
        return cct;

    }
    
    public Collection<Beanorigen> getorigen(String ct) throws SQLException {
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

       ArrayList<Beanorigen> lista = new ArrayList<Beanorigen>();
        try {

            String Query = "exec consultaorigen ?";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setString(1, ct);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Beanorigen cct =new Beanorigen();
                cct.setCt_origen(rs.getString(1));
                cct.setCt_destino(rs.getString(2));
                lista.add(cct);
            }
            pstm.close();
            rs.close();
            conexion.close();
        } catch (SQLException e) {
            e.getMessage();
            conexion.close();
        }
        return lista;

    }

    public BeanCT Consulta_ct_lugares(String ct, String grado) throws SQLException {
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

        BeanCT cct = new BeanCT();
        try {

            String Query = "exec listado ?";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setString(1, ct);
            rs = pstm.executeQuery();
            while (rs.next()) {
                cct.setMunicipio(rs.getString(1));
                cct.setCt(rs.getString(2));
                cct.setNombre(rs.getString(3));
                cct.setTurno(rs.getString(4));
                cct.setDireccion(rs.getString(5));
                cct.setContrasena(rs.getString(6));
            }
            pstm.close();
            rs.close();
            conexion.close();
        } catch (SQLException e) {
            e.getMessage();
            conexion.close();

        }
        return cct;

    }

    public Beansupervisor getUsuario(String claveCt, String contrasena) throws SQLException {
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
        Beansupervisor ct2 = new Beansupervisor();
        try {

            String Query = "exec valida_usuario_super ?,?";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setString(1, claveCt);
            pstm.setString(2, contrasena);
            rs = pstm.executeQuery();
            while (rs.next()) {
                ct2.setCt(rs.getString("ct"));
                ct2.setClave(rs.getString("clave"));
                ct2.setNombrect(rs.getString("nombrect"));
                ct2.setZona(rs.getString("zonaescolar"));

            }
            pstm.close();
            rs.close();
            conexion.close();
        } catch (SQLException e) {
            e.getMessage();
            conexion.close();
        }
        return ct2;
    }

    public Collection<BeanCT> getctporzona(String zona) throws SQLException {
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

            String Query = "exec listadoctzona ?";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setString(1, zona);
            rs = pstm.executeQuery();
            while (rs.next()) {
                BeanCT ctz = new BeanCT();
                ctz.setCt(rs.getString("ct"));
                ctz.setNombre(rs.getString("nombre"));
                listaCentrosTrabajo.add(ctz);
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

    public Collection<Beanlugares> getctlugares(String ct) throws SQLException {
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
        ArrayList<Beanlugares> ctlugares = new ArrayList<Beanlugares>();
        try {

            String Query = "exec totallugares ?";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setString(1, ct);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Beanlugares ctz = new Beanlugares();
                ctz.setCt(rs.getString("ct"));
                ctz.setGrado(rs.getString("grado"));
                ctz.setTotal(rs.getString("total"));
                ctz.setPadres(rs.getString("padres"));
                ctz.setDirectores(rs.getString("directores"));
                ctlugares.add(ctz);
            }
            pstm.close();
            rs.close();
            conexion.close();

        } catch (SQLException e) {
            e.getMessage();
            conexion.close();
        }
        return ctlugares;
    }

    public Collection<Beanlugaresactual> getctlugaresactual(String ct) throws SQLException {
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
        ArrayList<Beanlugaresactual> ctlugares = new ArrayList<Beanlugaresactual>();
        try {
            String Query = "exec totallugaresactual ?";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setString(1, ct);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Beanlugaresactual ctla = new Beanlugaresactual();
                ctla.setModo(rs.getInt("modo"));
                ctla.setGrado(rs.getInt("grado"));
                ctla.setPreinscritos(rs.getInt("preinscritos"));
                ctlugares.add(ctla);
            }
            pstm.close();
            rs.close();
            conexion.close();

        } catch (SQLException e) {
            e.getMessage();
            conexion.close();
        }
        return ctlugares;
    }

    public Beansupervisor getUsuarioadmin(String claveCt, String contrasena) throws SQLException {
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
        Beansupervisor ct2 = new Beansupervisor();
        try {

            String Query = "exec valida_usuario_admin ?,?";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setString(1, claveCt);
            pstm.setString(2, contrasena);
            rs = pstm.executeQuery();
            while (rs.next()) {
                ct2.setCt(rs.getString("ct"));
                ct2.setClave(rs.getString("clave"));
                ct2.setNombrect(rs.getString("nombrect"));
                ct2.setZona(rs.getString("zonaescolar"));

            }
            pstm.close();
            rs.close();
            conexion.close();
        } catch (SQLException e) {
            e.getMessage();
            conexion.close();
        }
        return ct2;
    }

    public Collection<Beanlugaresctgrado> getlugaresctgrado(String ct, int grado) throws SQLException {
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
        ArrayList<Beanlugaresctgrado> lugaresctgrado = new ArrayList<Beanlugaresctgrado>();
        try {
            String Query = "exec totallugaresctgrado ?,?";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setString(1, ct);
            pstm.setInt(2, grado);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Beanlugaresctgrado ctla = new Beanlugaresctgrado();
                ctla.setFecha(rs.getDate("fecha"));
                ctla.setCt(rs.getString("ct"));
                ctla.setModo(rs.getInt("modo"));
                ctla.setGrado(rs.getInt("grado"));
                ctla.setTotal(rs.getInt("total"));
                ctla.setOcupados(rs.getInt("ocupados"));
                lugaresctgrado.add(ctla);
            }
            pstm.close();
            rs.close();
            conexion.close();

        } catch (SQLException e) {
            e.getMessage();
            conexion.close();
        }
        return lugaresctgrado;
    }

    public boolean actualizalugares(Beanlugaresctgrado bean) throws SQLException {
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
        Beansupervisor ct2 = new Beansupervisor();
        boolean status = false;
        try {
            String Query = "exec actualizarlugares ?,?,?,?,?";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setDate(1, bean.getFecha());
            pstm.setString(2, bean.getCt());
            pstm.setInt(3, bean.getGrado());
            pstm.setInt(4, bean.getTotal());
            pstm.setInt(5, bean.getModo());
            status = pstm.executeUpdate() == 1;
            pstm.close();
            conexion.close();
        } catch (SQLException e) {
            e.getMessage();
            conexion.close();
        }
        return status;
    }

    public void getestadistica(String fecha) throws SQLException {
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

        try {
            String Query = "SET NOCOUNT ON; EXEC conteohora '" + fecha + "'";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            //pstm.setString(1, fecha);
            rs = pstm.executeQuery();
        } catch (SQLException e) {
            e.getMessage();
        }
        rs.close();
        conexion.close();

    }

    public Collection<BeanFecha> getreporte() throws SQLException {
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
        ArrayList<BeanFecha> estadistica = new ArrayList<BeanFecha>();
        try {
            String Query = "exec conteohora1 ";

            PreparedStatement pstm = conexion.prepareStatement(Query);

            rs = pstm.executeQuery();
            while (rs.next()) {
                BeanFecha ctla = new BeanFecha();
                ctla.setHora(rs.getInt("hora"));
                ctla.setModo(rs.getInt("modo1"));
                ctla.setTotal(rs.getInt("modo2"));
                estadistica.add(ctla);
            }
            pstm.close();
            rs.close();
            conexion.close();

        } catch (SQLException e) {
            e.getMessage();
            conexion.close();
        }
        return estadistica;
    }

    public boolean getinsertaorigen(String origen, String destino) throws SQLException {
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
        Beansupervisor ct2 = new Beansupervisor();
        boolean status = false;
        try {
            String Query = "exec insertaorigen ?,?";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setString(1, origen);
            pstm.setString(2, destino);
            
            status = pstm.execute() == true;
            pstm.close();
            conexion.close();
        } catch (SQLException e) {
            e.getMessage();
            conexion.close();
        }
        return status;
    }
    public Beanorigen  getorigen(String origen, String destino) throws SQLException {
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
        Beanorigen ct2 = new Beanorigen();
        try {

            String Query = "exec validarorigen ?,?";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setString(1, origen);
            pstm.setString(2, destino);
            rs = pstm.executeQuery();
            while (rs.next()) {
                ct2.setCt_origen(rs.getString("ct_origen"));
                ct2.setCt_destino(rs.getString("ct_destino"));
            }
            pstm.close();
            rs.close();
            conexion.close();
        } catch (SQLException e) {
            e.getMessage();
            conexion.close();
        }
        return ct2;
    }
}
