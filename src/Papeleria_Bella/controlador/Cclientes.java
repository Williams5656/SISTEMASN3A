package Papeleria_Bella.controlador;

import Papeleria_Bella.modelo.ClientesBD;
import Papeleria_Bella.modelo.ClientesMD;
import Papeleria_Bella.modelo.Conexion;
import Papeleria_Bella.modelo.PersonaBD;
import Papeleria_Bella.modelo.PersonaMD;
import Papeleria_Bella.vista.Vclientes;
import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Cclientes {

    public static Vclientes vistacliente;

    ClientesBD bcliente = new ClientesBD();
    PersonaBD bdpersona = new PersonaBD();

    public Cclientes(Vclientes vistacliente) {
        this.vistacliente = vistacliente;
        vistacliente.setVisible(true);
        vistacliente.setLocationRelativeTo(null);
        vistacliente.getTxtPorcentajeDiscapacidad().setVisible(false);
        vistacliente.getLabelPorcentajeDiscapacidad().setVisible(false);
        vistacliente.getLabelTINombres1().setVisible(false);
        vistacliente.getLabelnombres().setVisible(false);
        vistacliente.getLabeltiCelular().setVisible(false);
        vistacliente.getLabelcelular().setVisible(false);
        CodigoCliente();
        lista();
        vistacliente.getButtonbuscar().addActionListener(x -> BuscarPersona());
        vistacliente.getButtonguardar().addActionListener(x -> guardar());
        vistacliente.getButtoneliminar().addActionListener(x -> eliminar());
        vistacliente.getButtonmodificar().addActionListener(x -> modificar());
        vistacliente.getButtonnuevo().addActionListener(x -> nuevo());
        vistacliente.getButtonimprimir().addActionListener(e -> imprimir_todo());
        vistacliente.getTxtBuscar().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscar();
            }
        });
        vistacliente.getTablacliente().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }

        });
        vistacliente.getCmbDiscapacidad().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDiscapacidadActionPerformed(evt);
            }
        });
    }

    public void lista() {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistacliente.getTablacliente().getModel();
        List<ClientesMD> lista = bcliente.mostrardatos();
        int columnas = modelo.getColumnCount();
        for (int j = vistacliente.getTablacliente().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);
        }
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            vistacliente.getTablacliente().setValueAt(lista.get(i).getCodigo(), i, 0);
            vistacliente.getTablacliente().setValueAt(lista.get(i).getCedula(), i, 1);
            vistacliente.getTablacliente().setValueAt(lista.get(i).getNombres(), i, 2);
            vistacliente.getTablacliente().setValueAt(lista.get(i).getCelular(), i, 3);
            vistacliente.getTablacliente().setValueAt(lista.get(i).getEstado(), i, 4);
            vistacliente.getTablacliente().setValueAt(lista.get(i).getDiscapacidad(), i, 5);
            vistacliente.getTablacliente().setValueAt(lista.get(i).getPorcentaje_discapacidad(), i, 6);

        }
    }

    private void cmbDiscapacidadActionPerformed(java.awt.event.ActionEvent evt) {
        String estado = vistacliente.getCmbDiscapacidad().getSelectedItem().toString();
        System.out.println(estado);
        if (estado.equalsIgnoreCase("SI")) {
            vistacliente.getTxtPorcentajeDiscapacidad().setVisible(true);
            vistacliente.getLabelPorcentajeDiscapacidad().setVisible(true);
        } else {
            vistacliente.getTxtPorcentajeDiscapacidad().setVisible(false);
            vistacliente.getLabelPorcentajeDiscapacidad().setVisible(false);
        }
    }

    public void guardar() {
        bcliente.setCodigo(vistacliente.getLabelcodigo2().getText());
        bcliente.setCedula(vistacliente.getTxtcedula().getText());
        bcliente.setNombres(vistacliente.getLabelnombres().getText());
        bcliente.setCelular(vistacliente.getLabelcelular().getText());
        bcliente.setEstado(vistacliente.getCmbEstado().getSelectedItem().toString());
        bcliente.setDiscapacidad(vistacliente.getCmbDiscapacidad().getSelectedItem().toString());
        bcliente.setPorcentaje_discapacidad(vistacliente.getTxtPorcentajeDiscapacidad().getValue().toString() + "%");

        if (bcliente.insertar()) {
            JOptionPane.showMessageDialog(null, "EXITO AL GUARDAR");
            lista();

        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
            lista();
        }

    }

    public void modificar() {
        bcliente.setCodigo(vistacliente.getLabelcodigo2().getText());
        bcliente.setCedula(vistacliente.getTxtcedula().getText());
        bcliente.setNombres(vistacliente.getLabelnombres().getText());
        bcliente.setCelular(vistacliente.getLabelcelular().getText());
        bcliente.setEstado(vistacliente.getCmbEstado().getSelectedItem().toString());
        bcliente.setDiscapacidad(vistacliente.getCmbDiscapacidad().getSelectedItem().toString());
        bcliente.setPorcentaje_discapacidad(vistacliente.getTxtPorcentajeDiscapacidad().getValue().toString() + "%");
        int resp = JOptionPane.showConfirmDialog(null, "Esta seguro de modificar");
        if (resp == 0) {
            if (bcliente.modificar(vistacliente.getLabelcodigo2().getText())) ;
            JOptionPane.showMessageDialog(null, "Datos Actualizados");
            lista();
            nuevo();

        }
    }

    public void seleccionar() {
        vistacliente.getButtonguardar().setEnabled(false);
        vistacliente.getButtonmodificar().setEnabled(true);

        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistacliente.getTablacliente().getModel();
        String codigo = (String) modelo.getValueAt(vistacliente.getTablacliente().getSelectedRow(), 0);
        List<ClientesMD> lista = bcliente.obtenerdatos(codigo);
        bcliente.setCodigo(lista.get(0).getCodigo());
        vistacliente.getLabelcodigo2().setText(bcliente.getCodigo());
        bcliente.setCedula(lista.get(0).getCedula());
        vistacliente.getTxtcedula().setText(bcliente.getCedula());
        bcliente.setNombres(lista.get(0).getNombres());
        vistacliente.getLabelnombres().setText(bcliente.getNombres());
        bcliente.setCelular(lista.get(0).getCelular());
        vistacliente.getLabelcelular().setText(bcliente.getCelular());
        bcliente.setEstado(lista.get(0).getEstado());
        vistacliente.getCmbEstado().setSelectedItem(bcliente.getEstado());
        bcliente.setDiscapacidad(lista.get(0).getDiscapacidad());
        vistacliente.getCmbDiscapacidad().setSelectedItem(bcliente.getDiscapacidad());
        bcliente.setPorcentaje_discapacidad(lista.get(0).getPorcentaje_discapacidad());
        String porcentaje = bcliente.getPorcentaje_discapacidad();
        porcentaje = porcentaje.replace("%", "");
        System.out.println(porcentaje);
        vistacliente.getTxtPorcentajeDiscapacidad().setValue(Double.parseDouble(porcentaje));

    }

    public void eliminar() {
        bcliente.setCodigo(vistacliente.getLabelcodigo2().getText());
        int resp = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar el usuario  " + vistacliente.getLabelcodigo2().getText());
        if (resp == 0) {
            if (bcliente.eliminar(vistacliente.getLabelcodigo2().getText())) ;
            JOptionPane.showMessageDialog(null, "Datos Actualizados");
            lista();
            nuevo();

        }
    }

    public void BuscarPersona() {
        if (vistacliente.getTxtcedula().equals("")) {
            JOptionPane.showMessageDialog(null, "Nó deje el campo vacio");
        } else {
            vistacliente.getLabelTINombres1().setVisible(true);
            vistacliente.getLabelnombres().setVisible(true);
            vistacliente.getLabelcelular().setVisible(true);
            vistacliente.getLabeltiCelular().setVisible(true);
            List<PersonaMD> listapersona = bdpersona.buscardatos(vistacliente.getTxtcedula().getText());
            for (int i = 0; i < listapersona.size(); i++) {
                vistacliente.getLabelnombres().setText(listapersona.get(i).getNombres() + " " + listapersona.get(i).getApellidos());
                vistacliente.getLabelcelular().setText(listapersona.get(i).getTelefono());
            }
        }
    }

    public void nuevo() {
        vistacliente.getTxtcedula().setText("");
        vistacliente.getLabelnombres().setText("");
        vistacliente.getLabelcelular().setText("");
        vistacliente.getTxtPorcentajeDiscapacidad().setValue(0);
        vistacliente.getButtonguardar().setEnabled(true);
        vistacliente.getButtonmodificar().setEnabled(false);
        vistacliente.getLabelTINombres1().setVisible(false);
        vistacliente.getLabelnombres().setVisible(false);
        vistacliente.getLabeltiCelular().setVisible(false);
        vistacliente.getLabelcelular().setVisible(false);
        CodigoCliente();
    }

    public void CodigoCliente() {
        char[] chars = "0123".toCharArray();

        int charsLength = chars.length;

        Random random = new Random();

        StringBuilder buffer = new StringBuilder();

        for (int i = 0; i < 3; i++) {

            buffer.append(chars[random.nextInt(charsLength)]);
        }

        vistacliente.getLabelcodigo2().setText("R0" + buffer.toString());
    }

    private void buscar() {
        if (vistacliente.getTxtBuscar().getText().isEmpty()) {
            lista();
        } else {
            DefaultTableModel model;
            model = (DefaultTableModel) vistacliente.getTablacliente().getModel();
            java.util.List<ClientesMD> lista = bcliente.buscardatos(vistacliente.getTxtBuscar().getText());
            int columnas = model.getColumnCount();
            for (int j = vistacliente.getTablacliente().getRowCount() - 1; j >= 0; j--) {
                model.removeRow(j);
            }
            for (int i = 0; i < lista.size(); i++) {
                model.addRow(new Object[columnas]);
                vistacliente.getTablacliente().setValueAt(lista.get(i).getCodigo(), i, 0);
                vistacliente.getTablacliente().setValueAt(lista.get(i).getCedula(), i, 1);
                vistacliente.getTablacliente().setValueAt(lista.get(i).getNombres(), i, 2);
                vistacliente.getTablacliente().setValueAt(lista.get(i).getCelular(), i, 3);
                vistacliente.getTablacliente().setValueAt(lista.get(i).getEstado(), i, 4);
                vistacliente.getTablacliente().setValueAt(lista.get(i).getDiscapacidad(), i, 5);
                vistacliente.getTablacliente().setValueAt(lista.get(i).getPorcentaje_discapacidad(), i, 6);
            }
        }

    }
    private void imprimir_todo() {
        Conexion conectar = new Conexion();
        try {
            JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/reportes/cliente.jasper"));
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
}
