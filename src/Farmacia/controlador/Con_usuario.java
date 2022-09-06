/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Farmacia.controlador;

//import Farmacia.modelo.UsuarioBD;
//import Farmacia.modelo.UsuarioMD;
//import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.swing.JOptionPane;
//import javax.swing.JTextField;
//import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
//import javax.swing.table.DefaultTableModel;

/**
 *
 * @author A
 */
//public class Con_usuario {
//     private final Vusuario vista;
//    private UsuarioBD bdusuario = new UsuarioBD();
//    private ArrayList<Con_Usuario> listausuario = new ArrayList<>();
//
//    public Con_Usuario(Vusuario vista) {
//        this.vista = vista;
//        vista.setVisible(true);
//        validaciones();
//        desactivarbotones();
//        vista.getBtnnuevo().addActionListener(e -> nuevo());
//        vista.getBtnguardar().addActionListener(e -> guardar());
//        vista.getBtnmodificar().addActionListener(e -> modificar());
//        vista.getBtneliminar().addActionListener(e -> eliminar());
////        vista.getBtnimprimir().addActionListener(e -> imprimir());
//
//        vista.getTablausuario().addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                seleccionar();
//            }
//        });
//        lista();
//    }
//
//    public void buscarname() {
//        UsuarioBD bdu = new UsuarioBD();
//        List<UsuarioMD> listau = bdu.mostrardatos();
//        int n = 0;
//        for (int i = 0; i < listau.size(); i++) {
//            if (vista.getTxtnombre().getText().equals(listau.get(i).getNombreUsuario())) {
//                n = 1;
//            } else {
//            }
//        }
//    }
//
//    public void nuevo() {
//        activarbotones();
//        vista.getBtnguardar().setEnabled(true);
//        vista.getBtnmodificar().setEnabled(false);
//        vista.getTxtnombre().setText("");
//        vista.getTxtusuario().setText("");
//        vista.getTxtcontrasena().setText("");
//        vista.getComboestado().setSelectedIndex(0);
//    }
//
//    public void desactivarbotones() {
//        vista.getBtnguardar().setEnabled(false);
//        vista.getBtnnuevo().setEnabled(true);
//        vista.getBtnimprimir().setEnabled(true);
//        vista.getBtneliminar().setEnabled(false);
//        vista.getBtnmodificar().setEnabled(false);
//        vista.getComboestado().setEnabled(false);
//        vista.getTxtnombre().setEnabled(false);
//        vista.getTxtusuario().setEnabled(false);
//        vista.getTxtcontrasena().setEnabled(false);
//    }
//
//    public void activarbotones() {
//        vista.getBtnguardar().setEnabled(true);
//        vista.getBtnimprimir().setEnabled(true);
//        vista.getBtneliminar().setEnabled(true);
//        vista.getComboestado().setEnabled(true);
//        vista.getTxtnombre().setEnabled(true);
//        vista.getTxtusuario().setEnabled(true);
//        vista.getTxtcontrasena().setEnabled(true);
//    }
//
//    public void guardar() {
//
//        String nom = (String) vista.getTxtnombre().getText();
//        String usu = (String) vista.getTxtusuario().getText();
//
//        String view = "";
//        String view2 = "";
//        view = bdusuario.verificarNombre(nom);
//        view2 = bdusuario.verificarUsuario(usu);
//        if (view != "") {
//            JOptionPane.showMessageDialog(null, "Nombre ya existe!", "\n Verifique", 0);
//            vista.getTxtnombre().setText("");
//        }
//        if (view2 != "") {
//            JOptionPane.showMessageDialog(null, "Usuario ya existe!", "\n Verifique", 0);
//            vista.getTxtusuario().setText("");
//        }
//        if (view == "" && view2 == "") {
//
//            bdusuario.setNombre_u(vista.getTxtnombre().getText());
//            bdusuario.setUsuario_u(vista.getTxtusuario().getText());
//            bdusuario.setContrasena_u((vista.getTxtcontrasena().getText()));
//            String estado = (String) vista.getComboestado().getSelectedItem();
//            bdusuario.setEstado_u(estado);
//            if (vista.getTxtnombre().getText().equals("") || vista.getTxtusuario().getText().equals("") || vista.getTxtcontrasena().getText().equals("")) {
//                JOptionPane.showMessageDialog(null, "Campos vacios");
//                nuevo();
//            } else {
//                if (bdusuario.insertar()) {
//                    JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
//                    lista();
//                    nuevo();
//                } else {
//                    JOptionPane.showMessageDialog(null, "Error al Guardar");
//                }
//            }
//        }
//
//    }
//
//    public void cambiarestado() {
//        String estado = (String) vista.getComboestado().getSelectedItem();
//        int resp2 = JOptionPane.showConfirmDialog(null, "Esta seguro de cambiar estado");
//        if (resp2 == 0) {
//            if (estado.equals("Activo")) {
//                if (bdusuario.desactivar(vista.getTxtnombre().getText())) {
//                    JOptionPane.showMessageDialog(null, "Desactivado");
//                    lista();
//                    nuevo();
//                } else {
//                    JOptionPane.showMessageDialog(null, "Error al desactivar");
//                }
//            }
//            if (estado.equals("Inactivo")) {
//                if (bdusuario.activar(vista.getTxtnombre().getText())) {
//                    JOptionPane.showMessageDialog(null, "Activado");
//                    lista();
//                    nuevo();
//                } else {
//                    JOptionPane.showMessageDialog(null, "Error al activar");
//                }
//            }
//        }
//    }
//
//    public void modificar() {
//        bdusuario.setNombre_u(vista.getTxtnombre().getText());
//        bdusuario.setUsuario_u(vista.getTxtnombre().getText());
//        bdusuario.setContrasena_u((vista.getTxtcontrasena().getText()));
//        String estado = (String) vista.getComboestado().getSelectedItem();
//        bdusuario.setEstado(estado);
//
//        int resp2 = JOptionPane.showConfirmDialog(null, "Desea modificar");
//        if (resp2 == 0) {
//            if (bdusuario.modificar(vista.getTxtnombre().getText())) {
//                JOptionPane.showMessageDialog(null, "Datos actualizados");
//                lista();
//                nuevo();
//            } else {
//                JOptionPane.showMessageDialog(null, "Error al modificar");
//            }
//        }
//    }
//
//    private void eliminar() {
//        if (bdusuario.Eliminar(vista.getTxtnombre().getText())) {
//            JOptionPane.showMessageDialog(null, "DATOS ELIMINADOS");
//            lista();
//            nuevo();
//        } else {
//            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR");
//        }
//    }
//
//    public void seleccionar() {
//        vista.getBtnguardar().setEnabled(false);
//        vista.getBtnnuevo().setEnabled(true);
//        vista.getBtneliminar().setEnabled(true);
//        vista.getBtnmodificar().setEnabled(true);
//        vista.getBtnimprimir().setEnabled(true);
//        DefaultTableModel modelo;
//        modelo = (DefaultTableModel) vista.getTablausuario().getModel();
//        String nombre = (String) modelo.getValueAt(vista.getTablausuario().getSelectedRow(), 0);
//        System.out.println(nombre);
//        List<UsuarioMD> lista = bdusuario.obtenerDatos(nombre);
//        bdusuario.setNombre_u(lista.get(0).getNombre_u());
//        bdusuario.setUsuario_u(lista.get(0).getUsuario_u());
//        bdusuario.setContrasena_u(lista.get(0).getContrasena_u());
//        bdusuario.setEstado_u(lista.get(0).getEstado_u());
//
//        vista.getTxtnombre().setText(bdusuario.getNombre_u());
//        vista.getTxtusuario().setText(bdusuario.getUsuario_u());
//        vista.getTxtcontrasena().setText(bdusuario.getContrasena_u());
//        vista.getComboestado().setSelectedItem(bdusuario.getEstado_u());
//        vista.getTxtnombre().setEnabled(false);
//        vista.getTxtusuario().setEnabled(false);
//        vista.getTxtcontrasena().setEditable(true);
//        vista.getComboestado().setEditable(true);
//
//    }
//
//    public void lista() {
//        DefaultTableModel modelo;
//        modelo = (DefaultTableModel) vista.getTablausuario().getModel();
//        List<UsuarioMD> lista = bdusuario.mostrardatos();
//        int columnas = modelo.getColumnCount();
//        for (int j = vista.getTablausuario().getRowCount() - 1; j >= 0; j--) {
//            modelo.removeRow(j);
//        }
//        for (int i = 0; i < lista.size(); i++) {
//            modelo.addRow(new Object[columnas]);
//            vista.getTablausuario().setValueAt(lista.get(i).getCedula(), i, 0);
//            vista.getTablausuario().setValueAt(lista.get(i).getNombreUsuario(), i, 1);
//            vista.getTablausuario().setValueAt(lista.get(i).getContrasenia(), i, 2);
//            vista.getTablausuario().setValueAt(lista.get(i).getRol(), i, 3);
//             vista.getTablausuario().setValueAt(lista.get(i).getEstado(), i, 4);
//        }
//    }
//
////    public void imprimir() {
////        Conect con = new Conect();
////        try {
////            JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/RepUsuarios.jasper"));
////            JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(jas, null, con.getCon());
////            JasperViewer jv = new JasperViewer(jp, false);
////            jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
////            jv.setVisible(true);
////        } catch (JRException e) {
////            System.out.println("no se pudo encontrar registros" + e.getMessage());
////            Logger.getLogger(Con_Usuario.class.getName()).log(Level.SEVERE, null, e);
////        }
////
////    }
//
//    private void only_letras(JTextField t) {
//        t.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyTyped(KeyEvent e) {
//                if ((e.getKeyChar() < 'a' | e.getKeyChar() > 'z') & (e.getKeyChar() < 'A' | e.getKeyChar() > 'Z') & (e.getKeyChar() != 32) | (vista.getTxtnombre().getText().length() >= 15)) {
//                    e.consume();
//                }
//            }
//        }
//        );
//    }

   
//}
