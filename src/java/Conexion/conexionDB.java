/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author David Costet
 */
public class conexionDB {
    public static Connection GetConnection() throws ClassNotFoundException
    {
        Connection conexion=null;
      
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            String url = "jdbc:sqlserver://172.16.20.35;databaseName=preinscripciones_sec2024;user=sa;password=morelospre*1256;";
            //String url = "jdbc:sqlserver://187.174.218.229:1436;databaseName=preinscripciones_sec2023;user=sa;password=morelospre*1256;";
            String url = "jdbc:sqlserver://172.16.20.35;databaseName=dbtest_preins_sec;user=sa;password=morelospre*1256;";
            conexion= DriverManager.getConnection(url);
        }
        catch(SQLException exc){
              System.out.println(exc.getMessage());
        
    }
     return conexion;
 }
    
}
