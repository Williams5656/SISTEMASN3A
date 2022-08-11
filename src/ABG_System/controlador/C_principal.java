package ABG_System.controlador;

import ABG_System.vista.V_Principal;
import java.awt.Frame;

public class C_principal {

    public static V_Principal vista;

    public C_principal(V_Principal vista) {
        this.vista = vista;
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.setExtendedState(Frame.MAXIMIZED_BOTH);
        vista.getBtnpersona().addActionListener(x -> persona());
        vista.getBtncliente().addActionListener(x -> cliente());
        vista.getBtnrol().addActionListener(x -> rol());
        vista.getBtnusuario().addActionListener(x -> usuario());
    }

    public void persona() {
        Vpersona vp = new Vpersona();
        Cpersona cp = new Cpersona(vp);

    }

    public void cliente() {
        Vcliente vc = new Vcliente();
        Ccliente cc = new Ccliente(vc);

    }

    public void rol() {
        Vcliente vc = new Vcliente();
        Ccliente cc = new Ccliente(vc);

    }

    public void usuario() {

    }
}
