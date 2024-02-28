/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DaoImpl.FachadaPadres;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.axis2.java.security.TrustAllTrustManager;

public class ServletProcRenapo extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NoSuchAlgorithmException, KeyManagementException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //BeanPres renapo = new BeanPres();
            //String mensaje = "";
            Gson gson = new Gson();
            //String parametros = "";
            String Json = "";
            String curp = request.getParameter("curp").toUpperCase();
            
           if(curp.equals("")){}else{
                 FachadaPadres log = new FachadaPadres ();
                int logcurp =  log.logcurp(curp);
           } 
          
            
            
              SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, new TrustManager[] { new TrustAllTrustManager() }, new java.security.SecureRandom());
            //System.setProperty("javax.net.ssl.trustStore", "/home/iebemAdmin3/renapoprod.keystore");
            /*System.setProperty("javax.net.ssl.trustStore", "C:\\renapoprod.keystore");
             RPCServiceClient serviceClient = new RPCServiceClient();
             Options options = serviceClient.getOptions();
             EndpointReference targetEPR = new EndpointReference("https://201.175.34.121/WebServicesGestion/services/ConsultaPorCurpService");
             options.setTo(targetEPR);
             BeanRenapo datos = new BeanRenapo();
             datos.setTipoTransaccion(1);
             datos.setUsuario("WS6770388");
             datos.setPassword("JORA688");
             datos.setDireccionIp("187.174.218.230");
             datos.setCveCurp(curp);
             datos.setCveEntidadEmisora("1");
             QName opSetAlta = new QName("http://services.wserv.ecurp.dgti.segob.gob.mx", "consultarPorCurp");
             Object[] altaServiceArgs = new Object[]{datos};
             Class<?>[] returnTypes = new Class[]{String.class};
             Object[] respuesta = serviceClient.invokeBlocking(opSetAlta, altaServiceArgs, returnTypes);
             String resultado = (String) respuesta[0];
             DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
             DocumentBuilder builder = factory.newDocumentBuilder();
             Document doc = builder.parse(new InputSource(new StringReader(resultado)));
             NodeList datosCurp = doc.getElementsByTagName("CURPStruct");
             Node datos_curp = datosCurp.item(0);
             if (datos_curp.getNodeType() == Node.ELEMENT_NODE) {
             Element elemento = (Element) datos_curp;
             //if (datos_curp.getFirstChild() == null) {
             NodoTag nodo = new NodoTag();
             String t0 = nodo.getTagValue("CURP", elemento);
             renapo.setCurp(t0);
             String t1 = nodo.getTagValue("nombres", elemento);
             renapo.setNombre(t1);
             NodeList nm = doc.getElementsByTagName("apellido1");
             if (nm.getLength() > 0) {
             Node n = nm.item(0);
             Node child = n.getFirstChild();
             if (child == null) {
             renapo.setPaterno("");
             } else {
             String t2 = nodo.getTagValue("apellido1", elemento);
             renapo.setPaterno(t2);
             }
             }
             NodeList nm2 = doc.getElementsByTagName("apellido2");
             if (nm2.getLength() > 0) {
             Node n2 = nm2.item(0);
             Node child2 = n2.getFirstChild();
             if (child2 == null) {
             renapo.setMaterno("");
             } else {
             String t3 = nodo.getTagValue("apellido2", elemento);
             renapo.setMaterno(t3);
             }
             }
             String t4 = nodo.getTagValue("fechNac", elemento);
             renapo.setFecha_nac(t4);
             String t5 = nodo.getTagValue("cveEntidadNac", elemento);
             renapo.setEdonac(t5);
             String t6 = nodo.getTagValue("sexo", elemento);
             renapo.setSexo(t6);*/
            String salida;
            String json = null;
            try {
                URL url = new URL("https://curp.iebem.edu.mx/curp.json?curp=" + curp );
                 HttpsURLConnection  conn = (HttpsURLConnection ) url.openConnection();
                         conn.setSSLSocketFactory(sc.getSocketFactory());
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept", "application/json");
                if (conn.getResponseCode() != 200) {
                    throw new RuntimeException("Failed : HTTP error code : "
                            + conn.getResponseCode());
                }

                BufferedReader br = new BufferedReader(new InputStreamReader(
                        (conn.getInputStream()), "UTF-8"));
                while ((salida = br.readLine()) != null) {
                    json = salida;
                }
                conn.disconnect();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //parametros = gson.toJson(renapo);
            Json = "{\"parametros\": " + json + "}";
            out.print(Json);
            //}
            //}
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
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ServletProcRenapo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (KeyManagementException ex) {
            Logger.getLogger(ServletProcRenapo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletProcRenapo.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ServletProcRenapo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (KeyManagementException ex) {
            Logger.getLogger(ServletProcRenapo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletProcRenapo.class.getName()).log(Level.SEVERE, null, ex);
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
