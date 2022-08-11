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

public class UsuarioBD extends PersonaBD {

    PreparedStatement st;
    ResultSet rs;
    Connection con;
    Conectar conectar = new Conectar();

    public List<PersonaBD> mostrardatos() {
        try {
            List<PersonaBD> lista = new ArrayList<PersonaBD>();
            String sql = "select * from persona";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                PersonaBD p = new PersonaBD();
                p.setCedula(rs.getString("cedula"));
                p.setNombres(rs.getString("nombre"));
                p.setApellidos(rs.getString("apellido"));
                p.setUsuario(rs.getString("usuario"));
                p.setClave(rs.getString("clave"));
                p.setDireccion(rs.getString("direccion"));
                p.setTelefono(rs.getString("telefono"));
                p.setCorreoElectronico(rs.getString("correo_electronico"));
                p.setRol(rs.getString("rol"));

                lista.add(p);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(UsuarioBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean insertar() {
        String sql = "INSERT INTO persona(cedula,nombre,apellido,usuario,clave,direccion,telefono,correo_electronico,rol)" + "VALUES ('" + getCedula() + "','" + getNombres() + "','" + getApellidos() + "','" + getUsuario() + "','" + getClave() + "','" + getDireccion() + "','" + getTelefono() + "','" + getCorreoElectronico() + getRol() + "')";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }
    }

    public boolean modificar(String cedula) {
        String sql = "update persona set \"nombre\"='" + getNombres() + "',\"apellido\"='" + getApellidos() + "',\"usuario\"='" + getUsuario() + "',\"clave\"='" + getClave() + "',\"direccion\"='" + getDireccion() + "',\"telefono\"='" + getDireccion() + "',\"telefono\"='" + getTelefono() + "',\"correo_electronico\"='" + getCorreoElectronico() + "',\"rol\"='" + getRol() + "'"
                + "where \"cedula\"='" + cedula + "'";
        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("ERROR AL MOMENTO DE EDITAR");
            System.out.println("INTENTE OTRA VEZ");

            return false;
        }
    }

    public List<PersonaBD> obtenerdatos(String cedula) {
        try {
            List<PersonaBD> lista = new ArrayList<PersonaBD>();
            String sql = "select * from persona where \"cedula\"='" + cedula + "'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                PersonaBD p = new PersonaBD();
                p.setCedula(rs.getString("cedula"));
                p.setNombres(rs.getString("nombre"));
                p.setApellidos(rs.getString("apellido"));
                p.setUsuario(rs.getString("usuario"));
                p.setClave(rs.getString("clave"));
                p.setDireccion(rs.getString("direccion"));
                p.setTelefono(rs.getString("telefono"));
                p.setCorreoElectronico(rs.getString("correo_electronico"));
                p.setRol(rs.getString("rol"));

                lista.add(p);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(UsuarioBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean eliminar(String cedula) {
        String nsql = "delete from persona where \"cedula\"='" + cedula + "'";
        if (conectar.noQuery(nsql) == null) {
            return true;

        } else {
            System.out.println("ERROR");
            System.out.println("NO SE PUDO ELIMINAR");
            return false;
        }
    }
     public PersonaBD validar(String User, String Pass) throws SQLException {
        PersonaBD us = new PersonaBD();
        String validar = "	Select * From persona\n"
                + "where persona.usuario=? and persona.clave=?;";
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
