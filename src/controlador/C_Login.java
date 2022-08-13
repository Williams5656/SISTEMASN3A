package controlador;

import java.awt.Color;
import java.awt.Font;
import vista.V_Login;

public class C_Login {

    public static V_Login vista;
    String tUsuario = "USUARIO:";
    String pClave = "CONTRASEÑA:";
    int xMouse, yMouse;
    int bloqueo = 3;
    int a = 0;
    boolean mostrar;

    public C_Login(V_Login vista) {
        C_Login.vista = vista;
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.getLabelOcultar().setVisible(false);
        vista.getBtn_Cerrar().setVisible(false);
        vista.getTxtClave().setVisible(false);
        vista.getBtn_Cerrar().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_CerrarMouseClicked(evt);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_CerrarMouseExited(evt);
            }
        });
        vista.getEfecto_Cerrar().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Efecto_CerrarMouseEntered(evt);
            }
        });
        vista.getPanelCerrar().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PanelCerrarMouseClicked(evt);
            }
        });
        vista.getLabelMostrar().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LabelMostrarMouseEntered(evt);
            }
        });
        vista.getLabelOcultar().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LabelOcultarMouseExited(evt);
            }
        });
        vista.getjPassClave().addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPassClaveFocusGained(evt);
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPassClaveFocusLost(evt);
            }
        });
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
    }

    private void Efecto_CerrarMouseEntered(java.awt.event.MouseEvent evt) {
        vista.getPanelCerrar().setBackground(Color.GRAY);
        vista.getEfecto_Cerrar().setVisible(false);
        vista.getBtn_Cerrar().setVisible(true);
    }

    private void Btn_CerrarMouseExited(java.awt.event.MouseEvent evt) {
        vista.getBtn_Cerrar().setVisible(false);
        vista.getEfecto_Cerrar().setVisible(true);
        vista.getPanelCerrar().setBackground(new Color(3, 3, 3));
    }

    private void Btn_CerrarMouseClicked(java.awt.event.MouseEvent evt) {
        System.exit(0);
    }

    private void PanelCerrarMouseClicked(java.awt.event.MouseEvent evt) {
        System.exit(0);
    }

    private void LabelMostrarMouseEntered(java.awt.event.MouseEvent evt) {
        vista.getLabelOcultar().setVisible(true);
        vista.getLabelMostrar().setVisible(false);
        vista.getTxtClave().setVisible(true);
        vista.getjPassClave().setVisible(false);
        vista.getTxtClave().setText(vista.getjPassClave().getText());
        mostrar = true;
    }

    private void LabelOcultarMouseExited(java.awt.event.MouseEvent evt) {
        vista.getLabelOcultar().setVisible(false);
        vista.getLabelMostrar().setVisible(true);
        vista.getTxtClave().setVisible(false);
        vista.getjPassClave().setVisible(true);
        vista.getjPassClave().setForeground(Color.BLACK);
        vista.getjPassClave().setText(vista.getTxtClave().getText());
        mostrar = false;
    }

    private void jPassClaveFocusGained(java.awt.event.FocusEvent evt) {
        vista.getjPassClave().setText("");
        vista.getLabelClave().setText(pClave);
        vista.getjPassClave().setEditable(true);
        vista.getjPassClave().setFont(new Font("Arial", 3, 14));
    }

    private void jPassClaveFocusLost(java.awt.event.FocusEvent evt) {
        if (vista.getjPassClave().getText().isEmpty()) {
            vista.getjPassClave().setText(pClave);
            vista.getLabelClave().setText("");
            vista.getjPassClave().setEditable(false);
        }
    }

    private void txtUsuarioFocusGained(java.awt.event.FocusEvent evt) {
        vista.getTxtUsuario().setText("");
        vista.getLabelUsuario().setText(tUsuario);
        vista.getTxtUsuario().setEditable(true);
        vista.getTxtUsuario().setFont(new Font("Arial", 3, 14));
    }

    private void txtUsuarioFocusLost(java.awt.event.FocusEvent evt) {
        if (vista.getTxtUsuario().getText().isEmpty()) {
            vista.getTxtUsuario().setText("Escriba su nombre de usuario");
            vista.getTxtUsuario().setForeground(Color.GRAY);
            vista.getTxtUsuario().setFont(new Font("Serif", 3, 20));
            vista.getLabelUsuario().setText("");
            vista.getTxtUsuario().setEditable(false);
        }

    }
}
