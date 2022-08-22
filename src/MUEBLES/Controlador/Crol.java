package MUEBLES.Controlador;


import MUEBLES.Modelo.M_rolMD;
import MUEBLES.Modelo.rol_BD;
import MUEBLES.Vista.Vista_rol;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Crol {

    public static Vista_rol vista;
    private rol_BD bdrol = new rol_BD();

    public Crol(Vista_rol vista) {
        this.vista = vista;
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        
        lista();
        
        vista.getBtnguardar().addActionListener(e -> guarda());
        vista.getBtnmodificar().addActionListener(e -> modifica());
        vista.getBtneliminar().addActionListener(e -> eliminar());
        vista.getBtnbuscar().addActionListener(e -> buscar());
        
        vista.getTablarol().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                seleccionar();
            }
        ;

    }

    );
    }
    
    public void buscar() {
        if (vista.getTxtbuscar().getText().equals("")) {
            lista();
        } else {
            DefaultTableModel modelo;
            modelo = (DefaultTableModel) vista.getTablarol().getModel();
            List<M_rolMD> lista = bdrol.obtenerdatos(vista.getTxtbuscar().getText());
            int columnas = modelo.getColumnCount();
            for (int j = vista.getTablarol().getRowCount() - 1; j >= 0; j--) {
                modelo.removeRow(j);
            }
            for (int i = 0; i < lista.size(); i++) {

                //if (lista.get(i).getCedula().equals(vista.getTxtbuscar().getText())) {
                modelo.addRow(new Object[columnas]);
                vista.getTablarol().setValueAt(lista.get(i).getCodigo(), i, 0);
                vista.getTablarol().setValueAt(lista.get(i).getNombre(), i, 1);
                vista.getTablarol().setValueAt(lista.get(i).getDescripcion(), i, 2);
                vista.getTablarol().setValueAt(lista.get(i).getEstado(), i, 3);

            }
        }
    }

    public void lista() {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTablarol().getModel();
        List<M_rolMD> lista = bdrol.mostrardatos();
        int columnas = modelo.getColumnCount();
        for (int j = vista.getTablarol().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);
        }
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            vista.getTablarol().setValueAt(lista.get(i).getCodigo(), i, 0);
            vista.getTablarol().setValueAt(lista.get(i).getNombre(), i, 1);
            vista.getTablarol().setValueAt(lista.get(i).getDescripcion(), i, 2);
            vista.getTablarol().setValueAt(lista.get(i).getEstado(), i, 3);

        }
    }

//    public void nombrescombo(){
//        List<M_rolMD> lista = bdrol.mostrardatos();
//        for (int i = 0; i < lista.size(); i++) {
//            vista.getCobnombre().addItem(lista.get(i).getNombre());
//        }
//    }
//    
//    public void guardarcodigo(){
//        List<M_rolMD> lista = bdrol.mostrardatos();
//        int idselecccionado = vista.getCobnombre().getSelectionIndex();
//        int idrol = lista.get(idselecccionado).getCodigo();
//        
//    }
    public void guarda() {
        bdrol.setCodigo(vista.getTxtcodigo().getText());
        bdrol.setNombre(vista.getTxtnombre().getText());
        bdrol.setDescripcion(vista.getTxtArea_descripcion().getText());
        String estado = (String) vista.getCobestado().getSelectedItem();
        bdrol.setEstado(estado);

        if (bdrol.insert()) {
            JOptionPane.showMessageDialog(null, "GUARDADO CORRECTO");
            lista();
            nuevo();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
        }
    }

    public void modifica() {
        bdrol.setNombre(vista.getTxtnombre().getText());
        bdrol.setDescripcion(vista.getTxtArea_descripcion().getText());
        String estado = (String) vista.getCobestado().getSelectedItem();
        bdrol.setEstado(estado);

        int res = JOptionPane.showConfirmDialog(null, "ESTA SEGURO DE MODIFICAR");
        if (res == 0) {
            if (bdrol.modificar(vista.getTxtcodigo().getText())) {
                JOptionPane.showMessageDialog(null, "datos actualizados");
                lista();
                nuevo();
            }
        }
    }

    public void seleccionar() {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTablarol().getModel();
        String cedula = (String) modelo.getValueAt(vista.getTablarol().getSelectedRow(), 0);

        List<M_rolMD> lista = bdrol.obtenerdatos(cedula);

        bdrol.setCodigo(lista.get(0).getCodigo());
        vista.getTxtcodigo().setText(bdrol.getCodigo());
        bdrol.setNombre(lista.get(0).getNombre());
        vista.getTxtnombre().setText(bdrol.getNombre());
        bdrol.setDescripcion(lista.get(0).getDescripcion());
        vista.getTxtArea_descripcion().setText(bdrol.getDescripcion());
        bdrol.setEstado(lista.get(0).getEstado());
        vista.getCobestado().setSelectedItem(bdrol.getEstado());
    }

    public void nuevo() {
        vista.getTxtcodigo().setText("");
        vista.getTxtnombre().setText("");
        vista.getTxtArea_descripcion().setText("");
        vista.getCobestado().setSelectedItem(0);

    }

    public void eliminar() {
        bdrol.setCodigo(vista.getTxtcodigo().getText());
        int res = JOptionPane.showConfirmDialog(null, "ESTA SEGURO DE ELIMINAR EL USUARIO " + vista.getTxtcodigo().getText());
        if (res == 0) {
            if (bdrol.eliminar(vista.getTxtcodigo().getText())) {
                JOptionPane.showMessageDialog(null, "DATOS ELIMINADOS");
                lista();
                nuevo();

            }
        }
    }
}
