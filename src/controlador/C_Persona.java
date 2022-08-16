package controlador;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.PersonaBD;
import modelo.PersonaMD;
import vista.V_Persona;

public class C_Persona {

    public static V_Persona vistapersona;
    private PersonaBD bdpersona = new PersonaBD();

    public C_Persona(V_Persona vistapersona) {
        this.vistapersona = vistapersona;
        vistapersona.setVisible(true);
        lista();
        vistapersona.getBtnguardarp().setEnabled(false);
        vistapersona.getBtnmodificar().setEnabled(false);
        vistapersona.getBtnguardarp().setVisible(false);
        vistapersona.getBtnnuevo().setVisible(false);
        vistapersona.getBtnmodificar().setVisible(false);
        vistapersona.getBtneliminar().setVisible(false);
        vistapersona.getBtn_CargarFoto().addActionListener(x -> obtieneImagen());
        vistapersona.getBtn_QuitarFoto().addActionListener(x -> QuitarImagen());
        vistapersona.getBtnguardarp().addActionListener(x -> guardar());
        vistapersona.getBtnmodificar().addActionListener(x -> modificar());
        vistapersona.getBtneliminar().addActionListener(x -> eliminar());
        vistapersona.getTablapersona().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }

        });
        /*vistapersona.getLabelBotones().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelBotonesMouseEntered(evt);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelBotonesMouseExited(evt);
            }
        });*/

    }

    public void lista() {

        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistapersona.getTablapersona().getModel();
        List<PersonaMD> lista = bdpersona.mostrardatos();
        int columnas = modelo.getColumnCount();

        for (int j = vistapersona.getTablapersona().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);

        }
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            vistapersona.getTablapersona().setValueAt(lista.get(i).getCodigo(), i, 0);
            vistapersona.getTablapersona().setValueAt(lista.get(i).getCedula(), i, 1);
            vistapersona.getTablapersona().setValueAt(lista.get(i).getNombres(), i, 2);
            vistapersona.getTablapersona().setValueAt(lista.get(i).getApellidos(), i, 3);
            vistapersona.getTablapersona().setValueAt(lista.get(i).getUsuario(), i, 4);
            vistapersona.getTablapersona().setValueAt(lista.get(i).getClave(), i, 5);
            vistapersona.getTablapersona().setValueAt(lista.get(i).getTelefono(), i, 6);
            vistapersona.getTablapersona().setValueAt(lista.get(i).getCorreo(), i, 7);
            vistapersona.getTablapersona().setValueAt(lista.get(i).getRol(), i, 8);
            vistapersona.getTablapersona().setValueAt(lista.get(i).getFoto_perfil(), i, 9);

        }
    }

    public void guardar() {
        bdpersona.setCedula(vistapersona.getTxtcedula().getText());
        bdpersona.setNombres(vistapersona.getTxtnombre().getText());
        bdpersona.setApellidos(vistapersona.getTxtapellido().getText());
        bdpersona.setUsuario(vistapersona.getTxtusuario().getText());
        bdpersona.setClave(vistapersona.getjPasspersona().getText());
        bdpersona.setTelefono(vistapersona.getTxttelefono().getText());
        bdpersona.setCorreo(vistapersona.getTxtcorreo().getText());
        bdpersona.setRol(vistapersona.getCbrol().getSelectedItem().toString());

        ImageIcon ic = (ImageIcon) vistapersona.getLabelFoto().getIcon();
        bdpersona.setFoto_perfil(ic.getImage());

        if (bdpersona.insertar()) {
            JOptionPane.showMessageDialog(null, "EXITO AL GUARDAR");
            lista();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
            lista();
        }

    }

    private void obtieneImagen() {
        vistapersona.getLabelFoto().setIcon(null);
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = j.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                Image icono = ImageIO.read(j.getSelectedFile()).getScaledInstance(vistapersona.getLabelFoto().getWidth(), vistapersona.getLabelFoto().getHeight(), Image.SCALE_DEFAULT);
                vistapersona.getLabelFoto().setIcon(new ImageIcon(icono));
                vistapersona.getLabelFoto().updateUI();
            } catch (IOException ex) {
                Logger.getLogger(C_Persona.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void modificar() {
        bdpersona.setCedula(vistapersona.getTxtcedula().getText());
        bdpersona.setNombres(vistapersona.getTxtnombre().getText());
        bdpersona.setApellidos(vistapersona.getTxtapellido().getText());
        bdpersona.setUsuario(vistapersona.getTxtusuario().getText());
        bdpersona.setClave(vistapersona.getjPasspersona().getText());
        bdpersona.setTelefono(vistapersona.getTxttelefono().getText());
        bdpersona.setCorreo(vistapersona.getTxtcorreo().getText());
        bdpersona.setRol(vistapersona.getCbrol().getSelectedItem().toString());

        ImageIcon ic = (ImageIcon) vistapersona.getLabelFoto().getIcon();
        bdpersona.setFoto_perfil(ic.getImage());
        int rest = JOptionPane.showConfirmDialog(null, "Esta Seguro de Modificar");
        if (rest == 0) {
            if (bdpersona.modificar(vistapersona.getTxtcedula().getText())) ;
            JOptionPane.showMessageDialog(null, "Datos Modificados");
            lista();
            nuevo();
        }

    }

    public void seleccionar() {
        vistapersona.getBtnguardarp().setEnabled(false);
        vistapersona.getBtnmodificar().setEnabled(true);
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistapersona.getTablapersona().getModel();
        String cedula = (String) modelo.getValueAt(vistapersona.getTablapersona().getSelectedRow(), 0);
        List<PersonaMD> lista = bdpersona.obtenerdatos(cedula);
        bdpersona.setCedula(lista.get(0).getCedula());
        vistapersona.getTxtcedula().setText(bdpersona.getCedula());
        bdpersona.setNombres(lista.get(0).getNombres());
        vistapersona.getTxtnombre().setText(bdpersona.getNombres());
        bdpersona.setApellidos(lista.get(0).getApellidos());
        vistapersona.getTxtapellido().setText(bdpersona.getApellidos());
        bdpersona.setUsuario(lista.get(0).getUsuario());
        vistapersona.getTxtusuario().setText(bdpersona.getUsuario());
        bdpersona.setClave(lista.get(0).getClave());
        vistapersona.getjPasspersona().setText(bdpersona.getClave());
        bdpersona.setTelefono(lista.get(0).getTelefono());
        vistapersona.getTxttelefono().setText(bdpersona.getTelefono());
        bdpersona.setCorreo(lista.get(0).getCorreo());
        vistapersona.getTxtcorreo().setText(bdpersona.getCorreo());
        bdpersona.setRol(lista.get(0).getRol());
        vistapersona.getCbrol().setSelectedItem(bdpersona.getRol());

        Image img = lista.get(0).getFoto_perfil();
        if (img != null) {
            Image newimg = img.getScaledInstance(vistapersona.getLabelFoto().getWidth(), vistapersona.getLabelFoto().getHeight(), java.awt.Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(newimg);
            vistapersona.getLabelFoto().setIcon(icon);
        } else {
            vistapersona.getLabelFoto().setIcon(null);
        }

    }

    public void eliminar() {
        bdpersona.setCedula(vistapersona.getTxtcedula().getText());
        int rest = JOptionPane.showConfirmDialog(null, "Esta Seguro de Eliminar");
        if (rest == 0) {
            if (bdpersona.Eliminar(vistapersona.getTxtcedula().getText()));
            JOptionPane.showMessageDialog(null, "Usuario Eliminado");
            lista();
            nuevo();
        }

    }

    public void nuevo() {
        vistapersona.getTxtcedula().setText("");
        vistapersona.getTxtnombre().setText("");
        vistapersona.getTxtapellido().setText("");
        vistapersona.getTxtusuario().setText("");
        vistapersona.getjPasspersona().setText("");
        vistapersona.getTxttelefono().setText("");
        vistapersona.getTxtcorreo().setText("");
        vistapersona.getLabelFoto().setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/usuario.png")));
        vistapersona.getBtnguardarp().setEnabled(true);
        vistapersona.getBtnmodificar().setEnabled(false);
    }

    public void QuitarImagen() {
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro de quitar la foto?", null, JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_NO_OPTION) {
            vistapersona.getLabelFoto().setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/usuario.png")));
        }

    }

    private void labelBotonesMouseEntered(java.awt.event.MouseEvent evt) {
        vistapersona.getBtnguardarp().setVisible(true);
        vistapersona.getBtnnuevo().setVisible(true);
        vistapersona.getBtnmodificar().setVisible(true);
        vistapersona.getBtneliminar().setVisible(true);
    }

    private void labelBotonesMouseExited(java.awt.event.MouseEvent evt) {
        vistapersona.getBtnguardarp().setVisible(false);
        vistapersona.getBtnnuevo().setVisible(false);
        vistapersona.getBtnmodificar().setVisible(false);
        vistapersona.getBtneliminar().setVisible(false);
    }
}
