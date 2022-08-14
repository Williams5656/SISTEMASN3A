package MUEBLES.Controlador;

import static MUEBLES.Controlador.Cmueblesprincipal.vistaprin;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import MUEBLES.Vista.Vista_busqueda_persona;
import MUEBLES.Modelo.*;

public class C_busqueda_persona {
    
    public static Vista_busqueda_persona vistabusper;
       private Persona_BD_muebles bdpersona = new Persona_BD_muebles();

    
    public C_busqueda_persona(Vista_busqueda_persona vistabusper) {
        this.vistabusper = vistabusper;
        
        vistabusper.setVisible(true);
        vistabusper.setLocationRelativeTo(null);
        
        vistabusper.getBtnguardar_persona().addActionListener(e -> guardar());
    }
    
    public void guardar() {
        bdpersona.setCedula(vistabusper.getTxtcedula().getText());
        bdpersona.setNombre(vistabusper.getTxtnombres().getText());
        bdpersona.setApellido(vistabusper.getTxtapellidos().getText());
        bdpersona.setDireccion(vistabusper.getTxtdireccion().getText());
        bdpersona.setCelular(vistabusper.getTxtcelular().getText());
        bdpersona.setNacionalidad(vistabusper.getTxtnacionalidad().getText());
        bdpersona.setFechana(vistabusper.getTxtfecha().getText());
        if (bdpersona.insert()) {
            JOptionPane.showMessageDialog(null, "GUARDADO CORRECTO");
            
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
        }
    }
    
    private void mostrar(){
        
    }
    
}
