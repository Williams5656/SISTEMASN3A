package Papeleria_Bella.controlador;

import Papeleria_Bella.vista.*;
import Papeleria_Bella.modelo.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Cventas {

    double Totalpagar = 0;
    public static Vventas vistav;
    private VentasBD bdventas = new VentasBD();
    private DetalleBD bddetalle = new DetalleBD();
    private ProductosMD productomd = new ProductosMD();
    private ProductosBD bdproducto = new ProductosBD();

    SimpleDateFormat fe = new SimpleDateFormat("dd-MM-yyyy");
    String CodigoProducto;
    double precio = 0;
    int cantidad = 0;
    int stock;
    double iva;
    int item = 0;

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public String getCodigoProducto() {
        return CodigoProducto;
    }

    public void setCodigoProducto(String CodigoProducto) {
        this.CodigoProducto = CodigoProducto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Cventas(Vventas vistav) {
        this.vistav = vistav;
        vistav.setVisible(true);
        vistav.setLocationRelativeTo(null);
        GenerarSerie();
        vistav.getLabelFecha().setText("" + LocalDate.now());
        vistav.getBtn_BuscarCedula().addActionListener(x -> BuscarCliente(vistav.getTxtbuscarcedula().getText()));
        vistav.getBtn_AgregarProducto().addActionListener(x -> AgregarProducto());
        vistav.getButtonbuscarnombreproducto().addActionListener(x -> BuscarProducto(vistav.getTxtBuscarProducto().getText()));

    }

    public void EliminarProducto() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo = (DefaultTableModel) vistav.getTablaventas().getModel();
        modelo.removeRow(vistav.getTablaventas().getSelectedRow());
        Totalpagar();
        vistav.getTxtbuscarcedula().requestFocus();
    }

    public void Guardar() {
        if (vistav.getTablaventas().getRowCount() > 0) {
            if (vistav.getTxtbuscarcedula().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debes buscar un cliente primero");
            } else {
                RegistrarVenta();
                RegistrarDetalle();
                ActualizarStock();
                LimpiarTabla();
                nuevo();
            }
        } else {
        }
    }

    public void BuscarCliente(String cedula) {

        if (vistav.getTxtbuscarcedula().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene el campo para realizar la busqueda", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            Conexion conectar = new Conexion();
            String sql = "Select nombres,apellidos from persona\n"
                    + "Where cedula=(Select cedula from clientes Where \"cedula\"='" + cedula + "')";
            ResultSet rs = conectar.query(sql);
            try {
                while (rs.next()) {
                    vistav.getLabelnombres().setText(rs.getString("nombres") + " " + rs.getString("apellidos"));

                }
            } catch (SQLException ex) {
                Logger.getLogger(VentasBD.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "ERROR: " + ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    public void BuscarProducto(String Producto) {

        if (vistav.getTxtbuscarcedula().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene el campo para realizar la busqueda", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            Conexion conectar = new Conexion();
            String sql = "Select * from producto\n"
                    + " where \"nombre\"='" + Producto + "'";
            ResultSet rs = conectar.query(sql);
            try {
                while (rs.next()) {
                    setCodigoProducto(rs.getString("codigo"));
                    setStock(Integer.parseInt(rs.getString("stock")));
                    vistav.getLabeliva().setText(rs.getString("iva"));
                    vistav.getLabelValorUnitario().setText(rs.getString("valorunitario"));
                    String porcentaje = rs.getString("iva");
                    porcentaje = porcentaje.replace("%", "");
                    setIva(Double.parseDouble(porcentaje));
                }
            } catch (SQLException ex) {
                Logger.getLogger(VentasBD.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "ERROR: " + ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    public void GenerarSerie() {
        String serie = bdventas.NroSerieVentas();
        if (serie == null) {
            vistav.getLabelSerieFactura().setText("000001");
        } else {
            int aumento = Integer.parseInt(serie);
            aumento = aumento + 1;
            vistav.getLabelSerieFactura().setText("00000" + aumento);
        }
    }

    public void AgregarProducto() {
        DefaultTableModel modelo;
        double total;
        modelo = (DefaultTableModel) vistav.getTablaventas().getModel();
        item = item + 1;
        String Articulo = vistav.getTxtBuscarProducto().getText();
        precio = Double.parseDouble(vistav.getLabelValorUnitario().getText());
        int Stock = getStock();
        cantidad = Integer.parseInt(vistav.getTxtCantidad().getValue().toString());
        precio = precio * (getIva() / 100) + precio;
        total = cantidad * precio;
        ArrayList listaProducto = new ArrayList();
        if (Stock > 0) {
            listaProducto.add(item);
            listaProducto.add(getCodigoProducto());
            listaProducto.add(Articulo);
            listaProducto.add(cantidad);
            listaProducto.add(precio);
            listaProducto.add(total);
            Object[] Item = new Object[6];
            Item[0] = listaProducto.get(0);
            Item[1] = listaProducto.get(1);
            Item[2] = listaProducto.get(2);
            Item[3] = listaProducto.get(3);
            Item[4] = listaProducto.get(4);
            Item[5] = listaProducto.get(5);
            modelo.addRow(Item);
            vistav.getTablaventas().setModel(modelo);
            Totalpagar();
            nuevo();
        } else {
            JOptionPane.showMessageDialog(null, "Producto Agotado", null, JOptionPane.ERROR_MESSAGE);
        }
    }

    public void nuevo() {
        GenerarSerie();
        vistav.getTxtbuscarcedula().setText("");
        vistav.getLabelnombres().setText("");
        vistav.getTxtBuscarProducto().setText("");
        vistav.getTxtCantidad().setValue(0);
        vistav.getLabelValorUnitario().setText("");
        vistav.getLabeliva().setText("");
        vistav.getLabelTotal().setText("");

    }

    public void LimpiarTabla() {
        DefaultTableModel tmp = new DefaultTableModel();
        tmp = (DefaultTableModel) vistav.getTablaventas().getModel();
        int fila = vistav.getTablaventas().getRowCount();
        for (int i = 0; i < fila; i++) {
            tmp.removeRow(0);
        }

    }

    private void Totalpagar() {
        Totalpagar = 0.00;
        int numFila = vistav.getTablaventas().getRowCount();
        for (int i = 0; i < numFila; i++) {
            double cal = Double.parseDouble(String.valueOf(vistav.getTablaventas().getModel().getValueAt(i, 5)));
            Totalpagar = Totalpagar + cal;
        }
        vistav.getLabelTotal().setText(String.format("%.2f", Totalpagar));
    }

    private void RegistrarVenta() {
        String cliente = vistav.getTxtbuscarcedula().getText();
        String numfactura = vistav.getLabelSerieFactura().getText();
        double monto = Totalpagar;
        bdventas.setNumfactura(numfactura);
        bdventas.setCedulacliente(cliente);
        bdventas.setFechaVenta(fe.format(vistav.getLabelFecha().getText()));
        bdventas.setMonto(monto);
        bdventas.setIdVentas(item);
        bdventas.setEstado(vistav.getCmbEstado().getSelectedItem().toString());
        if (bdventas.insertarventas()) {
            JOptionPane.showMessageDialog(null, "Datos guardados correctamente");

        } else {
            JOptionPane.showMessageDialog(null, "Error al guardar");

        }
    }

    private void RegistrarDetalle() {
        int id = bdventas.IdVenta();
        String codigoproductop = "";
        int cantidadp = 0;
        double preciou = 0;
        for (int i = 0; i < vistav.getTablaventas().getRowCount(); i++) {
            codigoproductop = vistav.getTablaventas().getValueAt(i, 0).toString();
            cantidadp = Integer.parseInt(vistav.getTablaventas().getValueAt(i, 2).toString());
            preciou = Double.parseDouble(vistav.getTablaventas().getValueAt(i, 3).toString());
        }
        bddetalle.setIdVentas(id);
        bddetalle.setIdProducto(codigoproductop);
        bddetalle.setCantidad(cantidadp);
        bddetalle.setPrecioVenta(preciou);
        if (bddetalle.insertardetalle()) {
            JOptionPane.showMessageDialog(null, "Datos guardados correctamente");

        } else {
            JOptionPane.showMessageDialog(null, "Error al guardar");

        }
    }

    private void ActualizarStock() {
        for (int i = 0; i < vistav.getTablaventas().getRowCount(); i++) {
            String id = vistav.getTablaventas().getValueAt(i, 0).toString();
            int cant = Integer.parseInt(vistav.getTablaventas().getValueAt(i, 2).toString());
            List<ProductosMD> producto = bdproducto.buscardatos(id);
            int StockActual = 0;
            for (int j = 0; j < producto.size(); j++) {
                StockActual = producto.get(j).getStock() - cant;
            }

            bddetalle.ActualizarStock(StockActual, id);

        }
    }
}
