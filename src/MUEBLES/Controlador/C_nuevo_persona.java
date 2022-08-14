package MUEBLES.Controlador;

import static MUEBLES.Controlador.Cmueblesprincipal.vistaprin;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import MUEBLES.Vista.*;
import MUEBLES.Modelo.*;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

public class C_nuevo_persona {
    
    public static Vista_nuevo_persona vistabusper;
       private Persona_BD_muebles bdpersona = new Persona_BD_muebles();

    
    public C_nuevo_persona(Vista_nuevo_persona vistabusper) {
        this.vistabusper = vistabusper;
        
        vistabusper.setVisible(true);
        vistabusper.setLocationRelativeTo(null);
        
        vistabusper.getBtnguardar_persona().addActionListener(e -> guardar());
        vistabusper.getBtnregresar().addActionListener(e -> regresar());
        vistabusper.getBtncargar().addActionListener(e -> obtieneImagen());
    }
    
    public void guardar() {
        bdpersona.setCedula(vistabusper.getTxtcedula().getText());
        bdpersona.setNombre(vistabusper.getTxtnombres().getText());
        bdpersona.setApellido(vistabusper.getTxtapellidos().getText());
        bdpersona.setDireccion(vistabusper.getTxtdireccion().getText());
        bdpersona.setCelular(vistabusper.getTxtcelular().getText());
        bdpersona.setNacionalidad(vistabusper.getTxtnacionalidad().getText());
        bdpersona.setFechana(vistabusper.getTxtfecha().getText());
        ImageIcon ic = (ImageIcon) vistabusper.getjLabel8().getIcon();
        bdpersona.setFoto(ic.getImage());
        
        if (bdpersona.insert()) {
            JOptionPane.showMessageDialog(null, "GUARDADO CORRECTO");
            
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
        }
    }
    
    private void obtieneImagen() {
        vistabusper.getjLabel8().setIcon(null);
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = j.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                Image icono = ImageIO.read(j.getSelectedFile()).getScaledInstance(vistabusper.getjLabel8().getWidth(), vistabusper.getjLabel8().getHeight(), Image.SCALE_DEFAULT);
                vistabusper.getjLabel8().setIcon(new ImageIcon(icono));
                vistabusper.getjLabel8().updateUI();
            } catch (IOException ex) {
                Logger.getLogger(C_nuevo_persona.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void regresar(){
        Vista_muebles_principal vista = new Vista_muebles_principal();
        C_muebles_persona vis = new C_muebles_persona(C_muebles_persona.vistaper);
        vistabusper.dispose();
    }
    
    private void mostrar(){
        
    }
    
}
