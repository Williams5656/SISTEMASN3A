package MUEBLES.Controlador;

import static MUEBLES.Controlador.Cmueblesinicio.vistaini;
import MUEBLES.Vista.*;
import java.awt.Dimension;
import static java.awt.Frame.MAXIMIZED_BOTH;

public class Cmueblesprincipal {
    
    public static Vista_muebles_principal vistaprin;
    
    public Cmueblesprincipal(Vista_muebles_principal vistaprin){
        this.vistaprin = vistaprin;
        
        vistaprin.setVisible(true);
        vistaprin.setLocationRelativeTo(null);
        vistaprin.setExtendedState(MAXIMIZED_BOTH);       
        vistaprin.getItmPersona().addActionListener(e -> persona());
        vistaprin.getItmUsuario().addActionListener(e -> usuario());
        vistaprin.getItmRegresar().addActionListener(e -> regresar());
        vistaprin.getItmrol().addActionListener(e -> rol());
    }
    
    private void persona(){
        Vista_persona_muebles vistaper = new Vista_persona_muebles();
        C_persona cmu = new C_persona(vistaper);
        vistaprin.getDesk_escritorio_muebles().add(vistaper);
        Dimension desktopSize = vistaprin.getDesk_escritorio_muebles().getSize();
        Dimension FrameSize = vistaper.getSize();
        vistaper.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
    }
    
    private void usuario(){
        Vista_usuario vistaper = new Vista_usuario();
        C_usuario cmu = new C_usuario(vistaper);
        vistaprin.getDesk_escritorio_muebles().add(vistaper);
        Dimension desktopSize = vistaprin.getDesk_escritorio_muebles().getSize();
        Dimension FrameSize = vistaper.getSize();
        vistaper.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
    }
    
    private void regresar(){
        Cmueblesinicio volv = new Cmueblesinicio(vistaini);
        vistaprin.dispose();
    }
    
    private void rol(){
        Vista_rol vistaper = new Vista_rol();
        Crol cmu = new Crol(vistaper);
        vistaprin.getDesk_escritorio_muebles().add(vistaper);
        Dimension desktopSize = vistaprin.getDesk_escritorio_muebles().getSize();
        Dimension FrameSize = vistaper.getSize();
        vistaper.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
    }
}