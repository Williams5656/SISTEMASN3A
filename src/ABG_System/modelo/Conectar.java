package ABG_System.modelo;

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
    String cadConexion = "jdbc:postgresql://ec2-44-206-197-71.compute-1.amazonaws.com:5432/dbd9hual32u4o0";
    String pgUser = "fsygculwvndeqe";
    String pgContra = "09c645210e86376b5043e05aa7d8288084eefa7cce4e745f0c4c7e7ccc4ac6c1";

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
}
