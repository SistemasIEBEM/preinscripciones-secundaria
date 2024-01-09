/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Bean.BeanPreinscribirPadres;
import Bean.BeanReservar;
import DaoImpl.Fachada;
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
 * @author Registro
 */
public class ServletPreinscribirSinCurp extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            FachadaDirectores fachadaDir = new FachadaDirectores();
            String ct = (String) request.getParameter("ct");
            String paterno = (String) request.getParameter("paterno");
            String materno = (String) request.getParameter("materno");
            String nombre = (String) request.getParameter("nombre");
            String fecha_nac = (String) request.getParameter("fecha");
            String sexo = (String) request.getParameter("sexo");
            String edo_nac = (String) request.getParameter("edonac");
            String grado = "1";
            String direccion = (String) request.getParameter("domicilio");
            direccion = direccion.replace("'", direccion);
            String municipio = (String) request.getParameter("municipio");
            municipio = municipio.replace("'", municipio);
            String telefono = (String) request.getParameter("telefono");
            String tutor_curp = (String) request.getParameter("curpT");
            tutor_curp = tutor_curp.replace("'", tutor_curp);
            String tutor_nombre = (String) request.getParameter("nombreT");
            tutor_nombre = tutor_nombre.replace("'", tutor_nombre);
            String tutor_apPaterno = (String) request.getParameter("apPaternoT");
            tutor_apPaterno = tutor_apPaterno.replace("'", tutor_apPaterno);
            String tutor_apMaterno = (String) request.getParameter("apMaternoT");
            tutor_apMaterno = tutor_apMaterno.replace("'", tutor_apMaterno);
            String tutor_entidad = (String) request.getParameter("entidadT");
            tutor_entidad = tutor_entidad.replace("'", tutor_entidad);
            String tutor_fecha = (String) request.getParameter("fechanacT");
            tutor_fecha = tutor_fecha.replace("'", tutor_fecha);
            String tutor_sexo = (String) request.getParameter("sexoT");
            tutor_sexo = tutor_sexo.replace("'", tutor_sexo);

            String correo = (String) request.getParameter("correo");
            correo = correo.replace("'", correo);
            /*intentamos preinscribir al alumno*/
            String curp = (String) request.getParameter("curp");
            String edad = curp.substring(4, 6);
            if (edad.equals("11") || edad.equals("10") || edad.equals("09") || edad.equals("08") || edad.equals("07") || edad.equals("06") ) {
                int edad_permitida = Integer.parseInt(edad);
                switch (edad_permitida) {
                    case 11:
                        grado = "1";
                        break;
                    case 10:
                        grado = "1";
                        break;
                    case 9:
                        grado = "1";
                        break;
                    case 8:
                        grado = "1";
                        break;
                    case 7:
                        grado = "1";
                        break;
                        
                    case 6:
                        grado = "1";
                        break;
                }
                String mes = curp.substring(6, 8);
                String dia = curp.substring(8, 10);
                if (mes.equals("01") || mes.equals("02") || mes.equals("03") || mes.equals("04") || mes.equals("05") || mes.equals("06")
                        || mes.equals("07") || mes.equals("08") || mes.equals("09") || mes.equals("10") || mes.equals("11") || mes.equals("12")) {
                    if (dia.equals("01") || dia.equals("02") || dia.equals("03") || dia.equals("04") || dia.equals("05") || dia.equals("06") || dia.equals("07")
                            || dia.equals("08") || dia.equals("09") || dia.equals("10") || dia.equals("11") || dia.equals("12") || dia.equals("13") || dia.equals("14")
                            || dia.equals("15") || dia.equals("16") || dia.equals("17") || dia.equals("18") || dia.equals("19") || dia.equals("20")
                            || dia.equals("21") || dia.equals("22") || dia.equals("23") || dia.equals("24") || dia.equals("25") || dia.equals("26") || dia.equals("27")
                            || dia.equals("28") || dia.equals("29") || dia.equals("30") || dia.equals("31")) {
                        Fachada fachada = new Fachada();
                        BeanReservar reservar = new BeanReservar();
                        reservar.setCt(ct);
                        reservar.setPaterno(paterno);
                        reservar.setMaterno(materno);
                        reservar.setNombre(nombre);
                        reservar.setGrado(grado);
                        int resultadoReserva = 0;
                        try {
                            resultadoReserva = fachada.getMsjDirSincurp(reservar);

                        } catch (Exception e) {
                            out.println(e.getMessage());
                        }

                        switch (resultadoReserva) {
                            case 7:
                                request.setAttribute("error", "665");
                                request.getRequestDispatcher("/error.jsp").forward(request, response);
                                break;

                            case 8:
                                request.setAttribute("error", "88");
                                request.getRequestDispatcher("/error.jsp").forward(request, response);
                                break;
                            case -1:

                                request.setAttribute("error", "9");
                                request.getRequestDispatcher("/error.jsp").forward(request, response);
                                break;
                        }
                        try {
                            fachadaDir.getPreinscribirDirSinCurp(curp, ct, paterno, materno, nombre, fecha_nac, sexo, edo_nac, grado, municipio, direccion, telefono, tutor_curp, tutor_nombre, tutor_apPaterno, tutor_apMaterno, tutor_entidad, tutor_fecha, tutor_sexo, correo);
                            BeanPreinscribirPadres CtBd = fachadaDir.getDatosDirSinCurp(paterno, materno, nombre, grado);
                            String folio = CtBd.getFolio();
                            String ct_nombre = CtBd.getNombre_ct();
                            String ct_direccion = CtBd.getDireccion();
                            String turno = CtBd.getTurno();
                            String curp2 = CtBd.getCurp();
                            FachadaPadres fachada2 = new FachadaPadres();
                            String fecha = fachada2.getFecha(curp2);
                            request.setAttribute("folio", folio);
                            request.setAttribute("curp", curp2);
                            request.setAttribute("nombre", nombre);
                            request.setAttribute("paterno", paterno);
                            request.setAttribute("materno", materno);
                            request.setAttribute("ct", ct);
                            request.setAttribute("Ct_nombre", ct_nombre);
                            request.setAttribute("Ct_direccion", ct_direccion);
                            request.setAttribute("turno", turno);
                            request.setAttribute("fecha", fecha);
                            request.getRequestDispatcher("/folio_preinscribirDir.jsp").forward(request, response);
                        } catch (Exception e) {
                            out.println(e.getMessage());
                        }
                    } else {
                        request.setAttribute("error", "146");
                        request.getRequestDispatcher("/error.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("error", "145");
                    request.getRequestDispatcher("/error.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("error", "144");
                request.getRequestDispatcher("/error.jsp").forward(request, response);
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
