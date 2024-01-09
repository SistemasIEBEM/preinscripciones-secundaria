/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.activation.MimetypesFileTypeMap;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Dao.DaoArchivo;
import Bean.BeanPres;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.CellView;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.Label;

/**
 *
 * @author David Costet
 */
public class ServletArchivo extends HttpServlet {

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
            throws ServletException, IOException, SQLException, WriteException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sesion = request.getSession();
        sesion.getAttribute("usuario");

        String opc = request.getParameter("opc");
        String ct = request.getParameter("ct");
        String dirUploadFiles;
        dirUploadFiles = getServletContext().getRealPath("/archivos/lista_alumnos_del_" + ct + "_preinscritos.xls");
        DaoArchivo pres = new DaoArchivo();
        List<BeanPres> datos = new ArrayList<>();
        switch (opc) {
            case "DescargarListaExcel":
                List<BeanPres> alumnos = (List<BeanPres>) pres.getlistaalumnos(ct);
                /*  for (BeanPres beanA : alumnos) {
                 BeanPres bean = new BeanPres();
                 bean.setFolio(beanA.getFolio());
                 bean.setCurp(beanA.getCurp());
                 bean.setPaterno(beanA.getPaterno());
                 bean.setMaterno(beanA.getMaterno());
                 bean.setNombre(beanA.getNombre());
                 bean.setFecha(beanA.getFecha());
                 bean.setSexo(beanA.getSexo());
                 bean.setEdonac(beanA.getEdonac());
                 bean.setCt(beanA.getCt());
                 bean.setGrado(beanA.getGrado());
                 bean.setModo(beanA.getModo());
                 bean.setDom_direccion(beanA.getDom_direccion());
                 bean.setTelefono(beanA.getTelefono());
                 bean.setTutor(beanA.getTutor());
                 bean.setCorreo(beanA.getCorreo());
                 datos.add(bean);
                 }*/
                try {
                    WritableWorkbook wworkbook;
                    dirUploadFiles = getServletContext().getRealPath("/archivos/lista_alumnos_del_" + ct + "_preinscritos.xls");
                    wworkbook = Workbook.createWorkbook(new File(dirUploadFiles));
                    WritableSheet wsheet = wworkbook.createSheet("ListaAlumnosPreinscritos", 0);
                    CellView cellView2 = wsheet.getColumnView(1);
                    cellView2.setAutosize(true);
                    wsheet.setColumnView(1, cellView2);
                    CellView cellView3 = wsheet.getColumnView(2);
                    cellView3.setAutosize(true);
                    wsheet.setColumnView(2, cellView3);
                    CellView cellView4 = wsheet.getColumnView(3);
                    cellView4.setAutosize(true);
                    wsheet.setColumnView(3, cellView4);
                    CellView cellView5 = wsheet.getColumnView(4);
                    cellView5.setAutosize(true);
                    wsheet.setColumnView(4, cellView5);
                    CellView cellView6 = wsheet.getColumnView(5);
                    cellView6.setAutosize(true);
                    wsheet.setColumnView(5, cellView6);
                    CellView cellView7 = wsheet.getColumnView(6);
                    cellView7.setAutosize(true);
                    wsheet.setColumnView(6, cellView7);
                    CellView cellView8 = wsheet.getColumnView(7);
                    cellView8.setAutosize(true);
                    wsheet.setColumnView(7, cellView8);
                    CellView cellView9 = wsheet.getColumnView(8);
                    cellView9.setAutosize(true);
                    wsheet.setColumnView(8, cellView9);
                    WritableFont wfc = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
                    WritableCellFormat celda = new WritableCellFormat(wfc);
                    celda.setAlignment(Alignment.CENTRE);
                    celda.setBackground(Colour.BLACK);
                    WritableFont wfc2 = new WritableFont(WritableFont.ARIAL, 14, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
                    WritableCellFormat celda2 = new WritableCellFormat(wfc2);
                    celda2.setAlignment(Alignment.CENTRE);
                    WritableFont wfc3 = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.RED);
                    WritableCellFormat celda3 = new WritableCellFormat(wfc3);
                    celda3.setAlignment(Alignment.CENTRE);
                    celda3.setBackground(Colour.BLACK);
                    Label labelFormato = new Label(2, 0, "INSTITUTO DE LA EDUCACIÓN BÁSICA DEL ESTADO DE MORELOS", celda2);
                    wsheet.addCell(labelFormato);
                    labelFormato = new Label(2, 2, "DIRECCIÓN DE PLANEACIÓN EDUCATIVA", celda2);
                    wsheet.addCell(labelFormato);
                    labelFormato = new Label(2, 4, "SISTEMA DE PREINSCRIPCIONES EN EDUCACIÓN BÁSICA", celda2);
                    wsheet.addCell(labelFormato);
                    labelFormato = new Label(2, 6, "CENTRO DE TRABAJO:  " + ct, celda2);
                    wsheet.addCell(labelFormato);

                    int col0 = 0;
                    int col1 = 1;
                    int col2 = 2;
                    int col3 = 3;
                    int col4 = 4;
                    int col5 = 5;
                    int col6 = 6;
                    int col7 = 7;
                    int col8 = 8;
                    int col9 = 9;
                    int col10 = 10;
                    int col11 = 11;
                    int col12 = 12;
                    int col13 = 13;
                    int col14 = 14;

                    labelFormato = new Label(col0, 10, "N.P", celda3);
                    wsheet.addCell(labelFormato);
                    labelFormato = new Label(col1, 10, "FOLIO", celda3);
                    wsheet.addCell(labelFormato);
                    labelFormato = new Label(col2, 10, "CURP", celda3);
                    wsheet.addCell(labelFormato);
                    labelFormato = new Label(col3, 10, "PRIMER APELLIDO", celda3);
                    wsheet.addCell(labelFormato);
                    labelFormato = new Label(col4, 10, "SEGUNDO APELLIDO", celda3);
                    wsheet.addCell(labelFormato);
                    labelFormato = new Label(col5, 10, "NOMBRE(S)", celda3);
                    wsheet.addCell(labelFormato);
                    labelFormato = new Label(col6, 10, "FECHA DE NACIMIENTO", celda3);
                    wsheet.addCell(labelFormato);
                    labelFormato = new Label(col7, 10, "SEXO", celda3);
                    wsheet.addCell(labelFormato);
                    labelFormato = new Label(col8, 10, "ENTIDAD DE NACIMIENTO", celda3);
                    wsheet.addCell(labelFormato);
                    labelFormato = new Label(col9, 10, "GRADO", celda3);
                    wsheet.addCell(labelFormato);
                    labelFormato = new Label(col10, 10, "DOMICILIO", celda3);
                    wsheet.addCell(labelFormato);
                    labelFormato = new Label(col11, 10, "TELEFONO", celda3);
                    wsheet.addCell(labelFormato);
                    labelFormato = new Label(col12, 10, "TUTOR", celda3);
                    wsheet.addCell(labelFormato);
                    labelFormato = new Label(col13, 10, "CORREO", celda3);
                    wsheet.addCell(labelFormato);

                    int fila = 11;
                    int count = 1;
                    for (BeanPres beanAnt : alumnos) {
                        Label label = new Label(0, fila, String.valueOf(count), celda);
                        String fecha = String.valueOf(beanAnt.getFecha());
                        String grado = String.valueOf(beanAnt.getGrado());
                        String modo = String.valueOf(beanAnt.getModo());
                        wsheet.addCell(label);
                        label = new Label(1, fila, beanAnt.getFolio(), celda);
                        wsheet.addCell(label);
                        label = new Label(2, fila, beanAnt.getCurp(), celda);
                        wsheet.addCell(label);
                        label = new Label(3, fila, beanAnt.getPaterno(), celda);
                        wsheet.addCell(label);
                        label = new Label(4, fila, beanAnt.getMaterno(), celda);
                        wsheet.addCell(label);
                        label = new Label(5, fila, beanAnt.getNombre(), celda);
                        wsheet.addCell(label);
                        label = new Label(6, fila, fecha, celda);
                        wsheet.addCell(label);
                        label = new Label(7, fila, beanAnt.getSexo(), celda);
                        wsheet.addCell(label);
                        label = new Label(8, fila, beanAnt.getEdonac(), celda);
                        wsheet.addCell(label);
                        label = new Label(9, fila, grado, celda);
                        wsheet.addCell(label);
                        label = new Label(10, fila, beanAnt.getDom_direccion(), celda);
                        wsheet.addCell(label);
                        label = new Label(11, fila, beanAnt.getTelefono(), celda);
                        wsheet.addCell(label);
                        label = new Label(12, fila, beanAnt.getTutor_nombre() + " " + beanAnt.getTutor_apPaterno() + " " + beanAnt.getTutor_apMaterno(), celda);
                        wsheet.addCell(label);
                        label = new Label(13, fila, beanAnt.getCorreo(), celda);
                        wsheet.addCell(label);

                        fila++;
                        count++;
                    }
                    wworkbook.write();
                    wworkbook.close();
                } catch (IOException ex) {
                    ex.getMessage();
                }

                File fileToDownload = new File(dirUploadFiles);
                FileInputStream fileInputStream = new FileInputStream(fileToDownload);

                ServletOutputStream out = response.getOutputStream();
                String mimeType = new MimetypesFileTypeMap().getContentType(dirUploadFiles);

                response.setContentType(mimeType);
                response.setContentLength(fileInputStream.available());
                response.setHeader("Content-Disposition", "attachment; filename=\""
                        + fileToDownload.getName() + "\"");

                int c;
                while ((c = fileInputStream.read()) != -1) {
                    out.write(c);
                }

                out.flush();
                out.close();
                fileInputStream.close();
                break;
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
            Logger.getLogger(ServletArchivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (WriteException ex) {
            Logger.getLogger(ServletArchivo.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServletArchivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (WriteException ex) {
            Logger.getLogger(ServletArchivo.class.getName()).log(Level.SEVERE, null, ex);
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
