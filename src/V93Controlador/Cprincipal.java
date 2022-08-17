package V93Controlador;

import java.awt.Dimension;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.security.Principal;
import V93Vista.*;

public class Cprincipal {
 
    public static VistaPrincipal Vistap;
     
    public Cprincipal(VistaPrincipal Vista) {
        this.Vistap = Vista;
        Vista.setVisible(true);
        Vista.setLocationRelativeTo(null);
        Vista.setExtendedState(MAXIMIZED_BOTH);
        Vista.getNuevoPersona().addActionListener(e -> personas());
        Vista.getNuevoUsuario().addActionListener(e -> usuarios());
        Vista.getNuevoRol().addActionListener(e ->rol());
 
    }
       
    private void personas() {
        VistaPersona vr = new VistaPersona();
        CPersonas cr = new CPersonas(vr);

    }
   
    private void usuarios() {
        VistaUsuario vuser = new VistaUsuario();
        CUsuarios cuser = new CUsuarios(vuser);

    }
     private void rol() {
        VistaRol vrol = new VistaRol();
        CRol crol = new CRol(vrol);

    }
}
