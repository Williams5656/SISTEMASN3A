
package Papeleria_Bella.controlador;

import Papeleria_Bella.controlador.*;
import Papeleria_Bella.vista.*;
import Papeleria_Bella.modelo.*;
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

public class Cpersona {
    public static Vpersona vistap;
    
    private PersonaBD bpersona = new PersonaBD();
    
    public Cpersona(Vpersona vistap) {
        this.vistap = vistap;
        vistap.setVisible(true);
        vistap.setLocationRelativeTo(null);
        lista();
        vistap.getButtonguardar().addActionListener(e -> guardar());
        vistap.getButtonguardar().setEnabled(true);
        vistap.getButtoncargar().addActionListener(e -> obtieneImagen());
        vistap.getButtoncargar().setEnabled(true);
    }
    
    public void lista() {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistap.getTablapersona().getModel();
        List<PersonaMD> lista = bpersona.mostrardatos();
        int columnas = modelo.getColumnCount();
        for (int j = vistap.getTablapersona().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);
        }
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            vistap.getTablapersona().setValueAt(lista.get(i).getCedula(), i, 0);
            vistap.getTablapersona().setValueAt(lista.get(i).getNombres(), i, 1);
            vistap.getTablapersona().setValueAt(lista.get(i).getApellidos(), i, 2);
            vistap.getTablapersona().setValueAt(lista.get(i).getTelefono(), i, 3);
            vistap.getTablapersona().setValueAt(lista.get(i).getDireccion(), i, 4);
            vistap.getTablapersona().setValueAt(lista.get(i).getEmail(), i, 5);
            vistap.getTablapersona().setValueAt(lista.get(i).getRol(), i, 6);

        }
    }
    
    public void nuevo(){
        vistap.getTxtcedula().setText("");
        vistap.getTxtnombres().setText("");
        vistap.getTxtapellidos().setText("");
        vistap.getTxttelefono().setText("");
        vistap.getTxtdireccion().setText("");
        vistap.getTxtemail().setText("");
        vistap.getComborol().setSelectedItem("");
        vistap.getButtonguardar().setEnabled(true);
        vistap.getButtonmodificar().setEnabled(true);
    }
    public void guardar() {
        bpersona.setCedula(vistap.getTxtcedula().getText());
        bpersona.setNombres(vistap.getTxtnombres().getText());
        bpersona.setApellidos(vistap.getTxtapellidos().getText());
        bpersona.setTelefono(vistap.getTxttelefono().getText());
        bpersona.setDireccion(vistap.getTxtdireccion().getText());
        bpersona.setEmail(vistap.getTxtemail().getText());
        bpersona.setRol(vistap.getComborol().getSelectedItem().toString());
        ImageIcon ic = (ImageIcon) vistap.getLabelfoto().getIcon();
        bpersona.setFoto(ic.getImage());
        if (bpersona.insertar()) {
            JOptionPane.showMessageDialog(null, "GUARDADO CORRECTAMENTE");
            lista();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
        }
    }
    public void modificar() {
        bpersona.setCedula(vistap.getTxtcedula().getText());
        bpersona.setNombres(vistap.getTxtnombres().getText());
        bpersona.setApellidos(vistap.getTxtapellidos().getText());
        bpersona.setTelefono(vistap.getTxttelefono().getText());
        bpersona.setDireccion(vistap.getTxtdireccion().getText());
        bpersona.setEmail(vistap.getTxtemail().getText());
        String rol = (String) vistap.getComborol().getSelectedItem();
        bpersona.setRol(rol);
        int resp = JOptionPane.showConfirmDialog(null, "Esta seguro de modificar");
        if (resp == 0) {
            if (bpersona.modificar(vistap.getTxtcedula().getText())) {
                JOptionPane.showMessageDialog(null, "Datos Actualizados");
                lista();
                nuevo();
                vistap.getButtonmodificar().setEnabled(false);
            }
        }

    }
    
    private void obtieneImagen() {
        vistap.getLabelfoto().setIcon(null);
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = j.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                Image icono = ImageIO.read(j.getSelectedFile()).getScaledInstance(vistap.getLabelfoto().getWidth(), vistap.getLabelfoto().getHeight(), Image.SCALE_DEFAULT);
                vistap.getLabelfoto().setIcon(new ImageIcon(icono));
                vistap.getLabelfoto().updateUI();
            } catch (IOException ex) {
                Logger.getLogger(Cpersona.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void eliminar(){
        bpersona.setCedula(vistap.getTxtcedula().getText());
        int resp = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar el usuario  "+vistap.getTxtcedula().getText());
        if (resp == 0) {
            if (bpersona.eliminar(vistap.getTxtcedula().getText())) {
                JOptionPane.showMessageDialog(null, "Datos Actualizados");
                lista();
                nuevo();
                
            }
        }
    }
}
