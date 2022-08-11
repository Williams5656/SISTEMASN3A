
package Papeleria_Bella.modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonaBD extends PersonaMD{

    Conect conectar = new Conect();
    public PersonaBD() {
    }

    public PersonaBD(String cedula, String nombres, String apellidos, String telefono, String direccion, String email, String rol) {
        super(cedula, nombres, apellidos, telefono, direccion, email, rol);
    }
    
    public List<PersonaMD> mostrardatos() {
        try {
            List<PersonaMD> lista = new ArrayList<PersonaMD>();
            String sql = "select * from persona";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                PersonaMD u = new PersonaMD();
                u.setCedula(rs.getString("cedula"));
                u.setNombres(rs.getString("nombres"));
                u.setApellidos(rs.getString("apellidos"));
                u.setTelefono(rs.getString("telefono"));
                u.setDireccion(rs.getString("direccion"));
                u.setEmail(rs.getString("email"));
                u.setRol(rs.getString("rol"));
                
                lista.add(u);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(PersonaMD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    public boolean insertar() {
        String sql = "INSERT INTO persona(cedula,nombres,apellidos,telefono,direccion,email,rol)" + "VALUES ('" + getCedula()+ "','" + getNombres()+ "','" + getApellidos()+ "','" + getTelefono()+ "','" + getDireccion()+ "','" + getEmail()+ "','" + getRol()+ "')";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }

    }
}
