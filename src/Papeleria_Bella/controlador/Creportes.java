


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

public class Creportes {
    public static Vreportes vistarep;
    private ReportesBD breportes = new ReportesBD();
    
    public Creportes(Vreportes vistarep) {
        this.vistarep = vistarep;
        vistarep.setVisible(true);
        vistarep.setLocationRelativeTo(null);
        lista();
        vistarep.getButtonguardar().addActionListener(x -> guardar());
        vistarep.getButtonmodificar().addActionListener(e -> modificar());
        /*vistav.getButtonbuscarproducto().addActionListener(e -> Buscarproducto());
        vistav.getButtonbuscarfactura().addActionListener(e -> Buscarfactura());
        vistav.getButtonimprimir().addActionListener(e -> imprimir());*/
        vistarep.getTablareportes().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }

        });

        vistarep.getButtonnuevo().addActionListener(e -> nuevo());
        vistarep.getButtoneliminar().addActionListener(e -> eliminar());
        vistarep.getButtonguardar().setEnabled(false);
        vistarep.getButtonmodificar().setEnabled(false);
    }
    public void lista() {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistarep.getTablareportes().getModel();
        List<ReportesMD> lista = breportes.mostrardatos();
        int columnas = modelo.getColumnCount();
        for (int j = vistarep.getTablareportes().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);
        }
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            vistarep.getTablareportes().setValueAt(lista.get(i).getCodigo(), i, 0);
            vistarep.getTablareportes().setValueAt(lista.get(i).getNombreprod(), i, 1);
            vistarep.getTablareportes().setValueAt(lista.get(i).getCantidadprod(), i, 2);
            vistarep.getTablareportes().setValueAt(lista.get(i).getIngreso(), i, 3);
            vistarep.getTablareportes().setValueAt(lista.get(i).getEgreso(), i, 4);
        }//mATHEW HENSON    
    }
    
    public void guardar() {
        breportes.setCodigo(vistarep.getLabelcodigo().getText());
        breportes.setNombreprod(vistarep.getCombonombreproducto().getSelectedItem().toString());
        breportes.setCantidadprod(vistarep.getTxtcantidadproducto().getText());
        breportes.setIngreso(Integer.parseInt(vistarep.getTxtingreso().getText()));
        breportes.setEgreso(Integer.parseInt(vistarep.getTxtegreso().getText()));
    }

    public void modificar() {
        breportes.setCodigo(vistarep.getLabelcodigo().getText());
        breportes.setNombreprod(vistarep.getCombonombreproducto().getSelectedItem().toString());
        breportes.setCantidadprod(vistarep.getTxtcantidadproducto().getText());
        breportes.setIngreso(Integer.parseInt(vistarep.getTxtingreso().getText()));
        breportes.setEgreso(Integer.parseInt(vistarep.getTxtegreso().getText()));

        int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro de modificar?");
        if (resp == 0) {
            if (breportes.modificar(vistarep.getLabelcodigo().getText())) ;
            JOptionPane.showMessageDialog(null, "Datos Actualizados");
            lista();
            nuevo();

        }
    }

    public void seleccionar() {
        vistarep.getButtonguardar().setEnabled(false);
        vistarep.getButtonmodificar().setEnabled(true);
    
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistarep.getTablareportes().getModel();
        String codigo = (String) modelo.getValueAt(vistarep.getTablareportes().getSelectedRow(), 0);
        List<ReportesMD> lista = breportes.obtenerdatos(codigo);
        breportes.setCodigo(lista.get(0).getCodigo());
        vistarep.getLabelcodigo().setText(breportes.getCodigo());
        breportes.setNombreprod(lista.get(0).getNombreprod());
        vistarep.getCombonombreproducto().setSelectedItem(breportes.getNombreprod());
        breportes.setCantidadprod(lista.get(0).getCantidadprod());
        vistarep.getTxtcantidadproducto().setText(breportes.getCantidadprod());
        breportes.setIngreso(lista.get(0).getIngreso());
        vistarep.getTxtingreso().setText(String.valueOf(breportes.getIngreso()));
        breportes.setEgreso(lista.get(0).getEgreso());
        vistarep.getTxtegreso().setText(String.valueOf(breportes.getEgreso()));


    }
    
    public void eliminar() {
        breportes.setCodigo(vistarep.getLabelcodigo().getText());
        int resp = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar el reporte  " + vistarep.getLabelcodigo().getText());
        if (resp == 0) {
            if (breportes.eliminar(vistarep.getLabelcodigo().getText())) ;
            JOptionPane.showMessageDialog(null, "Datos Actualizados");
            lista();
            nuevo();

        }
    }

    public void nuevo() {
        vistarep.getLabelcodigo().setText("");
        vistarep.getCombonombreproducto().setSelectedItem("");
        vistarep.getTxtcantidadproducto().setText("");
        vistarep.getTxtingreso().setText("");
        vistarep.getTxtegreso().setText("");

        vistarep.getButtonguardar().setEnabled(true);
        vistarep.getButtonmodificar().setEnabled(false);
    }
}
