<%-- 
    Document   : salir
    Created on : 5/01/2017, 09:56:21 PM
    Author     : david
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" session="true" %>
 
<%
 HttpSession sesion = request.getSession();
sesion.setAttribute("usuario"," ");
            sesion.invalidate();
            response.sendRedirect("loginadmin.jsp");
            %>
