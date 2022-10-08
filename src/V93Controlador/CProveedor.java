package V93Controlador;

import V93Modelo.ProveedorBD;
import V93Modelo.ProveedorMb;
import V93Vista.VistaProveedor;
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

public class CProveedor {

    public static VistaProveedor VistaProv;

    private ProveedorBD bdproveedor = new ProveedorBD();
    Eventos evts = new Eventos();

    public CProveedor(VistaProveedor VistaProv) {
        this.VistaProv = VistaProv;
        VistaProv.setVisible(true);
        VistaProv.setLocationRelativeTo(null);
        lista();
        VistaProv.getBtnGuardarProveedor().addActionListener(x -> guardar());
        VistaProv.getBtnModificarProveedor().addActionListener(e -> modificar());
        VistaProv.getBtnBuscarProveedor().addActionListener(e -> buscar());
        VistaProv.getBtnEliminarProveedor().addActionListener(e -> eliminar());
        VistaProv.getBtnNuevoProveedor().addActionListener(e -> nuevo());
        VistaProv.getBtnImprimirProveedor().addActionListener(e -> ImprimirProveedor());
        
        VistaProv.getTableProveedor().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }

        });

        VistaProv.getTxtRucProveedor().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRucProveedorKeyTyped(evt);
            }

        });

        VistaProv.getTxtNombreProveedor().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreProveedorKeyTyped(evt);
            }

        });

        VistaProv.getTxtCelularProveedor().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCelularProveedorKeyTyped(evt);
            }

        });

        VistaProv.getTxtDireccionProveedor().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionProveedorKeyTyped(evt);
            }

        });

        VistaProv.getBtnNuevoProveedor().addActionListener(e -> nuevo());
        VistaProv.getBtnEliminarProveedor().addActionListener(e -> eliminar());
        VistaProv.getBtnGuardarProveedor().setEnabled(false);
        VistaProv.getBtnModificarProveedor().setEnabled(false);
        
    }

    private void txtRucProveedorKeyTyped(java.awt.event.KeyEvent evt) {
        evts.numberKeyPress(evt);
    }

    private void txtNombreProveedorKeyTyped(java.awt.event.KeyEvent evt) {
        evts.textKeyPress(evt);
    }

    private void txtCelularProveedorKeyTyped(java.awt.event.KeyEvent evt) {
        evts.numberKeyPress(evt);
    }

    private void txtDireccionProveedorKeyTyped(java.awt.event.KeyEvent evt) {
        evts.textKeyPress(evt);
    }

    public void lista() {

        DefaultTableModel modelo;
        modelo = (DefaultTableModel) VistaProv.getTableProveedor().getModel();
        List<ProveedorMb> lista = bdproveedor.mostrardatos();
        int columnas = modelo.getColumnCount();

        for (int j = VistaProv.getTableProveedor().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);

        }
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            VistaProv.getTableProveedor().setValueAt(lista.get(i).getRuc(), i, 0);
            VistaProv.getTableProveedor().setValueAt(lista.get(i).getNombre(), i, 1);
            VistaProv.getTableProveedor().setValueAt(lista.get(i).getCelular(), i, 2);
            VistaProv.getTableProveedor().setValueAt(lista.get(i).getDireccion(), i, 3);
            VistaProv.getTableProveedor().setValueAt(lista.get(i).getRazon(), i, 4);

        }
    }
    
    private void ImprimirProveedor() {
        Conectar con = new Conectar();
        try {

            JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/reportes/proveedor.jasper"));

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
        bdproveedor.setRuc(VistaProv.getTxtRucProveedor().getText());
        bdproveedor.setNombre(VistaProv.getTxtNombreProveedor().getText());
        bdproveedor.setCelular(VistaProv.getTxtCelularProveedor().getText());
        bdproveedor.setDireccion(VistaProv.getTxtDireccionProveedor().getText());
        bdproveedor.setRazon(VistaProv.getTxtRazonSocialProveedor().getText());

        if (bdproveedor.insertar()) {
            JOptionPane.showMessageDialog(null, "EXITO AL GUARDAR");
            lista();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
            lista();
        }

    }

    /*private void obtieneImagen() {
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
     */
    public void buscar() {
        if (VistaProv.getTxtBuscarProveedor().getText().equals("")) {
            lista();
        } else {
            DefaultTableModel modelo;
            modelo = (DefaultTableModel) VistaProv.getTableProveedor().getModel();
            List<ProveedorMb> lista = bdproveedor.obtenerdatos(VistaProv.getTxtBuscarProveedor().getText());
            int columnas = modelo.getColumnCount();

            for (int j = VistaProv.getTableProveedor().getRowCount() - 1; j >= 0; j--) {
                modelo.removeRow(j);
            }
            for (int i = 0; i < lista.size(); i++) {
                modelo.addRow(new Object[columnas]);
                VistaProv.getTableProveedor().setValueAt(lista.get(i).getRuc(), i, 0);
                VistaProv.getTableProveedor().setValueAt(lista.get(i).getNombre(), i, 1);
                VistaProv.getTableProveedor().setValueAt(lista.get(i).getCelular(), i, 2);
                VistaProv.getTableProveedor().setValueAt(lista.get(i).getDireccion(), i, 3);
                VistaProv.getTableProveedor().setValueAt(lista.get(i).getRazon(), i, 4);

            }
        }

    }

    public void modificar() {
        bdproveedor.setRuc(VistaProv.getTxtRucProveedor().getText());
        bdproveedor.setNombre(VistaProv.getTxtNombreProveedor().getText());
        bdproveedor.setCelular(VistaProv.getTxtCelularProveedor().getText());
        bdproveedor.setDireccion(VistaProv.getTxtDireccionProveedor().getText());
        bdproveedor.setRazon(VistaProv.getTxtRazonSocialProveedor().getText());

        int rest = JOptionPane.showConfirmDialog(null, "Esta Seguro de Modificar");
        if (rest == 0) {
            if (bdproveedor.modificar(VistaProv.getTxtRucProveedor().getText())) ;
            JOptionPane.showMessageDialog(null, "Datos Modificados");
            lista();
            nuevo();
        }

    }

    public void seleccionar() {
        VistaProv.getBtnGuardarProveedor().setEnabled(false);
        VistaProv.getBtnModificarProveedor().setEnabled(true);
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) VistaProv.getTableProveedor().getModel();
        String ruc = (String) modelo.getValueAt(VistaProv.getTableProveedor().getSelectedRow(), 0);
        List<ProveedorMb> lista = bdproveedor.obtenerdatos(ruc);
        bdproveedor.setRuc(lista.get(0).getRuc());
        VistaProv.getTxtRucProveedor().setText(bdproveedor.getRuc());
        bdproveedor.setNombre(lista.get(0).getNombre());
        VistaProv.getTxtNombreProveedor().setText(bdproveedor.getNombre());
        bdproveedor.setCelular(lista.get(0).getCelular());
        VistaProv.getTxtCelularProveedor().setText(bdproveedor.getCelular());
        bdproveedor.setDireccion(lista.get(0).getDireccion());
        VistaProv.getTxtDireccionProveedor().setText(bdproveedor.getDireccion());
        bdproveedor.setRazon(lista.get(0).getRazon());
        VistaProv.getTxtRazonSocialProveedor().setText(bdproveedor.getRazon());

    }

    public void eliminar() {
        bdproveedor.setRuc(VistaProv.getTxtRucProveedor().getText());
        int rest = JOptionPane.showConfirmDialog(null, "Esta Seguro de Eliminar");
        if (rest == 0) {
            if (bdproveedor.eliminar(VistaProv.getTxtRucProveedor().getText()));
            JOptionPane.showMessageDialog(null, "Proveedor Eliminado");
            lista();
            nuevo();
        }

    }

    public void nuevo() {
        VistaProv.getTxtRucProveedor().setText("");
        VistaProv.getTxtNombreProveedor().setText("");
        VistaProv.getTxtCelularProveedor().setText("");
        VistaProv.getTxtDireccionProveedor().setText("");
        VistaProv.getTxtRazonSocialProveedor().setText("");
        VistaProv.getTxtBuscarProveedor().setText("");
        VistaProv.getBtnGuardarProveedor().setEnabled(true);
        VistaProv.getBtnModificarProveedor().setEnabled(false);
    }
}
