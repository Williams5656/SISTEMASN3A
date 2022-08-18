package V93Controlador;

import static V93Controlador.CRol.VistaR;
import V93Modelo.RolBD;
import V93Modelo.RolMb;
import V93Vista.VistaRol;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CRol {
             
    public static VistaRol VistaR;

    private RolBD bdrol = new RolBD();

    public CRol(VistaRol VistaR) {
        this.VistaR = VistaR;
        VistaR.setVisible(true);
        VistaR.setLocationRelativeTo(null);
        lista();
        VistaR.getBtnGuardarRol().addActionListener(x -> guardar());
        VistaR.getBtnModificarRol().addActionListener(e -> modificar());
        VistaR.getBtnbuscarr().addActionListener(e -> buscar());
        VistaR.getTableRol().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                seleccionar();
            }

        });

        VistaR.getBtnNuevoRol().addActionListener(e -> nuevo());
        VistaR.getBtnEliminarRol().addActionListener(e -> eliminar());
        VistaR.getBtnGuardarRol().setEnabled(false);
        VistaR.getBtnModificarRol().setEnabled(false);
    }

    public void lista() {

        DefaultTableModel modelo;
        modelo = (DefaultTableModel) VistaR.getTableRol().getModel();
        List<RolMb> lista = bdrol.mostrardatos();
        int columnas = modelo.getColumnCount();

        for (int j = VistaR.getTableRol().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);

        }
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            VistaR.getTableRol().setValueAt(lista.get(i).getCodigo(), i, 0);
            VistaR.getTableRol().setValueAt(lista.get(i).getNombre(), i, 1);
            VistaR.getTableRol().setValueAt(lista.get(i).getDescripcion(), i, 2);
            VistaR.getTableRol().setValueAt(lista.get(i).getEstado(), i, 3);

        }
    }

    public void nuevo() {
        VistaR.getTxtCodigoRol().setText("");
        VistaR.getTxtNombreRol().setText("");
        VistaR.getTxtDesceipcionRol().setText("");
        VistaR.getjComboBoxRol().setSelectedItem("");
        VistaR.getTxtbuscarr().setText("");

        VistaR.getBtnGuardarRol().setEnabled(true);
        VistaR.getBtnModificarRol().setEnabled(false);

    }  
 
    public void guardar() {
        bdrol.setCodigo(VistaR.getTxtCodigoRol().getText());
        bdrol.setNombre(VistaR.getTxtNombreRol().getText());
        bdrol.setDescripcion(VistaR.getTxtDesceipcionRol().getText());
        String rol = (String) VistaR.getjComboBoxRol().getSelectedItem();
        bdrol.setEstado(rol);

        if (bdrol.insertar()) {
            JOptionPane.showMessageDialog(null, "EXITO AL GUARDAR");
            lista();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
        }
    }

    public void buscar() {
        if (VistaR.getTxtbuscarr().getText().equals("")) {
            lista();
        } else {
            DefaultTableModel modelo;
            modelo = (DefaultTableModel) VistaR.getTableRol().getModel();
            List<RolMb> lista = bdrol.obtenerdatos(VistaR.getTxtbuscarr().getText());
            int columnas = modelo.getColumnCount();

            for (int j = VistaR.getTableRol().getRowCount() - 1; j >= 0; j--) {
                modelo.removeRow(j);
            }
            for (int i = 0; i < lista.size(); i++) {
                modelo.addRow(new Object[columnas]);
                VistaR.getTableRol().setValueAt(lista.get(i).getCodigo(), i, 0);
                VistaR.getTableRol().setValueAt(lista.get(i).getNombre(), i, 1);
                VistaR.getTableRol().setValueAt(lista.get(i).getDescripcion(), i, 2);
                VistaR.getTableRol().setValueAt(lista.get(i).getEstado(), i, 3);

            }
        }

    }

    public void modificar() {
        bdrol.setCodigo(VistaR.getTxtCodigoRol().getText());
        bdrol.setNombre(VistaR.getTxtNombreRol().getText());
        bdrol.setDescripcion(VistaR.getTxtDesceipcionRol().getText());
        String rol = (String) VistaR.getjComboBoxRol().getSelectedItem();
        bdrol.setEstado(rol);

        int resp = JOptionPane.showConfirmDialog(null, "confirme si desea modificar");
        if (resp == 0) {
            if (bdrol.modificar(VistaR.getTxtCodigoRol().getText()));
            JOptionPane.showMessageDialog(null, "datos actualizados");
            lista();
            nuevo();
        }
    }

    public void seleccionar() {
        VistaR.getBtnGuardarRol().setEnabled(false);
        VistaR.getBtnModificarRol().setEnabled(true);
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) VistaR.getTableRol().getModel();
        String cedula = (String) modelo.getValueAt(VistaR.getTableRol().getSelectedRow(), 0);
        List<RolMb> lista = bdrol.obtenerdatos(cedula);
        bdrol.setCodigo(lista.get(0).getCodigo());
        VistaR.getTxtCodigoRol().setText(bdrol.getCodigo());
        bdrol.setNombre(lista.get(0).getNombre());
        VistaR.getTxtNombreRol().setText(bdrol.getNombre());
        bdrol.setDescripcion(lista.get(0).getDescripcion());
        VistaR.getTxtDesceipcionRol().setText(bdrol.getDescripcion());
        bdrol.setEstado(lista.get(0).getEstado());
        VistaR.getjComboBoxRol().setSelectedItem(bdrol.getEstado());
    }

    public void eliminar() {
        bdrol.setCodigo(VistaR.getTxtCodigoRol().getText());
        int resp = JOptionPane.showConfirmDialog(null, "SEGURO QUE DESEA INHABILITAR  " + VistaR.getTxtNombreRol().getText());
        if (resp == 0) {
            if (bdrol.eliminar(VistaR.getTxtCodigoRol().getText()));
            JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS");
            lista();
            nuevo();
        }
    }
}
