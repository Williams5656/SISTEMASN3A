package V93Controlador;

import V93Modelo.ClienteBD;
import V93Modelo.ClienteMb;
import V93Modelo.Conectar;
import V93Modelo.CotizacionBD;
import V93Modelo.DetalleMb;
import V93Modelo.Eventos;
import V93Modelo.FacturaBD;
import V93Modelo.FacturaMb;
import V93Modelo.ProductoBD;
import V93Modelo.ProductoMb;
import V93Vista.VistaCotizacion;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class CCotizacion {

    public static VistaCotizacion VistaCotizacion;

    private FacturaBD bdfactura = new FacturaBD();
    ProductoMb pro = new ProductoMb();
    ProductoBD proDao = new ProductoBD();
    ClienteMb cl = new ClienteMb();
    ClienteBD cliente = new ClienteBD();
    int item;
    double Totalpagar;
    FacturaMb v = new FacturaMb();
    FacturaBD Vdao = new FacturaBD();
    DetalleMb Dv = new DetalleMb();
    DefaultTableModel tmp = new DefaultTableModel();
    Eventos event = new Eventos();
    DefaultTableModel modelo = new DefaultTableModel();
    List<Object> listadetalle = new ArrayList();
    CotizacionBD bdcotizacion = new CotizacionBD();

    public CCotizacion(VistaCotizacion Vista) {
        this.VistaCotizacion = Vista;
        Vista.setVisible(true);
        Vista.setLocationRelativeTo(null);
        Vista.getTxtCodigoProFactura().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoProFacturaKeyPressed(evt);
            }

            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoProFacturaKeyTyped(evt);
            }
        });
        Vista.getTxtCedulaClienteFactura().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCedulaClienteFacturaKeyPressed(evt);
            }

            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaClienteFacturaKeyTyped(evt);
            }
        });
        Vista.getTxtDescripcionProFactura().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionProFacturaKeyTyped(evt);
            }
        });
        Vista.getTxtCantidadFactura().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadFacturaKeyPressed(evt);
            }

            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadFacturaKeyTyped(evt);
            }
        });
        Vista.getTxtStockFactura().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStockFacturaKeyTyped(evt);
            }
        });
        Vista.getTxtPrecioFactura().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioFacturaKeyTyped(evt);
            }
        });

        Vista.getBtnGenerarFactura().addActionListener(x -> btnGenerarFacturaActionPerformed());

        Vista.getBtnEliminarFactura().addActionListener(e -> btnEliminarFacturaActionPerformed());
    }

    private void txtCedulaClienteFacturaKeyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!"".equals(VistaCotizacion.getTxtCedulaClienteFactura().getText())) {

                List<ClienteMb> cl = cliente.BuscarCliente(VistaCotizacion.getTxtCedulaClienteFactura().getText());
                for (int i = 0; i < cl.size(); i++) {
                    if (cl.get(i).getNombre() != null) {
                        VistaCotizacion.getTxtNombreClienteFactura().setText("" + cl.get(i).getNombre());

                    } else {
                        VistaCotizacion.getTxtCedulaClienteFactura().setText("");
                        JOptionPane.showMessageDialog(null, "El Cliente no Existe");
                    }

                }
            }
        }
    }

    private void txtDescripcionProFacturaKeyTyped(java.awt.event.KeyEvent evt) {
        event.textKeyPress(evt);
    }

    private void txtCedulaClienteFacturaKeyTyped(java.awt.event.KeyEvent evt) {
        event.numberKeyPress(evt);
    }

    private void txtCodigoProFacturaKeyTyped(java.awt.event.KeyEvent evt) {
        event.numberKeyPress(evt);
    }

    private void txtCodigoProFacturaKeyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!"".equals(VistaCotizacion.getTxtCodigoProFactura().getText())) {
                List<ProductoMb> pro = proDao.BuscarPro(VistaCotizacion.getTxtCodigoProFactura().getText());
                for (int i = 0; i < pro.size(); i++) {
                    if (pro.get(i).getDescripcion() != null) {
                        VistaCotizacion.getTxtDescripcionProFactura().setText("" + pro.get(i).getDescripcion());
                        VistaCotizacion.getTxtPrecioFactura().setText("" + pro.get(i).getPrecio());
                        VistaCotizacion.getTxtStockFactura().setText("" + pro.get(i).getStock());
                        VistaCotizacion.getTxtCantidadFactura().requestFocus();

                    } else {
                        LimpiarVenta();
                        VistaCotizacion.getTxtCodigoProFactura().requestFocus();

                    }

                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrse el Codigo del Producto");
                VistaCotizacion.getTxtCodigoProFactura().requestFocus();
            }
        }
    }

    private void LimpiarVenta() {

        VistaCotizacion.getTxtCodigoProFactura().setText("");
        VistaCotizacion.getTxtDescripcionProFactura().setText("");
        VistaCotizacion.getTxtCantidadFactura().setText("");
        VistaCotizacion.getTxtStockFactura().setText("");
        VistaCotizacion.getTxtPrecioFactura().setText("");
    }

    private void txtCantidadFacturaKeyPressed(java.awt.event.KeyEvent evt) {
        double iva = 1.12;
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!"".equals(VistaCotizacion.getTxtCantidadFactura().getText())) {
                String cod = VistaCotizacion.getTxtCodigoProFactura().getText();
                String descripcion = VistaCotizacion.getTxtDescripcionProFactura().getText();
                int cant = Integer.parseInt(VistaCotizacion.getTxtCantidadFactura().getText());
                double precio = Double.parseDouble(VistaCotizacion.getTxtPrecioFactura().getText());
                double total = cant * precio * iva;
                int stock = Integer.parseInt(VistaCotizacion.getTxtStockFactura().getText());
                if (stock >= cant) {
                    item = item + 1;
                    DefaultTableModel tmp = (DefaultTableModel) VistaCotizacion.getTableFactura().getModel();
                    for (int i = 0; i < VistaCotizacion.getTableFactura().getRowCount(); i++) {
                        if (VistaCotizacion.getTableFactura().getValueAt(i, 1).equals(VistaCotizacion.getTxtDescripcionProFactura().getText())) {
                            JOptionPane.showMessageDialog(null, "El Producto ya esta registrado");
                            return;
                        }
                    }

                    listadetalle.add(item);
                    listadetalle.add(cod);
                    listadetalle.add(descripcion);
                    listadetalle.add(cant);
                    listadetalle.add(precio);
                    listadetalle.add(total);
                    Object[] o = new Object[5];
                    o[0] = listadetalle.get(1);
                    o[1] = listadetalle.get(2);
                    o[2] = listadetalle.get(3);
                    o[3] = listadetalle.get(4);
                    o[4] = listadetalle.get(5);
                    tmp.addRow(o);
                    VistaCotizacion.getTableFactura().setModel(tmp);
                    Totalpagar();
                    LimpiarVenta();
                    VistaCotizacion.getTxtCodigoProFactura().requestFocus();

                } else {
                    JOptionPane.showMessageDialog(null, "Stock no disponible");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Ingrese la Cantidad");
            }
        }
    }

    private void Totalpagar() {
        Totalpagar = 0.00;
        int numFila = VistaCotizacion.getTableFactura().getRowCount();
        for (int i = 0; i < numFila; i++) {
            double cal = Double.parseDouble(String.valueOf(VistaCotizacion.getTableFactura().getModel().getValueAt(i, 4)));
            Totalpagar = Totalpagar + cal;
        }
        VistaCotizacion.getLabelTotalaPagar().setText(String.format("%.2f", Totalpagar));
    }

    private void txtCantidadFacturaKeyTyped(java.awt.event.KeyEvent evt) {
        event.numberKeyPress(evt);
    }

    private void txtPrecioFacturaKeyTyped(java.awt.event.KeyEvent evt) {
        event.numberDecimalKeyPress(evt, VistaCotizacion.getTxtPrecioFactura());
    }

    private void txtStockFacturaKeyTyped(java.awt.event.KeyEvent evt) {
        event.numberKeyPress(evt);
    }

    private void btnEliminarFacturaActionPerformed() {

        modelo = (DefaultTableModel) VistaCotizacion.getTableFactura().getModel();
        modelo.removeRow(VistaCotizacion.getTableFactura().getSelectedRow());
        Totalpagar();
        VistaCotizacion.getTxtCodigoProFactura().requestFocus();
    }

    private void btnGenerarFacturaActionPerformed() {
        if (VistaCotizacion.getTableFactura().getRowCount() > 0) {
            if (!"".equals(VistaCotizacion.getTxtNombreClienteFactura().getText())) {
                Conectar con = new Conectar();
                try {
                    String vendedor = VistaCotizacion.getLabelVendedorFactura().getText();
                    String codigo = "";
                    String cantidad = "";
                    String precio = "";
                    String total = "";
                    for (int i = 0; i < VistaCotizacion.getTableFactura().getRowCount(); i++) {
                        codigo = VistaCotizacion.getTableFactura().getValueAt(i, 0).toString();
                        cantidad = VistaCotizacion.getTableFactura().getValueAt(i, 2).toString();
                        precio = VistaCotizacion.getTableFactura().getValueAt(i, 3).toString();
                        total = VistaCotizacion.getTableFactura().getValueAt(i, 4).toString();
                    }
                    bdcotizacion.setCliente(VistaCotizacion.getTxtNombreClienteFactura().getText());
                    bdcotizacion.setProducto(codigo);
                    bdcotizacion.setCantidad(Integer.parseInt(cantidad));
                    bdcotizacion.setPrecio(Double.parseDouble(precio));
                    bdcotizacion.setTotal(Double.parseDouble(total));
                    if (bdcotizacion.RegistrarCotizacion()) {
                        JOptionPane.showMessageDialog(null, "EXITO AL GUARDAR");
                    } else {
                        JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
                    }

                    JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/reportes/Cotizacion.jasper"));
                    System.out.println(codigo);
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("vendedor", vendedor);
                    JasperPrint ja = (JasperPrint) JasperFillManager.fillReport(jas, map, con.getCon());
                    JasperViewer jv = new JasperViewer(ja, false);
                    jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    jv.setVisible(true);
                } catch (JRException e) {
                    System.out.println("no se pudo encontrar registros" + e.getMessage());
                    Logger.getLogger(CCotizacion.class.getName()).log(Level.SEVERE, null, e);
                }
                LimpiarTableVenta();
                LimpiarClienteVenta();

            } else {
                JOptionPane.showMessageDialog(null, "Debes buscar un Cliente");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No existen Productos en la Venta");

        }

    }

    private void RegistrarVenta() {
        bdfactura.setCliente(VistaCotizacion.getLabelVendedorFactura().getText());
        bdfactura.setVendedor(VistaCotizacion.getTxtNombreClienteFactura().getText());
        bdfactura.setTotal(Double.parseDouble(VistaCotizacion.getLabelTotalaPagar().getText()));

    }

//     
    private void ActualizarStock() {
        for (int i = 0; i < VistaCotizacion.getTableFactura().getRowCount(); i++) {
            String cod = VistaCotizacion.getTableFactura().getValueAt(i, 0).toString();
            int cant = Integer.parseInt(VistaCotizacion.getTableFactura().getValueAt(i, 2).toString());
            List<ProductoMb> pro = proDao.BuscarPro(cod);
            for (int j = 0; j < pro.size(); j++) {
                int StockActual = pro.get(i).getStock() - cant;
                Vdao.ActualizarStock(StockActual, cod);
            }

        }
    }
//     

    private void LimpiarTableVenta() {
        tmp = (DefaultTableModel) VistaCotizacion.getTableFactura().getModel();
        int fila = VistaCotizacion.getTableFactura().getRowCount();
        for (int i = 0; i < fila; i++) {
            tmp.removeRow(0);
        }
//         
    }

    private void LimpiarClienteVenta() {
        VistaCotizacion.getTxtCedulaClienteFactura().setText("");
        VistaCotizacion.getTxtNombreClienteFactura().setText("");
//        VistaFac.gettxtTelefonoClienteVenta.setText("");
//        VistaFac.gettxtDireccionClienteFactura.setText("");
//        VistaFac.gettxtRazonClienteFactura.setText("");
    }
}
