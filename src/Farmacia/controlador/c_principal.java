/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Farmacia.controlador;

import Farmacia.vista.*;
import Farmacia.controlador.*;
import java.awt.Dimension;
import java.awt.Frame;

/**
 *
 * @author VICO5
 */
public class c_principal {

    public static v_principal vista;

    public c_principal(v_principal vista) {
        this.vista = vista;
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.setExtendedState(Frame.MAXIMIZED_BOTH);
        vista.getBtn_persona().addActionListener(e -> persona());
        vista.getBtn_rol().addActionListener(e -> rol());
        vista.getBtn_salir().addActionListener(e -> salir());
    }

    private void persona() {
        v_persona vpersona = new v_persona();
        cpersona cpersona = new cpersona(vpersona);

        vista.getjDesktopPane1().add(vpersona);
        Dimension desktopSize = vista.getjDesktopPane1().getSize();
        Dimension FrameSize = vpersona.getSize();
        vpersona.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
    }
    private void rol(){
        v_roles vroles = new v_roles();
        c_roles croles = new c_roles(vroles);

        vista.getjDesktopPane1().add(vroles);
        Dimension desktopSize = vista.getjDesktopPane1().getSize();
        Dimension FrameSize = vroles.getSize();
        vroles.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
    }
     private void salir(){
        vista.dispose();
    }
}
