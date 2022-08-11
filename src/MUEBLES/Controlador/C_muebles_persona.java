package MUEBLES.Controlador;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import MUEBLES.Vista.*;

public class C_muebles_persona {
    
    public static Vista_persona_muebles vistaper;
    
    public C_muebles_persona(Vista_persona_muebles vistaper){
        this.vistaper = vistaper;
        vistaper.setVisible(true);
        vistaper.setLocationRelativeTo(null);
    }
}
