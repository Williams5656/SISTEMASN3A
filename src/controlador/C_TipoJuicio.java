package controlador;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.TipoJuicioBD;
import modelo.TipoJuicioMD;
import vista.V_RegistroJuicio;

public class C_TipoJuicio {

    public static V_RegistroJuicio vistajuicio;
    private final TipoJuicioBD bdjuicio = new TipoJuicioBD();

    public C_TipoJuicio(V_RegistroJuicio vistajuicio) {
        this.vistajuicio = vistajuicio;
        vistajuicio.setVisible(true);
        GenerarCodJuicio();
        lista();
        vistajuicio.getBtnguardarp().setEnabled(false);
        vistajuicio.getBtnmodificar().setEnabled(false);
        vistajuicio.getBtnguardarp().addActionListener(x -> guardar());
        vistajuicio.getBtnmodificar().addActionListener(x -> modificar());
        vistajuicio.getBtneliminar().addActionListener(x -> eliminar());
        vistajuicio.getBtnnuevo().addActionListener(x -> nuevo());
        vistajuicio.getTableJuicio().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }

        });
        vistajuicio.getTxtBuscarJuicio().addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                TxtBuscarJuicioFocusGained(evt);
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                TxtBuscarJuicioFocusLost(evt);
            }
        });
        vistajuicio.getTxtBuscarJuicio().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
               BuscarJuicio();
            }
        });
    }

    public void lista() {

        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistajuicio.getTableJuicio().getModel();
        List<TipoJuicioMD> lista = bdjuicio.mostrardatos();
        int columnas = modelo.getColumnCount();

        for (int j = vistajuicio.getTableJuicio().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);

        }
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            vistajuicio.getTableJuicio().setValueAt(lista.get(i).getCodigo(), i, 0);
            vistajuicio.getTableJuicio().setValueAt(lista.get(i).getNombre(), i, 1);
            vistajuicio.getTableJuicio().setValueAt(lista.get(i).getDescripcion(), i, 2);
            vistajuicio.getTableJuicio().setValueAt(lista.get(i).getPrecio(), i, 3);

        }
    }

    public void guardar() {

        bdjuicio.setCodigo(vistajuicio.getCodigoJuicio().getText());
        bdjuicio.setNombre(vistajuicio.getTxtNombre().getText());
        bdjuicio.setDescripcion(vistajuicio.getTxtDescripcion().getText());
        bdjuicio.setPrecio(Double.parseDouble(vistajuicio.getTxtPrecio().getText()));

        if (bdjuicio.insertar()) {
            JOptionPane.showMessageDialog(null, "EXITO AL GUARDAR");
            lista();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
            lista();
        }

    }

    public void modificar() {
        bdjuicio.setCodigo(vistajuicio.getCodigoJuicio().getText());
        bdjuicio.setNombre(vistajuicio.getTxtNombre().getText());
        bdjuicio.setDescripcion(vistajuicio.getTxtDescripcion().getText());
        bdjuicio.setPrecio(Double.parseDouble(vistajuicio.getTxtPrecio().getText()));

        int rest = JOptionPane.showConfirmDialog(null, "Esta Seguro de Modificar");
        if (rest == 0) {
            if (bdjuicio.modificar(vistajuicio.getCodigoJuicio().getText())) ;
            JOptionPane.showMessageDialog(null, "Datos Modificados");
            lista();
            nuevo();
        }

    }

    public void seleccionar() {
        vistajuicio.getBtnguardarp().setEnabled(false);
        vistajuicio.getBtnmodificar().setEnabled(true);
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistajuicio.getTableJuicio().getModel();
        String cedula = (String) modelo.getValueAt(vistajuicio.getTableJuicio().getSelectedRow(), 0);
        List<TipoJuicioMD> lista = bdjuicio.obtenerdatos(cedula);
        bdjuicio.setCodigo(lista.get(0).getCodigo());
        vistajuicio.getCodigoJuicio().setText(bdjuicio.getCodigo());
        bdjuicio.setNombre(lista.get(0).getNombre());
        vistajuicio.getTxtNombre().setText(bdjuicio.getNombre());
        bdjuicio.setDescripcion(lista.get(0).getDescripcion());
        vistajuicio.getTxtDescripcion().setText(bdjuicio.getDescripcion());
        bdjuicio.setPrecio(lista.get(0).getPrecio());
        vistajuicio.getTxtPrecio().setText(String.valueOf(bdjuicio.getPrecio()));
    }

    public void GenerarCodJuicio() {
        char[] chars = "0123".toCharArray();

        int charsLength = chars.length;

        Random random = new Random();

        StringBuilder buffer = new StringBuilder();

        for (int i = 0; i < 3; i++) {

            buffer.append(chars[random.nextInt(charsLength)]);
        }

        vistajuicio.getCodigoJuicio().setText("JCO" + buffer.toString());
    }

    public void eliminar() {
        bdjuicio.setCodigo(vistajuicio.getCodigoJuicio().getText());
        int rest = JOptionPane.showConfirmDialog(null, "Esta Seguro de Eliminar");
        if (rest == 0) {
            if (bdjuicio.eliminar(vistajuicio.getCodigoJuicio().getText()));
            JOptionPane.showMessageDialog(null, "Usuario Eliminado");
            lista();
            nuevo();
        }

    }

    public void nuevo() {
        vistajuicio.getTxtNombre().setText("");
        vistajuicio.getTxtDescripcion().setText("");
        vistajuicio.getTxtPrecio().setText("");
        vistajuicio.getBtnguardarp().setEnabled(true);
        vistajuicio.getBtnmodificar().setEnabled(true);
        GenerarCodJuicio();
    }

    private void TxtBuscarJuicioFocusGained(java.awt.event.FocusEvent evt) {
        vistajuicio.getTxtBuscarJuicio().setText("");
        vistajuicio.getTxtBuscarJuicio().setForeground(Color.BLACK);

    }

    private void TxtBuscarJuicioFocusLost(java.awt.event.FocusEvent evt) {
        if (vistajuicio.getTxtBuscarJuicio().getText().isEmpty()) {
            vistajuicio.getTxtBuscarJuicio().setText("Ingrese el nombre");
            vistajuicio.getTxtBuscarJuicio().setForeground(Color.GRAY);
        }
    }

    public void BuscarJuicio() {
        if (vistajuicio.getTxtBuscarJuicio().getText().equals("")) {
            lista();
        } else {
            DefaultTableModel modelo;
            modelo = (DefaultTableModel) vistajuicio.getTableJuicio().getModel();

            List<TipoJuicioMD> lista = bdjuicio.buscardatosporcodigo(vistajuicio.getTxtBuscarJuicio().getText());
            int columnas = modelo.getColumnCount();

            for (int j = vistajuicio.getTableJuicio().getRowCount() - 1; j >= 0; j--) {
                modelo.removeRow(j);
            }

            for (int i = 0; i < lista.size(); i++) {
                modelo.addRow(new Object[columnas]);

                vistajuicio.getTableJuicio().setValueAt(lista.get(i).getCodigo(), i, 0);
                vistajuicio.getTableJuicio().setValueAt(lista.get(i).getNombre(), i, 1);
                vistajuicio.getTableJuicio().setValueAt(lista.get(i).getDescripcion(), i, 2);
                vistajuicio.getTableJuicio().setValueAt(lista.get(i).getPrecio(), i, 3);
            }
        }
    }
}
