package V93Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class Conectar {
      
    Connection con;
    Statement st;
    ResultSet rs;
 
    String cadConexion = "jdbc:postgresql://localhost:5432/V93";
    String pgUser = "postgres";
    String pgContra = "Josue2018.";
    // String cadConexion = "jdbc:postgresql://ec2-3-223-169-166.compute-1.amazonaws.com:5432/d9sf9n4bar9r8o";
    // String pgUser = "uvihzcapdjbpzo";
    // String pgContra = "9f025f115f8c021b6567c6aa2102d40b042212571b0f0e1a8883be057d91ab71";
    //Conexion a heroku
//    Connection con;
//    Statement st;
//    ResultSet rs;
//    String cadConexion="jdbc:postgresql://ec2-44-199-52-133.compute-1.amazonaws.com:5432/dc3k5f62r653lp";
//    String pgUser="znfnqjrnxvbgqe";
//    String pgContra="f48f4656ce162f56bdc4ed25c0384bcff30056bece5403fd038aa4b60f84c75e";

    public Conectar() {

        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Se Cargo Driver.");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            con = DriverManager.getConnection(cadConexion, pgUser, pgContra);
            System.out.println("Se conecto DB.");
        } catch (SQLException ex) {
            Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, null, ex);
            return ex;
        }
    }

    public ResultSet query(String sql) {
        System.out.println(sql);
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            //  st.close();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
