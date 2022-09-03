package V93Controlador;

import V93Vista.*;
import V93Modelo.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CLogin {

    UsuarioBD lg = new UsuarioBD();
    UsuarioMb us = new UsuarioMb();
    int bloqueo = 3;
    int a = 0;
    boolean mostrar;
    public static VistaLogin VistaL;
    private LoginBD bdpersona = new LoginBD();

    public CLogin(VistaLogin VistaL) {

        CLogin.VistaL = VistaL;
        VistaL.setVisible(true);
        VistaL.setLocationRelativeTo(null);
//        VistaL.getLabelOcultar().setVisible(false);
//        VistaL.getBtn_Cerrar().setVisible(false);
//        VistaL.getTxtClave().setVisible(false)
//       vista.getBtn_Ingresar().addActionListener(x -> {
        VistaL.getBtnIniciarLogin().addActionListener(x -> {
            try {
                validar();
            } catch (SQLException ex) {
                Logger.getLogger(CLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    public void validar() throws SQLException {

        String usuario = VistaL.getTxtCedulaLogin().getText();
        String clave = VistaL.getPasswordLogin().getText();
        if (VistaL.getTxtCedulaLogin().getText().equals("") || String.valueOf(VistaL.getPasswordLogin().getPassword()).equals("")) {
            JOptionPane.showMessageDialog(null, "LLene todos los campos", null, JOptionPane.ERROR_MESSAGE);
        } else {
            us = lg.validar(usuario, clave);
                if (us.getUsuario()!= null && us.getClave() != null) {
                    VistaPrincipal vistap = new VistaPrincipal();
                    Cprincipal Inicio = new Cprincipal(vistap);
                    VistaL.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o Contraseña Incorrectos", null, JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(null, "Intentos Permitidos: " + bloqueo, null, JOptionPane.WARNING_MESSAGE);
                    VistaL.getTxtCedulaLogin().requestFocus();
                    VistaL.getTxtCedulaLogin().setText("");
                    VistaL.getPasswordLogin().setText("");
                    bloqueo = bloqueo - 1;
                }
            
        }

        if (bloqueo == -1) {
            JOptionPane.showMessageDialog(null, "Usted a agotado sus intentos", "Seguridad del Sistema", JOptionPane.OK_OPTION);
            System.exit(0);
        }
    }
}
