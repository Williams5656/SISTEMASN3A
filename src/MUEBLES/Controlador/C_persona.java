package MUEBLES.Controlador;

import static MUEBLES.Controlador.Cmueblesprincipal.vistaprin;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import MUEBLES.Vista.Vista_persona_muebles;
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

public class C_persona {

    public static Vista_persona_muebles vista;
    private Persona_BD_muebles bdpersona = new Persona_BD_muebles();

    public C_persona(Vista_persona_muebles vista) {
        this.vista = vista;
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);

        lista();
        vista.getBtguarda().addActionListener(e -> guarda());
        vista.getBtmodifica().addActionListener(e -> modifica());
        vista.getBteliminar().addActionListener(e -> eliminar());
        vista.getBtcargar().addActionListener(e -> obtieneImagen());
        vista.getBtnbuscar().addActionListener(e -> buscar());

        vista.getTabla_muebles_persona().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                selecciona();
            }
        ;

    }

    );
    }
    
    public void lista() {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTabla_muebles_persona().getModel();
        List<M_personaMD> lista = bdpersona.mostrardatos();
        int columnas = modelo.getColumnCount();
        for (int j = vista.getTabla_muebles_persona().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);
        }
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            vista.getTabla_muebles_persona().setValueAt(lista.get(i).getCedula(), i, 0);
            vista.getTabla_muebles_persona().setValueAt(lista.get(i).getNombre(), i, 1);
            vista.getTabla_muebles_persona().setValueAt(lista.get(i).getApellido(), i, 2);
            vista.getTabla_muebles_persona().setValueAt(lista.get(i).getDireccion(), i, 3);
            vista.getTabla_muebles_persona().setValueAt(lista.get(i).getCelular(), i, 4);
            vista.getTabla_muebles_persona().setValueAt(lista.get(i).getNacionalidad(), i, 5);
            vista.getTabla_muebles_persona().setValueAt(lista.get(i).getFechana(), i, 6);
            vista.getTabla_muebles_persona().setValueAt(lista.get(i).getFoto(), i, 7);
        }
    }

    public void guarda() {
        bdpersona.setCedula(vista.getTxtcedula().getText());
        bdpersona.setNombre(vista.getTxtnombres().getText());
        bdpersona.setApellido(vista.getTxtapellidos().getText());
        bdpersona.setDireccion(vista.getTxtdireccion().getText());
        bdpersona.setCelular(vista.getTxtcelular().getText());
        bdpersona.setNacionalidad(vista.getTxtnacionalidad().getText());
        bdpersona.setFechana(vista.getTxtfecha().getText());
        ImageIcon ic = (ImageIcon) vista.getJimagen().getIcon();
        bdpersona.setFoto(ic.getImage());

        if (bdpersona.insert()) {
            JOptionPane.showMessageDialog(null, "GUARDADO CORRECTO");
            lista();
            nuevo();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
        }
    }

    public void modifica() {
        bdpersona.setNombre(vista.getTxtnombres().getText());
        bdpersona.setApellido(vista.getTxtapellidos().getText());
        bdpersona.setDireccion(vista.getTxtdireccion().getText());
        bdpersona.setCelular(vista.getTxtcelular().getText());
        bdpersona.setNacionalidad(vista.getTxtnacionalidad().getText());
        bdpersona.setFechana(vista.getTxtfecha().getText());
        ImageIcon ic = (ImageIcon) vista.getJimagen().getIcon();
        bdpersona.setFoto(ic.getImage());

        int res = JOptionPane.showConfirmDialog(null, "ESTA SEGURO DE MODIFICAR");
        if (res == 0) {
            if (bdpersona.modificar(vista.getTxtcedula().getText())) {
                JOptionPane.showMessageDialog(null, "datos actualizados");
                lista();
                nuevo();
            }
        }
    }

    public void selecciona() {

        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTabla_muebles_persona().getModel();
        String cedula = (String) modelo.getValueAt(vista.getTabla_muebles_persona().getSelectedRow(), 0);

        List<M_personaMD> lista = bdpersona.obtenerdatos(cedula);

        bdpersona.setCedula(lista.get(0).getCedula());
        vista.getTxtcedula().setText(bdpersona.getCedula());
        bdpersona.setNombre(lista.get(0).getNombre());
        vista.getTxtnombres().setText(bdpersona.getNombre());
        bdpersona.setApellido(lista.get(0).getApellido());
        vista.getTxtapellidos().setText(bdpersona.getApellido());
        bdpersona.setDireccion(lista.get(0).getDireccion());
        vista.getTxtdireccion().setText(bdpersona.getDireccion());
        bdpersona.setCelular(lista.get(0).getCelular());
        vista.getTxtcelular().setText(bdpersona.getCelular());
        bdpersona.setNacionalidad(lista.get(0).getNacionalidad());
        vista.getTxtnacionalidad().setText(bdpersona.getNacionalidad());
        bdpersona.setFechana(lista.get(0).getFechana());
        vista.getTxtfecha().setText(bdpersona.getFechana());

        Image img = lista.get(0).getFoto();
        if (img != null) {
            Image newimg = img.getScaledInstance(vista.getJimagen().getWidth(), vista.getJimagen().getHeight(), java.awt.Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(newimg);
            vista.getJimagen().setIcon(icon);
        } else {
            vista.getJimagen().setIcon(null);
        }

    }

    public void nuevo() {
        vista.getTxtcedula().setText("");
        vista.getTxtnombres().setText("");
        vista.getTxtapellidos().setText("");
        vista.getTxtdireccion().setText("");
        vista.getTxtcelular().setText("");
        vista.getTxtnacionalidad().setText("");
        vista.getTxtfecha().setText("");

    }

    public void eliminar() {
        bdpersona.setCedula(vista.getTxtcedula().getText());
        int res = JOptionPane.showConfirmDialog(null, "ESTA SEGURO DE ELIMINAR EL USUARIO " + vista.getTxtcedula().getText());
        if (res == 0) {
            if (bdpersona.eliminar(vista.getTxtcedula().getText())) {
                JOptionPane.showMessageDialog(null, "DATOS ELIMINADOS");
                lista();
                nuevo();

            }
        }
    }

    private void obtieneImagen() {
        vista.getJimagen().setIcon(null);
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = j.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                Image icono = ImageIO.read(j.getSelectedFile()).getScaledInstance(vista.getJimagen().getWidth(), vista.getJimagen().getHeight(), Image.SCALE_DEFAULT);
                vista.getJimagen().setIcon(new ImageIcon(icono));
                vista.getJimagen().updateUI();
            } catch (IOException ex) {
                Logger.getLogger(C_persona.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void buscar() {
        if (vista.getTxtbuscar().getText().equals("")) {
            lista();
        } else {
            DefaultTableModel modelo;
            modelo = (DefaultTableModel) vista.getTabla_muebles_persona().getModel();
            List<M_personaMD> lista = bdpersona.obtenerdatos(vista.getTxtbuscar().getText());
            int columnas = modelo.getColumnCount();
            for (int j = vista.getTabla_muebles_persona().getRowCount() - 1; j >= 0; j--) {
                modelo.removeRow(j);
            }
            for (int i = 0; i < lista.size(); i++) {

                //if (lista.get(i).getCedula().equals(vista.getTxtbuscar().getText())) {
                    modelo.addRow(new Object[columnas]);
                    vista.getTabla_muebles_persona().setValueAt(lista.get(i).getCedula(), i, 0);
                    vista.getTabla_muebles_persona().setValueAt(lista.get(i).getNombre(), i, 1);
                    vista.getTabla_muebles_persona().setValueAt(lista.get(i).getApellido(), i, 2);
                    vista.getTabla_muebles_persona().setValueAt(lista.get(i).getDireccion(), i, 3);
                    vista.getTabla_muebles_persona().setValueAt(lista.get(i).getCelular(), i, 4);
                    vista.getTabla_muebles_persona().setValueAt(lista.get(i).getNacionalidad(), i, 5);
                    vista.getTabla_muebles_persona().setValueAt(lista.get(i).getFechana(), i, 6);
                    vista.getTabla_muebles_persona().setValueAt(lista.get(i).getFoto(), i, 7);
                
            }
        }
    }
}
