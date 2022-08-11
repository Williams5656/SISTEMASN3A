package ABG_System.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ABG_System.vista.*;

public class UsuarioBD {

    PreparedStatement st;
    ResultSet rs;
    Connection con;
    Conectar conectar = new Conectar();

    public UsuarioMD validar(String User, String Pass) throws SQLException {
        UsuarioMD us = new UsuarioMD();
        String validar = "	Select * From login\n"
                + "where login.usuario=? and login.clave=?;";
        try {
            con = conectar.getCon();
            st = con.prepareStatement(validar);
            st.setString(1, User);
            st.setString(2, Pass);
            rs = st.executeQuery();
            while (rs.next()) {
                us.setUsuario(rs.getString(1));
                us.setClave(rs.getString(2));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString(), null, JOptionPane.ERROR_MESSAGE);
        }
        return us;
    }
}
