
package Hertz.Controlador;

import Hertz.Modelo.*;
import Hertz.Vista.*;
import Hertz.Controlador.*;
import java.awt.Frame;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CInicio {
    
    public static VInicio vista;
    
    public CInicio(VInicio vista) {
        this.vista = vista;
        vista.setVisible(true);
        //vista.setLocationRelativeTo(null);
        //vista.setExtendedState(Frame.MAXIMIZED_BOTH);
    
    //-----------------------   MOSTRAR VENTANAS   -----------------------------
    
        vista.getBtnIngresar().addActionListener(e -> { 
        try {
            ingresar();
        } catch(SQLException ex){
            Logger.getLogger(CInicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        });
    }
    
    private void ingresar() throws SQLException {
        UsuarioBD bdusuario = new UsuarioBD();
        List<UsuarioMD> lista = bdusuario.mostrardatos();
        RolBD rolEstado = new RolBD();
        List<RolMD> listaRoles = rolEstado.mostrardatos();
        int a = 0;
        for (int i = 0; i < lista.size(); i++){
            int id_rol = lista.get(i).getCodigo();
            String estadoRol = listaRoles.get(id_rol).getEstado();
            
            if(vista.getTxtUsuario().getText().equals(lista.get(i).getUsuario()) && 
                    vista.getTxtPassword().getText().equals(lista.get(i).getPassword()) && 
                    lista.get(i).getEstado().equals("Activo") && 
                    estadoRol.equals("Activo")){                
                VPrincipal vmenu = new VPrincipal();
                CPrincipal menu = new CPrincipal(vmenu);
                vista.setVisible(false);
                vmenu.setVisible(true);
                a = 1;
                
            } else {
                if(lista.get(i).getEstado().equals("Inactivo")){
                    JOptionPane.showMessageDialog(null, "USUARIO BLOQUEADO");
                    a=1;
                } else if (estadoRol.equals("Inactio")){
                    JOptionPane.showMessageDialog(null, "ROL BLOQUEADO");
                    a=1;
                }
            }
            
        } while (a == 0)
        {
            JOptionPane.showMessageDialog(null, "CREDENCIALES INCORRECTAS");
            a = 1;
        }
    }
}
