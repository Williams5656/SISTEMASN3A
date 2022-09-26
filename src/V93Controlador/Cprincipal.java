package V93Controlador;

import java.awt.Dimension;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.security.Principal;
import V93Vista.*;

public class Cprincipal {

    public static VistaPrincipal Vistap;

    public Cprincipal(VistaPrincipal Vista) {
        this.Vistap = Vista;
        Vista.setVisible(true);
        Vista.setLocationRelativeTo(null);
        Vista.setExtendedState(MAXIMIZED_BOTH);
        Vista.getNuevoPersona().addActionListener(e -> personas());
        Vista.getNuevoUsuario().addActionListener(e -> usuarios());
        Vista.getNuevoRol().addActionListener(e -> rol());
        Vista.getNuevoProveedor().addActionListener(e -> proveedor());
        Vista.getNuevoProducto().addActionListener(e -> producto());
        Vista.getNuevoCliente().addActionListener(e -> cliente());
        Vista.getNuevaFactura().addActionListener(e -> factura());
         Vista.getNuevaVenta().addActionListener(e -> venta());
    }

    private void personas() {
        VistaPersona vr = new VistaPersona();
        CPersonas cr = new CPersonas(vr);

    }
private void cotizacion(){
    VistaCotizacion vc=new VistaCotizacion();
    CCotizacion cc=new CCotizacion(vc);
}
private void usuarios() {
        VistaUsuario vuser = new VistaUsuario();
        CUsuarios cuser = new CUsuarios(vuser);

    }

    private void rol() {
        VistaRol vrol = new VistaRol();
        CRol crol = new CRol(vrol);

    }

    private void proveedor() {
        VistaProveedor vprov = new VistaProveedor();
        CProveedor cprov = new CProveedor(vprov);

    }

    private void producto() {
        VistaProducto vpro = new VistaProducto();
        CProducto cpro = new CProducto(vpro);

    }

    private void cliente() {
        VistaCliente vclie = new VistaCliente();
        CCliente cclie = new CCliente(vclie);

    }

    private void factura() {
        VistaFactura vfact = new VistaFactura();
        CFactura fac = new CFactura(vfact);
    }
     private void venta() {
        VistaVentas vvent = new VistaVentas();
        CVentas vent = new CVentas(vvent);
    }
}
