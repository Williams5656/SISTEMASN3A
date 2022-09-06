/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Farmacia.controlador;

import Farmacia.vista.Vmenu;
import Farmacia.vista.Vpersona;
import Farmacia.vista.Vusuario;
import java.awt.Dimension;
import static java.awt.Frame.MAXIMIZED_BOTH;

/**
 *
 * @author A
 */
public class Con_menu {
     public static Vmenu vista;

    public Con_menu(Vmenu vista) {
        this.vista = vista;
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.setExtendedState(MAXIMIZED_BOTH);
        vista.getBtn_usuario().addActionListener(e -> usuario());
        vista.getBtn_persona().addActionListener(e -> persona());
//        vista.getBtn_factura().addActionListener(e -> factura());
//        vista.getBtn_farmaceutico().addActionListener(e -> farmaceutico());
//        vista.getBtn_medicamento().addActionListener(e -> medicamento());
////      vista.getBtn_pedido().addActionListener(e -> salir());
//        vista.getBtn_proveedor().addActionListener(e -> proveedor());
    }



    private void usuario() {
        Vusuario user = new Vusuario();
        vista.getjDesktopPane1().add(user);
        Dimension desktopSize = vista.getjDesktopPane1().getSize();
        Dimension FrameSize = user.getSize();
        user.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
//        Cusuario us = new Cusuario(user);
    }
     private void persona() {
        Vpersona pro = new Vpersona();
        vista.getjDesktopPane1().add(pro);
        Dimension desktopSize = vista.getjDesktopPane1().getSize();
        Dimension FrameSize = pro.getSize();
        pro.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
//        Cproducto prod = new Cproducto(pro);
    }
    
//      private void medicamento() {
//        Vmedicamento pro = new Vmedicamento();
//        vista.getjDesktopPane1().add(pro);
//        Dimension desktopSize = vista.getjDesktopPane1().getSize();
//        Dimension FrameSize = pro.getSize();
//        pro.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
////        Cproducto prod = new Cproducto(pro);
//    }
//
//
//    private void proveedor() {
//        Vproveedor pro = new Vproveedor();
//        vista.getjDesktopPane1().add(pro);
//        Dimension desktopSize = vista.getjDesktopPane1().getSize();
//        Dimension FrameSize = pro.getSize();
//        pro.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
////        Con_Producto prod = new Con_Producto(pro);
//    }

}

