/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Bean.BeanCTO;
import Bean.BeanCurp;
import Bean.BeanPreinscribirPadres;
import Bean.BeanReservar;
import Classes.ConsultaCurp;
import DaoImpl.Fachada;
import DaoImpl.FachadaPadres;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.axis2.AxisFault;

/**
 *
 * @author Registro
 */
public class ServletProcesaDatosDir extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, MalformedURLException, NoSuchAlgorithmException, KeyManagementException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String CtBD = null;
            String Ct_nombre = null;
            //String Ct_municipio = CtBd.getMunicicpio();
            String Ct_direccion = null;
            String Ct_turno = null;
            String bandera = "";
            String bandera2 = "";
            HttpSession sesion = request.getSession();
            RequestDispatcher rd;
            rd = request.getRequestDispatcher("salir_dir.jsp");
            String curp = (String) request.getParameter("curp").toUpperCase();
            String ct = (String) request.getParameter("ct").toUpperCase();
            if (curp.equals("")) {
                request.setAttribute("error", "22");
                request.getRequestDispatcher("/error.jsp").forward(request, response);
            } else {
                FachadaPadres log = new FachadaPadres ();
                int logcurp =  log.logcurp(curp);
                Pattern pat1 = Pattern.compile("[A-Z]{1}[AEIOUX]{1}[A-Z]{2}[0-9]{2}"
                        + "(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])"
                        + "[HM]{1}"
                        + "(AS|BC|BS|CC|CS|CH|CL|CM|DF|DG|GT|GR|HG|JC|MC|MN|MS|NT|NL|OC|PL|QT|QR|SP|SL|SR|TC|TS|TL|VZ|YN|ZS|NE)"
                        + "[B-DF-HJ-NP-TV-Z]{3}"
                        + "[0-9A-Z]{1}[0-9]{1}$");
                Pattern pat2 = Pattern.compile("17([DES|DSN|DST|DTV|DZS]{3})[0-9]{4}[A-Z]{1}$");
                if (!pat1.matcher(curp).matches()) {
                    request.setAttribute("error", "122");
                    request.getRequestDispatcher("/error.jsp").forward(request, response);
                }
                if (!pat2.matcher(ct).matches()) {
                    request.setAttribute("error", "133");
                    request.getRequestDispatcher("/error.jsp").forward(request, response);
                }
            }
            String edad = curp.substring(4, 6);
            Fachada fachada = new Fachada();
            bandera = fachada.getBandera(curp);
            //edades - modificar según el ciclo escolar
            bandera2 = fachada.getBandera2(curp);
            //if (bandera2.equals("1")) {
            if (edad.equals("11") || edad.equals("10") || edad.equals("09") || edad.equals("08") || edad.equals("07")|| edad.equals("06") || bandera.equals("1")) {
                //Validar la CURP con RENAPO
                BeanCurp unCurp = new BeanCurp();
                ConsultaCurp datos = new ConsultaCurp();
                try {
                    unCurp = datos.getCurp(curp);
                } catch (AxisFault e) {
                    e.getMessage();
                }
                if (unCurp.getNombre() != null) {   //validacion del curp si existe
                    //BeanCTO CtBd = fachada.getCt3(curp);
                    BeanCTO CtBd2 = fachada.getCt2(curp);
                    if (CtBd2.getCt() != null) {
                        BeanCTO CtBd3 = fachada.getCt3(curp);
                        CtBD = CtBd3.getCt();
                        Ct_nombre = CtBd3.getNombre();
                        //String Ct_municipio = CtBd.getMunicicpio();
                        Ct_direccion = CtBd3.getDireccion();
                        Ct_turno = CtBd3.getTurno();
                        if (CtBD == null || CtBD.equals(ct)) {    //validacion de centro de trabajo
                            //String fecha_nac = "20" + curp.substring(4, 6) + "-" + curp.substring(6, 8) + "-" + curp.substring(8, 10);
                            //String sexo = curp.substring(10, 11);
                            //String edo_nac = curp.substring(11, 13);
                            BeanCTO CtBd = fachada.getCt(ct);
                            CtBD = CtBd.getCt();
                            Ct_nombre = CtBd.getNombre();
                            //String Ct_municipio = CtBd.getMunicicpio();
                            Ct_direccion = CtBd.getDireccion();
                            Ct_turno = CtBd.getTurno();
                            String grado = "1";
                            String nombre = unCurp.getNombre().replace("'", "");
                            String paterno = unCurp.getApaterno().replace("'", "");
                            String materno = unCurp.getAmaterno().replace("'", "");
                            /*Reservamos el lugar*/
                            BeanReservar reservar = new BeanReservar();
                            reservar.setCurp(curp);
                            reservar.setCt(ct);
                            reservar.setGrado(grado);
                            int resultadoReserva = 0;
                            try {
                                resultadoReserva = fachada.getMsjDir(reservar);

                            } catch (Exception e) {
                                out.println(e.getMessage());
                            }
                            switch (resultadoReserva) {
                                case 7:
                                    Fachada facha = new Fachada();
                                    BeanPreinscribirPadres datosFolio = facha.getFolio(curp);
                                    FachadaPadres fachada2 = new FachadaPadres();
                                    String fecha = fachada2.getFecha(curp);
                                    String folio = datosFolio.getFolio();
                                    request.setAttribute("curp", curp);
                                    request.setAttribute("nombre", nombre);
                                    request.setAttribute("paterno", paterno);
                                    request.setAttribute("materno", materno);
                                    request.setAttribute("ct", ct);
                                    request.setAttribute("Ct_nombre", Ct_nombre);
                                    request.setAttribute("Ct_direccion", Ct_direccion);
                                    request.setAttribute("Ct_turno", Ct_turno);
                                    request.setAttribute("fecha", fecha);
                                    request.setAttribute("folio", folio);
                                    request.getRequestDispatcher("/folio_preinscribirDir.jsp").forward(request, response);
                                    break;
                                case 8:
                                    request.setAttribute("error", "88");
                                    request.getRequestDispatcher("/error.jsp").forward(request, response);
                                    break;
                                case -1:
                                    request.setAttribute("error", "99");
                                    request.getRequestDispatcher("/error.jsp").forward(request, response);
                                    break;
                            }
                            request.setAttribute("curp", curp);
                            request.setAttribute("nombre", nombre);
                            request.setAttribute("paterno", paterno);
                            request.setAttribute("materno", materno);
                            request.setAttribute("ct", ct);
                            request.setAttribute("Ct_nombre", Ct_nombre);
                            request.setAttribute("Ct_direccion", Ct_direccion);
                            request.setAttribute("Ct_turno", Ct_turno);
                            request.setAttribute("bandera", bandera);
                            request.getRequestDispatcher("/datos_alumnos_dir.jsp").forward(request, response);
                        } else {
                            request.setAttribute("error", "1117");
                            request.setAttribute("ct", CtBD);
                            request.setAttribute("nombre_ct", Ct_nombre);
                            request.getRequestDispatcher("/error.jsp").forward(request, response);
                        }
                    } else {
                        BeanCTO CtBd3 = fachada.getCt(ct);
                        Ct_nombre = CtBd3.getNombre();
                        //String Ct_municipio = CtBd.getMunicicpio();
                        Ct_direccion = CtBd3.getDireccion();
                        Ct_turno = CtBd3.getTurno();
                        String grado = "1";
                        String nombre = unCurp.getNombre().replace("'", "");
                        String paterno = unCurp.getApaterno().replace("'", "");
                        String materno = unCurp.getAmaterno().replace("'", "");
                        /*Reservamos el lugar*/
                        BeanReservar reservar = new BeanReservar();
                        reservar.setCurp(curp);
                        reservar.setCt(ct);
                        reservar.setGrado(grado);
                        int resultadoReserva = 0;
                        try {
                            resultadoReserva = fachada.getMsjDir(reservar);

                        } catch (Exception e) {
                            out.println(e.getMessage());
                        }
                        switch (resultadoReserva) {
                            case 7:
                                Fachada facha = new Fachada();
                                BeanPreinscribirPadres datosFolio = facha.getFolio(curp);
                                FachadaPadres fachada2 = new FachadaPadres();
                                String fecha = fachada2.getFecha(curp);
                                String folio = datosFolio.getFolio();
                                request.setAttribute("curp", curp);
                                request.setAttribute("nombre", nombre);
                                request.setAttribute("paterno", paterno);
                                request.setAttribute("materno", materno);
                                request.setAttribute("ct", ct);
                                request.setAttribute("Ct_nombre", Ct_nombre);
                                request.setAttribute("Ct_direccion", Ct_direccion);
                                request.setAttribute("Ct_turno", Ct_turno);
                                request.setAttribute("fecha", fecha);
                                request.setAttribute("folio", folio);
                                request.getRequestDispatcher("/folio_preinscribirDir.jsp").forward(request, response);
                                break;
                            case 8:
                                request.setAttribute("error", "88");
                                request.getRequestDispatcher("/error.jsp").forward(request, response);
                                break;
                            case -1:
                                request.setAttribute("error", "99");
                                request.getRequestDispatcher("/error.jsp").forward(request, response);
                                break;
                        }
                        request.setAttribute("curp", curp);
                        request.setAttribute("nombre", nombre);
                        request.setAttribute("paterno", paterno);
                        request.setAttribute("materno", materno);
                        request.setAttribute("ct", ct);
                        request.setAttribute("Ct_nombre", Ct_nombre);
                        request.setAttribute("Ct_direccion", Ct_direccion);
                        request.setAttribute("Ct_turno", Ct_turno);
                        request.setAttribute("bandera", bandera);
                        request.getRequestDispatcher("/datos_alumnos_dir.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("error", "120");
                    request.getRequestDispatcher("/error.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("error", "144");
                request.getRequestDispatcher("/error.jsp").forward(request, response);
            }
            /*} else {
             request.setAttribute("error", "204");
             request.getRequestDispatcher("/error.jsp").forward(request, response);
             }*/
            rd.forward(request, response);
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
            throws ServletException, IOException, MalformedURLException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ServletProcesaDatosDir.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ServletProcesaDatosDir.class.getName()).log(Level.SEVERE, null, ex);
        } catch (KeyManagementException ex) {
            Logger.getLogger(ServletProcesaDatosDir.class.getName()).log(Level.SEVERE, null, ex);
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
            throws ServletException, IOException, MalformedURLException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ServletProcesaDatosDir.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ServletProcesaDatosDir.class.getName()).log(Level.SEVERE, null, ex);
        } catch (KeyManagementException ex) {
            Logger.getLogger(ServletProcesaDatosDir.class.getName()).log(Level.SEVERE, null, ex);
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
