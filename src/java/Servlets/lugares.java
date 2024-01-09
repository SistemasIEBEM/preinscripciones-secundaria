/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Bean.BeanFecha;
import Bean.Beanlugaresctgrado;
import Bean.Beanorigen;
import Bean.Beansupervisor;
import DaoImpl.CT;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author David Costet
 */
public class lugares extends HttpServlet {

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
        request.setCharacterEncoding("ISO-8859-1");
        try (PrintWriter out = response.getWriter()) {
            HttpSession sesion = request.getSession();
            Beansupervisor nombre = (Beansupervisor) sesion.getAttribute("usuario");
            CT totalugares = new CT();
            boolean status = false;
            int suma1 = 0;
            String valida = request.getParameter("valida");
            Beanlugaresctgrado ctgrado = new Beanlugaresctgrado();
            String mensaje = "";
            if (valida.equals("1")) {
                String ct = request.getParameter("ct");
                int grado = Integer.parseInt(request.getParameter("grado"));
                String mensaje1 = request.getParameter("mensaje");
                Collection<Beanlugaresctgrado> lugaresctgrado = totalugares.getlugaresctgrado(ct, grado);
                if (lugaresctgrado.equals(null)) {
                    mensaje = "NO HAY LUGARES PARA ESTE CCT";
                } else {
                    sesion.setAttribute("usuario", nombre);
                    request.setAttribute("mensaje_alerta", mensaje1);
                    request.setAttribute("lugaresctgrado", lugaresctgrado);
                    request.getRequestDispatcher("confirmacionctgrado.jsp").forward(request, response);
                }

            } else if (valida.equals("2")) {
                int contador = Integer.parseInt(request.getParameter("contador"));
                int suma = Integer.parseInt(request.getParameter("suma"));
                String ct12 = request.getParameter("ct1");
                int grado12 = Integer.parseInt(request.getParameter("grado1"));
                List<Integer> datos = new ArrayList<>();
                List<Date> datos1 = new ArrayList<>();
                List<String> datos2 = new ArrayList<>();
                List<Integer> datos3 = new ArrayList<>();
                List<Integer> datos4 = new ArrayList<>();
                List<Integer> datos5 = new ArrayList<>();
                for (int i = 1; i <= contador; i++) {
                    String total = "total" + i;
                    String fecha = "fecha" + i;
                    String ct = "ct" + i;
                    String grado = "grado" + i;
                    String modo = "modo" + i;
                    datos.add(Integer.parseInt(request.getParameter(total)));
                    datos1.add(Date.valueOf(request.getParameter(fecha)));
                    datos2.add(request.getParameter(ct));
                    datos3.add(Integer.parseInt(request.getParameter(grado)));
                    datos4.add(Integer.parseInt(request.getParameter(modo)));
                }
                for (int j = 0; j < contador; j++) {
                    ctgrado.setTotal(datos.get(j));
                    suma1 = suma1 + ctgrado.getTotal();
                }

                if (suma1 == suma) {
                    for (int i = 0; i < contador; i++) {
                        ctgrado.setFecha(datos1.get(i));
                        ctgrado.setCt(datos2.get(i));
                        ctgrado.setGrado(datos3.get(i));
                        ctgrado.setTotal(datos.get(i));
                        ctgrado.setModo(datos4.get(i));
                        status = totalugares.actualizalugares(ctgrado);
                    }
                } else {
                    String mensaje_alerta = " NO SE ACTUALIZO POR QUE EL TOTAL DE LOS LUGARES ACTUALES NO CORRESPONDE CON EL ANTERIOR";
                    request.getRequestDispatcher("lugares?valida=1&&ct=" + ct12 + "&&grado=" + grado12 + "&&mensaje=" + mensaje_alerta).forward(request, response);
                }
                String mensaje_alerta = "EL REGISTRO SE ACTUALIZO CORRECTAMENTE";
                request.getRequestDispatcher("lugares?valida=1&&ct=" + ct12 + "&&grado=" + grado12 + "&&mensaje=" + mensaje_alerta).forward(request, response);
                /*TODO output your page here. You may use following sample code.*/
            } else if (valida.equals("3")) {
                String fecha = request.getParameter("fecha");
                CT estadistica = new CT();
                estadistica.getestadistica(fecha);
                ArrayList<BeanFecha> conteohora = (ArrayList<BeanFecha>) estadistica.getreporte();

                if (conteohora.equals(null)) {
                    mensaje = "no hay alumnos registrados";
                } else {
                    sesion.setAttribute("usuario", nombre);
                    request.setAttribute("mensaje", mensaje);
                    request.setAttribute("conteo", conteohora);

                    request.getRequestDispatcher("estadisticas.jsp").forward(request, response);
                }
            } else if (valida.equals("4")) {
                CT origen = new CT();
                boolean estatus = false;
                int numero = Integer.parseInt(request.getParameter("numero"));
                String ct = request.getParameter("ct");

                if (numero == 0) {
                    Beanorigen bean = new Beanorigen();
                    String ct1 = request.getParameter("ct1");
                    bean = origen.getvalidarorigen(ct, ct1);
                    if (bean.getCt_destino() != ("") && bean.getCt_origen() != ("")) {
                        System.out.println("ya existe");
                    } else {
                        estatus = origen.getinsertaorigen(ct, ct1);
                    }

                } else if (numero == 2) {
                    Beanorigen bean = new Beanorigen();
                    Beanorigen bean1 = new Beanorigen();

                    String ct1 = request.getParameter("ct1");
                    String ct2 = request.getParameter("ct2");
                    bean = origen.getvalidarorigen(ct, ct1);
                    bean1 = origen.getvalidarorigen(ct, ct2);
                    if (bean.getCt_destino() != ("") && bean.getCt_origen() != ("")) {
                        System.out.println("ya existe");
                    } else {
                        estatus = origen.getinsertaorigen(ct, ct1);
                    }
                    if (bean1.getCt_destino() != ("") && bean1.getCt_origen() != ("")) {
                        System.out.println("ya existe");
                    } else {
                        estatus = origen.getinsertaorigen(ct, ct2);
                    }

                } else if (numero == 3) {
                    Beanorigen bean = new Beanorigen();
                    Beanorigen bean1 = new Beanorigen();
                    Beanorigen bean2 = new Beanorigen();
                    String ct1 = request.getParameter("ct1");
                    String ct2 = request.getParameter("ct2");
                    String ct3 = request.getParameter("ct3");
                    bean = origen.getvalidarorigen(ct, ct1);
                    bean1 = origen.getvalidarorigen(ct, ct2);
                    bean2 = origen.getvalidarorigen(ct, ct3);
                    if (bean.getCt_destino() != (null) && bean.getCt_origen() != (null)) {
                        System.out.println("ya existe");
                    } else {
                        estatus = origen.getinsertaorigen(ct, ct1);
                    }
                    if (bean1.getCt_destino() != ("") && bean1.getCt_origen() != ("")) {
                        System.out.println("ya existe");
                    } else {
                        estatus = origen.getinsertaorigen(ct, ct2);
                    }
                    if (bean2.getCt_destino() != ("") && bean2.getCt_origen() != ("")) {
                        System.out.println("ya existe");
                    } else {
                        estatus = origen.getinsertaorigen(ct, ct3);
                    }

                } else if (numero == 4) {
                    Beanorigen bean = new Beanorigen();
                    Beanorigen bean1 = new Beanorigen();
                    Beanorigen bean2 = new Beanorigen();
                    Beanorigen bean3 = new Beanorigen();

                    String ct1 = request.getParameter("ct1");
                    String ct2 = request.getParameter("ct2");
                    String ct3 = request.getParameter("ct3");
                    String ct4 = request.getParameter("ct4");
                    bean = origen.getvalidarorigen(ct, ct1);
                    bean1 = origen.getvalidarorigen(ct, ct2);
                    bean2 = origen.getvalidarorigen(ct, ct3);
                    bean3 = origen.getvalidarorigen(ct, ct4);

                    if (bean.getCt_destino() != ("") && bean.getCt_origen() != ("")) {
                        System.out.println("ya existe");
                    } else {
                        estatus = origen.getinsertaorigen(ct, ct1);
                    }
                    if (bean1.getCt_destino() != ("") && bean1.getCt_origen() != ("")) {
                        System.out.println("ya existe");
                    } else {
                        estatus = origen.getinsertaorigen(ct, ct2);
                    }
                    if (bean2.getCt_destino() != ("") && bean2.getCt_origen() != ("")) {
                        System.out.println("ya existe");
                    } else {
                        estatus = origen.getinsertaorigen(ct, ct3);
                    }
                    if (bean3.getCt_destino() != ("") && bean3.getCt_origen() != ("")) {
                        System.out.println("ya existe");
                    } else {
                        estatus = origen.getinsertaorigen(ct, ct4);
                    }
                } else if (numero == 5) {
                    Beanorigen bean = new Beanorigen();
                    Beanorigen bean1 = new Beanorigen();
                    Beanorigen bean2 = new Beanorigen();
                    Beanorigen bean3 = new Beanorigen();
                    Beanorigen bean4 = new Beanorigen();

                    String ct1 = request.getParameter("ct1");
                    String ct2 = request.getParameter("ct2");
                    String ct3 = request.getParameter("ct3");
                    String ct4 = request.getParameter("ct4");
                    String ct5 = request.getParameter("ct5");

                    bean = origen.getvalidarorigen(ct, ct1);
                    bean1 = origen.getvalidarorigen(ct, ct2);
                    bean2 = origen.getvalidarorigen(ct, ct3);
                    bean3 = origen.getvalidarorigen(ct, ct4);
                    bean4 = origen.getvalidarorigen(ct, ct5);

                    if (bean.getCt_destino() != ("") && bean.getCt_origen() != ("")) {
                        System.out.println("ya existe");
                    } else {
                        estatus = origen.getinsertaorigen(ct, ct1);
                    }
                    if (bean1.getCt_destino() != ("") && bean1.getCt_origen() != ("")) {
                        System.out.println("ya existe");
                    } else {
                        estatus = origen.getinsertaorigen(ct, ct2);
                    }
                    if (bean2.getCt_destino() != ("") && bean2.getCt_origen() != ("")) {
                        System.out.println("ya existe");
                    } else {
                        estatus = origen.getinsertaorigen(ct, ct3);
                    }
                    if (bean3.getCt_destino() != ("") && bean3.getCt_origen() != ("")) {
                        System.out.println("ya existe");
                    } else {
                        estatus = origen.getinsertaorigen(ct, ct4);
                    }
                    if (bean4.getCt_destino() != ("") && bean4.getCt_origen() != ("")) {
                        System.out.println("ya existe");
                    } else {
                        estatus = origen.getinsertaorigen(ct, ct5);
                    }
                } else if (numero == 6) {
                    Beanorigen bean = new Beanorigen();
                    Beanorigen bean1 = new Beanorigen();
                    Beanorigen bean2 = new Beanorigen();
                    Beanorigen bean3 = new Beanorigen();
                    Beanorigen bean4 = new Beanorigen();
                    Beanorigen bean5 = new Beanorigen();
                    String ct1 = request.getParameter("ct1");
                    String ct2 = request.getParameter("ct2");
                    String ct3 = request.getParameter("ct3");
                    String ct4 = request.getParameter("ct4");
                    String ct5 = request.getParameter("ct5");
                    String ct6 = request.getParameter("ct6");

                    bean = origen.getvalidarorigen(ct, ct1);
                    bean1 = origen.getvalidarorigen(ct, ct2);
                    bean2 = origen.getvalidarorigen(ct, ct3);
                    bean3 = origen.getvalidarorigen(ct, ct4);
                    bean4 = origen.getvalidarorigen(ct, ct5);
                    bean5 = origen.getvalidarorigen(ct, ct6);

                    if (bean.getCt_destino() != ("") && bean.getCt_origen() != ("")) {
                        System.out.println("ya existe");
                    } else {
                        estatus = origen.getinsertaorigen(ct, ct1);
                    }
                    if (bean1.getCt_destino() != ("") && bean1.getCt_origen() != ("")) {
                        System.out.println("ya existe");
                    } else {
                        estatus = origen.getinsertaorigen(ct, ct2);
                    }
                    if (bean2.getCt_destino() != ("") && bean2.getCt_origen() != ("")) {
                        System.out.println("ya existe");
                    } else {
                        estatus = origen.getinsertaorigen(ct, ct3);
                    }
                    if (bean3.getCt_destino() != ("") && bean3.getCt_origen() != ("")) {
                        System.out.println("ya existe");
                    } else {
                        estatus = origen.getinsertaorigen(ct, ct4);
                    }
                    if (bean4.getCt_destino() != ("") && bean4.getCt_origen() != ("")) {
                        System.out.println("ya existe");
                    } else {
                        estatus = origen.getinsertaorigen(ct, ct5);
                    }
                    if (bean5.getCt_destino() != ("") && bean5.getCt_origen() != ("")) {
                        System.out.println("ya existe");
                    } else {
                        estatus = origen.getinsertaorigen(ct, ct6);
                    }

                } else if (numero == 7) {

                    Beanorigen bean = new Beanorigen();
                    Beanorigen bean1 = new Beanorigen();
                    Beanorigen bean2 = new Beanorigen();
                    Beanorigen bean3 = new Beanorigen();
                    Beanorigen bean4 = new Beanorigen();
                    Beanorigen bean5 = new Beanorigen();
                    Beanorigen bean6 = new Beanorigen();
                    String ct1 = request.getParameter("ct1");
                    String ct2 = request.getParameter("ct2");
                    String ct3 = request.getParameter("ct3");
                    String ct4 = request.getParameter("ct4");
                    String ct5 = request.getParameter("ct5");
                    String ct6 = request.getParameter("ct6");
                    String ct7 = request.getParameter("ct7");

                    bean = origen.getvalidarorigen(ct, ct1);
                    bean1 = origen.getvalidarorigen(ct, ct2);
                    bean2 = origen.getvalidarorigen(ct, ct3);
                    bean3 = origen.getvalidarorigen(ct, ct4);
                    bean4 = origen.getvalidarorigen(ct, ct5);
                    bean5 = origen.getvalidarorigen(ct, ct6);
                    bean6 = origen.getvalidarorigen(ct, ct7);

                    if (bean.getCt_destino() != ("") && bean.getCt_origen() != ("")) {
                        System.out.println("ya existe");
                    } else {
                        estatus = origen.getinsertaorigen(ct, ct1);
                    }
                    if (bean1.getCt_destino() != ("") && bean1.getCt_origen() != ("")) {
                        System.out.println("ya existe");
                    } else {
                        estatus = origen.getinsertaorigen(ct, ct2);
                    }
                    if (bean2.getCt_destino() != ("") && bean2.getCt_origen() != ("")) {
                        System.out.println("ya existe");
                    } else {
                        estatus = origen.getinsertaorigen(ct, ct3);
                    }
                    if (bean3.getCt_destino() != ("") && bean3.getCt_origen() != ("")) {
                        System.out.println("ya existe");
                    } else {
                        estatus = origen.getinsertaorigen(ct, ct4);
                    }
                    if (bean4.getCt_destino() != ("") && bean4.getCt_origen() != ("")) {
                        System.out.println("ya existe");
                    } else {
                        estatus = origen.getinsertaorigen(ct, ct5);
                    }
                    if (bean5.getCt_destino() != ("") && bean5.getCt_origen() != ("")) {
                        System.out.println("ya existe");
                    } else {
                        estatus = origen.getinsertaorigen(ct, ct6);
                    }
                    if (bean6.getCt_destino() != ("") && bean6.getCt_origen() != ("")) {
                        System.out.println("ya existe");
                    } else {
                        estatus = origen.getinsertaorigen(ct, ct7);
                    }
                } else if (numero == 8) {
                    Beanorigen bean = new Beanorigen();
                    Beanorigen bean1 = new Beanorigen();
                    Beanorigen bean2 = new Beanorigen();
                    Beanorigen bean3 = new Beanorigen();
                    Beanorigen bean4 = new Beanorigen();
                    Beanorigen bean5 = new Beanorigen();
                    Beanorigen bean6 = new Beanorigen();
                    Beanorigen bean7 = new Beanorigen();

                    String ct1 = request.getParameter("ct1");
                    String ct2 = request.getParameter("ct2");
                    String ct3 = request.getParameter("ct3");
                    String ct4 = request.getParameter("ct4");
                    String ct5 = request.getParameter("ct5");
                    String ct6 = request.getParameter("ct6");
                    String ct7 = request.getParameter("ct7");
                    String ct8 = request.getParameter("ct8");

                    bean = origen.getvalidarorigen(ct, ct1);
                    bean1 = origen.getvalidarorigen(ct, ct2);
                    bean2 = origen.getvalidarorigen(ct, ct3);
                    bean3 = origen.getvalidarorigen(ct, ct4);
                    bean4 = origen.getvalidarorigen(ct, ct5);
                    bean5 = origen.getvalidarorigen(ct, ct6);
                    bean6 = origen.getvalidarorigen(ct, ct7);
                    bean7 = origen.getvalidarorigen(ct, ct8);

                    if (bean.getCt_destino() != ("") && bean.getCt_origen() != ("")) {
                        System.out.println("ya existe");
                    } else {
                        estatus = origen.getinsertaorigen(ct, ct1);
                    }
                    if (bean1.getCt_destino() != ("") && bean1.getCt_origen() != ("")) {
                        System.out.println("ya existe");
                    } else {
                        estatus = origen.getinsertaorigen(ct, ct2);
                    }
                    if (bean2.getCt_destino() != ("") && bean2.getCt_origen() != ("")) {
                        System.out.println("ya existe");
                    } else {
                        estatus = origen.getinsertaorigen(ct, ct3);
                    }
                    if (bean3.getCt_destino() != ("") && bean3.getCt_origen() != ("")) {
                        System.out.println("ya existe");
                    } else {
                        estatus = origen.getinsertaorigen(ct, ct4);
                    }
                    if (bean4.getCt_destino() != ("") && bean4.getCt_origen() != ("")) {
                        System.out.println("ya existe");
                    } else {
                        estatus = origen.getinsertaorigen(ct, ct5);
                    }
                    if (bean5.getCt_destino() != ("") && bean5.getCt_origen() != ("")) {
                        System.out.println("ya existe");
                    } else {
                        estatus = origen.getinsertaorigen(ct, ct6);
                    }
                    if (bean6.getCt_destino() != ("") && bean6.getCt_origen() != ("")) {
                        System.out.println("ya existe");
                    } else {
                        estatus = origen.getinsertaorigen(ct, ct7);
                    }
                    if (bean7.getCt_destino() != ("") && bean7.getCt_origen() != ("")) {
                        System.out.println("ya existe");
                    } else {
                        estatus = origen.getinsertaorigen(ct, ct8);
                    }

                } else if (numero == 9) {
                    Beanorigen bean = new Beanorigen();
                    Beanorigen bean1 = new Beanorigen();
                    Beanorigen bean2 = new Beanorigen();
                    Beanorigen bean3 = new Beanorigen();
                    Beanorigen bean4 = new Beanorigen();
                    Beanorigen bean5 = new Beanorigen();
                    Beanorigen bean6 = new Beanorigen();
                    Beanorigen bean7 = new Beanorigen();
                    Beanorigen bean8 = new Beanorigen();

                    String ct1 = request.getParameter("ct1");
                    String ct2 = request.getParameter("ct2");
                    String ct3 = request.getParameter("ct3");
                    String ct4 = request.getParameter("ct4");
                    String ct5 = request.getParameter("ct5");
                    String ct6 = request.getParameter("ct6");
                    String ct7 = request.getParameter("ct7");
                    String ct8 = request.getParameter("ct8");
                    String ct9 = request.getParameter("ct9");

                    bean = origen.getvalidarorigen(ct, ct1);
                    bean1 = origen.getvalidarorigen(ct, ct2);
                    bean2 = origen.getvalidarorigen(ct, ct3);
                    bean3 = origen.getvalidarorigen(ct, ct4);
                    bean4 = origen.getvalidarorigen(ct, ct5);
                    bean5 = origen.getvalidarorigen(ct, ct6);
                    bean6 = origen.getvalidarorigen(ct, ct7);
                    bean7 = origen.getvalidarorigen(ct, ct8);
                    bean8 = origen.getvalidarorigen(ct, ct9);

                    if (bean.getCt_destino() != ("") && bean.getCt_origen() != ("")) {
                        System.out.println("ya existe");
                    } else {
                        estatus = origen.getinsertaorigen(ct, ct1);
                    }
                    if (bean1.getCt_destino() != ("") && bean1.getCt_origen() != ("")) {
                        System.out.println("ya existe");
                    } else {
                        estatus = origen.getinsertaorigen(ct, ct2);
                    }
                    if (bean2.getCt_destino() != ("") && bean2.getCt_origen() != ("")) {
                        System.out.println("ya existe");
                    } else {
                        estatus = origen.getinsertaorigen(ct, ct3);
                    }
                    if (bean3.getCt_destino() != ("") && bean3.getCt_origen() != ("")) {
                        System.out.println("ya existe");
                    } else {
                        estatus = origen.getinsertaorigen(ct, ct4);
                    }
                    if (bean4.getCt_destino() != ("") && bean4.getCt_origen() != ("")) {
                        System.out.println("ya existe");
                    } else {
                        estatus = origen.getinsertaorigen(ct, ct5);
                    }
                    if (bean5.getCt_destino() != ("") && bean5.getCt_origen() != ("")) {
                        System.out.println("ya existe");
                    } else {
                        estatus = origen.getinsertaorigen(ct, ct6);
                    }
                    if (bean6.getCt_destino() != ("") && bean6.getCt_origen() != ("")) {
                        System.out.println("ya existe");
                    } else {
                        estatus = origen.getinsertaorigen(ct, ct7);
                    }
                    if (bean7.getCt_destino() != ("") && bean7.getCt_origen() != ("")) {
                        System.out.println("ya existe");
                    } else {
                        estatus = origen.getinsertaorigen(ct, ct8);
                    }
                    if (bean8.getCt_destino() != ("") && bean8.getCt_origen() != ("")) {
                        System.out.println("ya existe");
                    } else {
                        estatus = origen.getinsertaorigen(ct, ct9);
                    }

                } else if (numero == 10) {
                    Beanorigen bean = new Beanorigen();
                    Beanorigen bean1 = new Beanorigen();
                    Beanorigen bean2 = new Beanorigen();
                    Beanorigen bean3 = new Beanorigen();
                    Beanorigen bean4 = new Beanorigen();
                    Beanorigen bean5 = new Beanorigen();
                    Beanorigen bean6 = new Beanorigen();
                    Beanorigen bean7 = new Beanorigen();
                    Beanorigen bean8 = new Beanorigen();
                    Beanorigen bean9 = new Beanorigen();

                    String ct1 = request.getParameter("ct1");
                    String ct2 = request.getParameter("ct2");
                    String ct3 = request.getParameter("ct3");
                    String ct4 = request.getParameter("ct4");
                    String ct5 = request.getParameter("ct5");
                    String ct6 = request.getParameter("ct6");
                    String ct7 = request.getParameter("ct7");
                    String ct8 = request.getParameter("ct8");
                    String ct9 = request.getParameter("ct9");
                    String ct10 = request.getParameter("ct10");

                    bean = origen.getvalidarorigen(ct, ct1);
                    bean1 = origen.getvalidarorigen(ct, ct2);
                    bean2 = origen.getvalidarorigen(ct, ct3);
                    bean3 = origen.getvalidarorigen(ct, ct4);
                    bean4 = origen.getvalidarorigen(ct, ct5);
                    bean5 = origen.getvalidarorigen(ct, ct6);
                    bean6 = origen.getvalidarorigen(ct, ct7);
                    bean7 = origen.getvalidarorigen(ct, ct8);
                    bean8 = origen.getvalidarorigen(ct, ct9);
                    bean9 = origen.getvalidarorigen(ct, ct10);

                    if (bean.getCt_destino() != ("") && bean.getCt_origen() != ("")) {
                        System.out.println("ya existe");
                    } else {
                        estatus = origen.getinsertaorigen(ct, ct1);
                    }
                    if (bean1.getCt_destino() != ("") && bean1.getCt_origen() != ("")) {
                        System.out.println("ya existe");
                    } else {
                        estatus = origen.getinsertaorigen(ct, ct2);
                    }
                    if (bean2.getCt_destino() != ("") && bean2.getCt_origen() != ("")) {
                        System.out.println("ya existe");
                    } else {
                        estatus = origen.getinsertaorigen(ct, ct3);
                    }
                    if (bean3.getCt_destino() != ("") && bean3.getCt_origen() != ("")) {
                        System.out.println("ya existe");
                    } else {
                        estatus = origen.getinsertaorigen(ct, ct4);
                    }
                    if (bean4.getCt_destino() != ("") && bean4.getCt_origen() != ("")) {
                        System.out.println("ya existe");
                    } else {
                        estatus = origen.getinsertaorigen(ct, ct5);
                    }
                    if (bean5.getCt_destino() != ("") && bean5.getCt_origen() != ("")) {
                        System.out.println("ya existe");
                    } else {
                        estatus = origen.getinsertaorigen(ct, ct6);
                    }
                    if (bean6.getCt_destino() != ("") && bean6.getCt_origen() != ("")) {
                        System.out.println("ya existe");
                    } else {
                        estatus = origen.getinsertaorigen(ct, ct7);
                    }
                    if (bean7.getCt_destino() != ("") && bean7.getCt_origen() != ("")) {
                        System.out.println("ya existe");
                    } else {
                        estatus = origen.getinsertaorigen(ct, ct8);
                    }
                    if (bean8.getCt_destino() != ("") && bean8.getCt_origen() != ("")) {
                        System.out.println("ya existe");
                    } else {
                        estatus = origen.getinsertaorigen(ct, ct9);
                    }
                    if (bean9.getCt_destino() != ("") && bean9.getCt_origen() != ("")) {
                        System.out.println("ya existe");
                    } else {
                        estatus = origen.getinsertaorigen(ct, ct10);
                    }

                }

                request.getRequestDispatcher("confirmarorigen.jsp").forward(request, response);

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
            Logger.getLogger(lugares.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(lugares.class.getName()).log(Level.SEVERE, null, ex);
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
