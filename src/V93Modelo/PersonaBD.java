package V93Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonaBD extends PersonaMb {

    Conectar conecta = new Conectar();

    public PersonaBD() {
    }

    public PersonaBD(String cedula, String nombre, String direccion, String fecha_nacimiento, String ciudad, String celular) {
        super(cedula, nombre, direccion, fecha_nacimiento, ciudad, celular);
    }

    public List<PersonaMb> mostrardatos() {
        try {
            List<PersonaMb> listausuario = new ArrayList<PersonaMb>();
            String sql = "select * from persona";
            ResultSet rs = conecta.query(sql);
            while (rs.next()) {
                PersonaMb u = new PersonaMb();
                u.setCedula(rs.getString("cedula"));
                u.setNombre(rs.getString("nombre"));
                u.setDireccion(rs.getString("direccion"));
                u.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
                u.setCiudad(rs.getString("ciudad"));
                u.setCelular(rs.getString("celular"));

                listausuario.add(u);
            }
            rs.close();
            return listausuario;
        } catch (SQLException e) {
            Logger.getLogger(PersonaBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean insertar() {
        String sql = "INSERT INTO persona (cedula, nombre, direccion, fecha_nacimiento, ciudad, celular)  VALUES ('" + getCedula() + "','" + getNombre() + "','"  + getDireccion() + "','" + getFecha_nacimiento() + "','" + getCiudad()+"','" + getCelular() + "')";

        if (conecta.noQuery(sql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }

    }

    public List<PersonaMb> obtenerdatos(String cedula) {
        try {
            List<PersonaMb> lista = new ArrayList<PersonaMb>();
            String sql = "select * from persona " + " where \"cedula\"='" + cedula + "'";
            ResultSet rs = conecta.query(sql);
            while (rs.next()) {
                PersonaMb m = new PersonaMb();
                m.setCedula(rs.getString("cedula"));
                m.setNombre(rs.getString("nombre"));
                m.setDireccion(rs.getString("direccion"));
                m.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
                m.setCiudad(rs.getString("ciudad"));
                m.setCelular(rs.getString("celular"));
                
                lista.add(m);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(PersonaBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    
    
    public boolean modificar(String cedula) {
        String sql = "update persona set \"nombre\"='" + getNombre() + "',\"direccion\"='" + getDireccion() + "',\"fecha_nacimiento\"='" + getFecha_nacimiento() + "',\"ciudad\"='" + getCiudad() + "',\"celular\"='" + getCelular() + "'"
                + " where \"cedula\"='" + cedula + "'";

        if (conecta.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("error al editar");

            return false;
        }

    }

    public boolean eliminar(String cedula) {
        String sql = "delete FROM persona where\"cedula\"='" + cedula + "'";
        if (conecta.noQuery(sql) == null) {
            return true;

        } else {
            System.out.println("error al eliminar");
            return false;
        }

    }

}
