 
package Papeleria_Bella.controlador;
import Papeleria_Bella.controlador.*;
import Papeleria_Bella.vista.*;
import Papeleria_Bella.modelo.*;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
public class Cprincipal {
    public static Vprincipal vista;
    String tUsuario = "usuario:";
    String pClave = "clave:";
    UsuarioBD lg = new UsuarioBD();
    UsuarioMD us = new UsuarioMD();
    int bloqueo = 3;
    int a = 0;
    boolean mostrar;
    
    public Cprincipal(Vprincipal vista) {
        this.vista=vista;
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.setExtendedState(MAXIMIZED_BOTH);
        vista.getItempersona().addActionListener(e-> persona ());
        vista.getItemusuario().addActionListener(e-> usuario());
        vista.getItemroles().addActionListener(e-> roles());

    }
    /*public void validar() throws SQLException {
        RolBD brol = new RolBD();
        String estado = "";
        List<RolMD> listarol = brol.buscardatosporcodigo(us.getRol());
        for (int i = 0; i < listarol.size(); i++) {
            estado = listarol.get(i).getEstado();
        }
        String usuario = vista.getTxtusuario().getText();
        String clave = vista.getFi().getText();
        if (vista.getTxtUsuario().getText().equals("") || String.valueOf(vista.getjPassClave().getPassword()).equals("")) {
            JOptionPane.showMessageDialog(null, "LLene todos los campos", null, JOptionPane.ERROR_MESSAGE);
        } else {
            us = lg.validar(usuario, clave);
            if (us.getEstado().equals("Inactivo")) {
                JOptionPane.showMessageDialog(null, "Usted es un usuario Inactivo \n Contactese con su administrador", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                if (estado.equals("Incativo")) {
                    JOptionPane.showMessageDialog(null, "Ha intentado entrar con un rol inactivo \n Contactese con su administrador", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {

                    if (us.getUsuario() != null && us.getClave() != null) {
                        V_Principal vistap = new V_Principal();
                        C_Principal Inicio = new C_Principal(vistap);
                        vista.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario o Contraseña Incorrectos", null, JOptionPane.ERROR_MESSAGE);
                        JOptionPane.showMessageDialog(null, "Intentos Permitidos: " + bloqueo, null, JOptionPane.WARNING_MESSAGE);
                        vista.getTxtUsuario().requestFocus();
                        vista.getTxtUsuario().setText("");
                        vista.getjPassClave().setText("");
                        bloqueo = bloqueo - 1;
                    }
                }
            }
        }
        if (bloqueo == -1) {
            JOptionPane.showMessageDialog(null, "Usted a agotado sus intentos", "Seguridad del Sistema", JOptionPane.OK_OPTION);
            System.exit(0);
        }
    }*/
            
         
    private void persona() {
        Vpersona1 p= new Vpersona1();
        Cpersona cper=new Cpersona(p);
    }
    private void usuario() {
        Vusuario vus= new Vusuario();
        Cusuario cuser=new Cusuario(vus);
    }

    private void roles() {
        Vrol p= new Vrol();
        Crol cper=new Crol(p);
    }
   
}
