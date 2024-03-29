/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Bean.BeanCorreo;
import Bean.BeanEscuela;
import Conexion.conexionDB;
import Dao.DaoAlumno;
import DaoImpl.FachadaPadres;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Depto. Sistemas
 */
public class dato extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        Connection miConexion = (Connection) conexionDB.GetConnection();
        try (PrintWriter out = response.getWriter()) {
            String opc = request.getParameter("accion");
            DaoAlumno loca = new DaoAlumno(miConexion);
            List<BeanCorreo> listasct = new ArrayList();
            List<BeanCorreo> cor = new ArrayList();
            List<BeanCorreo> datos = new ArrayList();
            Gson gson = new Gson();
            String mensaje = "";
            String mensajes = "";
            switch (opc) {
                case "2":
                    String id = request.getParameter("id");
                    listasct = loca.consulta(id);
                    String opcion = "";
                    for (BeanCorreo be : listasct) {
                        opcion += "<option value='" + be.getCorreo() + "'>" + be.getCorreo() + "</option>";
                    }
                    out.print(opcion);
                    break;

                case "3":
                    String muni = request.getParameter("muni");
                    String local = request.getParameter("loca");
                    cor = loca.consultacorde(muni);
                    datos = loca.consultadatos(muni, local);
                    mensaje = gson.toJson(cor);
                    mensajes = gson.toJson(datos);
                    String latitud = "";
                    String longitud = "";
                    for (BeanCorreo corde : cor) {
                        latitud = corde.getLat();
                        longitud = corde.getLng();
                    }
                    response.setContentType("application/json");
                    response.setCharacterEncoding("utf-8");

                    response.getWriter().write("[");
                    response.getWriter().write(mensaje);
                    response.getWriter().write(",");
                    response.getWriter().write(mensajes);
                    response.getWriter().write("]");
                    //String Json = "{\"longitud\": " + longitud + "}"+"{\"latitud\": " + latitud + "}"+"{\"parametros\": " + mensajes + "}";
                    //String Json = "{\"parametros\": " + mensajes + "}";
                    //String Json = "{\"parametros\": " + mensajes + "}";

                    //out.print(Json);
                    break;

                case "4":
                    String Ct = request.getParameter("ct");
                    Collection<BeanEscuela> listaCTS;
                    FachadaPadres muestra = new FachadaPadres();
                    listaCTS = muestra.getEscuelas(Ct);
                    String datosTabla = gson.toJson(listaCTS);
                    String Json = "{\"parametros\": " + datosTabla + "}";
                    out.print(Json);
                    break;
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(dato.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(dato.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(dato.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(dato.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
