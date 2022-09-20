package controlador;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.*;
import vista.*;

public class C_Login {

    public static V_Login vista;
    String tUsuario = "USUARIO:";
    String pClave = "CONTRASEÑA:";
    UsuarioBD lg = new UsuarioBD();
    UsuarioMD us = new UsuarioMD();
    int xMouse, yMouse;
    int bloqueo = 3;
    int a = 0;
    boolean mostrar;

    public C_Login(V_Login vista) {
        C_Login.vista = vista;
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.getjLabel1().requestFocus();
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
        vista.getBtn_Ingresar().addActionListener(x -> {
            try {
                validar();
            } catch (SQLException ex) {
                Logger.getLogger(C_Login.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.toString(), "!ERRORRR¡", JOptionPane.ERROR_MESSAGE);
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
        vista.getTxtUsuario().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyPressed(evt);
            }
        });
        vista.getjPassClave().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtClaveKeyPressed(evt);

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
        vista.getTxtUsuario().setText(vista.getTxtUsuario().getText());
        vista.getTxtClave().setVisible(true);
        vista.getjPassClave().setVisible(false);
        vista.getTxtClave().setText(vista.getjPassClave().getText());
        mostrar = true;
    }

    private void LabelOcultarMouseExited(java.awt.event.MouseEvent evt) {
        vista.getLabelOcultar().setVisible(false);
        vista.getLabelMostrar().setVisible(true);
        vista.getTxtUsuario().setText(vista.getTxtUsuario().getText());
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
        vista.getTxtUsuario().setForeground(Color.BLACK);
        vista.getTxtUsuario().setFont(new Font("Arial", 3, 14));
    }

    private void txtUsuarioFocusLost(java.awt.event.FocusEvent evt) {
        if (vista.getTxtUsuario().getText().isEmpty()) {
            vista.getTxtUsuario().setText("Escriba su nombre de usuario");
            vista.getTxtUsuario().setForeground(Color.GRAY);
            vista.getTxtUsuario().setFont(new Font("Serif", 3, 14));
            vista.getLabelUsuario().setText("");
            vista.getTxtUsuario().setEditable(false);
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

    private void txtUsuarioKeyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            vista.getjPassClave().requestFocus();
        }
    }

    private void txtClaveKeyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            vista.getBtn_Ingresar().requestFocus();
            try {
                validar();
            } catch (SQLException ex) {
                Logger.getLogger(C_Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void validar() throws SQLException {
        RolBD bdrol = new RolBD();
        String estado = "";
        String id_rol = "";
        List<RolMD> listarol = bdrol.mostrardatos();
        for (int i = 0; i < listarol.size(); i++) {
            estado = listarol.get(i).getEstado();
            id_rol = listarol.get(i).getCodigo();
        }
        String usuario = vista.getTxtUsuario().getText();
        String clave = vista.getjPassClave().getText();
        if (vista.getTxtUsuario().getText().equals("") || String.valueOf(vista.getjPassClave().getPassword()).equals("")) {
            JOptionPane.showMessageDialog(null, "LLene todos los campos", null, JOptionPane.ERROR_MESSAGE);
        } else {
            us = lg.validar(usuario, clave);
            if (us.getEstado().equals("Inactivo")) {
                JOptionPane.showMessageDialog(null, "Usted es un usuario Inactivo \n Contactese con su administrador", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                if (us.getRol().equals(id_rol)) {
                    if (estado.equals("Inactivo")) {
                        JOptionPane.showMessageDialog(null, "Ha intentado entrar con un rol inactivo \n Contactese con su administrador", "ERROR", JOptionPane.ERROR_MESSAGE);

                    } else {

                        if (us.getUsuario() != null && us.getClave() != null) {
                            V_Principal vistap = new V_Principal();
                            C_Principal Iniciop = new C_Principal(vistap);
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

        }
    }
}
