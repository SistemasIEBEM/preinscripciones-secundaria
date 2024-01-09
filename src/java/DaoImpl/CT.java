/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoImpl;

import Bean.BeanCT;
import Bean.BeanFecha;
import Bean.Beanlugares;
import Bean.Beanlugaresactual;
import Bean.Beanlugaresctgrado;
import Bean.Beanorigen;
import Bean.Beansupervisor;
import Dao.Muestra;
import Dao.MuestraCTDAO;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Mike
 */
public class CT {

    public Collection<BeanCT> mostrarCentrosTrabajo(String municipio) throws SQLException {
        MuestraCTDAO MuestraCTS = new MuestraCTDAO();
        Collection<BeanCT> listaUsuarios = MuestraCTS.getCTS(municipio);
        //for( UsuarioDTO unUsuario:listaUsuarios){
        //  System.out.println(unUsuario);
        //}
        return listaUsuarios;
    }

    public BeanCT mostrarDatos(String ct) throws SQLException {
        Muestra MuestraCTS = new Muestra();
        BeanCT datos = MuestraCTS.getCT(ct);
        //for( UsuarioDTO unUsuario:listaUsuarios){
        //  System.out.println(unUsuario);
        //}
        return datos;
    }
    public  Collection<Beanorigen> mostrarDatos1(String ct) throws SQLException {
        Muestra MuestraCTS = new Muestra();
        Collection<Beanorigen> datos = MuestraCTS.getorigen(ct);
        //for( UsuarioDTO unUsuario:listaUsuarios){
        //  System.out.println(unUsuario);
        //}
        return datos;
    }

    public Beansupervisor getUsuario(String ct, String contrasena) throws SQLException {
        Muestra buscaUsuario = new Muestra();
        return buscaUsuario.getUsuario(ct, contrasena);
    }

    public Collection<BeanCT> getctporzona(String zona) throws SQLException {
        Muestra mostrarct = new Muestra();
        Collection<BeanCT> listadoct = mostrarct.getctporzona(zona);
        return listadoct;
    }

    public Collection<Beanlugares> getctlugares(String ct) throws SQLException {
        Muestra mostrarct = new Muestra();
        Collection<Beanlugares> cttotales = mostrarct.getctlugares(ct);
        return cttotales;
    }

    public Collection<Beanlugaresactual> getctlugaresactual(String ct) throws SQLException {
        Muestra mostrarct = new Muestra();
        Collection<Beanlugaresactual> cttotalesactuales = mostrarct.getctlugaresactual(ct);
        return cttotalesactuales;
    }
    
    public Collection<Beanlugaresctgrado> getlugaresctgrado(String ct, int grado) throws SQLException {
        Muestra mostrarct = new Muestra();
        Collection<Beanlugaresctgrado> lugaresctgrado = mostrarct.getlugaresctgrado(ct,grado);
        return lugaresctgrado;
    }
    
    public boolean actualizalugares(Beanlugaresctgrado bean) throws SQLException {
        Muestra actualizalugares = new Muestra();
        return actualizalugares.actualizalugares(bean);
    }
    public void getestadistica(String fecha) throws SQLException {
        Muestra mostrarct = new Muestra();
        mostrarct.getestadistica(fecha);
        
    }
    public ArrayList<BeanFecha> getreporte() throws SQLException {
        Muestra mostrarct = new Muestra();
        ArrayList<BeanFecha> estadistica = (ArrayList<BeanFecha>) mostrarct.getreporte();
        return estadistica;
    }
      public boolean getinsertaorigen(String origen, String destino) throws SQLException {
        Muestra inserta = new Muestra();
        return inserta.getinsertaorigen(origen, destino);
    }
      
       public Beanorigen getvalidarorigen(String origen, String destino) throws SQLException {
        Muestra buscaUsuario = new Muestra();
        Beanorigen datos=buscaUsuario.getorigen(origen, destino);
        return datos;
    }
    
}
