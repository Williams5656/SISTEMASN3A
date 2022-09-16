package controlador;

import java.awt.Color;
import modelo.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import modelo.RolMD;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import vista.V_Rol;

public class C_Rol {

    public static ArrayList<RolBD> listarol = new ArrayList();
    public static V_Rol vistarol;
    public RolBD bdrol = new RolBD();
    boolean mostrar = false;

    public C_Rol(V_Rol vistarol) {
        this.vistarol = vistarol;
        vistarol.setVisible(true);
        listarol();
        GenerarCodRol();
        vistarol.getBtnguardarp().addActionListener(e -> guardar());
        vistarol.getBtnmodificar().addActionListener(e -> modificar());
        vistarol.getBtnimprimir().addActionListener(e -> Imprimir());
        vistarol.getTableRol().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }

        });
        vistarol.getBtnnuevo().addActionListener(e -> nuevo());
        vistarol.getBtneliminar().addActionListener(e -> eliminar());

        vistarol.getBtnguardarp().setEnabled(false);
        vistarol.getBtnmodificar().setEnabled(false);
        vistarol.getCheckBoxEstado().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBoxEstadoActionPerformed(evt);
            }
        });
        vistarol.getBtnBuscarRol().addActionListener(x -> Buscar());
        vistarol.getTxtBuscarRol().addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscarRolFocusGained(evt);
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscarRolFocusLost(evt);
            }
        });
    }

    public void nuevo() {
        vistarol.getTxtnombre().setText("");
        vistarol.getTxtDescripcion().setText("");
        vistarol.getBtnguardarp().setEnabled(true);
        vistarol.getBtnmodificar().setEnabled(true);
        GenerarCodRol();
    }

    public void listarol() {

        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistarol.getTableRol().getModel();
        List<RolMD> lista = bdrol.mostrardatos();
        int columnas = modelo.getColumnCount();

        for (int j = vistarol.getTableRol().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);

        }
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            vistarol.getTableRol().setValueAt(lista.get(i).getCodigo(), i, 0);
            vistarol.getTableRol().setValueAt(lista.get(i).getNombre(), i, 1);
            vistarol.getTableRol().setValueAt(lista.get(i).getDescripcion(), i, 2);
            vistarol.getTableRol().setValueAt(lista.get(i).getEstado(), i, 3);

        }
    }

    public void guardar() {
        List<RolMD> listarol = bdrol.mostrardatos();
        String nombrerol = "";
        for (int i = 0; i < listarol.size(); i++) {
            nombrerol = listarol.get(i).getNombre();

        }
        if (nombrerol.equalsIgnoreCase(vistarol.getTxtnombre().getText())) {
            JOptionPane.showMessageDialog(null, "Rol ya existente en los registros", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            bdrol.setCodigo(vistarol.getLabelCodRol().getText());
            bdrol.setNombre(vistarol.getTxtnombre().getText());
            bdrol.setDescripcion(vistarol.getTxtDescripcion().getText());
            bdrol.setEstado(vistarol.getLabelEstado().getText());
            if (bdrol.insertar()) {
                JOptionPane.showMessageDialog(null, "GUARDADO CORRECTAMENTE");
                listarol();
            } else {
                JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
            }
        }

    }

    public void modificar() {
        bdrol.setCodigo(vistarol.getLabelCodRol().getText());
        bdrol.setNombre(vistarol.getTxtnombre().getText());
        bdrol.setDescripcion(vistarol.getTxtDescripcion().getText());
        bdrol.setEstado(vistarol.getLabelEstado().getText());
        int resp = JOptionPane.showConfirmDialog(null, "ESTA SEGURO DE MODIFICAR LOS DATOS");
        if (resp == 0) {
            if (bdrol.modificar(vistarol.getLabelCodRol().getText())) {
                JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS CORRECTAMENTE");
                listarol();
                nuevo();
                vistarol.getBtnmodificar().setEnabled(false);
            }
        }
    }

    public void seleccionar() {
        vistarol.getBtnguardarp().setEnabled(false);
        vistarol.getBtnmodificar().setEnabled(true);
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistarol.getTableRol().getModel();
        String codigo = (String) modelo.getValueAt(vistarol.getTableRol().getSelectedRow(), 0);
        List<RolMD> lista = bdrol.obtenerdatos(codigo);
        bdrol.setCodigo(lista.get(0).getCodigo());
        vistarol.getLabelCodRol().setText(bdrol.getCodigo());
        bdrol.setNombre(lista.get(0).getNombre());
        vistarol.getTxtnombre().setText(bdrol.getNombre());
        bdrol.setDescripcion(lista.get(0).getDescripcion());
        vistarol.getTxtDescripcion().setText(bdrol.getDescripcion());
        bdrol.setEstado(lista.get(0).getEstado());
        vistarol.getLabelEstado().setText(bdrol.getEstado());

    }

    public void eliminar() {

        bdrol.setCodigo(vistarol.getLabelCodRol().getText());
        int resp = JOptionPane.showConfirmDialog(null, "ESTA SEGURO DE ELIMINAR LOS DATOS" + vistarol.getLabelCodRol().getText());
        if (resp == 0) {
            if (bdrol.eliminar(vistarol.getLabelCodRol().getText())) {
                JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS");
                listarol();
                nuevo();
            }
        }

    }

    private void CheckBoxEstadoActionPerformed(java.awt.event.ActionEvent evt) {
        if (mostrar) {
            vistarol.getLabelEstado().setText("Activo");
            mostrar = false;

        } else {
            vistarol.getLabelEstado().setText("Inactivo");
            mostrar = true;
        }
    }

    public void GenerarCodRol() {
        char[] chars = "0123".toCharArray();

        int charsLength = chars.length;

        Random random = new Random();

        StringBuilder buffer = new StringBuilder();

        for (int i = 0; i < 3; i++) {

            buffer.append(chars[random.nextInt(charsLength)]);
        }

        vistarol.getLabelCodRol().setText("RL0" + buffer.toString());
    }

    public void Buscar() {
        if (vistarol.getTxtBuscarRol().getText().equals("")) {
            listarol();
        } else {
            DefaultTableModel model;
            model = (DefaultTableModel) vistarol.getTableRol().getModel();
            java.util.List<RolMD> listarol = bdrol.buscardatospornombre(vistarol.getTxtBuscarRol().getText());
            int columnas = model.getColumnCount();
            for (int j = vistarol.getTableRol().getRowCount() - 1; j >= 0; j--) {
                model.removeRow(j);
            }
            for (int i = 0; i < listarol.size(); i++) {
                model.addRow(new Object[columnas]);
                vistarol.getTableRol().setValueAt(listarol.get(i).getCodigo(), i, 0);
                vistarol.getTableRol().setValueAt(listarol.get(i).getNombre(), i, 1);
                vistarol.getTableRol().setValueAt(listarol.get(i).getDescripcion(), i, 2);
                vistarol.getTableRol().setValueAt(listarol.get(i).getEstado(), i, 3);
            }
        }
    }

    private void txtBuscarRolFocusGained(java.awt.event.FocusEvent evt) {
        vistarol.getTxtBuscarRol().setText("");
        vistarol.getTxtBuscarRol().setForeground(Color.BLACK);
    }

    private void txtBuscarRolFocusLost(java.awt.event.FocusEvent evt) {
        if (vistarol.getTxtBuscarRol().getText().isEmpty()) {
            vistarol.getTxtBuscarRol().setText("Ingrese el nombre del rol");
            vistarol.getTxtBuscarRol().setForeground(Color.GRAY);
        }
    }

    private void Imprimir() {
        int opcion = Integer.parseInt(JOptionPane.showInputDialog("Elija una opcion para imprimir: \n 1. Imprimir Todo \n 2. Imprimir con un parametro \n 3.Imprimir con dos parametros"));
        try {
            switch (opcion) {
                case 1:
                    ImprimirTodo();
                    break;
                case 2:
                    ImprimirunParametro();
                    break;
                case 3:
                    ImprimirDosParametros();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "No elijio una opcion correcta", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException | NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Ingrese solo números", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void ImprimirTodo() {
        Conectar con = new Conectar();
        try {
            JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/rol.jasper"));

            Map<String, Object> map = new HashMap<String, Object>();
            JasperPrint ja = (JasperPrint) JasperFillManager.fillReport(jas, map, con.getCon());
            JasperViewer jv = new JasperViewer(ja, false);
            jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jv.setVisible(true);
        } catch (JRException e) {
            System.out.println("no se pudo encontrar registros" + e.getMessage());
            Logger.getLogger(C_Rol.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void ImprimirunParametro() {
        Conectar con = new Conectar();
        try {
            String codigo = JOptionPane.showInputDialog("Escriba el codigo del rol");
            JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/rol1.jasper"));

            Map<String, Object> map = new HashMap<String, Object>();

            map.put("codigor", codigo);

            JasperPrint ja = (JasperPrint) JasperFillManager.fillReport(jas, map, con.getCon());
            JasperViewer jv = new JasperViewer(ja, false);
            jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jv.setVisible(true);
        } catch (JRException e) {
            System.out.println("no se pudo encontrar registros" + e.getMessage());
            Logger.getLogger(C_Rol.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void ImprimirDosParametros() {
        Conectar con = new Conectar();
        try {
            String codigo = JOptionPane.showInputDialog("Escriba el codigo del rol");
            String nombre = JOptionPane.showInputDialog("Escriba el nombre del rol");
            JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/auto3.jasper"));

            Map<String, Object> map = new HashMap<String, Object>();

            map.put("codigor", codigo);
            map.put("nombrer", nombre);

            JasperPrint ja = (JasperPrint) JasperFillManager.fillReport(jas, map, con.getCon());
            JasperViewer jv = new JasperViewer(ja, false);
            jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jv.setVisible(true);
        } catch (JRException e) {
            System.out.println("no se pudo encontrar registros" + e.getMessage());
            Logger.getLogger(C_Rol.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
