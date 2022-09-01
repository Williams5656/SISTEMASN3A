/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.vpersona;
import Vista.vprincipal;
import Vista.vrol;
import Vista.vusuario;
import java.awt.Dimension;
import java.awt.Frame;

/**
 *
 * @author VICO5
 */
public class cprincipal {
    public static vprincipal vista;
    
    public cprincipal(vprincipal vista){
        this.vista=vista;
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.setExtendedState(Frame.MAXIMIZED_BOTH);
        
        vista.getBtn_persona().addActionListener(e-> persona());
        vista.getBtn_usuario().addActionListener(e-> usuario());
        vista.getBtn_rol().addActionListener(e-> rol());
        vista.getBtn_salir().addActionListener(e-> salir());
        
    }

    private void persona() {
        vpersona vpersona = new vpersona();
        cpersona cpersona = new cpersona(vpersona);

        vista.getEscritorio().add(vpersona);
        Dimension desktopSize = vista.getEscritorio().getSize();
        Dimension FrameSize = vpersona.getSize();
        vpersona.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        
    }

    private void usuario() {
        vusuario vusu = new vusuario();
        cusuario cpersona = new cusuario(vusu);

        vista.getEscritorio().add(vusu);
        Dimension desktopSize = vista.getEscritorio().getSize();
        Dimension FrameSize = vusu.getSize();
        vusu.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
    }

    private void rol() {
        vrol vrol = new vrol();
        crol cpersona = new crol(vrol);

        vista.getEscritorio().add(vrol);
        Dimension desktopSize = vista.getEscritorio().getSize();
        Dimension FrameSize = vrol.getSize();
        vrol.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        
    }

    private void salir() {
         vista.dispose();
    }
    
    
}
