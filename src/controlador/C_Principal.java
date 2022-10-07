package controlador;

import java.awt.Dimension;

import static java.awt.Frame.MAXIMIZED_BOTH;
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
    
}
