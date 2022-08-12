package controlador;

import java.awt.Color;
import vista.V_Login;

public class C_Login {

    public static V_Login vista;

    public C_Login(V_Login vista) {
        C_Login.vista = vista;
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.getLabelOcultar().setVisible(false);
        vista.getBtn_Cerrar().setVisible(false);
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
    }
     private void Efecto_CerrarMouseEntered(java.awt.event.MouseEvent evt) {  
         vista.getPanelCerrar().setBackground(Color.GRAY);
         vista.getEfecto_Cerrar().setVisible(false);
         vista.getBtn_Cerrar().setVisible(true);
    }                                          

    private void Btn_CerrarMouseExited(java.awt.event.MouseEvent evt) {                                       
        vista.getBtn_Cerrar().setVisible(false);
        vista.getEfecto_Cerrar().setVisible(true);
        vista.getPanelCerrar().setBackground(new Color(3,3,3));
    }                                      

    private void Btn_CerrarMouseClicked(java.awt.event.MouseEvent evt) {                                        
       System.exit(0);
    } 
     private void PanelCerrarMouseClicked(java.awt.event.MouseEvent evt) {                                   
       System.exit(0);
    } 
}
