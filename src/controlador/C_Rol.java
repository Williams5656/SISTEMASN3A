package controlador;

import modelo.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Mrol;
import vista.V_Rol;

public class C_Rol {

    public static ArrayList<RolBD> listarol = new ArrayList();
    public static V_Rol vistarol;
    public RolBD bdrol = new RolBD();

    public C_Rol(V_Rol vistarol) {
        this.vistarol = vistarol;
        vistarol.setVisible(true);
        listarol();
        vistarol.getBtnguardarp().addActionListener(e -> guardar());
        vistarol.getBtnmodificar().addActionListener(e -> modificar());
        vistarol.getTableRol().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }

        });
        vistarol.getBtnnuevo().addActionListener(e -> nuevo());
        vistarol.getBtneliminar().addActionListener(e -> eliminar());

        vistarol.getBtnguardarp().setEnabled(true);
        vistarol.getBtnmodificar().setEnabled(false);
    }

    public void nuevo() {
        vistarol.getLabelCodRol().setText("");
        vistarol.getTxtnombre().setText("");
        vistarol.getTxtDescripcion().setText("");
        vistarol.getCheckBoxEstado().setSelected(false);
    }

    public void listarol() {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistarol.getTableRol().getModel();
        List<Mrol> listarol = bdrol.mostrardatos();
        for (int j = vistarol.getTableRol().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);

        }
        int columnas = modelo.getColumnCount();
        for (int i = 0; i < listarol.size(); i++) {
            modelo.addRow(new Object[columnas]);
            vistarol.getTableRol().setValueAt(listarol.get(i).getCodigo(), i, 0);
            vistarol.getTableRol().setValueAt(listarol.get(i).getNombre(), i, 1);
            vistarol.getTableRol().setValueAt(listarol.get(i).getDescripcion(), i, 2);
            vistarol.getTableRol().setValueAt(listarol.get(i).getDescripcion(), i, 2);
        }
    }

    public void guardar() {
        bdrol.setCodigo(vistarol.getLabelCodRol().getText());
        bdrol.setNombre(vistarol.getTxtnombre().getText());
        bdrol.setDescripcion(vistarol.getTxtDescripcion().getText());
        bdrol.setEstado(vistarol.getCheckBoxEstado().getText());

        if (bdrol.insertar()) {
            JOptionPane.showMessageDialog(null, "GUARDADO CORRECTAMENTE");
            listarol();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
        }
    }

    public void modificar() {
        bdrol.setCodigo(vistarol.getLabelCodRol().getText());
        bdrol.setNombre(vistarol.getTxtnombre().getText());
        bdrol.setDescripcion(vistarol.getTxtDescripcion().getText());
        bdrol.setEstado(vistarol.getCheckBoxEstado().getText());
        int resp = JOptionPane.showConfirmDialog(null, "ESTA SEGURO DE MODIFICAR LOS DATOS");
        if (resp == 0) {
            if (bdrol.modificar(vistarol.getLabelCodRol().getText())) {
                JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS CORRECTAMENTE");
                listarol();
                nuevo();
                vistarol.getBtnmodificar().setEnabled(false);
            }
        }
    }

    public void seleccionar() {
        vistarol.getBtnguardarp().setEnabled(false);
        vistarol.getBtnmodificar().setEnabled(true);
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistarol.getTableRol().getModel();
        String codigo = (String) modelo.getValueAt(vistarol.getTableRol().getSelectedRow(), 0);
        List<Mrol> lista = bdrol.obtenerdatos(codigo);
        bdrol.setCodigo(lista.get(0).getCodigo());
        vistarol.getLabelCodRol().setText(bdrol.getCodigo());
        bdrol.setNombre(lista.get(0).getNombre());
        vistarol.getTxtnombre().setText(bdrol.getNombre());
        bdrol.setDescripcion(lista.get(0).getDescripcion());
        vistarol.getTxtDescripcion().setText(bdrol.getDescripcion());
        bdrol.setEstado(lista.get(0).getEstado());
        vistarol.getCheckBoxEstado().setText(bdrol.getEstado());

    }

    public void eliminar() {

        bdrol.setCodigo(vistarol.getLabelCodRol().getText());
        int resp = JOptionPane.showConfirmDialog(null, "ESTA SEGURO DE ELIMINAR LOS DATOS" + vistarol.getLabelCodRol().getText());
        if (resp == 0) {
            if (bdrol.eliminar(vistarol.getLabelCodRol().getText())) {
                JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS");
                listarol();
                nuevo();
            }
        }

    }

}
