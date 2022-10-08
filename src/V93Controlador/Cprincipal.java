package V93Controlador;

import V93Modelo.Conectar;
import java.awt.Dimension;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.security.Principal;
import V93Vista.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

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
        Vista.getBtn_Cotizacion().addActionListener(e -> cotizacion());
        Vista.getNuevaEmpresa().addActionListener(e -> empresa());
        Vista.getVentas().addActionListener(x->ImprimirVentas());
        Vista.getStock().addActionListener(x->ImprimirProductos());
        Vista.getClientes().addActionListener(x->ImprimirClientes());
        Vista.getLabeldatos().setText(CLogin.listauser.get(0) + "--" + CLogin.listauser.get(1));
    }

    private void personas() {
        VistaPersona vr = new VistaPersona();
        CPersonas cr = new CPersonas(vr);

    }

    private void cotizacion() {
        VistaCotizacion vc = new VistaCotizacion();
        CCotizacion cc = new CCotizacion(vc);
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

    private void empresa() {
        VistaEmpresa emp = new VistaEmpresa();
        CEmpresa cem = new CEmpresa(emp);

    }

    private void ImprimirVentas() {
        Conectar con = new Conectar();
        try {
            String vendedor = JOptionPane.showInputDialog("Escriba el nombre del vendedor");
            String cliente = JOptionPane.showInputDialog("Escriba el nombre del cliente");
            JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/reportes/ventas.jasper"));

            Map<String, Object> map = new HashMap<String, Object>();

            map.put("cedula", cliente);
            map.put("vendedor", vendedor);

            JasperPrint ja = (JasperPrint) JasperFillManager.fillReport(jas, map, con.getCon());
            JasperViewer jv = new JasperViewer(ja, false);
            jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jv.setVisible(true);
        } catch (JRException e) {
            System.out.println("no se pudo encontrar registros" + e.getMessage());
            Logger.getLogger(Cprincipal.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void ImprimirClientes() {
        Conectar con = new Conectar();
        try {
            String codigo = JOptionPane.showInputDialog("Escriba el estado de usuario");
            String nombre = JOptionPane.showInputDialog("Escriba el nombre del rol");
            JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/reportes/ConsultaUsuario.jasper"));

            Map<String, Object> map = new HashMap<String, Object>();

            map.put("codigor", codigo);
            map.put("nombrer", nombre);

            JasperPrint ja = (JasperPrint) JasperFillManager.fillReport(jas, map, con.getCon());
            JasperViewer jv = new JasperViewer(ja, false);
            jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jv.setVisible(true);
        } catch (JRException e) {
            System.out.println("no se pudo encontrar registros" + e.getMessage());
            Logger.getLogger(Cprincipal.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void ImprimirProductos() {
        Conectar con = new Conectar();
        try {
            int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Escriba le cantidad de stock que desea saber"));
            JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/reportes/producto.jasper"));

            Map<String, Object> map = new HashMap<String, Object>();

            map.put("cantidad", cantidad);

            JasperPrint ja = (JasperPrint) JasperFillManager.fillReport(jas, map, con.getCon());
            JasperViewer jv = new JasperViewer(ja, false);
            jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jv.setVisible(true);
        } catch (JRException e) {
            System.out.println("no se pudo encontrar registros" + e.getMessage());
            Logger.getLogger(Cprincipal.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
