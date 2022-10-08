
package Papeleria_Bella.controlador;
import static Papeleria_Bella.controlador.Cpersona.vista;
import static Papeleria_Bella.controlador.Cusuario.vistau;
import Papeleria_Bella.vista.*;
import Papeleria_Bella.modelo.*;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
//
public class Cproductos {
    public static Vproductos vistapr;
    private ProductosBD bproductos = new ProductosBD();
    
    public Cproductos(Vproductos vistapr) {
        this.vistapr = vistapr;
        vistapr.setVisible(true);
        vistapr.setLocationRelativeTo(null);
        
        lista();
        GenerarCodProductos();
        vistapr.getButtonguardar().addActionListener(x -> guardar());
        vistapr.getButtonmodificar().addActionListener(e -> modificar());
        vistapr.getButtoncargar().addActionListener(e -> obtieneImagen());
        vistapr.getButtonbuscar().addActionListener(e -> Buscar());
        vistapr.getTablaproductos().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }

        });

        vistapr.getButtonnuevo().addActionListener(e -> nuevo());
        vistapr.getButtoneliminar().addActionListener(e -> eliminar());
        vistapr.getButtonguardar().setEnabled(false);
        vistapr.getButtonmodificar().setEnabled(false);
        

        vistapr.getTxtnombre().setEnabled(false);
        vistapr.getTxtdescripcion().setEnabled(false);
        vistapr.getTxtproveedor().setEnabled(false);
        vistapr.getTxtmarca().setEnabled(false);
        vistapr.getTxtmodelo().setEnabled(false);
        vistapr.getTxtstock().setEnabled(false);
        vistapr.getTxtvaloru().setEnabled(false);
        vistapr.getComboiva().setEnabled(false);
    }
    
    public void lista() {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistapr.getTablaproductos().getModel();
        List<ProductosMD> lista = bproductos.mostrardatos();
        int columnas = modelo.getColumnCount();
        for (int j = vistapr.getTablaproductos().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);
        }
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            vistapr.getTablaproductos().setValueAt(lista.get(i).getCodigo(), i, 0);
            vistapr.getTablaproductos().setValueAt(lista.get(i).getNombre(), i, 1);
            vistapr.getTablaproductos().setValueAt(lista.get(i).getDescripcion(), i, 2);
            vistapr.getTablaproductos().setValueAt(lista.get(i).getProveedor(), i, 3);
            vistapr.getTablaproductos().setValueAt(lista.get(i).getMarca(), i, 4);
            vistapr.getTablaproductos().setValueAt(lista.get(i).getModelo(), i, 5);
            vistapr.getTablaproductos().setValueAt(lista.get(i).getStock(), i, 6);
            vistapr.getTablaproductos().setValueAt(lista.get(i).getValorunitario(), i, 7);
            vistapr.getTablaproductos().setValueAt(lista.get(i).getIva(), i, 8);

        }
    }
    
    public void guardar() {
        bproductos.setCodigo(vistapr.getLabelcodigo().getText());
        bproductos.setNombre(vistapr.getTxtnombre().getText());
        bproductos.setDescripcion(vistapr.getTxtdescripcion().getText());
        bproductos.setProveedor(vistapr.getTxtproveedor().getText());
        bproductos.setMarca(vistapr.getTxtmarca().getText());
        bproductos.setModelo(vistapr.getTxtmarca().getText());
        bproductos.setStock(Integer.parseInt(vistapr.getTxtstock().getText()));
        bproductos.setValorunitario(Double.parseDouble(vistapr.getTxtvaloru().getText()));
        bproductos.setIva(vistapr.getComboiva().getSelectedItem().toString());

        ImageIcon ic = (ImageIcon) vistapr.getLabelfoto().getIcon();
        bproductos.setFoto(ic.getImage());

        if (bproductos.insertar()) {
            JOptionPane.showMessageDialog(null, "EXITO AL GUARDAR");
            lista();

        vistapr.getTxtnombre().setEnabled(false);
        vistapr.getTxtdescripcion().setEnabled(false);
        vistapr.getTxtproveedor().setEnabled(false);
        vistapr.getTxtmarca().setEnabled(false);
        vistapr.getTxtmodelo().setEnabled(false);
        vistapr.getTxtstock().setEnabled(false);
        vistapr.getTxtvaloru().setEnabled(false);
        vistapr.getComboiva().setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
            lista();

        vistapr.getTxtnombre().setEnabled(false);
        vistapr.getTxtdescripcion().setEnabled(false);
        vistapr.getTxtproveedor().setEnabled(false);
        vistapr.getTxtmarca().setEnabled(false);
        vistapr.getTxtmodelo().setEnabled(false);
        vistapr.getTxtstock().setEnabled(false);
        vistapr.getTxtvaloru().setEnabled(false);
        vistapr.getComboiva().setEnabled(false);
        }

    }
    
    public void modificar() {
        bproductos.setCodigo(vistapr.getLabelcodigo().getText());
        bproductos.setNombre(vistapr.getTxtnombre().getText());
        bproductos.setDescripcion(vistapr.getTxtdescripcion().getText());
        bproductos.setProveedor(vistapr.getTxtproveedor().getText());
        bproductos.setMarca(vistapr.getTxtmarca().getText());
        bproductos.setModelo(vistapr.getTxtmarca().getText());
        bproductos.setStock(Integer.parseInt(vistapr.getTxtstock().getText()));
        bproductos.setValorunitario(Double.parseDouble(vistapr.getTxtvaloru().getText()));
        bproductos.setIva(vistapr.getComboiva().getSelectedItem().toString());

        int resp = JOptionPane.showConfirmDialog(null, "Esta seguro de modificar");
        if (resp == 0) {
            if (bproductos.modificar(vistapr.getLabelcodigo().getText())) ;
            JOptionPane.showMessageDialog(null, "Datos Actualizados");
            lista();
            nuevo();

        vistapr.getTxtnombre().setEnabled(false);
        vistapr.getTxtdescripcion().setEnabled(false);
        vistapr.getTxtproveedor().setEnabled(false);
        vistapr.getTxtmarca().setEnabled(false);
        vistapr.getTxtmodelo().setEnabled(false);
        vistapr.getTxtstock().setEnabled(false);
        vistapr.getTxtvaloru().setEnabled(false);
        vistapr.getComboiva().setEnabled(false);

        }
    }
    public void seleccionar() {
        vistapr.getButtonguardar().setEnabled(false);
        vistapr.getButtonmodificar().setEnabled(true);
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistapr.getTablaproductos().getModel();
        String codigo = (String) modelo.getValueAt(vistapr.getTablaproductos().getSelectedRow(), 0);
        List<ProductosMD> lista = bproductos.obtenerdatos(codigo);
        bproductos.setCodigo(lista.get(0).getCodigo());
        vistapr.getLabelcodigo().setText(bproductos.getCodigo());
        bproductos.setNombre(lista.get(0).getNombre());
        vistapr.getTxtnombre().setText(bproductos.getNombre());
        bproductos.setDescripcion(lista.get(0).getDescripcion());
        vistapr.getTxtdescripcion().setText(bproductos.getDescripcion());
        bproductos.setProveedor(lista.get(0).getProveedor());
        vistapr.getTxtproveedor().setText(bproductos.getProveedor());
        bproductos.setMarca(lista.get(0).getMarca());
        vistapr.getTxtmarca().setText(bproductos.getMarca());
        bproductos.setModelo(lista.get(0).getModelo());
        vistapr.getTxtmodelo().setText(bproductos.getModelo());
        bproductos.setStock(lista.get(0).getStock());
        vistapr.getTxtstock().setText(String.valueOf(bproductos.getStock()));
        bproductos.setValorunitario(lista.get(0).getValorunitario());
        vistapr.getTxtvaloru().setText(String.valueOf(bproductos.getValorunitario()));
        bproductos.setIva(lista.get(0).getIva());
        vistapr.getComboiva().setSelectedItem(bproductos.getIva());

        Image img = lista.get(0).getFoto();
        if (img != null) {
            Image newimg = img.getScaledInstance(vistapr.getLabelfoto().getWidth(), vistapr.getLabelfoto().getHeight(), java.awt.Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(newimg);
            vistapr.getLabelfoto().setIcon(icon);
        } else {
            vistapr.getLabelfoto().setIcon(null);
        }
        

        vistapr.getTxtnombre().setEnabled(true);
        vistapr.getTxtdescripcion().setEnabled(true);
        vistapr.getTxtproveedor().setEnabled(true);
        vistapr.getTxtmarca().setEnabled(true);
        vistapr.getTxtmodelo().setEnabled(true);
        vistapr.getTxtstock().setEnabled(true);
        vistapr.getTxtvaloru().setEnabled(true);
        vistapr.getComboiva().setEnabled(true);

    }
    
    private void obtieneImagen() {
        vistapr.getLabelfoto().setIcon(null);
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = j.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                Image icono = ImageIO.read(j.getSelectedFile()).getScaledInstance(vistapr.getLabelfoto().getWidth(), vistapr.getLabelfoto().getHeight(), Image.SCALE_DEFAULT);
                vistapr.getLabelfoto().setIcon(new ImageIcon(icono));
                vistapr.getLabelfoto().updateUI();
            } catch (IOException ex) {
                Logger.getLogger(Cproductos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void eliminar() {
        bproductos.setCodigo(vistapr.getLabelcodigo().getText());
        int resp = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar el producto  " + vistapr.getLabelcodigo().getText());
        if (resp == 0) {
            if (bproductos.eliminar(vistapr.getLabelcodigo().getText())) ;
            JOptionPane.showMessageDialog(null, "Datos Actualizados");
            lista();
            nuevo();

        vistapr.getTxtnombre().setEnabled(false);
        vistapr.getTxtdescripcion().setEnabled(false);
        vistapr.getTxtproveedor().setEnabled(false);
        vistapr.getTxtmarca().setEnabled(false);
        vistapr.getTxtmodelo().setEnabled(false);
        vistapr.getTxtstock().setEnabled(false);
        vistapr.getTxtvaloru().setEnabled(false);
        vistapr.getComboiva().setEnabled(false);

        }
    }
    public void nuevo() {
        vistapr.getLabelcodigo().setText("");
        vistapr.getTxtnombre().setText("");
        vistapr.getTxtdescripcion().setText("");
        vistapr.getTxtproveedor().setText("");
        vistapr.getTxtmarca().setText("");
        vistapr.getTxtmodelo().setText("");
        vistapr.getTxtstock().setText("");
        vistapr.getTxtvaloru().setText("");
        vistapr.getComboiva().setSelectedItem("");

        vistapr.getButtonguardar().setEnabled(true);
        vistapr.getButtonmodificar().setEnabled(false);
        GenerarCodProductos();

        vistapr.getTxtnombre().setEnabled(true);
        vistapr.getTxtdescripcion().setEnabled(true);
        vistapr.getTxtproveedor().setEnabled(true);
        vistapr.getTxtmarca().setEnabled(true);
        vistapr.getTxtmodelo().setEnabled(true);
        vistapr.getTxtstock().setEnabled(true);
        vistapr.getTxtvaloru().setEnabled(true);
        vistapr.getComboiva().setEnabled(true);
    }
    
    public void Buscar() {
        if (vistapr.getTxtbuscar().getText().equals("")) {
            lista();
        } else {
            DefaultTableModel model;
            model = (DefaultTableModel) vistapr.getTablaproductos().getModel();
            java.util.List<ProductosMD> lista = bproductos.buscardatos(vistapr.getTxtbuscar().getText());
            int columnas = model.getColumnCount();
            for (int j = vistapr.getTablaproductos().getRowCount() - 1; j >= 0; j--) {
                model.removeRow(j);
            }
            for (int i = 0; i < lista.size(); i++) {
                model.addRow(new Object[columnas]);
                vistapr.getTablaproductos().setValueAt(lista.get(i).getCodigo(), i, 0);
                vistapr.getTablaproductos().setValueAt(lista.get(i).getNombre(), i, 1);
                vistapr.getTablaproductos().setValueAt(lista.get(i).getDescripcion(), i, 2);
                vistapr.getTablaproductos().setValueAt(lista.get(i).getProveedor(), i, 3);
                vistapr.getTablaproductos().setValueAt(lista.get(i).getMarca(), i, 4);
                vistapr.getTablaproductos().setValueAt(lista.get(i).getModelo(), i, 5);
                vistapr.getTablaproductos().setValueAt(lista.get(i).getStock(), i, 6);
                vistapr.getTablaproductos().setValueAt(lista.get(i).getValorunitario(), i, 7);
                vistapr.getTablaproductos().setValueAt(lista.get(i).getIva(), i, 8);

            }
        }
    }
    public void GenerarCodProductos() {
        char[] chars = "0123".toCharArray();

        int charsLength = chars.length;

        Random random = new Random();

        StringBuilder buffer = new StringBuilder();

        for (int i = 0; i < 3; i++) {

            buffer.append(chars[random.nextInt(charsLength)]);
        }

        vistapr.getLabelcodigo().setText("P0" + buffer.toString());
    }


}


