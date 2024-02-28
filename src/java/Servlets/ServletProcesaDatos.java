/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Bean.BeanCTO;
import Bean.BeanCurp;
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
import org.apache.axis2.AxisFault;

/**
 *
 * @author Registro
 */
public class ServletProcesaDatos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, MalformedURLException, NoSuchAlgorithmException, KeyManagementException {
        try (PrintWriter out = response.getWriter()) {
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("ISO-8859-1");
            String letras = "";
            String bandera = "";
            String bandera2 = "";
            RequestDispatcher rd;
            rd = request.getRequestDispatcher("index.jsp");
            String curp = (String) request.getParameter("curp").toUpperCase();
            String ct = (String) request.getParameter("ct").toUpperCase();
            if ((curp.equals("") || ct.equals(""))) {
                request.setAttribute("error", "1");
                request.getRequestDispatcher("/error.jsp").forward(request, response);
            } else {
               
                Pattern pat1 = Pattern.compile("[A-Z]{1}[AEIOUX]{1}[A-Z]{2}[0-9]{2}"
                        + "(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])"
                        + "[HM]{1}"
                        + "(AS|BC|BS|CC|CS|CH|CL|CM|DF|DG|GT|GR|HG|JC|MC|MN|MS|NT|NL|OC|PL|QT|QR|SP|SL|SR|TC|TS|TL|VZ|YN|ZS|NE)"
                        + "[B-DF-HJ-NP-TV-Z]{3}"
                        + "[0-9A-Z]{1}[0-9]{1}$");
                Pattern pat2 = Pattern.compile("17([DIX|DML|DPB|DPR|DST|DTV|DZC|DZS|KPR|PDM|PML|PPR|SPR]{3})[0-9]{4}[A-Z]{1}$");
                if (!pat1.matcher(curp).matches()) {
                    request.setAttribute("error", "12");
                    request.getRequestDispatcher("/error.jsp").forward(request, response);
                }
                if (!pat2.matcher(ct).matches()) {
                    request.setAttribute("error", "13");
                    request.getRequestDispatcher("/error.jsp").forward(request, response);
                }
            }
            String edad = curp.substring(4, 6);
            Fachada fachada = new Fachada();
            bandera = fachada.getBandera(curp);
            bandera2 = fachada.getBandera2(curp);
            if (bandera2.equals("1")) {
                if (edad.equals("12") ||edad.equals("11") || edad.equals("10") || edad.equals("09") || edad.equals("08") || edad.equals("07") || bandera.equals("1")) {
                    letras = fachada.LetrasDelDia();
                    if (letras != null || !(letras.equals(""))) {
                        String letraInicialCurp = curp.substring(0, 1);
                        int posicion = letras.indexOf(letraInicialCurp);
                        if (posicion >= 0) {
                            //Validar la CURP con RENAPO
                            BeanCurp unCurp = new BeanCurp();
                            ConsultaCurp datos = new ConsultaCurp();
                            try {
                                unCurp = datos.getCurp(curp);
                                 
                            } catch (AxisFault e) {
                                e.getMessage();
                            }
                            if (unCurp.getNombre() != null) {   //validacion del curp si existe
                                FachadaPadres log = new FachadaPadres ();
                                     int logcurp =  log.logcurp(curp);
                                BeanCTO CtBd = fachada.getCt2(curp); // regresar valor de CT si existe en tabla de curps
                                if (CtBd.getCt() != null) { // valida si el curp está en ct_curp
                                    //BeanCTO CtBd2 = fachada.getCt(CtBd.getCt());
                                    if (CtBd.getNombre() != null) {
                                        String CtBD = CtBd.getCt();
                                        String Ct_nombre = CtBd.getNombre();
                                        //String Ct_municipio = CtBd2.getMunicicpio();
                                        String Ct_direccion = CtBd.getDireccion();
                                        String Ct_turno = CtBd.getTurno();
                                        if (CtBD.equals(ct)) {    //validacion de centro de trabajo
                                            BeanCTO validaCt = fachada.getCt2(curp);
                                            if (validaCt.getCt() != null) {
                                                ct = validaCt.getCt();
                                                Ct_nombre = validaCt.getNombre();
                                                //Ct_municipio = validaCt.getMunicicpio();
                                                Ct_direccion = validaCt.getDireccion();
                                                Ct_turno = validaCt.getTurno();
                                            }
                                            String fecha_nac = "20" + curp.substring(4, 6) + "-" + curp.substring(6, 8) + "-" + curp.substring(8, 10);
                                            String sexo = curp.substring(10, 11);
                                            String edo_nac = curp.substring(11, 13);
                                            String grado = "1";
                                            Fachada VerificarRegistro = new Fachada();
                                            int error = 0;
                                            error = VerificarRegistro.getMsj(curp);
                                            if (error != 0) {
                                                switch (error) {
                                                    case 1:
                                                        FachadaPadres fachada2 = new FachadaPadres();
                                                        String fecha = fachada2.getFecha(curp);
                                                        request.setAttribute("fecha", fecha);
                                                        request.setAttribute("curp", curp);
                                                        request.getRequestDispatcher("/folioConsulta.jsp").forward(request, response);
                                                        break;
                                                }
                                            }
                                            String nombre = unCurp.getNombre().replace("'", "");
                                            String paterno = unCurp.getApaterno().replace("'", "");
                                            String materno = unCurp.getAmaterno().replace("'", "");
                                            request.setAttribute("fecha_nac", fecha_nac);
                                            request.setAttribute("sexo", sexo);
                                            request.setAttribute("edo_nac", edo_nac);
                                            request.setAttribute("grado", grado);
                                            request.setAttribute("curp", curp);
                                            request.setAttribute("nombre", nombre);
                                            request.setAttribute("paterno", paterno);
                                            request.setAttribute("materno", materno);
                                            request.setAttribute("ct", ct);
                                            request.setAttribute("Ct_nombre", Ct_nombre);
                                            request.setAttribute("Ct_direccion", Ct_direccion);
                                            request.setAttribute("Ct_turno", Ct_turno);
                                            request.getRequestDispatcher("/datos_alumno.jsp").forward(request, response);
                                        } else {
                                            BeanCTO validaCt = fachada.getCt2(curp);
                                            if (validaCt.getCt() != null) {
                                                ct = validaCt.getCt();
                                                Ct_nombre = validaCt.getNombre();
                                                //Ct_municipio = validaCt.getMunicicpio();
                                                Ct_direccion = validaCt.getDireccion();
                                                Ct_turno = validaCt.getTurno();
                                            } else {
                                                request.setAttribute("error", "3");
                                                request.getRequestDispatcher("/error.jsp").forward(request, response);
                                            }
                                            String fecha_nac = "20" + curp.substring(4, 6) + "-" + curp.substring(6, 8) + "-" + curp.substring(8, 10);
                                            String sexo = curp.substring(10, 11);
                                            String edo_nac = curp.substring(11, 13);
                                            String grado = "1";
                                            Fachada VerificarRegistro = new Fachada();
                                            int error = 0;
                                            error = VerificarRegistro.getMsj(curp);
                                            if (error != 0) {
                                                switch (error) {
                                                    case 1:
                                                        FachadaPadres fachada2 = new FachadaPadres();
                                                        String fecha = fachada2.getFecha(curp);
                                                        request.setAttribute("fecha", fecha);
                                                        request.setAttribute("curp", curp);
                                                        request.getRequestDispatcher("/folioConsulta.jsp").forward(request, response);
                                                        break;
                                                }
                                            }
                                            String nombre = unCurp.getNombre().replace("'", "");
                                            String paterno = unCurp.getApaterno().replace("'", "");
                                            String materno = unCurp.getAmaterno().replace("'", "");
                                            request.setAttribute("fecha_nac", fecha_nac);
                                            request.setAttribute("sexo", sexo);
                                            request.setAttribute("edo_nac", edo_nac);
                                            request.setAttribute("grado", grado);
                                            request.setAttribute("curp", curp);
                                            request.setAttribute("nombre", nombre);
                                            request.setAttribute("paterno", paterno);
                                            request.setAttribute("materno", materno);
                                            request.setAttribute("ct", ct);
                                            request.setAttribute("Ct_nombre", Ct_nombre);
                                            request.setAttribute("Ct_direccion", Ct_direccion);
                                            request.setAttribute("Ct_turno", Ct_turno);
                                            request.getRequestDispatcher("/datos_alumno.jsp").forward(request, response);
                                        }
                                    } else {
                                        request.setAttribute("error", "3");
                                        request.getRequestDispatcher("/error.jsp").forward(request, response);
                                    }
                                } else {
                                    //String CtBD = CtBd.getCt();
                                    String Ct_nombre = null;
                                    //String Ct_municipio = CtBd2.getMunicicpio();
                                    String Ct_direccion = null;
                                    String Ct_turno = null;
                                    BeanCTO validaCt = fachada.getCt(ct);
                                    if (validaCt.getCt() != null) {
                                        ct = validaCt.getCt();
                                        Ct_nombre = validaCt.getNombre();
                                        //Ct_municipio = validaCt.getMunicicpio();
                                        Ct_direccion = validaCt.getDireccion();
                                        Ct_turno = validaCt.getTurno();
                                    } else {
                                        request.setAttribute("error", "3");
                                        request.getRequestDispatcher("/error.jsp").forward(request, response);
                                    }
                                    String fecha_nac = "20" + curp.substring(4, 6) + "-" + curp.substring(6, 8) + "-" + curp.substring(8, 10);
                                    String sexo = curp.substring(10, 11);
                                    String edo_nac = curp.substring(11, 13);
                                    String grado = "1";
                                    Fachada VerificarRegistro = new Fachada();
                                    int error = 0;
                                    error = VerificarRegistro.getMsj(curp);
                                    if (error != 0) {
                                        switch (error) {
                                            case 1:
                                                request.setAttribute("curp", curp);
                                                request.getRequestDispatcher("/folioConsulta.jsp").forward(request, response);
                                                break;
                                        }
                                    }
                                    String nombre = unCurp.getNombre().replace("'", "");
                                    String paterno = unCurp.getApaterno().replace("'", "");
                                    String materno = unCurp.getAmaterno().replace("'", "");
                                    request.setAttribute("fecha_nac", fecha_nac);
                                    request.setAttribute("sexo", sexo);
                                    request.setAttribute("edo_nac", edo_nac);
                                    request.setAttribute("grado", grado);
                                    request.setAttribute("curp", curp);
                                    request.setAttribute("nombre", nombre);
                                    request.setAttribute("paterno", paterno);
                                    request.setAttribute("materno", materno);
                                    request.setAttribute("ct", ct);
                                    request.setAttribute("Ct_nombre", Ct_nombre);
                                    request.setAttribute("Ct_direccion", Ct_direccion);
                                    request.setAttribute("Ct_turno", Ct_turno);
                                    request.getRequestDispatcher("/datos_alumno.jsp").forward(request, response);
                                }
                            } else {
                                request.setAttribute("error", "10");
                                request.getRequestDispatcher("/error.jsp").forward(request, response);
                            }
                        } else {
                            request.setAttribute("error", "2");
                            request.getRequestDispatcher("/error.jsp").forward(request, response);
                        }
                    } else {
                        request.setAttribute("error", "9");
                        request.getRequestDispatcher("/error.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("error", "14");
                    request.getRequestDispatcher("/error.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("error", "204");
                request.getRequestDispatcher("/error.jsp").forward(request, response);
            }
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
            Logger.getLogger(ServletProcesaDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ServletProcesaDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (KeyManagementException ex) {
            Logger.getLogger(ServletProcesaDatos.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServletProcesaDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ServletProcesaDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (KeyManagementException ex) {
            Logger.getLogger(ServletProcesaDatos.class.getName()).log(Level.SEVERE, null, ex);
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
