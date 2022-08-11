package MUEBLES.Controlador;

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
    }
    
    private void persona(){
        Vista_persona_muebles vistaper = new Vista_persona_muebles();
        C_muebles_persona cmu = new C_muebles_persona(vistaper);
        vistaprin.getDesk_escritorio_muebles().add(vistaper);
        Dimension desktopSize = vistaprin.getDesk_escritorio_muebles().getSize();
        Dimension FrameSize = vistaper.getSize();
        vistaper.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
    }
}
