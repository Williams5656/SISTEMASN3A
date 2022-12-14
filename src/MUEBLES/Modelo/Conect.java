package MUEBLES.Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conect {
    Connection con;
    Statement st;
    ResultSet rs;
    String cadConexion="jdbc:postgresql://ec2-54-161-255-125.compute-1.amazonaws.com:5432/d7i9e3273467s0";
    String pgUser="jzkxzgumseewmx";
    String pgContra="74fd11d0b64a55c3b944d7f91f2db15bdd1aaa5a0264ae1db804aa13057ce015";
//    Connection con;
//    Statement st;
//    ResultSet rs;
//    String cadConexion="jdbc:postgresql://ec2-44-199-52-133.compute-1.amazonaws.com:5432/dc3k5f62r653lp";
//    String pgUser="znfnqjrnxvbgqe";
//    String pgContra="f48f4656ce162f56bdc4ed25c0384bcff30056bece5403fd038aa4b60f84c75e";
//    
    
     public Conect() {
        
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Se Cargo Driver.");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            con=DriverManager.getConnection(cadConexion,pgUser,pgContra);
            System.out.println("Se conecto DB.");
        } catch (SQLException ex) {
            Logger.getLogger(Conect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public SQLException noQuery(String nsql){
        System.out.println(nsql);
        try {
            st=con.createStatement();
            st.execute(nsql);
            st.close();
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(Conect.class.getName()).log(Level.SEVERE, null, ex);
            return ex;
        }
    }
    
    public ResultSet query(String sql){
        System.out.println(sql);
        try {
            st=con.createStatement();
            ResultSet rs = st.executeQuery(sql);
          //  st.close();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Conect.class.getName()).log(Level.SEVERE, null, ex);
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
