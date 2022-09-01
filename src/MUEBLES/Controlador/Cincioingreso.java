package MUEBLES.Controlador;

import MUEBLES.Vista.*;
import static MUEBLES.Controlador.Cmueblesinicio.vistaini;
import static java.awt.Frame.MAXIMIZED_BOTH;

public class Cincioingreso {
    
    public static Vista_cargo vista;
    
    public Cincioingreso(Vista_cargo vista){
        this.vista = vista;
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        
        vista.getBtn_regresar().addActionListener(e->regresar());
        //vista.getBtn_ingresar().addActionListener(e->cargo());
        vista.getBtn_ingresar().addActionListener(e->administrador());
        
    }
    
    private void administrador(){
        Vista_administrador vista = new Vista_administrador();
        C_administrador admin = new C_administrador(vista);
    }
   
    private void regresar(){
        Cmueblesinicio volv = new Cmueblesinicio(vistaini);
        vista.dispose();
    }
}
