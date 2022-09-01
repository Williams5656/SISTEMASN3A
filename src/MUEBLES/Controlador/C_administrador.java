package MUEBLES.Controlador;

import MUEBLES.Vista.Vista_administrador;
import static java.awt.Frame.MAXIMIZED_BOTH;
import static MUEBLES.Controlador.Cincioingreso.vista;

public class C_administrador {
    
    public static Vista_administrador vistadmin;

    public C_administrador(Vista_administrador vistadmin) {
        this.vistadmin = vistadmin;
        
        vistadmin.setVisible(true);
        vistadmin.setLocationRelativeTo(null);
        vistadmin.setExtendedState(MAXIMIZED_BOTH);
        
        vistadmin.getItm_regresar().addActionListener(e->regresar());
    }
    
    private void nuevoproducto(){
        
    }
    
    private void regresar(){
        Cincioingreso volv = new Cincioingreso(vista);
        vistadmin.dispose();
    }
}
