package controlador;

import java.awt.Dimension;

import static java.awt.Frame.MAXIMIZED_BOTH;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import modelo.Conectar;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import vista.*;

public class C_Principal {
    
    public static V_Principal vista;
    
    public C_Principal(V_Principal vista) {
        this.vista = vista;
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.setExtendedState(MAXIMIZED_BOTH);
        vista.getBtn_nuevopersona().addActionListener(x -> persona());
        vista.getBtn_nuevorol().addActionListener(x -> rol());
        vista.getBtn_NuevoUsuario().addActionListener(x -> usuario());
        vista.getBtn_NuevoCliente().addActionListener(x -> cliente());
        vista.getBtn_NuevoConsultorio().addActionListener(x -> consultorio());
        vista.getBtn_NuevoJuicio().addActionListener(x -> Tipo_Juicio());
        vista.getBtn_NuevoServicio().addActionListener(x -> Servicio());
        vista.getBtn_ImprimirCliente().addActionListener(x->ImprimirCliente());
        vista.getBtn_ImprimirUsuarioRol().addActionListener(x->Imprimirporusuarioyrol());
        vista.getLabelUser().setText(C_Login.lista2.get(0) + "--" + C_Login.lista2.get(1));
    }
    
    public C_Principal() {
    }
    
    public void persona() {
        V_Persona vp = new V_Persona();
        C_Persona cp = new C_Persona(vp);
        vista.getEscritorio().add(vp);
        Dimension desktopSize = vista.getEscritorio().getSize();
        Dimension FrameSize = vp.getSize();
        vp.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        
    }
    
    public void rol() {
        V_Rol vr = new V_Rol();
        C_Rol cr = new C_Rol(vr);
        vista.getEscritorio().add(vr);
        Dimension desktopSize = vista.getEscritorio().getSize();
        Dimension FrameSize = vr.getSize();
        vr.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        
    }
    
    public void usuario() {
        V_Usuario vr = new V_Usuario();
        C_Usuario cr = new C_Usuario(vr);
        vista.getEscritorio().add(vr);
        Dimension desktopSize = vista.getEscritorio().getSize();
        Dimension FrameSize = vr.getSize();
        vr.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        
    }
    
    public void cliente() {
        V_GesClient vr = new V_GesClient();
        C_Cliente cr = new C_Cliente(vr);
        vista.getEscritorio().add(vr);
        Dimension desktopSize = vista.getEscritorio().getSize();
        Dimension FrameSize = vr.getSize();
        vr.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        
    }
    
    public void consultorio() {
        V_Consultorio con = new V_Consultorio();
        C_Consultorio cn = new C_Consultorio(con);
        vista.getEscritorio().add(con);
        Dimension desktopSize = vista.getEscritorio().getSize();
        Dimension FrameSize = con.getSize();
        con.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        
    }

    public void Servicio() {
        V_Servicios con = new V_Servicios();
        C_Servicio cn = new C_Servicio(con);
        vista.getEscritorio().add(con);
        Dimension desktopSize = vista.getEscritorio().getSize();
        Dimension FrameSize = con.getSize();
        con.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        
    }

    public void Tipo_Juicio() {
        V_RegistroJuicio con = new V_RegistroJuicio();
        C_TipoJuicio cn = new C_TipoJuicio(con);
        vista.getEscritorio().add(con);
        Dimension desktopSize = vista.getEscritorio().getSize();
        Dimension FrameSize = con.getSize();
        con.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        
    }
        private void ImprimirCliente() {
        Conectar con = new Conectar();
        try {
            String cedula = JOptionPane.showInputDialog("Escriba la cedula de la persona");
            JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/por_cliente.jasper"));

            Map<String, Object> map = new HashMap<String, Object>();

            map.put("cedula", cedula);

            JasperPrint ja = (JasperPrint) JasperFillManager.fillReport(jas, map, con.getCon());
            JasperViewer jv = new JasperViewer(ja, false);
            jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jv.setVisible(true);
        } catch (JRException e) {
            System.out.println("no se pudo encontrar registros" + e.getMessage());
            Logger.getLogger(C_Persona.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void Imprimirporusuarioyrol() {
        Conectar con = new Conectar();
        try {
            String usuario = JOptionPane.showInputDialog("Escriba el nombre de usuario");
            String rol = JOptionPane.showInputDialog("Escriba el nombre del rol");
            JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/por_usuario_y_rol.jasper"));

            Map<String, Object> map = new HashMap<String, Object>();

            map.put("usuario", usuario);
            map.put("rol", rol);
            JasperPrint ja = (JasperPrint) JasperFillManager.fillReport(jas, map, con.getCon());
            JasperViewer jv = new JasperViewer(ja, false);
            jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jv.setVisible(true);
        } catch (JRException e) {
            System.out.println("no se pudo encontrar registros" + e.getMessage());
            Logger.getLogger(C_Persona.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
