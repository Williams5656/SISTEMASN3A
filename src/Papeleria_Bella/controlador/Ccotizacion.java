
package Papeleria_Bella.controlador;
import Papeleria_Bella.vista.*;
import Papeleria_Bella.modelo.*;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Ccotizacion {
    public static Vcotizacion vistacot;
    private CotizacionBD bcotizacion = new CotizacionBD();
    
    public Ccotizacion(Vcotizacion vistacot) {
        this.vistacot = vistacot;
        vistacot.setVisible(true);
        vistacot.setLocationRelativeTo(null);
        lista();
        vistacot.getButtonguardar().addActionListener(x -> guardar());
        vistacot.getButtonmodificar().addActionListener(e -> modificar());
//        vistacot.getButtonbuscarproducto().addActionListener(e -> Buscarproducto());
//        vistacot.getButtonbuscarfactura().addActionListener(e -> Buscarfactura());
//        vistacot.getButtonimprimir().addActionListener(e -> imprimir());
        vistacot.getTablacotizacion().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }

        });

        vistacot.getButtonnuevo().addActionListener(e -> nuevo());
        vistacot.getButtoneliminar().addActionListener(e -> eliminar());
        vistacot.getButtonguardar().setEnabled(false);
        vistacot.getButtonmodificar().setEnabled(false);
        vistacot.getTxtcedula().setEnabled(false);
        vistacot.getTxtnombreproducto().setEnabled(false);
        vistacot.getTxtcantidad().setEnabled(false);
        vistacot.getTxttotal().setEnabled(false);

    }

    public void lista() {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistacot.getTablacotizacion().getModel();
        List<CotizacionMD> lista = bcotizacion.mostrardatos();
        int columnas = modelo.getColumnCount();
        for (int j = vistacot.getTablacotizacion().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);
        }
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            vistacot.getTablacotizacion().setValueAt(lista.get(i).getCodigo(), i, 0);
            vistacot.getTablacotizacion().setValueAt(lista.get(i).getCedula(), i, 1);
            vistacot.getTablacotizacion().setValueAt(lista.get(i).getCodigoproductos(), i, 2);
            vistacot.getTablacotizacion().setValueAt(lista.get(i).getNombreproductos(), i, 3);
            vistacot.getTablacotizacion().setValueAt(lista.get(i).getCantidad(), i, 4);
            vistacot.getTablacotizacion().setValueAt(lista.get(i).getValorunitario(), i, 5);
            vistacot.getTablacotizacion().setValueAt(lista.get(i).getIva(), i, 6);
            vistacot.getTablacotizacion().setValueAt(lista.get(i).getTotal(), i, 7);
        }
    }
    
    public void guardar() {
        bcotizacion.setCodigo(vistacot.getLabelcodigo().getText());
        bcotizacion.setCedula(vistacot.getTxtcedula().getText());
        bcotizacion.setCodigoproductos(vistacot.getLabelcodigoproducto().getText());
        bcotizacion.setNombreproductos(vistacot.getTxtnombreproducto().getText());
        bcotizacion.setCantidad(Integer.parseInt(vistacot.getTxtcantidad().getText()));
        bcotizacion.setValorunitario(Integer.parseInt(vistacot.getLabelvaloru().getText()));
        bcotizacion.setIva(vistacot.getLabeliva().getText());
        bcotizacion.setTotal(Integer.parseInt(vistacot.getTxttotal().getText()));
        if (bcotizacion.insertar()) {
            JOptionPane.showMessageDialog(null, "EXITO AL GUARDAR");
            lista();
        vistacot.getTxtcedula().setEnabled(false);
        vistacot.getTxtnombreproducto().setEnabled(false);
        vistacot.getTxtcantidad().setEnabled(false);
        vistacot.getTxttotal().setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
            lista();
            
        vistacot.getTxtcedula().setEnabled(false);
        vistacot.getTxtnombreproducto().setEnabled(false);
        vistacot.getTxtcantidad().setEnabled(false);
        vistacot.getTxttotal().setEnabled(false);
        }
        
    }

    public void modificar() {
        bcotizacion.setCodigo(vistacot.getLabelcodigo().getText());
        bcotizacion.setCedula(vistacot.getTxtcedula().getText());
        bcotizacion.setCodigoproductos(vistacot.getLabelcodigoproducto().getText());
        bcotizacion.setNombreproductos(vistacot.getTxtnombreproducto().getText());
        bcotizacion.setCantidad(Integer.parseInt(vistacot.getTxtcantidad().getText()));
        bcotizacion.setValorunitario(Integer.parseInt(vistacot.getLabelvaloru().getText()));
        bcotizacion.setIva(vistacot.getLabeliva().getText());
        bcotizacion.setTotal(Integer.parseInt(vistacot.getTxttotal().getText()));

        int resp = JOptionPane.showConfirmDialog(null, "Esta seguro de modificar");
        if (resp == 0) {
            if (bcotizacion.modificar(vistacot.getLabelcodigo().getText())) ;
            JOptionPane.showMessageDialog(null, "Datos Actualizados");
            lista();
            nuevo();
            
        vistacot.getTxtcedula().setEnabled(false);
        vistacot.getTxtnombreproducto().setEnabled(false);
        vistacot.getTxtcantidad().setEnabled(false);
        vistacot.getTxttotal().setEnabled(false);

        }
    }

    public void seleccionar() {
        vistacot.getButtonguardar().setEnabled(false);
        vistacot.getButtonmodificar().setEnabled(true);
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistacot.getTablacotizacion().getModel();
        String codigo = (String) modelo.getValueAt(vistacot.getTablacotizacion().getSelectedRow(), 0);
        List<CotizacionMD> lista = bcotizacion.obtenerdatos(codigo);
        bcotizacion.setCodigo(lista.get(0).getCodigo());
        vistacot.getLabelcodigo().setText(bcotizacion.getCodigo());
        bcotizacion.setCedula(lista.get(0).getCedula());
        vistacot.getTxtcedula().setText(bcotizacion.getCedula());
        bcotizacion.setCodigoproductos(lista.get(0).getCodigoproductos());
        vistacot.getLabelcodigoproducto().setText(bcotizacion.getCodigoproductos());
        bcotizacion.setNombreproductos(lista.get(0).getNombreproductos());
        vistacot.getTxtnombreproducto().setText(bcotizacion.getNombreproductos());
        bcotizacion.setCantidad(lista.get(0).getCantidad());
        vistacot.getTxtcantidad().setText(String.valueOf(bcotizacion.getCantidad()));
        bcotizacion.setValorunitario(lista.get(0).getValorunitario());
        vistacot.getLabelvaloru().setText(String.valueOf(bcotizacion.getCantidad()));
        bcotizacion.setIva(lista.get(0).getIva());
        vistacot.getLabeliva().setText(bcotizacion.getIva());
        
        vistacot.getTxtcedula().setEnabled(true);
        vistacot.getTxtnombreproducto().setEnabled(true);
        vistacot.getTxtcantidad().setEnabled(true);
        vistacot.getTxttotal().setEnabled(true);

    }
    
    public void eliminar() {
        bcotizacion.setCodigo(vistacot.getLabelcodigo().getText());
        int resp = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar la cotización  " + vistacot.getLabelcodigo().getText());
        if (resp == 0) {
            if (bcotizacion.eliminar(vistacot.getLabelcodigo().getText())) ;
            JOptionPane.showMessageDialog(null, "Datos Actualizados");
            lista();
            nuevo();
            
        vistacot.getTxtcedula().setEnabled(false);
        vistacot.getTxtnombreproducto().setEnabled(false);
        vistacot.getTxtcantidad().setEnabled(false);
        vistacot.getTxttotal().setEnabled(false);

        }
    }

    public void nuevo() {
        vistacot.getLabelcodigo().setText("");
        vistacot.getTxtcedula().setText("");
        vistacot.getLabelcodigoproducto().setText("");
        vistacot.getTxtnombreproducto().setText("");
        vistacot.getTxtcantidad().setText("");
        vistacot.getLabelvaloru().setText("");
        vistacot.getLabeliva().setText("");
        vistacot.getButtonguardar().setEnabled(true);
        vistacot.getButtonmodificar().setEnabled(false);
        vistacot.getTxtcedula().setEnabled(true);
        vistacot.getTxtnombreproducto().setEnabled(true);
        vistacot.getTxtcantidad().setEnabled(true);
        vistacot.getTxttotal().setEnabled(true);
    }
}
