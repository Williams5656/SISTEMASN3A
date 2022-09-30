package V93Controlador;

import V93Modelo.ClienteBD;
import V93Modelo.ClienteMb;
import V93Modelo.DetalleBD;
import V93Modelo.DetalleMb;
import V93Modelo.Eventos;
import V93Modelo.FacturaBD;
import V93Modelo.FacturaMb;
import V93Modelo.ProductoBD;
import V93Modelo.ProductoMb;
import V93Vista.VistaFactura;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CFactura {

    public static VistaFactura VistaFac;

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
    DetalleBD bddetalle = new DetalleBD();
    DefaultTableModel tmp = new DefaultTableModel();
    Eventos event = new Eventos();
    DefaultTableModel modelo = new DefaultTableModel();

    public CFactura(VistaFactura VistaFac) {
        this.VistaFac = VistaFac;
        VistaFac.setVisible(true);
        VistaFac.setLocationRelativeTo(null);
        // lista();
        VistaFac.getTxtCodigoProFactura().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoProFacturaKeyPressed(evt);
            }

            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoProFacturaKeyTyped(evt);
            }
        });
        VistaFac.getTxtCedulaClienteFactura().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCedulaClienteFacturaKeyPressed(evt);
            }

            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaClienteFacturaKeyTyped(evt);
            }
        });
        VistaFac.getTxtDescripcionProFactura().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionProFacturaKeyTyped(evt);
            }
        });
        VistaFac.getTxtCantidadFactura().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadFacturaKeyPressed(evt);
            }

            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadFacturaKeyTyped(evt);
            }
        });
        VistaFac.getTxtStockFactura().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStockFacturaKeyTyped(evt);
            }
        });
        VistaFac.getTxtPrecioFactura().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioFacturaKeyTyped(evt);
            }
        });

        VistaFac.getBtnGenerarFactura().addActionListener(x -> btnGenerarFacturaActionPerformed());

        VistaFac.getBtnEliminarFactura().addActionListener(e -> btnEliminarFacturaActionPerformed());

    }

    private void txtCedulaClienteFacturaKeyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!"".equals(VistaFac.getTxtCedulaClienteFactura().getText())) {

                List<ClienteMb> cl = cliente.BuscarCliente(VistaFac.getTxtCedulaClienteFactura().getText());
                for (int i = 0; i < cl.size(); i++) {
                    if (cl.get(i).getNombre() != null) {
                        VistaFac.getTxtNombreClienteFactura().setText("" + cl.get(i).getNombre());

                    } else {
                        VistaFac.getTxtCedulaClienteFactura().setText("");
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
            if (!"".equals(VistaFac.getTxtCodigoProFactura().getText())) {
                List<ProductoMb> pro = proDao.BuscarPro(VistaFac.getTxtCodigoProFactura().getText());
                for (int i = 0; i < pro.size(); i++) {
                    if (pro.get(i).getDescripcion() != null) {
                        VistaFac.getTxtDescripcionProFactura().setText("" + pro.get(i).getDescripcion());
                        VistaFac.getTxtPrecioFactura().setText("" + pro.get(i).getPrecio());
                        VistaFac.getTxtStockFactura().setText("" + pro.get(i).getStock());
                        VistaFac.getTxtCantidadFactura().requestFocus();

                    } else {
                        LimpiarVenta();
                        VistaFac.getTxtCodigoProFactura().requestFocus();

                    }

                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrse el Codigo del Producto");
                VistaFac.getTxtCodigoProFactura().requestFocus();
            }
        }
    }

    private void LimpiarVenta() {

        VistaFac.getTxtCodigoProFactura().setText("");
        VistaFac.getTxtDescripcionProFactura().setText("");
        VistaFac.getTxtCantidadFactura().setText("");
        VistaFac.getTxtStockFactura().setText("");
        VistaFac.getTxtPrecioFactura().setText("");
    }

    private void txtCantidadFacturaKeyPressed(java.awt.event.KeyEvent evt) {
        double iva = 1.12;
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!"".equals(VistaFac.getTxtCantidadFactura().getText())) {
                String cod = VistaFac.getTxtCodigoProFactura().getText();
                String descripcion = VistaFac.getTxtDescripcionProFactura().getText();
                int cant = Integer.parseInt(VistaFac.getTxtCantidadFactura().getText());
                double precio = Double.parseDouble(VistaFac.getTxtPrecioFactura().getText());
                double total = cant * precio * iva;
                int stock = Integer.parseInt(VistaFac.getTxtStockFactura().getText());
                if (stock >= cant) {
                    item = item + 1;
                    DefaultTableModel tmp = (DefaultTableModel) VistaFac.getTableFactura().getModel();
                    for (int i = 0; i < VistaFac.getTableFactura().getRowCount(); i++) {
                        if (VistaFac.getTableFactura().getValueAt(i, 1).equals(VistaFac.getTxtDescripcionProFactura().getText())) {
                            JOptionPane.showMessageDialog(null, "El Producto ya esta registrado");
                            return;
                        }
                    }

                    ArrayList lista = new ArrayList();
                    lista.add(item);
                    lista.add(cod);
                    lista.add(descripcion);
                    lista.add(cant);
                    lista.add(precio);
                    lista.add(total);
                    Object[] o = new Object[5];
                    o[0] = lista.get(1);
                    o[1] = lista.get(2);
                    o[2] = lista.get(3);
                    o[3] = lista.get(4);
                    o[4] = lista.get(5);
                    tmp.addRow(o);
                    VistaFac.getTableFactura().setModel(tmp);
                    Totalpagar();
                    LimpiarVenta();
                    VistaFac.getTxtCodigoProFactura().requestFocus();

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
        int numFila = VistaFac.getTableFactura().getRowCount();
        for (int i = 0; i < numFila; i++) {
            double cal = Double.parseDouble(String.valueOf(VistaFac.getTableFactura().getModel().getValueAt(i, 4)));
            Totalpagar = Totalpagar + cal;
        }
        VistaFac.getLabelTotalaPagar().setText(String.format("%.2f", Totalpagar));
    }

    private void txtCantidadFacturaKeyTyped(java.awt.event.KeyEvent evt) {
        event.numberKeyPress(evt);
    }

    private void txtPrecioFacturaKeyTyped(java.awt.event.KeyEvent evt) {
        event.numberDecimalKeyPress(evt, VistaFac.getTxtPrecioFactura());
    }

    private void txtStockFacturaKeyTyped(java.awt.event.KeyEvent evt) {
        event.numberKeyPress(evt);
    }

    private void btnEliminarFacturaActionPerformed() {

        modelo = (DefaultTableModel) VistaFac.getTableFactura().getModel();
        modelo.removeRow(VistaFac.getTableFactura().getSelectedRow());
        Totalpagar();
        VistaFac.getTxtCodigoProFactura().requestFocus();
    }

    private void btnGenerarFacturaActionPerformed() {
        if (VistaFac.getTableFactura().getRowCount() > 0) {
            if (!"".equals(VistaFac.getTxtNombreClienteFactura().getText())) {
                RegistrarVenta();
                RegistrarDetalle();
                ActualizarStock();

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

        bdfactura.setCliente(VistaFac.getTxtNombreClienteFactura().getText());
        bdfactura.setVendedor(VistaFac.getLabelVendedorFactura().getText());
        bdfactura.setTotal(Double.parseDouble(VistaFac.getLabelTotalaPagar().getText()));
        if (bdfactura.insertar()) {
            JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
//                   nuevo();

        } else {
            JOptionPane.showMessageDialog(null, "Error al guardar");

        }

    }

    private void RegistrarDetalle() {

        int id = bddetalle.IdVenta();
        String cod = "";
        int cant = 0;
        double precio = 0;
        for (int i = 0; i < VistaFac.getTableFactura().getRowCount(); i++) {
            cod = VistaFac.getTableFactura().getValueAt(i, 0).toString();
            cant = Integer.parseInt(VistaFac.getTableFactura().getValueAt(i, 2).toString());
            precio = Double.parseDouble(VistaFac.getTableFactura().getValueAt(i, 3).toString());

        }

        bddetalle.setCod_pro(cod);
        bddetalle.setCantidad(cant);
        bddetalle.setPrecio(precio);
        bddetalle.setId_venta(id);

//       bddetalle.setId_venta(Integer.parseInt(VistaFac.getTxtCantidadFactura().getText()));
        if (bddetalle.RegistrarDetalle()) {
            JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
//                   nuevo();

        } else {
            JOptionPane.showMessageDialog(null, "Error al guardar");

        }

//        int id = bddetalle.IdVenta();
//        for (int i = 0; i < VistaFac.getTableFactura().getRowCount(); i++) {
//            int cod = Integer.parseInt(VistaFac.getTableFactura().getValueAt(i, 0).toString());
//            int cant = Integer.parseInt(VistaFac.getTableFactura().getValueAt(i, 2).toString());
//            double precio = Double.parseDouble(VistaFac.getTableFactura().getValueAt(i, 3).toString());
//            Dv.setCod_pro(cod);
//            Dv.setCantidad(cant);
//            Dv.setPrecio(precio);
//            Dv.setId(id);
//            bddetalle.RegistrarDetalle(Dv);
//        }
    }

    private void ActualizarStock() {
        for (int i = 0; i < VistaFac.getTableFactura().getRowCount(); i++) {
            String cod = VistaFac.getTableFactura().getValueAt(i, 0).toString();
            int cant = Integer.parseInt(VistaFac.getTableFactura().getValueAt(i, 2).toString());
            List<ProductoMb> pro = proDao.BuscarPro(cod);
            for (int j = 0; j < pro.size(); j++) {
                int StockActual = pro.get(j).getStock() - cant;
                Vdao.ActualizarStock(StockActual, cod);
            }

        }
    }
//     

    private void LimpiarTableVenta() {
        tmp = (DefaultTableModel) VistaFac.getTableFactura().getModel();
        int fila = VistaFac.getTableFactura().getRowCount();
        for (int i = 0; i < fila; i++) {
            tmp.removeRow(0);
        }
//         
    }

    private void LimpiarClienteVenta() {
        VistaFac.getTxtCedulaClienteFactura().setText("");
        VistaFac.getTxtNombreClienteFactura().setText("");
//        VistaFac.gettxtTelefonoClienteVenta.setText("");
//        VistaFac.gettxtDireccionClienteFactura.setText("");
//        VistaFac.gettxtRazonClienteFactura.setText("");
    }
}
