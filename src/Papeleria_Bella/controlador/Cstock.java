
package Papeleria_Bella.controlador;

import Papeleria_Bella.modelo.Conexion;
import Papeleria_Bella.modelo.*;
import Papeleria_Bella.vista.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Cstock {
    public static Vstock vistastock;
    private StockBD bstock = new StockBD();
    
    public Cstock(Vstock vistastock) {
        this.vistastock = vistastock;
        vistastock.setVisible(true);
        vistastock.setLocationRelativeTo(null);

        GenerarCodStock();

        vistastock.getButtonguardar().addActionListener(x -> guardar());
        vistastock.getButtonmodificar().addActionListener(e -> modificar());

        vistastock.getTablastock().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }

        });

        vistastock.getButtonbuscar().addActionListener(x -> buscar());
        vistastock.getButtonnuevo().addActionListener(e -> nuevo());
        vistastock.getButtoneliminar().addActionListener(e -> eliminar());
        vistastock.getButtonguardar().setEnabled(false);
        vistastock.getButtonmodificar().setEnabled(false);
        

        vistastock.getLabelcodigoproducto().setEnabled(false);
        vistastock.getTxtstock().setEnabled(false);
        vistastock.getTxtnom_producto().setEnabled(false);

        lista();
    }
    public void lista() {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistastock.getTablastock().getModel();
        List<StockMD> lista = bstock.mostrardatos();
        int columnas = modelo.getColumnCount();
        for (int j = vistastock.getTablastock().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);
        }
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            vistastock.getTablastock().setValueAt(lista.get(i).getCodigo(), i, 0);
            vistastock.getTablastock().setValueAt(lista.get(i).getCodigo_producto(), i, 1);
            vistastock.getTablastock().setValueAt(lista.get(i).getStock(), i, 2);
            vistastock.getTablastock().setValueAt(lista.get(i).getNombre_producto(), i, 3);
            
        }
        nuevo();
    }

    public void guardar() {

        bstock.setCodigo(vistastock.getLabelcodigo().getText());
        bstock.setCodigo_producto(vistastock.getLabelcodigoproducto().getText());
        bstock.setStock(Integer.parseInt(vistastock.getTxtstock().getText()));
        bstock.setNombre_producto(vistastock.getTxtnom_producto().getText());
        

        if (bstock.insertar()) {
            JOptionPane.showMessageDialog(null, "EXITO AL GUARDAR");
            lista();
    
        vistastock.getLabelcodigoproducto().setEnabled(false);
        vistastock.getTxtstock().setEnabled(false);
        vistastock.getTxtnom_producto().setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
            lista();

        vistastock.getLabelcodigoproducto().setEnabled(false);
        vistastock.getTxtstock().setEnabled(false);
        vistastock.getTxtnom_producto().setEnabled(false);
        }

    }
    public void modificar() {
        bstock.setCodigo(vistastock.getLabelcodigo().getText());
        bstock.setCodigo_producto(vistastock.getLabelcodigoproducto().getText());
        bstock.setStock(Integer.parseInt(vistastock.getTxtstock().getText()));
        bstock.setNombre_producto(vistastock.getTxtnom_producto().getText());
        
        int resp = JOptionPane.showConfirmDialog(null, "Esta seguro de modificar");
        if (resp == 0) {
            if (bstock.modificar(vistastock.getLabelcodigo().getText())) ;
            JOptionPane.showMessageDialog(null, "Datos Actualizados");
            lista();

        
        vistastock.getLabelcodigoproducto().setEnabled(false);
        vistastock.getTxtstock().setEnabled(false);
        vistastock.getTxtnom_producto().setEnabled(false);
        }
    }

    public void seleccionar() {
        vistastock.getButtonguardar().setEnabled(false);
        vistastock.getButtonmodificar().setEnabled(true);

        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistastock.getTablastock().getModel();
        String codigo = (String) modelo.getValueAt(vistastock.getTablastock().getSelectedRow(), 0);
        List<StockMD> lista = bstock.obtenerdatos(codigo);
        bstock.setCodigo(lista.get(0).getCodigo());
        vistastock.getLabelcodigo().setText(bstock.getCodigo());
        bstock.setCodigo_producto(lista.get(0).getCodigo_producto());
        vistastock.getLabelcodigoproducto().setText(bstock.getCodigo_producto());
        bstock.setStock(lista.get(0).getStock());
        vistastock.getTxtstock().setText(String.valueOf(bstock.getStock()));
        bstock.setNombre_producto(lista.get(0).getNombre_producto());
        vistastock.getTxtnom_producto().setText(bstock.getNombre_producto());
        
 
        vistastock.getLabelcodigoproducto().setEnabled(true);
        vistastock.getTxtstock().setEnabled(true);
        vistastock.getTxtnom_producto().setEnabled(true);

    }

    public void eliminar() {
        bstock.setCodigo(vistastock.getLabelcodigo().getText());
        int resp = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar el item tal " + vistastock.getLabelcodigo().getText());
        if (resp == 0) {
            if (bstock.eliminar(vistastock.getLabelcodigo().getText())) ;
            JOptionPane.showMessageDialog(null, "Datos Actualizados");
            lista();

        vistastock.getLabelcodigoproducto().setEnabled(false);
        vistastock.getTxtstock().setEnabled(false);
        vistastock.getTxtnom_producto().setEnabled(false);
        }

    }
    public void nuevo() {
        vistastock.getLabelcodigo().setText("");
        vistastock.getLabelcodigoproducto().setText("");
        vistastock.getTxtstock().setText("");
        vistastock.getTxtnom_producto().setText("");
        vistastock.getButtonguardar().setEnabled(true);
        vistastock.getButtonmodificar().setEnabled(false);
        GenerarCodStock();
        
 
        vistastock.getLabelcodigoproducto().setEnabled(true);
        vistastock.getTxtstock().setEnabled(true);
        vistastock.getTxtnom_producto().setEnabled(true);
    }

    private void buscar() {
        if (vistastock.getTxtnom_producto().getText().equals("")) {
            lista();
        } else {

            java.util.List<ProductosMD> lista = bstock.buscardatos(vistastock.getTxtnom_producto().getText());
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getNombre().equals(vistastock.getTxtnom_producto().getText())) {
                    vistastock.getLabelcodigoproducto().setText(lista.get(i).getCodigo());
                } else {
                    JOptionPane.showMessageDialog(null, "Producto no registrado", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

    }

    public void GenerarCodStock() {
        char[] chars = "0123".toCharArray();

        int charsLength = chars.length;

        Random random = new Random();

        StringBuilder buffer = new StringBuilder();

        for (int i = 0; i < 3; i++) {

            buffer.append(chars[random.nextInt(charsLength)]);
        }

        vistastock.getLabelcodigo().setText("Prov" + buffer.toString());
    }   
}
