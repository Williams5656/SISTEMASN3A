package V93Controlador;

import V93Vista.*;
import javax.swing.table.DefaultTableModel;
import V93Modelo.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;

public class CUsuarios {
   
    public static VistaUsuario VistaU;
    
    private UsuarioBD bdusuario = new UsuarioBD();

    public CUsuarios(VistaUsuario VistaU) {
        this.VistaU = VistaU;
        VistaU.setVisible(true);
        VistaU.setLocationRelativeTo(null);
        lista();
        VistaU.getBtnGuardarUsuario().addActionListener(x -> guardar());
        VistaU.getBtnModificarUsuario().addActionListener(e -> modificar());
        VistaU.getTableUsuario().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                seleccionar();
            }

        });

        VistaU.getBtnNuevoUsuario().addActionListener(e -> nuevo());
        VistaU.getBtnEliminarUsuario().addActionListener(e -> eliminar());

        VistaU.getBtnGuardarUsuario().setEnabled(false);
        VistaU.getBtnModificarUsuario().setEnabled(false);
    }

    public void lista() {

        DefaultTableModel modelo;
        modelo = (DefaultTableModel) VistaU.getTableUsuario().getModel();
        List<UsuarioMb> lista = bdusuario.mostrardatos();
        int columnas = modelo.getColumnCount();

        for (int j = VistaU.getTableUsuario().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);

        }
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            VistaU.getTableUsuario().setValueAt(lista.get(i).getCedula(), i, 0);
            VistaU.getTableUsuario().setValueAt(lista.get(i).getNombre(), i, 1);
            VistaU.getTableUsuario().setValueAt(lista.get(i).getCorreo(), i, 2);
            VistaU.getTableUsuario().setValueAt(lista.get(i).getClave(), i, 3);
            VistaU.getTableUsuario().setValueAt(lista.get(i).getRol(), i, 4);
            VistaU.getTableUsuario().setValueAt(lista.get(i).getEstado(), i, 5);

        }
    }

    public void nuevo() {
        VistaU.getTxtCedulaUsuario().setText("");
        VistaU.getTxtNombreUsuario().setText("");
        VistaU.getTxtCorreoUsuario().setText("");
        VistaU.getTxtPasswordUsuario().setText("");
        VistaU.getjComboBoxRolUsuario().setSelectedItem("");
        VistaU.getjComboBoxEstadoUsuario().setSelectedItem("");

        VistaU.getBtnGuardarUsuario().setEnabled(true);
        VistaU.getBtnModificarUsuario().setEnabled(false);

    }

    public void guardar() {
        bdusuario.setCedula(VistaU.getTxtCedulaUsuario().getText());
        bdusuario.setNombre(VistaU.getTxtNombreUsuario().getText());
        bdusuario.setCorreo(VistaU.getTxtCorreoUsuario().getText());
        bdusuario.setClave(VistaU.getTxtPasswordUsuario().getText());
        String rol = (String) VistaU.getjComboBoxRolUsuario().getSelectedItem();
        bdusuario.setRol(rol);
        String estado = (String) VistaU.getjComboBoxEstadoUsuario().getSelectedItem();
        bdusuario.setEstado(estado);

        if (bdusuario.insertar()) {
            JOptionPane.showMessageDialog(null, "EXITO AL GUARDAR");
            lista();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
        }
    }

    public void modificar() {
        bdusuario.setCedula(VistaU.getTxtCedulaUsuario().getText());
        bdusuario.setNombre(VistaU.getTxtNombreUsuario().getText());
        bdusuario.setCorreo(VistaU.getTxtCorreoUsuario().getText());
        bdusuario.setClave(VistaU.getTxtPasswordUsuario().getText());
        String rol = (String) VistaU.getjComboBoxRolUsuario().getSelectedItem();
        bdusuario.setRol(rol);
        String estado = (String) VistaU.getjComboBoxEstadoUsuario().getSelectedItem();
        bdusuario.setEstado(estado);

        int resp = JOptionPane.showConfirmDialog(null, "confirme si desea modificar");
        if (resp == 0) {
            if (bdusuario.modificar(VistaU.getTxtCedulaUsuario().getText()));
            JOptionPane.showMessageDialog(null, "datos actualizados");
            lista();
            nuevo();
        }
    }

    public void seleccionar() {
        VistaU.getBtnGuardarUsuario().setEnabled(false);
        VistaU.getBtnModificarUsuario().setEnabled(true);
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) VistaU.getTableUsuario().getModel();
        String cedula = (String) modelo.getValueAt(VistaU.getTableUsuario().getSelectedRow(), 0);
        List<UsuarioMb> lista = bdusuario.obtenerdatos(cedula);
        bdusuario.setCedula(lista.get(0).getCedula());
        VistaU.getTxtCedulaUsuario().setText(bdusuario.getCedula());
        bdusuario.setNombre(lista.get(0).getNombre());
        VistaU.getTxtNombreUsuario().setText(bdusuario.getNombre());
        bdusuario.setCorreo(lista.get(0).getCorreo());
        VistaU.getTxtCorreoUsuario().setText(bdusuario.getCorreo());
        bdusuario.setClave(lista.get(0).getClave());
        VistaU.getTxtPasswordUsuario().setText(bdusuario.getClave());
        bdusuario.setRol(lista.get(0).getRol());
        VistaU.getjComboBoxRolUsuario().setSelectedItem(bdusuario.getRol());
        bdusuario.setEstado(lista.get(0).getEstado());
        VistaU.getjComboBoxEstadoUsuario().setSelectedItem(bdusuario.getEstado());
    }

    public void eliminar() {
        bdusuario.setCedula(VistaU.getTxtCedulaUsuario().getText());
        int resp = JOptionPane.showConfirmDialog(null, "confirme si desea eliminar" + VistaU.getTxtCedulaUsuario().getText());
        if (resp == 0) {
            if (bdusuario.eliminar(VistaU.getTxtCedulaUsuario().getText()));
            JOptionPane.showMessageDialog(null, "datos actualizados");
            lista();
            nuevo();
        }
    }
}
