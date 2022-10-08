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

public class CProducto {
    
    public static VistaProducto VistaProd;
    
    private ProductoBD bdproducto = new ProductoBD();
    
    public CProducto(VistaProducto VistaP) {
        this.VistaProd = VistaP;
        VistaP.setVisible(true);
        VistaP.setLocationRelativeTo(null);
        lista();
        VistaP.getBtnGuardarProducto().addActionListener(x -> guardar());
        VistaP.getBtnModificarProducto().addActionListener(e -> modificar());
        VistaP.getBtnFotoProducto().addActionListener(e -> obtieneImagen());
        VistaP.getBtnBuscarProducto().addActionListener(e -> buscar());
        VistaP.getBtnImprimirProducto().addActionListener(e -> ImprimirProducto());
        // VistaP.getBtnNuevoPersona().addActionListener(e -> nuevo());
        VistaP.getTableProducto().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }
            
        });
        
        VistaP.getBtnNuevoProducto().addActionListener(e -> nuevo());
        VistaP.getBtnEliminarProducto().addActionListener(e -> eliminar());
        VistaP.getBtnGuardarProducto().setEnabled(false);
        VistaP.getBtnModificarProducto().setEnabled(false);
        VistaP.getjComboBoxProveedorProducto().setModel(bdproducto.NombreProveedor());
    }
     private void ImprimirProducto() {
        Conectar con = new Conectar();
        try {

            JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/reportes/ReporProducto.jasper"));

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

    private void obtieneImagen() {
        VistaProd.getjLabelFotoProducto().setIcon(null);
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = j.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                Image icono = ImageIO.read(j.getSelectedFile()).getScaledInstance(VistaProd.getjLabelFotoProducto().getWidth(), VistaProd.getjLabelFotoProducto().getHeight(), Image.SCALE_DEFAULT);
                VistaProd.getjLabelFotoProducto().setIcon(new ImageIcon(icono));
                VistaProd.getjLabelFotoProducto().updateUI();
            } catch (IOException ex) {
                Logger.getLogger(CProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void lista() {
        
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) VistaProd.getTableProducto().getModel();
        List<ProductoMb> lista = bdproducto.mostrardatos();
        int columnas = modelo.getColumnCount();
        
        for (int j = VistaProd.getTableProducto().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);
            
        }
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            VistaProd.getTableProducto().setValueAt(lista.get(i).getCodigo(), i, 0);
            VistaProd.getTableProducto().setValueAt(lista.get(i).getDescripcion(), i, 1);
            VistaProd.getTableProducto().setValueAt(lista.get(i).getProveedor(), i, 2);
            VistaProd.getTableProducto().setValueAt(lista.get(i).getStock(), i, 3);
            VistaProd.getTableProducto().setValueAt(lista.get(i).getPrecio(), i, 4);
            VistaProd.getTableProducto().setValueAt(lista.get(i).getFoto(), i, 5);
            
        }
    }
    
    public void guardar() {
        bdproducto.setCodigo(VistaProd.getTxtCodigoProducto().getText());
        bdproducto.setDescripcion(VistaProd.getTxtDescripcionProducto().getText());
        bdproducto.setProveedor(VistaProd.getjComboBoxProveedorProducto().getSelectedItem().toString());
        bdproducto.setStock(Integer.parseInt(VistaProd.getTxtStockProducto().getText()));
        bdproducto.setPrecio(Double.parseDouble(VistaProd.getTxtPrecioProducto().getText()));
        
        ImageIcon ic = (ImageIcon) VistaProd.getjLabelFotoProducto().getIcon();
        bdproducto.setFoto(ic.getImage());
        
        if (bdproducto.insertar()) {
            JOptionPane.showMessageDialog(null, "EXITO AL GUARDAR");
            lista();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
            lista();
        }
        
    }
    
    public void buscar() {
        if (VistaProd.getTxtBuscarProducto().getText().equals("")) {
            lista();
        } else {
            DefaultTableModel modelo;
            modelo = (DefaultTableModel) VistaProd.getTableProducto().getModel();
            List<ProductoMb> lista = bdproducto.obtenerdatos(VistaProd.getTxtBuscarProducto().getText());
            int columnas = modelo.getColumnCount();
            
            for (int j = VistaProd.getTableProducto().getRowCount() - 1; j >= 0; j--) {
                modelo.removeRow(j);
            }
            for (int i = 0; i < lista.size(); i++) {
                modelo.addRow(new Object[columnas]);
                VistaProd.getTableProducto().setValueAt(lista.get(i).getCodigo(), i, 0);
                VistaProd.getTableProducto().setValueAt(lista.get(i).getDescripcion(), i, 1);
                VistaProd.getTableProducto().setValueAt(lista.get(i).getProveedor(), i, 2);
                VistaProd.getTableProducto().setValueAt(lista.get(i).getStock(), i, 3);
                VistaProd.getTableProducto().setValueAt(lista.get(i).getPrecio(), i, 4);
                
            }
        }
        
    }
    
    public void modificar() {
        bdproducto.setCodigo(VistaProd.getTxtCodigoProducto().getText());
        bdproducto.setDescripcion(VistaProd.getTxtDescripcionProducto().getText());
        bdproducto.setProveedor(VistaProd.getjComboBoxProveedorProducto().getSelectedItem().toString());
        bdproducto.setStock(Integer.parseInt(VistaProd.getTxtStockProducto().getText()));
        bdproducto.setPrecio(Double.parseDouble(VistaProd.getTxtPrecioProducto().getText()));
        ImageIcon ic = (ImageIcon) VistaProd.getjLabelFotoProducto().getIcon();
        bdproducto.setFoto(ic.getImage());
        int rest = JOptionPane.showConfirmDialog(null, "Esta Seguro de Modificar");
        if (rest == 0) {
            if (bdproducto.modificar(VistaProd.getTxtCodigoProducto().getText())) ;
            JOptionPane.showMessageDialog(null, "Datos Modificados");
            lista();
            nuevo();
        }
        
    }
    
    public void seleccionar() {
        VistaProd.getBtnGuardarProducto().setEnabled(false);
        VistaProd.getBtnModificarProducto().setEnabled(true);
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) VistaProd.getTableProducto().getModel();
        String codigo = (String) modelo.getValueAt(VistaProd.getTableProducto().getSelectedRow(), 0);
        List<ProductoMb> lista = bdproducto.obtenerdatos(codigo);
        bdproducto.setCodigo(lista.get(0).getCodigo());
        VistaProd.getTxtCodigoProducto().setText(bdproducto.getCodigo());
        bdproducto.setDescripcion(lista.get(0).getDescripcion());
        VistaProd.getTxtDescripcionProducto().setText(bdproducto.getDescripcion());
        bdproducto.setProveedor(lista.get(0).getProveedor());
        VistaProd.getjComboBoxProveedorProducto().setSelectedItem(bdproducto.getProveedor());
        bdproducto.setStock(lista.get(0).getStock());
        VistaProd.getTxtStockProducto().setText(String.valueOf(bdproducto.getStock()));
        bdproducto.setPrecio(lista.get(0).getPrecio());
        VistaProd.getTxtPrecioProducto().setText(String.valueOf(bdproducto.getPrecio()));
        
        Image img = lista.get(0).getFoto();
        if (img != null) {
            Image newimg = img.getScaledInstance(VistaProd.getjLabelFotoProducto().getWidth(), VistaProd.getjLabelFotoProducto().getHeight(), java.awt.Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(newimg);
            VistaProd.getjLabelFotoProducto().setIcon(icon);
        } else {
            VistaProd.getjLabelFotoProducto().setIcon(null);
        }
        
    }
    
    public void eliminar() {
        bdproducto.setCodigo(VistaProd.getTxtCodigoProducto().getText());
        int rest = JOptionPane.showConfirmDialog(null, "Esta Seguro de Eliminar");
        if (rest == 0) {
            if (bdproducto.eliminar(VistaProd.getTxtCodigoProducto().getText()));
            JOptionPane.showMessageDialog(null, "Usuario Eliminado");
            lista();
            nuevo();
        }
        
    }
    
    public void nuevo() {
        VistaProd.getTxtCodigoProducto().setText("");
        VistaProd.getTxtDescripcionProducto().setText("");
        VistaProd.getTxtBuscarProducto().setText("");
        VistaProd.getTxtStockProducto().setText("");
        VistaProd.getTxtPrecioProducto().setText("");
        VistaProd.getBtnGuardarProducto().setEnabled(true);
        VistaProd.getBtnModificarProducto().setEnabled(false);
    }
}
