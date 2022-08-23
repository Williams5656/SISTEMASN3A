package Papeleria_Bella.controlador;

import Papeleria_Bella.controlador.*;
import Papeleria_Bella.vista.*;
import Papeleria_Bella.modelo.*;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Cinicio {

    public static Vinicio vista;
    int bloqueo = 3;
    int a = 0;
    UsuarioBD lg = new UsuarioBD();
    UsuarioMD us = new UsuarioMD();

    public Cinicio(Vinicio vista) {
        this.vista = vista;
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);

        vista.getButtoningresar().addActionListener(e -> {
            try {
                validar();
            } catch (SQLException ex) {
                Logger.getLogger(Cinicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }

    public void validar() throws SQLException {

        String usuario = vista.getTxtusuario().getText();
        String clave = vista.getFieldcontraseña().getText();
        if (vista.getTxtusuario().getText().equals("") || String.valueOf(vista.getFieldcontraseña().getPassword()).equals("")) {
            JOptionPane.showMessageDialog(null, "LLene todos los campos", null, JOptionPane.ERROR_MESSAGE);
        } else {
            us = lg.validar(usuario, clave);
            if (us.getEstado().equals("Inactivo")) {
                JOptionPane.showMessageDialog(null, "Usted es un usuario Inactivo \n Contactese con su administrador", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                if (us.getUsuario() != null && us.getClave() != null) {
                    Vprincipal vistap = new Vprincipal();
                    Cprincipal Inicio = new Cprincipal(vistap);
                    vista.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o Contraseña Incorrectos", null, JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(null, "Intentos Permitidos: " + bloqueo, null, JOptionPane.WARNING_MESSAGE);
                    vista.getTxtusuario().requestFocus();
                    vista.getTxtusuario().setText("");
                    vista.getFieldcontraseña().setText("");
                    bloqueo = bloqueo - 1;
                }
            }

        }
        if (bloqueo == -1) {
            JOptionPane.showMessageDialog(null, "Usted a agotado sus intentos", "Seguridad del Sistema", JOptionPane.OK_OPTION);
            System.exit(0);
        }
    }
}
