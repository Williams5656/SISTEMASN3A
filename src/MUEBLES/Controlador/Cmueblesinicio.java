package MUEBLES.Controlador;

/**
 *
 * @author HP i5
 */
import MUEBLES.Modelo.*;
import MUEBLES.Vista.*;
import java.awt.Dimension;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cmueblesinicio {
    public static Minicio vistaini;
    
    public Cmueblesinicio(Minicio vistaini) {
        this.vistaini = vistaini;
        vistaini.setVisible(true);
        vistaini.setLocationRelativeTo(null);
        vistaini.setResizable(false);
        
        vistaini.getBtncancelar_inicio().addActionListener(e -> salir());
        //vistaini.getBtnloguear_inicio().addActionListener(e -> ingreso());
        
        vistaini.getBtnloguear_inicio().addActionListener(e -> { 
        try {
            ingresar();
        } catch(SQLException ex){
            Logger.getLogger(Cmueblesinicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        });
    }
    
    private void salir() {
        System.exit(0);
    }
    
    private void ingreso(){
        Vista_muebles_principal vista = new Vista_muebles_principal();
        Cmueblesprincipal cprin = new Cmueblesprincipal(vista);
        vistaini.dispose();
    }
    
    private void ingresar() throws SQLException {
        Usuario_BD bdusuario = new Usuario_BD();
        List<M_usuario_MD> lista = bdusuario.mostrardatos();
        rol_BD rolEstado = new rol_BD();
        List<M_rolMD> listaRoles = rolEstado.mostrardatos();
        int a = 0;
        for (int i = 0; i < lista.size(); i++){
            String rol = lista.get(i).getCodigo();
            String estadoRol = listaRoles.get(i).getEstado();
            
            if(vistaini.getTxtusuario_inicio().getText().equals(lista.get(i).getUsuario()) && 
                    vistaini.getTxtContrasenia_inicio().getText().equals(lista.get(i).getContrasena()) && 
                    lista.get(i).getEstado().equals("Activo") && 
                    estadoRol.equals("Activo")){                
                Minicio vmenu = new Minicio();
                Cmueblesinicio menu = new Cmueblesinicio(vmenu);
                vistaini.setVisible(false);
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
