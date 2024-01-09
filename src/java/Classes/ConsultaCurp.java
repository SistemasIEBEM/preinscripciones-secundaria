/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Bean.BeanCurp;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.xml.namespace.QName;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.java.security.TrustAllTrustManager;
import org.apache.axis2.rpc.client.RPCServiceClient;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import renapo.DatosConsultaCurp;

/**
 *
 * @author Registro
 */
public class ConsultaCurp {

    private BeanCurp datosCurp;

    public BeanCurp getCurp(String curp) throws AxisFault, MalformedURLException, NoSuchAlgorithmException, KeyManagementException {
        
        SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, new TrustManager[] { new TrustAllTrustManager() }, new java.security.SecureRandom());
        
        //System.setProperty("javax.net.ssl.trustStore", "C:\\renapoprod.keystore");
        //System.setProperty("javax.net.ssl.trustStore", "/home/sistemas/renapoprod.keystore");
        //System.setProperty("javax.net.ssl.trustStore", "/home/iebemAdmin3/renapoprod.keystore");
        /*RPCServiceClient serviceClient = new RPCServiceClient();
         Options options = serviceClient.getOptions();
         EndpointReference targetEPR = new EndpointReference("https://201.175.34.121/WebServicesConsulta/services/ConsultaPorCurpService");
         options.setTo(targetEPR);
         BeanRenapo datos = new BeanRenapo();
         datos.setTipoTransaccion(1);
         datos.setUsuario("WS6770388");
         datos.setPassword("JORA688");
         datos.setDireccionIp("187.174.218.230");
         datos.setCveCurp(Curp);
         datos.setCveEntidadEmisora("1");
         QName opSetAlta = new QName("http://services.wserv.ecurp.dgti.segob.gob.mx", "consultarPorCurp"); //urn:ConsultaCurpService
         Object[] altaServiceArgs = new Object[]{datos};
         Class<?>[] returnTypes = new Class[]{String.class};
         Object[] response = serviceClient.invokeBlocking(opSetAlta,
         altaServiceArgs, returnTypes);
         String result = (String) response[0];
         QName optGetConfirm = new QName("http://services.wserv.ecurp.dgti.segob.gob.mx", "getConfirm");
         Object[] opGetConfirmArgs = new Object[]{getSessionID(result), "OK"};
         serviceClient.invokeRobust(optGetConfirm, opGetConfirmArgs);*/
        String salida;
        String json = null;
        try {
           URL url = new URL("https://wscurp.morelos.gob.mx/restful/curp.json?curp=" + curp + "&token=6af21d42-be7d-4d2e-b500-40f48d1d3a01");
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
            datosCurp = getData(json);
            conn.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return datosCurp;
    }

    /*private static String getSessionID(String xml) {
     String sessionID = "";
     try {
     Document doc = DocumentHelper.parseText(xml);
     Attribute attr = doc.getRootElement().attribute("SessionID");
     sessionID = attr.getText();
     } catch (Exception ignoredException) {
     ignoredException.getMessage();
     }
     return sessionID;
     }*/
    private static BeanCurp getData(String xml) {
        BeanCurp propiedad = new BeanCurp();
        try {
            /*Document doc = DocumentHelper.parseText(xml);
             propiedad.setCurp(doc.getRootElement().elementText("CURP"));
             propiedad.setApaterno(doc.getRootElement().elementText("apellido1"));
             propiedad.setAmaterno(doc.getRootElement().elementText("apellido2"));
             propiedad.setNombre(doc.getRootElement().elementText("nombres"));*/
            JsonObject convertedObject = new Gson().fromJson(xml, JsonObject.class);
            propiedad.setCurp(convertedObject.get("curp").getAsString());
            propiedad.setApaterno(convertedObject.get("apellidoPaterno").getAsString());
            propiedad.setAmaterno(convertedObject.get("apellidoMaterno").getAsString());
            propiedad.setNombre(convertedObject.get("nombre").getAsString());
        } catch (Exception ignoredException) {
            ignoredException.getMessage();
        }
        return propiedad;
    }

}
