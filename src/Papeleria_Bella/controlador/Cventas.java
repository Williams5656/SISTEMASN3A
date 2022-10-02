package Papeleria_Bella.controlador;

import Papeleria_Bella.vista.*;
import Papeleria_Bella.modelo.*;
import static Papeleria_Bella.modelo.VentasBD.vistav;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Cventas {

    double Totalpagar = 0;
    public static Vventas vistav;
    private VentasBD bventas = new VentasBD();
    final double iva = 0.12;
    String CodigoProducto;
    double PrecioP;
    double precio = 0;
    int cantidad = 0;
    int stock;

    public double getPrecioP() {
        return PrecioP;
    }

    public void setPrecioP(double PrecioP) {
        this.PrecioP = PrecioP;
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
                    +  " where \"nombre\"='" + Producto + "'";
            ResultSet rs = conectar.query(sql);
            try {
                while (rs.next()) {
                    setCodigoProducto(rs.getString("codigo"));
                    setPrecioP(Double.parseDouble(rs.getString("valorunitario")));
                    setStock(Integer.parseInt(rs.getString("stock")));
                    vistav.getLabeliva().setText(rs.getString("iva"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(VentasBD.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "ERROR: " + ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    public void GenerarSerie() {
        String serie = bventas.NroSerieVentas();
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
        int item = 0;
        modelo = (DefaultTableModel) vistav.getTablaventas().getModel();
        item = item + 1;
        vistav.getLabelValorUnitario().setText(String.valueOf(getPrecioP()));
        String Articulo = vistav.getTxtBuscarProducto().getText();
        precio = Double.parseDouble(vistav.getLabelValorUnitario().getText());
        int Stock = getStock();
        cantidad = Integer.parseInt(vistav.getTxtCantidad().getValue().toString());
        precio = precio * 0.12 + precio;
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
        } else {
            JOptionPane.showMessageDialog(null, "Producto Agotado", null, JOptionPane.ERROR_MESSAGE);
        }
    }

    private void Totalpagar() {
        Totalpagar = 0.00;
        int numFila = vistav.getTablaventas().getRowCount();
        for (int i = 0; i < numFila; i++) {
            double cal = Double.parseDouble(String.valueOf(vistav.getTablaventas().getModel().getValueAt(i, 4)));
            Totalpagar = Totalpagar + cal;
        }
        vistav.getLabelTotal().setText(String.format("%.2f", Totalpagar));
    }

    public void nuevo() {

    }
}
