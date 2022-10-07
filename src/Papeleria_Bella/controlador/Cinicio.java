package Papeleria_Bella.controlador;

import Papeleria_Bella.controlador.*;
import Papeleria_Bella.modelo.*;
import Papeleria_Bella.vista.*;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Cinicio {

    public static ArrayList<String> listalogin;
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
            } catch (SQLException | NullPointerException ex) {
                Logger.getLogger(Cinicio.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos " + ex.toString());
            }
        });
        vista.getFieldcontraseña().addKeyListener(new java.awt.event.KeyAdapter() {

            public void KeyPressed(java.awt.event.KeyEvent evt) {
                txtClaveKeyPressed(evt);
            }
        });

    }

    private void txtClaveKeyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            vista.getButtoningresar().requestFocus();
            try {
                validar();
            } catch (SQLException e) {
                Logger.getLogger(Cinicio.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    public void validar() throws SQLException {
        String estado = "";
        String estado_rol = "";
        String usuario = vista.getTxtusuario().getText();
        String clave = vista.getFieldcontraseña().getText();
        RolBD bdrol = new RolBD();
        List<RolMD> listarol = bdrol.mostrardatos();
        if (vista.getTxtusuario().getText().equals("") || String.valueOf(vista.getFieldcontraseña().getPassword()).equals("")) {
            JOptionPane.showMessageDialog(null, "No dejar campos vacios", null, JOptionPane.ERROR_MESSAGE);
        } else {
            try {

                us = lg.validar(usuario, clave);
                for (int i = 0; i < listarol.size(); i++) {
                    if (us.getRol().equals(listarol.get(i).getNombre())) {
                        estado_rol = listarol.get(i).getEstado();

                    }
                }
                listalogin = new ArrayList();
                listalogin.add(usuario);
                listalogin.add(us.getRol());
            } catch (NullPointerException es) {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos " + es.toString());
            }
            if (estado_rol.equals("Inactivo")) {
                JOptionPane.showMessageDialog(null, "Usuario con rol Inactivo", "ERROR", JOptionPane.ERROR_MESSAGE);

            } else {
                if (us.getEstado().equals("Inactivo")) {
                    JOptionPane.showMessageDialog(null, "Usuario Inactivo", "ERROR", JOptionPane.ERROR_MESSAGE);
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
        }
        if (bloqueo == -1) {
            JOptionPane.showMessageDialog(null, "Usted a agotado sus intentos", "Seguridad del Sistema", JOptionPane.OK_OPTION);
            System.exit(0);
        }
    }
}
