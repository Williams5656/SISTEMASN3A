package ABG_System.controlador;

import ABG_System.vista.V_Login;
import java.awt.Color;
import java.awt.Font;

public class C_Login {

    public static V_Login vista;
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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelOcultarMouseClicked(evt);
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

}
