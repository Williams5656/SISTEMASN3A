/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.vcliente;
import Vista.vproductos;
import Vista.vpersona;
import Vista.vprincipal;
import Vista.vrol;
import Vista.vusuario;
import java.awt.Dimension;
import java.awt.Frame;
import static java.awt.Frame.MAXIMIZED_BOTH;

/**
 *
 * @author VICO5
 */
public class cprincipal {
    public static vprincipal vista;

    public cprincipal(vprincipal vista) {
        this.vista = vista;
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.setExtendedState(MAXIMIZED_BOTH);
        vista.getBtn_persona().addActionListener(e -> persona());
        vista.getBtn_usuario().addActionListener(e -> usuario());
        vista.getBtn_rol().addActionListener(e -> rol());
        vista.getBtnproductos().addActionListener(e -> productos());
        vista.getBtncliente().addActionListener(e -> cliente());
        vista.getBtn_salir().addActionListener(e -> salir());
      
//        
    }


    private void persona() {
        vpersona user = new vpersona();
        vista.getEscritorio().add(user);
        Dimension desktopSize = vista.getEscritorio().getSize();
        Dimension FrameSize = user.getSize();
        user.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
          cpersona cp = new cpersona(user);
    }
    
     private void usuario() {
        vusuario user = new vusuario();
        vista.getEscritorio().add(user);
        Dimension desktopSize = vista.getEscritorio().getSize();
        Dimension FrameSize = user.getSize();
        user.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
          cusuario vu = new cusuario(user);
    }
     
      private void rol() {
        vrol user = new vrol();
        vista.getEscritorio().add(user);
        Dimension desktopSize = vista.getEscritorio().getSize();
        Dimension FrameSize = user.getSize();
        user.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
          crol vu = new crol(user);
    }
       private void productos() {
        vproductos user = new vproductos();
        vista.getEscritorio().add(user);
        Dimension desktopSize = vista.getEscritorio().getSize();
        Dimension FrameSize = user.getSize();
        user.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
          cproductos vu = new cproductos(user);
    }
        private void cliente() {
        vcliente user = new vcliente();
        vista.getEscritorio().add(user);
        Dimension desktopSize = vista.getEscritorio().getSize();
        Dimension FrameSize = user.getSize();
        user.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
          ccliente vu = new ccliente(user);
    }
     
      private void salir() {
         vista.dispose();
    }
    }

//  
//   
//    
//    
//}
