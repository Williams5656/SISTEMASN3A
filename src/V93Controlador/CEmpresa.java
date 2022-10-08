
package V93Controlador;

import V93Vista.*;
import javax.swing.table.DefaultTableModel;
import V93Modelo.*;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
    
public class CEmpresa {

    public static VistaEmpresa VistaEmp;
           
    private EmpresaBD bdempresa = new EmpresaBD();

    public CEmpresa(VistaEmpresa VistaEmp) {
        this.VistaEmp = VistaEmp;
        VistaEmp.setVisible(true);
        VistaEmp.setLocationRelativeTo(null);
        lista();
        VistaEmp.getBtnGuardarEmpresa().addActionListener(x -> guardar());
        VistaEmp.getBtnModificarEmpresa().addActionListener(e -> modificar());
        VistaEmp.getBtnAgregarFotoEmpresa().addActionListener(e -> obtieneImagen());
        VistaEmp.getBtnBuscarEmpresa().addActionListener(e -> buscar());
        VistaEmp.getBtnImprimirEmpresa().addActionListener(e -> ImprimirEmpresa());
        // VistaP.getBtnNuevoPersona().addActionListener(e -> nuevo());
        VistaEmp.getTableEmpresa().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }

        });
  
        VistaEmp.getBtnNuevoEmpresa().addActionListener(e -> nuevo());
        VistaEmp.getBtnEliminarEmpresa().addActionListener(e -> eliminar());
        VistaEmp.getBtnGuardarEmpresa().setEnabled(false);
        VistaEmp.getBtnModificarEmpresa().setEnabled(false);
    }
     
    public void lista() {

        DefaultTableModel modelo;
        modelo = (DefaultTableModel) VistaEmp.getTableEmpresa().getModel();
        List<EmpresaMb> lista = bdempresa.mostrardatos();
        int columnas = modelo.getColumnCount();

        for (int j = VistaEmp.getTableEmpresa().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);

        }
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            VistaEmp.getTableEmpresa().setValueAt(lista.get(i).getRuc(), i, 0);
            VistaEmp.getTableEmpresa().setValueAt(lista.get(i).getNombre(), i, 1);
            VistaEmp.getTableEmpresa().setValueAt(lista.get(i).getActividad(), i, 2);
            VistaEmp.getTableEmpresa().setValueAt(lista.get(i).getDireccion(), i, 3);
            VistaEmp.getTableEmpresa().setValueAt(lista.get(i).getCiudad(), i, 4);
            VistaEmp.getTableEmpresa().setValueAt(lista.get(i).getCelular(), i, 5);
            VistaEmp.getTableEmpresa().setValueAt(lista.get(i).getCorreo(), i, 6);
            VistaEmp.getTableEmpresa().setValueAt(lista.get(i).getEstado(), i, 7);
            
        }
    }
    
    private void ImprimirEmpresa() {
        Conectar con = new Conectar();
        try {

            JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/reportes/Empresa.jasper"));

            Map<String, Object> map = new HashMap<String, Object>();

            JasperPrint ja = (JasperPrint) JasperFillManager.fillReport(jas, map, con.getCon());
            JasperViewer jv = new JasperViewer(ja, false);
            jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jv.setVisible(true);
        } catch (JRException e) {
            System.out.println("no se pudo encontrar registros" + e.getMessage());
            Logger.getLogger(Cprincipal.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void guardar() {
        bdempresa.setRuc(VistaEmp.getTxtRucEmpresa().getText());
        bdempresa.setNombre(VistaEmp.getTxtNombreEmpresa().getText());
        bdempresa.setActividad(VistaEmp.getTxtActividadEmpresa().getText());
        bdempresa.setDireccion(VistaEmp.getTxtDireccionEmpresa().getText());
        bdempresa.setCiudad(VistaEmp.getTxtCiudadEmpresa().getText());
        bdempresa.setCelular(VistaEmp.getTxtCelularEmpresa().getText());
        bdempresa.setCorreo(VistaEmp.getTxtCorreoEmpresa().getText());
        String empresa = (String) VistaEmp.getjComboBoxEstadoEmpresa().getSelectedItem();
        bdempresa.setEstado(empresa);
        

        ImageIcon ic = (ImageIcon) VistaEmp.getLabelFotoEmpresa().getIcon();
        bdempresa.setFoto(ic.getImage());

        if (bdempresa.insertar()) {
            JOptionPane.showMessageDialog(null, "EXITO AL GUARDAR");
            lista();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
            lista();
        }

    }

    private void obtieneImagen() {
        VistaEmp.getLabelFotoEmpresa().setIcon(null);
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = j.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                Image icono = ImageIO.read(j.getSelectedFile()).getScaledInstance(VistaEmp.getLabelFotoEmpresa().getWidth(), VistaEmp.getLabelFotoEmpresa().getHeight(), Image.SCALE_DEFAULT);
                VistaEmp.getLabelFotoEmpresa().setIcon(new ImageIcon(icono));
                VistaEmp.getLabelFotoEmpresa().updateUI();
            } catch (IOException ex) {
                Logger.getLogger(CPersonas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void buscar() {
        if (VistaEmp.getTxtbuscarEmpresa().getText().equals("")) {
            lista();
        } else {
            DefaultTableModel modelo;
            modelo = (DefaultTableModel) VistaEmp.getTableEmpresa().getModel();
            List<EmpresaMb> lista = bdempresa.obtenerdatos(VistaEmp.getTxtbuscarEmpresa().getText());
            int columnas = modelo.getColumnCount();

            for (int j = VistaEmp.getTableEmpresa().getRowCount() - 1; j >= 0; j--) {
                modelo.removeRow(j);
            }
            for (int i = 0; i < lista.size(); i++) {
                modelo.addRow(new Object[columnas]);
                VistaEmp.getTableEmpresa().setValueAt(lista.get(i).getRuc(), i, 0);
                VistaEmp.getTableEmpresa().setValueAt(lista.get(i).getNombre(), i, 1);
                VistaEmp.getTableEmpresa().setValueAt(lista.get(i).getActividad(), i, 2);
                VistaEmp.getTableEmpresa().setValueAt(lista.get(i).getDireccion(), i, 3);
                VistaEmp.getTableEmpresa().setValueAt(lista.get(i).getCiudad(), i, 4);
                VistaEmp.getTableEmpresa().setValueAt(lista.get(i).getCelular(), i, 5);
                VistaEmp.getTableEmpresa().setValueAt(lista.get(i).getCorreo(), i, 6);
                VistaEmp.getTableEmpresa().setValueAt(lista.get(i).getEstado(), i, 7);
            }
        }

    }

    public void modificar() {
        bdempresa.setRuc(VistaEmp.getTxtRucEmpresa().getText());
        bdempresa.setNombre(VistaEmp.getTxtNombreEmpresa().getText());
        bdempresa.setActividad(VistaEmp.getTxtActividadEmpresa().getText());
        bdempresa.setDireccion(VistaEmp.getTxtDireccionEmpresa().getText());
        bdempresa.setCiudad(VistaEmp.getTxtCiudadEmpresa().getText());
        bdempresa.setCelular(VistaEmp.getTxtCelularEmpresa().getText());
        bdempresa.setCorreo(VistaEmp.getTxtCorreoEmpresa().getText());
        String empresa = (String) VistaEmp.getjComboBoxEstadoEmpresa().getSelectedItem();
        bdempresa.setEstado(empresa);
        
        
        ImageIcon ic = (ImageIcon) VistaEmp.getLabelFotoEmpresa().getIcon();
        bdempresa.setFoto(ic.getImage());
        int rest = JOptionPane.showConfirmDialog(null, "Esta Seguro de Modificar");
        if (rest == 0) {
            if (bdempresa.modificar(VistaEmp.getTxtRucEmpresa().getText())) ;
            JOptionPane.showMessageDialog(null, "Datos Modificados");
            lista();
            nuevo();
        }

    }

    public void seleccionar() {
        VistaEmp.getBtnGuardarEmpresa().setEnabled(false);
        VistaEmp.getBtnModificarEmpresa().setEnabled(true);
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) VistaEmp.getTableEmpresa().getModel();
        String ruc = (String) modelo.getValueAt(VistaEmp.getTableEmpresa().getSelectedRow(), 0);
        List<EmpresaMb> lista = bdempresa.obtenerdatos(ruc);
        bdempresa.setRuc(lista.get(0).getRuc());
        VistaEmp.getTxtRucEmpresa().setText(bdempresa.getRuc());
        bdempresa.setNombre(lista.get(0).getNombre());
        VistaEmp.getTxtNombreEmpresa().setText(bdempresa.getNombre());
        bdempresa.setActividad(lista.get(0).getActividad());
        VistaEmp.getTxtActividadEmpresa().setText(bdempresa.getActividad());
        bdempresa.setDireccion(lista.get(0).getDireccion());
        VistaEmp.getTxtDireccionEmpresa().setText(bdempresa.getDireccion());
        bdempresa.setCiudad(lista.get(0).getCiudad());
        VistaEmp.getTxtCiudadEmpresa().setText(bdempresa.getCiudad());
        bdempresa.setCelular(lista.get(0).getCelular());
        VistaEmp.getTxtCelularEmpresa().setText(bdempresa.getCelular());
        bdempresa.setCorreo(lista.get(0).getCorreo());
        VistaEmp.getTxtCorreoEmpresa().setText(bdempresa.getCorreo());
        bdempresa.setEstado(lista.get(0).getEstado());
        VistaEmp.getjComboBoxEstadoEmpresa().setSelectedItem(bdempresa.getEstado());
   
        Image img = lista.get(0).getFoto();
        if (img != null) {
            Image newimg = img.getScaledInstance(VistaEmp.getLabelFotoEmpresa().getWidth(), VistaEmp.getLabelFotoEmpresa().getHeight(), java.awt.Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(newimg);
            VistaEmp.getLabelFotoEmpresa().setIcon(icon);
        } else {
            VistaEmp.getLabelFotoEmpresa().setIcon(null);
        }

    }

    public void eliminar() {
        bdempresa.setRuc(VistaEmp.getTxtRucEmpresa().getText());
        int rest = JOptionPane.showConfirmDialog(null, "Esta Seguro de Eliminar");
        if (rest == 0) {
            if (bdempresa.eliminar(VistaEmp.getTxtRucEmpresa().getText()));
            JOptionPane.showMessageDialog(null, "Usuario Eliminado");
            lista();
            nuevo();
        }

    }

    public void nuevo() {
        VistaEmp.getTxtRucEmpresa().setText("");
        VistaEmp.getTxtNombreEmpresa().setText("");
        VistaEmp.getTxtActividadEmpresa().setText("");
        VistaEmp.getTxtDireccionEmpresa().setText("");
        VistaEmp.getTxtCiudadEmpresa().setText("");
        VistaEmp.getTxtCelularEmpresa().setText("");
        VistaEmp.getTxtCorreoEmpresa().setText("");
        VistaEmp.getTxtbuscarEmpresa().setText("");
        VistaEmp.getBtnGuardarEmpresa().setEnabled(true);
        VistaEmp.getBtnModificarEmpresa().setEnabled(false);
    }
} 
