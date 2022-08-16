
package Papeleria_Bella.controlador;

import Papeleria_Bella.controlador.*;
import Papeleria_Bella.vista.*;
import Papeleria_Bella.modelo.*;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cinicio {
    public static Vinicio vista;
    
    public Cinicio(Vinicio vista) {
        this.vista=vista;
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        
        vista.getButtoningresar().addActionListener(e-> principal ());

    }

    
    private void principal() {
        Vprincipal p= new Vprincipal();
        Cprincipal cper=new Cprincipal(p);
    }
}
