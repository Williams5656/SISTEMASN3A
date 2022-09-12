 package Papeleria_Bella.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
//ggggg
public class Conexion {
  
    Connection con;
    Statement st;
    ResultSet rs;
    String cadConexion = "jdbc:postgresql://ec2-54-152-28-9.compute-1.amazonaws.com:5432/dbgvefkq7b6l4t";
    String pgUser = "alsappqypndnbd";
    String pgContra = "f62c8aa6efbd5e25954bcdc0d13b83da1479594c9fd9eb4e9724591890e8ad4a";
       
    public Conexion() {

        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Se Cargo Driver.");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            //Esto es una prueba
        }
 
        try {
            con = DriverManager.getConnection(cadConexion, pgUser, pgContra);
            System.out.println("Se conecto DB.");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }  

    public SQLException noQuery(String nsql) {
        System.out.println(nsql);
        try {
            st = con.createStatement();
            st.execute(nsql);
            st.close();
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return ex;
        }
    }

    public  ResultSet query(String sql) {
        System.out.println(sql);
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            //  st.close();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public Connection getCon() {
        return con;
    }
 
    public void setCon(Connection con) {
        this.con = con;
    }
}
