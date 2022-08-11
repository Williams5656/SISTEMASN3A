package MUEBLES.Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Persona_BD_muebles extends M_muebles_persona{
    Conect conectar = new Conect();

    public Persona_BD_muebles(String cedula, String nombre, String apellido, String direccion, String celular, String nacionalidad, String fechana) {
        super(cedula, nombre, apellido, direccion, celular, nacionalidad, fechana);
    }

    public Persona_BD_muebles() {
    }
    
    public List<M_muebles_persona> mostrardatos() {
        try {
            List<M_muebles_persona> lista = new ArrayList<M_muebles_persona>();
            String sql = "select * from cliente";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                M_muebles_persona m = new M_muebles_persona();
                m.setCedula(rs.getString("cedula"));
                m.setNombre(rs.getString("nombres"));
                m.setCelular(rs.getString("apellidos"));
                m.setCelular(rs.getString("direccion"));
                m.setCelular(rs.getString("celular"));
                m.setCelular(rs.getString("nacionalidad"));
                m.setCelular(rs.getString("fnacimiento"));

                lista.add(m);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(M_muebles_persona.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
    public boolean insert() {
        String sql = "insert into persona(cedula, nombres, apellidos, direccion, celular, nacionalidad, fnacimiento)" + "values ('" + getCedula()+ "','" + getNombre() + "','" + getApellido()+ "','" + getDireccion()+ "','" + getCelular()+ "','" + getNacionalidad()+ "','" + getFechana()+ "')";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {

            JOptionPane.showMessageDialog(null, "¡ Falla al insertar !");
            return false;
        }
    }
}
