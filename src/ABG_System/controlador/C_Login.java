package ABG_System.controlador;

import ABG_System.modelo.UsuarioBD;
import ABG_System.modelo.PersonaBD;
import ABG_System.vista.V_Login;
import ABG_System.vista.V_Principal;
import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class C_Login {

    public static V_Login vista;
    UsuarioBD lg = new UsuarioBD();
    PersonaBD us = new PersonaBD();
    int xMouse, yMouse;
    int bloqueo = 3;
    boolean mostrar;
    String tUsuario = "USUARIO:";
    String pClave = "CONTRASEÑA:";

    public C_Login(V_Login vista) {
        this.vista = vista;
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.getTxtPassUser().setVisible(false);
        vista.getBtn_Cerrar().setVisible(false);
        vista.getLabelMostrar().setVisible(false);
        vista.getTxtUsuario().setText(tUsuario);
        vista.getTxtUsuario().setFont(new Font("Miriam Fixed", 3, 14));
        vista.getJpassUser().setText(pClave);
        vista.getJpassUser().setFont(new Font("Miriam Fixed", 3, 14));
        vista.getTxtUsuario().addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUsuarioFocusGained(evt);
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUsuarioFocusLost(evt);
            }
        });
        vista.getJpassUser().addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                JpassUserFocusGained(evt);
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                JpassUserFocusLost(evt);
            }
        });
        vista.getLabelOcultar().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelOcultarMouseClicked(evt);
            }
        });
        vista.getBarraMovi().addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                BarraMoviMouseDragged(evt);
            }
        });
        vista.getBarraMovi().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BarraMoviMousePressed(evt);
            }
        });
        vista.getBtnIngresar().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    BtnIngresarActionPerformed(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(C_Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

    private void txtUsuarioFocusGained(java.awt.event.FocusEvent evt) {
        vista.getTxtUsuario().setText("");
        vista.getLabelUsuario().setText(tUsuario);
        vista.getTxtUsuario().setEditable(true);
        vista.getTxtUsuario().setFont(new Font("Arial", 3, 14));
    }

    private void txtUsuarioFocusLost(java.awt.event.FocusEvent evt) {
        if (vista.getTxtUsuario().getText().isEmpty()) {
            vista.getTxtUsuario().setText(tUsuario);
            vista.getLabelUsuario().setText("");
            vista.getTxtUsuario().setEditable(false);
        }

    }

    private void JpassUserFocusGained(java.awt.event.FocusEvent evt) {
        vista.getJpassUser().setText("");
        vista.getLabelclave().setText(pClave);
        vista.getJpassUser().setEditable(true);
        vista.getJpassUser().setFont(new Font("Arial", 3, 14));
    }

    private void JpassUserFocusLost(java.awt.event.FocusEvent evt) {
        if (vista.getJpassUser().getText().isEmpty()) {
            vista.getJpassUser().setText(pClave);
            vista.getLabelclave().setText("");
            vista.getJpassUser().setEditable(false);
        }

    }

    private void labelOcultarMouseClicked(java.awt.event.MouseEvent evt) {
        if (mostrar) {
            vista.getLabelMostrar().setVisible(true);
            vista.getTxtPassUser().setVisible(false);
            vista.getJpassUser().setVisible(true);
            this.vista.getJpassUser().setForeground(Color.BLACK);
            vista.getJpassUser().setText(vista.getTxtPassUser().getText());
            mostrar = false;
        } else {
            vista.getLabelMostrar().setVisible(false);
            vista.getTxtPassUser().setVisible(true);
            vista.getJpassUser().setVisible(false);
            vista.getTxtPassUser().setText(vista.getJpassUser().getText());
            mostrar = true;
        }
    }

    private void BarraMoviMousePressed(java.awt.event.MouseEvent evt) {
        xMouse = evt.getX();
        yMouse = evt.getY();
    }

    private void BarraMoviMouseDragged(java.awt.event.MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        vista.setLocation(x - xMouse, y - yMouse);
    }

    private void BtnIngresarActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
        validar();
    }

    public void validar() throws SQLException {
        String usuario = vista.getTxtUsuario().getText();
        String clave = vista.getJpassUser().getText();
        if (vista.getTxtUsuario().getText().equals("") || String.valueOf(vista.getJpassUser().getPassword()).equals("")) {
            JOptionPane.showMessageDialog(null, "LLene todos los campos", null, JOptionPane.ERROR_MESSAGE);
        } else {
            us = lg.validar(usuario, clave);
            if (us.getUsuario() != null && us.getClave() != null) {
                V_Principal vistab = new V_Principal();
                C_principal Inicio = new C_principal(vistab);
                vista.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o Contraseña Incorrectos", null, JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(null, "Intentos Permitidos: " + bloqueo, null, JOptionPane.WARNING_MESSAGE);
                vista.getTxtUsuario().requestFocus();
                vista.getTxtUsuario().setText("");
                vista.getJpassUser().setText("");
                bloqueo = bloqueo - 1;
            }
        }
        if (bloqueo == -1) {
            JOptionPane.showMessageDialog(null, "Usted a agotado sus intentos", "Seguridad del Sistema", JOptionPane.OK_OPTION);
            System.exit(0);
        }
    }

}
