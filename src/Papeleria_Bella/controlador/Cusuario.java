package Papeleria_Bella.controlador;

import Papeleria_Bella.modelo.Conexion;
import Papeleria_Bella.modelo.*;
import Papeleria_Bella.vista.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Cusuario {

    public static Vusuario vistau;
    private UsuarioBD busuario = new UsuarioBD();
    public RolBD brol = new RolBD();
    public PersonaBD bdpersona = new PersonaBD();
    String NombreRol = "";

    public Cusuario(Vusuario vistau) {
        this.vistau = vistau;
        vistau.setVisible(true);
        vistau.setLocationRelativeTo(null);
        vistau.getComborol().setModel(busuario.ROL());
        GenerarCodUsuario();

        vistau.getButtonguardar().addActionListener(x -> guardar());
        vistau.getButtonbuscar().addActionListener(e -> buscar());
        vistau.getButtonmodificar().addActionListener(e -> modificar());
        vistau.getButtonimprimir().addActionListener(e -> imprimir_todo());
        vistau.getComborol().setModel(busuario.ROL());
        vistau.getButtonmodificar().setEnabled(false);
        vistau.getButtonguardar().setEnabled(false);
        

        vistau.getTxtcedula().setEnabled(false);
        vistau.getTxtusuario().setEnabled(false);
        vistau.getPassword().setEnabled(false);
        vistau.getComborol().setEnabled(false);
        vistau.getComboestado().setEnabled(false);
        vistau.getTablausuario().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }

        });

        vistau.getButtonbuscar().addActionListener(x -> buscar());
        vistau.getButtonnuevo().addActionListener(e -> nuevo());
        vistau.getButtoneliminar().addActionListener(e -> eliminar());
        
        

        lista();
    }

    public void lista() {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistau.getTablausuario().getModel();
        List<UsuarioMD> lista = busuario.mostrardatos();
        int columnas = modelo.getColumnCount();
        for (int j = vistau.getTablausuario().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);
        }
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            vistau.getTablausuario().setValueAt(lista.get(i).getCodigo(), i, 0);
            vistau.getTablausuario().setValueAt(lista.get(i).getCedula(), i, 1);
            vistau.getTablausuario().setValueAt(lista.get(i).getUsuario(), i, 2);
            vistau.getTablausuario().setValueAt(lista.get(i).getRol(), i, 3);
            vistau.getTablausuario().setValueAt(lista.get(i).getEstado(), i, 4);
        }
        nuevo();
    }

    public void guardar() {
        String Codrol = "";
        List<RolMD> lista = brol.buscardatospornombre(vistau.getComborol().getSelectedItem().toString());
        for (int i = 0; i < lista.size(); i++) {
            Codrol = lista.get(i).getCodigo();

        }
        busuario.setCodigo(vistau.getLabelcodigo().getText());
        busuario.setCedula(vistau.getTxtcedula().getText());
        busuario.setUsuario(vistau.getTxtusuario().getText());
        busuario.setClave(vistau.getPassword().getText());
        busuario.setRol(vistau.getComborol().getSelectedItem().toString());
        busuario.setEstado(vistau.getComboestado().getSelectedItem().toString());

        if (busuario.insertar()) {
            JOptionPane.showMessageDialog(null, "EXITO AL GUARDAR");
            lista();
        vistau.getTxtcedula().setEnabled(false);
        vistau.getTxtusuario().setEnabled(false);
        vistau.getPassword().setEnabled(false);
        vistau.getComborol().setEnabled(false);
        vistau.getComboestado().setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
            lista();
            vistau.getTxtcedula().setEnabled(false);
        vistau.getTxtusuario().setEnabled(false);
        vistau.getComborol().setEnabled(false);
        vistau.getComboestado().setEnabled(false);
        vistau.getPassword().setEnabled(false);
        }

    }

    public void modificar() {
        busuario.setCodigo(vistau.getLabelcodigo().getText());
        busuario.setCedula(vistau.getTxtcedula().getText());
        busuario.setUsuario(vistau.getTxtusuario().getText());
        String rol = (String) vistau.getComborol().getSelectedItem();
        busuario.setRol(rol);
        busuario.setEstado(vistau.getComboestado().getSelectedItem().toString());
        int resp = JOptionPane.showConfirmDialog(null, "Esta seguro de modificar");
        if (resp == 0) {
            if (busuario.modificar(vistau.getLabelcodigo().getText())) ;
            JOptionPane.showMessageDialog(null, "Datos Actualizados");
            lista();
            vistau.getTxtcedula().setEnabled(false);
        vistau.getTxtusuario().setEnabled(false);
        vistau.getComborol().setEnabled(false);
        vistau.getPassword().setEnabled(false);
        vistau.getComboestado().setEnabled(false);

        }
    }

    public void seleccionar() {
        vistau.getButtonguardar().setEnabled(false);
        vistau.getButtonmodificar().setEnabled(true);

        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistau.getTablausuario().getModel();
        String cedula = (String) modelo.getValueAt(vistau.getTablausuario().getSelectedRow(), 0);
        List<UsuarioMD> lista = busuario.obtenerdatos(cedula);
        busuario.setCodigo(lista.get(0).getCodigo());
        vistau.getLabelcodigo().setText(busuario.getCodigo());
        busuario.setCedula(lista.get(0).getCedula());
        vistau.getTxtcedula().setText(busuario.getCedula());
        busuario.setUsuario(lista.get(0).getUsuario());
        vistau.getTxtusuario().setText(busuario.getUsuario());
        busuario.setRol(lista.get(0).getRol());
        vistau.getComborol().setSelectedItem(busuario.getRol());
        busuario.setEstado(lista.get(0).getEstado());
        vistau.getComboestado().setSelectedItem(busuario.getEstado());

        vistau.getTxtcedula().setEnabled(true);
        vistau.getTxtusuario().setEnabled(true);
        vistau.getComborol().setEnabled(true);
        vistau.getPassword().setEnabled(true);
        vistau.getComboestado().setEnabled(true);
    }

    public void eliminar() {
        busuario.setCodigo(vistau.getLabelcodigo().getText());
        int resp = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar el usuario tal " + vistau.getLabelcodigo().getText());
        if (resp == 0) {
            if (busuario.eliminar(vistau.getLabelcodigo().getText())) ;
            JOptionPane.showMessageDialog(null, "Datos Actualizados");
            lista();
            vistau.getTxtcedula().setEnabled(false);
        vistau.getTxtusuario().setEnabled(false);
        vistau.getComborol().setEnabled(false);
        vistau.getPassword().setEnabled(false);
        vistau.getComboestado().setEnabled(false);

        }

    }

    public void nuevo() {
        vistau.getTxtcedula().setText("");
        vistau.getTxtusuario().setText("");
        vistau.getPassword().setText("");
        vistau.getComboestado().setSelectedItem("");
        vistau.getButtonguardar().setEnabled(true);
        vistau.getButtonmodificar().setEnabled(false);
        GenerarCodUsuario();
        vistau.getTxtcedula().setEnabled(true);
        vistau.getTxtusuario().setEnabled(true);
        vistau.getComborol().setEnabled(true);
        vistau.getPassword().setEnabled(true);
        vistau.getComboestado().setEnabled(true);
    }

    private void buscar() {
        if (vistau.getTxtcedula().getText().equals("")) {
            lista();
        } else {

            java.util.List<PersonaMD> lista = busuario.buscardatos(vistau.getTxtcedula().getText());
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getCedula().equals(vistau.getTxtcedula().getText())) {
                    vistau.getLabeldatospersona().setText(lista.get(i).getNombres() + "  " + lista.get(i).getApellidos());
                } else {
                    JOptionPane.showMessageDialog(null, "Persona no registrada", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public void GenerarCodUsuario() {
        char[] chars = "0123".toCharArray();

        int charsLength = chars.length;

        Random random = new Random();

        StringBuilder buffer = new StringBuilder();

        for (int i = 0; i < 3; i++) {

            buffer.append(chars[random.nextInt(charsLength)]);
        }

        vistau.getLabelcodigo().setText("U" + buffer.toString());
    }
 
    private void imprimir_todo(){
        Conexion conectar = new Conexion();
        try {
            JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/reportes/usuario.jasper"));
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
