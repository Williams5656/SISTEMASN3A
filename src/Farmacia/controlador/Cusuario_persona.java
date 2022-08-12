/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Farmacia.controlador;

import Farmacia.modelo.Usuario_PersonaBD;
import Farmacia.modelo.Usuario_PersonaMD;
import Farmacia.vista.Vusuario_Vpersona;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author A
 */
public class Cusuario_persona {
    private final Vusuario_Vpersona vista;
    private Usuario_PersonaBD bdusuario = new Usuario_PersonaBD();
    private ArrayList<Cusuario_persona> listausuario = new ArrayList<>();

    public Cusuario_persona(Vusuario_Vpersona vista) {
        this.vista = vista;
        vista.setVisible(true);
//        validaciones();
        desactivarbotones();
        vista.getBtn_nuevo().addActionListener(e -> nuevo());
        vista.getBtnguardar().addActionListener(e -> guardar());
        vista.getBtn_modificar().addActionListener(e -> modificar());
        vista.getBtneliminar().addActionListener(e -> eliminar());
//        vista.getBtnimprimir().addActionListener(e -> imprimir());

        vista.getTablaUsuario().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
            }
        });
        lista();
    }

    public void buscarname() {
        Usuario_PersonaBD bdu = new Usuario_PersonaBD();
        List<Usuario_PersonaMD> listau = bdu.mostrardatos();
        int n = 0;
        for (int i = 0; i < listau.size(); i++) {
            if (vista.getTxtnombre1().getText().equals(listau.get(i).getNombres())) {
                n = 1;
            } else {
            }
        }
    }

    public void nuevo() {
        activarbotones();
        vista.getBtnguardar().setEnabled(true);
        vista.getBtn_modificar().setEnabled(false);
        vista.getTxtnombre1().setText("");
        vista.getTxtnombre_u().setText("");
        vista.getTxtcedula1().setText("");
        vista.getTxtclave_u().setText("");
        vista.getCombo_estado().setSelectedIndex(0);
        vista.getCombo_rol().setSelectedIndex(0);
    }

    public void desactivarbotones() {
        vista.getBtnguardar().setEnabled(false);
        vista.getBtn_nuevo().setEnabled(true);
//        vista.getBtnimprimir().setEnabled(true);
        vista.getBtneliminar().setEnabled(false);
        vista.getBtn_modificar().setEnabled(false);
        vista.getCombo_estado().setEnabled(false);
        vista.getCombo_rol().setEnabled(false);
        vista.getTxtnombre1().setEnabled(false);
        vista.getTxtnombre_u().setEnabled(false);
        vista.getTxtcedula1().setEnabled(false);
        vista.getTxtclave_u().setEnabled(false);
        
    }

    public void activarbotones() {
        vista.getBtnguardar().setEnabled(true);
//        vista.getBtnimprimir().setEnabled(true);
        vista.getBtneliminar().setEnabled(true);
        vista.getCombo_estado().setEnabled(true);
        vista.getCombo_rol().setEnabled(true);
        vista.getTxtnombre1().setEnabled(true);
        vista.getTxtnombre_u().setEnabled(true);
        vista.getTxtcedula1().setEnabled(true);
        vista.getTxtclave_u().setEnabled(true);
    }

    public void guardar() {

        String nom = (String) vista.getTxtnombre1().getText();
        String usu = (String) vista.getTxtnombre_u().getText();

        String view = "";
        String view2 = "";
////        view = bdusuario.verificarNombre1(nom);
////        view2 = bdusuario.verificarNombre_u(usu);
        if (view != "") {
            JOptionPane.showMessageDialog(null, "Nombre ya existe!", "\n Verifique", 0);
            vista.getTxtnombre1().setText("");
        }
        if (view2 != "") {
            JOptionPane.showMessageDialog(null, "Usuario ya existe!", "\n Verifique", 0);
            vista.getTxtnombre_u().setText("");
        }
        if (view == "" && view2 == "") {

            bdusuario.setNombres(vista.getTxtnombre1().getText());
            bdusuario.setNombreU(vista.getTxtnombre_u().getText());
            bdusuario.setClave((vista.getTxtclave_u().getText()));
            String rol = (String) vista.getCombo_rol().getSelectedItem();
            String estado = (String) vista.getCombo_estado().getSelectedItem();
            bdusuario.setEstado(estado);
            if (vista.getTxtnombre1().getText().equals("") || vista.getTxtnombre_u().getText().equals("") || vista.getTxtclave_u().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Campos vacios");
                nuevo();
            } else {
                if (bdusuario.insertar()) {
                    JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
                    lista();
                    nuevo();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Guardar");
                }
            }
        }

    }

    public void cambiarestado() {
        String estado = (String) vista.getCombo_estado().getSelectedItem();
        int resp2 = JOptionPane.showConfirmDialog(null, "Esta seguro de cambiar estado");
        if (resp2 == 0) {
            if (estado.equals("Activo")) {
                if (bdusuario.desactivar(vista.getTxtnombre1().getText())) {
                    JOptionPane.showMessageDialog(null, "Desactivado");
                    lista();
                    nuevo();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al desactivar");
                }
            }
            if (estado.equals("Inactivo")) {
                if (bdusuario.activar(vista.getTxtnombre1().getText())) {
                    JOptionPane.showMessageDialog(null, "Activado");
                    lista();
                    nuevo();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al activar");
                }
            }
        }
    }

    public void modificar() {
        bdusuario.setNombres(vista.getTxtnombre1().getText());
        bdusuario.setNombreU(vista.getTxtnombre_u().getText());
        bdusuario.setClave((vista.getTxtclave_u().getText()));
        bdusuario.setCedula((vista.getTxtcedula1().getText()));
        String rol = (String) vista.getCombo_rol().getSelectedItem();
        String estado = (String) vista.getCombo_estado().getSelectedItem();
        
        bdusuario.setEstado(estado);

        int resp2 = JOptionPane.showConfirmDialog(null, "Desea modificar");
        if (resp2 == 0) {
            if (bdusuario.modificar(vista.getTxtnombre1().getText())) {
                JOptionPane.showMessageDialog(null, "Datos actualizados");
                lista();
                nuevo();
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");
            }
        }
    }

    private void eliminar() {
        if (bdusuario.Eliminar(vista.getTxtnombre1().getText())) {
            JOptionPane.showMessageDialog(null, "DATOS ELIMINADOS");
            lista();
            nuevo();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR");
        }
    }

    public void seleccionar() {
        vista.getBtnguardar().setEnabled(false);
        vista.getBtn_nuevo().setEnabled(true);
        vista.getBtneliminar().setEnabled(true);
        vista.getBtn_modificar().setEnabled(true);
//        vista.getBtnimprimir().setEnabled(true);
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTablaUsuario().getModel();
        String nombre = (String) modelo.getValueAt(vista.getTablaUsuario().getSelectedRow(), 0);
        System.out.println(nombre);
        List<Usuario_PersonaMD> lista = bdusuario.obtenerDatos(nombre);
        bdusuario.setNombres(lista.get(0).getNombres());
        bdusuario.setNombreU(lista.get(0).getNombreU());
        bdusuario.setClave(lista.get(0).getClave());
        bdusuario.setEstado(lista.get(0).getEstado());

        vista.getTxtnombre1().setText(bdusuario.getNombres());
        vista.getTxtnombre_u().setText(bdusuario.getNombreU());
        vista.getTxtclave_u().setText(bdusuario.getClave());
        vista.getCombo_rol().setSelectedItem(bdusuario.getRol());
        vista.getCombo_estado().setSelectedItem(bdusuario.getEstado());
        vista.getTxtnombre1().setEnabled(false);
        vista.getTxtnombre_u().setEnabled(false);
        vista.getTxtclave_u().setEditable(true);
        vista.getCombo_rol().setEditable(true);
        vista.getCombo_estado().setEditable(true);

    }

    public void lista() {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) vista.getTablaUsuario().getModel();
        List<Usuario_PersonaMD> lista = bdusuario.mostrardatos();
        int columnas = modelo.getColumnCount();
        for (int j = vista.getTablaUsuario().getRowCount() - 1; j >= 0; j--) {
            modelo.removeRow(j);
        }
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[columnas]);
            vista.getTablaUsuario().setValueAt(lista.get(i).getCedula(), i, 0);
            vista.getTablaUsuario().setValueAt(lista.get(i).getNombres(), i, 1);
            vista.getTablaUsuario().setValueAt(lista.get(i).getNombreU(), i, 2);
            vista.getTablaUsuario().setValueAt(lista.get(i).getClave(), i, 3);
            vista.getTablaUsuario().setValueAt(lista.get(i).getFechaNacimiento(), i, 4);
            vista.getTablaUsuario().setValueAt(lista.get(i).getEstado(), i, 5);
            vista.getTablaUsuario().setValueAt(lista.get(i).getRol(), i, 6);
        }
    }

//    public void imprimir() {
//        Conect con = new Conect();
//        try {
//            JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/RepUsuarios.jasper"));
//            JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(jas, null, con.getCon());
//            JasperViewer jv = new JasperViewer(jp, false);
//            jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//            jv.setVisible(true);
//        } catch (JRException e) {
//            System.out.println("no se pudo encontrar registros" + e.getMessage());
//            Logger.getLogger(Con_Usuario.class.getName()).log(Level.SEVERE, null, e);
//        }
//
//    }

    private void only_letras(JTextField t) {
        t.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if ((e.getKeyChar() < 'a' | e.getKeyChar() > 'z') & (e.getKeyChar() < 'A' | e.getKeyChar() > 'Z') & (e.getKeyChar() != 32) | (vista.getTxtnombre1().getText().length() >= 15)) {
                    e.consume();
                }
            }
        }
        );
    }

}

