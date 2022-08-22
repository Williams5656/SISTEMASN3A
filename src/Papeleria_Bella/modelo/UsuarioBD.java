
package Papeleria_Bella.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;


public class UsuarioBD {
    
    Conexion conectar = new Conexion();
      public DefaultComboBoxModel ROL(){
        DefaultComboBoxModel listarol=new DefaultComboBoxModel();
        ResultSet rs= conectar.query("Select * from rol order by nombre");
        try {
            while (rs.next()) {
                listarol.addElement(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return listarol;
    }
}
