
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
import java.util.Random;
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

public class Cventas {
    public static Vventas vistav;
    private VentasBD bventas = new VentasBD();
    final double iva=0.12;
    
    public Cventas(Vventas vistav) {
        this.vistav = vistav;
        vistav.setVisible(true);
        vistav.setLocationRelativeTo(null);
        lista();
        GenerarCodVentas();
        vistav.getButtonguardar().addActionListener(x -> guardar());
        vistav.getButtonmodificar().addActionListener(e -> modificar());
        /*vistav.getButtonbuscarproducto().addActionListener(e -> Buscarproducto());
        vistav.getButtonbuscarfactura().addActionListener(e -> Buscarfactura());
        vistav.getButtonimprimir().addActionListener(e -> imprimir());*/
        vistav.getTablaventas().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }

        });

        vistav.getButtonnuevo().addActionListener(e -> nuevo());
        vistav.getButtoneliminar().addActionListener(e -> eliminar());
        vistav.getButtonguardar().setEnabled(false);
        vistav.getButtonmodificar().setEnabled(false);
        
        vistav.getTxtcedula().setEnabled(false);
        vistav.getLabel().setEnabled(false);
        vistav.getTxtnombre().setEnabled(false);
        vistav.getTxtcantidad().setEnabled(false);
        vistav.getTxtvalor().setEnabled(false);
        vistav.getTxttotal().setEnabled(false);
    }

    public void lista() {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistav.getTablaventas().getModel();
        List<VentasMD> lista = bventas.mostrardatos();
        int columnas = modelo.getColumnCount();
        for (int j = vistav.getTablaventas().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);
        }
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            vistav.getTablaventas().setValueAt(lista.get(i).getNumfactura(), i, 0);
            vistav.getTablaventas().setValueAt(lista.get(i).getCedula(), i, 1);
            vistav.getTablaventas().setValueAt(lista.get(i).getCodigo(), i, 2);
            vistav.getTablaventas().setValueAt(lista.get(i).getNombreproducto(), i, 3);
            vistav.getTablaventas().setValueAt(lista.get(i).getCantidad(), i, 4);
            vistav.getTablaventas().setValueAt(lista.get(i).getValoru(), i, 5);
            vistav.getTablaventas().setValueAt(lista.get(i).getIva(), i, 6);
            vistav.getTablaventas().setValueAt(lista.get(i).getTotal(), i, 7);
        }
    }
    
    public void guardar() {
        bventas.setNumfactura(vistav.getLabelnumero().getText());
        bventas.setCedula(vistav.getTxtcedula().getText());
        bventas.setCodigo(vistav.getLabelcodigo().getText());
        bventas.setNombreproducto(vistav.getTxtnombre().getText());
        bventas.setCantidad(Integer.parseInt(vistav.getTxtcantidad().getText()));
        bventas.setValoru(vistav.getTxtvalor().getText());
        bventas.setIva(vistav.getLabeliva().getText());
        bventas.setTotal(vistav.getTxttotal().getText());
        if (bventas.insertar()) {
            JOptionPane.showMessageDialog(null, "EXITO AL GUARDAR");
            lista();
            vistav.getTxtcedula().setEnabled(false);
        vistav.getLabelcodigo().setEnabled(false);
        vistav.getTxtnombre().setEnabled(false);
        vistav.getTxtcantidad().setEnabled(false);
        vistav.getTxtvalor().setEnabled(false);
        vistav.getTxttotal().setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
            lista();
            
            vistav.getTxtcedula().setEnabled(false);
        vistav.getLabelcodigo().setEnabled(false);
        vistav.getTxtnombre().setEnabled(false);
        vistav.getTxtcantidad().setEnabled(false);
        vistav.getTxtvalor().setEnabled(false);
        vistav.getTxttotal().setEnabled(false);
        }
    }

    public void modificar() {
        bventas.setNumfactura(vistav.getLabelnumero().getText());
        bventas.setCedula(vistav.getTxtcedula().getText());
        bventas.setCodigo(vistav.getLabelcodigo().getText());
        bventas.setNombreproducto(vistav.getTxtnombre().getText());
        bventas.setCantidad(Integer.parseInt(vistav.getTxtcantidad().getText()));
        bventas.setValoru(vistav.getTxtvalor().getText());
        bventas.setIva(vistav.getLabeliva().getText());
        bventas.setTotal(vistav.getTxttotal().getText());

        int resp = JOptionPane.showConfirmDialog(null, "Esta seguro de modificar");
        if (resp == 0) {
            if (bventas.modificar(vistav.getLabelnumero().getText())) ;
            JOptionPane.showMessageDialog(null, "Datos Actualizados");
            lista();
            nuevo();
            vistav.getTxtcedula().setEnabled(false);
        vistav.getLabelcodigo().setEnabled(false);
        vistav.getTxtnombre().setEnabled(false);
        vistav.getTxtcantidad().setEnabled(false);
        vistav.getTxtvalor().setEnabled(false);
        vistav.getTxttotal().setEnabled(false);

        }
    }

    public void seleccionar() {
        vistav.getButtonguardar().setEnabled(false);
        vistav.getButtonmodificar().setEnabled(true);
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistav.getTablaventas().getModel();
        String numero = (String) modelo.getValueAt(vistav.getTablaventas().getSelectedRow(), 0);
        List<VentasMD> lista = bventas.obtenerdatos(numero);
        bventas.setNumfactura(lista.get(0).getNumfactura());
        vistav.getLabelnumero().setText(bventas.getNumfactura());
        bventas.setCedula(lista.get(0).getCedula());
        vistav.getTxtcedula().setText(bventas.getCedula());
        bventas.setCodigo(lista.get(0).getCodigo());
        vistav.getLabelcodigo().setText(bventas.getCodigo());
        bventas.setNombreproducto(lista.get(0).getNombreproducto());
        vistav.getTxtnombre().setText(bventas.getNombreproducto());
        bventas.setCantidad(lista.get(0).getCantidad());
        vistav.getTxtcantidad().setText(String.valueOf(bventas.getCantidad()));
        bventas.setValoru(lista.get(0).getValoru());
        vistav.getTxtvalor().setText(bventas.getValoru());
        bventas.setIva(lista.get(0).getIva());
        vistav.getLabeliva().setText(bventas.getIva());
        
        vistav.getTxtcedula().setEnabled(true);
        vistav.getLabelcodigo().setEnabled(true);
        vistav.getTxtnombre().setEnabled(true);
        vistav.getTxtcantidad().setEnabled(true);
        vistav.getTxtvalor().setEnabled(true);
        vistav.getTxttotal().setEnabled(true);

    }
    
    public void eliminar() {
        bventas.setNumfactura(vistav.getLabelnumero().getText());
        int resp = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar el usuario  " + vistav.getLabelnumero().getText());
        if (resp == 0) {
            if (bventas.eliminar(vistav.getLabelnumero().getText())) ;
            JOptionPane.showMessageDialog(null, "Datos Actualizados");
            lista();
            nuevo();
            vistav.getTxtcedula().setEnabled(false);
        vistav.getLabelcodigo().setEnabled(false);
        vistav.getTxtnombre().setEnabled(false);
        vistav.getTxtcantidad().setEnabled(false);
        vistav.getTxtvalor().setEnabled(false);
        vistav.getTxttotal().setEnabled(false);

        }
    }

    public void nuevo() {
        vistav.getLabelnumero().setText("");
        vistav.getTxtcedula().setText("");
        vistav.getLabelcodigo().setText("");
        vistav.getTxtnombre().setText("");
        vistav.getTxtcantidad().setText("");
        vistav.getTxtvalor().setText("");
        vistav.getLabeliva().setText("");
        vistav.getButtonguardar().setEnabled(true);
        vistav.getButtonmodificar().setEnabled(false);
        GenerarCodVentas();
        
        vistav.getTxtcedula().setEnabled(true);
        vistav.getLabelcodigo().setEnabled(true);
        vistav.getTxtnombre().setEnabled(true);
        vistav.getTxtcantidad().setEnabled(true);
        vistav.getTxtvalor().setEnabled(true);
        vistav.getTxttotal().setEnabled(true);
    }
    public void GenerarCodVentas() {
        char[] chars = "0123456789".toCharArray();

        int charsLength = chars.length;

        Random random = new Random();

        StringBuilder buffer = new StringBuilder();

        for (int i = 0; i < 10; i++) {

            buffer.append(chars[random.nextInt(charsLength)]);
        }

        vistav.getLabelnumero().setText( buffer.toString());
    }
}
