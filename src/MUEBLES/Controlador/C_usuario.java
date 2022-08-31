package MUEBLES.Controlador;

import MUEBLES.Modelo.*;
import MUEBLES.Vista.*;
import MUEBLES.Vista.Vista_usuario;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class C_usuario {

    public static Vista_usuario vistaus;
    private Usuario_BD bdusuario = new Usuario_BD();
    private rol_BD bdrol = new rol_BD();

    public C_usuario(Vista_usuario vistaus) {
        this.vistaus = vistaus;

        vistaus.setVisible(true);
        vistaus.setLocationRelativeTo(null);

        codigorol();
        lista();

        vistaus.getBtnguardar().addActionListener(e -> guarda());
        vistaus.getBtnguardar().addActionListener(e -> guardarcogigo());
        vistaus.getBtnmodificar().addActionListener(e -> modifica());
        vistaus.getBtneliminar().addActionListener(e -> eliminar());
        vistaus.getBtnbuscar().addActionListener(e -> buscar());

        vistaus.getTablausuario().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                seleccionar();
            }
        ;

    }

    );
    }
    
    public void buscar() {
        if (vistaus.getTxtbuscar().getText().equals("")) {
            lista();
        } else {
            DefaultTableModel modelo;
            modelo = (DefaultTableModel) vistaus.getTablausuario().getModel();
            List<M_usuario_MD> lista = bdusuario.obtenerdatos(vistaus.getTxtbuscar().getText());
            int columnas = modelo.getColumnCount();
            for (int j = vistaus.getTablausuario().getRowCount() - 1; j >= 0; j--) {
                modelo.removeRow(j);
            }
            for (int i = 0; i < lista.size(); i++) {

                //if (lista.get(i).getCedula().equals(vista.getTxtbuscar().getText())) {
                modelo.addRow(new Object[columnas]);
                vistaus.getTablausuario().setValueAt(lista.get(i).getCodigo(), i, 0);
                vistaus.getTablausuario().setValueAt(lista.get(i).getCedula_persona(), i, 1);
                vistaus.getTablausuario().setValueAt(lista.get(i).getUsuario(), i, 2);
                vistaus.getTablausuario().setValueAt(lista.get(i).getContrasena(), i, 3);
                vistaus.getTablausuario().setValueAt(lista.get(i).getCodigo_rol(), i, 4);
                vistaus.getTablausuario().setValueAt(lista.get(i).getEstado(), i, 5);

            }
        }
    }

    public void lista() {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistaus.getTablausuario().getModel();
        List<M_usuario_MD> lista = bdusuario.mostrardatos();
        int columnas = modelo.getColumnCount();
        for (int j = vistaus.getTablausuario().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);
        }
        for (int i = 0; i < lista.size(); i++) {
            vistaus.getTablausuario().setValueAt(lista.get(i).getCodigo(), i, 0);
            vistaus.getTablausuario().setValueAt(lista.get(i).getCedula_persona(), i, 1);
            vistaus.getTablausuario().setValueAt(lista.get(i).getUsuario(), i, 2);
            vistaus.getTablausuario().setValueAt(lista.get(i).getContrasena(), i, 3);
            vistaus.getTablausuario().setValueAt(lista.get(i).getCodigo_rol(), i, 4);
            vistaus.getTablausuario().setValueAt(lista.get(i).getEstado(), i, 5);

        }
    }

    public void guarda() {
        bdusuario.setCodigo(vistaus.getTxtcodigousuario().getText());
        bdusuario.setCedula_persona(vistaus.getTxtcedulapersona().getText());
        bdusuario.setUsuario(vistaus.getTxtusuario().getText());
        bdusuario.setContrasena(vistaus.getTxtcontraseña().getText());
        String rol = (String) vistaus.getCobcodigorol().getSelectedItem();
        bdusuario.setCodigo_rol(rol);
        String estado = (String) vistaus.getCobestado().getSelectedItem();
        bdusuario.setEstado(estado);

        if (bdusuario.insert()) {
            JOptionPane.showMessageDialog(null, "GUARDADO CORRECTO");
            lista();
            nuevo();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
        }
    }

    public void modifica() {
        bdusuario.setCodigo(vistaus.getTxtcodigousuario().getText());
        bdusuario.setCedula_persona(vistaus.getTxtcedulapersona().getText());
        bdusuario.setUsuario(vistaus.getTxtusuario().getText());
        bdusuario.setContrasena(vistaus.getTxtcontraseña().getText());
        String rol = (String) vistaus.getCobcodigorol().getSelectedItem();
        bdusuario.setCodigo_rol(rol);
        String estado = (String) vistaus.getCobestado().getSelectedItem();
        bdusuario.setEstado(estado);

        int res = JOptionPane.showConfirmDialog(null, "ESTA SEGURO DE MODIFICAR");
        if (res == 0) {
            if (bdusuario.modificar(vistaus.getTxtcodigousuario().getText())) {
                JOptionPane.showMessageDialog(null, "datos actualizados");
                lista();
                nuevo();
            }
        }
    }

    public void seleccionar() {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistaus.getTablausuario().getModel();
        String cedula = (String) modelo.getValueAt(vistaus.getTablausuario().getSelectedRow(), 0);

        List<M_usuario_MD> lista = bdusuario.obtenerdatos(cedula);

        bdusuario.setCodigo(lista.get(0).getCodigo());
        vistaus.getTxtcodigousuario().setText(bdusuario.getCodigo());
        bdusuario.setCedula_persona(lista.get(0).getCedula_persona());
        vistaus.getTxtcedulapersona().setText(bdusuario.getCedula_persona());
        bdusuario.setUsuario(lista.get(0).getUsuario());
        vistaus.getTxtusuario().setText(bdusuario.getUsuario());
        bdusuario.setContrasena(lista.get(0).getContrasena());
        vistaus.getTxtcontraseña().setText(bdusuario.getContrasena());
        bdusuario.setCodigo_rol(lista.get(0).getCodigo_rol());
        vistaus.getCobcodigorol().setSelectedItem(bdusuario.getCodigo_rol());
        bdusuario.setEstado(lista.get(0).getEstado());
        vistaus.getCobestado().setSelectedItem(bdusuario.getEstado());
    }

    public void nuevo() {
        vistaus.getTxtcodigousuario().setText("");
        vistaus.getTxtcedulapersona().setText("");
        vistaus.getTxtusuario().setText("");
        vistaus.getTxtcontraseña().setText("");
        vistaus.getCobcodigorol().setSelectedItem(0);
        vistaus.getCobestado().setSelectedItem(0);

    }

    public void eliminar() {
        bdusuario.setCodigo(vistaus.getTxtcodigousuario().getText());
        int res = JOptionPane.showConfirmDialog(null, "ESTA SEGURO DE ELIMINAR EL USUARIO " + vistaus.getTxtcodigousuario().getText());
        if (res == 0) {
            if (bdusuario.eliminar(vistaus.getTxtcodigousuario().getText())) {
                JOptionPane.showMessageDialog(null, "DATOS ELIMINADOS");
                lista();
                nuevo();

            }
        }
    }

    public void codigorol() {
        List<M_rolMD> lista = bdrol.mostrardatos();
        for (int i = 0; i < lista.size(); i++) {
            vistaus.getCobcodigorol().addItem(lista.get(i).getNombre());
        }
    }

    public void guardarcogigo() {
        List<M_rolMD> lista = bdrol.mostrardatos();
        int ideseleccionado = vistaus.getCobcodigorol().getSelectedIndex();
        String codigo = lista.get(ideseleccionado).getCodigo();

    }

}
