package V93Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteBD extends ClienteMb {

    Conectar conecta = new Conectar();

    public ClienteBD() {
    }

    public ClienteBD(String cedula, String nombre, String ciudad, String direccion, String telefono, String correo) {
        super(cedula, nombre, ciudad, direccion, telefono, correo);
    }

    public List<ClienteMb> mostrardatos() {
        try {
            List<ClienteMb> listacliente = new ArrayList<ClienteMb>();
            String sql = "select * from cliente";
            ResultSet rs = conecta.query(sql);
            while (rs.next()) {
                ClienteMb u = new ClienteMb();
                u.setCedula(rs.getString("cedula"));
                u.setNombre(rs.getString("nombre"));
                u.setCiudad(rs.getString("ciudad"));
                u.setDireccion(rs.getString("direccion"));
                u.setTelefono(rs.getString("telefono"));
                u.setCorreo(rs.getString("correo"));

                listacliente.add(u);
            }
            rs.close();
            return listacliente;
        } catch (SQLException e) {
            Logger.getLogger(ClienteBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean insertar() {
        String sql = "INSERT INTO cliente (cedula, nombre, ciudad, direccion, telefono, correo)  VALUES ('" + getCedula() + "','" + getNombre() + "','" + getCiudad() + "','" + getDireccion() + "','" + getTelefono() + "','" + getCorreo() + "')";

        if (conecta.noQuery(sql) == null) {
            return true;
        } else {

            System.out.println("Error");
            return false;
        }

    }

    public List<ClienteMb> obtenerdatos(String cedula) {
        try {
            List<ClienteMb> lista = new ArrayList<ClienteMb>();
            String sql = "select * from cliente " + " where \"cedula\" ILIKE '%" + cedula + "%'";
            ResultSet rs = conecta.query(sql);
            while (rs.next()) {
                ClienteMb m = new ClienteMb();
                m.setCedula(rs.getString("cedula"));
                m.setNombre(rs.getString("nombre"));
                m.setCiudad(rs.getString("ciudad"));
                m.setDireccion(rs.getString("direccion"));
                m.setTelefono(rs.getString("telefono"));
                m.setCorreo(rs.getString("correo"));

                lista.add(m);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(ClienteBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public boolean modificar(String cedula) {

        String sql = "update cliente set \"nombre\"='" + getNombre() + "',\"ciudad\"='" + getCiudad() + "',\"direccion\"='" + getDireccion() + "',\"telefono\"='" + getTelefono() + "',\"correo\"='" + getCorreo() + "'"
                + " where \"cedula\"='" + cedula + "'";

        if (conecta.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("error al editar");

            return false;
        }

    }

    public boolean eliminar(String cedula) {
        String sql = "delete FROM cliente where\"cedula\"='" + cedula + "'";
        if (conecta.noQuery(sql) == null) {
            return true;

        } else {
            System.out.println("error al eliminar");
            return false;
        }

    }
}
