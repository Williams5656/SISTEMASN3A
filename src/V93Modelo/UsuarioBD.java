package V93Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class UsuarioBD extends UsuarioMb {

    Conectar conectar = new Conectar();

    public UsuarioBD() {
    }

    public UsuarioBD(String codigo, String cedula, String nombre_usuario, String clave, String codigo_rol, String estado, String correo) {
        super(codigo, cedula, nombre_usuario, clave, codigo_rol, estado, correo);
    }

    public List<UsuarioMb> mostrardatos() {
        try {
            List<UsuarioMb> lista = new ArrayList<UsuarioMb>();
            String sql = "select codigou, usuario, clave, estadou, correo, cedula, rol, r.cargo "
                    + "from usuario "
                    + "inner join rol r "
                    + "on rol = r.codigo ";

//          String sql = "select * from usuario";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                UsuarioMb usua = new UsuarioMb();
                usua.setCodigo(rs.getString("codigou"));
                usua.setUsuario(rs.getString("usuario"));
                usua.setClave(rs.getString("clave"));
                usua.setEstado(rs.getString("estadou"));
                usua.setCorreo(rs.getString("correo"));
                usua.setCedula(rs.getString("cedula"));
                usua.setCodigo_rol(rs.getString("cargo"));

                lista.add(usua);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(UsuarioBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
 public List<UsuarioMb> mostrarUsuario() {
        
        try {
            List<UsuarioMb> lista = new ArrayList<UsuarioMb>();
            String sql = "select * from usuario";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                UsuarioMb usuario = new UsuarioMb();
                
                usuario.setCodigo(rs.getString("codigou"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setClave(rs.getString("clave"));
                usuario.setEstado(rs.getString("estadou"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setCedula(rs.getString("cedula"));
                usuario.setCodigo_rol(rs.getString("cargo"));
                lista.add(usuario);
            }
            
            rs.close();
            return lista;
        }
        catch (SQLException e) {
            Logger.getLogger(UsuarioBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
    public boolean insertar() {
          
        String sql = "INSERT INTO usuario(codigou, usuario, clave, estadou, correo, cedula, rol)" + 
                "VALUES ('" + 
                getCodigo() + "','" + 
                getUsuario() + "','" + 
                getClave()+ "','" + 
                getEstado() + "','" + 
                getCorreo() + "','" +
                getCedula() + "','" + 
                getCodigo_rol()+ "');" +
                "Update usuario set rol = ( Select r.codigo " +
                                           "from rol r " +
                                           "inner join usuario u " +
                                           "on u.rol = r.cargo " +
                                           "where rol = '" + getCodigo_rol()+ "') " +
                                            "where cedula = '"+getCedula()+"';";

        if (conectar.noQuery(sql) == null) {
            return true;
        } 
        else {
            JOptionPane.showMessageDialog(null, "Error");
            return false;
        }
    }//Fin del insertar
    
       
    public UsuarioMb validar(String User, String Pass) throws SQLException {
        PreparedStatement st;
        ResultSet rs;
        Connection con;
        UsuarioMb usua = new UsuarioMb();
        String validar = "select * from usuario " + " where usuario.usuario = ? and usuario.clave = ? ; ";
        
        try {
            con = conectar.getCon();

            st = con.prepareStatement(validar);
            st.setString(1, User);
            st.setString(2, Pass);
            rs = st.executeQuery();

            while (rs.next()) {
     
                usua.setCodigo(rs.getString("codigou"));
                usua.setUsuario(rs.getString("usuario"));
                usua.setClave(rs.getString("clave"));
                usua.setEstado(rs.getString("estadou"));
                usua.setCorreo(rs.getString("correo"));
                usua.setCedula(rs.getString("cedula"));
                usua.setCodigo_rol(rs.getString("rol"));

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString(), null, JOptionPane.ERROR_MESSAGE);
        }
        return usua;
    }

    public boolean modificar(String codigo) {
            String sql = "update usuario set " +
                    
                    "codigou = '" + getCodigo()+ "', " +
                    "usuario = '" + getUsuario() + "', " +
                    "clave = '" + getClave() + "', " +
                    "estadou = '" + getEstado()+ "', " +
                    "correo = '" + getCorreo()+ "', " +
                    "cedula = '" + getCedula()+ "', " +
                    "rol = '" + getCodigo_rol()+ "' " +
                    "where codigou = '" + codigo + "';" +
                    
                     "Update usuario set rol = ( Select r.codigo " +
                                           "from rol r " +
                                           "inner join usuario u " +
                                           "on u.rol = r.cargo " +
                                           "where rol = '" + getCodigo_rol()+ "') " +
                                            "where cedula = '"+getCedula()+"';";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("error al editar");

            return false;
        }

    }

    public List<UsuarioMb> obtenerdatos(String codigou) {
        try {
            List<UsuarioMb> lista = new ArrayList<UsuarioMb>();
            String sql = "select codigou, usuario, clave, estadou, correo, cedula, rol, r.cargo "
                    + "from usuario "
                    + "inner join rol r "
                    + "on rol = r.codigo "
                    + "where codigou = '"+
                    codigou + "'";

            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                UsuarioMb usua = new UsuarioMb();
                usua.setCodigo(rs.getString("codigou"));
                usua.setUsuario(rs.getString("usuario"));
                usua.setClave(rs.getString("clave"));
                usua.setEstado(rs.getString("estadou"));
                usua.setCorreo(rs.getString("correo"));
                usua.setCedula(rs.getString("cedula"));
                usua.setCodigo_rol(rs.getString("cargo"));

                lista.add(usua);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(UsuarioBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
 public DefaultComboBoxModel rol(){
        DefaultComboBoxModel listaRol = new DefaultComboBoxModel();
        listaRol.addElement("Seleccionar");
        ResultSet rs = conectar.query("Select * from rol order by cargo");
        try{
            while (rs.next()){
                listaRol.addElement(rs.getString("cargo"));
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return listaRol;
    }
 
public DefaultComboBoxModel cedula(){
        DefaultComboBoxModel listaCedula = new DefaultComboBoxModel();
        listaCedula.addElement("Seleccionar");
        ResultSet rs = conectar.query("Select * from persona order by cedula");
        try{
            while (rs.next()){
                listaCedula.addElement(rs.getString("cedula") + "  " + (rs.getString("nombre")));
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return listaCedula;
    }

 public boolean eliminar(String codigo) {
        String sql = "delete from usuario where \"codigou\"='" + codigo + "'";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            System.out.println("error al eliminar");
            return false;
        }

    } 
  public List<UsuarioMb> BuscarUsuario(String cedula) {
        try {
            List<UsuarioMb> lista = new ArrayList<UsuarioMb>(); 
             String sql = "select codigou, usuario, clave, estadou, correo, cedula, rol, r.cargo "
                    + "from usuario "
                    + "inner join rol r "
                    + "on rol = r.codigo "
                     + "where \"cedula\" ILIKE '%" + cedula + "%'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                UsuarioMb usuario = new UsuarioMb();
                
                usuario.setCodigo(rs.getString("codigou"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setClave(rs.getString("clave"));
                usuario.setEstado(rs.getString("estadou"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setCedula(rs.getString("cedula"));
                usuario.setCodigo_rol(rs.getString("cargo"));
                lista.add(usuario);
            }
            
            rs.close();
            return lista;
        }
        catch (SQLException e) {
            Logger.getLogger(UsuarioBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
}
