/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Bean.BeanInscribir;
import Bean.BeanInscribirResultado;
import DaoImpl.FachadaPadres;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mike
 */
public class ServletDatosPersonales extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            BeanInscribirResultado datos;
            BeanInscribirResultado resultDatos;
            FachadaPadres fachadaPa = new FachadaPadres();
            String curp = (String) request.getParameter("curp");
            String ct = (String) request.getParameter("ct");
            String paterno = (String) request.getParameter("paterno");
            String materno = (String) request.getParameter("materno");
            String nombre = (String) request.getParameter("nombre");
            String fechaNac = (String) request.getParameter("fechaNac");
            String sexo = (String) request.getParameter("sexo");
            String edonac = (String) request.getParameter("edonac");
            String ct_destino = (String) request.getParameter("ct_registro");
            String grado = (String) request.getParameter("grado");
            String modo = (String) request.getParameter("modo");
            BeanInscribir DNIdatos = new BeanInscribir(curp, paterno, materno, nombre, Date.valueOf(fechaNac), sexo, edonac, ct_destino, grado);
            try {
                resultDatos = fachadaPa.getDatosPreinscribir(DNIdatos);
                if (resultDatos.getError() != null) {
                    switch (Integer.parseInt(resultDatos.getError())) {
                        case 8:
                            request.setAttribute("error", "8");
                            request.getRequestDispatcher("/error.jsp").forward(request, response);
                            break;
                        case 7:
                             datos = fachadaPa.getDatosFinal(curp);
                                request.setAttribute("folio", datos.getFolio());
                                request.setAttribute("curp", datos.getCurp());
                                request.setAttribute("nombre", datos.getNombre() + " " + datos.getPaterno() + " " + datos.getMaterno());
                                request.setAttribute("paterno", datos.getPaterno());
                                request.setAttribute("materno", datos.getMaterno());
                                request.setAttribute("ct", datos.getCt());
                                request.setAttribute("Ct_nombre", datos.getNombre_ct());
                                request.setAttribute("Ct_direccion", datos.getDireccion());
                                request.setAttribute("Ct_turno", datos.getTurno());
                                request.getRequestDispatcher("/datos_personales.jsp").forward(request, response);
                            break;
                        case -1:
                            request.setAttribute("error", "9");
                            request.getRequestDispatcher("/error.jsp").forward(request, response);
                            break;
                    }
                }
                datos = fachadaPa.getDatosFinal(curp);
                request.setAttribute("folio", datos.getFolio());
                request.setAttribute("curp", datos.getCurp());
                request.setAttribute("nombre", datos.getNombre() + " " + datos.getPaterno() + " " + datos.getMaterno());
                request.setAttribute("paterno", datos.getPaterno());
                request.setAttribute("materno", datos.getMaterno());
                request.setAttribute("ct", datos.getCt());
                request.setAttribute("Ct_nombre", datos.getNombre_ct());
                request.setAttribute("Ct_direccion", datos.getDireccion());
                request.setAttribute("Ct_turno", datos.getTurno());
                request.getRequestDispatcher("/datos_personales.jsp").forward(request, response);
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
