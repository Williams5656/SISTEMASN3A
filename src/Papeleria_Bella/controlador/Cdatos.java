package Papeleria_Bella.controlador;

import Papeleria_Bella.vista.*;
import Papeleria_Bella.modelo.*;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Cdatos {

    public static Vdatos vistad;

    private DatosBD bdatos = new DatosBD();

    public Cdatos(Vdatos vistad) {
        this.vistad = vistad;
        vistad.setVisible(true);
        vistad.setLocationRelativeTo(null);
        GenerarCodDatos();
        lista();
        vistad.getButtonguardar().addActionListener(x -> guardar());
        vistad.getButtonmodificar().addActionListener(e -> modificar());
        vistad.getTabladatos().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }

        });

        vistad.getButtonnuevo().addActionListener(e -> nuevo());
        vistad.getButtoneliminar().addActionListener(e -> eliminar());
        vistad.getButtonguardar().setEnabled(false);
        vistad.getButtonmodificar().setEnabled(false);
        
        vistad.getTxtruc().setEnabled(false);
        vistad.getTxtnombrec().setEnabled(false);
        vistad.getTxtrazons().setEnabled(false);
        vistad.getTxtmatrizp().setEnabled(false);
        vistad.getTxtcelular().setEnabled(false);
        vistad.getComboestado().setEnabled(false);
    }

    public void lista() {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vistad.getTabladatos().getModel();
        List<DatosMD> lista = bdatos.mostrardatos();
        int columnas = modelo.getColumnCount();
        for (int j = vistad.getTabladatos().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);
        }
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            vistad.getTabladatos().setValueAt(lista.get(i).getCodigo(), i, 0);
            vistad.getTabladatos().setValueAt(lista.get(i).getRuc(), i, 1);
            vistad.getTabladatos().setValueAt(lista.get(i).getNombrec(), i, 2);
            vistad.getTabladatos().setValueAt(lista.get(i).getRazons(), i, 3);
            vistad.getTabladatos().setValueAt(lista.get(i).getMatrizp(), i, 4);
            vistad.getTabladatos().setValueAt(lista.get(i).getCelular(), i, 5);
            vistad.getTabladatos().setValueAt(lista.get(i).getEstado(), i, 6);

        }
    }

    public void guardar() {
        bdatos.setCodigo(vistad.getLabelcodigo().getText());
        bdatos.setRuc(vistad.getTxtruc().getText());
        bdatos.setNombrec(vistad.getTxtnombrec().getText());
        bdatos.setRazons(vistad.getTxtrazons().getText());
        bdatos.setMatrizp(vistad.getTxtmatrizp().getText());
        bdatos.setCelular(vistad.getTxtcelular().getText());
        bdatos.setEstado(vistad.getComboestado().getSelectedItem().toString());

        int resp = JOptionPane.showConfirmDialog(null, "Esta seguro de guardar");
        if (resp == 0) {
            if (bdatos.modificarestadoalguardar(vistad.getComboestado().getSelectedItem().toString())) ;
            JOptionPane.showMessageDialog(null, "Datos Actualizados");
            lista();
            nuevo();
        }
        if (bdatos.insertar()) {
            JOptionPane.showMessageDialog(null, "EXITO AL GUARDAR");
            lista();
            
        vistad.getTxtruc().setEnabled(false);
        vistad.getTxtnombrec().setEnabled(false);
        vistad.getTxtrazons().setEnabled(false);
        vistad.getTxtmatrizp().setEnabled(false);
        vistad.getTxtcelular().setEnabled(false);
        vistad.getComboestado().setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
            lista();
        vistad.getTxtruc().setEnabled(false);
        vistad.getTxtnombrec().setEnabled(false);
        vistad.getTxtrazons().setEnabled(false);
        vistad.getTxtmatrizp().setEnabled(false);
        vistad.getTxtcelular().setEnabled(false);
        vistad.getComboestado().setEnabled(false);
        }
       

    }

    public void modificar() {
        bdatos.setCodigo(vistad.getLabelcodigo().getText());
        bdatos.setRuc(vistad.getTxtruc().getText());
        bdatos.setNombrec(vistad.getTxtnombrec().getText());
        bdatos.setRazons(vistad.getTxtrazons().getText());
        bdatos.setMatrizp(vistad.getTxtmatrizp().getText());
        bdatos.setCelular(vistad.getTxtcelular().getText());
        bdatos.setEstado(vistad.getComboestado().getSelectedItem().toString());

//        int resp1 = JOptionPane.showConfirmDialog(null, "Esta seguro de modificar el estado");
//        if (resp1 == 0) {
//            if (bdatos.modificarestado(vistad.getComboestado().getSelectedItem().toString(),vistad.getLabelcodigo().getText())) ;
//            JOptionPane.showMessageDialog(null, "Datos Actualizados");
//            lista();
//            nuevo();
//        }
        int resp = JOptionPane.showConfirmDialog(null, "Esta seguro de modificar");
        if (resp == 0) {
            if (bdatos.modificar(vistad.getLabelcodigo().getText())) ;
            JOptionPane.showMessageDialog(null, "Datos Actualizados");
            lista();
            nuevo();
        vistad.getTxtruc().setEnabled(false);
        vistad.getTxtnombrec().setEnabled(false);
        vistad.getTxtrazons().setEnabled(false);
        vistad.getTxtmatrizp().setEnabled(false);
        vistad.getTxtcelular().setEnabled(false);
        vistad.getComboestado().setEnabled(false);
  
        }
    }

    public void seleccionar() {
        vistad.getButtonguardar().setEnabled(false);
        vistad.getButtonmodificar().setEnabled(true);
        DefaultTableModel modelo;

        modelo = (DefaultTableModel) vistad.getTabladatos().getModel();
        String codigo = (String) modelo.getValueAt(vistad.getTabladatos().getSelectedRow(), 0);
        List<DatosMD> lista = bdatos.obtenerdatos(codigo);
        bdatos.setCodigo(lista.get(0).getCodigo());
        vistad.getLabelcodigo().setText(bdatos.getCodigo());
        bdatos.setRuc(lista.get(0).getRuc());
        vistad.getTxtruc().setText(bdatos.getRuc());
        bdatos.setNombrec(lista.get(0).getNombrec());
        vistad.getTxtnombrec().setText(bdatos.getNombrec());
        bdatos.setRazons(lista.get(0).getRazons());
        vistad.getTxtrazons().setText(bdatos.getRazons());
        bdatos.setMatrizp(lista.get(0).getMatrizp());
        vistad.getTxtmatrizp().setText(bdatos.getMatrizp());
        bdatos.setCelular(lista.get(0).getCelular());
        vistad.getTxtcelular().setText(bdatos.getCelular());
        bdatos.setEstado(lista.get(0).getEstado());
        vistad.getComboestado().setSelectedItem(bdatos.getEstado());
        
        vistad.getTxtruc().setEnabled(true);
        vistad.getTxtnombrec().setEnabled(true);
        vistad.getTxtrazons().setEnabled(true);
        vistad.getTxtmatrizp().setEnabled(true);
        vistad.getTxtcelular().setEnabled(true);
        vistad.getComboestado().setEnabled(true);

    }

    public void eliminar() {
        bdatos.setCodigo(vistad.getLabelcodigo().getText());
        int resp = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar el usuario  " + vistad.getLabelcodigo().getText());
        if (resp == 0) {
            if (bdatos.eliminar(vistad.getLabelcodigo().getText())) ;
            JOptionPane.showMessageDialog(null, "Datos Actualizados");
            lista();
            nuevo();
        vistad.getTxtruc().setEnabled(false);
        vistad.getTxtnombrec().setEnabled(false);
        vistad.getTxtrazons().setEnabled(false);
        vistad.getTxtmatrizp().setEnabled(false);
        vistad.getTxtcelular().setEnabled(false);
        vistad.getComboestado().setEnabled(false);

        }
    }

    public void nuevo() {
        vistad.getLabelcodigo().setText("");
        vistad.getTxtruc().setText("");
        vistad.getTxtnombrec().setText("");
        vistad.getTxtrazons().setText("");
        vistad.getTxtmatrizp().setText("");
        vistad.getTxtcelular().setText("");
        vistad.getComboestado().setSelectedItem("");
        vistad.getButtonguardar().setEnabled(true);
        vistad.getButtonmodificar().setEnabled(false);
        GenerarCodDatos();
    }

    public void GenerarCodDatos() {
        char[] chars = "0123".toCharArray();

        int charsLength = chars.length;

        Random random = new Random();

        StringBuilder buffer = new StringBuilder();

        for (int i = 0; i < 3; i++) {

            buffer.append(chars[random.nextInt(charsLength)]);
        }

        vistad.getLabelcodigo().setText("D" + buffer.toString());
    }
}
