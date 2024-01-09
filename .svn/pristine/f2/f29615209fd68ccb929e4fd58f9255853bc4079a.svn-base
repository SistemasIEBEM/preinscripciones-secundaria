/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Bean.BeanCT;
import Bean.BeanCTO;
import Bean.Beansupervisor;
import DaoImpl.CT;
import DaoImpl.Fachada;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author David Costet
 */
public class ServletLogin extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
             HttpSession sesion = request.getSession();
            String valida = request.getParameter("valida");
            if (valida.equals("1")) {
                String ct = request.getParameter("ct").toUpperCase();
                String contra = request.getParameter("pass").toUpperCase();
                Fachada fachada = new Fachada();
                BeanCTO CtBd = fachada.getUsuario(ct, contra);
                String Ct_ct = CtBd.getCt();
                String Ct_contrasena = CtBd.getContrasena();
                if (ct.equals(Ct_ct) && contra.equals(Ct_contrasena) && sesion.getAttribute("usuario") == null) {
                    sesion.setAttribute("usuario", ct);
                    response.sendRedirect("menudir.jsp");
                } else {
                    request.setAttribute("error", "112");
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                }
            } else if (valida.equals("2")) {
                String usuario = request.getParameter("ct").toUpperCase();
                String password = request.getParameter("contra").toUpperCase();
                CT fechada = new CT();
                Beansupervisor bean = fechada.getUsuario(usuario, password);
                String ct_bd = bean.getCt();
                String contra_bd = bean.getClave();
                String nombrects = bean.getNombrect();
                String zonaescolars = bean.getZona();
                Collection<BeanCT> bean2 = fechada.getctporzona(zonaescolars);
                if (usuario.equals(ct_bd) && password.equals(contra_bd)) {
                    sesion.setAttribute("usuario", bean);
                    request.setAttribute("ctzona", bean2);
                    request.getRequestDispatcher("menusuper.jsp").forward(request, response);
                } else {
                    request.setAttribute("error", "111");
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                }
            }else if (valida.equals("3")) {
                String usuario = request.getParameter("ct").toUpperCase();
                String password = request.getParameter("contra").toUpperCase();
                CT fechada = new CT();
                Beansupervisor bean = fechada.getUsuario(usuario, password);
                String ct_bd = bean.getCt();
                String contra_bd = bean.getClave();
                String nombrects = bean.getNombrect();
                String zonaescolars = bean.getZona();
                if (usuario.equals(ct_bd) && password.equals(contra_bd)) {

                    sesion.setAttribute("usuario", bean);
                    request.getRequestDispatcher("menuadmin.jsp").forward(request, response);
                } else {
                    request.setAttribute("error", "115");
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                }
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
        } catch (SQLException ex) {
            Logger.getLogger(ServletLogin.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(ServletLogin.class.getName()).log(Level.SEVERE, null, ex);
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
