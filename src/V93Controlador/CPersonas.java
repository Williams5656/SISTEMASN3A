package V93Controlador;

import V93Vista.*;
import javax.swing.table.DefaultTableModel;
import V93Modelo.*;
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
    
public class CPersonas {

    public static VistaPersona VistaP;
    
    private PersonaBD bdpersona = new PersonaBD();

    public CPersonas(VistaPersona VistaP) {
        this.VistaP = VistaP;
        VistaP.setVisible(true);
        VistaP.setLocationRelativeTo(null);
        lista();
        VistaP.getBtnGuardarPersona().addActionListener(x -> guardar());
        VistaP.getBtnModificarPersona().addActionListener(e -> modificar());
        VistaP.getBtnFoto().addActionListener(e -> obtieneImagen());
        VistaP.getBtnbuscarp().addActionListener(e -> buscar());
        // VistaP.getBtnEliminarPersona().addActionListener(e -> eliminar());
        // VistaP.getBtnNuevoPersona().addActionListener(e -> nuevo());
        VistaP.getTablePersona().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }

        });
  
        VistaP.getBtnNuevoPersona().addActionListener(e -> nuevo());
        VistaP.getBtnEliminarPersona().addActionListener(e -> eliminar());
        VistaP.getBtnGuardarPersona().setEnabled(false);
        VistaP.getBtnModificarPersona().setEnabled(false);
    }
     
    public void lista() {

        DefaultTableModel modelo;
        modelo = (DefaultTableModel) VistaP.getTablePersona().getModel();
        List<PersonaMb> lista = bdpersona.mostrardatos();
        int columnas = modelo.getColumnCount();

        for (int j = VistaP.getTablePersona().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);

        }
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            VistaP.getTablePersona().setValueAt(lista.get(i).getCedula(), i, 0);
            VistaP.getTablePersona().setValueAt(lista.get(i).getNombre(), i, 1);
            VistaP.getTablePersona().setValueAt(lista.get(i).getDireccion(), i, 2);
            VistaP.getTablePersona().setValueAt(lista.get(i).getFecha_nacimiento(), i, 3);
            VistaP.getTablePersona().setValueAt(lista.get(i).getCiudad(), i, 4);
            VistaP.getTablePersona().setValueAt(lista.get(i).getCelular(), i, 5);

        }
    }

    public void guardar() {
        bdpersona.setCedula(VistaP.getTxtCedulaPersona().getText());
        bdpersona.setNombre(VistaP.getTxtNombrePersona().getText());
        bdpersona.setDireccion(VistaP.getTxtDireccionPersona().getText());
        bdpersona.setFecha_nacimiento(VistaP.getTxtFechaNacimientoPersona().getText());
        bdpersona.setCiudad(VistaP.getTxtCiudadPersona().getText());
        bdpersona.setCelular(VistaP.getTxtCelularPersona().getText());

        ImageIcon ic = (ImageIcon) VistaP.getLbFoto().getIcon();
        bdpersona.setFoto(ic.getImage());

        if (bdpersona.insertar()) {
            JOptionPane.showMessageDialog(null, "EXITO AL GUARDAR");
            lista();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
            lista();
        }

    }

    private void obtieneImagen() {
        VistaP.getLbFoto().setIcon(null);
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = j.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                Image icono = ImageIO.read(j.getSelectedFile()).getScaledInstance(VistaP.getLbFoto().getWidth(), VistaP.getLbFoto().getHeight(), Image.SCALE_DEFAULT);
                VistaP.getLbFoto().setIcon(new ImageIcon(icono));
                VistaP.getLbFoto().updateUI();
            } catch (IOException ex) {
                Logger.getLogger(CPersonas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void buscar() {
        if (VistaP.getTxtbuscarp().getText().equals("")) {
            lista();
        } else {
            DefaultTableModel modelo;
            modelo = (DefaultTableModel) VistaP.getTablePersona().getModel();
            List<PersonaMb> lista = bdpersona.obtenerdatos(VistaP.getTxtbuscarp().getText());
            int columnas = modelo.getColumnCount();

            for (int j = VistaP.getTablePersona().getRowCount() - 1; j >= 0; j--) {
                modelo.removeRow(j);
            }
            for (int i = 0; i < lista.size(); i++) {
                modelo.addRow(new Object[columnas]);
                VistaP.getTablePersona().setValueAt(lista.get(i).getCedula(), i, 0);
                VistaP.getTablePersona().setValueAt(lista.get(i).getNombre(), i, 1);
                VistaP.getTablePersona().setValueAt(lista.get(i).getDireccion(), i, 2);
                VistaP.getTablePersona().setValueAt(lista.get(i).getFecha_nacimiento(), i, 3);
                VistaP.getTablePersona().setValueAt(lista.get(i).getCiudad(), i, 4);
                VistaP.getTablePersona().setValueAt(lista.get(i).getCelular(), i, 5);
            }
        }

    }

    public void modificar() {
        bdpersona.setCedula(VistaP.getTxtCedulaPersona().getText());
        bdpersona.setNombre(VistaP.getTxtNombrePersona().getText());
        bdpersona.setDireccion(VistaP.getTxtDireccionPersona().getText());
        bdpersona.setFecha_nacimiento(VistaP.getTxtFechaNacimientoPersona().getText());
        bdpersona.setCiudad(VistaP.getTxtCiudadPersona().getText());
        bdpersona.setCelular(VistaP.getTxtCelularPersona().getText());
        ImageIcon ic = (ImageIcon) VistaP.getLbFoto().getIcon();
        bdpersona.setFoto(ic.getImage());
        int rest = JOptionPane.showConfirmDialog(null, "Esta Seguro de Modificar");
        if (rest == 0) {
            if (bdpersona.modificar(VistaP.getTxtCedulaPersona().getText())) ;
            JOptionPane.showMessageDialog(null, "Datos Modificados");
            lista();
            nuevo();
        }

    }

    public void seleccionar() {
        VistaP.getBtnGuardarPersona().setEnabled(false);
        VistaP.getBtnModificarPersona().setEnabled(true);
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) VistaP.getTablePersona().getModel();
        String cedula = (String) modelo.getValueAt(VistaP.getTablePersona().getSelectedRow(), 0);
        List<PersonaMb> lista = bdpersona.obtenerdatos(cedula);
        bdpersona.setCedula(lista.get(0).getCedula());
        VistaP.getTxtCedulaPersona().setText(bdpersona.getCedula());
        bdpersona.setNombre(lista.get(0).getNombre());
        VistaP.getTxtNombrePersona().setText(bdpersona.getNombre());
        bdpersona.setDireccion(lista.get(0).getDireccion());
        VistaP.getTxtDireccionPersona().setText(bdpersona.getDireccion());
        bdpersona.setFecha_nacimiento(lista.get(0).getFecha_nacimiento());
        VistaP.getTxtFechaNacimientoPersona().setText(bdpersona.getFecha_nacimiento());
        bdpersona.setCiudad(lista.get(0).getCiudad());
        VistaP.getTxtCiudadPersona().setText(bdpersona.getCiudad());
        bdpersona.setCelular(lista.get(0).getCelular());
        VistaP.getTxtCelularPersona().setText(bdpersona.getCelular());
   
        Image img = lista.get(0).getFoto();
        if (img != null) {
            Image newimg = img.getScaledInstance(VistaP.getLbFoto().getWidth(), VistaP.getLbFoto().getHeight(), java.awt.Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(newimg);
            VistaP.getLbFoto().setIcon(icon);
        } else {
            VistaP.getLbFoto().setIcon(null);
        }

    }

    public void eliminar() {
        bdpersona.setCedula(VistaP.getTxtCedulaPersona().getText());
        int rest = JOptionPane.showConfirmDialog(null, "Esta Seguro de Eliminar");
        if (rest == 0) {
            if (bdpersona.eliminar(VistaP.getTxtCedulaPersona().getText()));
            JOptionPane.showMessageDialog(null, "Usuario Eliminado");
            lista();
            nuevo();
        }

    }

    public void nuevo() {
        VistaP.getTxtCedulaPersona().setText("");
        VistaP.getTxtNombrePersona().setText("");
        VistaP.getTxtDireccionPersona().setText("");
        VistaP.getTxtFechaNacimientoPersona().setText("");
        VistaP.getTxtCiudadPersona().setText("");
        VistaP.getTxtCelularPersona().setText("");
        VistaP.getTxtbuscarp().setText("");
        VistaP.getBtnGuardarPersona().setEnabled(true);
        VistaP.getBtnModificarPersona().setEnabled(false);
    }
}  
