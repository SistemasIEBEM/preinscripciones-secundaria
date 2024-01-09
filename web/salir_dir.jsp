<%-- 
    Document   : salir_dir
    Created on : 9/01/2017, 01:28:39 PM
    Author     : Registro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" session="true" %>

<!DOCTYPE html>
<%
 HttpSession sesion = request.getSession();
sesion.setAttribute("usuario"," ");
            sesion.invalidate();
            response.sendRedirect("logindir.jsp");
            %>
