package controlador;

import static controlador.C_Persona.vistapersona;
import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ClienteBD;
import modelo.ClienteMD;
import modelo.PersonaMD;
import vista.V_GesClient;

public class C_Cliente {

    public static V_GesClient vistacliente;
    private ClienteBD bdcliente = new ClienteBD();

    public void lista() {

        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistacliente.getTableCliente().getModel();
        List<ClienteMD> lista = bdcliente.mostrardatos();
        int columnas = modelo.getColumnCount();

        for (int j = vistacliente.getTableCliente().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);

        }
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            vistacliente.getTableCliente().setValueAt(lista.get(i).getCodigo(), i, 0);
            vistacliente.getTableCliente().setValueAt(lista.get(i).getCedula(), i, 1);
            vistacliente.getTableCliente().setValueAt(lista.get(i).getNombres(), i, 2);
            vistacliente.getTableCliente().setValueAt(lista.get(i).getTelefono(), i, 3);
            vistacliente.getTableCliente().setValueAt(lista.get(i).getEstado(), i, 4);

        }
    }

    public void guardar() {
        bdcliente.setCodigo(vistacliente.getLabelCodigo().getText());
        bdcliente.setCedula(vistacliente.getLabelCedula().getText());
        bdcliente.setNombres(vistacliente.getLabelNombres().getText());
        bdcliente.setTelefono(vistacliente.getLabelTelefono().getText());
        bdcliente.setEstado(vistacliente.getCmbEstadoCliente().getSelectedItem().toString());

        if (bdcliente.insertar()) {
            JOptionPane.showMessageDialog(null, "EXITO AL GUARDAR");
            lista();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
            lista();
        }

    }

    public void modificar() {
        bdcliente.setCedula(vistacliente.getTxtcedula().getText());
        bdcliente.setNombres(vistacliente.getTxtnombre().getText());
        bdcliente.setApellidos(vistacliente.getTxtapellido().getText());
        bdcliente.setTelefono(vistacliente.getTxttelefono().getText());
        bdcliente.setCorreo(vistacliente.getTxtcorreo().getText());
        int rest = JOptionPane.showConfirmDialog(null, "Esta Seguro de Modificar");
        if (rest == 0) {
            if (bdcliente.modificar(vistacliente.getTxtcedula().getText())) ;
            JOptionPane.showMessageDialog(null, "Datos Modificados");
            lista();
            nuevo();
        }

    }

    public void seleccionar() {
        vistacliente.getBtnguardarp().setEnabled(false);
        vistacliente.getBtnmodificar().setEnabled(true);
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistacliente.getTablapersona().getModel();
        String cedula = (String) modelo.getValueAt(vistacliente.getTablapersona().getSelectedRow(), 0);
        List<PersonaMD> lista = bdcliente.obtenerdatos(cedula);
        bdcliente.setCedula(lista.get(0).getCedula());
        vistacliente.getTxtcedula().setText(bdcliente.getCedula());
        bdcliente.setNombres(lista.get(0).getNombres());
        vistacliente.getTxtnombre().setText(bdcliente.getNombres());
        bdcliente.setApellidos(lista.get(0).getApellidos());
        vistacliente.getTxtapellido().setText(bdcliente.getApellidos());
        bdcliente.setTelefono(lista.get(0).getTelefono());
        vistacliente.getTxttelefono().setText(bdcliente.getTelefono());
        bdcliente.setCorreo(lista.get(0).getCorreo());
        vistacliente.getTxtcorreo().setText(bdcliente.getCorreo());

        Image img = lista.get(0).getFoto_perfil();
        if (img != null) {
            Image newimg = img.getScaledInstance(vistacliente.getLabelFoto().getWidth(), vistacliente.getLabelFoto().getHeight(), java.awt.Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(newimg);
            vistacliente.getLabelFoto().setIcon(icon);
        } else {
            vistacliente.getLabelFoto().setIcon(null);
        }

    }

    public void eliminar() {
        bdcliente.setCedula(vistacliente.getTxtcedula().getText());
        int rest = JOptionPane.showConfirmDialog(null, "Esta Seguro de Eliminar");
        if (rest == 0) {
            if (bdcliente.Eliminar(vistacliente.getTxtcedula().getText()));
            JOptionPane.showMessageDialog(null, "Usuario Eliminado");
            lista();
            nuevo();
        }

    }

    public void nuevo() {
        vistacliente.getTxtcedula().setText("");
        vistacliente.getTxtnombre().setText("");
        vistacliente.getTxtapellido().setText("");
        vistacliente.getTxttelefono().setText("");
        vistacliente.getTxtcorreo().setText("");
        vistacliente.getLabelFoto().setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/usuario.png")));
        vistacliente.getBtnguardarp().setEnabled(true);
        vistacliente.getBtnmodificar().setEnabled(false);
    }

    public void QuitarImagen() {
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro de quitar la foto?", null, JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_NO_OPTION) {
            vistacliente.getLabelFoto().setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/usuario.png")));
        }

    }

    private void labelBotonesMouseEntered(java.awt.event.MouseEvent evt) {
        vistacliente.getBtnguardarp().setVisible(true);
        vistacliente.getBtnnuevo().setVisible(true);
        vistacliente.getBtnmodificar().setVisible(true);
        vistacliente.getBtneliminar().setVisible(true);
    }

    private void labelBotonesMouseExited(java.awt.event.MouseEvent evt) {
        vistacliente.getBtnguardarp().setVisible(false);
        vistacliente.getBtnnuevo().setVisible(false);
        vistacliente.getBtnmodificar().setVisible(false);
        vistacliente.getBtneliminar().setVisible(false);
    }

    private void txtBuscarCedulaFocusGained(java.awt.event.FocusEvent evt) {
        vistacliente.getTxtBuscarCedula().setText("");
        vistacliente.getTxtBuscarCedula().setForeground(Color.BLACK);

    }

    private void txtBuscarCedulaFocusLost(java.awt.event.FocusEvent evt) {
        if (vistacliente.getTxtBuscarCedula().getText().isEmpty()) {
            vistacliente.getTxtBuscarCedula().setText("Ingrese el número de Cédula");
            vistacliente.getTxtBuscarCedula().setForeground(Color.GRAY);
        }
    }

    public void Buscar() {
        if (vistacliente.getTxtBuscarCedula().getText().equals("")) {
            lista();
        } else {
            DefaultTableModel model;
            model = (DefaultTableModel) vistacliente.getTablapersona().getModel();
            java.util.List<PersonaMD> lista = bdcliente.buscardatos(vistacliente.getTxtBuscarCedula().getText());
            int columnas = model.getColumnCount();
            for (int j = vistacliente.getTablapersona().getRowCount() - 1; j >= 0; j--) {
                model.removeRow(j);
            }
            for (int i = 0; i < lista.size(); i++) {
                model.addRow(new Object[columnas]);
                vistacliente.getTablapersona().setValueAt(lista.get(i).getCedula(), i, 0);
                vistacliente.getTablapersona().setValueAt(lista.get(i).getNombres(), i, 1);
                vistacliente.getTablapersona().setValueAt(lista.get(i).getApellidos(), i, 2);
                vistacliente.getTablapersona().setValueAt(lista.get(i).getTelefono(), i, 3);
                vistacliente.getTablapersona().setValueAt(lista.get(i).getCorreo(), i, 4);
                vistacliente.getTablapersona().setValueAt(lista.get(i).getFoto_perfil(), i, 5);
            }
        }
    }
}
