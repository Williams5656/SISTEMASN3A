package controlador;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.*;
import vista.V_Usuario;

public class C_Usuario {
      public static V_Usuario vistausuario;
    public UsuarioBD bdusuario = new UsuarioBD();

 public C_Usuario(V_Usuario vistaUsuario) {
        this.vistausuario = vistaUsuario;
        vistaUsuario.setVisible(true);
        vistaUsuario.getTxtCedula().addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCedulaFocusGained(evt);
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCedulaFocusLost(evt);
            }
        });
   
    }
    
    public void lista() {

        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistausuario.getTableUsuario().getModel();
        List<UsuarioMD> lista = bdusuario.mostrardatos();
        int columnas = modelo.getColumnCount();

        for (int j = vistausuario.getTableUsuario().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);

        }
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            vistausuario.getTableUsuario().setValueAt(lista.get(i).getCodUsuario(), i, 0);
            vistausuario.getTableUsuario().setValueAt(lista.get(i).getCedula(), i, 1);
            vistausuario.getTableUsuario().setValueAt(lista.get(i).getUsuario(), i, 2);
            vistausuario.getTableUsuario().setValueAt(lista.get(i).getClave(), i, 3);
            vistausuario.getTableUsuario().setValueAt(lista.get(i).getRol(), i, 4);
            vistausuario.getTableUsuario().setValueAt(lista.get(i).getEstado(), i, 5);

        }
    }

    public void guardar() {
        bdusuario.setCodUsuario(vistausuario.getLabelCodigoRol().getText());
        bdusuario.setCedula(vistausuario.getTxtCedula().getText());
        bdusuario.setUsuario(vistausuario.getTxtUsuario().getText());
        bdusuario.setClave(vistausuario.getJPassClave().getText());
        bdusuario.setRol(vistausuario.getCmbRol().getSelectedItem().toString());
        bdusuario.setEstado(vistausuario.getLabelEstado().getText());

        if (bdusuario.insertar()) {
            JOptionPane.showMessageDialog(null, "EXITO AL GUARDAR");
            lista();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
            lista();
        }

    }

  
    public void modificar() {
        bdusuario.setCodUsuario(vistausuario.getLabelCodigoRol().getText());
        bdusuario.setCedula(vistausuario.getTxtCedula().getText());
        bdusuario.setUsuario(vistausuario.getTxtUsuario().getText());
        bdusuario.setClave(vistausuario.getJPassClave().getText());
        bdusuario.setRol(vistausuario.getCmbRol().getSelectedItem().toString());
        bdusuario.setEstado(vistausuario.getLabelEstado().getText());
      
        int rest = JOptionPane.showConfirmDialog(null, "Esta Seguro de Modificar");
        if (rest == 0) {
            if (bdusuario.modificar(vistausuario.getLabelCodigoRol().getText())) ;
            JOptionPane.showMessageDialog(null, "Datos Modificados");
            lista();
            nuevo();
        }

    }

    public void seleccionar() {
        vistausuario.getBtnguardarp().setEnabled(false);
        vistausuario.getBtnmodificar().setEnabled(true);
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistausuario.getTableUsuario().getModel();
        String cedula = (String) modelo.getValueAt(vistausuario.getTableUsuario().getSelectedRow(), 0);
        List<UsuarioMD> lista = bdusuario.obtenerdatos(cedula);
        bdusuario.setCodUsuario(lista.get(0).getCodUsuario());
        vistausuario.getLabelCodigoUsuario().setText(bdusuario.getCodUsuario());
        bdusuario.setCedula(lista.get(0).getCedula());
        vistausuario.getTxtCedula().setText(bdusuario.getCedula());
        bdusuario.setUsuario(lista.get(0).getUsuario());
        vistausuario.getTxtUsuario().setText(bdusuario.getUsuario());
        bdusuario.setClave(lista.get(0).getClave());
        vistausuario.getJPassClave().setText(bdusuario.getClave());
        bdusuario.setRol(lista.get(0).getRol());
        vistausuario.getCmbRol().setSelectedItem(bdusuario.getRol());
        bdusuario.setEstado(lista.get(0).getEstado());
        vistausuario.getLabelEstado().setText(bdusuario.getEstado());

      

    }

    public void eliminar() {
        bdusuario.setCedula(vistausuario.getLabelCodigoUsuario().getText());
        int rest = JOptionPane.showConfirmDialog(null, "Esta Seguro de Eliminar");
        if (rest == 0) {
            if (bdusuario.eliminar(vistausuario.getLabelCodigoUsuario().getText()));
            JOptionPane.showMessageDialog(null, "Usuario Eliminado");
            lista();
            nuevo();
        }

    }

    public void nuevo() {
        vistausuario.getTxtCedula().setText("");
        vistausuario.getTxtUsuario().setText("");
        vistausuario.getBtnguardarp().setEnabled(true);
        vistausuario.getBtnmodificar().setEnabled(false);
    }

  
  

    private void txtCedulaFocusGained(java.awt.event.FocusEvent evt) {
        vistausuario.getTxtCedula().setText("");
        vistausuario.getTxtCedula().setForeground(Color.BLACK);

    }

    private void txtCedulaFocusLost(java.awt.event.FocusEvent evt) {
        if (vistausuario.getTxtCedula().getText().isEmpty()) {
            vistausuario.getTxtCedula().setText("Ingrese el número de Cédula");
            vistausuario.getTxtCedula().setForeground(Color.GRAY);
        }
    }

   
}
