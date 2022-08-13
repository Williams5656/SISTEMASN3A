package controlador;

import java.awt.Dimension;
import java.awt.Frame;
import vista.*;

public class C_Principal {

    public static V_Principal vista;

    public C_Principal(V_Principal vista) {
        this.vista = vista;
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.setExtendedState(Frame.MAXIMIZED_BOTH);
        vista.getBtn_nuevopersona().addActionListener(x -> persona());
    }

    public void persona() {
        V_Persona vp = new V_Persona();
        C_Persona cp = new C_Persona(vp);
        vista.getEscritorio().add(vp);
        vp.setVisible(true);
        Dimension desktopSize = vista.getEscritorio().getSize();
        Dimension FrameSize = vp.getSize();
        vp.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        vp.show();

    }
}
