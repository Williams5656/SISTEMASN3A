package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conectar {

    Connection con;
    Statement st;
    ResultSet rs;
    String cadConexion = "jdbc:postgresql://ec2-3-223-242-224.compute-1.amazonaws.com:5432/ddsq9uv4eadsel";
    String pgUser = "cqadrwqunakukl";
    String pgContra = "95ed0f99d0ba47c2ab7856ec93518bf920b684db97f21a984c10d90e0e29a38b";

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
            JOptionPane.showMessageDialog(null, "ERROR: "+ex.toString());
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
