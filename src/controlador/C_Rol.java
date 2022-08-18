package controlador;

import modelo.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.RolMD;
import vista.V_Rol;

public class C_Rol {

    public static ArrayList<RolBD> listarol = new ArrayList();
    public static V_Rol vistarol;
    public RolBD bdrol = new RolBD();
    boolean mostrar = false;

    public C_Rol(V_Rol vistarol) {
        this.vistarol = vistarol;
        vistarol.setVisible(true);
        listarol();
        GenerarCodRol();
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

        vistarol.getBtnguardarp().setEnabled(false);
        vistarol.getBtnmodificar().setEnabled(false);
        vistarol.getCheckBoxEstado().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBoxEstadoActionPerformed(evt);
            }
        });
        vistarol.getBtnBuscarRol().addActionListener(x->Buscar());
    }

    public void nuevo() {
        vistarol.getTxtnombre().setText("");
        vistarol.getTxtDescripcion().setText("");
        vistarol.getBtnguardarp().setEnabled(true);
        vistarol.getBtnmodificar().setEnabled(true);
        GenerarCodRol();
    }

    public void listarol() {

        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistarol.getTableRol().getModel();
        List<RolMD> lista = bdrol.mostrardatos();
        int columnas = modelo.getColumnCount();

        for (int j = vistarol.getTableRol().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);

        }
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            vistarol.getTableRol().setValueAt(lista.get(i).getCodigo(), i, 0);
            vistarol.getTableRol().setValueAt(lista.get(i).getNombre(), i, 1);
            vistarol.getTableRol().setValueAt(lista.get(i).getDescripcion(), i, 2);
            vistarol.getTableRol().setValueAt(lista.get(i).getEstado(), i, 3);

        }
    }

    public void guardar() {
        bdrol.setCodigo(vistarol.getLabelCodRol().getText());
        bdrol.setNombre(vistarol.getTxtnombre().getText());
        bdrol.setDescripcion(vistarol.getTxtDescripcion().getText());
        bdrol.setEstado(vistarol.getLabelEstado().getText());

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
        bdrol.setEstado(vistarol.getLabelEstado().getText());
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
        List<RolMD> lista = bdrol.obtenerdatos(codigo);
        bdrol.setCodigo(lista.get(0).getCodigo());
        vistarol.getLabelCodRol().setText(bdrol.getCodigo());
        bdrol.setNombre(lista.get(0).getNombre());
        vistarol.getTxtnombre().setText(bdrol.getNombre());
        bdrol.setDescripcion(lista.get(0).getDescripcion());
        vistarol.getTxtDescripcion().setText(bdrol.getDescripcion());
        bdrol.setEstado(lista.get(0).getEstado());
        vistarol.getLabelEstado().setText(bdrol.getEstado());

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

    private void CheckBoxEstadoActionPerformed(java.awt.event.ActionEvent evt) {
        if (mostrar) {
            vistarol.getLabelEstado().setText("Activo");
            mostrar = false;

        } else {
            vistarol.getLabelEstado().setText("Inactivo");
            mostrar = true;
        }
    }

    public void GenerarCodRol() {
        char[] chars = "0123".toCharArray();

        int charsLength = chars.length;

        Random random = new Random();

        StringBuilder buffer = new StringBuilder();

        for (int i = 0; i < 3; i++) {

            buffer.append(chars[random.nextInt(charsLength)]);
        }

        vistarol.getLabelCodRol().setText("ROL000-" + buffer.toString());
    }

    public void Buscar() {
        if (vistarol.getTxtBuscarRol().getText().equals("")) {
            listarol();
        } else {
            DefaultTableModel model;
            model = (DefaultTableModel) vistarol.getTableRol().getModel();
            java.util.List<RolMD> listarol = bdrol.buscardatos(vistarol.getTxtBuscarRol().getText());
            int columnas = model.getColumnCount();
            for (int j = vistarol.getTableRol().getRowCount() - 1; j >= 0; j--) {
                model.removeRow(j);
            }
            for (int i = 0; i < listarol.size(); i++) {
                    model.addRow(new Object[columnas]);
                    vistarol.getTableRol().setValueAt(listarol.get(i).getCodigo(), i, 0);
                    vistarol.getTableRol().setValueAt(listarol.get(i).getNombre(), i, 1);
                    vistarol.getTableRol().setValueAt(listarol.get(i).getDescripcion(), i, 2);
                    vistarol.getTableRol().setValueAt(listarol.get(i).getEstado(), i, 3);
            }
        }
    }
}
