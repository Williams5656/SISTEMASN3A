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
    String cadConexion = "jdbc:postgresql://ec2-34-235-198-25.compute-1.amazonaws.com:5432/d45ligre8e7fsc";
    String pgUser = "dquqngtvulsesk";
    String pgContra = "380ac9f289b0370be936d6863c3111281408119549daf93ff6b4268f7e423f74";
       
    public Conexion() {

        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Se Cargo Driver.");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
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
