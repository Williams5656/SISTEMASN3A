
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

public class Cproveedores {
    public static Vproveedores vistaprov;
    private ProveedoresBD bproveedores = new ProveedoresBD();
    public Cproveedores(Vproveedores vistaprov) {
        this.vistaprov = vistaprov;
        vistaprov.setVisible(true);
        vistaprov.setLocationRelativeTo(null);

        GenerarCodProvee();

        vistaprov.getButtonguardar().addActionListener(x -> guardar());
        vistaprov.getButtonbuscar().addActionListener(e -> buscar());
        vistaprov.getButtonmodificar().addActionListener(e -> modificar());

        vistaprov.getTablaproveedores().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }

        });

        vistaprov.getButtonbuscar().addActionListener(x -> buscar());
        vistaprov.getButtonnuevo().addActionListener(e -> nuevo());
        vistaprov.getButtoneliminar().addActionListener(e -> eliminar());
        vistaprov.getButtonguardar().setEnabled(false);
        vistaprov.getButtonmodificar().setEnabled(false);
        
        vistaprov.getTxtruc().setEnabled(false);
        vistaprov.getTxtnombrecom().setEnabled(false);
        vistaprov.getTxtrepresentanteleg().setEnabled(false);
        vistaprov.getTxtcelular().setEnabled(false);



        lista();
    }
    public void lista() {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistaprov.getTablaproveedores().getModel();
        List<ProveedoresMD> lista = bproveedores.mostrardatos();
        int columnas = modelo.getColumnCount();
        for (int j = vistaprov.getTablaproveedores().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);
        }
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            vistaprov.getTablaproveedores().setValueAt(lista.get(i).getCodigo(), i, 0);
            vistaprov.getTablaproveedores().setValueAt(lista.get(i).getRuc(), i, 1);
            vistaprov.getTablaproveedores().setValueAt(lista.get(i).getNombrecom(), i, 2);
            vistaprov.getTablaproveedores().setValueAt(lista.get(i).getRepresentanteleg(), i, 3);
            vistaprov.getTablaproveedores().setValueAt(lista.get(i).getCelular(), i, 4);
        }
       
    }

    public void guardar() {

        bproveedores.setCodigo(vistaprov.getLabelcodigo().getText());
        bproveedores.setRuc(vistaprov.getTxtruc().getText());
        bproveedores.setNombrecom(vistaprov.getTxtnombrecom().getText());
        bproveedores.setRepresentanteleg(vistaprov.getTxtrepresentanteleg().getText());
        bproveedores.setCelular(vistaprov.getTxtcelular().getText());

        if (bproveedores.insertar()) {
            JOptionPane.showMessageDialog(null, "EXITO AL GUARDAR");
            lista();
            vistaprov.getTxtruc().setEnabled(false);
        vistaprov.getTxtnombrecom().setEnabled(false);
        vistaprov.getTxtrepresentanteleg().setEnabled(false);
        vistaprov.getTxtcelular().setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
            lista();
            vistaprov.getTxtruc().setEnabled(false);
        vistaprov.getTxtnombrecom().setEnabled(false);
        vistaprov.getTxtrepresentanteleg().setEnabled(false);
        vistaprov.getTxtcelular().setEnabled(false);
        }

    }
    public void modificar() {
        bproveedores.setCodigo(vistaprov.getLabelcodigo().getText());
        bproveedores.setRuc(vistaprov.getTxtruc().getText());
        bproveedores.setNombrecom(vistaprov.getTxtnombrecom().getText());
        bproveedores.setRepresentanteleg(vistaprov.getTxtrepresentanteleg().getText());
        bproveedores.setCelular(vistaprov.getTxtcelular().getText());
        
        int resp = JOptionPane.showConfirmDialog(null, "Esta seguro de modificar");
        if (resp == 0) {
            if (bproveedores.modificar(vistaprov.getLabelcodigo().getText())) ;
            JOptionPane.showMessageDialog(null, "Datos Actualizados");
            lista();
            nuevo();
            vistaprov.getTxtruc().setEnabled(false);
        vistaprov.getTxtnombrecom().setEnabled(false);
        vistaprov.getTxtrepresentanteleg().setEnabled(false);
        vistaprov.getTxtcelular().setEnabled(false);
        }
    }

    public void seleccionar() {
        vistaprov.getButtonguardar().setEnabled(false);
        vistaprov.getButtonmodificar().setEnabled(true);

        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistaprov.getTablaproveedores().getModel();
        String codigo = (String) modelo.getValueAt(vistaprov.getTablaproveedores().getSelectedRow(), 0);
        List<ProveedoresMD> lista = bproveedores.obtenerdatos(codigo);
        bproveedores.setCodigo(lista.get(0).getCodigo());
        vistaprov.getLabelcodigo().setText(bproveedores.getCodigo());
        bproveedores.setRuc(lista.get(0).getRuc());
        vistaprov.getTxtruc().setText(bproveedores.getRuc());
        bproveedores.setNombrecom(lista.get(0).getNombrecom());
        vistaprov.getTxtnombrecom().setText(bproveedores.getNombrecom());
        bproveedores.setRepresentanteleg(lista.get(0).getRepresentanteleg());
        vistaprov.getTxtrepresentanteleg().setText(bproveedores.getRepresentanteleg());
        bproveedores.setCelular(lista.get(0).getCelular());
        vistaprov.getTxtcelular().setText(bproveedores.getCelular());
        vistaprov.getTxtruc().setEnabled(true);
        vistaprov.getTxtnombrecom().setEnabled(true);
        vistaprov.getTxtrepresentanteleg().setEnabled(true);
        vistaprov.getTxtcelular().setEnabled(true);

    }

    public void eliminar() {
        bproveedores.setCodigo(vistaprov.getLabelcodigo().getText());
        int resp = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar el usuario tal " + vistaprov.getLabelcodigo().getText());
        if (resp == 0) {
            if (bproveedores.eliminar(vistaprov.getLabelcodigo().getText())) ;
            JOptionPane.showMessageDialog(null, "Datos Actualizados");
            lista();
            vistaprov.getTxtruc().setEnabled(false);
        vistaprov.getTxtnombrecom().setEnabled(false);
        vistaprov.getTxtrepresentanteleg().setEnabled(false);
        vistaprov.getTxtcelular().setEnabled(false);

        }

    }
    public void nuevo() {
        vistaprov.getLabelcodigo().setText("");
        vistaprov.getTxtruc().setText("");
        vistaprov.getTxtnombrecom().setText("");
        vistaprov.getTxtrepresentanteleg().setText("");
        vistaprov.getTxtcelular().setText("");
        vistaprov.getButtonguardar().setEnabled(true);
        vistaprov.getButtonmodificar().setEnabled(false);
        GenerarCodProvee();
        vistaprov.getTxtruc().setEnabled(true);
        vistaprov.getTxtnombrecom().setEnabled(true);
        vistaprov.getTxtrepresentanteleg().setEnabled(true);
        vistaprov.getTxtcelular().setEnabled(true);
    }

    private void buscar() {
        if (vistaprov.getLabelcodigo().getText().equals("")) {
            lista();
        } else {

            java.util.List<ProveedoresMD> lista = bproveedores.buscardatos(vistaprov.getLabelcodigo().getText());
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getCodigo().equals(vistaprov.getLabelcodigo().getText())) {
                    vistaprov.getTxtruc().setText(lista.get(i).getNombrecom()+ "  " + lista.get(i).getRepresentanteleg());
                } else {
                    JOptionPane.showMessageDialog(null, "Persona no registrada", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

    }

    public void GenerarCodProvee() {
        char[] chars = "0123".toCharArray();

        int charsLength = chars.length;

        Random random = new Random();

        StringBuilder buffer = new StringBuilder();

        for (int i = 0; i < 3; i++) {

            buffer.append(chars[random.nextInt(charsLength)]);
        }

        vistaprov.getLabelcodigo().setText("Prov" + buffer.toString());
    }
}
