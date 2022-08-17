package MUEBLES.Controlador;

import static MUEBLES.Controlador.Cmueblesprincipal.vistaprin;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import MUEBLES.Vista.*;
import MUEBLES.Modelo.*;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

public class C_muebles_persona {
    
    public static Vista_persona_muebles vistaper;
    private Persona_BD_muebles bdpersona = new Persona_BD_muebles();
    
    public C_muebles_persona(Vista_persona_muebles vistaper){
        this.vistaper = vistaper;
        vistaper.setVisible(true);
        vistaper.setLocationRelativeTo(null);
        
        lista();
        vistaper.getBtnguardar_persona().addActionListener(e -> guardar());
        vistaper.getBtnmodificar().addActionListener(e -> modificar());
        vistaper.getBtneliminar().addActionListener(e -> eliminar());
        vistaper.getBtncargar().addActionListener(e -> obtieneImagen());
        
        vistaper.getTabla_muebles_persona().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                seleccionar();
            }
        ;

        });
    }
    
    public void lista() {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistaper.getTabla_muebles_persona().getModel();
        List<M_muebles_personaMD> lista = bdpersona.mostrardatos();
        int columnas = modelo.getColumnCount();
        for (int j = vistaper.getTabla_muebles_persona().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);
        }
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            vistaper.getTabla_muebles_persona().setValueAt(lista.get(i).getCedula(), i, 0);
            vistaper.getTabla_muebles_persona().setValueAt(lista.get(i).getNombre(), i, 1);
            vistaper.getTabla_muebles_persona().setValueAt(lista.get(i).getApellido(), i, 2);
            vistaper.getTabla_muebles_persona().setValueAt(lista.get(i).getDireccion(), i, 3);
            vistaper.getTabla_muebles_persona().setValueAt(lista.get(i).getCelular(), i, 4);
            vistaper.getTabla_muebles_persona().setValueAt(lista.get(i).getNacionalidad(), i, 5);
            vistaper.getTabla_muebles_persona().setValueAt(lista.get(i).getFechana(), i, 6);
        }
    }
    
    public void guardar() {
        bdpersona.setCedula(vistaper.getTxtcedula().getText());
        bdpersona.setNombre(vistaper.getTxtnombres().getText());
        bdpersona.setApellido(vistaper.getTxtapellidos().getText());
        bdpersona.setDireccion(vistaper.getTxtdireccion().getText());
        bdpersona.setCelular(vistaper.getTxtcelular().getText());
        bdpersona.setNacionalidad(vistaper.getTxtnacionalidad().getText());
        bdpersona.setFechana(vistaper.getTxtfecha().getText());
        ImageIcon ic = (ImageIcon) vistaper.getJimagen().getIcon();
        bdpersona.setFoto(ic.getImage());
        
        if (bdpersona.insert()) {
            JOptionPane.showMessageDialog(null, "GUARDADO CORRECTO");
            lista();
            nuevo();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
        }
    }
    
    public void modificar() {
        bdpersona.setNombre(vistaper.getTxtnombres().getText());
        bdpersona.setApellido(vistaper.getTxtapellidos().getText());
        bdpersona.setDireccion(vistaper.getTxtdireccion().getText());
        bdpersona.setCelular(vistaper.getTxtcelular().getText());
        bdpersona.setNacionalidad(vistaper.getTxtnacionalidad().getText());
        bdpersona.setFechana(vistaper.getTxtfecha().getText());
        
        int res = JOptionPane.showConfirmDialog(null, "ESTA SEGURO DE MODIFICAR");
        if (res == 0) {
            if (bdpersona.modificar(vistaper.getTxtcedula().getText())) {
                JOptionPane.showMessageDialog(null, "datos actualizados");
                lista();
                nuevo();
                vistaper.getBtnmodificar().setEnabled(false);
            }
        }
    }

    public void seleccionar() {

        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistaper.getTabla_muebles_persona().getModel();
        String cedula = (String) modelo.getValueAt(vistaper.getTabla_muebles_persona().getSelectedRow(), 0);

        List<M_muebles_personaMD> lista = bdpersona.obtenerdatos(cedula);

        bdpersona.setCedula(lista.get(0).getCedula());
        vistaper.getTxtcedula().setText(bdpersona.getCedula());
        bdpersona.setNombre(lista.get(0).getNombre());
        vistaper.getTxtnombres().setText(bdpersona.getNombre());
        bdpersona.setApellido(lista.get(0).getApellido());
        vistaper.getTxtapellidos().setText(bdpersona.getApellido());
        bdpersona.setDireccion(lista.get(0).getDireccion());
        vistaper.getTxtdireccion().setText(bdpersona.getDireccion());
        bdpersona.setCelular(lista.get(0).getCelular());
        vistaper.getTxtcelular().setText(bdpersona.getCelular());
        bdpersona.setNacionalidad(lista.get(0).getNacionalidad());
        vistaper.getTxtnacionalidad().setText(bdpersona.getNacionalidad());
        bdpersona.setFechana(lista.get(0).getFechana());
        vistaper.getTxtfecha().setText(bdpersona.getFechana());
        
        Image img = lista.get(0).getFoto();
        if (img != null) {
            Image newimg = img.getScaledInstance(vistaper.getJimagen().getWidth(), vistaper.getJimagen().getHeight(), java.awt.Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(newimg);
            vistaper.getJimagen().setIcon(icon);
        } else {
            vistaper.getJimagen().setIcon(null);
        }

    }

    public void nuevo() {
        vistaper.getTxtcedula().setText("");
        vistaper.getTxtnombres().setText("");
        vistaper.getTxtapellidos().setText("");
        vistaper.getTxtdireccion().setText("");
        vistaper.getTxtcelular().setText("");
        vistaper.getTxtnacionalidad().setText("");
        vistaper.getTxtfecha().setText("");
        vistaper.getJimagen().setText("");

    }

    public void eliminar(){
        bdpersona.setCedula(vistaper.getTxtcedula().getText());
        int res = JOptionPane.showConfirmDialog(null, "ESTA SEGURO DE ELIMINAR EL USUARIO "+vistaper.getTxtcedula().getText());
        if (res == 0) {
            if (bdpersona.eliminar(vistaper.getTxtcedula().getText())) {
                JOptionPane.showMessageDialog(null, "DATOS ELIMINADOS");
                lista();
                nuevo();
                vistaper.getBtnmodificar().setEnabled(false);
            }
        }
    }
    
    private void obtieneImagen() {
        vistaper.getJimagen().setIcon(null);
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = j.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                Image icono = ImageIO.read(j.getSelectedFile()).getScaledInstance(vistaper.getJimagen().getWidth(), vistaper.getJimagen().getHeight(), Image.SCALE_DEFAULT);
                vistaper.getJimagen().setIcon(new ImageIcon(icono));
                vistaper.getJimagen().updateUI();
            } catch (IOException ex) {
                Logger.getLogger(C_muebles_persona.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
