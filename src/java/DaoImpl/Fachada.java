/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoImpl;

import Bean.BeanCTO;
import Bean.BeanCurp;
import Bean.BeanPreinscribirPadres;
import Bean.BeanReporte;
import Bean.BeanReservar;
import Dao.DaoCTO;
import Dao.DaoImprimirFolio;
import Dao.DaoReporte;
import Dao.DaoReservar;
import Dao.LestrasDelDiaDAO;
import java.sql.SQLException;
import java.util.Collection;

public class Fachada {

    public String LetrasDelDia() {
        LestrasDelDiaDAO buscaLestras = new LestrasDelDiaDAO();
        return buscaLestras.getLetrasDelDia();
    }

    public BeanCTO getCt(String ct) throws SQLException {
        DaoCTO buscaCt = new DaoCTO();
        return buscaCt.getCt(ct);
    }

    public String getBandera(String curp) throws SQLException {
        DaoCTO buscaBandera = new DaoCTO();
        return buscaBandera.getBandera(curp);
    }

    public String getBandera2(String curp) throws SQLException {
        DaoCTO buscaBandera = new DaoCTO();
        return buscaBandera.getBandera2(curp);
    }

    public BeanCTO getCt2(String curp) throws SQLException {
        DaoCTO buscaCt2 = new DaoCTO();
        return buscaCt2.getCt2(curp);
    }

    public BeanCTO getCt3(String curp) throws SQLException {
        DaoCTO buscaCt3 = new DaoCTO();
        return buscaCt3.getCt3(curp);
    }

    public int getMsj(String curp) throws SQLException {
        DaoReservar obtenMsj = new DaoReservar();
        return obtenMsj.getReservar(curp);
    }

    public BeanPreinscribirPadres getFolio(String curp) throws SQLException {
        DaoImprimirFolio obtenFolioDatos = new DaoImprimirFolio();
        return obtenFolioDatos.getDatosFolio(curp);
    }

    public BeanCTO getUsuario(String ct, String contrasena) throws SQLException {
        DaoCTO buscaUsuario = new DaoCTO();
        return buscaUsuario.getUsuario(ct, contrasena);
    }

    public Collection<BeanReporte> mostrarReporte(String ct) throws SQLException {
        DaoReporte reporte = new DaoReporte();
        Collection<BeanReporte> listaReporte = reporte.getReporte(ct);
        //for( UsuarioDTO unUsuario:listaUsuarios){
        //  System.out.println(unUsuario);
        //}
        return listaReporte;
    }

    public int getMsjDir(BeanReservar reservar2) throws SQLException {
        DaoReservar obtenMsj = new DaoReservar();
        return obtenMsj.getReservarDir(reservar2);
    }

    public int getMsjDirSincurp(BeanReservar reservar2) throws SQLException {
        DaoReservar obtenMsj = new DaoReservar();
        return obtenMsj.getReservarDirSinCurp(reservar2);
    }

}