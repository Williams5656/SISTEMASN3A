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
        vistarol.setLocationRelativeTo(null);
        listarol();
        vistarol.getBtnguardar().addActionListener(e -> guardar());
        vistarol.getBtnmodificar().addActionListener(e -> modificar());
        vistarol.getTablarol().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }

        });
        vistarol.getBtnnuevo().addActionListener(e -> nuevo());
        vistarol.getBtneliminar().addActionListener(e -> eliminar());

        vistarol.getBtnguardar().setEnabled(true);
        vistarol.getBtnmodificar().setEnabled(false);
    }

    public void nuevo() {
        vistarol.getTxtcodigo().setText("");
        vistarol.getTxtnombre().setText("");
        vistarol.getTxtdescripcion().setText("");
        vistarol.getCbestado().setSelectedItem("");
    }

    public void listarol() {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistarol.getTablarol().getModel();
        List<Mrol> listarol = bdrol.mostrardatos();
        for (int j = vistarol.getTablarol().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);

        }
        int columnas = modelo.getColumnCount();
        for (int i = 0; i < listarol.size(); i++) {
            modelo.addRow(new Object[columnas]);
            vistarol.getTablarol().setValueAt(listarol.get(i).getCodigo(), i, 0);
            vistarol.getTablarol().setValueAt(listarol.get(i).getNombre(), i, 1);
            vistarol.getTablarol().setValueAt(listarol.get(i).getDescripcion(), i, 2);
            vistarol.getTablarol().setValueAt(listarol.get(i).getDescripcion(), i, 2);
        }
    }

    public void guardar() {
        bdrol.setCodigo(vistarol.getTxtcodigo().getText());
        bdrol.setNombre(vistarol.getTxtnombre().getText());
        bdrol.setDescripcion(vistarol.getTxtdescripcion().getText());
        bdrol.setEstado(vistarol.getCbestado().getSelectedItem().toString());

        if (bdrol.insertar()) {
            JOptionPane.showMessageDialog(null, "GUARDADO CORRECTAMENTE");
            listarol();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
        }
    }

    public void modificar() {
        bdrol.setCodigo(vistarol.getTxtcodigo().getText());
        bdrol.setNombre(vistarol.getTxtnombre().getText());
        bdrol.setDescripcion(vistarol.getTxtdescripcion().getText());
        bdrol.setEstado(vistarol.getCbestado().getSelectedItem().toString());
        int resp = JOptionPane.showConfirmDialog(null, "ESTA SEGURO DE MODIFICAR LOS DATOS");
        if (resp == 0) {
            if (bdrol.modificar(vistarol.getTxtcodigo().getText())) {
                JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS CORRECTAMENTE");
                listarol();
                nuevo();
                vistarol.getBtnmodificar().setEnabled(false);
            }
        }
    }

    public void seleccionar() {
        vistarol.getBtnguardar().setEnabled(false);
        vistarol.getBtnmodificar().setEnabled(true);
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistarol.getTablarol().getModel();
        String codigo = (String) modelo.getValueAt(vistarol.getTablarol().getSelectedRow(), 0);
        List<Mrol> lista = bdrol.obtenerdatos(codigo);
        bdrol.setCodigo(lista.get(0).getCodigo());
        vistarol.getTxtcodigo().setText(bdrol.getCodigo());
        bdrol.setNombre(lista.get(0).getNombre());
        vistarol.getTxtnombre().setText(bdrol.getNombre());
        bdrol.setDescripcion(lista.get(0).getDescripcion());
        vistarol.getTxtdescripcion().setText(bdrol.getDescripcion());
        bdrol.setEstado(lista.get(0).getEstado());
        vistarol.getCbestado().setSelectedItem(bdrol.getEstado());

    }

    public void eliminar() {

        bdrol.setCodigo(vistarol.getTxtcodigo().getText());
        int resp = JOptionPane.showConfirmDialog(null, "ESTA SEGURO DE ELIMINAR LOS DATOS" + vistarol.getTxtcodigo().getText());
        if (resp == 0) {
            if (bdrol.eliminar(vistarol.getTxtcodigo().getText())) {
                JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS");
                listarol();
                nuevo();
            }
        }

    }

}
