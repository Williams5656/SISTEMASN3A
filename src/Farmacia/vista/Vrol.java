/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Farmacia.vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author A
 */
public class Vrol extends javax.swing.JInternalFrame {

    /**
     * Creates new form Vusuario
     */
    public Vrol() {
        initComponents();
    }

    public JButton getBtnbuscar() {
        return Btnbuscar;
    }

    public void setBtnbuscar(JButton Btnbuscar) {
        this.Btnbuscar = Btnbuscar;
    }

    public JButton getBtneliminar() {
        return Btneliminar;
    }

    public void setBtneliminar(JButton Btneliminar) {
        this.Btneliminar = Btneliminar;
    }

    public JButton getBtnguardar() {
        return Btnguardar;
    }

    public void setBtnguardar(JButton Btnguardar) {
        this.Btnguardar = Btnguardar;
    }

    public JButton getBtnmodificar() {
        return Btnmodificar;
    }

    public void setBtnmodificar(JButton Btnmodificar) {
        this.Btnmodificar = Btnmodificar;
    }

    public JButton getBtnnuevo() {
        return Btnnuevo;
    }

    public void setBtnnuevo(JButton Btnnuevo) {
        this.Btnnuevo = Btnnuevo;
    }

    public JComboBox<String> getCombo_estado() {
        return combo_estado;
    }

    public void setCombo_estado(JComboBox<String> combo_estado) {
        this.combo_estado = combo_estado;
    }

    public JComboBox<String> getCombo_nombres() {
        return combo_nombres;
    }

    public void setCombo_nombres(JComboBox<String> combo_nombres) {
        this.combo_nombres = combo_nombres;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel15() {
        return jLabel15;
    }

    public void setjLabel15(JLabel jLabel15) {
        this.jLabel15 = jLabel15;
    }

    public JLabel getjLabel16() {
        return jLabel16;
    }

    public void setjLabel16(JLabel jLabel16) {
        this.jLabel16 = jLabel16;
    }

    public JLabel getjLabel17() {
        return jLabel17;
    }

    public void setjLabel17(JLabel jLabel17) {
        this.jLabel17 = jLabel17;
    }

    public JLabel getjLabel18() {
        return jLabel18;
    }

    public void setjLabel18(JLabel jLabel18) {
        this.jLabel18 = jLabel18;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
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

    public JLabel getjLabel8() {
        return jLabel8;
    }

    public void setjLabel8(JLabel jLabel8) {
        this.jLabel8 = jLabel8;
    }

    public JLabel getjLabel9() {
        return jLabel9;
    }

    public void setjLabel9(JLabel jLabel9) {
        this.jLabel9 = jLabel9;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JSeparator getjSeparator8() {
        return jSeparator8;
    }

    public void setjSeparator8(JSeparator jSeparator8) {
        this.jSeparator8 = jSeparator8;
    }

    public JTable getTabla_roles() {
        return tabla_roles;
    }

    public void setTabla_roles(JTable tabla_roles) {
        this.tabla_roles = tabla_roles;
    }

    public JTextField getTxtBuscar() {
        return txtBuscar;
    }

    public void setTxtBuscar(JTextField txtBuscar) {
        this.txtBuscar = txtBuscar;
    }

    public JTextField getTxt_codigo() {
        return txt_codigo;
    }

    public void setTxt_codigo(JTextField txt_codigo) {
        this.txt_codigo = txt_codigo;
    }

    public JTextField getTxt_descripcion() {
        return txt_descripcion;
    }

    public void setTxt_descripcion(JTextField txt_descripcion) {
        this.txt_descripcion = txt_descripcion;
    }

   
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel17 = new javax.swing.JLabel();
        combo_estado = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txt_descripcion = new javax.swing.JTextField();
        combo_nombres = new javax.swing.JComboBox<>();
        txt_codigo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        Btnnuevo = new javax.swing.JButton();
        Btnguardar = new javax.swing.JButton();
        Btnmodificar = new javax.swing.JButton();
        Btneliminar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        Btnbuscar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_roles = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("**REGISTRO DE ROLES**");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setText("*Nuevo*");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, -1, -1));

        combo_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar....", "Activo", "Inactivo" }));
        getContentPane().add(combo_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 120, 20));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("ESTADO DE LA PERSONA:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));
        getContentPane().add(txt_descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 150, 20));

        combo_nombres.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        getContentPane().add(combo_nombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 210, 20));
        getContentPane().add(txt_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 210, 20));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("DESCRIBIR EL CARGO:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Nombres:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Codigo:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel15.setText("*Guardar*");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, -1, -1));

        jLabel16.setText("*Modificar*");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, -1, -1));

        jLabel18.setText("*Eliminar*");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 320, -1, -1));

        Btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Farmacia_imagenes/nuevo.png"))); // NOI18N
        getContentPane().add(Btnnuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, -1, -1));

        Btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Farmacia_imagenes/guardar.png"))); // NOI18N
        getContentPane().add(Btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, -1, -1));

        Btnmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Farmacia_imagenes/modificar.png"))); // NOI18N
        getContentPane().add(Btnmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, -1, -1));

        Btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Farmacia_imagenes/cambiar estado eliminar.jpeg"))); // NOI18N
        getContentPane().add(Btneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 270, -1, -1));

        jLabel2.setText("**Buscar**");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 90, -1, -1));

        jSeparator8.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator8.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, 250, 10));

        Btnbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Farmacia_imagenes/buscar (2).png"))); // NOI18N
        getContentPane().add(Btnbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 50, -1, -1));

        txtBuscar.setBorder(null);
        txtBuscar.setOpaque(false);
        getContentPane().add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 60, 250, 20));

        tabla_roles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla_roles);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, 510, 200));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Farmacia_imagenes/istockphoto-526058997-1024x1024.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 1050, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btnbuscar;
    private javax.swing.JButton Btneliminar;
    private javax.swing.JButton Btnguardar;
    private javax.swing.JButton Btnmodificar;
    private javax.swing.JButton Btnnuevo;
    private javax.swing.JComboBox<String> combo_estado;
    private javax.swing.JComboBox<String> combo_nombres;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTable tabla_roles;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_descripcion;
    // End of variables declaration//GEN-END:variables
}
