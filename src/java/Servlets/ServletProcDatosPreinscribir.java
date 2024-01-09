/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Bean.BeanPreinscribirPadres;
import DaoImpl.FachadaDirectores;
import DaoImpl.FachadaPadres;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mike
 */
public class ServletProcDatosPreinscribir extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            FachadaPadres fachadaPa = new FachadaPadres();
            String curp = (String) request.getParameter("curp");
            String folio = (String) request.getParameter("folio");
            String nombre = (String) request.getParameter("nombre");
            String ct = (String) request.getParameter("ct");
            String ct_nombre = (String) request.getParameter("ct_nombre");
            String ct_direccion = (String) request.getParameter("ct_direccion");
            String turno = (String) request.getParameter("turno");

            String tutor_curp = (String) request.getParameter("curpT");
            tutor_curp = tutor_curp.replace("'", tutor_curp);
            String tutor_nombre = (String) request.getParameter("nombreT");
            tutor_nombre = tutor_nombre.replace("'", tutor_nombre);
            String tutor_apPaterno = (String) request.getParameter("apPaterno");
            tutor_apPaterno = tutor_apPaterno.replace("'", tutor_apPaterno);
            String tutor_apMaterno = (String) request.getParameter("apMaterno");
            tutor_apMaterno = tutor_apMaterno.replace("'", tutor_apMaterno);
            String tutor_entidad = (String) request.getParameter("entidad");
            tutor_entidad = tutor_entidad.replace("'", tutor_entidad);
            String tutor_fecha = (String) request.getParameter("fechanac");
            tutor_fecha = tutor_fecha.replace("'", tutor_fecha);
            String tutor_sexo = (String) request.getParameter("sexo");
            tutor_sexo = tutor_sexo.replace("'", tutor_sexo);

            String correo = (String) request.getParameter("correo");
            correo = correo.replace("'", correo);
            String municipio = (String) request.getParameter("municipio");
            String direccion = (String) request.getParameter("domicilio");
            direccion = direccion.replace("'", direccion);
            String telefono = (String) request.getParameter("telefono");
            try {
                fachadaPa.getActualiza(curp, folio, municipio, direccion, telefono, tutor_curp, tutor_nombre, tutor_apPaterno, tutor_apMaterno, tutor_entidad, tutor_fecha, tutor_sexo, correo);
                FachadaPadres fachada = new FachadaPadres();
                String fecha = fachada.getFecha(curp);
                request.setAttribute("folio", folio);
                request.setAttribute("curp", curp);
                request.setAttribute("nombre", nombre);
                request.setAttribute("ct", ct);
                request.setAttribute("Ct_nombre", ct_nombre);
                request.setAttribute("Ct_direccion", ct_direccion);
                request.setAttribute("turno", turno);
                request.setAttribute("fecha", fecha);
                request.getRequestDispatcher("/folio_preinscripcion.jsp").forward(request, response);
            } catch (Exception e) {
                out.println(e.getMessage());
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
        processRequest(request, response);
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
        processRequest(request, response);
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
