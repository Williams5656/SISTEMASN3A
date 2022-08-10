package ABG_System.controlador;

import ABG_System.vista.V_Login;
import java.awt.Color;
import java.awt.Font;

public class C_Login {

    public static V_Login vista;

    public C_Login(V_Login vista) {
        this.vista = vista;
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.getJpassUser().setVisible(false);
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
    }

    private void txtUsuarioFocusGained(java.awt.event.FocusEvent evt) {
        vista.getTxtUsuario().setForeground(Color.BLACK);
        if (vista.getTxtUsuario().getText().isEmpty()) {
            vista.getLabelUsuario().setText("USUARIO: ");
            vista.getTxtUsuario().setText("");
        } else {
            vista.getTxtUsuario().setText(vista.getTxtUsuario().getText());
            vista.getTxtUsuario().setForeground(Color.BLACK);
            vista.getTxtUsuario().setFont(new Font("Arial", 3, 14));

        }

    }

    private void txtUsuarioFocusLost(java.awt.event.FocusEvent evt) {
        vista.getTxtUsuario().setText("USUARIO: ");
        vista.getLabelUsuario().setText("");
        vista.getTxtUsuario().setForeground(Color.GRAY);
        vista.getTxtUsuario().setFont(new Font("Serif", 3, 24));
    }

    private void txtPassUserFocusGained(java.awt.event.FocusEvent evt) {
        vista.getTxtPassUser().setVisible(false);
        vista.getJpassUser().setVisible(true);
        if (vista.getJpassUser().getText().isEmpty()) {
            vista.getJpassUser().setText(vista.getJpassUser().getText());
        } else {
            vista.getLabelclave().setText("CONTRASEÑA: ");
            vista.getJpassUser().setText("");
        }

    }

    private void JpassUserFocusLost(java.awt.event.FocusEvent evt) {
        vista.getJpassUser().setVisible(false);
        vista.getTxtPassUser().setVisible(true);
        vista.getTxtPassUser().setForeground(Color.GRAY);
        vista.getTxtPassUser().setFont(new Font("Serif", 3, 24));
        vista.getLabelclave().setText("");
        vista.getTxtPassUser().setText("CONTRASEÑA: ");
    }

    private void JpassUserFocusGained(java.awt.event.FocusEvent evt) {
        vista.getLabelclave().setText("CONTRASEÑA: ");
        vista.getJpassUser().setText("");
    }

    private void txtPassUserFocusLost(java.awt.event.FocusEvent evt) {

    }
}
