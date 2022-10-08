package Papeleria_Bella.controlador;

import Papeleria_Bella.vista.*;
import Papeleria_Bella.modelo.*;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Cpersona {

    public static Vpersona1 vista;

    private PersonaBD bpersona = new PersonaBD();
    SimpleDateFormat fe = new SimpleDateFormat("yyyy-MM-dd");

    public Cpersona(Vpersona1 vista) {
        this.vista = vista;
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        lista();
        validar();
        try {
            vista.getButtonguardar().addActionListener(x -> guardar());
            vista.getButtonmodificar().addActionListener(e -> modificar());
            vista.getButtoncargar().addActionListener(e -> obtieneImagen());
            vista.getButtonbuscar().addActionListener(e -> Buscar());
            vista.getButtonimprimir().addActionListener(e -> imprimir_todo());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }

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

        vista.getTxtcedula().setEnabled(false);
        vista.getTxtnombres().setEnabled(false);
        vista.getTxtapellidos().setEnabled(false);
        vista.getTxttelefono().setEnabled(false);
        vista.getTxtdireccion().setEnabled(false);
        vista.getTxtemail().setEnabled(false);
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
        nuevo();
    }

    public void guardar() {

        bpersona.setCedula(vista.getTxtcedula().getText());
        bpersona.setNombres(vista.getTxtnombres().getText());
        bpersona.setApellidos(vista.getTxtapellidos().getText());
        bpersona.setTelefono(vista.getTxttelefono().getText());
        bpersona.setDireccion(vista.getTxtdireccion().getText());
        bpersona.setEmail(vista.getTxtemail().getText());
        bpersona.setFecha_nacimiento(fe.format(vista.getTxtFecha().getDate()));

        ImageIcon ic = (ImageIcon) vista.getLabelfoto().getIcon();
        bpersona.setFoto(ic.getImage());

        if (bpersona.insertar()) {
            JOptionPane.showMessageDialog(null, "EXITO AL GUARDAR");
            lista();
            vista.getTxtcedula().setEnabled(false);
            vista.getTxtnombres().setEnabled(false);
            vista.getTxtapellidos().setEnabled(false);
            vista.getTxttelefono().setEnabled(false);
            vista.getTxtdireccion().setEnabled(false);
            vista.getTxtemail().setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
            lista();

            vista.getTxtcedula().setEnabled(false);
            vista.getTxtnombres().setEnabled(false);
            vista.getTxtapellidos().setEnabled(false);
            vista.getTxttelefono().setEnabled(false);
            vista.getTxtdireccion().setEnabled(false);
            vista.getTxtemail().setEnabled(false);
        }
    }

    public void modificar() {
        bpersona.setCedula(vista.getTxtcedula().getText());
        bpersona.setNombres(vista.getTxtnombres().getText());
        bpersona.setApellidos(vista.getTxtapellidos().getText());
        bpersona.setTelefono(vista.getTxttelefono().getText());
        bpersona.setDireccion(vista.getTxtdireccion().getText());
        bpersona.setEmail(vista.getTxtemail().getText());
        bpersona.setFecha_nacimiento(fe.format(vista.getTxtFecha().getDate()));

        int resp = JOptionPane.showConfirmDialog(null, "Esta seguro de modificar");
        if (resp == 0) {
            if (bpersona.modificar(vista.getTxtcedula().getText())) ;
            JOptionPane.showMessageDialog(null, "Datos Actualizados");
            lista();
            nuevo();
            vista.getTxtcedula().setEnabled(false);
            vista.getTxtnombres().setEnabled(false);
            vista.getTxtapellidos().setEnabled(false);
            vista.getTxttelefono().setEnabled(false);
            vista.getTxtdireccion().setEnabled(false);
            vista.getTxtemail().setEnabled(false);
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
        bpersona.setFecha_nacimiento(lista.get(0).getFecha_nacimiento());

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = null;
        try {
            fecha = format.parse(bpersona.getFecha_nacimiento());
            vista.getTxtFecha().setDate(fecha);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No existe fecha de nacimiento en esta persona", "AVISO", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, e);
        }

        Image img = lista.get(0).getFoto();
        if (img != null) {
            Image newimg = img.getScaledInstance(vista.getLabelfoto().getWidth(), vista.getLabelfoto().getHeight(), java.awt.Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(newimg);
            vista.getLabelfoto().setIcon(icon);
        } else {
            vista.getLabelfoto().setIcon(null);
        }

        vista.getTxtcedula().setEnabled(true);
        vista.getTxtnombres().setEnabled(true);
        vista.getTxtapellidos().setEnabled(true);
        vista.getTxttelefono().setEnabled(true);
        vista.getTxtdireccion().setEnabled(true);
        vista.getTxtemail().setEnabled(true);
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

    public void eliminar() {
        bpersona.setCedula(vista.getTxtcedula().getText());
        int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar la persona?" + vista.getTxtcedula().getText());
        if (resp == 0) {
            if (bpersona.eliminar(vista.getTxtcedula().getText())) ;
            JOptionPane.showMessageDialog(null, "Datos Actualizados");
            lista();
            nuevo();
            vista.getTxtcedula().setEnabled(false);
            vista.getTxtnombres().setEnabled(false);
            vista.getTxtapellidos().setEnabled(false);
            vista.getTxttelefono().setEnabled(false);
            vista.getTxtdireccion().setEnabled(false);
            vista.getTxtemail().setEnabled(false);
        }
    }

    public void nuevo() {
        vista.getTxtcedula().setText("");
        vista.getTxtnombres().setText("");
        vista.getTxtapellidos().setText("");
        vista.getTxttelefono().setText("");
        vista.getTxtdireccion().setText("");
        vista.getTxtemail().setText("");
        vista.getButtonguardar().setEnabled(true);
        vista.getButtonmodificar().setEnabled(false);
        vista.getTxtcedula().setEnabled(true);
        vista.getTxtnombres().setEnabled(true);
        vista.getTxtapellidos().setEnabled(true);
        vista.getTxttelefono().setEnabled(true);
        vista.getTxtdireccion().setEnabled(true);
        vista.getTxtemail().setEnabled(true);
    }

    public void Buscar() {
        if (vista.getTxtbuscar().getText().equals("")) {
            lista();
        } else {
            DefaultTableModel model;
            model = (DefaultTableModel) vista.getTablapersona().getModel();
            java.util.List<PersonaMD> lista = bpersona.buscardatos(vista.getTxtbuscar().getText());
            int columnas = model.getColumnCount();
            for (int j = vista.getTablapersona().getRowCount() - 1; j >= 0; j--) {
                model.removeRow(j);
            }
            for (int i = 0; i < lista.size(); i++) {
                model.addRow(new Object[columnas]);
                vista.getTablapersona().setValueAt(lista.get(i).getCedula(), i, 0);
                vista.getTablapersona().setValueAt(lista.get(i).getNombres(), i, 1);
                vista.getTablapersona().setValueAt(lista.get(i).getApellidos(), i, 2);
                vista.getTablapersona().setValueAt(lista.get(i).getTelefono(), i, 3);
                vista.getTablapersona().setValueAt(lista.get(i).getDireccion(), i, 4);
                vista.getTablapersona().setValueAt(lista.get(i).getEmail(), i, 5);

            }
        }
    }

    private void imprimir_todo() {
        Conexion conectar = new Conexion();
        try {
            JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/reportes/persona.jasper"));
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("logo", "images/pap.png");
            JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(jas, map, conectar.getCon());

            JasperViewer jv = new JasperViewer(jp, false);
            jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jv.setVisible(true);
        } catch (JRException e) {
            System.out.println("No hay registros en la tabla." + e.getMessage());
            Logger.getLogger(Cpersona.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void validar() {
        Validacion.Letras.solo_letras(vista.getTxtnombres());
        Validacion.Numeros.solo_numeros(vista.getTxtcedula());
        Validacion.Numeros.solo_numeros(vista.getTxttelefono());
        Validacion.Letras.solo_letras(vista.getTxtapellidos());
    }

}
