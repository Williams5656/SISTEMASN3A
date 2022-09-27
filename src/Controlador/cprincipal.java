/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.vcliente;
import Vista.vpersona;
import Vista.vprincipal;
import Vista.vproducto;
import Vista.vproveedor;
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
        vista.getBtn_cliente().addActionListener(e-> cliente());
        vista.getBtn_proveedor().addActionListener(e-> proveedor());
         vista.getBtn_productos().addActionListener(e-> producto());
        vista.getBtn_salir().addActionListener(e-> salir());
        
    }

    private void persona() {
        vpersona userp = new vpersona();
        cpersona user = new cpersona(userp);

        vista.getEscritorio().add(userp);
        Dimension desktopSize = vista.getEscritorio().getSize();
        Dimension FrameSize = userp.getSize();
        userp.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        
    }

    private void usuario() {
        vusuario useru = new vusuario();
        cusuario user = new cusuario(useru);

        vista.getEscritorio().add(useru);
        Dimension desktopSize = vista.getEscritorio().getSize();
        Dimension FrameSize = useru.getSize();
        useru.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
    }

    private void rol() {
        vrol userr = new vrol();
        crol cpersona = new crol(userr);

        vista.getEscritorio().add(userr);
        Dimension desktopSize = vista.getEscritorio().getSize();
        Dimension FrameSize = userr.getSize();
        userr.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        
    }
     private void cliente() {
        vcliente userc = new vcliente();
        ccliente user = new ccliente(userc);

        vista.getEscritorio().add(userc);
        Dimension desktopSize = vista.getEscritorio().getSize();
        Dimension FrameSize = userc.getSize();
        userc.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        
    }
      private void proveedor() {
        vproveedor userpro = new vproveedor();
        cproveedor user = new cproveedor(userpro);

        vista.getEscritorio().add(userpro);
        Dimension desktopSize = vista.getEscritorio().getSize();
        Dimension FrameSize = userpro.getSize();
        userpro.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        
    }
       private void producto() {
        vproducto userprod = new vproducto();
        cproducto user = new cproducto(userprod);

        vista.getEscritorio().add(userprod);
        Dimension desktopSize = vista.getEscritorio().getSize();
        Dimension FrameSize = userprod.getSize();
        userprod.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        
    }
    

    private void salir() {
         vista.dispose();
    }
    
    
}
