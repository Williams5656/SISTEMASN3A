package MUEBLES.Controlador;

/**
 *
 * @author HP i5
 */
import MUEBLES.Vista.*;
import java.awt.Dimension;
import static java.awt.Frame.MAXIMIZED_BOTH;
import javax.swing.JOptionPane;

public class Cmueblesinicio {
    public static Minicio vistaini;
    
    public Cmueblesinicio(Minicio vistaini) {
        this.vistaini = vistaini;
        vistaini.setVisible(true);
        vistaini.setLocationRelativeTo(null);
        vistaini.setResizable(false);
        
        vistaini.getBtncancelar_inicio().addActionListener(e -> salir());
        vistaini.getBtnloguear_inicio().addActionListener(e -> ingreso());
    }
    
    private void salir() {
        System.exit(0);
    }
    
    private void ingreso(){
        Vista_muebles_principal vista = new Vista_muebles_principal();
        Cmueblesprincipal cprin = new Cmueblesprincipal(vista);
        vistaini.dispose();
    }
}
