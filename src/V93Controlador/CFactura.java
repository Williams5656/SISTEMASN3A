package V93Controlador;

import V93Modelo.ClienteBD;
import V93Modelo.ClienteMb;
import V93Modelo.DetalleMb;
import V93Modelo.Eventos;
import V93Modelo.FacturaBD;
import V93Modelo.FacturaMb;
import V93Modelo.ProductoBD;
import V93Modelo.ProductoMb;
import V93Vista.VistaFactura;
import com.sun.glass.events.KeyEvent;
import java.util.ArrayList;
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
    DetalleMb detalle = new DetalleMb();

    Eventos event = new Eventos();

    public CFactura(VistaFactura VistaFac) {
        this.VistaFac = VistaFac;
        VistaFac.setVisible(true);
        VistaFac.setLocationRelativeTo(null);
        VistaFac.getTxtCodigoProFactura().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoProFacturaKeyPressed(evt);
            }

            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoProFacturaKeyTyped(evt);
            }
        });
        VistaFac.getTxtCedulaClienteFactura().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCedulaClienteFacturaKeyPressed(evt);
            }

            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaClienteFacturaKeyTyped(evt);
            }
        });
        VistaFac.getTxtDescripcionProFactura().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionProFacturaKeyTyped(evt);
            }
        });
        VistaFac.getTxtCantidadFactura().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadFacturaKeyPressed(evt);
            }
             public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadFacturaKeyTyped(evt);
            }
        });
        VistaFac.getTxtStockFactura().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStockFacturaKeyTyped(evt);
            }
        });
        VistaFac.getTxtPrecioFactura().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioFacturaKeyTyped(evt);
            }
        });
    }

    private void txtCedulaClienteFacturaKeyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!"".equals(VistaFac.getTxtCedulaClienteFactura().getText())) {

                cl = cliente.BuscarCliente(VistaFac.getTxtCedulaClienteFactura().getText());
                if (cl.getNombre() != null) {
                    VistaFac.getTxtNombreClienteFactura().setText("" + cl.getNombre());

                } else {
                    VistaFac.getTxtCedulaClienteFactura().setText("");
                    JOptionPane.showMessageDialog(null, "El Cliente no Existe");
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
                String cod = VistaFac.getTxtCodigoProFactura().getText();
                pro = proDao.BuscarPro(cod);
                if (pro.getDescripcion() != null) {
                    VistaFac.getTxtDescripcionProFactura().setText("" + pro.getDescripcion());
                    VistaFac.getTxtPrecioFactura().setText("" + pro.getPrecio());
                    VistaFac.getTxtStockFactura().setText("" + pro.getStock());
                    VistaFac.getTxtCantidadFactura().requestFocus();

                } else {
                    LimpiarVenta();
                    VistaFac.getTxtCodigoProFactura().requestFocus();

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
        double iva=0.12;
        if (evt.getKeyCode()== KeyEvent.VK_ENTER){
            if(!"".equals(VistaFac.getTxtCantidadFactura().getText())){
                String cod = VistaFac.getTxtCodigoProFactura().getText();
                String descripcion = VistaFac.getTxtDescripcionProFactura().getText();
                int cant = Integer.parseInt(VistaFac.getTxtCantidadFactura().getText());
                double precio = Double.parseDouble(VistaFac.getTxtPrecioFactura().getText());
                double total = cant * precio * iva;
                int stock = Integer.parseInt(VistaFac.getTxtStockFactura().getText());
                if(stock>= cant){
                    item = item + 1;
                    DefaultTableModel  tmp = (DefaultTableModel) VistaFac.getTableFactura().getModel();
                    for(int i=0; i<VistaFac.getTableFactura().getRowCount();i++){
                        if(VistaFac.getTableFactura().getValueAt(i, 1).equals(VistaFac.getTxtDescripcionProFactura().getText())){
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
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Stock no disponible");
                }
                
            }else{
               JOptionPane.showMessageDialog(null, "Ingrese la Cantidad"); 
            }
        }
    }
      private void  Totalpagar(){
         Totalpagar = 0.00;
         int numFila = VistaFac.getTableFactura().getRowCount();
         for (int i = 0; i< numFila; i++){
             double cal = Double.parseDouble(String.valueOf(VistaFac.getTableFactura().getModel().getValueAt(i, 4)));
             Totalpagar = Totalpagar + cal;
         }
         VistaFac.getLabelTotalaPagar().setText(String.format("%.2f",Totalpagar));
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
          private void btnGenerarFacturaActionPerformed(java.awt.event.ActionEvent evt) { 
//                if(VistaFac.getTableFactura().getRowCount()> 0){
//            if(!"".equals(VistaFac.getTxtNombreClienteFactura().getText())){
//                RegistrarVenta();
//                RegistrarDetalle();
//                ActualizarStock();
//                pdf();
//                LimpiarTableVenta();
//                LimpiarClienteVenta();
//                
//            }else{
//                JOptionPane.showMessageDialog(null, "Debes buscar un Cliente");
//            }
//        }else{
//                JOptionPane.showMessageDialog(null, "No existen Productos en la Venta");
//            
//        }
        
    } 
               private void RegistrarVenta(){
         String cliente = VistaFac.getTxtNombreClienteFactura().getText();
         
         double monto = Totalpagar;
         v.setCliente(cliente);
         v.setTotal(monto);
         Vdao.RegistrarVenta(v);
         
     }
     
//     private void RegistrarDetalle(){
//         int id = Vdao.IdVenta();
//         for(int i = 0; i<txtTableVenta.getRowCount(); i++){
//             int cod = Integer.parseInt(txtTableVenta.getValueAt(i, 0).toString());
//             int cant = Integer.parseInt(txtTableVenta.getValueAt(i, 2).toString());
//             double precio = Double.parseDouble(txtTableVenta.getValueAt(i, 3).toString());
//             Dv.setCod_pro(cod);
//             Dv.setCantidad(cant);
//             Dv.setPrecio(precio);
//             Dv.setId(id);
//             Vdao.RegistrarDetalle(Dv);
//         }
//     }
//     
//     private void ActualizarStock(){
//         for(int i = 0; i <txtTableVenta.getRowCount(); i++){
//         String cod = txtTableVenta.getValueAt(i, 0).toString();
//         int cant = Integer.parseInt(txtTableVenta.getValueAt(i, 2).toString());
//         pro = proDao.BuscarPro(cod);
//         int StockActual = pro.getStock() - cant;
//         Vdao.ActualizarStock(StockActual, cod);
//         
//     }
//     }
//     
//     private void LimpiarTableVenta(){
//         tmp = (DefaultTableModel)txtTableVenta.getModel();
//         int fila = txtTableVenta.getRowCount();
//         for(int i = 0; i<fila; i++){
//             tmp.removeRow(0);
//         }
//         
//     }
//     
//     private void LimpiarClienteVenta(){
//        txtRucVenta.setText("");
//        txtNombreClienteVenta.setText("");
//        txtTelefonoClienteVenta.setText("");
//        txtDireccionClienteVenta.setText("");
//        txtRazonClienteVenta.setText("");
//     }
}
