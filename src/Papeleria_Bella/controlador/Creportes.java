


package Papeleria_Bella.controlador;
import Papeleria_Bella.vista.*;
import Papeleria_Bella.modelo.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Creportes {
    public static Vreportes vistarep;

    
    public Creportes(Vreportes vistarep) {
        this.vistarep = vistarep;
        vistarep.setVisible(true);
        vistarep.setLocationRelativeTo(null);

        vistarep.getButtonimprimirpersona().addActionListener(x -> imprimirpersona());
        vistarep.getButtonimprimirusuario().addActionListener(e -> imprimirusuario());

    }
    
    private void imprimirpersona(){
        Conexion conectar = new Conexion();
        try {
            JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/reportes/persona2.jasper"));
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("logo", "images/pap.png");
            JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(jas, map, conectar.getCon());

            JasperViewer jv = new JasperViewer(jp, false);
            jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jv.setVisible(true);
        } catch (JRException e) {
            System.out.println("No hay registros en la tabla." + e.getMessage());
            Logger.getLogger(Cpersona.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    private void imprimirusuario(){
        Conexion conectar = new Conexion();
        try {
            JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/reportes/usuario2.jasper"));
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("logo", "images/pap.png");
            JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(jas, map, conectar.getCon());

            JasperViewer jv = new JasperViewer(jp, false);
            jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jv.setVisible(true);
        } catch (JRException e) {
            System.out.println("No hay registros en la tabla." + e.getMessage());
            Logger.getLogger(Cpersona.class.getName()).log(Level.SEVERE, null, e);
        }
    }
       
}
