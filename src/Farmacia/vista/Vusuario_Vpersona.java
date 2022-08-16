/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Farmacia.vista;

import com.toedter.calendar.JCalendar;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import Farmacia.*;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
/**
 *
 * @author A
 */
public class Vusuario_Vpersona extends javax.swing.JInternalFrame {
 SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    /**
     * Creates new form Vusuario
     */
    public Vusuario_Vpersona() {
        initComponents();      
    }

    public SimpleDateFormat getFormato() {
        return formato;
    }

    public void setFormato(SimpleDateFormat formato) {
        this.formato = formato;
    }

    public JButton getBtn_modificar() {
        return btn_modificar;
    }

    public void setBtn_modificar(JButton btn_modificar) {
        this.btn_modificar = btn_modificar;
    }

    public JButton getBtn_nuevo() {
        return btn_nuevo;
    }

    public void setBtn_nuevo(JButton btn_nuevo) {
        this.btn_nuevo = btn_nuevo;
    }

    public JButton getBtneliminar() {
        return btneliminar;
    }

    public void setBtneliminar(JButton btneliminar) {
        this.btneliminar = btneliminar;
    }

    public JButton getBtnguardar() {
        return btnguardar;
    }

    public void setBtnguardar(JButton btnguardar) {
        this.btnguardar = btnguardar;
    }

    public JComboBox<String> getCombo_estado() {
        return combo_estado;
    }

    public void setCombo_estado(JComboBox<String> combo_estado) {
        this.combo_estado = combo_estado;
    }

    public JComboBox<String> getCombo_rol() {
        return combo_rol;
    }

    public void setCombo_rol(JComboBox<String> combo_rol) {
        this.combo_rol = combo_rol;
    }

    public JCalendar getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(JCalendar fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public JLabel getImagen() {
        return imagen;
    }

    public void setImagen(JLabel imagen) {
        this.imagen = imagen;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public void setjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

    public JLabel getjLabel6() {
        return jLabel6;
    }

    public void setjLabel6(JLabel jLabel6) {
        this.jLabel6 = jLabel6;
    }

    public JLabel getjLabel7() {
        return jLabel7;
    }

    public void setjLabel7(JLabel jLabel7) {
        this.jLabel7 = jLabel7;
    }

    public JLabel getjLabel8() {
        return jLabel8;
    }

    public void setjLabel8(JLabel jLabel8) {
        this.jLabel8 = jLabel8;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JTable getTablaUsuario() {
        return tablaUsuario;
    }

    public void setTablaUsuario(JTable tablaUsuario) {
        this.tablaUsuario = tablaUsuario;
    }

    public JTextField getTxtcedula1() {
        return txtcedula1;
    }

    public void setTxtcedula1(JTextField txtcedula1) {
        this.txtcedula1 = txtcedula1;
    }

    public JTextField getTxtclave_u() {
        return txtclave_u;
    }

    public void setTxtclave_u(JTextField txtclave_u) {
        this.txtclave_u = txtclave_u;
    }

    public JTextField getTxtnombre1() {
        return txtnombre1;
    }

    public void setTxtnombre1(JTextField txtnombre1) {
        this.txtnombre1 = txtnombre1;
    }

    public JTextField getTxtnombre_u() {
        return txtnombre_u;
    }

    public void setTxtnombre_u(JTextField txtnombre_u) {
        this.txtnombre_u = txtnombre_u;
    }

   
   

//    public Image getIconImage() {
//        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Farmacia.inicio.imagenes/7457f4f8d72fde5.jpg"));
//        return retValue;
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtcedula1 = new javax.swing.JTextField();
        txtnombre1 = new javax.swing.JTextField();
        txtnombre_u = new javax.swing.JTextField();
        txtclave_u = new javax.swing.JTextField();
        combo_rol = new javax.swing.JComboBox<>();
        btn_nuevo = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuario = new javax.swing.JTable();
        combo_estado = new javax.swing.JComboBox<>();
        btnguardar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        fecha_nacimiento = new com.toedter.calendar.JCalendar();
        imagen = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("--USUARIO,PERSONA--");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cedula:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 24, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Fecha_nacimiento:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Rol:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nombre Usuario:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Clave:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, -1, -1));
        getContentPane().add(txtcedula1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 130, -1));
        getContentPane().add(txtnombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 130, -1));
        getContentPane().add(txtnombre_u, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, 120, -1));
        getContentPane().add(txtclave_u, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, 120, -1));

        combo_rol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE", "Cliente", "Farmaceutico", "Proveedor" }));
        getContentPane().add(combo_rol, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, 120, -1));

        btn_nuevo.setText("NUEVO");
        getContentPane().add(btn_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 380, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Estado:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 170, -1, -1));

        tablaUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaUsuario);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 600, 230));

        combo_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        getContentPane().add(combo_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 170, 100, -1));

        btnguardar.setText("GUARDAR");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, -1, -1));

        btn_modificar.setText("MODIFICAR");
        getContentPane().add(btn_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 380, -1, -1));

        btneliminar.setText("ELIMINAR");
        getContentPane().add(btneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 380, -1, -1));
        getContentPane().add(fecha_nacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 380, 230));

        imagen.setText("**FOTO**");
        getContentPane().add(imagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 200, 130, 140));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Farmacia_imagenes/7457f4f8d72fde5.jpg"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnguardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JComboBox<String> combo_estado;
    private javax.swing.JComboBox<String> combo_rol;
    private com.toedter.calendar.JCalendar fecha_nacimiento;
    private javax.swing.JLabel imagen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaUsuario;
    private javax.swing.JTextField txtcedula1;
    private javax.swing.JTextField txtclave_u;
    private javax.swing.JTextField txtnombre1;
    private javax.swing.JTextField txtnombre_u;
    // End of variables declaration//GEN-END:variables
}
