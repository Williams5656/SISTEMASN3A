package V93Controlador;

import static V93Controlador.CPersonas.VistaP;
import V93Vista.*;
import javax.swing.table.DefaultTableModel;
import V93Modelo.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;

public class CUsuarios {

    public static VistaUsuario VistaU;

    private UsuarioBD bdusuario = new UsuarioBD();
    private RolBD bdrol = new RolBD();
    private PersonaBD bdpersona = new PersonaBD();

    public CUsuarios(VistaUsuario VistaU) {
        this.VistaU = VistaU;
        VistaU.setVisible(true);
        VistaU.setLocationRelativeTo(null);
        lista();
        // cedulaUsuario();
        //rolUsuario();
        VistaU.getBtnNuevoUsuario().addActionListener(e -> nuevo());
        VistaU.getComborolu().setModel(bdusuario.rol());
        VistaU.getCombocedulau().setModel(bdusuario.cedula());
        VistaU.getBtnGuardarUsuario().addActionListener(x -> guardar());
        VistaU.getBtnModificarUsuario().addActionListener(e -> modificar());
        VistaU.getBtnEliminarUsuario().addActionListener(e -> eliminar());
        VistaU.getBtnbuscaru().addActionListener(e -> buscar());
        VistaU.getTableUsuario().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                seleccionar();
            }

        });
//        VistaU.getTxtbuscaru().addKeyListener(new java.awt.event.KeyAdapter() {
//            @Override
//            public void keyPressed(java.awt.event.KeyEvent evt) {
//                txtCedulabKeyPressed(evt);
//            }
//
//        });

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
            VistaU.getTableUsuario().setValueAt(lista.get(i).getCodigo(), i, 0);
            VistaU.getTableUsuario().setValueAt(lista.get(i).getCedula(), i, 1);
            VistaU.getTableUsuario().setValueAt(lista.get(i).getUsuario(), i, 2);
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
        bdusuario.setUsuario(VistaU.getTxtnombreu().getText());
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
        bdusuario.setUsuario(VistaU.getTxtnombreu().getText());
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
        bdusuario.setUsuario(lista.get(0).getUsuario());
        VistaU.getTxtnombreu().setText(bdusuario.getUsuario());
        bdusuario.setClave(lista.get(0).getClave());
        VistaU.getTxtpasswordu().setText(bdusuario.getClave());

        bdusuario.setCodigo_rol(lista.get(0).getCodigo_rol());
        VistaU.getComborolu().setSelectedItem(bdusuario.getCodigo_rol());

        bdusuario.setEstado(lista.get(0).getEstado());
        VistaU.getComboestadou().setSelectedItem(bdusuario.getEstado());
        bdusuario.setCorreo(lista.get(0).getCorreo());
        VistaU.getTxtcorreou().setText(bdusuario.getCorreo());
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

    public void buscar() {
        if (VistaU.getTxtbuscaru().getText().equals("")) {
            lista();
        } else {
            DefaultTableModel modelo;
            modelo = (DefaultTableModel) VistaU.getTableUsuario().getModel();
            List<UsuarioMb> lista = bdusuario.BuscarUsuario(VistaU.getTxtbuscaru().getText());
            int columnas = modelo.getColumnCount();

            for (int j = VistaU.getTableUsuario().getRowCount() - 1; j >= 0; j--) {
                modelo.removeRow(j);
            }
            for (int i = 0; i < lista.size(); i++) {
                modelo.addRow(new Object[columnas]);
                VistaU.getTableUsuario().setValueAt(lista.get(i).getCodigo(), i, 0);
                VistaU.getTableUsuario().setValueAt(lista.get(i).getCedula(), i, 1);
                VistaU.getTableUsuario().setValueAt(lista.get(i).getUsuario(), i, 2);
                VistaU.getTableUsuario().setValueAt(lista.get(i).getClave(), i, 3);
                VistaU.getTableUsuario().setValueAt(lista.get(i).getCodigo_rol(), i, 4);
                VistaU.getTableUsuario().setValueAt(lista.get(i).getEstado(), i, 5);
                VistaU.getTableUsuario().setValueAt(lista.get(i).getCorreo(), i, 6);
            }
        }
    }
//
//    private void txtCedulabKeyPressed(java.awt.event.KeyEvent evt) {
//        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//            if (!"".equals(VistaU.getTxtcedulab().getText())) {
//
//                List<PersonaMb> cl = bdpersona.obtenerdatos(VistaU.getTxtcedulab().getText());
//                for (int i = 0; i < cl.size(); i++) {
//                    if (cl.get(i).getNombre() != null) {
//                        VistaU.getLbnombre().setText("" + cl.get(i).getNombre());
//
//                    } else {
//                        VistaU.getTxtcedulab().setText("");
//                        JOptionPane.showMessageDialog(null, "El Cliente no Existe");
//                    }
//
//                }
//            }
//        }
//    }
}
