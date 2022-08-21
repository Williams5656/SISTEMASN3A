 
package Papeleria_Bella.controlador;

import Papeleria_Bella.vista.*;
import Papeleria_Bella.modelo.*;
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


public class Cpersona {
    
    public static Vpersona1 vista;
      
    private PersonaBD bpersona = new PersonaBD();
   
    public Cpersona(Vpersona1 vista) {
        this.vista = vista;
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        lista();
        vista.getButtonguardar().addActionListener(x -> guardar());
       // vista.getButtonguardar().setEnabled(true);
       vista.getButtonmodificar().addActionListener(e -> modificar());
        vista.getButtoncargar().addActionListener(e -> obtieneImagen());
        //vista.getButtoncargar().setEnabled(true);
        vista.getTablapersona().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }

        });
        
        vista.getButtonnuevo().addActionListener(e -> nuevo());
        vista.getButtoneliminar().addActionListener(e -> eliminar());
        vista.getButtonguardar().setEnabled(false);
        vista.getButtonmodificar().setEnabled(false);
    }

       
    
     
    public void lista() {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTablapersona().getModel();
        List<PersonaMD> lista = bpersona.mostrardatos();
        int columnas = modelo.getColumnCount();
        for (int j = vista.getTablapersona().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);
        }
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            vista.getTablapersona().setValueAt(lista.get(i).getCedula(), i, 0);
            vista.getTablapersona().setValueAt(lista.get(i).getNombres(), i, 1);
            vista.getTablapersona().setValueAt(lista.get(i).getApellidos(), i, 2);
            vista.getTablapersona().setValueAt(lista.get(i).getTelefono(), i, 3);
            vista.getTablapersona().setValueAt(lista.get(i).getDireccion(), i, 4);
            vista.getTablapersona().setValueAt(lista.get(i).getEmail(), i, 5);
           

        }
    }
    
  
    public void guardar() {
        bpersona.setCedula(vista.getTxtcedula().getText());
        bpersona.setNombres(vista.getTxtnombres().getText());
        bpersona.setApellidos(vista.getTxtapellidos().getText());
        bpersona.setTelefono(vista.getTxttelefono().getText());
        bpersona.setDireccion(vista.getTxtdireccion().getText());
        bpersona.setEmail(vista.getTxtemail().getText());
       
        ImageIcon ic = (ImageIcon) vista.getLabelfoto().getIcon();
        bpersona.setFoto(ic.getImage());
        
        

        if (bpersona.insertar()) {
            JOptionPane.showMessageDialog(null, "EXITO AL GUARDAR");
            lista();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
            lista();
        }

    }
    
    public void modificar() {
        bpersona.setCedula(vista.getTxtcedula().getText());
        bpersona.setNombres(vista.getTxtnombres().getText());
        bpersona.setApellidos(vista.getTxtapellidos().getText());
        bpersona.setTelefono(vista.getTxttelefono().getText());
        bpersona.setDireccion(vista.getTxtdireccion().getText());
        bpersona.setEmail(vista.getTxtemail().getText());
        
        int resp = JOptionPane.showConfirmDialog(null, "Esta seguro de modificar");
        if (resp == 0) {
            if (bpersona.modificar(vista.getTxtcedula().getText())) ;
                JOptionPane.showMessageDialog(null, "Datos Actualizados");
                lista();
                nuevo();
                //vista.getButtonmodificar().setEnabled(false);
            }
        }

   
    public void seleccionar() {
        vista.getButtonguardar().setEnabled(false);
        vista.getButtonmodificar().setEnabled(true);
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTablapersona().getModel();
        String cedula = (String) modelo.getValueAt(vista.getTablapersona().getSelectedRow(), 0);
        List<PersonaMD> lista = bpersona.obtenerdatos(cedula);
        bpersona.setCedula(lista.get(0).getCedula());
        vista.getTxtcedula().setText(bpersona.getCedula());
        bpersona.setNombres(lista.get(0).getNombres());
        vista.getTxtnombres().setText(bpersona.getNombres());
        bpersona.setApellidos(lista.get(0).getApellidos());
        vista.getTxtapellidos().setText(bpersona.getApellidos());
        bpersona.setTelefono(lista.get(0).getTelefono());
        vista.getTxttelefono().setText(bpersona.getTelefono());
        bpersona.setDireccion(lista.get(0).getDireccion());
        vista.getTxtdireccion().setText(bpersona.getDireccion());
        bpersona.setEmail(lista.get(0).getEmail());
        vista.getTxtemail().setText(bpersona.getEmail());
       
        
        
        
        
         Image img = lista.get(0).getFoto();
        if (img != null) {
            Image newimg = img.getScaledInstance(vista.getLabelfoto().getWidth(), vista.getLabelfoto().getHeight(), java.awt.Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(newimg);
            vista.getLabelfoto().setIcon(icon);
        } else {
            vista.getLabelfoto().setIcon(null);
        }

    } 
  
 
    
    private void obtieneImagen() {
        vista.getLabelfoto().setIcon(null);
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = j.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                Image icono = ImageIO.read(j.getSelectedFile()).getScaledInstance(vista.getLabelfoto().getWidth(), vista.getLabelfoto().getHeight(), Image.SCALE_DEFAULT);
                vista.getLabelfoto().setIcon(new ImageIcon(icono));
                vista.getLabelfoto().updateUI();
            } catch (IOException ex) {
                Logger.getLogger(Cpersona.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
           
    public void eliminar(){
        bpersona.setCedula(vista.getTxtcedula().getText());
        int resp = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar el usuario  "+vista.getTxtcedula().getText());
        if (resp == 0) {
            if (bpersona.eliminar(vista.getTxtcedula().getText())) ;
                JOptionPane.showMessageDialog(null, "Datos Actualizados");
                lista();
                nuevo();
                
            }
    } 
    public void nuevo(){
        vista.getTxtcedula().setText("");
        vista.getTxtnombres().setText("");
        vista.getTxtapellidos().setText("");
        vista.getTxttelefono().setText("");
        vista.getTxtdireccion().setText("");
        vista.getTxtemail().setText("");
        vista.getButtonguardar().setEnabled(true);
        vista.getButtonmodificar().setEnabled(false);
    }
        
}

