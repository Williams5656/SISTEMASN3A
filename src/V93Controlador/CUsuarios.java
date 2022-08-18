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
        cedulaUsuario();
        rolUsuario(); 
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
    private PersonaBD bdpersona = new PersonaBD();

    public void cedulaUsuario() {
        List<PersonaMb> listau = bdpersona.mostrardatos();
        for (int i = 0; i < listau.size(); i++) {
            VistaU.getCombocedulau().addItem(listau.get(i).getCedula());
        }
    }
    private RolBD bdrol = new RolBD();

    public void rolUsuario() {
        List<RolMb> listar = bdrol.mostrardatos();
        for (int i = 0; i < listar.size(); i++) {
            VistaU.getComborolu().addItem(listar.get(i).getCodigo());
        }
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
            VistaU.getTableUsuario().setValueAt(lista.get(i).getCodigo(), i, 0);
            VistaU.getTableUsuario().setValueAt(lista.get(i).getCedula(), i, 1);
            VistaU.getTableUsuario().setValueAt(lista.get(i).getNombre_usuario(), i, 2);
            VistaU.getTableUsuario().setValueAt(lista.get(i).getClave(), i, 3);
            VistaU.getTableUsuario().setValueAt(lista.get(i).getCodigo_rol(), i, 4);
            VistaU.getTableUsuario().setValueAt(lista.get(i).getEstado(), i, 5);
            VistaU.getTableUsuario().setValueAt(lista.get(i).getCorreo(), i, 6);

        }
    }

    public void nuevo() {
        VistaU.getTxtcodigou().setText("");
        VistaU.getCombocedulau().setSelectedItem("");
        VistaU.getTxtnombreu().setText("");
        VistaU.getTxtpasswordu().setText("");
        VistaU.getComborolu().setSelectedItem("");
        VistaU.getComboestadou().setSelectedItem("");
        VistaU.getTxtcorreou().setText("");

        VistaU.getBtnGuardarUsuario().setEnabled(true);
        VistaU.getBtnModificarUsuario().setEnabled(false);

    }

    public void guardar() {
        bdusuario.setCodigo(VistaU.getTxtcodigou().getText());
        String cedula = (String) VistaU.getCombocedulau().getSelectedItem();
        bdusuario.setCedula(cedula);
        bdusuario.setNombre_usuario(VistaU.getTxtnombreu().getText());
        bdusuario.setClave(VistaU.getTxtpasswordu().getText());
        String cod_rol = (String) VistaU.getComborolu().getSelectedItem();
        bdusuario.setCodigo_rol(cod_rol);
        String estado = (String) VistaU.getComboestadou().getSelectedItem();
        bdusuario.setEstado(estado);
        bdusuario.setCorreo(VistaU.getTxtcorreou().getText());
      
        if (bdusuario.insertar()) {
            JOptionPane.showMessageDialog(null, "EXITO AL GUARDAR");
            lista();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
        }
    }

    public void modificar() {
        bdusuario.setCodigo(VistaU.getTxtcodigou().getText());
        String cedula = (String) VistaU.getCombocedulau().getSelectedItem();
        bdusuario.setCedula(cedula);
        bdusuario.setNombre_usuario(VistaU.getTxtnombreu().getText());
        bdusuario.setClave(VistaU.getTxtpasswordu().getText());
        String cod_rol = (String) VistaU.getComborolu().getSelectedItem();
        bdusuario.setEstado(cod_rol);
        String estado = (String) VistaU.getComboestadou().getSelectedItem();
        bdusuario.setEstado(estado);
        bdusuario.setCorreo(VistaU.getTxtcorreou().getText());

        int resp = JOptionPane.showConfirmDialog(null, "confirme si desea modificar");
        if (resp == 0) {
            if (bdusuario.modificar(VistaU.getTxtcodigou().getText()));
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
        String codigo = (String) modelo.getValueAt(VistaU.getTableUsuario().getSelectedRow(), 0);
        List<UsuarioMb> lista = bdusuario.obtenerdatos(codigo);
        bdusuario.setCodigo(lista.get(0).getCodigo());
        VistaU.getTxtcodigou().setText(bdusuario.getCodigo());
        bdusuario.setCedula(lista.get(0).getCedula());
        VistaU.getCombocedulau().setSelectedItem(bdusuario.getCedula());
        bdusuario.setNombre_usuario(lista.get(0).getNombre_usuario());
        VistaU.getTxtnombreu().setText(bdusuario.getNombre_usuario());
        bdusuario.setClave(lista.get(0).getClave());
        VistaU.getTxtpasswordu().setText(bdusuario.getClave());
        bdusuario.setCodigo_rol(lista.get(0).getCodigo_rol());
        VistaU.getComborolu().setSelectedItem(bdusuario.getCodigo_rol());
        bdusuario.setEstado(lista.get(0).getEstado());
        VistaU.getComboestadou().setSelectedItem(bdusuario.getEstado());
    }

    public void eliminar() {
        bdusuario.setCodigo(VistaU.getTxtcodigou().getText());
        int resp = JOptionPane.showConfirmDialog(null, "confirme si desea eliminar" + VistaU.getTxtcodigou().getText());
        if (resp == 0) {
            if (bdusuario.eliminar(VistaU.getTxtcodigou().getText()));
            JOptionPane.showMessageDialog(null, "datos actualizados");
            lista();
            nuevo();
        }
    }
}
