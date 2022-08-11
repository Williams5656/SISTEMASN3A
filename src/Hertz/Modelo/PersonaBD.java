
package Hertz.Modelo;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import javax.swing.JOptionPane;

public class PersonaBD extends PersonaMD{
    Conect conectar = new Conect();

    public PersonaBD() {
    }

    public PersonaBD(String cedula, String nombre, String direccion, String celular, String email, String fechanac) {
        super(cedula, nombre, direccion, celular, email, fechanac);
    }
    
    public List<PersonaMD> mostrardatos() {
        
        try {
            List<PersonaMD> lista = new ArrayList<PersonaMD>();
            String sql = "select * from persona";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                
                PersonaMD persona = new PersonaMD();
                persona.setCedula(rs.getString("cedula"));
                persona.setNombre(rs.getString("nombre"));
                persona.setDireccion(rs.getString("direccion"));
                persona.setCelular(rs.getString("celular"));
                persona.setEmail(rs.getString("email"));
                persona.setFechaNac(rs.getString("fechaNac"));
                lista.add(persona);
                
            }
            
            rs.close();
            return lista;
        }
        catch (SQLException e) {
            Logger.getLogger(PersonaBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }//Fin mostrar datos
    
    public boolean insertar() {
        String sql = "INSERT INTO persona(cedula, nombre, direccion, celular, email, fechaNac)" + 
                "VALUES ('" + 
                getCedula() + "','" + 
                getNombre().toUpperCase() + "','" + 
                getDireccion().toUpperCase() + "','" + 
                getCelular() + "','" + 
                getEmail().toLowerCase() + "','" + 
                getFechaNac()+ "')"; 

        if (conectar.noQuery(sql) == null) {
            return true;
        } 
        else {
            
            JOptionPane.showMessageDialog(null, "ERROR");
            return false;
        }
    }//Fin de insertar
    
    public List<PersonaMD> obtenerDatos(String cedula) {
        
        try {
            List<PersonaMD> lista = new ArrayList<PersonaMD>();
            String sql = 
                    "select * from persona " + 
                    "where cedula = '" + cedula + "'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                PersonaMD persona = new PersonaMD();
                persona.setCedula(rs.getString("cedula"));
                persona.setNombre(rs.getString("nombre"));
                persona.setDireccion(rs.getString("direccion"));
                persona.setCelular(rs.getString("celular"));
                persona.setEmail(rs.getString("email"));
                persona.setFechaNac(rs.getString("fechaNac"));
                lista.add(persona);
            }
            
            rs.close();
            return lista;
        }
        catch (SQLException e) {
            Logger.getLogger(PersonaBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }//Fin de obtener datos
    
}
